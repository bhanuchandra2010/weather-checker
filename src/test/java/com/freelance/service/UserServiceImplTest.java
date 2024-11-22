package com.freelance.service;

import com.freelance.config.WebClientConfig;
import com.freelance.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceImplTest {

    @Mock
    private WebClientConfig mockWebClient;

    private UserServiceImpl userServiceImplUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        userServiceImplUnderTest = new UserServiceImpl();
        userServiceImplUnderTest.webClient = mockWebClient;
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testGetUser() {
        // Setup
        when(mockWebClient.webClient()).thenReturn(WebClient.builder().baseUrl("https://api.api-ninjas.com/v1/randomuser").build());

        // Run the test
        StepVerifier.create(userServiceImplUnderTest.getUser())
                .assertNext(user -> {
                    System.out.println("User name = "+user.getName());
                    Assert.notNull(user, "not null");
                })
                .verifyComplete();
    }
}
