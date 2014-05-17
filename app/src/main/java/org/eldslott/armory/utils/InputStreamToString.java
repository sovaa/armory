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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/16/14
 */
public class InputStreamToString {
    public static String convert(InputStream inputStream) {
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader rd = new BufferedReader(isr);

        try {
            String line;
            while ((line = rd.readLine()) != null) {
                answer.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return answer.toString();
    }
}
