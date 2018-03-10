
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.stage.Modality;
import javafx.stage.Stage;


public class compose 
{        
    
	static Button Compose = new Button("Send");
	static TextField Recipent = new TextField("");
	static TextField Subject = new TextField("");
	static TextArea Body = new TextArea();
	static String banks;
	
	public static void display()
    
    {
		Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(350);
        
        Compose.setOnAction(new EventHandler<ActionEvent>()
        {
        	   public void handle(ActionEvent event)
        	   {  
        		   if(event.getSource()==Compose)
        			{
        			   try 
        			   	{  
        				   GUI.useEmail2();
	        		 	   window.close();
	        		 	   	Recipent = new TextField();
    		 	   			Subject = new TextField();
    		 	   	        Body = new TextArea();
        			   	} 
        		 	   	catch (IOException e) 
        		 	   	{
        					// TODO Auto-generated catch block
        		 	   			e.printStackTrace();
        		 	   	}
        			}}
        	});
        
        Recipent.setMaxWidth(500);
        Subject.setMaxWidth(500);
        Body.setMaxWidth(500);
        Body.setMinHeight(300);
        Recipent.setPromptText("Recipent");
        Subject.setPromptText("Subject");
        window.setTitle("New Email");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(Recipent,Subject,Body,Compose);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,500,500);
        window.setScene(scene);
        window.showAndWait();
       	}
    



        
} 
        
      
        
        

    
    
    

   
    
    

    
    




