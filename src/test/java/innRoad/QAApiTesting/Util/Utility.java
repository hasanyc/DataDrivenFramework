package innRoad.QAApiTesting.Util;

import java.util.Hashtable;

public class Utility {

	// Test suite is runnable or not
	public static boolean isSuiteRunnable (String SuiteName, Xls_Reader xls){

		int rows = xls.getRowCount(Constants.SUITE_SHEET);
		for (int rNum=2; rNum<=rows;rNum++){
			String data = xls.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rNum);
			if (data.equals(SuiteName)){
				String runmode = xls.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COL, rNum);
				if (runmode.equals(Constants.RUNMODE_YES))
					return true;
				else 
					return false;
			}
		}

		return false;

	}


	public static boolean  isTestCaseRunnable (String testCases, Xls_Reader xls){

		int rows = xls.getRowCount(Constants.TESTCASE_SHEET);
		for (int rNum=2; rNum<=rows;rNum++){
			String testNameXls = xls.getCellData(Constants.TESTCASE_SHEET, Constants.TESTCASE_COL, rNum);
			if (testNameXls.equals(testCases)){
				String runmode = xls.getCellData(Constants.TESTCASE_SHEET, Constants.RUNMODE_COL, rNum);
				if (runmode.equals(Constants.RUNMODE_YES))
					return true;
				else 
					return false;
			}
		}
		return false; // default 
	}

	public static Object[][]  getData(String testName, Xls_Reader xls){
		int rows = xls.getRowCount(Constants.ENDPOINTS_SHEET);
		System.out.println("Total rows - "+ rows);

		// row number for testCase
		int testCaseRowNum=1;
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++){
			String testNameXls = xls.getCellData(Constants.ENDPOINTS_SHEET, 0, testCaseRowNum);
			if(testNameXls.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test Starts from row Number - "+ testCaseRowNum);
		int dataStartRowNum=testCaseRowNum+2;
		int colStartRowNum=testCaseRowNum+1;

		// rows of data
		int testRows=1;
		while(!xls.getCellData(Constants.ENDPOINTS_SHEET, 0, dataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Total rows of data are - "+testRows);

		// cols of data
		int testCols=0;
		while(!xls.getCellData(Constants.ENDPOINTS_SHEET,testCols,colStartRowNum).equals("")){
			testCols++;
		}
		Object[][] data = new Object[testRows][1];
		int r=0;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			Hashtable<String,String> table = new Hashtable<String,String>();
			for(int cNum=0;cNum<testCols;cNum++){
				//System.out.println(xls.getCellData(Constants.DATA_SHEET, cNum, rNum));
				//data[r][cNum]=xls.getCellData(Constants.DATA_SHEET, cNum, rNum);
				table.put(xls.getCellData(Constants.ENDPOINTS_SHEET, cNum, colStartRowNum), xls.getCellData(Constants.ENDPOINTS_SHEET, cNum, rNum));
			}
			data[r][0]=table;
			r++;
		}
		return data;

	}

}
