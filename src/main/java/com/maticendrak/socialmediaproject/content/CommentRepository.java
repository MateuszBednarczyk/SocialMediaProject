package com.maticendrak.socialmediaproject.content;

import com.maticendrak.socialmediaproject.content.comment.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface CommentRepository extends JpaRepository<CommentEntity, Long> {


}
