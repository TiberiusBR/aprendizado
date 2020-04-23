package er183;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args)  {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		String strPath = sc.next();
		File path = new File(strPath + "\\srcfile.csv"); //E se o arquivo não existir? FileNotFoundException!
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line;
			
			while ((line = br.readLine()) != null) {
				
				String [] splitText = line.split(";");
				
				list.add(new Product(splitText[0], Double.parseDouble(splitText[1]), Integer.parseInt(splitText[2])));
				System.out.println(splitText[0] + " , " + splitText[1] + " , " + splitText[2]);
			}
			
			boolean check = new File(strPath + "\\out").mkdir();
			System.out.println("Directory created: " + check);	
			
			BufferedWriter bw = new BufferedWriter(new FileWriter((strPath + "\\out\\summary.csv") , true)); //Funciona, porém, use um try aqui. Assim ele fechará o buffer sozinho.
			
			for (Product lis : list) { //Ao usar um try, um catch pode ser colocado para indicar erro na escrita dos valores.
				bw.write(lis.getName() + ";" + lis.total());
				bw.newLine();
				System.out.println("Item added!");
			}
			bw.close(); //Fechamento manual
		}
		catch (IOException e) { 
			System.out.println("Erro na leitura/escrita.");
			e.printStackTrace(); //Erro Geral de IO
		}
		
		
		sc.close();
	}

}
