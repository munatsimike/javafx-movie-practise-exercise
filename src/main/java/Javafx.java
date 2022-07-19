import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Javafx extends Application {
    Button button;
    Stage stage;
    GridPane gridPane;
    Label username;
    Label password;
    TextField usernameTextField;
    PasswordField passwordTextField;


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        button = new Button("Login");
        loginElements();
        addElementsToGrid();
        loginBtnHandler();

        Scene scene = new Scene(vBox());
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setWidth(500);
        stage.setHeight(500);
        button.setStyle("-fx-arc-height: 10 ");
        stage.show();

    }

    public ImageView imageView(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Image image = new Image(fileInputStream);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        return imageView;
    }

    public void loginBtnHandler() {
        button.setOnMouseClicked((event) -> {
            stage.hide();
            MainWindow window = new MainWindow();
            window.showMainWindow();
        });
    }

    public void loginElements(){
        button = new Button("Login");
        gridPane = new GridPane();
        username = new Label("Username");
        password = new Label("Password");
        usernameTextField = new TextField();
        passwordTextField = new PasswordField();

    }

    public void  addElementsToGrid(){
        gridPane.add(username, 0, 0);
        gridPane.add(usernameTextField, 1, 0);
        gridPane.add(password, 0, 1);
        gridPane.add(passwordTextField, 1, 1);
        gridPane.add(button, 1, 2);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    public VBox vBox() throws FileNotFoundException {
        VBox vBox = new VBox(imageView("src/main/resources/images/login.png"), gridPane);
        vBox.setStyle("-fx-background-color: #ffffff");
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
}
