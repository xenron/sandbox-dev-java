package ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class ExpressionUtil {

	public static void main(String[] args) {
		ExpressionUtil exp = new ExpressionUtil();
		System.out.println(exp.toSuffix("1 + 2 * 4"));
		System.out.println(exp.calcExpr("1 + 2 * 4"));

	}

	// 中缀表达式转为后缀表达式算法
	/**
	 * @param strexp
	 *            遇到数字加进到新表达式 遇到( 加到栈里面 遇到) 弹出至到栈遇到( 遇到运算符 比较里面是否已有运算符 没有加
	 *            有的话则比较优先级 如果优先级比自己低 则弹出 至到遇到优先级同等或高于的
	 * @return
	 */
	public List<String> toSuffix(String strexp) {
		List<String> lret = new ArrayList<String>();
		Stack<String> ss = new Stack<String>();
		String[] str = strexp.split("\\s+");
		for (int i = 0; i < str.length; i++) {
			if ("(".equals(str[i]))
				ss.push(str[i]);
			else if (StringUtils.isNumeric(str[i])) {
				lret.add(str[i]);
			} else if (")".equals(str[i])) {
				String item = ss.pop();
				while (!item.equals("(")) {
					lret.add(item);
					item = ss.pop();
				}
			} else { // when operator
				// compare the order of the operator
				if (!ss.isEmpty()) {
					String s = ss.pop();
					if (comparePrior(str[i], s)) {
						ss.push(s);
					} else {
						lret.add(s);
					}
				}
				ss.push(str[i]);
			}
		}

		while (!ss.isEmpty())
			lret.add(ss.pop());

		return lret;
	}

	public boolean comparePrior(String operator1, String operator2) {
		if ("(".equals(operator2)) {
			return true;
		}
		if ("*".equals(operator1) || "/".equals(operator1)) {
			if ("+".equals(operator2) || "-".equals(operator2)) {
				return true;
			}
		}
		return false;
	}

	public Integer calcExpr(String string) {
 		List<String> expr = toSuffix(string);
		Stack<Integer> nums = new Stack<Integer>();
		for (int i = 0; i < expr.size(); i++) {
			if(StringUtils.isNumeric(expr.get(i)))
				nums.push(Integer.valueOf(expr.get(i)));
			else calcS(nums,expr.get(i));
		}
		return nums.pop();
	}

	private void calcS(Stack<Integer> data, String op) {
		int op1 = data.pop();
		int op2 = data.pop();
		char x = (Character) op.charAt(0);
		if (x == '+')
			data.push(op2 + op1);
		if (x == '-')
			data.push(op2 - op1);
		if (x == '*')
			data.push(op2 * op1);
		if (x == '/')
			data.push(op2 / op1);
	}
}
