module com.example.proiectmip2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.proiectmip2 to javafx.fxml;
    exports com.example.proiectmip2;
}