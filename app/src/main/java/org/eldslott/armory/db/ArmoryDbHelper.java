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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.eldslott.armory.db.ArmoryContract.*;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/17/14
 */
public class ArmoryDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Armory.db";

    private static final String SQL_CREATE_CREATURES = getSqlCreateCreatures();
    private static final String SQL_CREATE_WEAPONS = getSqlCreateWeapons();
    private static final String SQL_CREATE_VERSIONS = getSqlCreateVersions();

    private static final String SQL_DELETE_CREATURES = SqlBuilder.dropTableSql(CreatureSchema.TABLE_NAME);
    private static final String SQL_DELETE_WEAPONS = SqlBuilder.dropTableSql(WeaponSchema.TABLE_NAME);
    private static final String SQL_DELETE_VERSIONS = SqlBuilder.dropTableSql(VersionSchema.TABLE_NAME);

    private static String getSqlCreateCreatures() {
        SqlBuilder builder = new SqlBuilder(CreatureSchema.TABLE_NAME);
        builder.addField(CreatureSchema.COLUMN_NAME_BACKEND_ID, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(CreatureSchema.COLUMN_NAME_NAME, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(CreatureSchema.COLUMN_NAME_DAMAGE, ArmoryContract.SQL_TYPE_INTEGER);
        builder.addField(CreatureSchema.COLUMN_NAME_HP, ArmoryContract.SQL_TYPE_INTEGER);
        builder.addField(CreatureSchema.COLUMN_NAME_REGEN, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(CreatureSchema.COLUMN_NAME_THREAT, ArmoryContract.SQL_TYPE_INTEGER);
        builder.addField(CreatureSchema.COLUMN_NAME_MATURITY, ArmoryContract.SQL_TYPE_INTEGER);
        return builder.toString();
    }

    private static String getSqlCreateWeapons() {
        SqlBuilder builder = new SqlBuilder(WeaponSchema.TABLE_NAME);
        builder.addField(WeaponSchema.COLUMN_NAME_BACKEND_ID, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_CLASS, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_TYPE, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_NAME, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_DAMAGE, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_RANGE, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_MARKUP, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DECAY, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_BURN, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_ATTACKS, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_HITREC, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_HITMAX, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGREC, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGMAX, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_HITPROF, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGPROF, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_SIB, ArmoryContract.SQL_TYPE_INTEGER);
        builder.addField(WeaponSchema.COLUMN_NAME_SOURCE, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_WEIGHT, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_POWER, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_MINTT, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_MAXTT, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_USES, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DISCOVERED, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_FOUND, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGSTB, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGCUT, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGIMP, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGPEN, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGSHR, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGBRN, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGCLD, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGACD, ArmoryContract.SQL_TYPE_FLOAT);
        builder.addField(WeaponSchema.COLUMN_NAME_DMGELC, ArmoryContract.SQL_TYPE_FLOAT);
        return builder.toString();
    }

    private static String getSqlCreateVersions() {
        SqlBuilder builder = new SqlBuilder(VersionSchema.TABLE_NAME);
        builder.addField(WeaponSchema.COLUMN_NAME_BACKEND_ID, ArmoryContract.SQL_TYPE_TEXT);
        builder.addField(VersionSchema.COLUMN_NAME_APP_VERSION, ArmoryContract.SQL_TYPE_INTEGER);
        builder.addField(VersionSchema.COLUMN_NAME_BACKEND_VERSION, ArmoryContract.SQL_TYPE_INTEGER);
        builder.addField(VersionSchema.COLUMN_NAME_DB_VERSION, ArmoryContract.SQL_TYPE_INTEGER);
        return builder.toString();
    }

    public ArmoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CREATURES);
        db.execSQL(SQL_CREATE_VERSIONS);
        db.execSQL(SQL_CREATE_WEAPONS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CREATURES);
        db.execSQL(SQL_DELETE_VERSIONS);
        db.execSQL(SQL_DELETE_WEAPONS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}