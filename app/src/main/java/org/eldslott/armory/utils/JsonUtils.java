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
package org.eldslott.armory.utils;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class JsonUtils {
    public static Integer getInt(JSONObject jsonObject, String name) {
        try {
            return Integer.parseInt((String)jsonObject.get(name));
        }
        catch (JSONException e) {
            Log.e(JsonUtils.class.toString(), "could not get from jsonObject for name '" + name + "': " + e.getMessage());
        }
        catch (Exception e) {
            Log.e(JsonUtils.class.toString(), "could not parse int for name " + name + "': " + e.getMessage());

            try {
                Log.e(JsonUtils.class.toString(), "value of unparseable int was: " + jsonObject.get(name));
            }
            catch (Exception e2) {
                Log.e(JsonUtils.class.toString(), "could not get unparseable int value from jsonObject: " + e2.getMessage());
            }
        }
        return null;
    }

    public static Double getDouble(JSONObject jsonObject, String name) {
        try {
            return Double.parseDouble((String)jsonObject.get(name));
        }
        catch (JSONException e) {
            Log.e(JsonUtils.class.toString(), "could not get from jsonObject for name '" + name + "': " + e.getMessage());
        }
        catch (Exception e) {
            Log.e(JsonUtils.class.toString(), "could not parse double for name " + name + "': " + e.getMessage());

            try {
                Log.e(JsonUtils.class.toString(), "value of unparseable double was: " + jsonObject.get(name));
            }
            catch (Exception e2) {
                Log.e(JsonUtils.class.toString(), "could not get unparseable double value from jsonObject: " + e2.getMessage());
            }
        }
        return null;
    }

    public static String getString(JSONObject jsonObject, String name) {
        try {
            return String.valueOf(jsonObject.get(name));
        }
        catch (JSONException e) {
            Log.e(JsonUtils.class.toString(), "could not get from jsonObject for name '" + name + "': " + e.getMessage());
        }
        catch (Exception e) {
            Log.e(JsonUtils.class.toString(), "could not get from jsonObject for name '" + name + "': " + e.getMessage());
        }
        return null;
    }
}
