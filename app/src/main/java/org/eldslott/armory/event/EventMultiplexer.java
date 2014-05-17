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
import org.eldslott.armory.app.ArmoryMain;
import org.eldslott.armory.event.handlers.NewBackendDbVersionEventHandler;
import org.eldslott.armory.event.handlers.ReadVersionsEventHandler;
import org.eldslott.armory.event.handlers.UpdateCreaturesEventHandler;
import org.eldslott.armory.event.handlers.UpdateWeaponsEventHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class EventMultiplexer {
    private List<EventHandler<?>> eventHandlers;
    private FragmentActivity fragmentActivity;

    public EventMultiplexer(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
        eventHandlers = new ArrayList<>();
        eventHandlers.add(new NewBackendDbVersionEventHandler(this));
        eventHandlers.add(new UpdateCreaturesEventHandler(this));
        eventHandlers.add(new UpdateWeaponsEventHandler(this));
        eventHandlers.add(new ReadVersionsEventHandler(this));
    }

    public FragmentActivity getActivity() {
        return fragmentActivity;
    }

    public void onEvent(Event event) {
        boolean foundHandler = false;

        for (EventHandler handler : eventHandlers) {
            if (handler.handlesEvent().equals(event.getClass())) {
                foundHandler = true;
                handler.onEvent(event);
            }
        }

        if (!foundHandler) {
            throw new IllegalArgumentException("no handler for event " + event.getClass().getName());
        }
    }
}
