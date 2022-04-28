package com.maticendrak.socialmediaproject.post;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @NotNull
    private String author;

    @NotNull
    private String postTitle;

    @NotNull
    private String postContent;

    @ManyToOne
    private CommentEntity comments;

    public PostEntity(String author, String postTitle, String postContent) {
        this.author = author;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

}
