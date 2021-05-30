package com.app.rwm.enums;

public enum USER_ROLE {
	ROLE_ADMIN ("ROLE_ADMIN"), ROLE_RUNNER("ROLE_RUNNER");

    private final String name;       

    private USER_ROLE(String s) {
        name = s;
    }

    @Override
    public String toString() {
       return this.name;
    }
}
