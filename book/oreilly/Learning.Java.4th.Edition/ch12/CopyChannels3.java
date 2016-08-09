import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyChannels3 {
	public static void main( String [] args ) throws Exception
	{
		String fromFileName = args[0];
		String toFileName = args[1];
		FileChannel in = new FileInputStream( fromFileName ).getChannel();
		FileChannel out = new FileOutputStream( toFileName ).getChannel();
		in.transferTo( 0, (int)in.size(), out );
		in.close();
		out.close();
	}
}
