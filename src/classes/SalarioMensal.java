package classes;

import java.sql.Date;

public class SalarioMensal {
    private int id;
    private Date mes;
    private float valor,horas_trabalhadas;
    private Funcionario funcionario;

    public SalarioMensal(int id, Date mes, float valor, Funcionario funcionario) {
        this.id = id;
        this.mes = mes;
        this.valor = valor;
        this.funcionario = funcionario;
    }
    
    public SalarioMensal(int id, Date mes, float valor) {
        this.id = id;
        this.mes = mes;
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Periodo: " + mes.toString().substring(0, 7);
    }

	public float getHoras_trabalhadas() {
		return horas_trabalhadas;
	}

	public void setHoras_trabalhadas(float horas_trabalhadas) {
		this.horas_trabalhadas = horas_trabalhadas;
	}
    
    
    
}
