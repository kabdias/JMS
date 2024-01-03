package com.example.JMS.Controller;

import com.example.JMS.Service.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private final ConsumerService ConsumerService;

    @Autowired
    public ConsumerController(ConsumerService ConsumerService) {
        this.ConsumerService = ConsumerService;
    }

    @Operation(summary = "Consumer message Jms", description = "Service permettant de consommer les messages JMS")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Message Received ", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
            @ApiResponse(responseCode = "404", description = "Not Found - Message don't received"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
    })
    @GetMapping("/consumeMessage")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> consumeMessage() {
        String receivedMessage = ConsumerService.listener();
        return ResponseEntity.ok("Received message from the queue 'test': " + receivedMessage);
    }
}
