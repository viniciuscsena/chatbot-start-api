package br.com.chatbot.start.chatbotstartapi.repositories;

import br.com.chatbot.start.chatbotstartapi.entities.Opcao;
import br.com.chatbot.start.chatbotstartapi.entities.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcao, Long> {

    //    @Query(value = "select op from Opcao op where op.perguntaPai = proximaPergunta")
    List<Opcao> findAllByPerguntaPai(Pergunta proximaPergunta);
}
