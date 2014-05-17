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
package org.eldslott.armory.entity;

/**
 * @author <a href="mailto:oscar.eriksson@sigma.se">Oscar Eriksson</a>
 * @date 5/16/14
 */
public final class VersionEntity extends BaseEntity {
    private static final VersionEntity UNKNOWN_ENTITY = new VersionEntity(null, -1, -1, -1);

    private final Integer database;
    private final Integer backend;
    private final Integer app;

    private VersionEntity(String backendId, Integer database, Integer backend, Integer app) {
        this.backendId = backendId;
        this.database = database;
        this.backend = backend;
        this.app = app;
    }

    public static VersionEntity create(String backendId, Integer database, Integer backend, Integer app) {
        if (backendId == null || database == null || backend == null || app == null) {
            return unknown();
        }

        return new VersionEntity(backendId, database, backend, app);
    }

    @Override
    public String toString() {
        return "VersionEntity{" +
                "database=" + database +
                ", backend=" + backend +
                ", app=" + app +
                "} " + super.toString();
    }

    public static VersionEntity unknown() {
        return UNKNOWN_ENTITY;
    }

    public Integer getDatabase() {
        return database;
    }

    public Integer getBackend() {
        return backend;
    }

    public Integer getApp() {
        return app;
    }
}