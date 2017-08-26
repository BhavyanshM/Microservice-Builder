package controllers;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXTextField;

import application.FormInterfaceBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller {
	
	private FXMLLoader loader;
	private Parent root;
	
	private String projectName;
	
	private Gson gson;
	
	private FormInterfaceBuilder builder;
	
	@FXML
	private BorderPane pane;
	@FXML
	private JFXButton newButton;
	@FXML
	private JFXButton containerButton;
	@FXML
	private JFXButton packagesButton;
	@FXML
	private JFXButton apiButton;
	@FXML
	private JFXButton databaseButton;
	@FXML
	private JFXButton setupButton;
	@FXML
	private JFXButton designButton;
	@FXML
	private JFXButton configureButton;
	@FXML
	private JFXButton deployButton;
	@FXML
	private JFXButton clearButton;
	@FXML
	private JFXButton confirmButton;
	@FXML
	private JFXButton currentButton;
	@FXML
	private JFXTextField name;
	@FXML
	private Label projectLabel;
	
	public Controller(){
		builder = new FormInterfaceBuilder();
	}
	
	public void onConfirmClicked(ActionEvent event) throws Exception{
		this.projectName = name.getText();
		if(!this.projectName.equals("")){
			((Stage)((Button)(event.getSource())).getScene().getWindow()).close();
			System.out.print(this.projectName);
		}
	}
	
	@FXML
	public void addMicroservice(ActionEvent event) throws Exception{
		Stage stage = new Stage();
		this.loader = new FXMLLoader();
		this.root = loader.load(getClass().getResource("/views/Form.fxml").openStream());
		stage.setScene(new Scene(root));
		stage.show();
//		activateInterface();
	}
	
	@FXML
	public void onButtonClicked(ActionEvent event) throws Exception{
		newButton = (JFXButton)event.getSource();
		if(currentButton!=null)
			currentButton.setButtonType(ButtonType.FLAT);
		newButton.setButtonType(ButtonType.RAISED);
		
		if(true && currentButton!=null)
			currentButton.setDisable(true);
		
		pane = (BorderPane)newButton.getParent().getParent();
		StackPane newPane = new StackPane();
		
		switch(newButton.idProperty().getValue()){
			case "containerButton":
				newPane.getChildren().add(builder.getBox("container_design"));
				break;
			
			case "packagesButton":
				newPane.getChildren().add(builder.getBox("packages_design"));
				break;
				
			case "databaseButton":
				newPane.getChildren().add(builder.getBox("database_design"));
				break;
				
			case "apiButton":
				newPane.getChildren().add(builder.getBox("api_design"));
				break;
				
			case "setupButton":
				newPane.getChildren().add(builder.getBox("setup_design"));
				break;
		}
			
		
		pane.setCenter(newPane);
		currentButton = newButton;
	}

	public void disableInterface(){
		containerButton.setDisable(true);
		packagesButton.setDisable(true);
		apiButton.setDisable(true);
		databaseButton.setDisable(true);
		setupButton.setDisable(true);
		designButton.setDisable(true);
		configureButton.setDisable(true);
		deployButton.setDisable(true);
		clearButton.setDisable(true);
		confirmButton.setDisable(true);
	}
	
	public void activateInterface(){
		containerButton.setDisable(false);
		packagesButton.setDisable(false);
		apiButton.setDisable(false);
		databaseButton.setDisable(false);
		setupButton.setDisable(false);
		designButton.setDisable(false);
		configureButton.setDisable(false);
		deployButton.setDisable(false);
		clearButton.setDisable(false);
		confirmButton.setDisable(false);
	}
	
	
}
