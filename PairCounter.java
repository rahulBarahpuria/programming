//package random;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PairCounter {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n = sc.nextInt();
		if(n < 2 || n > 200000) {
			throw new Exception("Invalid input. Please enter n in range between [2, 200000].");
			
		}
		int arr[] = new int [n];
		System.out.println("Enter arr elements:");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < 0 || arr[i] > 1000000000) {
				throw new Exception("Invalid input. Please enter element in range between [0, 1000000000].");
			}
		}
		System.out.println("enter k:");
		int k = sc.nextInt();
		if(k < 0 || k > 1000000000) {
			throw new Exception("Invalid input. Please enter k in range between [0, 1000000000].");
		}
		List<Pair> list = new LinkedList<Pair>();
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(arr[j] - arr[i] == k) {
					Pair pair = new Pair(arr[i], arr[j]);
					list.add(pair);
				}
			}
		}
		
		List<Pair> list2 = removeDuplicatePairs(list);
		for(Pair pair : list2) {
			System.out.print("("+pair.getFirstElement()+", "+pair.getSecondElement()+")");
		}
	}
	
	public static boolean checkIsSamePair(Pair pair1, Pair pair2) {
		
		boolean isSamePair = false;
		if(pair1.getFirstElement() == pair2.getFirstElement() && pair1.getSecondElement() == pair2.getSecondElement()) {
			isSamePair = true;
		}
		return isSamePair;
	}
	
	public static List<Pair> removeDuplicatePairs(List<Pair> list) {
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = i+1; j < list.size(); j++) {
				if(checkIsSamePair(list.get(i), list.get(j))) {
					list.remove(list.get(j));
					removeDuplicatePairs(list);
				}
			}
		}
		return list;
	}

}

class Pair {


	private int firstElement;
	private int secondElement;
	public Pair(int firstElement, int secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}
	public int getFirstElement() {
		return firstElement;
	}
	public void setFirstElement(int firstElement) {
		this.firstElement = firstElement;
	}
	public int getSecondElement() {
		return secondElement;
	}
	public void setSecondElement(int secondElement) {
		this.secondElement = secondElement;
	}
	
	


}