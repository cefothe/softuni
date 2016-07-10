package com.cefothe.exam.system.split.common;

import sun.invoke.empty.Empty;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class SystemInformation {
    private  String name;


    protected SystemInformation(String name) {
        setName(name);
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
