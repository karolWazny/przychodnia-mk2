package com.przychodniamk2;

import com.przychodniamk2.config.DatabaseConfig;
import com.przychodniamk2.systemControl.Database;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.net.URL;

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
        applicationContext = new SpringApplicationBuilder(App.class).child(DatabaseConfig.class).run();
        Database o = applicationContext.getBean("database", Database.class);
        o.setContext(applicationContext);

        /*Addresses address = new Addresses();
        address.setApartmentNumber((short) 3);
        address.setHouseNumber("221B");
        address.setStreet("Baker Street");
        address.setZipCode("40-543");
        address.setTown("London");
        address = applicationContext.getBean("addressRepository", AddressRepository.class).save(address);

        Personals person = new Personals();
        person.setFirstName("Frodo");
        person.setGender("2");
        person.setBirthDate(new Date(0));
        person.setPesel("00000000003");
        person.setAddressID(address.getId());
        person.setLastName("Baggins");
        o.createPatient(person);*/
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        String currentPath = System.getProperty("user.dir");
        loader.setLocation(new URL("file:///" + currentPath + "/src/main/resources/fxml/chooseDoctor.fxml"));
        AnchorPane gridPane = loader.load();

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
