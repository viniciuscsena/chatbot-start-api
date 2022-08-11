package br.com.chatbot.start.chatbotstartapi.presenters;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponsePresenter {

    Long perguntaId;
    String mensagem;
    Long nivelId;

    List<OpcaoPresenter> opcoes;

    @Getter
    @Setter
    public static class OpcaoPresenter {
        Long idOpcao;
        String descricao;
        Long proximaPergunta;
    }
}
