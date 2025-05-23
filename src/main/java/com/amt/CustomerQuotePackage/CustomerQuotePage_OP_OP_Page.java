package com.amt.CustomerQuotePackage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ConfigConstants;
import com.amt.testUtil.Difference;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.ReadExcelCalculationForPurchaseAgreement;
import com.amt.testUtil.RemoveComma;

public class CustomerQuotePage_OP_OP_Page extends TestBase {

	CustomerQuotePage_OP_OP_Page obj_cust_quote_outright_bchPage;
	ReadExcelCalculationForPurchaseAgreement obj_read_excel_calculation_page;

	

	JavascriptExecutor jse;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;
	
	

	// vehicle_discount_cost_price
	@FindBy(xpath = "//*[@id='bdiscount']//ancestor::div[3]//div//p")
	private WebElement vehicle_discount_cost_price;

	// vehicle_additional_discount_cost_price
	@FindBy(xpath = "(//*[@id='bdiscountvalue']//ancestor::div[3]//div)[1]")
	private WebElement vehicle_additional_discount_cost_price;

	// paint_discount_cost_price
	@FindBy(xpath = "(//*[@id='pdiscountper']//ancestor::div[3]//div)[1]")
	private WebElement paint_discount_cost_price;

	// paint_additional_discount_cost_price
	@FindBy(xpath = "(//*[@id='pdiscountvalue']//ancestor::div[3]//div)[1]")
	private WebElement paint_additional_discount_cost_price;

	// options_discount_cost_price
	@FindBy(xpath = "(//*[@id='odiscount']//ancestor::div[3]//div)[1]")
	private WebElement options_discount_cost_price;

	// options_additional_discount_cost_price
	@FindBy(xpath = "(//*[@id='odiscountvalue']//ancestor::div[3]//div)[1]")
	private WebElement options_additional_discount_cost_price;

