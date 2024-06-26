package com.example.bootjar_comment.command;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table("comments")
public class CommentCommand {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "userId")
    private Long userId;

    @Column(value = "todoId")
    private Long todoId;

    @Column(value = "nickname")
    private String nickname;

    @Column(value = "image")
    private String image;

    @Column(value = "content")
    private String content;

    @CreatedDate
    @Column(value = "createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(value = "updatedAt")
    private LocalDateTime updatedAt;
}
