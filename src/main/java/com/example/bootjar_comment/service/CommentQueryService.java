package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.User;
import com.example.bootjar_comment.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentQueryService {
    Flux<CommentCommand> getCommentList(Long todoId);
}