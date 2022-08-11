package br.com.chatbot.start.chatbotstartapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Solucao {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    @ManyToOne
    private TipoSolucao tipoSolucao;
    private Integer flAtivo;
    private LocalDate dataCriacao;
}
