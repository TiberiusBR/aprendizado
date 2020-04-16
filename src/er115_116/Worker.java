package er115_116;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import er115_116.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); //N�O COLOCAR NO CONSTRUTOR, pois j� foi instanciado
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

// Esse set ir� trocar a lista j� instanciada por outra. N�o deve acontecer.
// A lista come�ar� vazia. Os valores ser�o adicionados pelas fun��es addContract e removeContract
//	public void setContracts(List<HourContract> contracts) {
//		this.contracts = contracts;
//	}
		
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) { //Calcular o  novo sal�rio com base nos contratos
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); //Inst�ncia um novo calend�rio "cal"
		for (HourContract c : contracts) { //Para todos os contratos na lista CONTRACTS...
			cal.setTime(c.getDate());  //Converte as dates do contracts para o calend�rio
			int c_year = cal.get(Calendar.YEAR); //Guarda o ano atual no c_year
			int c_month = 1 + cal.get(Calendar.MONTH); //Guarda o m�s atual no c_month + 1,pois o MONTH no calendar come�a com 00
			if (year == c_year && month ==c_month) {
				sum += c.totalValue(); //Realiza o c�lculo caso o ano e m�s do contrato sejam equivalentes ao input
			}
		}
		return sum;
	}
}
