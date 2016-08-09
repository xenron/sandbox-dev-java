package math;

public class Factorial {

  public static long declarativeFactorial(int n) {
    assert n > 0 : "Argument must be greater than 0";
    if (n == 1) return 1;
    else return n * declarativeFactorial(n-1);
  }

  public static long imperativeFactorial(int n) {
    assert n > 0 : "Argument must be greater than 0";
    long result = 1;
    for (int i = 2; i<= n; i++) {
      result *= i;
    }
    return result;
  }
}