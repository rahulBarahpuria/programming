// package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperStack {
	
	static Scanner sc = new Scanner(System.in);
	static List<Integer> stack = null;
	
	public static void main(String[] args) {

		
		System.out.println("Enter size of stack: ");
		int size = sc.nextInt();
		stack = new ArrayList<Integer>(size);
		int top = -1;
		while (true) {
			System.out.println("1. Push   2. Pop     3. Inc   0. Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			if(choice == 0) {
				break;
			}
			switch (choice) {
			case 1: {
				System.out.println("Enter element to push in stack: ");
				int element = sc.nextInt();
				top = push(stack, size, element, top);
				break;
			}
			case 2 : {
				top = pop(stack, top);
				break;
			}
			case 3 : {
				System.out.println("Enter position counting from bottom from where the elemnts to be incremented: ");
				int pos = sc.nextInt();
				System.out.println("Enter increment factor");
				int inc = sc.nextInt();
				stack = increment(stack, top, pos-1, inc);
				break;
			}
			default : {
				System.out.println("Invalid choice. Try again...");
			}
			}
			if(top >= 0) {
				System.out.println("Top element: " + stack.get(top));

			} else {
				System.out.println("Empty");
			}
		}

	}
	
	public static int push(List<Integer> stack, int size, int element, int top) {
		
		if(top < size-1) {
			top++;
			stack.add(element);
		} else {
			System.out.println("Stack overflow!");
		}
		return top;
	}
	
	public static int pop (List<Integer> stack, int top) {
		
		if(top >= 0) {
			int popout = stack.remove(top);
			
			top--;
		}
		
		return top;
	}
	
	public static List<Integer> increment(List<Integer> stack, int top, int pos, int inc) {
		
		if((pos) <= top) {
			while(pos >= 0) {
				int element = stack.remove(pos);
				element = element + inc;
				stack.add(pos, element);
				pos--;
			}
		} else {
			System.out.println("Not a valid position.");
		}
		
		return stack;
	}

}
