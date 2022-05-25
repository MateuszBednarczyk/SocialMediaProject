package com.maticendrak.socialmediaproject.appuser;

import com.maticendrak.socialmediaproject.content.post.PostEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Users")
@Data
@NoArgsConstructor
@Table(name = "users")
public class AppUserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Usersettings
    @NotNull
    private String username;
    @NotNull
    private String password;

    @Nullable
    private String email;

    @Nullable
    private String description;

    @Nullable
    private String image;

    @Nullable
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PostEntity> posts;

    @Nullable
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> following;
    private String role;

    public AppUserEntity(String username, String password, @Nullable String email, @Nullable String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
