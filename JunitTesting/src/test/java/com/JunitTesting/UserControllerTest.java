package com.JunitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.JunitTesting.controller.UserController;
import com.JunitTesting.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	
	@Mock
    private UserService mockService;

    @InjectMocks
    private UserController controller;

    @Test
    void testGetUserName_Found() {
        // Mock the service
      //  UserService mockService = mock(UserService.class);
        when(mockService.getUserName(1)).thenReturn("Alice");

        // Call method & assert
        assertEquals("Alice", controller.getUserName(1));

        // Verify interaction
        verify(mockService, times(1)).getUserName(1);
        
//        Why we use verify()?
//       In unit testing, verification ensures that your code:
//       1.  Calls the right methods
//       2.  With the right parameters
//       3.  And the correct number of times
    }

    @Test
    void testGetUserName_NotFound() {
        UserService mockService = mock(UserService.class);
        when(mockService.getUserName(2)).thenReturn("Unknown User");

        UserController controller = new UserController(mockService);

        assertEquals("Unknown User", controller.getUserName(2));

        verify(mockService, times(1)).getUserName(2);
    }
}
