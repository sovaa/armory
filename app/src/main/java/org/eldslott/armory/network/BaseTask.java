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
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.utils.InputStreamToString;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public abstract class BaseTask extends AsyncTask<String, Void, JSONArray> {
    protected static final String BASE_URL = "http://10.0.2.2:3000/";
    protected EventMultiplexer eventMultiplexer;

    public BaseTask(EventMultiplexer eventMultiplexer) {
        this.eventMultiplexer = eventMultiplexer;
    }

    protected JSONArray tryToReadResponse(String url) throws IOException, JSONException {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
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
}
