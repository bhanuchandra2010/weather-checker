package com.freelance.service;

import com.freelance.entity.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getUser();}
