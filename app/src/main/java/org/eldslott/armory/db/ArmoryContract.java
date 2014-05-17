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

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public abstract class ArmoryContract {
    public static final String SQL_TYPE_TEXT = "text";
    public static final String SQL_TYPE_INTEGER = "integer";
    public static final String SQL_TYPE_FLOAT = "float";

    public static abstract interface BaseArmorySchema extends BaseColumns {
        public static final String COLUMN_NAME_BACKEND_ID = "backendId";
    }

    public static abstract interface CreatureSchema extends BaseArmorySchema {
        public static final String TABLE_NAME = "creature";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_HP = "hp";
        public static final String COLUMN_NAME_REGEN = "regen";
        public static final String COLUMN_NAME_DAMAGE = "damage";
        public static final String COLUMN_NAME_THREAT = "threat";
        public static final String COLUMN_NAME_MATURITY = "maturity";
    }

    public static abstract class VersionSchema implements BaseArmorySchema {
        public static final String TABLE_NAME = "version";
        public static final String COLUMN_NAME_BACKEND_VERSION = "backend";
        public static final String COLUMN_NAME_APP_VERSION = "app";
        public static final String COLUMN_NAME_DB_VERSION = "db";
    }

    public static abstract class WeaponSchema implements BaseArmorySchema {
        public static final String TABLE_NAME = "weapon";
        public static final String COLUMN_NAME_CLASS = "class";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DAMAGE = "damage";
        public static final String COLUMN_NAME_RANGE = "range";
        public static final String COLUMN_NAME_MARKUP = "markup";
        public static final String COLUMN_NAME_DECAY = "decay";
        public static final String COLUMN_NAME_BURN = "burn";
        public static final String COLUMN_NAME_ATTACKS = "attacks";
        public static final String COLUMN_NAME_HITREC = "hitrec";
        public static final String COLUMN_NAME_HITMAX = "hitmax";
        public static final String COLUMN_NAME_DMGREC = "dmgrec";
        public static final String COLUMN_NAME_DMGMAX = "dmgmax";
        public static final String COLUMN_NAME_HITPROF = "hitprof";
        public static final String COLUMN_NAME_DMGPROF = "dmgprof";
        public static final String COLUMN_NAME_SIB = "sib";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_POWER = "power";
        public static final String COLUMN_NAME_MINTT = "mintt";
        public static final String COLUMN_NAME_MAXTT = "maxtt";
        public static final String COLUMN_NAME_USES = "uses";
        public static final String COLUMN_NAME_DISCOVERED = "discovered";
        public static final String COLUMN_NAME_FOUND = "found";
        public static final String COLUMN_NAME_DMGSTB = "dmgstb";
        public static final String COLUMN_NAME_DMGCUT = "dmgcut";
        public static final String COLUMN_NAME_DMGIMP = "dmgimp";
        public static final String COLUMN_NAME_DMGPEN = "dmgpen";
        public static final String COLUMN_NAME_DMGSHR = "dmgshr";
        public static final String COLUMN_NAME_DMGBRN = "dmgbrn";
        public static final String COLUMN_NAME_DMGCLD = "dmgcld";
        public static final String COLUMN_NAME_DMGACD = "dmgacd";
        public static final String COLUMN_NAME_DMGELC = "dmgelc";
    }
}
