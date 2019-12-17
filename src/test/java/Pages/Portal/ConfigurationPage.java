package Pages.Portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Pages.GenericPage;
import WebElements.Button;
import WebElements.TextBox;

public class ConfigurationPage extends GenericPage{
	
	private static final String  plusButtonID = "rulesGrid--datalist--action-bar--add-button--icon-button";
	private static final String rulesXpath = "/html/body/portal-main/div/div/div/portal-router/div/twa-portal-stage[6]/div/div[2]/twa-nav-menu-stage[25]/div/div[2]/twa-swg-customer-home-vc/twa-lazy-view-stack/div/twa-lazy-view[6]/div/twa-swg-customer-policies/twa-page/div/twa-cbox[2]/twa-collapse/div[1]/twa-tab-panel/twa-tab-strip/div[1]/div/div[1]/div[2]/div/div[1]";
	private static final String categoriesGridID = "subCategoriesGrid";
	
	public static final By categoriesGridByID = By.id(categoriesGridID);
	public static final By costumerNameBoxByID = By.id("customerSearchInput");
	public static final By subCategorySpinnerByXpath =By.xpath("//*[@id=\"customerPolicies\"]/div/twa-cbox[2]/div[1]/span/twa-spinner");




	

	@FindBy(how=How.XPATH,using="//*[@id=\"customerSearchInput--material-input\"]/div/div[1]/label/input")
		private WebElement customerName_element;
	 	public TextBox customerName;
	
	@FindBy(how=How.XPATH,using=rulesXpath)
		private WebElement rules_element;
		public Button rules;
		
		@FindBy(how=How.ID,using=plusButtonID)
		private WebElement plusButton_element;
		public Button plusButton;
 	
		 public ConfigurationPage () {
			 customerName = new TextBox(customerName_element);
			 rules = new Button(rules_element);
			 plusButton = new Button(plusButton_element);
		 }
		 
		 public WebElement GetFoundCustomerRow(String customerName) {
			    String xpath = "//span[contains(text(),'"+customerName +"')]";
			 	return this.driver.findElement(By.xpath(xpath));
		 }

}
