package modelo;

import java.time.LocalDateTime;

public class Funcionario {
    
    private int id_funcionario;
    private String nome;
    private String cpf;
    private char situacao;
    private LocalDateTime dataAlteracao;

    public Funcionario() {
    }

    public Funcionario(int id_funcionario, String nome, String cpf, char situacao, LocalDateTime dataAlteracao) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.cpf = cpf;
        this.situacao = situacao;
        this.dataAlteracao = dataAlteracao;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id_funcionario=" + id_funcionario + ", nome=" + nome + ", cpf=" + cpf + ", situacao=" + situacao + ", dataAlteracao=" + dataAlteracao + '}';
    }
    
}
