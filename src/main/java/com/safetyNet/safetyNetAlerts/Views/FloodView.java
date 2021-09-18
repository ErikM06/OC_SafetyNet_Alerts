package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.Birthdate;
import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.MedicationAndAllergie;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonContactDetails;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstNameLastname;


public class FloodView {
	
	public interface floodView extends PersonFirstNameLastname, PersonContactDetails, MedicationAndAllergie, Birthdate {
		
	}
}
