/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata;

import com.jwjung.demospringdata.entity.Comment;
import com.jwjung.demospringdata.entity.Post;
import com.jwjung.demospringdata.repository.PostRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

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

        Post post = new Post();
        post.setTitle("2입니다.");

        Comment comment = new Comment();
        comment.setComment("ama");

        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("wmd");

        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
//        Post post = session.get(Post.class, 4L);
//        System.out.println("==============");
//        System.out.println(post.getTitle());
//        post.getComment().forEach(str -> {
//            System.out.println("===================");
//            System.out.println(str.getComment());
//            System.out.println("===================");
//        });
        session.save(post);
//        Comment comment = session.get(Comment.class, 5L);
//        System.out.println("=======================");
//        System.out.println(comment.getPost().getTitle());
//        System.out.println(comment.getComment());

        /**
         * JPQL(HQL)
         * Entity 기준 작성 쿼리
         */
        TypedQuery<Post> query = (TypedQuery<Post>) entityManager.createQuery("SELECT p from Post as p");
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        System.out.println("==========================================");

        /**
         * Criteria Query(type safe Query)
         */
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> builderQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = builderQuery.from(Post.class);
        builderQuery.select(root);

        List<Post> resultList = entityManager.createQuery(builderQuery).getResultList();
        resultList.forEach(System.out::println);
        System.out.println("==========================================");

        /**
         * Native Query
         */
        List<Post> posts1 = entityManager.createNativeQuery("SELECT * from post", Post.class).getResultList();
        posts1.forEach(System.out::println);
        System.out.println("==========================================");

        /**
         * JPA Repository 사용
         */
        postRepository.findAll().forEach(System.out::println);
    }
}
