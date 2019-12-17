package Tests;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;


public class runtest {

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("src\\test\\java\\TestSuites\\ExampleSuite.xml");//path to xml..
		testng.setTestSuites(suites);
        testng.addListener(tla);
		testng.run();
		
		/*TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { Test1Example.class });
		testSuite.addListener(new TestListenerAdapter ());
		testSuite.setDefaultSuiteName("My Test Suite");
		testSuite.setDefaultTestName("My Test");
		testSuite.setOutputDirectory("/Users/pankaj/temp/testng-output");
		testSuite.run();*/


	}

}
