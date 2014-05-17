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
package org.eldslott.armory.event.event;

import org.eldslott.armory.entity.VersionEntity;
import org.eldslott.armory.event.Event;
import org.eldslott.armory.event.EventMultiplexer;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class StoreVersionEvent implements Event {
    private VersionEntity versionEntity;

    public StoreVersionEvent(VersionEntity versionEntity) {
        this.versionEntity = versionEntity;
    }

    public VersionEntity getVersionEntity() {
        return versionEntity;
    }
}
