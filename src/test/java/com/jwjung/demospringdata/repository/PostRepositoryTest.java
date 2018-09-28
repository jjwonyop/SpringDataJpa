/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata.repository;

import com.jwjung.demospringdata.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        Post post = new Post();
        post.setTitle("Hello Test");
        assertThat(post.getId()).isNull();

        Post newPost = postRepository.save(post);

        assertThat(newPost.getId()).isNotNull();

        List<Post> postList = postRepository.findAll();
        assertThat(postList.size()).isEqualTo(1);
        assertThat(postList).contains(newPost);

        //Paging
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        Page<Post> hello = postRepository.findByTitleContains("Hello", PageRequest.of(0, 10));
        assertThat(hello.getTotalElements()).isEqualTo(1);
        assertThat(hello.getNumber()).isEqualTo(0);
        assertThat(hello.getSize()).isEqualTo(10);
        assertThat(hello.getNumberOfElements()).isEqualTo(1);

        // counting
        long countByTitleContains = postRepository.countByTitleContains("Hello");
        assertThat(countByTitleContains).isEqualTo(1);

        //starting
        page = postRepository.findByTitleStartingWith("Nothing", PageRequest.of(0, 10));
        assertThat(page.getNumberOfElements()).isEqualTo(0);


    }

}