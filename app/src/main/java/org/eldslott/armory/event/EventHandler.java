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
package org.eldslott.armory.event;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public abstract class EventHandler<T extends Event> {
    protected EventMultiplexer eventMultiplexer;
    private final Class<? extends Event> handles;

    public EventHandler(EventMultiplexer eventMultiplexer, Class<? extends Event> event) {
        this.eventMultiplexer = eventMultiplexer;
        this.handles = event;
    }

    public abstract void onEvent(T event);

    public FragmentActivity getActivity() {
        return eventMultiplexer.getActivity();
    }

    public Class<? extends Event> handlesEvent() {
        return handles;
    }

    protected void publishEvent(Event event) {
        eventMultiplexer.onEvent(event);
    }
}
