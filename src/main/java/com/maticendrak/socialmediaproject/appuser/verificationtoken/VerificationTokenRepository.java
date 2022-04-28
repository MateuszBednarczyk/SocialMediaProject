package com.maticendrak.socialmediaproject.appuser.verificationtoken;

import org.springframework.data.jpa.repository.JpaRepository;

interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {

    VerificationTokenEntity findVerificationTokenEntityByUserId(Long id);

}
