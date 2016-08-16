package ch13.NioSample;

import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadWriteDemo {
	
	public void writeMappedByteDemo(String filePath) throws IOException{
	 final int start = 0;  
     final int size = 1024;  
	 RandomAccessFile raf = new RandomAccessFile(filePath, "rw" );  
     FileChannel fc = raf.getChannel();  
       
     MappedByteBuffer mbb = fc.map( FileChannel.MapMode.READ_WRITE,start, size );
     mbb.put( 0, (byte)97 );  
     mbb.put( 1023, (byte)122 );    
     raf.close();  
	}

	public void readDemo(String filePath) throws IOException {
		FileInputStream fin = new FileInputStream(filePath); 
		// 获取通道
		FileChannel fc = fin.getChannel(); 
		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024); 
		// 读取数据到缓冲区
		fc.read(buffer); 
		buffer.flip(); 
		while (buffer.remaining() > 0) {
			byte b = buffer.get();
			System.out.print(((char) b));
		} 
		fin.close();
	}

	public void writeTest(String filePath) throws IOException {
		FileOutputStream fout = new FileOutputStream(filePath);
		FileChannel fc = fout.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		for (int i = 0; i < message.length; ++i) {
			buffer.put(message[i]);
		}

		buffer.flip();
		fc.write(buffer);
		fout.close();
	}

	static private final byte message[] = "Hello nio Hello java Hello world"
			.getBytes();

	static public void main(String args[]) {
		String filePath = "/tmp/testnio.txt";
		FileChannelReadWriteDemo demo = new FileChannelReadWriteDemo();
		try{
		demo.writeTest(filePath);
		demo.readDemo(filePath);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
