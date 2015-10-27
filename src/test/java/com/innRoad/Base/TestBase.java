package com.innRoad.Base;

import org.apache.log4j.Logger;
import org.testng.SkipException;

import com.innRoad.Util.Constants;
import com.innRoad.Util.Utility;
import com.innRoad.Util.Xls_Reader;

public class TestBase {

	//public static Properties prop;
	// 
	
	public static Logger APPLICATION_LOG	= Logger.getLogger("devpinoyLogger");

	public static void validateRunmodes (String testName, String suiteName, String dataRunmode){
		APPLICATION_LOG.debug("Validating run-mode for " +testName+" in suite "+ suiteName);
		
		// Suite Run-mode
		boolean isSuiteRunmode=Utility.isSuiteRunnable(suiteName, new Xls_Reader (System.getProperty("user.dir")+"\\ExcelFiles\\Suite.xlsx"));
		// Test Run-mode
		boolean isTestRunmode = Utility.isTestCaseRunnable(testName,new Xls_Reader (System.getProperty("user.dir")+"\\ExcelFiles\\"+suiteName+".xlsx"));
		boolean dataSetRunmode=false;
		if (dataRunmode.equals(Constants.RUNMODE_YES))
			dataSetRunmode=true;
		if (!(isSuiteRunmode && isTestRunmode && dataSetRunmode)){
			throw new SkipException ("Skpping the test " + testName+ " inside the suite "+suiteName);
		}
	}
}
