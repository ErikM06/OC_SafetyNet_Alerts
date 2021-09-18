package com.safetyNet.safetyNetAlerts.Views;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.safetyNet.safetyNetAlerts.DTO.FireAddressDTO;
import com.safetyNet.safetyNetAlerts.models.MedicalRecord;
import com.safetyNet.safetyNetAlerts.models.View;
import com.safetyNet.safetyNetAlerts.models.View.Internal;
import com.safetyNet.safetyNetAlerts.models.View.Public;

@Component
public class FireAddressView {
	
	public interface fireAddressView extends Internal {
		
	}
	

}
