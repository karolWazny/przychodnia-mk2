package com.przychodniamk2.gui.browsePastVisits;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.business.Patient;
import com.przychodniamk2.gui.FXMLController;
import com.przychodniamk2.systemControl.UserInteractionController;
import com.przychodniamk2.systemControl.database.Database;
import com.przychodniamk2.systemControl.usecase.DoneVisitDisplayer;
import javafx.beans.property.ReadOnlyObjectProperty;
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
    private DoneVisitDisplayer doneVisitDisplayer;
    private DoneVisit chosenVisit;

    public BrowsePastVisitsController() {
        super(fxml);
    }

    @FXML
    ListView<DoneVisit> visitsListView;


    @FXML
    private void initialize(){
        ReadOnlyObjectProperty<DoneVisit> chosenVisitProperty = visitsListView.getSelectionModel().selectedItemProperty();
        chosenVisitProperty.addListener((observable, oldValue, newValue)->
                    chosenVisit = newValue
        );
    }

    @FXML
    private void confirmClick(MouseEvent event){
        close();
    }

    @FXML
    private void listViewClick(MouseEvent event){
        if(event.getClickCount() == 2){
            doneVisitDisplayer.display(chosenVisit);
        }
    }

    @Override
    public void setContext(ApplicationContext context) {
        this.context = context;
        Database database = context.getBean("database", Database.class);
        doneVisitDisplayer = context.getBean("doneVisitDisplayer", DoneVisitDisplayer.class);

        List<DoneVisit> visits = database.readPastVisits(getData());
        ObservableList<DoneVisit> observableList = FXCollections.observableArrayList();
        observableList.addAll(visits);
        visitsListView.setItems(observableList);
    }
}
