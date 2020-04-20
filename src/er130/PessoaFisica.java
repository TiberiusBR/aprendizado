package er130;

public class PessoaFisica extends Pessoa{
	
	public Double healthExpenses;

	public PessoaFisica() { super(); }
	
	public PessoaFisica(String name, Double income, Double healthExpenses) {
		super(name, income);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public double taxCalc() {
		
		double tax = 0;
		if (income < 20000) {
			tax += income * 0.15;
		} else {
			tax += income * 0.25;
		}
		if (healthExpenses > 0) {
			tax -= healthExpenses * 0.5;
		}
		
		return tax;
	}
	
	
}
