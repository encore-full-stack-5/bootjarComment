package com.example.bootjar_comment.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "nickname")
    private String nickname;

    @Column(value = "image")
    private String image;
}
