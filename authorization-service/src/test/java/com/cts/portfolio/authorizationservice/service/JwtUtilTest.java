package com.cts.portfolio.authorizationservice.service;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class JwtUtilTest {

    @Mock
    JwtUtil jwtUtil;

    @Autowired
    AuthService authService;

    private static String token = "portFolio101";

//    @Test
//    void contextLoads() {
//        assertNotNull(jwtUtil);
//    }
//
//    @Test
//    void extractUsernameTestSuccess() {
//        when(jwtUtil.validateToken(token)).thenReturn(true);
//        assertNull(jwtUtil.extractUsername(token));
//    }
//
//    @Test
//    void validateTokenTestSuccess() {
//        assertFalse(jwtUtil.validateToken(token));
//    }
//
//    @Test
//    void validateTokenTestFail() {
//        assertFalse(jwtUtil.validateToken("randomToken"));
//
//    }
    
}
