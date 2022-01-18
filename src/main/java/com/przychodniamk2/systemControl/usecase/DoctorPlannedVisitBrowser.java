package com.przychodniamk2.systemControl.usecase;

import com.przychodniamk2.unit.business.Doctor;
import com.przychodniamk2.unit.business.ScheduledVisit;

public interface DoctorPlannedVisitBrowser {
    ScheduledVisit browseVisits(Doctor doctor);
}
