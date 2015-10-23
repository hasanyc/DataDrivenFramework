package innRoad.QAApiTesting.SuiteA;

import java.util.Hashtable;
import org.testng.annotations.Test;

import innRoad.QAApiTesting.Base.TestBase;
import innRoad.QAApiTesting.Util.Constants;
import innRoad.QAApiTesting.Util.TestDataProvider;

public class PutTest extends TestBase{
	
	@Test (dataProviderClass=TestDataProvider.class, dataProvider="suiteADataProvider")
	public void putTest(Hashtable<String,String>table){
		validateRunmodes ("putTest", Constants.FIRST_SUITE, table.get(Constants.RUNMODE_COL));
		
	}


	
}


