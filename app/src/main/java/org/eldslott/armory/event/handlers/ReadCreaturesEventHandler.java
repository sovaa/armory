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
import org.eldslott.armory.entity.CreatureEntity;
import org.eldslott.armory.event.EventHandler;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.ReadCreaturesEvent;
import org.eldslott.armory.event.event.StoreCreaturesEvent;
import org.eldslott.armory.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class ReadCreaturesEventHandler extends EventHandler<ReadCreaturesEvent> {
    public ReadCreaturesEventHandler(EventMultiplexer eventMultiplexer) {
        super(eventMultiplexer, ReadCreaturesEvent.class);
    }

    private static final String JSON_NAME_BACKEND_ID = "_id";
    private static final String JSON_NAME_NAME = "name";
    private static final String JSON_NAME_HP = "hp";
    private static final String JSON_NAME_REGEN = "regen";
    private static final String JSON_NAME_DAMAGE = "damage";
    private static final String JSON_NAME_THREAT = "threat";
    private static final String JSON_NAME_MATURITY = "maturity";

    @Override
    public void onEvent(ReadCreaturesEvent event) {
        JSONArray jsonArray = event.getJsonArray();
        List<CreatureEntity> creatureEntities = null;

        try {
            creatureEntities = tryToRead(jsonArray);
        }
        catch (Exception e) {
            Log.e(ReadCreaturesEventHandler.class.getName(), "could not read version from JsonReader: " + e.getMessage());
        }

        if (creatureEntities != null) {
            publishEvent(new StoreCreaturesEvent(creatureEntities));
        }
    }

    private List<CreatureEntity> tryToRead(JSONArray jsonArray) throws IOException, JSONException {
        if (jsonArray == null) {
            return null;
        }

        List<CreatureEntity> creatureEntities = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String backendId = JsonUtils.getString(jsonObject, JSON_NAME_BACKEND_ID);
            String name = JsonUtils.getString(jsonObject, JSON_NAME_NAME);
            Integer hp = JsonUtils.getInt(jsonObject, JSON_NAME_HP);
            Double regen = JsonUtils.getDouble(jsonObject, JSON_NAME_REGEN);
            Integer damage = JsonUtils.getInt(jsonObject, JSON_NAME_DAMAGE);
            Integer threat = JsonUtils.getInt(jsonObject, JSON_NAME_THREAT);
            Integer maturity = JsonUtils.getInt(jsonObject, JSON_NAME_MATURITY);

            creatureEntities.add(CreatureEntity.create(backendId, name, hp, regen, damage, threat, maturity));
        }

        return creatureEntities;
    }
}
