/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata;

import com.jwjung.demospringdata.entity.Comment;
import com.jwjung.demospringdata.entity.Post;
import org.hibernate.Session;
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
//        TbipsMemEntity tbipsMemEntity = new TbipsMemEntity();
//        tbipsMemEntity.setUsername("juwon");
//        tbipsMemEntity.setPassword("aaaa");
//        Study study = new Study();
//        study.setName("juwon");
//
//        tbipsMemEntity.addStudies(study);
//
//        entityManager.persist(tbipsMemEntity);
//        entityManager.persist(study);

//        Post post = new Post();
//        post.setTitle("1입니다.");
//
//        Comment comment = new Comment();
//        comment.setComment("gma");
//
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("qmd");
//
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 4L);
        System.out.println("==============");
        System.out.println(post.getTitle());
        post.getComment().forEach(str -> {
            System.out.println("===================");
            System.out.println(str.getComment());
            System.out.println("===================");
        });
//        session.save(post);
        Comment comment = session.get(Comment.class, 5L);
        System.out.println("=======================");
        System.out.println(comment.getPost().getTitle());
        System.out.println(comment.getComment());
    }
}
