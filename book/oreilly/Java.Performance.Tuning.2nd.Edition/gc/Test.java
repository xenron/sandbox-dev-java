package tuning.gc;
public class Test {
  public static void main(String[] args)
  {
    int SIZE = 4000;
    StringBuffer s;
    java.util.Vector v;

    //Create some objects so that the garbage collector 
    //has something to do
    for (int i = 0; i < SIZE; i++)
    {
      s = new StringBuffer(50);
      v = new java.util.Vector(30);
      s.append(i).append(i+1).append(i+2).append(i+3);
    }
    s = null;
    v = null;
    System.out.println("Starting explicit garbage collection");
    long time = System.currentTimeMillis();
    System.gc();
    System.out.println("Garbage collection took " + 
      (System.currentTimeMillis()-time) + " millis");

    int[] arr = new int[SIZE*10];
    //null the variable so that the array can be garbage collected
    time = System.currentTimeMillis();
    arr = null;
    System.out.println("Starting explicit garbage collection");
    System.gc();
    System.out.println("Garbage collection took " + 
      (System.currentTimeMillis()-time) + " millis");
  }
}
