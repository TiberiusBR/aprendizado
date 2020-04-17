package er115_116;

import er115_116.enums.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException { //O SimpleDateFormat requer um ParseException, caso a data n�o seja no formato desejado.
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
		
		/*Inst�ncia de um novo objeto Worker. Cont�m o workerName, um novo WorkerLevel que usa o valor da variavel workerLevel,
		O baseSalary e uma inst�ncia do objeto Department. Uma composi��o do Department com Worker � feita, assim � necess�rio
		instanciar.*/
		Worker worker = new Worker (workerName , WorkerLevel.valueOf(workerLevel) , baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i = 1 ; i <= n ; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("DATE (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next()); //Cria uma vari�vel do tipo DATE. O parse � utilizado para converter a string digitada em date
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
		int month = Integer.parseInt(monthAndYear.substring(0 , 2)); //Pega a string digitada, da posi��o 0 at� a 2� e a transforma em int. Ser� pego o m�s do formato MM/YYYY
		int year = Integer.parseInt(monthAndYear.substring(3)); //O mesmo de cima, mas pegar� da posi��o 3 em diante.
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f" , worker.income(year, month)));
		
		sc.close();
	}

}
