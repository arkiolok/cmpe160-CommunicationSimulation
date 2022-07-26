
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	private int minTalked;
	private int msgSent;
	private double mbUsed;
	
	
	Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID=ID;
		this.talkingCharge=talkingCharge;
		this.messageCost=messageCost;
		this.networkCharge=networkCharge;
		this.discountRate=discountRate;
		this.minTalked = 0;
		this.msgSent = 0;
		this.mbUsed = 0.0;
	}
	
	double calculateTalkingCost(int minute, Customer customer) {
		double talkingCost;

		if (customer.getAge() < 18 || customer.getAge() >65) {		
			talkingCost = minute*talkingCharge*discounter();			
		}
		else {
			talkingCost = minute*talkingCharge;	
		}
		return talkingCost;	
	}
	
	double calculateMessageCost(int quantity, Customer customer, Customer other) {
		double msgCost;
		
		if (customer.getOperator().equals(other.getOperator())) {	
			msgCost = quantity*messageCost*discounter();
		}
		else {
			msgCost = quantity*messageCost;
		}
		return msgCost;	
	}
	
	double calculateNetworkCost(double amount) {
		double networkCost;
		networkCost=amount*networkCharge;
		return networkCost;
	}
	
	void talk(int minute) {
		minTalked += minute;	
	}
	
	void message(int quantity) {
		msgSent+= quantity;		
	}
	void connection (double amount) {
		mbUsed += amount;
		
	}

	
	private double discounter() {
		return ((double) (100-discountRate))/100;
	}
	
	
	/**
	 * @return the talkingCharge
	 */
	public double getTalkingCharge() {
		return talkingCharge;
	}

	/**
	 * @param talkingCharge the talkingCharge to set
	 */
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}

	/**
	 * @return the messageCost
	 */
	public double getMessageCost() {
		return messageCost;
	}

	/**
	 * @param messageCost the messageCost to set
	 */
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}

	/**
	 * @return the networkCharge
	 */
	public double getNetworkCharge() {
		return networkCharge;
	}

	/**
	 * @param networkCharge the networkCharge to set
	 */
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}

	/**
	 * @return the discountRate
	 */
	public int getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
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

	
	

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

