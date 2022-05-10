package com.senac.starter.models;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor

public class Candidato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String dataDeNascimento;
    private String sexo;
    private String partido;
    private String numeroDoCandidato;
    private String vencedor;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario votador;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
