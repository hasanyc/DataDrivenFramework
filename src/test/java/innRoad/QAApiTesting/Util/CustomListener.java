package innRoad.QAApiTesting.Util;

import java.io.File;

import org.testng.internal.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


public class CustomListener extends TestListenerAdapter implements IInvokedMethodListener,ISuiteListener{
	public static Hashtable<String,String> resultTable ;
	public static ArrayList<String> keys ;
	public static String fileName;
	String path=System.getProperty("user.dir")+"\\Reports\\";

	public void onTestFailure(ITestResult tr){
		report(tr.getName(), tr.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult tr) {
		report(tr.getName(), tr.getThrowable().getMessage());

	}
	
	public void onTestSuccess(ITestResult tr){
		report(tr.getName(), "PASS");

	}
	
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		
		
	}
 
	public void beforeInvocation(IInvokedMethod arg0, ITestResult test) {
	}

	public void onStart(ISuite suite) {
		System.out.println("Starting suite "+ suite.getName());
		if(resultTable==null){
		 resultTable  = new Hashtable<String,String>();
		 keys = new ArrayList<String>();
		}
	}

	public void onFinish(ISuite suite) {
		if(resultTable !=null){
			System.out.println("Finishing suite "+ suite.getName());
			System.out.println(resultTable);
			
			
			
			if(!suite.equals("My Project")){
				Xls_Reader xls = new Xls_Reader(path+fileName+"\\Report.xlsx");
				xls.addSheet(suite.getName());
				
				xls.setCellData(suite.getName(), 0, 1, "Test Case");
				xls.setCellData(suite.getName(), 1, 1, "Result");
				
				for(int i=0;i<keys.size();i++){
					String key = keys.get(i);
					String value = resultTable.get(key);
					xls.setCellData(suite.getName(), 0, i+2, key);
					xls.setCellData(suite.getName(), 1, i+2, value);

				}
				
			}
			keys=null;
			resultTable=null;
			
			
		}
		
		
	}
	
	public void report(String name,String result){
		// test Iteration 1
		// test Iteration 2
		int iteration_number=1;
		while(resultTable.containsKey(name+" Iteration "+iteration_number)){
			iteration_number++;
		}
		keys.add(name+" Iteration "+iteration_number);
		resultTable.put(name+" Iteration "+iteration_number, result);
		if(fileName==null){
			Date d=new Date();
			 fileName=d.toString().replace(" ", "_").replace(":", "_");
			 File f = new File(path+fileName+"\\Report.xlsx");
			 f.mkdir();
			 File src = new File(path+"ReportTemplate.xlsx");
			 File dest = new File(path+fileName+"\\Report.xlsx");
			  try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		

	}
			
	

}
