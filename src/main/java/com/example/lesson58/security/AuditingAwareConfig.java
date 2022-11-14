package com.example.lesson58.security;

import com.example.lesson58.entity.User;
import com.example.lesson58.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@RequiredArgsConstructor
@Configuration
public class AuditingAwareConfig {
    private final UserRepository userRepository;

    @Bean
    public AuditorAware<User> auditingAware(){
        return new AuditingAwareImpl(userRepository);
    }
}
