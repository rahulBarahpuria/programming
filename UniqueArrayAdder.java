//package random;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueArrayAdder {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		if(n < 1 || n > 2000) {
			throw new Exception("Cause: Invalid input. Please enter size in between range [1, 2000]");
		}
		int [] arr = new int[n];
		System.out.println("Enter elements one by one:");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < 1 || arr[i] > 3000) {
				throw new Exception("Cause: Invalid input. Please enter element in between range [1, 3000]");
			}
		}
		
		HashSet<Integer> uniqueList = new HashSet<>();
		for(int i = 0 ; i < n ; i++) {
			if(!uniqueList.add(arr[i])) {
				while(!uniqueList.add(arr[i])) {
					arr = updateDuplicates(arr, i);
				}
			}
		}
		int minSum = 0;
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			minSum += arr[i];
		}
		System.out.println("Minimum sum = " + minSum);
		
	}
	
	public static int[] updateDuplicates(int arr[], int index) {
		
		int element = arr[index];
		element++;
//		System.out.println("updating " + arr[index]);
		arr[index] = element;
		return arr;
		
	}
	

}
