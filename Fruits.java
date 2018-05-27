package program4;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Fruits extends Application {
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {

		String appleURL = "http://juliandance.org/wp-content/uploads/2016/01/RedApple.jpg";
		String bananaURL = "https://images-na.ssl-images-amazon.com/images/I/71gI-IUNUkL._SL1500_.jpg";
		String orangeURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Orange-Whole-%26-Split.jpg/1024px-Orange-Whole-%26-Split.jpg";
		String watermelonURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Watermelon_cross_BNC.jpg/1024px-Watermelon_cross_BNC.jpg";
		String grapeURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Table_grapes_on_white.jpg/1024px-Table_grapes_on_white.jpg";
		ImageView image = new ImageView(new Image(appleURL));
		ComboBox cBox = new ComboBox();
		cBox.getItems().addAll(
			"Apple",
			"Banana",
			"Orange",
			"Watermelon",
			"Grape"
		);
		
		cBox.setPromptText("Fruit");
		cBox.setEditable(true);
		cBox.setOnAction((Event ev) -> {
			System.out.println(cBox.getValue());
			
			if(cBox.getValue().equals("Apple")) {
				image.setImage(new Image(appleURL));
			}
			
			if(cBox.getValue().equals("Banana")) {
				image.setImage(new Image(bananaURL));
			}

			if(cBox.getValue().equals("Orange")) {
				image.setImage(new Image(orangeURL));
			}

			if(cBox.getValue().equals("Watermelon")) {
				image.setImage(new Image(watermelonURL));
			}

			if(cBox.getValue().equals("Grape")) {
				image.setImage(new Image(grapeURL));
			}
		});
		
		Pane pane = new Pane();
		pane.getChildren().add(image);
		image.fitWidthProperty().bind(pane.widthProperty());
		image.fitHeightProperty().bind(pane.heightProperty());
		
		BorderPane root = new BorderPane();
		root.setTop(cBox);
		root.setCenter(pane);
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lab 6 Program 4");
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
