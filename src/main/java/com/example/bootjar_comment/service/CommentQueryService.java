package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.User;
import reactor.core.publisher.Flux;

public interface CommentQueryService {
    Flux<CommentCommand> getCommentList(Long todoId);
}