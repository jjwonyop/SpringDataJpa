/*
 * Copyright (c) 2018.
 * Made by jjwonyop
 */

package com.jwjung.demospringdata.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {
    // Spring Framework 5.0 부터 지원하는 Null Annotation 지원
    <E extends T> E save(@NonNull T entity);

    List<T> findAll();

    Long count();

    @Nullable
    <E extends T> Optional<E> findById(@Nullable Id id);
}
