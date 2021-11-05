package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonEmail;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstNameLastname;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonPhone;


public class PhoneAddressView {
	
	public interface PhoneAddressViewForPerson extends PersonFirstNameLastname, PersonPhone, PersonEmail {
		
	}

	
	
}
