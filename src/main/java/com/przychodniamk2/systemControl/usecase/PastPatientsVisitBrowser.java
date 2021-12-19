package com.przychodniamk2.systemControl.usecase;

import com.przychodniamk2.business.DoneVisit;
import com.przychodniamk2.business.Patient;

public interface PastPatientsVisitBrowser {
    void browseVisits(Patient patient);
}
