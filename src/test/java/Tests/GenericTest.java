package Tests;

import java.util.HashMap;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import Utils.Data.Excel;
import Utils.Logs.JLog;
import Utils.PropertiesFile.PropertiesFile;

public class GenericTest {
	
	protected HashMap<String,String> data;
    
	@SuppressWarnings("unchecked")
	public GenericTest(Object  dataToSet) {
		data=(HashMap<String, String>) dataToSet;
	}
	
	
    @DataProvider(name = "getData")
        public static Object[] getDataForInstances(ITestNGMethod m) throws Exception {
    	
    	String fullTestName = m.getConstructorOrMethod().getName(); //m.getMethodName();
    	String [] arr =fullTestName.split("\\.");
    	String sheetName = arr[arr.length-1];
    	String fileName = PropertiesFile.readProperty("Excel.fileLocation");
        boolean excelFileStatus = Excel.setExcelFileAndSheet(fileName, sheetName);
        Object [] getTestData = null;
        if (excelFileStatus)
        	getTestData = Excel.getTestData();
        
        if (getTestData ==null)
        	JLog.logger.error("Could not find Excel sheet for this test.");

        return getTestData;
        
    }




}
