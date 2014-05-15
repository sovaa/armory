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
import org.eldslott.armory.entity.Versions;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/15/14
 */
public class VersionsReader implements JsonCallbackReader<Versions> {
    private static final String JSON_NAME_DATABASE = "database";
    private static final String JSON_NAME_APP = "app"; // TODO: probably remove, backend shouldn't need to know app version
    private static final String JSON_NAME_BACKEND = "backend";

    public Versions read(JSONArray jsonArray) {
        Versions version = Versions.unknown();

        try {
            version = tryToRead(jsonArray);
        }
        catch (Exception e) {
            Log.e(VersionsReader.class.getName(), "could not read version from JsonReader: " + e.getMessage());
        }

        return version;
    }

    private Versions tryToRead(JSONArray jsonArray) throws IOException, JSONException {
        Integer backend = null;
        Integer app = null;
        Integer database = null;

        if (jsonArray == null) {
            return Versions.unknown();
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            app = max(jsonArray.getJSONObject(i).get(JSON_NAME_APP), app);
            backend = max(jsonArray.getJSONObject(i).get(JSON_NAME_BACKEND), backend);
            database = max(jsonArray.getJSONObject(i).get(JSON_NAME_DATABASE), database);
        }

        return Versions.create(database, backend, app);
    }

    private Integer max(Object nextObject, Integer prev) {
        Integer next;
        try {
            next = (Integer)nextObject;
        }
        catch (Exception e) {
            return prev;
        }

        if (next == null) {
            return prev;
        }

        if (prev == null) {
            return next;
        }

        if (next > prev) {
            return next;
        }

        return prev;
    }
}
