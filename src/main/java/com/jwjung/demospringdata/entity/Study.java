/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private TbipsMemEntity owner;

    public TbipsMemEntity getOwner() {
        return owner;
    }

    public void setOwner(TbipsMemEntity owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
