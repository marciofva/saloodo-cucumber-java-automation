package com.saloodo.fixtures;

import java.util.HashMap;
import java.util.Map;

public class DataShipperDetails {
	
	public static  Map<String, String> updateWithValidData() {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("companyName", "Food Truck Express");
		 map.put("street", "Trankgasse");
		 map.put("streetNo", "11");
		 map.put("addressExtension", "Neumarkt 2");
		 map.put("postcode", "50667");
		 map.put("city", "Cologne");
		 map.put("country", "Germany");
		 map.put("vatId", "GB897602235");
		return map;
	}
}
