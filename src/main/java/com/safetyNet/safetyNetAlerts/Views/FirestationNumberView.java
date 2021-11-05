package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonAddress;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonEmail;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstNameLastname;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonPhone;

public class FirestationNumberView {
	
	public interface numberChildAndAdults {
		
	}
	 public interface personInfoView extends numberChildAndAdults, PersonFirstNameLastname, PersonAddress, PersonPhone, PersonEmail {
		 
	 }
}
