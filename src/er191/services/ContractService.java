package er191.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import er191.entities.Contract;
import er191.entities.Installment;

public class ContractService {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private OnlinePaymentService ops;

	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}
	
	public void processContract(Contract contract , Integer months) {
		
		Calendar cal = Calendar.getInstance();
		Date date = contract.getDate();
		cal.setTime(date);
		double value = (contract.getTotalValue() / 3);
		
		for(int i = 1; i <= months; i++) {
			
			double amount = ops.paymentFee(ops.interest(value, i));
			
			cal.add(Calendar.MONTH, 1);
			Date dueDate = cal.getTime();
			
			contract.addInstallment(new Installment(dueDate, amount));
		}
		
	}

}
