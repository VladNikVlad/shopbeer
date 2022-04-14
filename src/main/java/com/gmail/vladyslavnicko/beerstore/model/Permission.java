package com.gmail.vladyslavnicko.beerstore.model;

public enum Permission {
    DEVELOPERS_READ("developers:read"),
    DEVELOPER_WRITE("developers:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
