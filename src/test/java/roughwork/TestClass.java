package roughwork;
import java.io.IOException;
import jxl.read.biff.BiffException;

public class TestClass {

	

	public static CommonMethods commonMethodobj = new CommonMethods();
	public static TestData td = new TestData();
	
	public static void main(String[] args) throws BiffException, IOException {
		ExcelReader file = new ExcelReader();
		System.out.println (file);
		// Load the Excel Sheet Col in to Dictionary for use in test cases
		file.ColumnDictionary();
		// Get the data from excel file
		commonMethodobj.readExcelData (td);
	}


}
