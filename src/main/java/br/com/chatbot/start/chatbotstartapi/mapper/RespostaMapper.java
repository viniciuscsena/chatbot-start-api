package br.com.chatbot.start.chatbotstartapi.mapper;

import br.com.chatbot.start.chatbotstartapi.entities.Opcao;
import br.com.chatbot.start.chatbotstartapi.entities.Pergunta;
import br.com.chatbot.start.chatbotstartapi.presenters.RespostaPresenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RespostaMapper {

    @Mapping(target = "idOpcao", source = "opcao.id")
    @Mapping(target = "descricao", source = "descricao")
    @Mapping(target = "proximaPergunta", source = "proximaPergunta.id")
    RespostaPresenter.OpcaoPresenter convertToOpcaoPresenter(Opcao opcao);

    @Mapping(target = "perguntaId", source = "pergunta.id")
    @Mapping(target = "mensagem", source = "pergunta.descricao")
    @Mapping(target = "nivelId", source = "pergunta.nivel.id")
    RespostaPresenter generateRespostaPresenter(Pergunta pergunta, List<Opcao> opcoes);

}
