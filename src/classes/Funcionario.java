package classes;

import java.sql.Date;


public class Funcionario {
    private int id; 
    private String nome;
    private float valor_hora;
    private String cpf;
    private String rg;
    private Date data_nascimento;
    private boolean status_func;
    private String genero;

    public Funcionario(int id, String nome, float valor_hora, String cpf, String rg, Date data_nascimento, boolean status_func, String genero) {
        this.id = id;
        this.nome = nome;
        this.valor_hora = valor_hora;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.status_func = status_func;
        this.genero = genero;
    }

    public Funcionario(String nome, float valor_hora, String cpf, String rg, Date data_nascimento, boolean status_func, String genero) {
        this.nome = nome;
        this.valor_hora = valor_hora;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nascimento = data_nascimento;
        this.status_func = status_func;
        this.genero = genero;
    }

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(float valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public boolean isStatus_func() {
        return status_func;
    }

    public void setStatus_func(boolean status_func) {
        this.status_func = status_func;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "id: " + id + "| nome: " + nome + "| valor_hora: " + valor_hora;
    }
    

}
