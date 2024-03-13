package br.com.fiap.springpjchamadostecnicos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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


    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "SOLICITANTE",
            referencedColumnName = "ID_SOLICITANTE",
            foreignKey = @ForeignKey(
                    name = "FK_CHAMADO_SOLICITANTE"
            )
    )
    private Solicitante solicitante;

    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "TECNICO",
            referencedColumnName = "ID_TECNICO",
            foreignKey = @ForeignKey(
                    name = "FK_CHAMADO_TECNICO"
            )
    )
    private Tecnico tecnico;

    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ESPECIALIDADE",
            referencedColumnName = "ID_ESPECIALIDADE",
            foreignKey = @ForeignKey(
                    name = "FK_CHAMADO_ESPECIALIDADE"
            )
    )
    private Especialidade especialidade;

    @Column( name = "DATA_ABERTURA")
    private LocalDateTime dataAbertura;

    @Column( name = "DATA_PRIMEIRO_ATENDIMENTO")
    private LocalDateTime dataPrimeiroAtendimento;

    @Column( name = "DATA_ENCERRAMENTO")
    private LocalDateTime dataEncerramento;


}