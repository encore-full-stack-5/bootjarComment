package com.example.bootjar_comment.repository;

import com.example.bootjar_comment.command.CommentCommand;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface QueryRepository extends R2dbcRepository<CommentCommand, Long> {
    @Query("SELECT C.id, C.todoId, U.id AS userId, C.content, U.nickname, U.image, C.createdAt, C.updatedAt " +
             "FROM comments C " +
        "LEFT JOIN users U ON C.userId = U.id " +
            "WHERE C.todoId = :todoId")
    Flux<CommentCommand> findByTodoId(Long todoId);
}