package javafxapplication6;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

public class HelloController implements Initializable {
    Connection con=DataB.connect();
    PreparedStatement ps;
    ResultSet res;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrong;
    @FXML
    private Button logBtn;
    
    

    @FXML
    protected void onHelloButtonClick(ActionEvent handler) {
        
        String sqlS="SELECT * FROM log ";
        try{
        ps=con.prepareStatement(sqlS);
        res=ps.executeQuery(sqlS);
        
        boolean her=false;
        
            while (res.next()) {
                if(username.getText().toString().equals(res.getString(2)) && password.getText().toString().equals(res.getString(3))){
                    her=true;
                    break;
                }
                
                
            }
            
            if(her){
            //wrong.setText("Succes!");
            JOptionPane.showMessageDialog(null, "Succes");
            HelloApplication a=new HelloApplication();
            a.changeScene("hello-view2.fxml");
                    
            }else{
                    
                    wrong.setText("Password or username is not valid");
                }
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}