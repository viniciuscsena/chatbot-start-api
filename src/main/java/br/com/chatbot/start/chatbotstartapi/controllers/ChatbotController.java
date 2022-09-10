package br.com.chatbot.start.chatbotstartapi.controllers;

import br.com.chatbot.start.chatbotstartapi.presenters.RespostaPresenter;
import br.com.chatbot.start.chatbotstartapi.services.RespostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ChatbotController {

    private RespostaService respostaService;

    @GetMapping("/mensagem/{idOpcao}")
    public ResponseEntity<RespostaPresenter> processaOpcao(@PathVariable Long idOpcao) {

        return ResponseEntity.ok().body(respostaService.responder(idOpcao));
    }

    @GetMapping("/mensagem/saudacao")
    public ResponseEntity<RespostaPresenter> processaOpcao() {

        return ResponseEntity.ok(respostaService.saudacao());
    }
}
