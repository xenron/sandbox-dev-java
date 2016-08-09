package tuning.io;

import java.io.*;

public class TestTraceMethodCalls
{
  public static void main(String[] args)
  {
    Runtime.getRuntime().traceMethodCalls(true);
    System.out.println("hello");
    System.out.println("hello");
  }
}