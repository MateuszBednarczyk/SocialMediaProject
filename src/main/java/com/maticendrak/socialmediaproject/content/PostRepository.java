package com.maticendrak.socialmediaproject.content;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface PostRepository extends JpaRepository<PostEntity, Long> {


}
