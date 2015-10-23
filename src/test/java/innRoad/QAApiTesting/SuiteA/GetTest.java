package innRoad.QAApiTesting.SuiteA;

import java.util.Hashtable;
import org.testng.annotations.Test;

import innRoad.QAApiTesting.Base.TestBase;
import innRoad.QAApiTesting.Util.Constants;
import innRoad.QAApiTesting.Util.TestDataProvider;


public class GetTest extends TestBase{


	@Test (dataProviderClass=TestDataProvider.class, dataProvider="suiteADataProvider")
	public void getTest(Hashtable<String,String>table){

		APPLICATION_LOG.debug("Executing Test case 1");
		validateRunmodes ("getTest", Constants.FIRST_SUITE, table.get(Constants.RUNMODE_COL));
		System.out.println(table.get(Constants.ENDPOINT_COL));
	}
}



