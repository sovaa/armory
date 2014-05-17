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

import org.eldslott.armory.entity.VersionEntity;
import org.eldslott.armory.event.EventHandler;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.StoreVersionEvent;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class StoreVersionEventHandler extends EventHandler<StoreVersionEvent> {
    public StoreVersionEventHandler(EventMultiplexer eventMultiplexer) {
        super(eventMultiplexer, StoreVersionEvent.class);
    }

    @Override
    public void onEvent(StoreVersionEvent event) {
        VersionEntity creatureEntities = event.getVersionEntity();
        // TODO: store them in db
    }
}