package tuning.loop;

//import java.io.File;
import java.util.Stack;
//import java.util.LinkedList;
import java.util.Hashtable;


class StringStack
{
  String[] stack;
  int size;
  public StringStack()
  {
    stack = new String[10];
  }

  public boolean empty()
  {
    return size == 0;
  }

  public String pop()
  {
    return stack[--size];
  }

  public void push(String obj)
  {
    if (size >= stack.length)
    {
      String[] tmp = new String[2*stack.length];
      System.arraycopy(stack, 0, tmp, 0, size);
      stack = tmp;
    }
    stack[size++] = obj;
  }

}


class File
{
  static String ls = System.getProperty("file.separator");
  static Hashtable files = new Hashtable();

  public static void filebuild(String root)
  {
    java.io.File f = new java.io.File(root);
    String dir;
    String[] filelist = f.list();
    if (filelist == null)
      return;
    files.put(root, f.list());
    for (int i = filelist.length-1; i >= 0; i--)
    {
      f = new java.io.File(root, filelist[i]);
      if (f.isDirectory())
      {
//        files.put(dir = root+ls+filelist[i], f.list());
        filebuild(root+ls+filelist[i]);
      }
    }
  }

  String dir;
  public File(String dir)
  {
    this.dir = dir;
  }

  public File(String dir, String file)
  {
    this.dir = dir+ls+file;
  }

  public String[] list()
  {
    return (String[]) files.get(dir);
  }

  public boolean isDirectory()
  {
    return files.get(dir) != null;
  }

}



public class FileSearch
{
  static String ls = System.getProperty("file.separator");

  public static void filesearch1(String root, String fileEnding)
  {
    File f = new File(root);
    String[] filelist = f.list();
    if (filelist == null)
      return;
    for (int i = filelist.length-1; i >= 0; i--)
    {
      f = new File(root, filelist[i]);
      if (f.isDirectory())
        filesearch1(root+ls+filelist[i], fileEnding);
      else if(filelist[i].toUpperCase().endsWith(fileEnding))
        System.out.println(root+ls+filelist[i]);
    }
  }

  public static void filesearch2(String root, String fileEnding)
  {
    StringStack dirs = new StringStack();
    dirs.push(root);
    File f;
    int i;
    String[] filelist;
    while(!dirs.empty())
    {
      f = new File(root = dirs.pop());
      filelist = f.list();
      if (filelist == null)
        continue;
      for (i = filelist.length-1; i >= 0; i--)
      {
        f = new File(root, filelist[i]);
        if (f.isDirectory())
          dirs.push(root+ls+filelist[i]);
        else if(filelist[i].toUpperCase().endsWith(fileEnding))
          System.out.println(root+ls+filelist[i]);
      }
    }
  }

  public static void filesearch3(String root, String fileEnding)
  {
    //depth first search
    File f = new File(root);
    String[] filelist = f.list();
    if (filelist == null)
      return;
    Stack stack = new Stack();
    for (int i = filelist.length-1; i >= 0; i--)
    {
      f = new File(root, filelist[i]);
      if (f.isDirectory())
        filesearch3(root+ls+filelist[i], fileEnding);
      else if(filelist[i].toUpperCase().endsWith(fileEnding))
        stack.push(root+ls+filelist[i]);
    }
    while(!stack.empty())
      System.out.println(stack.pop());
  }
/*
  public static void filesearch4(String root, String fileEnding)
  {
    LinkedList list = new LinkedList();
    list.addLast(root);
    filesearch4(list, fileEnding);
  }
  public static void filesearch4(LinkedList list, String fileEnding)
  {
    //breadth first search
    String root = (String) list.removeFirst();
    File f = new File(root);
    String[] filelist = f.list();
    if (filelist == null)
      return;
    for (int i = filelist.length-1; i >= 0; i--)
    {
      f = new File(root, filelist[i]);
      if (f.isDirectory())
        list.addFirst(root+ls+filelist[i]);
      else if(filelist[i].toUpperCase().endsWith(fileEnding))
        System.out.println(root+ls+filelist[i]);
    }
    while(list.size() != 0)
      filesearch4(list, fileEnding);
  }
*/


  public static void main(String[] args)
  {
    String root = args[0];
    String fileEnding = args[1].toUpperCase();
    File.filebuild(root);

    System.gc();
    try{Thread.sleep(10000);}catch(Exception e){}

    long time = System.currentTimeMillis();
    for (int i = 0; i < 10; i++)
      filesearch1(root, fileEnding);
    time = System.currentTimeMillis() - time;
    System.out.println("filesearch1 took " + time);

    time = System.currentTimeMillis();
    for (int i = 0; i < 10; i++)
      filesearch2(root, fileEnding);
    time = System.currentTimeMillis() - time;
    System.out.println("filesearch2 took " + time);

    time = System.currentTimeMillis();
    for (int i = 0; i < 10; i++)
      filesearch1(root, fileEnding);
    time = System.currentTimeMillis() - time;
    System.out.println("filesearch1 took " + time);

    time = System.currentTimeMillis();
    for (int i = 0; i < 10; i++)
      filesearch2(root, fileEnding);
    time = System.currentTimeMillis() - time;
    System.out.println("filesearch2 took " + time);

    time = System.currentTimeMillis();
    for (int i = 0; i < 10; i++)
      filesearch1(root, fileEnding);
    time = System.currentTimeMillis() - time;
    System.out.println("filesearch1 took " + time);

    time = System.currentTimeMillis();
    for (int i = 0; i < 10; i++)
      filesearch2(root, fileEnding);
    time = System.currentTimeMillis() - time;
    System.out.println("filesearch2 took " + time);

 }
}