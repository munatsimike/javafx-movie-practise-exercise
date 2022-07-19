import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    ObservableList<Person> persons;

    public Database() {
        persons = FXCollections.observableArrayList();
        persons.add(new Person("Mike2", "Michael1"));
        persons.add(new Person("Mike1", "Michael6"));
    }

    public ObservableList<Person> getPersons() {
        return persons;
    }

    public void deletePerson(){
        persons.remove(1);
    }
}
