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
public final class Versions {
    private static final Versions UNKNOWN_VERSION = new Versions(-1, -1, -1);

    private final Integer database;
    private final Integer backend;
    private final Integer app;

    private Versions(Integer database, Integer backend, Integer app) {
        this.database = database;
        this.backend = backend;
        this.app = app;
    }

    public static Versions create(Integer database, Integer backend, Integer app) {
        if (database == null || backend == null || app == null) {
            return unknown();
        }

        return new Versions(database, backend, app);
    }

    @Override
    public String toString() {
        return "Versions{" +
                "database=" + database +
                ", backend=" + backend +
                ", app=" + app +
                '}';
    }

    public static Versions unknown() {
        return UNKNOWN_VERSION;
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