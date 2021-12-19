package com.przychodniamk2.systemControl.usecase;

import com.przychodniamk2.business.Doctor;
import com.przychodniamk2.business.ScheduledVisit;

public interface DoctorPlannedVisitBrowser {
    ScheduledVisit browseVisits(Doctor doctor);
}
