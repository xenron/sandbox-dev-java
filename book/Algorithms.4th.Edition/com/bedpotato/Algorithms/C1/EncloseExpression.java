package com.bedpotato.Algorithms.C1;

import java.util.Stack;

/**
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号后的中序表达式
 * 
 * @author 阿伦
 * 
 */
public class EncloseExpression {
	public static void main(String[] args) {
		String str = "1+2)*3-4)*5-6)))";
		System.out.println(encloseExpression(str));
	}

	public static String encloseExpression(String str) {
		Stack<String> exprStack = new Stack<String>();
		Stack<String> assistStack = new Stack<String>();
		String popch;
		int rightBrackets = 0;
		for (int i = 0; i < str.length(); i++) {
			String s = String.valueOf(str.charAt(i));
			if (s.matches("^[1-9]\\d*$")) {
				exprStack.push(s);
			} else if (!s.equals(")")) {
				exprStack.push(s);
			} else {
				assistStack.push(s);
				while (!exprStack.empty()) {
					popch = exprStack.pop();
					if (popch.equals(")")) {
						assistStack.push(popch);
						rightBrackets++;
					} else if (popch.equals("+") || popch.equals("-")) {
						assistStack.push(popch);
						if (rightBrackets == 0) {
							assistStack.push(exprStack.pop());
							assistStack.push("(");
							break;
						}
					} else if (popch.equals("(")) {
						assistStack.push(popch);
						rightBrackets--;
					} else {
						assistStack.push(popch);
					}
				}
				while (rightBrackets-- > 0) {
					assistStack.push("(");
				}
				while (!assistStack.empty()) {
					exprStack.push(assistStack.pop());
				}
			}
		}
		String expr = "";
		while (!exprStack.empty()) {
			expr = exprStack.pop() + expr;
		}
		while (rightBrackets-- > 0) {
			expr = "(" + expr;
		}
		return expr;
	}
}
