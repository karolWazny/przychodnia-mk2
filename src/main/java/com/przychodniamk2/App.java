package com.przychodniamk2;

import com.przychodniamk2.business.Employee;
import com.przychodniamk2.config.DatabaseConfig;
import com.przychodniamk2.config.UIConfig;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.UserInteractionController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;
import java.util.Optional;

@SpringBootApplication
public class App extends Application {
    private static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    public static ApplicationContext context(){
        return applicationContext;
    }

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(App.class).child(DatabaseConfig.class).child(UIConfig.class).run();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Employee employee = LogInDialog.logIn(applicationContext);

        if(employee == null)
            return;

        FXMLLoader loader = new FXMLLoader();
        String currentPath = System.getProperty("user.dir");
        loader.setLocation(new URL("file:///" + currentPath + "/src/main/resources/main.fxml"));
        Pane gridPane = loader.load();

        ((mainController)loader.getController()).setUserInteractionController(applicationContext.getBean("userInteractionController", UserInteractionController.class));

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        applicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }

    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
    }
}
