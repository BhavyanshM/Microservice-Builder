package controllers;

import application.FormInterfaceBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Controller {
	
//	private FXMLLoader loader;
//	private Parent root;
	
	private FormInterfaceBuilder builder;
	
	@FXML
	public BorderPane pane;
	@FXML
	public Button newButton;
	
	public Controller(){
		builder = new FormInterfaceBuilder();
	}
	
	@FXML
	public void onButtonClicked(ActionEvent event) throws Exception{
//		this.loader = new FXMLLoader();
//		this.root = loader.load(getClass().getResource("/views/Form.fxml").openStream());	
		
		newButton = (Button)event.getSource();
		pane = (BorderPane)newButton.getParent().getParent();
		StackPane newPane = new StackPane();
		
		switch(newButton.idProperty().getValue()){
			case "containerButton":
				newPane.getChildren().add(builder.getBox("container_design"));
				break;
			
			case "packagesButton":
				newPane.getChildren().add(builder.getBox("packages_design"));
				break;
		}
			
		
		pane.setCenter(newPane);
	}
}
