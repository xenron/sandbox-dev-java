package com.bedpotato.Algorithms.C1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Evaluate {
	public static void main(String[] args) {
		String str = "(1+((2+3)*(4*5)+s(4)))";
		System.out.println(evaluate(str));
		System.out.println(evaluateMe(str));
	}

	public static final List<String> opList = new ArrayList<String>();
	static {
		opList.add("+");
		opList.add("-");
		opList.add("*");
		opList.add("/");
		opList.add("s");
	}

	public static double evaluate(String str) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		for (int i = 0; i < str.length(); i++) {
			String s = String.valueOf(str.charAt(i));
			if (s.equals("(")) {
				// do nothing
			} else if (opList.contains(s)) {
				ops.add(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				Double v = vals.pop();
				if (op.equals("s")) {
					v = calculate(op, v, 0D);
				} else {
					v = calculate(op, vals.pop(), v);
				}
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(s));
			}
		}
		return vals.pop();
	}

	public static double evaluateMe(String str) {
		Stack<String> vals = new Stack<String>();
		for (int i = 0; i < str.length(); i++) {
			String s = String.valueOf(str.charAt(i));
			if (s.equals("(")) {
				// do nothing
			} else if (s.equals(")")) {
				Double v = Double.parseDouble(vals.pop());
				String op = vals.pop();
				if (op.equals("s")) {
					v = calculate(op, v, 0D);
				} else {
					v = calculate(op, Double.parseDouble(vals.pop()), v);
				}
				vals.push(v.toString());
			} else {
				vals.push(s);
			}
		}
		return Double.parseDouble(vals.pop());
	}

	private static double calculate(String op, double v1, double v2) {
		if (op.equals("s")) {
			return Math.sqrt(v1);
		} else if (op.equals("+")) {
			return v1 + v2;
		} else if (op.equals("-")) {
			return v1 - v2;
		} else if (op.equals("*")) {
			return v1 * v2;
		} else if (op.equals("/")) {
			return v1 / v2;
		} else {
			return 0D;
		}
	}
}
