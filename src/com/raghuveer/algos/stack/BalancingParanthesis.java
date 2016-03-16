package com.raghuveer.algos.stack;

public class BalancingParanthesis {

	public static void main(String args[]) {

		Stack<Character> stack = new Stack<Character>();

		boolean check = true;

		String input = "{}()()";
		char a;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
				check = false;
			} else {
				if (stack.isEmpty()) {
					check = false;
					break;
				}
				a = stack.pop();
				if (c == '}') {
					if (a == '{') {
						check = true;
					} else {
						check = false;
						break;
					}
				}
				if (c == ']') {
					if (a == '[') {
						check = true;
					} else {
						check = false;
						break;
					}
				}
				if (c == ')') {
					if (a == '(') {
						check = true;
					} else {
						check = false;
						break;
					}
				}

			}
		}
		if (!stack.isEmpty()) {
			System.out.println("String is not balance");

		} else {
			if (check) {
				System.out.println("String is Balanced");
			} else {
				System.out.println("String is not Balanced");
			}
		}
	}
}
