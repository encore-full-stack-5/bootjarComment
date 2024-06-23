package com.example.bootjar_comment.repository;

import com.example.bootjar_comment.command.CommentCommand;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CommandRepository extends R2dbcRepository<CommentCommand, Long> {
    Flux<CommentCommand> findByTodoId(Long todoId);
}
