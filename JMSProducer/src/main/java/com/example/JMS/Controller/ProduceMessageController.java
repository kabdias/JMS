package com.example.JMS.Controller;

import com.example.JMS.Service.SendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProduceMessageController {


    @Autowired
    private SendService sendService;


    @Operation(summary = "Send message Jms", description = "Service permettant d'envoyer des JMS")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Message send ", content = {@io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "403", description = "Forbidden - Accès interdit"),
            @ApiResponse(responseCode = "404", description = "Not Found - Ajout non éffectué"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Erreur interne du serveur")
    })
    @GetMapping("send/{name}")
    public String sendName(@PathVariable("name") String name){

        sendService.sendName(name);
        return name;
    }
}