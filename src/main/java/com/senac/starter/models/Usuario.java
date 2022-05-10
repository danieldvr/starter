package com.senac.starter.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cep;
    private String cidade;
    private String dataDeNascimento;
    private String estadoCivil;
    private String estado;
    private String sexo;
    private String rg;


    @OneToMany(mappedBy = "vencedor", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Candidato> candidatos;

    private int idade;
    private boolean casado;

    public Usuario(String nome, int idade, boolean casado) {
        this.nome = nome;
        this.idade = idade;
        this.casado = casado;
    }
}
