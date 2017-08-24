package application;

import java.util.ArrayList;

import com.jfoenix.controls.JFXTextField;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormInterfaceBuilder {
	private ArrayList<Form> forms;
	private Form form;
	
	public FormInterfaceBuilder(){
		forms = new ArrayList<Form>();
		
		form = new Form(Form.idOne++, "container_design");
		form.addKey("Container Name");
		form.addKey("Base Image");
		forms.add(form);
		
		form = new Form(Form.idOne++, "packages_design");
		form.addKey("Repository Name");
		form.addKey("Package Name");
		forms.add(form);
	}
	
	public VBox getBox(String name){
		VBox box = new VBox();
		VBox.setMargin(box , new Insets(100, 100, 100, 100));
		box.setPadding(new Insets(40, 40, 40, 40));
		for(Form form : this.forms){
			if(form.getName().equals(name)){
				for(Key key : form.keys){
					JFXTextField field = new JFXTextField();
					field.setPromptText(key.getKey());
					field.setLabelFloat(true);
					HBox hbox = new HBox(field);
					VBox.setMargin(hbox, new Insets(10, 10, 10, 10));
					box.getChildren().add(hbox);
				}
			}
		}
		
		box.setSpacing(10);
		
		return box;
	}
}
