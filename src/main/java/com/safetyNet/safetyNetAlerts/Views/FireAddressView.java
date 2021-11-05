package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.Birthdate;
import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.MedicationAndAllergie;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonEmail;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstNameLastname;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonPhone;


public class FireAddressView {
	
	public interface fireAddressView extends PersonFirstNameLastname, PersonPhone, PersonEmail, Birthdate, MedicationAndAllergie {
		
	}
	

}
