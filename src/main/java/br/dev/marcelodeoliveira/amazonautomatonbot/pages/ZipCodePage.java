package br.dev.marcelodeoliveira.amazonautomatonbot.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import br.dev.marcelodeoliveira.amazonautomatonbot.core.BasePage;
import br.dev.marcelodeoliveira.amazonautomatonbot.pages.utils.CssTools;

public class ZipCodePage extends BasePage {
	public ZipCodePage() {
		super();
	}
	
	

	By selectZipCodeLink = By.xpath("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
	By BrazilianZipCodePreffix = By.xpath("//*[@id='GLUXZipUpdateInput_0']");
	By BrazilianZipCodeSuffix = By.xpath("//*[@id='GLUXZipUpdateInput_1']");
	By zipCodeFrame = By.xpath("//*['GLUXZipInputSection']/div");
	By SubmitZipCodeConfirmation = By.xpath("//*[@id='GLUXZipUpdate']/..");

	private By zipCodeError = By.xpath("//*[@id='GLUXZipError']");
	private By zipCodeErrorMessage = By.xpath("//*[@id='GLUXZipError']/div/div/div");

	By ShippingAndDeliveryInformationsFrame = By.xpath("//*[@id='deliveryBlockMessage']");
	By ShippingAndDeliveryInformationsSpans = By.xpath("//*[@id='deliveryBlockContainer']");
	// By.xpath("//*[@id='deliveryBlockContainer']//div/span[contains(@class,
	// data-csa-c)]");
	private CssTools cssTools = new CssTools();

	public String addZipCode(String zipCode) {



		implicityWait(Duration.ofSeconds(10));
		clickButton(selectZipCodeLink);

		scriptWait();
		
		redirectWait();

		
		waitForElementPresenceThenContinue(SubmitZipCodeConfirmation);

		// smelling like a cadaver! make a zipcode dedicaated method in some utils
		// package!
		// seizing the localization packs as well!
		writeTextOnElementField(BrazilianZipCodePreffix, zipCode.substring(0, 5));
		writeTextOnElementField(BrazilianZipCodeSuffix, zipCode.substring(6, zipCode.length()));
		movingDivWait();
		scriptWait();
		switchToDefaultContent();
		//waitForElementAndClick(SubmitZipCodeConfirmation);
		clickButton(SubmitZipCodeConfirmation);
		//switchToDefaultContent();


		var txt = isZipCodeInvalid();

	
		
		return txt;
	}

	public String getDeliveryInfos() {

		var infos = getElementsText(ShippingAndDeliveryInformationsSpans);

		cssTools.webElementHighlight(ShippingAndDeliveryInformationsFrame);

		scriptWait();

		return infos;
	}

	public String isZipCodeInvalid() {
//		scriptWait();
//		redirectWait();

		String text = "";
		waitForElementPresence(zipCodeError);
	//	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		if (isElementPresent(zipCodeErrorMessage)) {
			text += getText(zipCodeErrorMessage);
			
		
		
	}
		return text;
	}

	public void killDriver() {
		// TODO Auto-generated method stub
		killDriver();
		
	}
}
