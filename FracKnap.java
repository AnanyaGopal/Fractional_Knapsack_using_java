import java.util.Scanner;
import java.util.TreeMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class FracKnap {
	//The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
	 // This map stores unsorted values
    static Map<Double, Integer> rawdata = new HashMap<>();
    // TreeMap to store values of HashMap
    static TreeMap<Double, Integer> sorted = new TreeMap<>(Collections.reverseOrder());
    
    private static double getOptimalValue(int capacity, int[] values, int[] weights, double[] fraction) {
    int  wei = 0;
    sortbykey();
    
    double total_Val = 0.0;
    for (Map.Entry<Double, Integer> entry : sorted.entrySet()) 
    {
    		if(wei<capacity){
    			System.out.println("Adding weights to knapsack......");
    			if(weights[entry.getValue()] > (capacity-wei))
    			{	
    				weights[entry.getValue()] = capacity-wei;
    				
    			}
    			System.out.println("Added "+weights[entry.getValue()]);
    			wei += weights[entry.getValue()];
    			
    			
    			total_Val += weights[entry.getValue()]*fraction[entry.getValue()];
    			
    			//System.out.println(wei + "-"+total_Val+ "-"+capacity);
    			
    		}
    }
     
   
        return total_Val;
    }

    public static void main(String args[]) {
        boolean tag = true;
		Scanner scanner = new Scanner(System.in);
		
		
		//The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack.
        // Number of Items
		System.out.println("Enter the number of Items you have:");
		int n = scanner.nextInt();
		
		System.out.println("Enter the total capacity of your knapsack:");
		// Capacity of the KS
		int capacity = scanner.nextInt();
		
		
		
			int[] values = new int[n];
			int[] weights = new int[n];
			double[] fraction = new double[n];

			for (int i = 0; i < n; i++) {
				System.out.println("Enter "+ (i+1) +" value and weights separated by space (For example: 50 10): ");
				values[i] = scanner.nextInt();
				weights[i] = scanner.nextInt();
				if(weights[i] !=0){
					
					fraction[i] = (double)values[i]/weights[i];
					  // putting values in the Map - with value per unit and index. We use this index to later map out the weight and value.
			        rawdata.put(fraction[i],i);
			    
				}
				//if(values[i]<0 || values[i]>2000001 || weights[i]<0 || weights[i]>2000001)
					//break;//System.out.println("Value/Weight exceeded");
				
			}
			scanner.close();
			// Check values once
			for (int i = 0; i < n; i++) {
				
				if(values[i]<0 || values[i]>2000001 || weights[i]<0 || weights[i]>2000001){
				 tag = false;	
				 break;//System.out.println("Value/Weight exceeded");
			}
				
			
			}
			
			if(tag)
				System.out.println("Total Value of knapsack is now " +getOptimalValue(capacity, values, weights,fraction));
			
			
    }
    
    public static void sortbykey()
    {
        // Copy all data from hashMap into TreeMap
        sorted.putAll(rawdata);
   	
    }
     
} 
