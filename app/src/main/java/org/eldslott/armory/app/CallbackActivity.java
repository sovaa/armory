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
package org.eldslott.armory.app;

import org.json.JSONArray;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/15/14
 */
public interface CallbackActivity {
    public void taskCallback(Class<?> classType, JSONArray jsonArray);
}
