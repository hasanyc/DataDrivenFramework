package com.innRoad.Base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import com.innRoad.Util.AllGetterSetter;
import com.innRoad.Util.Constants;
import com.innRoad.Util.Utility;
import com.innRoad.Util.Xls_Reader;

public class TestBase {

	//public static Properties prop;

	public static Logger APPLICATION_LOG	= Logger.getLogger("devpinoyLogger");
	public static String BaseURL;
	public static int Port;
	public static AllGetterSetter testConf;

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
	
	 public static void suiteInitialize() throws IOException {
		 
	        BasicConfigurator.configure();
	        // loading all the configurations from a property file
	        APPLICATION_LOG.debug("Starting the test suite");
	        System.out.println("Working Directory= " + System.getProperty("user.dir"));
	        BaseURL=testConf.getBaseURL();
	        Port=testConf.getPort();
	    }
	 
	 
	 public static List<AllGetterSetter> loadTestConfig(String sendInfoFile)throws IOException {
	        BufferedReader br = null;
	        String line = "";
	        List<AllGetterSetter> sendInfo = new ArrayList<AllGetterSetter>();
	        try {
	            br = new BufferedReader(new FileReader(sendInfoFile));
	            br.readLine();
	            while ((line = br.readLine()) != null) {
	                // split on comma(','). Exclude the commas in double quotes.
	                String[] testRequestArray = line
	                        .split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
	                AllGetterSetter testRequest = new AllGetterSetter();
	                // add values from csv 
	                testRequest.setTestID(Long.parseLong(testRequestArray[0]));
	                testRequest.setBaseURL(testRequestArray[1]);
	                testRequest.setPort(Integer.parseInt(testRequestArray[2]));
	                testRequest.setMethod(testRequestArray[3]);
	                testRequest.setEndpoint(testRequestArray[4]);
	                testRequest.setResponseContentType(testRequestArray[4]);
	                sendInfo.add(testRequest);
	            }
	            
	        }
	        
	        catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        br.close();
	        return sendInfo;
	    }
}