	@FindBy(xpath = "//p[normalize-space()='Customer Quote']")
	private WebElement customer_quote;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-all-customer-quotes[1]/div[1]/app-aquisition-hire-agreement[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[6]/div[4]")
	private WebElement customer_quote_matrix_default_cell;

	@FindBy(xpath = "//*[normalize-space()='Monthly finance payment']//ancestor::div[1]//div//p//strong|//*[normalize-space()='Monthly finance rental']//ancestor::div[1]//div//p//strong")
	private WebElement customer_quote_monthly_finance_rental;
	
	@FindBy(xpath = "//*[normalize-space()='Monthly maint. payment']//ancestor::div[1]//div//p//strong|//*[normalize-space()='Monthly maint. rental']//ancestor::div[1]//div//p//strong")
	private WebElement customer_quote_monthly_maintenance_rental;

	@FindBy(xpath = "//*[normalize-space()='Total monthly payment']//ancestor::div[1]//div//p//strong|//*[normalize-space()='Total monthly rental']//ancestor::div[1]//div//p//strong")
	private WebElement customer_quote_monthly_total_rental;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/app-aquisition-header[1]/div[1]/div[2]/div[3]/button[1]")
	private WebElement save_button;

	@FindBy(xpath = "//select[@name='acquisitionPaymentProfileId']")
	private WebElement customer_quote_payment_profile_dropdown;

	@FindBy(xpath = "//*[@id='lessFinanceSettlement']")
	private WebElement less_finance_Settlement;

	@FindBy(xpath = "//input[@id='depositRequired']")
	private WebElement deposit_required;

	@FindBy(xpath = "//*[contains(text(),' Holding cost summary ')]")
	private WebElement holding_cost_summary;

	@FindBy(xpath = "//*[normalize-space()='Balance to finance']//ancestor::div[1]//div//p//strong")
	private WebElement balance_to_finance_value;

	@FindBy(xpath = "//*[@id='collapseFirst']/div/div/div[1]/label")
	private WebElement customer_quote_maintenance_toggle_button;

	@FindBy(xpath = "//input[@name='monetaryAmount']")
	private WebElement initial_payment_input_field;

	@FindBy(xpath = "//*[@id='upsell']")
	private WebElement matrix_upsell_input_field;

	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/app-purchase-customer-quote-summary-header/div/div[2]/div/p/strong")
	private WebElement terms;

	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/app-purchase-customer-quote-summary-header/div/div[3]/div/p/strong")
	private WebElement miles_per_annum;

	@FindBy(xpath = "//*[@id='bdiscount']")
	private WebElement vehicle_discount;

	@FindBy(xpath = "//*[@id='pdiscountper']")
	private WebElement paint_discount;

	@FindBy(xpath = "//*[@id='odiscount']")
	private WebElement options_discount;

	@FindBy(xpath = "//*[@id='bdiscountvalue']")
	private WebElement vehicle_additional_discount;

	@FindBy(xpath = "//*[@id='pdiscountvalue']")
	private WebElement paint_additional_discount;

	@FindBy(xpath = "//*[@id='odiscountvalue']")
	private WebElement options_additional_discount;

	@FindBy(xpath = "//input[@id='VehicleProfit']")
	private WebElement vehicle_profit_input;
	
	@FindBy(xpath = "//*[normalize-space()='Total profit']//ancestor::div[1]//div[2]//p")
	private WebElement total_profit;
	
	// referrer commission
	@FindBy(xpath = "//*[@id='referrerComm']")
	private WebElement referrer_commission_input;

	@FindBy(xpath = "(//*[normalize-space()='Vehicle sales price'])[2]//ancestor::div[2]//div[3]")
	private WebElement vehicle_sales_price;

	@FindBy(xpath = "//*[normalize-space()='On the road price']//ancestor::div[1]//div[2]//p//strong")
	private WebElement vehicle_otr_price;

	@FindBy(xpath = "//*[contains(text(),' Part exchange & additional payments ')]")
	private WebElement part_exchange_and_additional_payment_button;


	@FindBy(xpath = "//app-purchase-customer-quote-summary-header/div/div[6]/div/p/strong")
	private WebElement total_monthly_payment;

	@FindBy(xpath = "//input[@id='offInvoiceSupport']")
	private WebElement rebate_input_field;

	@FindBy(xpath = "//input[@id='salesTotal']|//input[@id='OnTheRoadPrice']")
	private WebElement vehicle_sale_price_used_vehicle;

	@FindBy(xpath = "//*[@id='registrationNumber']")
	private WebElement registration_number;

	@FindBy(xpath = "//*[normalize-space()='Search']")
	private WebElement search_button;

	@FindBy(xpath = "//*[@id='mileage']")
	private WebElement mileage;

	@FindBy(xpath = "//*[@id='partExchange']|//*[@id='partExchnage']")
	private WebElement given_part_exchange_value;

	@FindBy(xpath = "//*[normalize-space()='Part exchange & additional payments']")
	private WebElement part_exchange_payment;

	@FindBy(xpath = "//*[@id='otrPartExchange']")
	private WebElement actual_part_exchange_value;

	@FindBy(xpath = "//*[@id='lessFinanceSettlement']")
	private WebElement less_finance_settlement;

	@FindBy(xpath = "//*[@name='depositRequired']")
	private WebElement order_Deposit;

	@FindBy(xpath = "//*[@name='financeDeposit']")
	private WebElement finance_Deposit;

	@FindBy(xpath = "//*[@id='DocumentFeeOR']")
	private WebElement document_fee;

	@FindBy(xpath = "//*[@name='FunderName']")
	private WebElement funder_name;

	@FindBy(xpath = "//*[@name='agreementName']")
	private WebElement agreement_number;

	@FindBy(xpath = "//*[@id='settlementExpiredDate']")
	private WebElement settlement_expiry_date;

	@FindBy(xpath = "//*[@id='vatQualifying']")
	private WebElement check_box_vat_qualifying;

	@FindBy(xpath = "//*[@id='OutstandingFinance']")
	private WebElement check_box_outstanding_finance;

	@FindBy(xpath = "//*[@id='SupplierSettingFinance']")
	private WebElement check_box_supplier_setting_finance;

	@FindBy(xpath = "//*[normalize-space()='Part exchange balance']//following::div[1]")
	private WebElement part_exchange_balance;

	@FindBy(xpath = "//*[normalize-space()='Pending amount']//ancestor::div[1]//p//strong")
	private WebElement pending_amount;

	Properties prop;


	public CustomerQuotePage_OP_OP_Page() {
		
				try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(ConfigConstants.EXCEL_VALUES_PROPERTY_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PageFactory.initElements(driver, this);

	}


	public boolean edit_vehicle_profit_and_check_updated_sales_price(String vehicle_profit, String sheet_name)
			throws InterruptedException, UnsupportedFlavorException, IOException {

		Click.on(driver, customer_quote, 30);
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		LO.print("***********Entered in Customer Quote page ***********");
		System.out.println("***********Entered in Customer Quote page ***********");
		
		
		LO.print("");
		System.out.println("");
		
		LO.print("Adding the Vehicle Profit");
		System.out.println("Adding the Vehicle Profit");	

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 30);
		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeys(driver, vehicle_profit_input, vehicle_profit, 30);
		
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		
		
		ExplicitWait.visibleElement(driver, vehicle_sales_price, 30);
		double vehicleSalesPriceFromScreen = Double
				.parseDouble(RemoveComma.of(vehicle_sales_price.getText().trim().substring(2)));
		double vehicleOTRPriceFromScreen = Double
				.parseDouble(RemoveComma.of(vehicle_otr_price.getText().trim().substring(2)));
		double vehicleProfit = Double.parseDouble(vehicle_profit);
		double vehicleSalesPriceFromActual = vehicleOTRPriceFromScreen + (vehicleProfit * 1.2);

		double diff = Difference.of_two_Double_Values(vehicleSalesPriceFromScreen, vehicleSalesPriceFromActual);

		boolean status = true;

		if (diff < 0.2) {
			status = true;

			LO.print("Vehicle profit " + vehicleProfit + " added to OTR price " + vehicleOTRPriceFromScreen
					+ "and sales price updated is " + vehicleSalesPriceFromActual + " i.e. true");
			System.out.println("Vehicle profit " + vehicleProfit + " added to OTR price " + vehicleOTRPriceFromScreen
					+ "and sales price updated is " + vehicleSalesPriceFromActual + " i.e. true");
		}

		return status;
	}

	
	
	public boolean edit_referrer_commission_and_check_updated_total_profit(String referrer_commission, String sheet_name)
			throws InterruptedException, UnsupportedFlavorException, IOException {

		LO.print("");
		System.out.println("");
		
		LO.print("Adding the referrer commission");
		System.out.println("Adding the referrer commission");

		

		ExplicitWait.visibleElement(driver, referrer_commission_input, 30);
		referrer_commission_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeys(driver, referrer_commission_input, referrer_commission, 30);
		
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		
		ExplicitWait.visibleElement(driver, total_profit, 30);
		
		
			
//		double totalProfitActual = Double
//				.parseDouble(RemoveComma.of(total_profit.getText()).trim().split(" ")[1].replaceAll("[^\\d.]", ""));
	
        StringBuilder cleanedNumber = new StringBuilder();
       
        boolean decimalPointEncountered = false;
        boolean arithmeticSymbolEncountered = false;
		

	        for (char c : total_profit.getText().toCharArray()) {
	            if (Character.isDigit(c) ||c == '-') {
	                cleanedNumber.append(c);
	            } else if (c == '.' && !decimalPointEncountered) {
	                cleanedNumber.append(c);
	                decimalPointEncountered = true;
	            }
//	            else if ((c == '-') && !arithmeticSymbolEncountered && cleanedNumber.length() == 0) {
//	                cleanedNumber.append(c);
//	                arithmeticSymbolEncountered = true;
//	            }
	        }

	        double totalProfitActual =  Double.parseDouble(cleanedNumber.toString());
		
		
		double totalProfitExpected = Double.parseDouble(vehicle_profit_input.getAttribute("value")) - Double.parseDouble(referrer_commission);
	
		
		System.out.println("Actual total profit " + totalProfitActual + " and Expected total profit " + totalProfitExpected);


		double diff = Difference.of_two_Double_Values(totalProfitActual, totalProfitExpected);

		boolean status = true;

		if (diff < 0.05) {
			status = true;

			LO.print("Actual total profit " + totalProfitActual + " equals to the Expected total profit " + totalProfitExpected+ " i.e. true");
			System.out.println("Actual total profit " + totalProfitActual + " equals to the Expected total profit " + totalProfitExpected+ " i.e. true");
		}
		else 
		{
			LO.print("Actual total profit " + totalProfitActual + " does not equal to the Expected total profit " + totalProfitExpected);
			System.err.println("Actual total profit " + totalProfitActual + " does not equal to the Expected total profit " + totalProfitExpected);

		}
		return status;
	}

	
	public boolean edit_vehicle_profit_and_sales_price_for_used_vehicle(String vehicle_profit, String sheet_name)
			throws InterruptedException, UnsupportedFlavorException, IOException {

		Click.on(driver, customer_quote, 30);

		LO.print("***********Entered in Customer Quote page ***********");
		System.out.println("***********Entered in Customer Quote page ***********");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, vehicle_profit_input, 30);
		vehicle_profit_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeys(driver, vehicle_profit_input, vehicle_profit, 30);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, vehicle_sale_price_used_vehicle, 20);
		double vehicle_sales_price_from_screen_converted =  Double.parseDouble(vehicle_sale_price_used_vehicle.getAttribute("value"));
		

