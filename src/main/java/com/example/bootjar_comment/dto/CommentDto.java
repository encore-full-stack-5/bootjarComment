package com.example.bootjar_comment.dto;

import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private Long todoId;
    private String content;
    private Long userId;
    private String nickname;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentDto toEntity(Comment comment, User user) {
        return CommentDto.builder()
                .id(comment.getId())
                .todoId(comment.getTodoId())
                .content(comment.getContent())
                .userId(user.getId())
                .nickname(user.getNickname())
                .image(user.getImage())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}
