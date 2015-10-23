package innRoad.QAApiTesting.Util;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import innRoad.QAApiTesting.Base.TestBase;

public class TestDataProvider{



	@DataProvider(name="suiteADataProvider")
	public static Object [][] getDataSuiteA(Method m) throws IOException{
	//	TestBase.init();
		System.out.println(System.getProperty("user.dir")+"\\ExcelFiles\\"+Constants.FIRST_SUITE+".xlsx");
		Xls_Reader xls1 = new Xls_Reader (System.getProperty("user.dir")+"\\ExcelFiles\\"+Constants.FIRST_SUITE+".xlsx");

		return Utility.getData(m.getName(), xls1);
	}
	
	@DataProvider(name="suiteBDataProvider")
	public static Object [][] getDataSuiteB(Method m) throws IOException{
		//TestBase.init();
		System.out.println(System.getProperty("user.dir")+"\\ExcelFiles\\"+Constants.FIRST_SUITE+".xlsx");
		Xls_Reader xls1 = new Xls_Reader (System.getProperty("user.dir")+"\\ExcelFiles\\"+Constants.FIRST_SUITE+".xlsx");

		return Utility.getData(m.getName(), xls1);
	}
	
	
}

