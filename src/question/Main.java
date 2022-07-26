
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		
		int cID = 0;
		int cOp = 0;
		
		while(reader.hasNext()) {
			
			int currentOperation;
			currentOperation = reader.nextInt();
			
			if (currentOperation==1) {
				customers[cID] = new Customer(cID, reader.next(), reader.nextInt(), operators[reader.nextInt()], reader.nextDouble() );
				cID ++;
			}
			
			if (currentOperation==2) {
				operators[cOp]= new Operator(cOp, reader.nextDouble(), reader.nextDouble(), reader.nextDouble(), reader.nextInt());
				cOp ++;		
			}
			if (currentOperation==3) {
				int callerID = reader.nextInt();
				int calleeID = reader.nextInt();
				int callTime = reader.nextInt();
				double costOfCall = customers[callerID].getOperator().calculateTalkingCost(callTime, customers[callerID]);
				
				if ((callerID != calleeID) && customers[callerID].getBill().check(costOfCall)) {
					customers[callerID].talk(callTime, customers[calleeID] );
					customers[callerID].getBill().add(costOfCall);
				}
			}
			if (currentOperation==4) {
				int senderID = reader.nextInt();
				int recieverID = reader.nextInt();
				int quantity = reader.nextInt();
				double costOfMsg = customers[senderID].getOperator().calculateMessageCost(quantity, customers[senderID], customers[recieverID]);
				
				if (senderID != recieverID && customers[senderID].getBill().check(costOfMsg)) {
					customers[senderID].message(quantity, customers[recieverID] );
					customers[senderID].getBill().add(costOfMsg);
				}
			}
			if (currentOperation==5) {
				int customerID = reader.nextInt();
				double mbUsed = reader.nextDouble();
				double costOfInternet = customers[customerID].getOperator().calculateNetworkCost(mbUsed);
				
				if (customers[customerID].getBill().check(costOfInternet)) {
					customers[customerID].connection(mbUsed);
					customers[customerID].getBill().add(costOfInternet);
				}
			}
			if (currentOperation==6) {
				int customerID = reader.nextInt();
				double paid = reader.nextDouble();
				double currentDebt = customers[customerID].getBill().getCurrentDebt();
				
				
				if (currentDebt >= paid)
					customers[customerID].getBill().pay(paid);
				else
					customers[customerID].getBill().pay(currentDebt);
			}
			if (currentOperation==7) {
				int customerID = reader.nextInt();
				int operatorID = reader.nextInt();
				
				if (customers[customerID].getOperator() != operators[operatorID] )
					customers[customerID].setOperator(operators[operatorID]);		
			}
			if (currentOperation==8) {
				int customerID = reader.nextInt();
				double newLimitingAmount = reader.nextDouble();
				if (customers[customerID].getBill().getCurrentDebt()<=newLimitingAmount)
					customers[customerID].getBill().changeTheLimit(newLimitingAmount);	
			}
			
		}
		
		for (int i=0; i<O; i++)
			outstream1.printf("Operator %d : %d %d %.2f\n",i , operators[i].getMinTalked(), operators[i].getMsgSent(), operators[i].getMbUsed() );
		
		for (int i=0; i<C; i++)
			outstream1.printf("Customer %d : %.2f %.2f\n", i, customers[i].getBill().getTotalDebtPaid(), customers[i].getBill().getCurrentDebt() );
		
		int mostTalkedCustomerID=-1;
		int mostTalkYet = -1;
		for (int i=0; i<C; i++) {
			if (customers[i].getMinTalked() > mostTalkYet) {
				mostTalkedCustomerID=i;
				mostTalkYet = customers[i].getMinTalked();
			}	
		}
		outstream1.printf("%s : %d\n", customers[mostTalkedCustomerID].getName() ,customers[mostTalkedCustomerID].getMinTalked() );
		
		int mostMsgdCustomerID=-1;
		int mostMsgYet = -1;
		for (int i=0; i<C; i++) {
			if (customers[i].getMsgSent() > mostMsgYet) {
				mostMsgdCustomerID=i;
				mostMsgYet = customers[i].getMsgSent();
			}	
		}
		outstream1.printf("%s : %d\n", customers[mostMsgdCustomerID].getName(), customers[mostMsgdCustomerID].getMsgSent() );
		
		int mostConnectedCustomerID=-1;
		double mostMbYet = -1;
		for (int i=0; i<C; i++) {
			if (customers[i].getMbUsed() > mostMbYet) {
				mostConnectedCustomerID=i;
				mostMbYet = customers[i].getMbUsed();
			}	
		}
		outstream1.printf("%s : %.2f\n" , customers[mostConnectedCustomerID].getName(), customers[mostConnectedCustomerID].getMbUsed() );

		
		reader.close();
		outstream1.close();
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

