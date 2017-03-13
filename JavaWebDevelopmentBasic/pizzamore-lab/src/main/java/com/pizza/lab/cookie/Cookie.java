package com.pizza.lab.cookie;

/**
 * Created by cefothe on 03.03.17.
 */
public class Cookie {

    private String name;

    private String value;

    public Cookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getCookie(){
        return name+"="+value;
    }
}
