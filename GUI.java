
import java.io.IOException;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javafx.application.Application;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application implements EventHandler<javafx.event.ActionEvent>
{	
	
	Button inbox = new Button("Inbox");
	static ObservableList<String> mail;
	ListView<String> list = new ListView<String>();
	Button quit = new Button("Quit");
	static TextArea Body = new TextArea();
	static ListView<String> listView = new ListView<>();


	
	public static void  main (String[] args) throws IOException
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    
    {   
        Stage window;
        Button buttonA = new Button("Compose");
        inbox.resize(20, 20);
        Button sentEmail = new Button("sent Email");
        Button Drafts = new Button("Drafts");
        Button Trash = new Button("Trash");
		inbox.setMinWidth(200);
		sentEmail.setMinWidth(200);
		Drafts.setMinWidth(200);
		Trash.setMinWidth(200);
		quit.setMinWidth(200);
		buttonA.setMinWidth(200);
		HBox topMenu = new HBox();
	    window = primaryStage;
	    window.setTitle("BushCode Mail");
	    topMenu.setAlignment(Pos.TOP_CENTER);
	    VBox leftMenu = new VBox();
	    buttonA.setOnAction(e-> compose.display());
	    inbox.setOnAction(this);
	    quit.setOnAction(this);
	    listView.getSelectionModel()
	    .setSelectionMode(SelectionMode.MULTIPLE);
	    listView.setMaxSize(300, 170);
	    leftMenu.getChildren()
	    .addAll(buttonA,inbox,sentEmail,Drafts,Trash,quit);
	    topMenu.getChildren().addAll(listView);
	    leftMenu.setSpacing(5);
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(topMenu);
	    borderPane.setLeft(leftMenu);
	    Scene scene = new Scene(borderPane,600,200);
	    window.setScene(scene);
	    window.show();
    }
   
   public void handle(javafx.event.ActionEvent event) 
   {
       	if(event.getSource()==inbox)
        {
    	   		try {
    	   				useEmail();
    	   			} 
    	   		catch (IOException e) 
    	   			{
			// TODO Auto-generated catch block
    	   			e.printStackTrace();
    	   			}
        	}
       
       if(event.getSource()==quit)
          {
    	   		try {
    	   				useEmail3();
    	   			} 
    	   		catch (IOException e) 
    	   			{
			// TODO Auto-generated catch block
			e.printStackTrace();
    	   			}
          }
    }
   

   private static void useEmail() throws IOException
	{
	   doRead();
	}

   protected static void useEmail2() throws IOException
	{
	   doSend();
	}
   
   protected static void useEmail3() throws IOException
	{
		
		quit();
	}


   private static void doSend() 
	{

		String message = compose.Body.getText();
		String message2 = compose.Recipent.getText();
		//Login.networkOutput.println(message2);
		Login.networkOutput.println(Login.name);
	

		Login.networkOutput.println("send");

		Login.networkOutput.println(message);

	
		
	}
   


   private static void doRead()
	{  
	   	Login.networkOutput.println(Login.name);
	   	Login.networkOutput.println("read");
		int count = Login.networkInput.nextInt();
		Login.networkInput.nextLine();
		

		if (count == 0)
		{   
			listView.getItems().clear();
			listView.getItems().add("\nMailbox empty.\n");
			return;
		}
     
		if (count > 0)
		{
			listView.getItems().clear();
		}
		
		System.out.println("\nMessages...\n");
		String message;
		
		for (int i=0; i<count; i++)
		{
			message = Login.networkInput.nextLine();
			listView.getItems().add((i+1) +":"+ message);
		}
	}
   
   private static void quit()
	{  
	String message = compose.Body.getText();
	Login.networkOutput.println(Login.name);
	Login.networkOutput.println("quit");
	Login.networkOutput.println(message);
	System.exit(1);
	   
	}
}
   

	       
	   
	     
	      
	        
	     
	        

	        
	        
        
 
        
       
  
   
   
	       
	                
	                
    	     
 

    	     
    	        
    	                
    	                
    	     
    	        

  