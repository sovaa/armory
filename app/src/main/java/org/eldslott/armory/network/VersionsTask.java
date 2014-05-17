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

import android.util.Log;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.ReadVersionsEvent;
import org.json.JSONArray;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/15/14
 */
public class VersionsTask extends BaseTask {
    public VersionsTask(EventMultiplexer eventMultiplexer) {
        super(eventMultiplexer);
    }

    @Override
    protected JSONArray doInBackground(String... urls) {
        JSONArray jsonArray = null;
        String url = BASE_URL + "versions.json";

        try {
            jsonArray = tryToReadResponse(url);
        }
        catch (Exception e) {
            Log.e(VersionsTask.class.toString(), "Failed to check version: " + e.getMessage());
        }

        return jsonArray;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        eventMultiplexer.onEvent(new ReadVersionsEvent(jsonArray));
    }
}
