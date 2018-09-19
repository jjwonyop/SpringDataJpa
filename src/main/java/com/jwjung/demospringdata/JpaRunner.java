/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata;

import com.jwjung.demospringdata.entity.TbipsMemEntity;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        TbipsMemEntity tbipsMemEntity = new TbipsMemEntity();
        tbipsMemEntity.setUsername("juwon");
        tbipsMemEntity.setPassword("aaaa");
//        Session session = entityManager.unwrap(Session.class);
//        session.save(tbipsMemEntity);
        entityManager.persist(tbipsMemEntity);
    }
}
