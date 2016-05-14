import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
	private static InetAddress SW[];
//	private static InetAddress sw;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	SW = InetAddress.getAllByName("pi.uj.edu.pl");
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
// sw = SW[0];
for (int i = 0; i < SW.length; i++)
{
System.out.println(SW[i]);	
}

	}

}
