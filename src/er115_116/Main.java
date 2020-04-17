package er115_116;

import er115_116.enums.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException { //O SimpleDateFormat requer um ParseException, caso a data não seja no formato desejado.
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		/*Instância de um novo objeto Worker. Contém o workerName, um novo WorkerLevel que usa o valor da variavel workerLevel,
		O baseSalary e uma instância do objeto Department. Uma composição do Department com Worker é feita, assim é necessário
		instanciar.*/
		Worker worker = new Worker (workerName , WorkerLevel.valueOf(workerLevel) , baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i = 1 ; i <= n ; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("DATE (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next()); //Cria uma variável do tipo DATE. O parse é utilizado para converter a string digitada em date
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); //Cria um novo HourContract chamado contrato com os valores digitados
			worker.addContract(contract); //Adiciona o contrato atual a lista de contratos do trabalhador.
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY):  ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0 , 2)); //Pega a string digitada, da posição 0 até a 2º e a transforma em int. Será pego o mês do formato MM/YYYY
		int year = Integer.parseInt(monthAndYear.substring(3)); //O mesmo de cima, mas pegará da posição 3 em diante.
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f" , worker.income(year, month)));
		
		sc.close();
	}

}
