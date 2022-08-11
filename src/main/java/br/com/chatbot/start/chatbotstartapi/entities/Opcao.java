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
public class Opcao {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private Integer ordem;
    @ManyToOne
    private Pergunta proximaPergunta;
    private Integer flCondicaoParada;
    private Integer flAtivo;
    private LocalDate dataCriacao;
    private LocalDate dataDesativacao;
    @ManyToOne
    private TipoArvore tipoArvore;
    @ManyToOne
    private Pergunta perguntaPai;
    @ManyToOne
    private Solucao solucao;

}

