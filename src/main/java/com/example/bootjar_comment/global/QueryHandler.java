package com.example.bootjar_comment.global;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.service.CommentQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class QueryHandler {
    private final CommentQueryService commentQueryService;

    public Flux<CommentCommand> getComments(Long todoId) {
        return commentQueryService.getCommentList(todoId);
    }
}
