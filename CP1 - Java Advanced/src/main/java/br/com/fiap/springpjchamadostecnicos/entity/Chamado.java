package br.com.fiap.springpjchamadostecnicos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_CHAMADO")
public class Chamado {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_CHAMADO"
    )
    @SequenceGenerator(
            name = "SQ_CHAMADO",
            sequenceName = "SQ_CHAMADO",
            allocationSize = 1
    )
    @Column(name = "ID_CHAMADO")
    private Long id;

    @Column(name = "TITULO_CHAMADO")
    private String titulo;

    @Column(name = "DESCRICAO_CHAMADO")
    private String descricao;

}
