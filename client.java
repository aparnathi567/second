import java.io.*;
import java.net.*;
import java.util.Scanner;
class client
{
	public static void main(String a[]) throws Exception
	{
		Socket s;
		ServerSocket ss=new ServerSocket(6667);	
			DataInputStream d;
			DataOutputStream k;
			String str=new String();
			
			do
			{
			s=new Socket("localhost",6666);
			k=new DataOutputStream(s.getOutputStream());
			//DataOutputStream e=new DataOutputStream(s.getInputStream());
			Scanner sc=new Scanner(System.in);
			str=sc.nextLine();
			k.writeUTF(str);
			k.close();
			}while(!str.equals("close"));
			s.close();
		
	
		do
		{
		s=ss.accept();
		d=new DataInputStream(s.getInputStream());
		//DataOutputStream e=new DataOutputStream(so.getOutputStream());
		str=d.readUTF();
		System.out.println(str);
		//e.writeUTF(str+" returned");
		s.close();
		}while(!str.equals("close"));//first run the server and then run the client
		ss.close();
	}
}