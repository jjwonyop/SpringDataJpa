/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata.repository;

import com.jwjung.demospringdata.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @Rollback(false)
    public void save() {
        Comment comment = new Comment();
        comment.setComment("Testing");
        Comment comment1 = commentRepository.save(comment);
        assertThat(comment1.getComment()).isEqualTo(comment.getComment());
        assertThat(comment.getId()).isEqualTo(comment1.getId());

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(1);

        Long count = commentRepository.count();
        assertThat(count).isEqualTo(1);

    }
}