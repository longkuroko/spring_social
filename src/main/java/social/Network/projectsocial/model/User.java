package social.Network.projectsocial.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(updatable = false)
    private String userCode;

    private String imgUrl;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email(message = "{error:invalid_email}")
    private String email;

    private String description;
    private Date create_At;
    private Date update_At;
    private boolean isLocked = false;
    private boolean isEnable = false;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String userCode, String imgUrl, String username, String password, String email, String description,
                Date create_At, Date update_At, Role role) {
        this.userCode = userCode;
        this.imgUrl = imgUrl;
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.create_At = create_At;
        this.update_At = update_At;
        this.role = role;
    }

    public User(String username, String email, String  password, Role role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String  getEmail(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }

    //    private  boolean accountVerified;
//
//    @OneToMany(mappedBy = "user")
//    private Set<EmailSecureToken> tokens;


}
