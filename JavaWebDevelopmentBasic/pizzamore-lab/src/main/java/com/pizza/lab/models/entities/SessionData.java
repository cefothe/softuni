package com.pizza.lab.models.entities;

import javax.persistence.*;

/**
 * Created by cefothe on 03.03.17.
 */
@Entity
@Table(name = "sessions_data")
public class SessionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String key;

    private String value;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    protected SessionData() {
    }

    public SessionData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
