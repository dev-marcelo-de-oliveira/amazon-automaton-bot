package br.dev.marcelodeoliveira.amazonautomatonbot.pages;

import static br.dev.marcelodeoliveira.amazonautomatonbot.core.DriverFactory.getDriver;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.amazonautomatonbot.core.BasePage;

public class RequestItemPage extends BasePage {

	
	
	By searchBar = By.xpath("//*[@id='twotabsearchtextbox']");
	By searchButton = By.xpath("//*[@id='nav-search-submit-text']");

	// -------------------------- RESULTS --------------------------

	By singlePageResultFrames = By.xpath("//div[@class = 'a-section a-spacing-base']/../../../parent::*");
	By singlePageResultTitles = By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']");
	
	//By singlePageResultImageFrame = By.xpath("//*[@class='a-section aok-relative s-image-square-aspect']/parent::*");

	By singlePageResultTitlesPartialXPATH = By.xpath(".//*[@class='a-size-base-plus a-color-base a-text-normal']");
	By singlePageResultImageFramePartialXPATH = By
			.xpath(".//*[@class='a-section aok-relative s-image-square-aspect']/../../..");

	
	By resultTitleLinks = By.xpath("//*[@data-component-type='s-search-result']//h2");
	By selectAddressLink = By.xpath("//*[@id='contextualIngressPtLabel']");
	
	By selectZipCodeLink = By.xpath("//*[id='contextualIngressPtLabel_deliveryShortLine']");
	By BrazilianZipCodePreffix = By.xpath ("//*[@id='GLUXZipUpdateInput_0']");
	By BrazilianZipCodeSuffix = By.xpath ("//*[@id='GLUXZipUpdateInput_1']");
	By SubmitZipCodeConfirmation = By.xpath("//*[@id='GLUXZipUpdate']/..");
	
//	@Override
//	@Before
//	public void startDriver() {}
	
	public RequestItemPage() {
		super();
	}
	
	
	public void selectZipCode() {
		clickOnElement(selectZipCodeLink);	
	}
	
//	public void addZipCode (String zipCode) {
//		
//		clickOnElement(selectAddressLink);
//		redirectWait();
//		scriptWait();
//		
//		
//		
//		//must be flexible to regional implementation rules
//		//magic numbers! refine it
//		//Should'nt you validate "invalid cpf" or "cpf regex match" cases?
//		writeTextOnElementField(BrazilianZipCodePreffix, zipCode.substring(0,5));
//		writeTextOnElementField(BrazilianZipCodePreffix, zipCode.substring(5,zipCode.length()));
//		clickButton(singlePageResultImageFramePartialXPATH);
//		
//	}

	public List<WebElement> searchElement(String searchQueryText) {

		redirectWait();
		writeTextOnElementField(searchBar, searchQueryText);

		moveToWebElementAndClick(searchButton);

		var relevantElements = getRelevantResults(searchQueryText.trim().toLowerCase());

		// formatar

				relevantElements.stream().map(p-> p.findElement(singlePageResultImageFramePartialXPATH)).
				forEach(elem-> {
						executeJS("arguments[0].style.border = arguments[1]", elem,
								
								//PQP! a ordem dos fatores altera o produto! Em css!
								"solid 4px fuchsia");
			
						scriptWait();
					}
				);

		//System.out.println(relevantElements.get(2).getText());
	//	System.out.println(elem.toString());

				//clickOnElement(selectAddressLink);
		
		return relevantElements;

	}

//	@Before
//	private void inicializa() {
//		redirectWait();
//	}

	private List<WebElement> getRelevantResults(String searchQuery) {

		redirectWait();
		

		var searchQueryWithTrimAndCaseLowered = searchQuery.trim().toLowerCase();
		Predicate<WebElement> containsExactMatch = welem -> welem.findElement(singlePageResultTitlesPartialXPATH).getText()
				.toLowerCase().trim().contains(searchQueryWithTrimAndCaseLowered);
		
//		Predicate<WebElement> startsWithKeyword = welem -> welem.findElement(singlePageResultTitlesPartialXPATH).getText()
//				.toLowerCase().trim().contains(searchQueryWithTrimAndCaseLowered.split(" ")[0]);

		Predicate<WebElement> isRelevant = welem -> welem.findElement(singlePageResultTitlesPartialXPATH).getText()
				.toLowerCase().trim().startsWith(searchQueryWithTrimAndCaseLowered.split(" ")[0]);

		
		// List<WebElement> results =
		// getDriver().findElements(singlePageResultFrames).stream().filter(isTitleRelevant).collect(Collectors.toList());

		
		
		var l = getDriver().findElements(singlePageResultFrames).stream().filter(containsExactMatch)
				.collect(Collectors.toList());

		redirectWait();


		return l;
	}

	private Integer validarItem(String searchQuery) {

		// redirectWait();
		/**
		 * ***ESTRATÉGIAS DE COMPARAÇÃO E VALIDAÇÃO***
		 * 
		 * Objetivo: tornar mais acurado, relevante e consequente- mente mais elástico o
		 * conjunto de resultados validados para a aplicação com a adoção de
		 * metodologias simples.
		 * 
		 * 
		 * 
		 * [1]. Insensível a Caixa;
		 * 
		 * [a]. Por carência de suporta a XPATH 2.0 o suporte aos novos métodos
		 * lower-case(), upper-case(), bem como ao matches() a validação de relevância
		 * deve ser feita internamente, com implementação rápida (Stream sugerida)
		 * 
		 * [2]. Insensível a Diacritização (a implementar)
		 * 
		 * [3]. Haverão duas Strings para valores esperados, no qual apenas uma é
		 * suficiente para que o teste passe:
		 * 
		 * [a]. nonSpacedExpectedItemString: aglutinação dos termos pela eliminação de
		 * caracteres conotadores de separação.
		 *
		 * [i]. A princípio: serão man- tidos apenas letras e dígitos.
		 * 
		 * [b]. spacedExpectedItemString palavras separadas por caracter de espaço;
		 * 
		 * [i] Palavras com Maiúsculas em seu interior;
		 * 
		 * [2] Palavras com traços, pontos médios, operador menos, travessões e
		 * undescores os terão substituídos por ' ' (espaço).
		 *
		 * 
		 *
		 *
		 * [c]. Tentar comparação em curto circuito: a primeira string a ser comparada
		 * com o valor esperado será nonSpacedExpectedItemString. Caso o teste passe,
		 * SpacedExpectedItemString não será utilizada (ou nem gerada para teste).
		 * 
		 * 
		 * 
		 */

		var relevantItemsQuantity = 3;
		return relevantItemsQuantity;
	}





//	public void startSearch(String searchQueryString) {
//		//redirectWait();
//		writeTextOnElementField(searchBar, searchQueryString);
//		
//		moveToWebElementAndClick(searchButton);
//		
//	}
}