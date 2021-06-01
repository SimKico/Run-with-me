package com.app.rwm.enums;

public enum INJURY_TYPE {
	
	KNEE_PAIN("KNEE_PAIN"), ACHILLES_TENDINITIS("ACHILLES_TENDINITIS"), BROKEN_LEG("BROKEN_LEG") ;

    private final String name;       

    private INJURY_TYPE(String s) {
        name = s;
    }

    @Override
    public String toString() {
       return this.name;
    }
}
