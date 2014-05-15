/*
 * This software is the confidential and proprietary information of
 * Sigma Systems Innovation. ("Confidential Information"). You shall
 * not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sigma Systems Innovation.
 *
 * COPYRIGHT (C) 2014 SIGMA SYSTEMS INNOVATION AB.
 * All rights reserved.
 */
package org.eldslott.armory.network;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eldslott.armory.app.CallbackActivity;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/15/14
 */
public class VersionsTask extends AsyncTask<String, Void, JSONArray> {
    private CallbackActivity callbackActivity;

    public VersionsTask(CallbackActivity callbackActivity) {
        this.callbackActivity = callbackActivity;
    }

    @Override
    protected JSONArray doInBackground(String... urls) {
        JSONArray jsonArray = null;

        try {
            jsonArray = tryToReadResponse(urls);
        }
        catch (Exception e) {
            Log.e(VersionsTask.class.toString(), "Failed to check version: " + e.getMessage());
        }

        return jsonArray;
    }

    private JSONArray tryToReadResponse(String... urls) throws IOException, JSONException {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(urls[0]);
        JSONArray jsonArray = null;

        HttpResponse httpResponse = client.execute(httpGet);
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();

        if (statusCode == 200) {
            HttpEntity entity = httpResponse.getEntity();
            InputStream inputStream = entity.getContent();
            jsonArray = new JSONArray(InputStreamToString.convert(inputStream));
        } else {
            Log.e(VersionsTask.class.toString(), "Failed to check version, status code: " + statusCode);
        }

        return jsonArray;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        callbackActivity.taskCallback(VersionsTask.class, jsonArray);
    }
}
