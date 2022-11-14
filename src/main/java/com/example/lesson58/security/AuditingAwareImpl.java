package com.example.lesson58.security;

import com.example.lesson58.entity.User;
import com.example.lesson58.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequiredArgsConstructor
public class AuditingAwareImpl implements AuditorAware<User> {
    private final UserRepository userRepository;
    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.ofNullable(userRepository.findByUserName(SecurityUtils.getCurrentUsername()));
    }
}
