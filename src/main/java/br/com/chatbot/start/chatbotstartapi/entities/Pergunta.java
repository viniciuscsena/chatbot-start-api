package br.com.chatbot.start.chatbotstartapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pergunta {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    @ManyToOne
    private Nivel nivel;
    private Integer flAtivo;
    private LocalDate dataCriacao;
    private LocalDate dataDesativacao;
}
