package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.Birthdate;
import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.MedicationAndAllergie;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonAddress;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonEmail;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstName;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonLastName;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonPhone;

public class PersonInfoView {
	
	public interface personInfoView extends PersonFirstName, PersonLastName, PersonAddress,  Birthdate, PersonPhone, PersonEmail, MedicationAndAllergie {
		
	}
	

}
