import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class MainWindow {
    VBox vBox;
    Window mainWindow;
    Database database;
    Button delete;
    TableViewBuilder tableViewBuilder;
    ObservableList<Person>persons;

    public MainWindow() {
        // build menu
        MenuBuilder menuBuilder = new MenuBuilder(dict());
        // get menubar
        MenuBar menuBar = menuBuilder.getMenuBar();
        // get table with movies
        database = new Database();
        persons = database.getPersons();
        writeToFile();
        delete = new Button("Delete");

        Label label = new Label("My movies");
        label.getStyleClass().add("white-font");
        HBox hBox = new HBox(myTableView());
        vBox = new VBox(menuBar, label, hBox, delete);
        mainWindow = new Window(1024, 800, vBox, "Movies");
        deleteHandler();

    }

    // display main window
    public void showMainWindow() {
        mainWindow.stage().show();
    }

    //  menu and menu items for the main window
    private HashMap<Menu, List<MenuItem>> dict() {
        HashMap<Menu, List<MenuItem>> myDict = new HashMap<>();
        myDict.put(new Menu("Admin"), List.of(new MenuItem("mike")));
        myDict.put(new Menu("Login"), List.of(new MenuItem("Hi"), new MenuItem("me")));
        myDict.put(new Menu("Help"), List.of(new MenuItem("Hi"), new MenuItem("me")));
        return myDict;
    }

    private void deleteHandler() {
        delete.setOnMouseClicked(e -> {
            database.deletePerson();

        });
    }

    private TableView<Person> myTableView() {

        tableViewBuilder = new TableViewBuilder();
        TableView<Person> people = tableViewBuilder.getTable();
        people.setItems(persons);
        return people;
    }

    private void writeToFile(){
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/file.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            for (Person person : persons){
                oos.writeObject(person);
            }
            // try with resources protected code
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



