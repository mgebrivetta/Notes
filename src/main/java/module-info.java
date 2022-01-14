module com.example.todo {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;


    opens com.example.todo to javafx.fxml;
    exports com.example.todo;
}