		double vehicleOTRPriceFromScreen = Double
				.parseDouble(RemoveComma.of(vehicle_otr_price.getText().trim().substring(2)));
		double vehicleProfit = Double.parseDouble(vehicle_profit);
		double vehicleSalesPriceFromActual = vehicleOTRPriceFromScreen + (vehicleProfit * 1.2);

		double diff = Difference.of_two_Double_Values(vehicle_sales_price_from_screen_converted,
				vehicleSalesPriceFromActual);

		boolean status = true;

		if (diff < 0.2) {
			status = true;

			LO.print("Vehicle profit " + vehicleProfit + " added to OTR price " + vehicleOTRPriceFromScreen
					+ "and sales price updated is " + vehicleSalesPriceFromActual + " i.e. true");
			System.out.println("Vehicle profit " + vehicleProfit + " added to OTR price " + vehicleOTRPriceFromScreen
					+ "and sales price updated is " + vehicleSalesPriceFromActual + " i.e. true");
		}

		return status;
	}

	public boolean put_part_exchange_values_and_check_pending_amount(String part_exchange_actual,
			String given_part_exchange_value_from_excel, String less_finance_settlement_from_excel,
			String order_Deposit_from_excel, String finance_deposit_from_excel, String document_fee_from_excel,
			String sheet_name) throws UnsupportedFlavorException, IOException, InterruptedException {

		LO.print("");
		System.out.println("");
		
		LO.print("Adding deposit values");
		System.out.println("Adding deposit values");

		
		Actions act = new Actions(driver);
		
		Click.on(driver, part_exchange_and_additional_payment_button, 20);
		Thread.sleep(4000);

		ExplicitWait.visibleElement(driver, order_Deposit, 20);
		order_Deposit.clear();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, order_Deposit, order_Deposit_from_excel, 30);
		act.sendKeys(Keys.TAB).perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		
		
		

		ExplicitWait.visibleElement(driver, document_fee, 30);
		document_fee.clear();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, document_fee, 30);
		document_fee.clear();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, document_fee, document_fee_from_excel, 30);
		act.sendKeys(Keys.TAB).perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		double vehicleSalesPriceFromScreen = Double
				.parseDouble(RemoveComma.of(vehicle_sales_price.getText().trim().substring(2)));

		double netPartExchangeAllowance = Double
				.parseDouble(RemoveComma.of(part_exchange_balance.getText().trim().substring(2)));

		double orderDeposit = Double.parseDouble(order_Deposit_from_excel);

		double documentfee = Double.parseDouble(document_fee_from_excel);

		double pendingAmountExpected = vehicleSalesPriceFromScreen - orderDeposit - netPartExchangeAllowance
				+ (documentfee * 1.2);

		double pendingAmountFromScreen = Double
				.parseDouble(RemoveComma.of(pending_amount.getText().trim().substring(2)));

		double diff = Difference.of_two_Double_Values(pendingAmountExpected, pendingAmountFromScreen);

		boolean status = false;
		if (diff < 0.2) {
			status = true;
			LO.print("Pending Amount from screen " + pendingAmountFromScreen + " Verified Successfully "
					+ "with applied formula " + pendingAmountExpected + " i.e. true");
			System.out.println("Pending Amount from screen " + pendingAmountFromScreen + " Verified Successfully "
					+ "with applied formula " + pendingAmountExpected + " i.e. true");
		}else
		{
			LO.print("Pending Amount from screen is " + pendingAmountFromScreen
					+ "and Pending Amount Expected is " + pendingAmountExpected + " found wrong");
			System.out.println("Pending Amount from screen is " + pendingAmountFromScreen
					+ "and Pending Amount Expected is " + pendingAmountExpected + " found wrong");

		}

		return status;

	}

	public boolean put_part_exchange_values_and_check_pending_amount_for_used_vehicle(String part_exchange_actual,
			String given_part_exchange_value_from_excel, String less_finance_settlement_from_excel, String deposit, String documentFee,
			String sheet_name) throws UnsupportedFlavorException, IOException, InterruptedException {

		
		LO.print("");
		System.out.println("");
		
		LO.print("Adding deposit values");
		System.out.println("Adding deposit values");

		
		Actions act = new Actions(driver);
		
		Click.on(driver, part_exchange_and_additional_payment_button, 20);
		Thread.sleep(4000);
		
		Click.on(driver, deposit_required, 30);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, deposit_required, deposit, 30);

		Click.on(driver, document_fee, 30);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, document_fee, documentFee, 30);
		
		act.sendKeys(Keys.TAB).perform();		
		
		ExplicitWait.visibleElement(driver, vehicle_sale_price_used_vehicle, 20);
		
		
		double vehicle_sales_price_from_screen_converted =  Double.parseDouble(vehicle_sale_price_used_vehicle.getAttribute("value"));
			


		double netPartExchangeAllowance = Double
				.parseDouble(RemoveComma.of(part_exchange_balance.getText().trim().substring(2)));

		double orderDeposit = Double.parseDouble(deposit);

		double documentfee = Double.parseDouble(documentFee);

		double pendingAmountExpected = vehicle_sales_price_from_screen_converted - orderDeposit - netPartExchangeAllowance
				+ (documentfee * 1.2);

		double pendingAmountFromScreen = Double
				.parseDouble(RemoveComma.of(pending_amount.getText().trim().substring(2)));
		

		double diff = Difference.of_two_Double_Values(pendingAmountExpected, pendingAmountFromScreen);

		boolean status = false;
		if (diff < 0.2) {
			status = true;
			LO.print("Pending Amount from screen " + pendingAmountFromScreen + " Verified Successfully "
					+ "with applied formula " + pendingAmountExpected + " i.e. true");
			System.out.println("Pending Amount from screen " + pendingAmountFromScreen + " Verified Successfully "
					+ "with applied formula " + pendingAmountExpected + " i.e. true");
		}

		return status;

	}

}
