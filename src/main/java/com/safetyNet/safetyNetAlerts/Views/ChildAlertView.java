package com.safetyNet.safetyNetAlerts.Views;

import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.Birthdate;
import com.safetyNet.safetyNetAlerts.Views.MedicalRecordView.MedicalRecordfirstNameLastName;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonFirstName;
import com.safetyNet.safetyNetAlerts.Views.PersonView.PersonLastName;



public class ChildAlertView {
	
	public interface ViewForFamily extends PersonFirstName, PersonLastName {
		
	}
	
	public interface View extends  ViewForFamily,MedicalRecordfirstNameLastName,Birthdate {
		
	}
}
