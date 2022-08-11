package br.com.chatbot.start.chatbotstartapi.controllers;

import br.com.chatbot.start.chatbotstartapi.presenters.ResponsePresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatbotController {

    @PostMapping("/mensagem")
    public ResponseEntity<List<ResponsePresenter>> processaMensagem() {

        return new ResponseEntity<List<ResponsePresenter>>(List.of(new ResponsePresenter(), new ResponsePresenter()), HttpStatus.OK);
    }
}
