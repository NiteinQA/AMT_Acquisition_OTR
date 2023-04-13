package com.amt.CustomerQuotePackage;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.Difference;
import com.amt.testUtil.Dropdown;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.ReadExcelCalculationForPurchaseAgreement;
import com.amt.testUtil.RemoveComma;

public class CustomerQuotePageBrokerCPPage extends TestBase {

	JavascriptExecutor jse;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;
	

	//vehicle_discount_cost_price
	@FindBy(xpath = "//*[@id='bdiscount']//ancestor::div[3]//div//p")
		private WebElement vehicle_discount_cost_price;

	//vehicle_additional_discount_cost_price
	@FindBy(xpath = "(//*[@id='bdiscountvalue']//ancestor::div[3]//div)[1]")
		private WebElement vehicle_additional_discount_cost_price;
		
		
		//paint_discount_cost_price
	@FindBy(xpath = "(//*[@id='pdiscountper']//ancestor::div[3]//div)[1]")
		private WebElement paint_discount_cost_price;

	//paint_additional_discount_cost_price
	@FindBy(xpath = "(//*[@id='pdiscountvalue']//ancestor::div[3]//div)[1]")
		private WebElement paint_additional_discount_cost_price;
		
		//options_discount_cost_price
	@FindBy(xpath = "(//*[@id='odiscount']//ancestor::div[3]//div)[1]")
		private WebElement options_discount_cost_price;

	//options_additional_discount_cost_price
	@FindBy(xpath = "(//*[@id='odiscountvalue']//ancestor::div[3]//div)[1]")
		private WebElement options_additional_discount_cost_price;

	@FindBy(xpath = "//input[@id='profit']")
	private WebElement vehicle_profit_input;

	@FindBy(xpath = "//p[normalize-space()='Customer Quote']")
	private WebElement customer_quote;

	@FindBy(xpath = "//*[@class='ng-select-container']//*[@class='ng-arrow-wrapper']")
	private WebElement customer_quote_funder;

	@FindBy(xpath = "//input[@id='quoteReferenceNo']")
	private WebElement quote_reference;

	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	private WebElement expiry_date;

	@FindBy(xpath = "//input[@id='duration']")
	private WebElement term_period;

	@FindBy(xpath = "//input[@id='funderItemMileage']")
	private WebElement miles_per_annum;

	@FindBy(xpath = "//input[@id='contractMileage']")
	private WebElement contract_miles;

	@FindBy(xpath = "//input[@id='cashDeposit']")
	private WebElement cashdeposit;

	@FindBy(xpath = "//input[@id='numberOfMonthlyPayments']")
	private WebElement noOfMonthlyPayment;

	@FindBy(xpath = "//*[@name='initialFinanceRental']")
	private WebElement initial_finance_rental;

	@FindBy(xpath = "//input[@id='initialMaintenanceRental']")
	private WebElement initial_maintenance_rental;

	@FindBy(xpath = "//input[@id='monthlyPayment']")
	private WebElement monthlyfinancePayment;

	@FindBy(xpath = "//input[@id='optionalFinalPayment']")
	private WebElement optionalfinalPayment;

	@FindBy(xpath = "//input[@id='optionToPurchaseFee']")
	private WebElement optiontoPurchaseFee;

	@FindBy(xpath = "//select[@name='vehicleTaxIncluded']")
	private WebElement rFLIncluded;

	@FindBy(xpath = "//input[@id='monthlyMaintenanceRental']")
	private WebElement monthly_maintenance_rental;

	@FindBy(xpath = "//input[@id='pencePerExcessMileageFinance']")
	private WebElement pence_Per_ExcessMileage_Finance;

	@FindBy(xpath = "//input[@id='apr']")
	private WebElement apr;

	@FindBy(xpath = "//input[@id='otrPartExchange']")
	private WebElement partExchangeactual;

	@FindBy(xpath = "//input[@id='partExchnage']")
	private WebElement partExchangegiven;

	@FindBy(xpath = "//input[@id='lessFinanceSettlement']")
	private WebElement lessFinancesettlement;

	@FindBy(xpath = "//*[@id='collapseTwo']/div/div[2]/div[9]/div[2]/p")
	private WebElement otrScreenPrice;

