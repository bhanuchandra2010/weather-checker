package com.freelance.service;

import com.freelance.config.WebClientConfig;
import com.freelance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    WebClientConfig webClient;

    @Override
    public Mono<User> getUser() {
        return webClient.webClient()
                .get()
                .header("X-Api-Key", "Uheundv4LUKaXBEjY2kCxg==zz9nfNxk3WFv2KiQ")
                .retrieve()
                .bodyToMono(User.class);
    }
}
