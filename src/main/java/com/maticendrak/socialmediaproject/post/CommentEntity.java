package com.maticendrak.socialmediaproject.post;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String content;

    @ManyToOne
    private CommentEntity answers;

}
