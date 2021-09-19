package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.Birthdate;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstNameLastname;


public class ChildAlertView {
	
	public interface ViewForFamily extends PersonFirstNameLastname {
		
	}
	
	public interface View extends  ViewForFamily, Birthdate {
		
	}
}
