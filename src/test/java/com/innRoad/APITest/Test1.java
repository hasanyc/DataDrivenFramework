package com.innRoad.APITest;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.innRoad.Base.TestBase;
import com.innRoad.Util.Constants;
import com.innRoad.Util.TestDataProvider;

public class Test1 extends TestBase{
	
	

	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public  void test1(Hashtable<String,String> table){
		APPLICATION_LOG.debug("Executing test1");

		validateRunmodes("Test1", Constants.FIRST_SUITE, table.get("Runmode"));
		
	}
	
}
