package thinkInJava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.util.Random;

import Models.Student;
 
public class ioDemo {
//generate 10 numbers and write it to a text file
 /*
 * Java 的 I/O 操作类在包 java.io 下，大概有将近 80 个类，但是这些类大概可以分成四组，分别是：
    基于字节操作的 I/O 接口：InputStream 和 OutputStream
    基于字符操作的 I/O 接口：Writer 和 Reader
    基于磁盘操作的 I/O 接口：File
    基于网络操作的 I/O 接口：Socket
    inner class can not used to serialiazble to objectoutputstream
* */
	static String tmp = System.getProperty("java.io.tmpdir");
	public static void writeChar( ) throws IOException
	{
		//java.io.tmpdir 
System.out.println("java.io.tmpdir is :"+ tmp);
		String filename = "iodemo.txt";
		BufferedWriter bow = new BufferedWriter(new FileWriter(tmp + filename));
		Random rand = new Random(47);
		for (int i=0;i<100;i++)
			bow.write(rand.nextInt(100) + "\r\n");
		bow.close();
		
	}
	public static void readChar() throws IOException
	{
		String filepath = tmp + "iodemo.txt";
		BufferedReader bfr = new BufferedReader(new FileReader(filepath));
		String tmp = bfr.readLine();
		while (null != tmp){
System.out.println(tmp);
			tmp=bfr.readLine();
		}
		bfr.close();
	}
	public static void writebin() throws IOException
	{ 
		String filename = "iodemobin.txt";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tmp + filename));
		Random rand = new Random(47);
		for (int i=0;i<5;i++)
			{
				int v = rand.nextInt(100);
				bos.write(v);
System.out.println(v);
			}
			
		bos.close();
	}
	public static void readBin() throws IOException
	{
		String filename = "iodemobin.txt";
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(tmp + filename));
		while(bis.available()>0)
		{
			int x=bis.read(); 
			System.out.println(x);
		}
		bis.close();
	}
	
	public static void writeObj() throws FileNotFoundException, IOException
	{
		Student s1 =  new Student("huaxiaoyao",20);
		Student s2 =  new Student("yaoyuanye",2);
		Student s3 =  new Student("yaoshuya",18);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmp + "studentiodemo.txt"));
		oos.writeObject(s1);
		oos.writeObject(s2);
		oos.writeObject(s3);
		oos.close();
	}
	public static void readObj() throws FileNotFoundException, IOException, ClassNotFoundException
	{ 
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tmp + "studentiodemo.txt"));
		Object obj = null;
		try
		{
			while((obj=ois.readObject())!=null)
			{
				Student s = (Student) obj; 
				System.out.println(s);
			}
		}
		catch(EOFException eof)
		{}
		catch(Exception ex)
		{ex.printStackTrace();}
		ois.close();
	}
	
	static void createFolder(String dir)
	{
		File _dir = new File(dir);
		if(_dir.exists())
			return;
			else
		_dir.mkdirs();
	}
	static void delFolder(String dir)
	{
		//java won't delete folder with files in it
		//you should delete the file one by one in the folder
		File _dir = new File(dir);
		if(_dir.exists())
			_dir.delete();
		else return;
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		//writeChar();readChar();
		//writebin();readBin();	 
		//writeObj();
		//readObj();
		final String dir = "/home/student/data/test";
		createFolder(dir);
		delFolder(dir);
	}	
	
}
