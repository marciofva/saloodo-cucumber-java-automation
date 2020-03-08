package com.saloodo.fixtures;

import java.util.HashMap;
import java.util.Map;
import com.saloodo.common.Utils;

public class DataRegistration {
	
	
	public static  Map<String, String> addShipper() {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("companyName", "Trucker");
		 map.put("email", Utils.generateEmail());
		 map.put("firstName", "Paul");
		 map.put("lastName", "Jackson");
		 map.put("phone", "+123 908 675 90");
		 map.put("vatId", Utils.generateVATID());
		 map.put("contactByEmail", "yes");
		 map.put("TermsAndConditions", "yes");
		return map;
	}
	
	
	public static  Map<String, String> addCarrier() {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("companyName", "Deliver Express");
		 map.put("firstName", "Jhon");
		 map.put("lastName", "Victor");
		 map.put("email", Utils.generateEmail());
		 map.put("phone", "+567 78 90 667");
		 map.put("password", Utils.generatePassword());
		 map.put("contactByEmail", "yes");
		 map.put("TermsAndConditions", "yes");
		return map;
	}
}
