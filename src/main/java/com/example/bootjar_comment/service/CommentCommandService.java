package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.dto.UpdateCommentDto;
import com.example.bootjar_comment.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentCommandService {

    private final CommandRepository commandRepository;

    public Mono<CommentCommand> createComment(Long todoId, CreateCommentDto commentDto) {
        CommentCommand comment = commentDto.toEntity(todoId);
        return commandRepository.save(comment);
    }

    public Mono<Void> updateComment(Long commentId, String content) {
        return commandRepository.findById(commentId)
                .flatMap(comment -> {
                    comment.setContent(content);
                    comment.setUpdatedAt(LocalDateTime.now());
                    return commandRepository.save(comment).then();
                });
    }

    public Mono<Void> deleteComment(Long commentId) {
        return commandRepository.deleteById(commentId);
    }
}
