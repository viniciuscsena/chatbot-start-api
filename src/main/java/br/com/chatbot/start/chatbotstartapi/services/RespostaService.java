package br.com.chatbot.start.chatbotstartapi.services;

import br.com.chatbot.start.chatbotstartapi.entities.Opcao;
import br.com.chatbot.start.chatbotstartapi.entities.Pergunta;
import br.com.chatbot.start.chatbotstartapi.mapper.RespostaMapper;
import br.com.chatbot.start.chatbotstartapi.presenters.RespostaPresenter;
import br.com.chatbot.start.chatbotstartapi.repositories.OpcaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RespostaService {

    private OpcaoRepository opcaoRepository;

    private RespostaMapper respostaMapper;

    public RespostaPresenter responder(Long idOpcao) {
        //TODO: Implementar caso de primeira interação (Saudação)
        //TODO: Implementar caso de ultima opção (Solução)
        Optional<Opcao> opcao = Optional.of(opcaoRepository.getReferenceById(idOpcao));
        Pergunta proximaPergunta = opcao.get().getProximaPergunta();
        List<Opcao> opcoes = opcaoRepository.findAllByPerguntaPai(proximaPergunta);

        return respostaMapper.generateRespostaPresenter(proximaPergunta, opcoes);
    }
}
