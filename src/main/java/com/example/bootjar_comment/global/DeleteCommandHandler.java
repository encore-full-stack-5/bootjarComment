package com.example.bootjar_comment.global;

import com.example.bootjar_comment.dto.UpdateCommentDto;
import com.example.bootjar_comment.service.CommentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteCommandHandler {
    private final CommentCommandService commentCommandService;

    public Mono<Void> deleteHandle(){
        return commentCommandService.deleteComment();
    }

}
