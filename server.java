import java.io.*;
import java.net.*;
import java.util.Scanner;
class server
{
	public static void main(String a[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(6666);	
		Socket so;
		String str=new String();
		DataOutputStream d;	
		DataInputStream k;
		do
		{
		so=ss.accept();
		k=new DataInputStream(so.getInputStream());
		//DataOutputStream e=new DataOutputStream(so.getOutputStream());
		str=k.readUTF();
		System.out.println(str);
		//e.writeUTF(str+" returned");
		so.close();
		}while(!str.equals("close"));//first run the server and then run the client
		k.close();
		ss.close();
	
		
		
		do
		{
		so=new Socket("localhost",6667);
		d=new DataOutputStream(so.getOutputStream());	
		
		//DataOutputStream e=new DataOutputStream(s.getInputStream());
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		d.writeUTF(str);
		}while(!str.equals("close"));
		d.close();
		so.close();	
}
}
