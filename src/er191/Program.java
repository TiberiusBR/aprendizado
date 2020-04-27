package er191;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import er191.entities.Contract;
import er191.entities.Installment;
import er191.services.ContractService;
import er191.services.PaypalService;



public class Program {
	

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		boolean cd = false;
		
		while (cd == false) {
		try {
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(contract, months);
		System.out.println();
		System.out.println("Installments:");
		
		for (Installment c: contract.getList()) {
			System.out.println(sdf.format(c.getDueDate()) + " - " + String.format("%.2f", c.getAmount()));
		}
		
		cd = true;
		sc.close();
		
		} catch (ParseException e) {
			System.out.println();
			System.out.println("Wrong date format. Please, repeat the form.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Wrong input format. Please, repeat the form.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println();
			sc.next();
		} catch (RuntimeException e) {
			System.out.println();
			System.out.println("Unknown Error. Please repeat the form.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println();
		}
	  }	
	}

}
