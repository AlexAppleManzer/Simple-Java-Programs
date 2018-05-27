import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
/*
 * Shows Distance between two draggable points
 */
public class distance extends Application {
	
	double ogX, ogY;
	static Text text = new Text();
	Circle circle1 = makeCircle(40, 40);
	Circle circle2 = makeCircle(120, 150);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Line line = new Line(40, 40, 120, 150);
			
			text.setX((circle1.getCenterX() + circle2.getCenterX()) / 2);
			text.setY((circle1.getCenterY() + circle2.getCenterY()) / 2);
			text.setFont(new Font(20));
			text.setText(Double.toString(Math.pow(Math.pow((circle1.getCenterX() - circle2.getCenterX()), 2) + Math.pow((circle1.getCenterY() - circle2.getCenterY()) , 2), (0.5))));
			line.startXProperty().bind(circle1.centerXProperty());
			line.startYProperty().bind(circle1.centerYProperty());
			line.endXProperty().bind(circle2.centerXProperty());
			line.endYProperty().bind(circle2.centerYProperty());
			line.setStrokeWidth(1);
			
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			root.getChildren().addAll(circle1, circle2, line, text);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Lab 5 Program 2");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Circle makeCircle(double x, double y) {
		
		Circle result = new Circle(10, Color.BLACK);
		result.setCursor(Cursor.HAND);
		result.setCenterX(x);
		result.setCenterY(y);
		result.setOnMousePressed((t) ->  {
			ogX = t.getSceneX();
			ogY = t.getSceneY();
		});
		
		result.setOnMouseDragged((t) -> {
			double newX = t.getSceneX() - ogX;
			double newY = t.getSceneY() - ogY;
			
			result.setCenterX(result.getCenterX() + newX);
			result.setCenterY(result.getCenterY() + newY);
			
			text.setX(text.getX() + newX / 2);
			text.setY(text.getY() + newY / 2);
			text.setText(Double.toString(Math.pow(Math.pow((circle1.getCenterX() - circle2.getCenterX()), 2) + Math.pow((circle1.getCenterY() - circle2.getCenterY()) , 2), (0.5))));
			
			ogX = t.getSceneX();
			ogY = t.getSceneY();
		});
		
		return result;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}


