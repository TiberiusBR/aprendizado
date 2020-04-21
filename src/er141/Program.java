package er141;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws PExceptions {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		account.withdraw(amount);
		System.out.println("New balance: " + account.getBalance());
		} catch (PExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input!");
			sc.close();
		} catch (RuntimeException e) {
			System.out.println("Unknown Error.");
			sc.close();
		}
		sc.close();
	}

}
