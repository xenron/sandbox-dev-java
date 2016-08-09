package shapes;

import java.util.List;
import java.util.Arrays;

public class Main {

  public static double totalArea(List<Shape> shapes) {

    double result = 0;
    for(Shape s : shapes) {
      result += s.getArea();
    }

    return result;
  }

  public static void main(String args[]) {
    System.out.println(totalArea(Arrays.asList(new Circle(5), new Square(3), new Circle(4.5))));
  }
}
