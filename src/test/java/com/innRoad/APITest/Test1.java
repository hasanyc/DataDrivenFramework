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
		/*
		Xls_Reader xls = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\Suite.xlsx");
		System.out.println(Utility.isSuiteRunnable("SuiteA", xls));
		System.out.println(Utility.isSuiteRunnable("SuiteB", xls));

		System.out.println(Utility.isSuiteRunnable("SuiteC", xls));
		Xls_Reader xls1 = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\SuiteA.xlsx");

		System.out.println(Utility.isTestCaseRunnable("Test1", xls1));
		*/
		validateRunmodes("Test1", Constants.FIRST_SUITE, table.get("Runmode"));
//		
//		try{
//		Assert.assertEquals("A1", "B1");
//		}catch(Throwable t){
//			ErrorUtil.addVerificationFailure(t);
//		}
//		
//		
//		try{
//			Assert.assertEquals("A2", "B2");
//			}catch(Throwable t){
//				ErrorUtil.addVerificationFailure(t);
//		}
//		
//		
//		try{
//			Assert.assertEquals("A3", "B3");
//			}catch(Throwable t){
//				ErrorUtil.addVerificationFailure(t);
//		}
//		
//		
//		Assert.assertEquals("A4", "B4");

		
	}
	
}
