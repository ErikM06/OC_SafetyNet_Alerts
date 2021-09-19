package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonAddress;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonContactDetails;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstNameLastname;

public class FirestationNumberView {
	
	public interface numberChildAndAdults {
		
	}
	 public interface personInfoView extends numberChildAndAdults, PersonFirstNameLastname, PersonAddress, PersonContactDetails {
		 
	 }
}
