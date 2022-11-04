module com.nassimlnd._2048fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.nassimlnd._2048fx to javafx.fxml;
    exports com.nassimlnd._2048fx;
}