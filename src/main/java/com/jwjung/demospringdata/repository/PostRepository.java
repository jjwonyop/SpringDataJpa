/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata.repository;

import com.jwjung.demospringdata.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * Spring framework code를 최소화 --> Autowired 대신 PersistenceContext
     * @Repository어노테이션 없어도 빈 등록이 됨
     *
     * @EnableJpaRepositorys 시작해서
     *
     * @Import(JpaRepositoriesRegistrar.class)(시작)
     * 를 통해 JpaRepository가 등록됨
     *
     * 핵심은 ImportBeanDefinitionRegistrar 인터페이스
     */

}
