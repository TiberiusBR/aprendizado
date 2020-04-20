package er130;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenses = sc.nextDouble();
				list.add(new PessoaFisica(name, income, healthExpenses));
			} else if (ch == 'c') {
				System.out.print("Number of employees: ");
				int qtdFuncionario = sc.nextInt();
				list.add(new PessoaJuridica(name, income, qtdFuncionario));
			}
		}
		
		System.out.println("TAXES PAID");
		double sum = 0;
		for (Pessoa p : list) {
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.taxCalc() ));
			sum += p.taxCalc();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum ));
		sc.close();
	}

}
