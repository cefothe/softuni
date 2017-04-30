package com.cefothe.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Stefan Angelov - Delta Source Bulgaria on 3/13/17.
 */

public class Dog implements Animal {

    private String name;

    public  Dog(){
        System.out.println("Instantiating");
    }

    //@PostConstruct
    public void init(){
        System.out.println("Initializing");
    }

    //@PreDestroy
    public  void destroy(){
        System.out.println("Destroy");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
