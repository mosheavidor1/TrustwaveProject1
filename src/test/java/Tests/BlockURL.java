package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Actions.CloudActions;;

public class BlockURL extends GenericTest{

	private CloudActions action;

	@Factory (dataProvider = "getData")
	public BlockURL(Object dataToSet) {
		super(dataToSet);
	 	action = new CloudActions();
	 }

	 @Test 
	 public void BlockURL1 () throws Exception {
		 
	     OpenPoliciesPage();
	     action.DeleteRules(data.get("Block Site"));
		 action.CloseApplication();


	     action.LaunchApplication(data.get("Browser"),data.get("LB IP") );
	     action.SetApplicationUrl(data.get("Block Site"));    
	     action.CheckNOTBlockedPage();
	     action.CloseApplication();
		 
	     OpenPoliciesPage();
		 action.AddRule(data.get("Block Site"));
		 action.CloseApplication();
		 
	     action.LaunchApplication(data.get("Browser"),data.get("LB IP") );
	     action.SetApplicationUrl(data.get("Block Site"));    
	     action.CheckBlockedPage();

	 }
	 
	 public void OpenPoliciesPage() throws Exception {
		 
	     action.LaunchApplication(data.get("Browser"));
		 
	     action.SetApplicationUrl(data.get("URL"));

		 action.Login(data.get("UserName"), data.get("Password"));

		 action.GotoSWGConfigurationPage(data.get("URL"));
		 
		 action.SelectCustomerAtConfigurationPage(data.get("CustomerName") );

		 action.GotoSWGPoliciesPage(data.get("URL"));

		 
	 }
	  
	
	  @BeforeClass
	  public void beforeClass() {
		  	  
		  
		  

	  }

	  @AfterClass
	  public void afterClass() {
		  
		 action.CloseApplication();

	  }

	
	
}
