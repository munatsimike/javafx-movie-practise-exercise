import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewBuilder {
    TableView<Person> tableView;
    public TableViewBuilder() {
        tableView = new TableView<>();

        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        assert false;
        tableView.getColumns().add(firstNameColumn);
        tableView.getColumns().add(lastNameColumn);
    }

    public TableView<Person> getTable() {
        return tableView;
    }


}
