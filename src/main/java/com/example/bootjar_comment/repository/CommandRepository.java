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

    // user-insert
    @Query("INSERT INTO users VALUES (:id, :nickname, :image)")
    Mono<Void> createByUserId(Long id, String nickname, String image);
    // user-update
    @Query("UPDATE users " +
              "SET nickname = :nickname, image = :image " +
            "WHERE id = :id")
    Mono<Void> updateByUserId(Long id, String nickname, String image);
    // user-delete
    @Query("DELETE " +
             "FROM users " +
            "WHERE id = :userId")
    Mono<Void> deleteByUserId(Long userId);
    // todo-insert
    @Query("INSERT INTO todos VALUES (:todoId)")
    Mono<Void> createByTodoId(Long todoId);
    // todo-delete
    @Query("DELETE " +
             "FROM todos " +
            "WHERE id = :todoId")
    Mono<Void> deleteByTodoId(Long todoId);
}
