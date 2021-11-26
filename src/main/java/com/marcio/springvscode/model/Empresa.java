package com.marcio.springvscode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa", schema = "edw")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Empresa(Long codigo, String nome_empresa) {
        this.codigo = codigo;
        this.nomeEmpresa = nome_empresa;
    }

    @Column(name = "CODIGO")
    private Long codigo;
    @Column(name = "NOME_EMPRESA")
    private String nomeEmpresa;

    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
