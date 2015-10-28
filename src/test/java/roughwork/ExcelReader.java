package roughwork;


import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


// http://www.softwaretestinghelp.com/selenium-framework-design-selenium-tutorial-21/
public class ExcelReader {

	public static Sheet wrksheet;

	public static Workbook wrkbook = null;

	public static Hashtable<String, Integer> dict = new Hashtable<String, Integer>();

	public ExcelReader() throws BiffException, IOException  {

			wrkbook = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\ExcelFiles\\SuiteC.xlsx"));
			wrksheet = wrkbook.getSheet("SAYAN");
		}

	public static int RowCount() {
		return wrksheet.getRows();
	}

	public static String ReadCell(int column, int row) {
		return wrksheet.getCell(column, row).getContents();
	}

	public void ColumnDictionary() {
		// Iterate through all the columns in the Excel sheet and store the
		// value in Hashtable
		for (int col = 0; col < wrksheet.getColumns(); col++) {
			dict.put(ReadCell(col, 0), col);
		}
	}

	public static int GetCell(String colName) {

		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);
		}
	}


}


