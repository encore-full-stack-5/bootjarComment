package com.example.bootjar_comment.global;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.service.CommentCommandService;
import com.example.bootjar_comment.service.CommentQueryService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class QueryHandler {
    CommentQueryService commentQueryService;

    public Flux<CommentCommand>getComments(Long todoId){
        return commentQueryService.getCommentList(todoId);
    }


}
