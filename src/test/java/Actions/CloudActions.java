package Actions;

import java.util.List;

import Pages.Portal.*;
import Tests.PolicyTest;
import WebElements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CloudActions extends TestActions {

	//URL Constans

	public static final String SWGConfigurationURL = "/#/operations?menuKey=swg-customer-home&stackKey=";
	public static final String SWGPoliciesURL = "/#/operations?menuKey=swg-customer-home&stackKey=swg-policies";
	public static final String SWGPolicyTestURL = "/#/operations?menuKey=swg-policy-test&stackKey=";


	public CloudActions() {
		super();
	}


	//Sets the login page and login to the website.
	public void Login(String userName, String password) throws Exception {
		LoginPage login = new LoginPage();
		DashboardPage dash = new DashboardPage();

		login.WaitUntilTitleAppearAndPageLoad("Trustwave Fusion");
		login.UserName.SetText(userName);
		login.Password.SetText(password);
		login.LoginButton.click();

		//wait until page load
		dash.WaitUntilObjectClickable(DashboardPage.dashboradByID);


	}

	//Policy Test -Clicks on policy test configure User
	public void ClickOnPolicyTestCofigureUser() {


		PolicyTestPage pol = new PolicyTestPage();

		pol.WaitUntilPageLoad();

		pol.WaitUntilObjectClickable(PolicyTestPage.Trustwave123);


		pol.TrustWaveButton.click();


	}

//Policy Test -Types in the text box of the Trustwave123 tenant  search

	public void TypeInTrustWave123(String tenant) {

		PolicyTestTenant Type123Text1 = new PolicyTestTenant();

		Type123Text1.WaitUntilObjectClickable(PolicyTestTenant.PolicyTestUrlType);

		Type123Text1.tenant.SetText(tenant);

		Type123Text1.WaitUntilObjectClickable(PolicyTestTenant.PolicyTestUrlType);

//clicks on the selected tenant
				Type123Text1.ChooseTenantId();


	}








//	public void TypeInTrustWave123() {
//
//		PolicyTestPage Type123Text1 = new PolicyTestPage();
//
//
//		Type123Text1.Trustwave123ChangeClient();
//
//
//		Type123Text1.ChooseTenantId();
//	}


	//Policy Test- type URL in text box.
//	public void PolicyTestTypeURL() {
//
//
//		PolicyTestPage pol = new PolicyTestPage();
//
//
	//	pol.WaitUntilObjectClickable(PolicyTestPage.PolicyTestUrlType);
//
//
//		pol.PolicyTestUrlwrite();


	//Policy Test Blocked Url

	public void PolicyTestTypeURL(String Block) {
		PolicyTestBlockUrlPage blockPage = new PolicyTestBlockUrlPage();

		blockPage.WaitUntilObjectClickable(PolicyTestBlockUrlPage.PolicyTestUrlType);


		blockPage.Block.SetText(Block);


	}

	//Policy Test- type IP in text box.


	public void PolicyTestTypeIP(String Block) {

		PolicyTestBlockIpPage IpBlock = new PolicyTestBlockIpPage();
		IpBlock.WaitUntilObjectClickable(PolicyTestBlockIpPage.PolicyTestIpType);

		IpBlock.Block.SetText(Block);


	}






	//Policy Test-Click on Go button
	public void ClickOnGo() {


		PolicyTestPage pol = new PolicyTestPage();


		pol.WaitUntilObjectClickable(PolicyTestPage.PolicyTestClickOnGo);


		pol.ClickOnGoButton();


	}


	//Policy Test check if Website is blocked

	public void PageIsBlocked() {

		PolicyTestPage pol = new PolicyTestPage();
		pol.WaitUntilObjectClickable(PolicyTestPage.PolicyCheckIfBlocked);







	}


	public void SelectCustomerAtConfigurationPage(String customerName) {
		ConfigurationPage conf = new ConfigurationPage();
		conf.WaitUntilObjectClickable(ConfigurationPage.costumerNameBoxByID);
		conf.customerName.SetText(customerName + "\n");
		conf.GetFoundCustomerRow(customerName).click();
		//conf.foundCustomerName.click();

	}


	//After customer is selected - adds url block rule
	public void DeleteRules(String url) {
		ConfigurationPage conf = new ConfigurationPage();

		conf.WaitUntilPageLoad();
		conf.WaitUntilObjectClickable(ConfigurationPage.categoriesGridByID);
		conf.WaitUntilObjectDisappear(ConfigurationPage.subCategorySpinnerByXpath);


		conf.rules.click();

		RulesPage rules = new RulesPage();
		List<WebElement> list = rules.GetAllRules(url);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			rules.delete.click();
		}
		if (list.size() > 0)
			CommitPendingChanges();
	}


	//After customer is selected - adds url block rule
	public void AddRule(String url) {
		ConfigurationPage conf = new ConfigurationPage();

		conf.WaitUntilPageLoad();
		conf.WaitUntilObjectClickable(ConfigurationPage.categoriesGridByID);
		conf.WaitUntilObjectDisappear(ConfigurationPage.subCategorySpinnerByXpath);


		conf.rules.click();
		conf.plusButton.click();

		AddRulePage addRule = new AddRulePage();

		addRule.WaitUntilObjectClickable(AddRulePage.RuleTypeByID);

		addRule.ruleType.SetValue("Custom URL");
		addRule.Action.SetValue("Block");
		addRule.URL.SetText(url);
		addRule.Submit.click();

		CommitPendingChanges();
	}

	public void CheckBlockedPage() {
		if (IsPageBlock())
			return;
		org.testng.Assert.fail("Page is not Blocked");
	}


	public void CheckNOTBlockedPage() {
		if (!IsPageBlock())
			return;
		org.testng.Assert.fail("Page Blocked");
	}

	public boolean IsPageBlock() {
		try {

			BlockPage block = new BlockPage();
			if (block.pageBlocked_element.getText().compareTo("Page Blocked") != 0)
				return false;
			block.trustwaveImage_element.click();
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public void CommitPendingChanges() {
		UpperMenu menu = new UpperMenu();
		menu.pendingChanes.click();
		PendingChangesPage pending = new PendingChangesPage();
		pending.submit.click();

		menu.WaitUntilObjectDisappear(pending.submitBy);

	}

	//
	public void GotoSWGConfigurationPage(String UrlPrefix) {
		this.SetApplicationUrl(UrlPrefix + SWGConfigurationURL);
	}

	//PolicyPage Login
	public void GotoSWGPoliciesPage(String UrlPrefix) {
		this.SetApplicationUrl(UrlPrefix + SWGPoliciesURL);
	}


	//Policy Test -Login Page
	public void GotoSWGPolicyTestPage(String UrlPrefix) {
		this.SetApplicationUrl(UrlPrefix + SWGPolicyTestURL);


	}



	}

