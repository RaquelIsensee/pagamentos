package classes;

import java.sql.Date;

public class SalarioMensal {
    private int id;
    private Date mes;
    private float valor;
    private Funcionario funcionario;

    public SalarioMensal(int id, Date mes, float valor, Funcionario funcionario) {
        this.id = id;
        this.mes = mes;
        this.valor = valor;
        this.funcionario = funcionario;
    }

    public SalarioMensal() {
    }

    public SalarioMensal(Date mes, float valor, Funcionario funcionario) {
        this.mes = mes;
        this.valor = valor;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
}
