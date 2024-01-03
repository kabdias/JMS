//package com.example.JMS.Service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jms.core.JmsTemplate;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.doThrow;
//
//
//@SpringBootTest
//public class ConsumerServiceTest {
//
//    @Mock
//    private JmsTemplate jmsTemplate;
//
//    @InjectMocks
//    private ConsumerService consumerService;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);  // Assurez-vous que Mockito initialise correctement les mocks
//    }
//
//    @Test
//    public void listener_ProcessMessage() {
//        String name = "John";
//        consumerService.listener(name);
//    }
//
//    @Test
//    public void listener_ErrorHandling() {
//        // Arrange
//        String name = "John";
//        doThrow(new IllegalArgumentException("Simulated error")).when(jmsTemplate).convertAndSend("test", name);
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> consumerService.listener(name));
//    }
//}