//package social.Network.projectsocial.security.jwt;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import social.Network.projectsocial.model.Role;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public class CustomUserDetail implements UserDetails {
//
//    User user;
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//            .collect(Collectors.toList());
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
