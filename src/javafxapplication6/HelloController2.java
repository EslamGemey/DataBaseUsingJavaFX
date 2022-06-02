package javafxapplication6;


import static java.lang.System.out;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HelloController2 implements Initializable{
    Connection con=DataB.connect();
    PreparedStatement ps;
    ResultSet res;
    String sqlS;
   
 
    
    @FXML
    TextField searchId;
    @FXML
    TextField id;
    @FXML
    TextField name;
    @FXML
    TextField phone;
    @FXML
    TextField email;
    @FXML
    TextField address;
    @FXML
    TextField jop;
    @FXML
    TableView<Data> table;
    @FXML
    TableColumn<Data,String> idCol;
    @FXML
    TableColumn<Data,String> nameCol;
    @FXML
    TableColumn<Data,String> emailCol;
    @FXML
    TableColumn<Data,String> addressCol;
    @FXML
    TableColumn<Data,String> phoneCol;
    @FXML
    TableColumn<Data,String> jopCol;
    
    ObservableList list=FXCollections.observableArrayList();
    
    int index;
    
     @FXML
    protected void onButtonClick(ActionEvent event) {
        
        
        
        sqlS="Insert into emp_info (`emp_id` ,`emp_name`, `emp_email`, `emp_address`, `emp_phone`,`emp_jop`) values ('"+id.getText()+"','"+name.getText()+"','"+email.getText()+"','"+ address.getText()+"','"+phone.getText()+"','"+jop.getText()+"')";
        try {
            ps=con.prepareStatement(sqlS);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Insert is Done");
            ResetData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @FXML
    protected void getSelctedRow(){
        index=table.getSelectionModel().getSelectedIndex();
        
        if(index <= -1){
            return;
        }
        
        id.setText(idCol.getCellData(index).toString());
        name.setText(nameCol.getCellData(index).toString());
        email.setText(emailCol.getCellData(index).toString());
        address.setText(addressCol.getCellData(index).toString());
        phone.setText(phoneCol.getCellData(index).toString());
        jop.setText(jopCol.getCellData(index).toString());
    }
    @FXML
    protected void onUpdateClick(ActionEvent aEvent){
        sqlS="UPDATE emp_info SET emp_name='"+name.getText()+"',emp_email='"+email.getText()+"',emp_address='"+ address.getText()+"',emp_phone='"+phone.getText()+"',emp_jop='"+jop.getText()+"' WHERE emp_id='"+id.getText()+"' ";
        try {
            ps=con.prepareStatement(sqlS);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Update is Done");
            ResetData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @FXML
    protected void onDeletClick(ActionEvent aEvent){
        
        sqlS="DELETE FROM emp_info WHERE emp_id='"+id.getText()+"' ";
        
        try {
            ps=con.prepareStatement(sqlS);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Delete is Done");
            ResetData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @FXML
    protected void onSearchClick(ActionEvent aEvent){
        if(searchId.getText().isEmpty()){
            ResetData();
        }
        else{
        list.clear();
        idCol.setCellValueFactory(new PropertyValueFactory<Data,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Data,String>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Data,String>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Data,String>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Data,String>("phon"));
        jopCol.setCellValueFactory(new PropertyValueFactory<Data,String>("jop"));
        
        sqlS="SELECT * FROM emp_info WHERE emp_id='"+searchId.getText()+"' ";
        
        try {
            ps=con.prepareStatement(sqlS);
            res=ps.executeQuery(sqlS);
            
            while (res.next()) {
                
                list.add(new Data(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
                
                    
            }
            
            //JOptionPane.showMessageDialog(null, "True");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        table.setItems(list);
        }
    }
    
    @FXML
    protected void onResetClick(ActionEvent aEvent){
        ResetData();
        /*dataTable();
        id.setText(null);
        name.setText(null);
        email.setText(null);
        address.setText(null);
        phone.setText(null);
        jop.setText(null);
        searchId.setText(null);*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        dataTable();
        /*idCol.setCellValueFactory(new PropertyValueFactory<Data,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Data,String>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Data,String>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Data,String>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Data,String>("phon"));
        jopCol.setCellValueFactory(new PropertyValueFactory<Data,String>("jop"));
        
        sqlS="SELECT * FROM emp_info";
        
        try {
            ps=con.prepareStatement(sqlS);
            res=ps.executeQuery(sqlS);
            
            while (res.next()) {
                list.add(new Data(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
                
            }
            
            JOptionPane.showMessageDialog(null, "True");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        table.setItems(list);*/
    }
    
    public void dataTable(){
        list.clear();
        idCol.setCellValueFactory(new PropertyValueFactory<Data,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Data,String>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Data,String>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Data,String>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Data,String>("phon"));
        jopCol.setCellValueFactory(new PropertyValueFactory<Data,String>("jop"));
        
        sqlS="SELECT * FROM emp_info";
        
        try {
            ps=con.prepareStatement(sqlS);
            res=ps.executeQuery(sqlS);
            
            while (res.next()) {
                
                list.add(new Data(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
                
                    
            }
            
            //JOptionPane.showMessageDialog(null, "True");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        table.setItems(list);
    }
    
    public void ResetData(){
        dataTable();
        id.setText(null);
        name.setText(null);
        email.setText(null);
        address.setText(null);
        phone.setText(null);
        jop.setText(null);
        searchId.setText(null);
    }
}