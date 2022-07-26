
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
	private int minTalked;
	private int msgSent;
	private double mbUsed; 
	
	
	Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		bill = new Bill(limitingAmount);
	}
	void talk(int minute, Customer other) {	
		minTalked += minute;
		other.minTalked += minute;
		operator.talk(minute);
		other.operator.talk(minute);
	}
	
	void message(int quantity, Customer other) {
		msgSent += quantity;
		operator.message(quantity);		
	}
	void connection(double amount) {
		mbUsed += amount;
		operator.connection(amount);		
	}
	
	
	
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}
	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	/**
	 * @return the minTalked
	 */
	public int getMinTalked() {
		return minTalked;
	}
	/**
	 * @return the msgSent
	 */
	public int getMsgSent() {
		return msgSent;
	}
	/**
	 * @return the mbUsed
	 */
	public double getMbUsed() {
		return mbUsed;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

