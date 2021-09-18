package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.birthdate;
import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.medicationAndAllergie;
import com.safetyNet.safetyNetAlerts.Views.PersonView.personContactDetails;
import com.safetyNet.safetyNetAlerts.Views.PersonView.personFirstNameLastname;


public class FloodView {
	
	public interface floodView extends personFirstNameLastname, personContactDetails, medicationAndAllergie, birthdate {
		
	}
}
