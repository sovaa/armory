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
package org.eldslott.armory.db;

import android.provider.BaseColumns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class SqlBuilder {
    private static final String COMMA_SEP = ", ";
    private static final String CLOSING_PARANTHESIS = ")";

    private StringBuilder builder;
    private Set<String> fields;
    private boolean finished = false;
    private String builtSql = null;

    public SqlBuilder(String tableName) {
        builder = new StringBuilder(String.format("create table %s (%s integer primary key", tableName, BaseColumns._ID));
        fields = new HashSet<>();
    }

    public static String dropTableSql(String tableName) {
        return "drop table if exists " + tableName;
    }

    public void addField(String fieldName, String fieldType) {
        if (finished) {
            throw new IllegalStateException("already finished, create new builder");
        }
        fields.add(String.format("%s %s", fieldName, fieldType));
    }

    @Override
    public String toString() {
        if (builtSql != null) {
            return builtSql;
        }

        appendFields();
        builder.append(CLOSING_PARANTHESIS);
        builtSql = builder.toString();

        return builtSql;
    }

    private void appendFields() {
        if (fields.size() == 0) {
            return;
        }

        Iterator<String> iter = fields.iterator();

        while (iter.hasNext()) {
            builder.append(iter.next());
            if (iter.hasNext()) {
                builder.append(COMMA_SEP);
            }
        }
    }
}
