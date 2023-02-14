package Nykaa_resources;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import Nykaa_Test._Test_Utility;

public class DataProviderClass extends _Test_Utility {

	@DataProvider()
	public Object[][] getData() throws Exception {
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\Nykaa_Project\\Nykaa_Data\\JsonData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
