package com.example.bootjar_comment.dto;

import com.example.bootjar_comment.command.CommentCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentDto {
    private Long todoId;
    private Long userId;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public CommentCommand toEntity(Long todoId) {
        return CommentCommand.builder()
                .todoId(todoId)
                .userId(userId)
                .content(content)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
