package program2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class MilesKilo extends Application {
	@Override
	public void start(Stage primaryStage) {
	
		GridPane grid = new GridPane();
		grid.setVgap(4);
	    grid.setHgap(10);
		TextField mile = new TextField();
		mile.setPrefWidth(200);
		Text mileText = new Text("Miles:");
		
		TextField kilo = new TextField();
		kilo.setPrefWidth(100);
		Text kiloText = new Text("Kilometers:");
		
		grid.add(mileText, 0, 0);
		grid.add(mile, 1, 0);
		grid.add(kiloText, 0, 1);
		grid.add(kilo, 1, 1);
		
		BorderPane root = new BorderPane();
		root.setCenter(grid);
		Scene scene = new Scene(root,300,80);
		primaryStage.setScene(scene);
		
		mile.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ENTER)){
					kilo.setText(Double.toString(mileToKilo(Double.parseDouble(mile.getText()))));
				}
			}
			
		});
		kilo.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ENTER)){
					mile.setText(Double.toString(kiloToMile(Double.parseDouble(kilo.getText()))));
				}
			}
			
		});
		
		primaryStage.setTitle("Lab 6 Program 2");
		primaryStage.show();

	}
	
	public static double mileToKilo(double x) {
		return x * 1.60934;
	}
	
	public static double kiloToMile(double x) {
		return x / 1.60934;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
