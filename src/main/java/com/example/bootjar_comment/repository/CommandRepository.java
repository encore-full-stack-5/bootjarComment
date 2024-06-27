package com.example.bootjar_comment.repository;

import com.example.bootjar_comment.domain.Comment;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CommandRepository extends R2dbcRepository<Comment, Long> {
    @Query("SELECT T.id " +
             "FROM todos T " +
            "WHERE T.id = :todoId")
    Mono<Comment> findByTodoId(Long todoId);
}
