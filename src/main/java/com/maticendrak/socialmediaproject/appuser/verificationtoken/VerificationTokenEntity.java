package com.maticendrak.socialmediaproject.appuser.verificationtoken;

import com.maticendrak.socialmediaproject.appuser.AppUserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Tokens")
class VerificationTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tokenId;
    private String tokenValue;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUserEntity user;

    public VerificationTokenEntity(String tokenValue, AppUserEntity user) {
        this.tokenValue = tokenValue;
        this.user = user;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public AppUserEntity getUser() {
        return user;
    }

    public void setUser(AppUserEntity user) {
        this.user = user;
    }
}
