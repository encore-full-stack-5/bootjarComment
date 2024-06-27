package com.example.bootjar_comment.controller;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.domain.User;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UpdateCommentDto;
import com.example.bootjar_comment.global.CreateCommandHandler;
import com.example.bootjar_comment.global.DeleteCommandHandler;
import com.example.bootjar_comment.global.QueryHandler;
import com.example.bootjar_comment.global.UpdateCommandHandler;
import com.example.bootjar_comment.global.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommandHandler commandHandler;
    private final QueryHandler queryHandler;
    private final UpdateCommandHandler updateCommandHandler;
    private final DeleteCommandHandler deleteCommandHandler;
    private final JwtUtils jwtUtils;

    @GetMapping("/{todoId}/comments")
    public Flux<CommentCommand> getComments(
            @PathVariable Long todoId
    ) {
        return queryHandler.getComments(todoId);
    }

    @PostMapping("/{todoId}/comments")
    public Mono<Comment> createComment(
            @PathVariable Long todoId,
            @RequestBody CreateCommentDto commentDto,
            @RequestHeader("Authorization") String token
    ) {
        if(token != null && token.startsWith("Bearer ")) {
            String bearerToken = token.substring(7);
            Long userId = jwtUtils.parseToken(bearerToken).getId();
            return commandHandler.createHandle(todoId, commentDto, userId);
        } else {
            return null;
        }
    }

    @PutMapping("/{todoId}/comments/{commentId}")
    public Mono<Void> updateComment(
            @PathVariable Long commentId,
            @RequestBody UpdateCommentDto comment,
            @RequestHeader("Authorization") String token
    ) {
        return updateCommandHandler.updateHandle(commentId, comment.getContent());
    }

    @DeleteMapping("/{todoId}/comments/{commentId}")
    public Mono<Void> deleteComment(
            @PathVariable Long commentId,
            @RequestHeader("Authorization") String token
    ) {
        return deleteCommandHandler.deleteHandle(commentId);
    }

}
