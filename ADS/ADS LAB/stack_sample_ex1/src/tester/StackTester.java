package tester;

import java.util.Scanner;

import core.StackOperation;

public class StackTester {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			StackOperation stack = new StackOperation();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Stack operations\n1. Push\n2. Pop\n"
							+ "3. Top\n4. GetMax\n5. DisplayAll\n0. Exit");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter element to push: ");
						stack.push(sc.nextInt());
						break;
					case 2:
						System.out.println("POP...");
						stack.pop();
						break;
					case 3:
						System.out.println("TOP: ");
						stack.top();
						break;
					case 4:
						System.out.println("Get Max: ");
						System.out.println("Max ele:  "+stack.getMax());
						break;
					case 5:
						System.out.println("Stack: ");
						stack.displayStack();
						break;
					case 0:
						System.out.println("exit...");
						exit = true;
						break;
					default:
						System.out.println("Invalid option...");
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}
	}
}
