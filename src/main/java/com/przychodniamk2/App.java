package com.przychodniamk2;

import com.przychodniamk2.config.DatabaseConfig;
import com.przychodniamk2.database.User;
import com.przychodniamk2.database.orm.tables.Addresses;
import com.przychodniamk2.database.orm.tables.Personals;
import com.przychodniamk2.database.repositories.AddressRepository;
import com.przychodniamk2.systemControl.Database;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;
import java.sql.Date;

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
        person.setPesel("00000000001");
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
        loader.setLocation(new URL("file:///D:/projects/przychodnia-mk3/src/main/resources/main.fxml"));
        GridPane gridPane = loader.load();

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
