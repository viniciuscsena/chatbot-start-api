package br.com.chatbot.start.chatbotstartapi.repositories;

import br.com.chatbot.start.chatbotstartapi.entities.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
