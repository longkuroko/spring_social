package social.Network.projectsocial.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import social.Network.projectsocial.security.jwt.CustomDetailsService;
import social.Network.projectsocial.security.jwt.JwtAuthenticationFilter;
import social.Network.projectsocial.security.jwt.JwtTokenHelper;
import social.Network.projectsocial.service.UserDetailService;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomDetailsService customDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtTokenHelper;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeRequests()
               .antMatchers("/auth/**")
               .permitAll()
               .anyRequest()
               .authenticated().and()
               .formLogin()
                       .and()
               .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

       // Add a filter to validate the tokens with every request
        http.addFilterBefore(jwtTokenHelper, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);

        provider.setUserDetailsService(userDetailService);
        return provider;
    }
}
