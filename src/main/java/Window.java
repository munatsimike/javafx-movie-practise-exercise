import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window {
    Stage stage;

    public Window(double width, double height, Parent parent, String title) {
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("css/style.css");
        stage = new Stage();
        stage.setTitle(title);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setScene(scene);
    }

    public Stage stage() {
        return stage;
    }
}
