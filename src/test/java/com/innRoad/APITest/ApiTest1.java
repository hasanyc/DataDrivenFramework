package com.innRoad.APITest;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.innRoad.Base.TestBase;
import com.innRoad.Util.Constants;
import com.innRoad.Util.TestDataProvider;

public class ApiTest1 extends TestBase{



	@Test(dataProviderClass=TestDataProvider.class,dataProvider="APIDataProvider")
	public  void test1(Hashtable<String,String> table){
		APPLICATION_LOG.debug("Executing TestCases: ApiTest1");
		validateRunmodes("ApiTest1", Constants.API_SUITE, table.get("Runmode"));
	}

}
