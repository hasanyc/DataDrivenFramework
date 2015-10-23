package innRoad.QAApiTesting.Base;

import org.apache.log4j.Logger;
import org.testng.SkipException;

import innRoad.QAApiTesting.Util.Constants;
import innRoad.QAApiTesting.Util.Utility;
import innRoad.QAApiTesting.Util.Xls_Reader;

public class TestBase {

	//public static Properties prop;
	public static Logger APPLICATION_LOG	= Logger.getLogger("devpinoyLogger");

	//
//	public static void init(){
//		if(prop == null){
//			String path=System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
//
//			prop = new Properties();
//			try {
//				FileInputStream fs = new FileInputStream(path);
//				prop.load(fs);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}


	public static void validateRunmodes (String testName, String suiteName, String dataRunmode){
		APPLICATION_LOG.debug("Validating runmode for " +testName+" in suite "+ suiteName);
		
		// Suite Runmode
		boolean isSuiteRunmode=Utility.isSuiteRunnable(suiteName, new Xls_Reader (System.getProperty("user.dir")+"\\ExcelFiles\\Suite.xlsx"));
		// Test Runmode
		boolean isTestRunmode = Utility.isTestCaseRunnable(testName,new Xls_Reader (System.getProperty("user.dir")+"\\ExcelFiles\\"+suiteName+".xlsx"));
		boolean dataSetRunmode=false;
		if (dataRunmode.equals(Constants.RUNMODE_YES))
			dataSetRunmode=true;
		if (!(isSuiteRunmode && isTestRunmode && dataSetRunmode)){
			throw new SkipException ("Skpping the test " + testName+ " inside the suite "+suiteName);
		}
	}
}
