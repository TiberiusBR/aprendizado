package er130;

public class PessoaJuridica extends Pessoa{
	
	private Integer qtdFuncionario;
	
	public PessoaJuridica() { super(); }

	public PessoaJuridica(String name, Double income, Integer qtdFuncionario) {
		super(name, income);
		this.qtdFuncionario = qtdFuncionario;
	}

	public Integer getQtdFuncionario() {
		return qtdFuncionario;
	}

	public void setQtdFuncionario(Integer qtdFuncionario) {
		this.qtdFuncionario = qtdFuncionario;
	}

	@Override
	public double taxCalc() {
		double total = 0;
		if (qtdFuncionario > 10) {
			total += income * 0.14;
		} else {
			total += income * 0.16;
		}
		return total;
	}

}
