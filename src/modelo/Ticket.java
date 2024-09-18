package modelo;

import java.time.LocalDate;

public class Ticket {
    
    private int id_ticket;
    private Funcionario funcionario;
    private int quantidade;
    private char situacao;
    private LocalDate dataEntrega;

    public Ticket() {
    }

    public Ticket(int id_ticket, Funcionario funcionario, int quantidade, char situacao, LocalDate dataEntrega) {
        this.id_ticket = id_ticket;
        this.funcionario = funcionario;
        this.quantidade = quantidade;
        this.situacao = situacao;
        this.dataEntrega = dataEntrega;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", funcionario=" + funcionario + ", quantidade=" + quantidade + ", situacao=" + situacao + ", dataEntrega=" + dataEntrega + '}';
    }

}
