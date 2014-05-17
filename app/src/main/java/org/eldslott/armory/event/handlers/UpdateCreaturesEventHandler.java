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

import org.eldslott.armory.event.EventHandler;
import org.eldslott.armory.event.EventMultiplexer;
import org.eldslott.armory.event.event.UpdateCreaturesEvent;
import org.eldslott.armory.network.CreaturesTask;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class UpdateCreaturesEventHandler extends EventHandler<UpdateCreaturesEvent> {
    public UpdateCreaturesEventHandler(EventMultiplexer eventMultiplexer) {
        super(eventMultiplexer, UpdateCreaturesEvent.class);
    }

    @Override
    public void onEvent(UpdateCreaturesEvent event) {
        new CreaturesTask(eventMultiplexer).execute();
    }
}
