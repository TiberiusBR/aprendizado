package er191;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import er191.entities.Contract;
import er191.entities.Installment;
import er191.services.ContractService;
import er191.services.OnlinePaymentService;
import er191.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
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
			System.out.println(sdf.format(c.getDueDate()) + " - " + c.getAmount() );
		}
		
		sc.close();
		

	}

}
