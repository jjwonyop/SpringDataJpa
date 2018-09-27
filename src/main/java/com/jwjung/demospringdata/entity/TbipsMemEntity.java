/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TbipsMem")
public class TbipsMemEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Transient
    private String yes;

    @Transient
    private String no;

    @OneToMany(mappedBy = "owner")
    // 끝이 현재 클래스(단방향)
    private Set<Study> studies = new HashSet<Study>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    )
    private Address homeAddress;

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudies(Study study) {
        this.studies.add(study);
        study.setOwner(this);
    }

    public void removeStudies(Study study) {
        this.studies.remove(study);
        study.setOwner(null);
    }
}
