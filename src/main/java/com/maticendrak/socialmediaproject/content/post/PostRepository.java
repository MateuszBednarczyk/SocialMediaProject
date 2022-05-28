package com.maticendrak.socialmediaproject.content.post;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByAuthor(AppUserEntity author);
    PostEntity findByPostId(Long id);

}
