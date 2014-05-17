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
package org.eldslott.armory.event.handlers;

import android.util.Log;
import org.eldslott.armory.entity.VersionEntity;
import org.eldslott.armory.event.EventHandler;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.NewBackendDbVersionEvent;
import org.eldslott.armory.event.event.ReadVersionsEvent;
import org.eldslott.armory.event.event.StoreVersionEvent;
import org.eldslott.armory.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class ReadVersionsEventHandler extends EventHandler<ReadVersionsEvent> {
    public ReadVersionsEventHandler(EventMultiplexer eventMultiplexer) {
        super(eventMultiplexer, ReadVersionsEvent.class);
    }

    private static final String JSON_NAME_BACKEND_ID = "_id";
    private static final String JSON_NAME_DATABASE = "database";
    private static final String JSON_NAME_APP = "app"; // TODO: probably remove, backend shouldn't need to know app version
    private static final String JSON_NAME_BACKEND = "backend";

    @Override
    public void onEvent(ReadVersionsEvent event) {
        JSONArray jsonArray = event.getJsonArray();
        VersionEntity version = VersionEntity.unknown();

        try {
            version = tryToRead(jsonArray);
        }
        catch (Exception e) {
            Log.e(ReadVersionsEventHandler.class.getName(), "could not read version from JsonReader: " + e.getMessage());
        }

        publishEvent(new StoreVersionEvent(version));

        // TODO: check against stored version in db
        if (version.getDatabase() > 1) {
            publishEvent(new NewBackendDbVersionEvent());
        }
    }

    private VersionEntity tryToRead(JSONArray jsonArray) throws IOException, JSONException {
        if (jsonArray == null) {
            return VersionEntity.unknown();
        }

        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String backendId = JsonUtils.getString(jsonObject, JSON_NAME_BACKEND_ID);
        Integer app = JsonUtils.getInt(jsonObject, JSON_NAME_APP);
        Integer backend = JsonUtils.getInt(jsonObject, JSON_NAME_BACKEND);
        Integer database = JsonUtils.getInt(jsonObject, JSON_NAME_DATABASE);

        return VersionEntity.create(backendId, database, backend, app);
    }
}
