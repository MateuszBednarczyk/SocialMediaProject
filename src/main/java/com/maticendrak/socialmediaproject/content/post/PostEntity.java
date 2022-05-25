package com.maticendrak.socialmediaproject.content.post;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import com.maticendrak.socialmediaproject.content.comment.CommentEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "post")
@Data
@NoArgsConstructor
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @NotNull
    @ManyToOne
    private AppUserEntity author;

    @NotNull
    private String postTitle;

    @NotNull
    private String postContent;

    @Nullable
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CommentEntity> comments;

    public PostEntity(AppUserEntity author, String postTitle, String postContent) {
        this.author = author;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}
