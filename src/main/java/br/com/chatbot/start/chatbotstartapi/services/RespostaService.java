package br.com.chatbot.start.chatbotstartapi.services;

import br.com.chatbot.start.chatbotstartapi.entities.Opcao;
import br.com.chatbot.start.chatbotstartapi.entities.Pergunta;
import br.com.chatbot.start.chatbotstartapi.mapper.RespostaMapper;
import br.com.chatbot.start.chatbotstartapi.presenters.RespostaPresenter;
import br.com.chatbot.start.chatbotstartapi.repositories.OpcaoRepository;
import br.com.chatbot.start.chatbotstartapi.repositories.PerguntaRepository;
import br.com.chatbot.start.chatbotstartapi.util.JsonUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class RespostaService {

    private OpcaoRepository opcaoRepository;

    private PerguntaRepository perguntaRepository;

    private RespostaMapper respostaMapper;

    private Logger logger;

    public RespostaPresenter responder(Long idOpcao) {
        //TODO: Implementar caso de ultima opção (Solução)
        Opcao opcao = opcaoRepository.findById(idOpcao).orElseThrow((Supplier<RuntimeException>) () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Pergunta proximaPergunta = opcao.getProximaPergunta();

        List<Opcao> opcoes = opcaoRepository.findAllByPerguntaPai(proximaPergunta);
        final RespostaPresenter respostaPresenter = respostaMapper.generateRespostaPresenter(proximaPergunta, opcoes);
        logger.info("Resposta: {} " , JsonUtil.toJson(respostaPresenter));
        return respostaPresenter;
    }

    public RespostaPresenter saudacao() {
        Optional<Pergunta> saudacaoOptional = perguntaRepository.findById(1L);
        Pergunta saudacao = saudacaoOptional.orElseThrow();

        List<Opcao> opcoes = opcaoRepository.findAllByPerguntaPai(saudacao);
        RespostaPresenter respostaPresenter = respostaMapper.generateRespostaPresenter(saudacao, opcoes);

        logger.info("Resposta: {}", JsonUtil.toJson(respostaPresenter));
        return respostaPresenter;

    }
}
