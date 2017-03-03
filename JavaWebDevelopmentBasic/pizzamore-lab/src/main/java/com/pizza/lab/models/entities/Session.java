package com.pizza.lab.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cefothe on 03.03.17.
 */
@Entity
@Table(name="sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private Set<SessionData> sessionData;

    public Session(){
        this.setSessionData(new HashSet<>());
    }

    public void addData(String key, String value){
        this.getSessionData().add(new SessionData(key,value));
    }

    private void setSessionData(Set<SessionData> sessionData) {
        this.sessionData = sessionData;
    }

    public Set<SessionData> getSessionData() {
        return sessionData;
    }

    public long getId() {
        return id;
    }

}
