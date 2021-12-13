package com.przychodniamk2.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Supplier;

public class ModalWindowController<C extends FXMLController<R>, R> {
    private R data;
    private final Supplier<? extends C> supplier;
    private ApplicationContext context;

    public ModalWindowController(Supplier<? extends C> supplier, ApplicationContext context){
        this.supplier = Objects.requireNonNull(supplier);
        this.context = context;
    }

    public void showStage() {
        try{
            FXMLController<R> controller = supplier.get();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.fxmlLocation());

            Pane root = loader.load();

            controller = loader.getController();
            controller.setParent(stage);
            controller.setContext(context);

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.showAndWait();

            data = (R)controller.data;
        } catch (IOException ignored){
            ignored.printStackTrace();
        }

    }

    public R getData() {
        return data;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
