
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Login extends Application implements EventHandler<javafx.event.ActionEvent>

{
    protected static InetAddress host;
    protected static String name;
    protected static Scanner networkInput, userEntry;
    protected static PrintWriter networkOutput;
    Button Compose = new Button("Login");
    static TextField Login = new TextField("");
    static PasswordField Password = new PasswordField();
    static String ame;
    String entry;
	final int PORT = 1249;
	protected static Socket socket; 
    
    public static void  main (String[] args) throws IOException 
    {
        launch(args);
    }
    
    
    public void start(Stage primaryStage) throws Exception
    {   
    	 	Stage window = new Stage();
         window.initModality(Modality.APPLICATION_MODAL);
         window.setMinWidth(350);
         Login.setPromptText("username");
         Password.setPromptText("Password");
         Login.setMaxWidth(200);
         Password.setMaxWidth(200);
         window.setTitle("Sign In");
         VBox layout = new VBox(10);
         layout.getChildren().addAll(Login,Password,Compose);
         layout.setAlignment(Pos.CENTER);
         Compose.setOnAction(this);
         Scene scene2 = new Scene(layout,500,500);
         window.setScene(scene2);
         window.showAndWait();
      }
    

    @Override
    public void handle(javafx.event.ActionEvent event)
    {
        if(event.getSource()==Compose)
            
        {
            ame = Login.getText();
            entry = Password.getText(); 
            Stage primaryStage = new Stage();
            System.out.println(entry);
            GUI gui = new GUI();
            name = ame;
            System.out.print("welcome" + ame);
          
            try
            {
                gui.start(primaryStage);
            }
            catch (Exception e)
            {
             
                e.printStackTrace();
            }
            
            try
            {
                host = InetAddress.getLocalHost();
                try {
					socket = new Socket(host,PORT);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            		try {
						networkInput = new Scanner(socket.getInputStream());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		try {
						networkOutput = new PrintWriter(socket.getOutputStream(),true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                
            
            }
            catch(UnknownHostException e)
            {
                System.out.println("Host ID not found!");
                System.exit(1);
            }
         }
    }






}
    
    

    




   
    

    



 
    