	@FindBy(xpath = "//*[@id='collapseTwo']/div/div[2]/div[10]/div[3]/p")
	private WebElement vehicle_sale_price;

	@FindBy(xpath = "//input[@id='pencePerExcessMileageMaintenance']")
	private WebElement pence_Per_ExcessMileage_maintenance;

	@FindBy(xpath = "//input[@id='commission']")
	private WebElement commission;

	@FindBy(xpath = "//i[@class='btn-icon-addAddress-white']")
	private WebElement add;

	@FindBy(xpath = "//i[@class='btn-icon-reset-black']")
	private WebElement reset;

	@FindBy(xpath = "//div[@class='row acquisition-menu']//div[3]//button[1]")
	private WebElement save_button;

	@FindBy(xpath = "//label[@for='maintenanceIncluded']//span[@class='slider round']")
	private WebElement maintenance_toggle_button;

	@FindBy(xpath = "//*[contains(text(),' Customer quote summary ')]")
	private WebElement customer_quote_summary;

	@FindBy(xpath = "//*[@id='partExchange_2']/div/div/div[3]/div/span")
	private WebElement customer_quote_summary_balance_to_finance;

	@FindBy(xpath = "//*[@id='partExchange_2']/div/div/div[1]/ul/li[4]/span[1]")
	private WebElement part_exchange_profit;

	@FindBy(xpath = "//*[@id='partExchange_2']/div/div/div[1]/ul/li[3]/span[2]")
	private WebElement part_exchange_value;

	@FindBy(xpath = "//input[@id='monthlyMaintenancePayment']")
	private WebElement monthly_maintenance_payment;

	@FindBy(xpath = "((//*[normalize-space()='On the road price']//ancestor::div[1])[1])//div[2]")
	private WebElement otr_cost_price;

	@FindBy(xpath = "//*[@name='salesTotal']")
	private WebElement sales_total_input;
	
	@FindBy(xpath = "//*[contains(text(),'On the road price')]//following::div[1]")
	private WebElement otrScreenPriceUsedVehicle;

	
	@FindBy(xpath = "//input[@id='salesTotal']")
	private WebElement vehicle_sale_price_used_vehicle;
	
	@FindBy(xpath = "//input[@id='profit']")
	private WebElement vehicleprofit;

	public CustomerQuotePageBrokerCPPage() {
		PageFactory.initElements(driver, this);
	}
	


