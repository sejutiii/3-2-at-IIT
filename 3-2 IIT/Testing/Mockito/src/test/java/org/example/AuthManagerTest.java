package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.SmartNullPointerException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthManagerTest {

    AuthManager authManager;

    @Mock
    UserRepository userRepositoryMock;

    @Mock
    HashLibrary hashLibraryMock;

    String email= "hello@mail";
    String password= "pass";
    String hashedPassword= "pass123";
    String falseEmail= "fake@mail";

    @BeforeEach
    public void setUp(){
        authManager= new AuthManager(userRepositoryMock, hashLibraryMock);
        User user = new User(email, password);
        lenient().when (hashLibraryMock.getHash(password)).thenReturn(hashedPassword);
        lenient().when (userRepositoryMock.findByEmail(email)).thenReturn(user);
    }

    @Test
    void testLoginSuccessful() {
        assertTrue(authManager.login(email, password));
    }

    @Test
    void testLoginNotSuccessful()
    {
        assertFalse(authManager.login(email, "FakePass"));
    }

    @Test
    void testUserNotFound()
    {
        when(userRepositoryMock.findByEmail(falseEmail)).thenThrow(new NullPointerException("null"));
        assertThrows(NullPointerException.class, ()-> authManager.login(falseEmail, "udhwu"));
    }
}