package com.greatlearning.iitr.algorithmsAssignmentProblem2;
import java.util.Arrays;
import java.util.Scanner;

//Lab 2 – Algorithms Problem Statement
//You are traveling to a country where the currency denominations are unknown &
//as you travel, you get to know about the denomination in random order. 
//You want to make a payment of amount x, in such a way that the number of notes you give is minimum.
//Assume that the denominations are in such a way that any amount can be paid.
//Take input of all the currency denominations(random order)
//Take input of the amount that you want to pay.
//Output Print the minimum no of notes that you 
//will be using to pay the net amount. 

public class CurrencyDenomination {
		
	public static void main(String args[]) 
	{
		int size,i,array[],counter[], amount ;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of Currency Denominations array");
		 size = sc.nextInt();
		array = new int[size];

		System.out.println("Enter the Currency Denominations values");
		for ( i = 0; i < size; i++) {
	           array[i] = sc.nextInt();
		}
	
	 	 System.out.println("Enter the amount that you want to pay");
		 amount = sc.nextInt();
		  counter = new int[size];
		 		  
		CurrencyDenomination cd = new CurrencyDenomination();
		
		cd.mergesort(array, 0, array.length - 1);
		
		System.out.println("The denominations in sorted order"); 
		printDenominations(array);
		
		int remainingAmount = cd.countNotes(array, counter,amount);
		 
		if ( remainingAmount > 0) {
			System.out.println("remainingAmount " + remainingAmount);
			System.out.println("Amount cannot be paid in given denominations");
		    return;
		}
		
		 System.out.println("Your payment approach in order to "+
		        "give min no of notes will be  ");  
				 
		 for( i = size-1; i>=0; i--) 
		 {
		  if(counter[i]>0) 
			{
		     System.out.print(array[i]+":"+counter[i]+" ");	
		    }   
		  }// end for	
	    }//end main method
	
	
	public static int countNotes(int[] array, int[] counter, int amount)
	{   
	    for(int i = array.length-1; i>=0; i--)  
	      {
	    	if (amount >=array[i] ) {
	    	counter[i] = amount/ array[i];
	    	amount = amount % array[i];
	    	}
	       }
	    return  amount;
	}

	
	void mergesort(int arr[], int l, int r)
	{  
	   if (l < r) {
   		int m = l+ (r-l)/2; // Find the middle point
	  // Sort first and second halves & merge them
		mergesort(arr, l, m);
		mergesort(arr, m + 1, r);
        merge(arr, l, m, r);	
        }
	  }

	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;
		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];
		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
			int i = 0, j = 0;
		// Initial index of merged subarray array
			int k = l;
		while (i < n1 && j < n2) {
		 if (L[i] <= R[j]) {
			    arr[k] = L[i];
				i++;
			}
		else {
			   arr[k] = R[j];
			   j++;
			}
			   k++;
			}//end while
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
				i++;
				k++;
			}
		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}// end merge

	static void printDenominations(int arr[])
	{   // A utility function to print array of size n
			for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
			System.out.println();
	}
	
}// end Currency Denomination class

/*TestCase 1
 Enter the size of currency denominations 3
 Enter the currency denominations value 5 1 10
 Enter the amount you want to pay 12 
 Your payment approach in order to give min no of notes will be 10:1 1:2 

TestCase 2
 Enter the size of currency denominations 5 
 Enter the currency denominations value 60 5 12 78 25
 Enter the amount you want to pay 128
 Your payment approach in order to give min no of notes will be 78:1 25:2 

TestCase 3
 Enter the size of currency denominations 4 
Enter the currency denominations value 12 5 123 18 
Enter the amount you want to pay 158 
Your payment approach in order to give min no of notes will be 123:1 18:1 12:1 5:1
*/	
