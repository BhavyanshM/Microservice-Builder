package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application{

	private Stage window;
	private Parent root;
	private Scene scene;
	private FXMLLoader loader;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		loader = new FXMLLoader();
		root = loader.load(getClass().getResource("/views/Main.fxml").openStream());
		scene = new Scene(root, 1000, 700);		
		window.setScene(scene);
		window.show();
	}
}
