package br.com.chatbot.start.chatbotstartapi.mapper;

import br.com.chatbot.start.chatbotstartapi.entities.Opcao;
import br.com.chatbot.start.chatbotstartapi.entities.Pergunta;
import br.com.chatbot.start.chatbotstartapi.presenters.ResponsePresenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ResponseMapper {

    @Mapping(target = "idOpcao", source = "opcao.id")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "proximaPergunta", source = "proximaPergunta.id")
    ResponsePresenter.OpcaoPresenter convertToOpcaoPresenter(Opcao opcao);

    @Mapping(target = "perguntaId", source = "pergunta.id")
    @Mapping(target = "mensagem", source = "pergunta.descricao")
    @Mapping(target = "nivelId", source = "pergunta.nivel.id")
    ResponsePresenter generateResponsePresenter(Pergunta pergunta, List<Opcao> opcoes);

}
