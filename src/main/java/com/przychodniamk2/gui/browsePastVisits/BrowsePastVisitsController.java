package com.przychodniamk2.gui.browsePastVisits;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.business.Patient;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BrowsePastVisitsController extends FXMLController<Patient> {
    private final static String fxml = "browsePastVisits.fxml";
    private ApplicationContext context;

    public BrowsePastVisitsController() {
        super(fxml);
    }

    @FXML
    ListView<DoneVisit> visitsListView;

    @FXML
    private void confirmClick(MouseEvent event){
        System.out.println(event.getClickCount());
        close();
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        Database database = context.getBean("database", Database.class);

        List<DoneVisit> visits = database.readPastVisits(getData());
        ObservableList<DoneVisit> observableList = FXCollections.observableArrayList();
        observableList.addAll(visits);
        visitsListView.setItems(observableList);
    }
}
