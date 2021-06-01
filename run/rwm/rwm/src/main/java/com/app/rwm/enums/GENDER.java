package com.app.rwm.enums;

public enum GENDER {
	MALE ("MALE"), FEMALE("FEMALE");

    private final String name;       

    private GENDER(String s) {
        name = s;
    }

    @Override
    public String toString() {
       return this.name;
    }
}
