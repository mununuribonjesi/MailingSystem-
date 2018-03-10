import java.io.*;
import java.net.*;
import java.util.*;

public class EmailServer2
{
	
	public static void main(String[] args)throws IOException
	{
		ServerSocket serverSocket = null;
		final int PORT = 1249;
		Socket client;
		ClientHandler handler;
		int clientCount = 0;
		try
		{
			serverSocket = new ServerSocket(PORT);
		}
		
		catch (IOException ioEx)
		{
			System.out.println("\nUnable to set up port!");
			System.exit(1);
		}

		System.out.println("\nServer running...\n");

		do
		{
			//Wait for client.
			client = serverSocket.accept();
			clientCount++;
			System.out.println(clientCount + "\nNew client accepted.\n");
			handler = new ClientHandler(client,clientCount);
			handler.start();
		}
		while (true);
	}
}

		class ClientHandler extends Thread
		{
			private static 	ServerSocket serverSocket;
			private static  String CLIENT1 =null;
			private static  String CLIENT2 =null;
			private static  String CLIENT3 = null;
			private static final int MAX_MESSAGES = 10;
			private static String[] mailbox1 = new String[MAX_MESSAGES];
			private static String[] mailbox2 = new String[MAX_MESSAGES];
			private static String[] mailbox3 = new String[MAX_MESSAGES];
			private static int messagesInBox1 = 0;
			private static int messagesInBox2 = 0;
			private static int messagesInBox3 = 0;
			private Socket client;
			private Scanner input;
			private PrintWriter output;
			private int count = 0;
		
			public ClientHandler(Socket socket,int count) throws IOException
			{
				client = socket;
				this.count += count;
				input = new Scanner(client.getInputStream());
				output = new PrintWriter(client.getOutputStream(),true);
			}
		
			public void run()
			{ 	
				try 
				{
					supplyEmail();
				} catch (IOException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
			
			public void supplyEmail() throws IOException
			{
				Scanner input = new Scanner(client.getInputStream());
				PrintWriter output = new PrintWriter(client.getOutputStream(),true);
				
				String name = input.nextLine();
				String sendRead = input.nextLine();
				
				
				while (!sendRead.equals("quit"))
				{
					if (!sendRead.equals("send")
					&& !sendRead.equals("read"))
				{
					client.close();
				}
				
				System.out.println("\n"  +name+ " "+ sendRead + "ing mail...");
				
				
				if (count ==1)
				{
					CLIENT1= name;
				
					if (sendRead.equals("send"))
					{
					
						doSend(mailbox2,messagesInBox2,input);
						if (messagesInBox2<MAX_MESSAGES)
							
							messagesInBox2++;
						
					}
					else
					{
						doRead(mailbox1,messagesInBox1,output);
						messagesInBox1 = 0;
					}
				}
				
				if (count ==2)//From CLIENT2.
				{
					CLIENT2 = name;
					if (sendRead.equals("send"))
					{
						doSend(mailbox1,messagesInBox1,input);
						if (messagesInBox1<MAX_MESSAGES)
							messagesInBox1++;
					}
					else
					{
						doRead(mailbox2,messagesInBox2,output);
						messagesInBox2 = 0;
					
						
					}
				}
				
				if (count ==3)//From CLIENT2.
				{
					CLIENT2 = name;
					if (sendRead.equals("send"))
					{
						doSend(mailbox2,messagesInBox2,input);
						if (messagesInBox2<MAX_MESSAGES)
							messagesInBox2++;
					}
					else
					{
						doRead(mailbox3,messagesInBox3,output);
						messagesInBox3 = 0;
					
						
					}
				}
				

				name = input.nextLine();
				sendRead = input.nextLine();
				//Recipent = input.nextLine();
		
				
			
				}
				}
			

				private static void doSend(String[] mailbox,
							int messagesInBox, Scanner input)
				{
				//Client has requested 'sending', so server must
				//read message from this client and then place message
				//into message box for other client (if there is room).
				
				String message = input.nextLine();
				if (messagesInBox == MAX_MESSAGES)
				System.out.println("\nMessage box full!");
				else
				mailbox[messagesInBox] = message;
				}
				
				private static void doRead(String[] mailbox,
						int messagesInBox, PrintWriter output)
				{
				//Client has requested 'reading', so server must
				//read messages from this client's message box and
				//then send those messages to the client.
				
				System.out.println("\nSending "
								+ messagesInBox + " message(s).\n");
				
				output.println(messagesInBox);
				for (int i=0; i<messagesInBox; i++)
				output.println(mailbox[i]);
				}
				
				
				}
				
				

		

		
		
	
	
	
	
	



	

		
		
		
			
	