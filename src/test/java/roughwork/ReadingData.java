package roughwork;

import innRoad.QAApiTesting.Util.Constants;
import innRoad.QAApiTesting.Util.Xls_Reader;

public class ReadingData {

	public static void main(String[] args) {

		Xls_Reader xls = new Xls_Reader (System.getProperty("user.dir")+"/ExcelFiles/SuiteA.xlsx");
		String testName="test1";
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
		System.out.println("Total cols "+testCols );

		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			for(int cNum=0;cNum<testCols;cNum++){
				System.out.println(xls.getCellData(Constants.ENDPOINTS_SHEET, cNum, rNum));
			}

		}

	}

}
