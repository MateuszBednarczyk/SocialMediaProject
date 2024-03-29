package com.maticendrak.socialmediaproject.content.comment;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "comment")
@Data
@NoArgsConstructor
@Table(name = "Comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String content;
    private Long parentPostId;

    public CommentEntity(String author, String content, Long parentPostId) {
        this.author = author;
        this.content = content;
        this.parentPostId = parentPostId;
    }
}
