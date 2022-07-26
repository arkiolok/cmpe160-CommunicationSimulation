
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

	private double limitingAmount;
	private double currentDebt;
	private double totalDebtPaid;
	
	Bill(double limitingAmount) {
		this.limitingAmount=limitingAmount;
		currentDebt=0;
	}
	
	boolean check(double amount) {
		
		return (currentDebt + amount) <= limitingAmount;
		
	}
	
	void add(double amount) {
		currentDebt += amount;  
	}
	
	void pay(double amount) {
		currentDebt -= amount;
		totalDebtPaid += amount;
		
	}
	void changeTheLimit(double amount) {
		limitingAmount = amount;
		
	}

	/**
	 * @return the limitingAmount
	 */
	public double getLimitingAmount() {
		return limitingAmount;
	}

	/**
	 * @return the currentDebt
	 */
	public double getCurrentDebt() {
		return currentDebt;
	}

	/**
	 * @return the totalDebtPaid
	 */
	public double getTotalDebtPaid() {
		return totalDebtPaid;
	}
	
	
	 

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

