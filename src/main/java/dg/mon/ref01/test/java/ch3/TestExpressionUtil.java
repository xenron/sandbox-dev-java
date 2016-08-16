package ch3;

import org.junit.Assert;
import org.junit.Test;

public class TestExpressionUtil {

	private static ExpressionUtil exp = new ExpressionUtil();

	@Test
	public void testToSuffix() {
		Assert.assertEquals("[1, 1, +]", exp.toSuffix("1 + 1").toString());
		Assert.assertEquals("[1, 1, +, 2, *]", exp.toSuffix("( 1 + 1 ) * 2").toString());
		Assert.assertEquals("[1, 1, 2, *, +]", exp.toSuffix("1 + 1 * 2").toString());
		Assert.assertEquals("[4, 5, *, 1, 2, *, +, 7, -]", exp.toSuffix("( 4 * 5 ) + ( 1 * 2 ) - 7").toString());
	}

	@Test
	public void testCalcInfix() {
		Assert.assertEquals(2, exp.calcExpr("1 + 1"),0);
		Assert.assertEquals(9, exp.calcExpr("1 + 2 * 4"),0);
		Assert.assertEquals(15, exp.calcExpr("( 4 * 5 ) + ( 1 * 2 ) - 7"),0);
	}

}
