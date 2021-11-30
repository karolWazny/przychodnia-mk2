package com.przychodniamk2.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Supplier;

public class ModalWindowController<C extends FXMLController, R> {
    private R data;
    private final Supplier<? extends C> supplier;

    public ModalWindowController(Supplier<? extends C> supplier){
        this.supplier = Objects.requireNonNull(supplier);
    }

    void showStage() {
        try{
            FXMLController controller = supplier.get();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.fxmlLocation());

            Pane root = loader.load();

            controller = loader.getController();

            Scene scene = new Scene(root);
            TextField tf = new TextField();
            Button submit = new Button("Submit");

            submit.setOnAction(e -> {
                data = (R)tf.getText();
                stage.close();
            });

            root.getChildren().addAll(tf, submit);
            stage.setScene(scene);

            stage.showAndWait();

            System.out.println(controller.string);
        } catch (IOException ignored){
            ignored.printStackTrace();
        }

    }

    R getData() {
        return data;
    }
}