	public boolean customer_Quote_page_verification_broker_purchase_used_vehicle(String vehicleProfit, String quoteRef,
			String quoteExpiryDate, String term, String milesperannum, String contractMileage, String cahDeposit,
			String noOfMonthlyPayments, String monthlyFinancePayment, String finalBallonPayment,
			String optionToPurchaseFee, String rflIncluded, String aPR, String commission2, String partExchangeActual,
			String partExchangeGiven, String lessFinanceSettlement, String sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException {

		Click.on(driver, customer_quote, 25);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		ExplicitWait.visibleElement(driver, otrScreenPriceUsedVehicle, 30);
		String otr_screen_price = otrScreenPriceUsedVehicle.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		ExplicitWait.visibleElement(driver, vehicleprofit, 20);

		vehicleprofit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		int profit = Integer.parseInt(vehicleProfit);

		Click.sendKeysint(driver, vehicleprofit, profit, 40);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		double vehicleProfit_converted = Double.parseDouble(vehicleProfit);
		ExplicitWait.visibleElement(driver, vehicle_sale_price_used_vehicle, 20);
		
		vehicle_sale_price_used_vehicle.sendKeys(Keys.chord(Keys.CONTROL, "a", "c"));

	       Clipboard clipboard =Toolkit.getDefaultToolkit().getSystemClipboard();
	       String vehicle_profit_copied =(String) clipboard.getData(DataFlavor.stringFlavor);
	       
	       
		double vehicle_profit_from_screen_converted = Double.parseDouble(vehicle_profit_copied);

		double diff2 = Difference.of_two_Double_Values(otr_screen_price_converted,
				vehicle_profit_from_screen_converted);

		LO.print("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);
		System.out.println("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);

		LO.print("After adding profit to otr price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_profit_from_screen_converted);
		System.out.println("After adding profit to otr price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_profit_from_screen_converted);

		boolean vehicle_profit_status = false;

		if (diff2 == (vehicleProfit_converted * 1.2)) {
			vehicle_profit_status = true;
			LO.print("Vehicle profit verified");
			System.out.println("Vehicle profit verified");
		}

		return vehicle_profit_status;
	}

	
	public boolean edit_otr_sales_price_and_verify_profit_broker_purchase_used_vehicle(String sales_price_percentage, String sheet_name)
			throws InterruptedException, UnsupportedFlavorException, IOException {

		LO.print("");
		System.out.println("");

		LO.print("Verifying Vehicle profit and Total Monthly Payment on editing Vehicle Sales Price");
		System.out.println("Verifying Vehicle profit and Total Monthly Payment on editing Vehicle Sales Price");

		// getting screen otr price
		ExplicitWait.visibleElement(driver, otr_cost_price, 30);
		double otrCostPrice = Double.parseDouble(RemoveComma.of(otr_cost_price.getText().trim().substring(2)));

		// code for sending input to sales total input
		ExplicitWait.visibleElement(driver, sales_total_input, 30);
		sales_total_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		double salesPricePercentage = Double.parseDouble(sales_price_percentage);
		double salesPrice = (((otrCostPrice * salesPricePercentage) / 100) + otrCostPrice);
		Click.sendKeys(driver, sales_total_input, String.valueOf(salesPrice), 20);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("Sending " + salesPrice + " to sales total input field");
		System.out.println("Sending " + salesPrice + " to sales total input field");

		double vehicel_profit_expected = (salesPrice - otrCostPrice) / 1.2;

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 30);
		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", "c"));
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String vehicle_profit_copied = (String) clipboard.getData(DataFlavor.stringFlavor);

		double vehicel_profit_actual = Double.parseDouble(vehicle_profit_copied);

		double diff1 = Difference.of_two_Double_Values(vehicel_profit_expected, vehicel_profit_actual);

		boolean status = false;

		if (diff1 < 0.2) {
			status = true;

			LO.print("Vehicle profit verified on editing Vehicle Sales Price");
			System.out.println("Vehicle profit verified on editing Vehicle Sales Price");
		}

		return status;
	}


	public boolean edit_otr_sales_price_and_verify_profit(String sales_price_percentage,
			String sheet_name) throws InterruptedException, UnsupportedFlavorException, IOException {

		LO.print("");
		System.out.println("");

		LO.print("Verifying Vehicle profit and Total Monthly Payment on editing Vehicle Sales Price");
		System.out.println("Verifying Vehicle profit and Total Monthly Payment on editing Vehicle Sales Price");

		// getting screen otr price
		ExplicitWait.visibleElement(driver, otr_cost_price, 30);
		double otrCostPrice = Double.parseDouble(RemoveComma.of(otr_cost_price.getText().trim().substring(2)));

		// code for sending input to sales total input
		ExplicitWait.visibleElement(driver, sales_total_input, 30);
		sales_total_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		double salesPricePercentage = Double.parseDouble(sales_price_percentage);
		double salesPrice = (((otrCostPrice * salesPricePercentage) / 100) + otrCostPrice);
		Click.sendKeys(driver, sales_total_input, String.valueOf(salesPrice), 20);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("Sending " + salesPrice + " to sales total input field");
		System.out.println("Sending " + salesPrice + " to sales total input field");

		double vehicel_profit_expected = (salesPrice - otrCostPrice) / 1.2;

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 30);
		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", "c"));
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String vehicle_profit_copied = (String) clipboard.getData(DataFlavor.stringFlavor);

		double vehicel_profit_actual = Double.parseDouble(vehicle_profit_copied);

		double diff1 = Difference.of_two_Double_Values(vehicel_profit_expected, vehicel_profit_actual);

		boolean status = false;

		if (diff1 < 0.2) {
			status = true;

			LO.print("Vehicle profit verified on editing Vehicle Sales Price");
			System.out.println("Vehicle profit verified on editing Vehicle Sales Price");
		}

		return status;
	}

	public boolean customer_Quote_vehicle_profit_checking_broker_cp_without_maintenance(String vehicleProfit,
			String quoteRef, String quoteExpiryDate, String term, String milesperannum, String contractMileage,
			String cahDeposit, String noOfMonthlyPayments, String monthlyFinancePayment, String optionalFinalPayment,
			String optionToPurchaseFee, String rflIncluded, String pensePerExcessMileFinance, String aPR,
			String commission2, String partExchangeActual, String partExchangeGiven, String lessFinanceSettlement,
			String sheet_name) throws InterruptedException, IOException {

		Click.on(driver, customer_quote, 25);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		ExplicitWait.visibleElement(driver, otrScreenPrice, 30);
		String otr_screen_price = otrScreenPrice.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 20);

		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		int profit = Integer.parseInt(vehicleProfit);

		Click.sendKeysint(driver, vehicle_profit_input, profit, 40);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();

		double vehicleProfit_converted = Double.parseDouble(vehicleProfit);
		ExplicitWait.visibleElement(driver, vehicle_sale_price, 20);
		String vehicle_sale_price_from_screen = RemoveComma.of(vehicle_sale_price.getText().trim().substring(2));
		double vehicle_sale_price_from_screen_converted = Double.parseDouble(vehicle_sale_price_from_screen);

		double diff2 = Difference.of_two_Double_Values(otr_screen_price_converted,
				vehicle_sale_price_from_screen_converted);

		LO.print("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);
		System.out.println("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);

		LO.print("After adding profit to cost price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_sale_price_from_screen_converted);
		System.out.println("After adding profit to cost price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_sale_price_from_screen_converted);

		boolean vehicle_profit_status = false;

		if (diff2 == (vehicleProfit_converted * 1.2)) {
			vehicle_profit_status = true;
			LO.print("Vehicle profit verified");
			System.out.println("Vehicle profit verified");
		}

		return vehicle_profit_status;
	}

	public boolean customer_Quote_balance_to_finance_checking_broker_cp_without_maintenance(String vehicleProfit,
			String quoteRef, String quoteExpiryDate, String term, String milesperannum, String contractMileage,
			String cahDeposit, String noOfMonthlyPayments, String monthlyFinancePayment, String optionalFinalPayment,
			String optionToPurchaseFee, String rflIncluded, String pensePerExcessMileFinance, String aPR,
			String commission2, String partExchangeActual, String partExchangeGiven, String lessFinanceSettlement,
			String sheet_name) throws InterruptedException, IOException {

		ExplicitWait.visibleElement(driver, otrScreenPrice, 30);
		String otr_screen_price = otrScreenPrice.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		double on_road_price_for_invoice = GetExcelFormulaValue.get_formula_value(14, 4, sheet_name);

		double diff = Difference.of_two_Double_Values(on_road_price_for_invoice, otr_screen_price_converted);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("");
		System.out.println("");

		LO.print("Adding Funder Quote Values to Screen");
		System.out.println("Adding Funder Quote Values to Screen");

		Click.on(driver, customer_quote_funder, 60);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		Click.sendKeys(driver, quote_reference, quoteRef, 60);

		Click.sendKeys(driver, expiry_date, quoteExpiryDate, 60);

		Click.sendKeys(driver, term_period, term, 60);

		Click.sendKeys(driver, miles_per_annum, milesperannum, 60);

		Click.on(driver, contract_miles, 20);

		Click.sendKeys(driver, cashdeposit, cahDeposit, 60);

		Click.sendKeys(driver, noOfMonthlyPayment, noOfMonthlyPayments, 60);

		Click.sendKeys(driver, monthlyfinancePayment, monthlyFinancePayment, 60);

		Click.sendKeys(driver, optionalfinalPayment, optionalFinalPayment, 60);

		Click.sendKeys(driver, optiontoPurchaseFee, optionToPurchaseFee, 60);

		Dropdown.selectByVisibleText(driver, rFLIncluded, rflIncluded, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_Finance, pensePerExcessMileFinance, 60);

		Click.sendKeys(driver, apr, aPR, 60);

		Click.sendKeys(driver, commission, commission2, 60);

		Click.on(driver, add, 60);

		LO.print("Funder Quote Added Successfully");
		System.out.println("Funder Quote Added Successfully");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("");
		System.out.println("");

		LO.print("Entering Part Exchange Values to screen");
		System.out.println("Entering Part Exchange Values to screen");

		Click.sendKeys(driver, partExchangeactual, partExchangeActual, 60);

		Click.sendKeys(driver, partExchangegiven, partExchangeGiven, 60);

		Click.sendKeys(driver, lessFinancesettlement, lessFinanceSettlement, 60);

		act.sendKeys(Keys.TAB).build().perform();

		LO.print("");
		System.out.println("");

		LO.print("Started verifying Balance To Finance");
		System.out.println("Started verifying Balance To Finance");

		ExplicitWait.visibleElement(driver, part_exchange_profit, 30);

		double part_exchange_profit_from_screen = Double
				.parseDouble(RemoveComma.of(part_exchange_value.getText().trim().substring(2)));

		LO.print("Funder quote added successfully");
		System.out.println("Funder quote added successfully");

		Click.on(driver, customer_quote_summary, 60);

		double balance_to_finance_expected = (otr_screen_price_converted - Double.parseDouble(cahDeposit)
				- part_exchange_profit_from_screen);

		LO.print("Balance To Finance Expected is =" + balance_to_finance_expected);
		System.out.println("Balance To Finance Expected is =" + balance_to_finance_expected);

		ExplicitWait.visibleElement(driver, customer_quote_summary_balance_to_finance, 20);

		double balance_to_finance_actual = Double
				.parseDouble(RemoveComma.of(customer_quote_summary_balance_to_finance.getText().trim().substring(2)));

		LO.print("Balance To Finance Actual From Screen is =" + balance_to_finance_actual);
		System.out.println("Balance To Finance Actual From Screen is =" + balance_to_finance_actual);

		boolean balance_to_finance_status = false;

		if (Difference.of_two_Double_Values(balance_to_finance_expected, balance_to_finance_actual) < 0.2) {
			balance_to_finance_status = true;
			LO.print("Balance to finance value from customer quote summary - verified");
			System.out.println("Balance to finance value from customer quote summary - verified");
		} else {
			LO.print("xxx -Please check Balance to finance value from customer quote summary");
			System.err.println("xxx -Please check Balance to finance value from customer quote summary");
		}

		return balance_to_finance_status;
	}

	public boolean customer_Quote_vehicle_profit_checking_broker_cp_with_maintenance(String vehicleProfit,
			String quoteRef, String quoteExpiryDate, String term, String milesperannum, String contractMileage,
			String cahDeposit, String noOfMonthlyPayments, String monthlyFinancePayment, String optionalFinalPayment,
			String optionToPurchaseFee, String rflIncluded, String pensePerExcessMileFinance, String aPR,
			String commission2, String partExchangeActual, String partExchangeGiven, String lessFinanceSettlement,
			String sheet_name) throws InterruptedException, IOException {

		Click.on(driver, customer_quote, 25);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		ExplicitWait.visibleElement(driver, otrScreenPrice, 30);
		String otr_screen_price = otrScreenPrice.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 60);

		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		int profit = Integer.parseInt(vehicleProfit);

		Click.sendKeysint(driver, vehicle_profit_input, profit, 40);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();

		double vehicleProfit_converted = Double.parseDouble(vehicleProfit);
		ExplicitWait.visibleElement(driver, vehicle_sale_price, 20);
		String vehicle_sale_price_from_screen = RemoveComma.of(vehicle_sale_price.getText().trim().substring(2));
		double vehicle_sale_price_from_screen_converted = Double.parseDouble(vehicle_sale_price_from_screen);

		double diff2 = Difference.of_two_Double_Values(otr_screen_price_converted,
				vehicle_sale_price_from_screen_converted);

		LO.print("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);
		System.out.println("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);

		LO.print("After adding profit to cost price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_sale_price_from_screen_converted);
		System.out.println("After adding profit to cost price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_sale_price_from_screen_converted);

		boolean vehicle_profit_status = false;

		if (diff2 == (vehicleProfit_converted * 1.2)) {
			vehicle_profit_status = true;
			LO.print("Vehicle profit verified");
			System.out.println("Vehicle profit verified");
		}

		return vehicle_profit_status;
	}

	public boolean customer_Quote_vehicle_profit_checking_broker_purchase_with_maintenance(String vehicleProfit,
			String quoteRef, String quoteExpiryDate, String term, String milesperannum, String contractMileage,
			String cahDeposit, String noOfMonthlyPayments, String monthlyFinancePayment, String optionalFinalPayment,
			String optionToPurchaseFee, String rflIncluded, String pensePerExcessMileFinance, String aPR,
			String commission2, String partExchangeActual, String partExchangeGiven, String lessFinanceSettlement,
			String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		Click.on(driver, customer_quote, 25);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		ExplicitWait.visibleElement(driver, otrScreenPriceUsedVehicle, 30);
		String otr_screen_price = otrScreenPriceUsedVehicle.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 60);

		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		int profit = Integer.parseInt(vehicleProfit);

		Click.sendKeysint(driver, vehicle_profit_input, profit, 40);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();

		double vehicleProfit_converted = Double.parseDouble(vehicleProfit);
		ExplicitWait.visibleElement(driver, vehicle_sale_price_used_vehicle, 20);
	
		vehicle_sale_price_used_vehicle.sendKeys(Keys.chord(Keys.CONTROL, "a", "c"));

	       Clipboard clipboard =Toolkit.getDefaultToolkit().getSystemClipboard();
	       String vehicle_sales_price_copied =(String) clipboard.getData(DataFlavor.stringFlavor);
		
			double vehicle_sales_price_from_screen_converted = Double.parseDouble(vehicle_sales_price_copied);

	       
		double diff2 = Difference.of_two_Double_Values(otr_screen_price_converted,
				vehicle_sales_price_from_screen_converted);

		LO.print("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);
		System.out.println("Vehicle profit from test data " + vehicleProfit_converted + " added to otr cost price "
				+ otr_screen_price_converted);

		LO.print("After adding profit to cost price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_sales_price_from_screen_converted);
		System.out.println("After adding profit to cost price " + otr_screen_price_converted
				+ " sales price is shown as (considering VAT%) " + vehicle_sales_price_from_screen_converted);

		boolean vehicle_profit_status = false;

		if (diff2 == (vehicleProfit_converted * 1.2)) {
			vehicle_profit_status = true;
			LO.print("Vehicle profit verified");
			System.out.println("Vehicle profit verified");
		}

		return vehicle_profit_status;
	}

	
	public boolean customer_Quote_balance_to_finance_checking_broker_cp_with_maintenance(String vehicleProfit,
			String quoteRef, String quoteExpiryDate, String term, String milesperannum, String contractMileage,
			String cahDeposit, String noOfMonthlyPayments, String monthlyFinancePayment, String optionalFinalPayment,
			String monthlyMaintenancePayment, String optionToPurchaseFee, String rflIncluded,
			String pensePerExcessMileFinance, String pensePerExcessMileMaintenance, String aPR, String commission2,
			String partExchangeActual, String partExchangeGiven, String lessFinanceSettlement, String sheet_name)
			throws InterruptedException, IOException {

		ExplicitWait.visibleElement(driver, otrScreenPrice, 30);
		String otr_screen_price = otrScreenPrice.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		double on_road_price_for_invoice = GetExcelFormulaValue.get_formula_value(14, 4, sheet_name);

		double diff = Difference.of_two_Double_Values(on_road_price_for_invoice, otr_screen_price_converted);
		Thread.sleep(4000);

		Click.on(driver, maintenance_toggle_button, 20);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("");
		System.out.println("");

		LO.print("Adding Funder Quote Values to Screen");
		System.out.println("Adding Funder Quote Values to Screen");

		Click.on(driver, customer_quote_funder, 60);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		Click.sendKeys(driver, quote_reference, quoteRef, 60);

		Click.sendKeys(driver, expiry_date, quoteExpiryDate, 60);

		Click.sendKeys(driver, term_period, term, 60);

		Click.sendKeys(driver, miles_per_annum, milesperannum, 60);

		Click.on(driver, contract_miles, 20);

		Click.sendKeys(driver, cashdeposit, cahDeposit, 60);

		Click.sendKeys(driver, noOfMonthlyPayment, noOfMonthlyPayments, 60);

		Click.sendKeys(driver, monthlyfinancePayment, monthlyFinancePayment, 60);

		Click.sendKeys(driver, optionalfinalPayment, optionalFinalPayment, 60);

		Click.sendKeys(driver, monthly_maintenance_payment, monthlyMaintenancePayment, 60);

		Click.sendKeys(driver, optiontoPurchaseFee, optionToPurchaseFee, 60);

		Dropdown.selectByVisibleText(driver, rFLIncluded, rflIncluded, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_Finance, pensePerExcessMileFinance, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_maintenance, pensePerExcessMileMaintenance, 60);

		Click.sendKeys(driver, apr, aPR, 60);

		Click.sendKeys(driver, commission, commission2, 60);

		Click.on(driver, add, 60);

		LO.print("Funder quote added successfully");
		System.out.println("Funder quote added successfully");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("");
		System.out.println("");

		LO.print("Entering Part Exchange Values to screen");
		System.out.println("Entering Part Exchange Values to screen");

		Click.sendKeys(driver, partExchangeactual, partExchangeActual, 60);

		Click.sendKeys(driver, partExchangegiven, partExchangeGiven, 60);

		Click.sendKeys(driver, lessFinancesettlement, lessFinanceSettlement, 60);

		act.sendKeys(Keys.TAB).build().perform();

		LO.print("");
		System.out.println("");

		LO.print("Started verifying Balance To Finance");
		System.out.println("Started verifying Balance To Finance");

		ExplicitWait.visibleElement(driver, part_exchange_profit, 30);

		double part_exchange_profit_from_screen = Double
				.parseDouble(RemoveComma.of(part_exchange_value.getText().trim().substring(2)));

		Click.on(driver, customer_quote_summary, 60);

		double balance_to_finance_expected = (otr_screen_price_converted - Double.parseDouble(cahDeposit)
				- part_exchange_profit_from_screen);

		LO.print("Balance To Finance Expected is =" + balance_to_finance_expected);
		System.out.println("Balance To Finance Expected is =" + balance_to_finance_expected);

		ExplicitWait.visibleElement(driver, customer_quote_summary_balance_to_finance, 20);

		double balance_to_finance_actual = Double
				.parseDouble(RemoveComma.of(customer_quote_summary_balance_to_finance.getText().trim().substring(2)));

		LO.print("Balance To Finance Actual From Screen is =" + balance_to_finance_actual);
		System.out.println("Balance To Finance Actual From Screen is =" + balance_to_finance_actual);

		boolean balance_to_finance_status = false;

		if (Difference.of_two_Double_Values(balance_to_finance_expected, balance_to_finance_actual) < 0.2) {
			balance_to_finance_status = true;
			LO.print("Balance to finance value from customer quote summary - verified");
			System.out.println("Balance to finance value from customer quote summary - verified");
		} else {
			LO.print("xxx -Please check Balance to finance value from customer quote summary");
			System.err.println("xxx -Please check Balance to finance value from customer quote summary");
		}

		return balance_to_finance_status;
	}

	public boolean customer_Quote_balance_to_finance_checking_broker_purchase_for_used_vehicle_with_maintenance(String vehicleProfit,
			String quoteRef, String quoteExpiryDate, String term, String milesperannum, String contractMileage,
			String cahDeposit, String noOfMonthlyPayments, String monthlyFinancePayment, String optionalFinalPayment,
			String monthlyMaintenancePayment, String optionToPurchaseFee, String rflIncluded,
			String pensePerExcessMileFinance, String pensePerExcessMileMaintenance, String aPR, String commission2,
			String partExchangeActual, String partExchangeGiven, String lessFinanceSettlement, String sheet_name)
			throws InterruptedException, IOException {

		ExplicitWait.visibleElement(driver, otrScreenPriceUsedVehicle, 30);
		String otr_screen_price = otrScreenPriceUsedVehicle.getText().trim().substring(2);
		String otr = RemoveComma.of(otr_screen_price);
		double otr_screen_price_converted = Double.parseDouble(otr);

		double on_road_price_for_invoice = GetExcelFormulaValue.get_formula_value(18, 4, sheet_name);

		double diff = Difference.of_two_Double_Values(on_road_price_for_invoice, otr_screen_price_converted);
		Thread.sleep(4000);

		Click.on(driver, maintenance_toggle_button, 20);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("");
		System.out.println("");

		LO.print("Adding Funder Quote Values to Screen");
		System.out.println("Adding Funder Quote Values to Screen");

		Click.on(driver, customer_quote_funder, 60);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		Click.sendKeys(driver, quote_reference, quoteRef, 60);

		Click.sendKeys(driver, expiry_date, quoteExpiryDate, 60);

		Click.sendKeys(driver, term_period, term, 60);

		Click.sendKeys(driver, miles_per_annum, milesperannum, 60);

		Click.on(driver, contract_miles, 20);

		Click.sendKeys(driver, cashdeposit, cahDeposit, 60);

		Click.sendKeys(driver, noOfMonthlyPayment, noOfMonthlyPayments, 60);

		Click.sendKeys(driver, monthlyfinancePayment, monthlyFinancePayment, 60);

		Click.sendKeys(driver, optionalfinalPayment, optionalFinalPayment, 60);

		Click.sendKeys(driver, monthly_maintenance_payment, monthlyMaintenancePayment, 60);

		Click.sendKeys(driver, optiontoPurchaseFee, optionToPurchaseFee, 60);

		Dropdown.selectByVisibleText(driver, rFLIncluded, rflIncluded, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_Finance, pensePerExcessMileFinance, 60);

		Click.sendKeys(driver, pence_Per_ExcessMileage_maintenance, pensePerExcessMileMaintenance, 60);

		Click.sendKeys(driver, apr, aPR, 60);

		Click.sendKeys(driver, commission, commission2, 60);

		Thread.sleep(2000);
		
		Click.on(driver, add, 60);

		LO.print("Funder quote added successfully");
		System.out.println("Funder quote added successfully");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		LO.print("");
		System.out.println("");

		LO.print("Entering Part Exchange Values to screen");
		System.out.println("Entering Part Exchange Values to screen");

		Click.sendKeys(driver, partExchangeactual, partExchangeActual, 60);

		Click.sendKeys(driver, partExchangegiven, partExchangeGiven, 60);

		Click.sendKeys(driver, lessFinancesettlement, lessFinanceSettlement, 60);

		act.sendKeys(Keys.TAB).build().perform();

		LO.print("");
		System.out.println("");

		LO.print("Started verifying Balance To Finance");
		System.out.println("Started verifying Balance To Finance");

		ExplicitWait.visibleElement(driver, part_exchange_profit, 30);

		double part_exchange_profit_from_screen = Double
				.parseDouble(RemoveComma.of(part_exchange_value.getText().trim().substring(2)));

		Click.on(driver, customer_quote_summary, 60);

		double balance_to_finance_expected = (otr_screen_price_converted - Double.parseDouble(cahDeposit)
				- part_exchange_profit_from_screen);

		LO.print("Balance To Finance Expected is =" + balance_to_finance_expected);
		System.out.println("Balance To Finance Expected is =" + balance_to_finance_expected);

		ExplicitWait.visibleElement(driver, customer_quote_summary_balance_to_finance, 20);

		double balance_to_finance_actual = Double
				.parseDouble(RemoveComma.of(customer_quote_summary_balance_to_finance.getText().trim().substring(2)));

		LO.print("Balance To Finance Actual From Screen is =" + balance_to_finance_actual);
		System.out.println("Balance To Finance Actual From Screen is =" + balance_to_finance_actual);

		boolean balance_to_finance_status = false;

		if (Difference.of_two_Double_Values(balance_to_finance_expected, balance_to_finance_actual) < 0.2) {
			balance_to_finance_status = true;
			LO.print("Balance to finance value from customer quote summary - verified");
			System.out.println("Balance to finance value from customer quote summary - verified");
		} else {
			LO.print("xxx -Please check Balance to finance value from customer quote summary");
			System.err.println("xxx -Please check Balance to finance value from customer quote summary");
		}

		return balance_to_finance_status;
	}

	
}
