package com.greatlearning.iitr.algorithmsAssignmentProblem1;
import java.util.Scanner;
//Problem1 statement
//PayMoney processes thousands of transactions daily amounting to crores of Rupees. 
//They also have a daily target that they must achieve. 
//Given a list of transactions done by PayMoney & a daily target,
//your task is to determine at which transaction PayMoney achieves the same. 
//If the target is not achievable, then display the target is not achieved.

public class Pay_Money {

		public int i,no_of_transactions, daily_target_amount, daily_target_no;
	    public static int array[];
	    public boolean status = false;
	    
	   Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		  Pay_Money paymoney = new Pay_Money();
	      paymoney.searchTarget();
		 }
	   
	public void searchTarget() {
	   System.out.println("Enter the size of transactions array");
	   no_of_transactions = sc.nextInt();
	   array = new int[no_of_transactions];

	    System.out.println("Enter the values of Transactions");
	    addTransactions();
	    printTransactions();
	    System.out.println("Enter the total number of targets that needs to be achieved");
	    daily_target_no = sc.nextInt();
	    
	    for(int i=0;i<daily_target_no;i++)
	    {
	    System.out.println("Enter the value of the target to be achieved");
	     daily_target_amount = sc.nextInt();
	     status = false;
	     searchDailyTargetValue(daily_target_amount);
	      if (status == false) {
		     System.out.println("Given target not achieved!!!");
		     return;
		     }
	     }
	    }
	    
	   
	     public void searchDailyTargetValue(int value) 
	     {
	    	
	      for (int i = 0; i < array.length; i++) {
	    	  if (array[i] >= value) {
	        	if (i==0)
	        		System.out.println("Daily Target amount "+ daily_target_amount
	      	 	          + " achieved after " + ++i +" transaction\n");
	          
	        	else 
	        		System.out.println("Daily Target amount "+ daily_target_amount
	 	          + " achieved after " + i +" transactions\n");
	         
	        status = true;
	         break;
	       }//end if stmt
	       }// end for stmt
	   }
	     
	   public void addTransactions() {
		 for (int i = 0; i < no_of_transactions; i++) {
		       	 array[i] = sc.nextInt();
		         }
		      }
		   
	  public void printTransactions() {
		  for (int i = 0; i < no_of_transactions; i++) {
		    System.out.println("Value at position " + i + " is:" + array[i]);
		    }
		   System.out.println();
		  }
	}

/* Tested on various sample data including the desired output
 * for the test cases below
TestCase 1
Enter the size of transaction array 3
Enter the values of array 20 12 31
Enter the total no of targets that needs to be achieved
2
Enter the value of target 
21
Target achieved after 2 transactions
Enter the value of target 
19 
Target achieved after 1 transactions

Explanation
Target 1 i.e 21 is achieved after 2 transactions, (20 + 12)
Target 2 i.e 19 is achieved in the 1st transaction itself. -------------------------------------------------------

case2
Enter the size of transaction array 1 
Enter the values of array 100
Enter the total no of targets that needs to be achieved 1
Enter the value of target 101 
Given target is not achieved

Explanation →
Since there is only 1 transaction that is of 100 and the target value is 101, hence target is not achieved. ------------------------------------------------------------------------------------------------------
*/
