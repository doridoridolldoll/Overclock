package overclock.overclock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import overclock.overclock.security.filter.ApiCheckFilter;
import overclock.overclock.security.filter.ApiLoginFilter;
import overclock.overclock.security.handler.ApiLoginFailHandler;
import overclock.overclock.security.handler.LoginSuccessHandler;
import overclock.overclock.security.util.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http.csrf().disable();
        http.addFilterBefore(apiCheckFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(apiLoginFilter(authenticationManager),
                UsernamePasswordAuthenticationFilter.class);
//        http.authorizeRequests().antMatchers("http://localhost:8080/partsregister").hasRole("ADMIN");

        http.oauth2Login().successHandler(successHandler());
//        http.oauth2Login();
//        http.oauth2Login().defaultSuccessUrl("./asdsad");
//
        return http.build() ;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public LoginSuccessHandler successHandler() {
        return new LoginSuccessHandler(passwordEncoder());
    }

    @Bean
    public ApiLoginFilter apiLoginFilter(AuthenticationManager authenticationManager) throws Exception {
        ApiLoginFilter apiLoginFilter = new ApiLoginFilter("/member/login", jwtUtil());

        apiLoginFilter.setAuthenticationManager(authenticationManager);
//        apiLoginFilter.setAuthenticationSuccessHandler(successHandler());
        apiLoginFilter.setAuthenticationFailureHandler(new ApiLoginFailHandler());
        return apiLoginFilter;
    }

    @Bean
    public JWTUtil jwtUtil(){
        return new JWTUtil();
    }


    @Bean
    public ApiCheckFilter apiCheckFilter(){
        return new ApiCheckFilter("/asas/**/*", jwtUtil());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
