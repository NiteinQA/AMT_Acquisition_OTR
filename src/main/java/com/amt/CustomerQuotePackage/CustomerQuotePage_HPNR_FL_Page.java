package com.amt.CustomerQuotePackage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.RemoveComma;

public class CustomerQuotePage_HPNR_FL_Page extends TestBase {

	CustomerQuotePage_HPNR_FL_Page obj_cust_quote_outright_FLPage;
	ReadExcelCalculation obj_read_excel_calculation_page;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;
	
	@FindBy(xpath = "//*[contains(text(),' Part exchange & additional payments ')]")
    private WebElement part_exchange_and_additional_payment_button;

	@FindBy(xpath = "//*[@name='withBalloon']//ancestor::label[1]//span")
	private WebElement with_balloon_toggle;

	@FindBy(xpath = "//p[normalize-space()='Customer Quote']")
	private WebElement customer_quote;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-all-customer-quotes[1]/div[1]/app-aquisition-hire-agreement[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[6]/div[4]")
	private WebElement customer_quote_matrix_default_cell;

	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/app-hire-customer-quote-summary-header/div/div[4]/div/p/strong")
	private WebElement customer_quote_monthly_finance_reantal;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/app-aquisition-header[1]/div[1]/div[2]/div[3]/button[1]")
	private WebElement save_button;

	@FindBy(xpath = "//select[@name='acquisitionPaymentProfileId']")
	private WebElement customer_quote_payment_profile_dropdown;

	@FindBy(xpath = "//*[normalize-space()='Monthly finance payment']//ancestor::div[1]//div//p//strong|//*[normalize-space()='Monthly finance rental']//ancestor::div[1]//div//p//strong")
	private WebElement customer_quote_monthly_finance_rental;
	
	@FindBy(xpath = "//*[normalize-space()='Monthly maint. payment']//ancestor::div[1]//div//p//strong|//*[normalize-space()='Monthly maint. rental']//ancestor::div[1]//div//p//strong")
	private WebElement customer_quote_monthly_maintenance_rental;

	@FindBy(xpath = "//*[normalize-space()='Total monthly payment']//ancestor::div[1]//div//p//strong|//*[normalize-space()='Total monthly rental']//ancestor::div[1]//div//p//strong")
	private WebElement customer_quote_monthly_total_rental;

	@FindBy(xpath = "//span[@class='slider round']")
	private WebElement customer_quote_maintenance_toggle_button;

	@FindBy(xpath = "//input[@name='monetaryAmount']")
	private WebElement initial_payment_input_field;

	@FindBy(xpath = "//label[@class='switch mr-2']//span[@class='slider round']")
	private WebElement part_exchange_toggle;

	@FindBy(xpath = "//*[normalize-space()='Net part exchange allowance']//ancestor::div[1]//p//strong")
	private WebElement part_exchange_allowance;

	@FindBy(xpath = "//*[normalize-space()='Balance due']//ancestor::div[1]//p//strong")
	private WebElement balance_due_value;

	// security deposit
	@FindBy(xpath = "//*[@id='securityDeposit']")
	private WebElement security_deposit_input_field;

	// matrix upsell
	@FindBy(xpath = "//*[@id='upsell']")
	private WebElement matrix_upsell_input_field;

	// referrer commission
	@FindBy(xpath = "//*[@id='FinanceCommission']")
	private WebElement referrer_upsell_input_field;

	// upsell cust summary
	@FindBy(xpath = "//*[@id='Upsell']")
	private WebElement summary_upsell_input_field;

	// cust quote summary

	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[1]/button")
	private WebElement customer_quote_summary;

	// Final balloon input field
	@FindBy(xpath = "//*[normalize-space()='Final balloon payment']//ancestor::div[1]//div//input")
	private WebElement summary_final_balloon_input_field;

	@FindBy(xpath = "//p[contains(text(),'Holding cost')]")
	private WebElement holding_cost;

	@FindBy(xpath = "//*[contains(text(),' Holding cost summary ')]")
	private WebElement holding_cost_summary;

	@FindBy(xpath = "//*[contains(text(),'CAP residual value')]//ancestor::div[1]//p//strong")
	private WebElement holding_cost_summary_residual_value_used;

	@FindBy(xpath = "//*[normalize-space()='Total CAP maint. value (ex. VAT):']//ancestor::div[1]//p|//*[normalize-space()='Total CAP maint. value (ex. VAT) :']//ancestor::div[1]//p")
	private WebElement total_cap_maintenance_value;

	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[1]/div/p/strong")
	private WebElement holding_cost_summary_terms;

	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[2]/div/p/strong")
	private WebElement holding_cost_summary_mileage;

	@FindBy(xpath = "//input[@id='ResidualValue']")
	private WebElement residual_value_used;

	@FindBy(xpath = "//input[@id='Maintenancevalue3']")
	private WebElement maintenance_cost_used;

	@FindBy(xpath = "//*[@id='ResidualPercentage']")
	private WebElement holding_cost_percentage_cap_residual_value_used;

	@FindBy(xpath = "//input[@id='CapMaintenancePercentage']")
	private WebElement holding_cost_percentage_maintenance_cost_used;

	// part Exchage elements

	@FindBy(xpath = "//*[@id='registrationNumber']")
	private WebElement registration_number;

	@FindBy(xpath = "//*[normalize-space()='Search']")
	private WebElement search_button;

	@FindBy(xpath = "//*[@id='mileage']")
	private WebElement mileage;

	@FindBy(xpath = "//*[@id='partExchange']|//*[@id='partExchnage']")
	private WebElement given_part_exchange_value;

	@FindBy(xpath = "//*[@id='partExchange_1']/button/div")
	private WebElement part_exchange_payment;

	@FindBy(xpath = "//*[@id='otrPartExchange']")
	private WebElement actual_part_exchange_value;

	@FindBy(xpath = "//*[@id='lessFinanceSettlement']")
	private WebElement less_finance_settlement;

	@FindBy(xpath = "//*[@name='orderDepositHire']|//*[@name='orderDeposit']")
	private WebElement order_Deposit;

	@FindBy(xpath = "//*[@name='financeDeposit']")
	private WebElement finance_Deposit;

	@FindBy(xpath = "//*[@id='DocumentFee']|//*[@id='DocumentFeeHire']")
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

	Properties prop;
	
	public CustomerQuotePage_HPNR_FL_Page() {
	

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

	public boolean customer_Quote_for_one_payment_option_for_used_car_with_funder_quote_addition_without_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, ClassNotFoundException, FormulaParseException, IllegalStateException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		obj_read_excel_calculation_page
				.set_global_variables_to_excel_for_finance_lease_for_funder_quote_addition(sheet_name);
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_one_payment_options_for_funder_quote_addition_without_maintenance(
						driver, customer_quote_payment_profile_dropdown, part_exchange_payment,
						actual_part_exchange_value, actual_part_exchange_value_from_excel, given_part_exchange_value,
						given_part_exchange_value_from_excel, less_finance_settlement,
						less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
						document_fee_from_excel, upsell, customer_quote_monthly_finance_rental, maintenance_required,
						maintenance_margin, initial_payment, part_exchange_status, target_rental, sheet_name);
	}

	public boolean customer_Quote_for_one_payment_option_for_used_car_with_funder_quote_addition_with_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, ClassNotFoundException, FormulaParseException, IllegalStateException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();

		ExplicitWait.clickableElement(driver, holding_cost, 20);

		Click.on(driver, holding_cost, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		
		ExplicitWait.visibleElement(driver, total_cap_maintenance_value, 30);

		double totalCapMaintenanceValue = Double
				.parseDouble(RemoveComma.of(total_cap_maintenance_value.getText().trim().substring(2)));

		Click.on(driver, customer_quote, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Actions act = new Actions(driver);

		if (totalCapMaintenanceValue == 0) {

			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
			obj_read_excel_calculation_page
					.set_global_variables_to_excel_for_finance_lease_for_funder_quote_addition(sheet_name);
			return obj_read_excel_calculation_page
					.verify_customer_quote_calculations_for_one_payment_options_for_funder_quote_addition_without_maintenance(
							driver, customer_quote_payment_profile_dropdown, part_exchange_payment,
							actual_part_exchange_value, actual_part_exchange_value_from_excel,
							given_part_exchange_value, given_part_exchange_value_from_excel, less_finance_settlement,
							less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
							document_fee_from_excel, upsell, customer_quote_monthly_finance_rental,
							maintenance_required, maintenance_margin, initial_payment, part_exchange_status,
							target_rental, sheet_name);

		} else {

			

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			Click.on(driver, customer_quote_maintenance_toggle_button, 30);

			obj_read_excel_calculation_page
					.set_global_variables_to_excel_for_finance_lease_for_funder_quote_addition(sheet_name);
			return obj_read_excel_calculation_page
					.verify_customer_quote_calculations_for_one_payment_options_for_funder_quote_addition_with_maintenance(
							driver, customer_quote_payment_profile_dropdown, part_exchange_payment,
							actual_part_exchange_value, actual_part_exchange_value_from_excel,
							given_part_exchange_value, given_part_exchange_value_from_excel, less_finance_settlement,
							less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
							document_fee_from_excel, upsell, customer_quote_monthly_finance_rental,
							customer_quote_monthly_maintenance_rental, maintenance_required, maintenance_margin,
							initial_payment, part_exchange_status, target_rental, sheet_name);
		}
	}

	public boolean customer_Quote_for_used_vehicle_for_one_payment_option_with_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, UnsupportedFlavorException, NumberFormatException, ClassNotFoundException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, customer_quote_maintenance_toggle_button, 40);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, holding_cost, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, holding_cost_summary, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, holding_cost_summary_terms, 30);

		double duration = Double.parseDouble(holding_cost_summary_terms.getText().substring(0, 2));

		ExplicitWait.visibleElement(driver, holding_cost_summary_mileage, 30);

		double annual_mileage = Double.parseDouble(RemoveComma.of(holding_cost_summary_mileage.getText()));

		ExplicitWait.visibleElement(driver, holding_cost_summary_residual_value_used, 30);

		ExplicitWait.visibleElement(driver, holding_cost_percentage_cap_residual_value_used, 20);
		ExplicitWait.visibleElement(driver, holding_cost_percentage_maintenance_cost_used, 20);
		ExplicitWait.visibleElement(driver, residual_value_used, 20);
		ExplicitWait.visibleElement(driver, maintenance_cost_used, 20);
		
		
		double percentage_cap_residual_value =  Double.parseDouble(holding_cost_percentage_cap_residual_value_used.getAttribute("value"));
		Thread.sleep(1000);		
		double percentage_cap_maintenance_cost =  Double.parseDouble(holding_cost_percentage_maintenance_cost_used.getAttribute("value"));
		Thread.sleep(1000);
		double used_residual_value =  Double.parseDouble(residual_value_used.getAttribute("value"));
		Thread.sleep(1000);
		double total_cap_maintenance_value_converted =  Double.parseDouble(maintenance_cost_used.getAttribute("value"));

		
		Thread.sleep(1000);

		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 160);

		obj_read_excel_calculation_page.set_global_variables_for_used_car_to_excel(sheet_name);

		obj_read_excel_calculation_page.write_holding_cost_cap_values_to_excel_with_maintenance(duration,
				annual_mileage, used_residual_value, total_cap_maintenance_value_converted,
				percentage_cap_residual_value, percentage_cap_maintenance_cost, sheet_name);
try {
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_one_payment_options_with_maintenance(driver,
						customer_quote_payment_profile_dropdown, part_exchange_payment, actual_part_exchange_value,
						actual_part_exchange_value_from_excel, given_part_exchange_value,
						given_part_exchange_value_from_excel, less_finance_settlement,
						less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
						document_fee_from_excel, upsell, customer_quote_monthly_finance_rental,
						customer_quote_monthly_maintenance_rental, maintenance_required, maintenance_margin,
						initial_payment, part_exchange_status, target_rental, sheet_name);
}catch(Exception e)
{
	return obj_read_excel_calculation_page
			.verify_customer_quote_calculations_for_one_payment_options_without_maintenance(driver, 
					customer_quote_payment_profile_dropdown, part_exchange_payment, actual_part_exchange_value,
					actual_part_exchange_value_from_excel, given_part_exchange_value,
					given_part_exchange_value_from_excel, less_finance_settlement, 
					less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel,
					document_fee, document_fee_from_excel, upsell, customer_quote_monthly_finance_rental, 
					maintenance_required, maintenance_margin, initial_payment, part_exchange_status, 
					target_rental, sheet_name);			
			
}
	}

	public boolean check_monthly_finance_rental_with_part_exchange_without_maintenance(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String sheet_name) throws InterruptedException, IOException {


		Thread.sleep(4000);
		
		LO.print("Entering the deposit Values");
		System.out.println("Entering the deposit Values");
		
		Actions act = new Actions(driver);
		
		Click.on(driver, part_exchange_and_additional_payment_button, 20);
		Thread.sleep(4000);

//		Click.on(driver, given_part_exchange_value, 20);
//
//		given_part_exchange_value.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, given_part_exchange_value, given_part_exchange_value_from_excel, 30);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//		jse.executeScript("arguments[0].click();", check_box_outstanding_finance, 20);
//
//	
//
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, funder_name, "Funder X", 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, agreement_number, "123", 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		ExplicitWait.visibleElement(driver, less_finance_settlement, 20);
//		less_finance_settlement.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, less_finance_settlement, less_finance_settlement_from_excel, 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, order_Deposit, 20);
		order_Deposit.clear();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, order_Deposit, order_Deposit_from_excel, 30);
		act.sendKeys(Keys.TAB).perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

//		ExplicitWait.visibleElement(driver, document_fee, 30);
//		document_fee.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		ExplicitWait.visibleElement(driver, document_fee, 30);
//		document_fee.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, document_fee, document_fee_from_excel, 30);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
		String monthly_finance_rental = customer_quote_monthly_finance_rental.getText().substring(2);
		String monthly_finance_rental_actual = RemoveComma.of(monthly_finance_rental);
		double monthly_finance_rental_actual_converted = Double.parseDouble(monthly_finance_rental_actual);
		LO.print("Monthly Finance Rental from screen (after making part exchange toggle on) is "
				+ monthly_finance_rental_actual_converted);
		System.out.println("Monthly Finance Rental from screen (after making part exchange toggle on) is "
				+ monthly_finance_rental_actual_converted);

		LO.print("Writing part exchange values to excel");
		System.out.println("Writing part exchange values to excel");

		FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);

		wb.getSheet(sheet_name).getRow(111).getCell(3).setCellValue(0);
		wb.getSheet(sheet_name).getRow(111).getCell(4)
				.setCellValue(0);
		wb.getSheet(sheet_name).getRow(112).getCell(4)
				.setCellValue(0);
		wb.getSheet(sheet_name).getRow(109).getCell(1).setCellValue("NO");
		FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
		wb.write(out);

		double monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

		LO.print("Monthly Finance Rental from Excel (with part exchange values) is " + monthlyFinanceRentalFromExcel);
		System.out.println(
				"Monthly Finance Rental from Excel (with part exchange values) is " + monthlyFinanceRentalFromExcel);

		boolean flag = false;
		if ((Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
				monthlyFinanceRentalFromExcel) < 0.2)) {
			flag = true;
			LO.print("Monthly finance rental (with part exchange values) is found OK");
			System.out.println("Monthly finance rental (with part exchange values) is found OK");
		} else {
			LO.print("Monthly finance rental (with part exchange values) is found wrong");
			System.out.println("Monthly finance rental (with part exchange values) is found wrong");
		}

//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		FileInputStream in1 = new FileInputStream(prop.getProperty("formula_excel_path"));
//		XSSFWorkbook wb1 = new XSSFWorkbook(in1);
//
//		wb1.getSheet(sheet_name).getRow(109).getCell(1).setCellValue("NO");
//		FileOutputStream out1 = new FileOutputStream(prop.getProperty("formula_excel_path"));
//		wb1.write(out1);

		return flag;
	}

	public boolean verify_balance_due_value(String sheet_name)
			throws UnsupportedFlavorException, IOException, InterruptedException, ClassNotFoundException {

		LO.print("");
		System.out.println("");

		LO.print("Balance Due value started verifying");
		System.out.println("Balance Due value started verifying");

		// waiting for the elements
		ExplicitWait.visibleElement(driver, balance_due_value, 30);

		Thread.sleep(3000);

		// taking elements from screen

		double balanceDueFromScreen = Double
				.parseDouble(RemoveComma.of(balance_due_value.getText().trim().substring(2)));

		double balance_due_expected = 0;
		if (Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName().contains("funder")) {
			if(Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName().contains("ownbook"))
			{
				balance_due_expected = GetExcelFormulaValue.get_formula_value(118, 4, sheet_name);
			}else {
				balance_due_expected = GetExcelFormulaValue.get_formula_value(124, 4, sheet_name);
			}
		} else {
			balance_due_expected = GetExcelFormulaValue.get_formula_value(118, 4, sheet_name);
		}

		LO.print("Balance due value Actual from screen is " + balanceDueFromScreen);
		System.out.println("Balance due value Actual from screen is " + balanceDueFromScreen);
		LO.print("");
		System.out.println("");
		LO.print("Balance due value Expected from Excel is " + balance_due_expected);
		System.out.println("Balance due value Expected from Excel is " + balance_due_expected);
		LO.print("");
		System.out.println("");

		double diff = Difference.of_two_Double_Values(balanceDueFromScreen, balance_due_expected);

		boolean balance_value = false;
		if (diff < 0.3) {
			balance_value = true;
			LO.print("Balance due value (with part exchange values) is verified and found ok");
			System.out.println("Balance due value (with part exchange values) is verified and found ok");
		} else {

			LO.print("Balance due value (with part exchange values) found wrong");
			System.out.println("Balance due value (with part exchange values) found wrong");
		}

		return balance_value;
	}

	public boolean check_monthly_finance_rental_with_part_exchange_with_maintenance(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String sheet_name) throws InterruptedException, IOException {


		LO.print("Entering the deposit Values");
		System.out.println("Entering the deposit Values");
		
		Actions act = new Actions(driver);
		
		Click.on(driver, part_exchange_and_additional_payment_button, 20);
		Thread.sleep(4000);

//		Click.on(driver, given_part_exchange_value, 20);
//
//		given_part_exchange_value.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, given_part_exchange_value, given_part_exchange_value_from_excel, 30);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//		jse.executeScript("arguments[0].click();", check_box_outstanding_finance, 20);
//
//	
//
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, funder_name, "Funder X", 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, agreement_number, "123", 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		ExplicitWait.visibleElement(driver, less_finance_settlement, 20);
//		less_finance_settlement.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, less_finance_settlement, less_finance_settlement_from_excel, 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, order_Deposit, 20);
		order_Deposit.clear();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, order_Deposit, order_Deposit_from_excel, 30);
		act.sendKeys(Keys.TAB).perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

//		ExplicitWait.visibleElement(driver, document_fee, 30);
//		document_fee.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		ExplicitWait.visibleElement(driver, document_fee, 30);
//		document_fee.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, document_fee, document_fee_from_excel, 30);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
		double monthly_finance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));
		double monthly_maintenance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_maintenance_rental.getText().substring(2)));

		LO.print("Monthly Finance Rental from screen (with part exchange values) is "
				+ monthly_finance_rental_actual_converted);
		System.out.println("Monthly Finance Rental from screen (with part exchange values) is "
				+ monthly_finance_rental_actual_converted);

		LO.print("Monthly Mainte. Rental from screen (with part exchange values) is "
				+ monthly_maintenance_rental_actual_converted);
		System.out.println("Monthly Mainte. Rental from screen (with part exchange values) is "
				+ monthly_maintenance_rental_actual_converted);

		LO.print("Writing part exchange values to excel");
		System.out.println("Writing part exchange values to excel");

		FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);

		wb.getSheet(sheet_name).getRow(111).getCell(3).setCellValue(0);
		wb.getSheet(sheet_name).getRow(111).getCell(4)
				.setCellValue(0);
		wb.getSheet(sheet_name).getRow(112).getCell(4)
				.setCellValue(0);
		wb.getSheet(sheet_name).getRow(109).getCell(1).setCellValue("NO");
		FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
		wb.write(out);

		double monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

		double monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(88, 1, sheet_name);

		LO.print("Monthly Finance Rental from Excel (with part exchange values) is " + monthlyFinanceRentalFromExcel);
		System.out.println(
				"Monthly Finance Rental from Excel (with part exchange values) is " + monthlyFinanceRentalFromExcel);

		LO.print("Monthly Mainte. Rental from Excel (with part exchange values) is " + monthlyMainteRentalFromExcel);
		System.out.println(
				"Monthly Mainte. Rental from Excel (with part exchange values) is " + monthlyMainteRentalFromExcel);

		double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
				monthlyFinanceRentalFromExcel);

		double diff2 = Difference.of_two_Double_Values(monthly_maintenance_rental_actual_converted,
				monthlyMainteRentalFromExcel);

		boolean flag = false;
		if (diff1 < 0.2 && diff2 < 0.2) {
			flag = true;
			LO.print("Monthly finance and maint. rental (with part exchange values) is found OK");
			System.out.println("Monthly finance and maint. rental (with part exchange values) is found OK");
		} else {
			LO.print("Monthly finance and maint. rental (with part exchange values) is found wrong");
			System.out.println("Monthly finance and maint. rental (with part exchange values) is found wrong");
		}

//    	FileInputStream in1 = new FileInputStream(prop.getProperty("formula_excel_path"));
//		XSSFWorkbook wb1 = new XSSFWorkbook(in1);
//
//		wb1.getSheet(sheet_name).getRow(109).getCell(1).setCellValue("NO");
//		FileOutputStream out1 = new FileOutputStream(prop.getProperty("formula_excel_path"));
//		wb1.write(out1);

		return flag;
	}
//
//public boolean check_monthly_finance_payment_with_balloon_payment_on_off_with_maintenance(String sheet_name) throws InterruptedException, IOException {
//		
//		
//		LO.print("");
//	    System.out.println("");
//	    
//	    LO.print("***********Checking Monthly Payment values with Balloon Payment ON / OFF***********");
//	    System.out.println("***********Checking Monthly Payment values with Balloon Payment ON / OFF***********");
//	   
////		ExplicitWait.visibleElement(driver, with_balloon_toggle, 20);
////	    
////	    JavascriptExecutor jse = (JavascriptExecutor)driver;
////		
////		jse.executeScript("arguments[0].click();", with_balloon_toggle);
//	    
//	    Click.on(driver, with_balloon_toggle, 30);
//		
//		 LO.print("Clicked on  - With Balloon Toggle");
//		 System.out.println("Clicked on - With Balloon Toggle");		
//	   
//		
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
//		
//		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
//		ExplicitWait.visibleElement(driver, customer_quote_monthly_maintenance_rental, 30);
//
//		double monthly_finance_rental_actual_converted = Double.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));
//		double monthly_maintenance_rental_actual_converted = Double.parseDouble(RemoveComma.of(customer_quote_monthly_maintenance_rental.getText().substring(2)));
//
//		LO.print("Monthly Finance Rental from screen (after making With Balloon toggle OFF) is "+monthly_finance_rental_actual_converted);
//	    System.out.println("Monthly Finance Rental from screen (after making With Balloon toggle OFF) is "+monthly_finance_rental_actual_converted);
//	    
//		LO.print("Monthly Mainte. Rental from screen (after making With Balloon toggle OFF) is "+monthly_maintenance_rental_actual_converted);
//	    System.out.println("Monthly Mainte. Rental from screen (after making With Balloon toggle OFF) is "+monthly_maintenance_rental_actual_converted);
//	    
//		
//		FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
//		XSSFWorkbook wb = new XSSFWorkbook(in);
//		
//		wb.getSheet(sheet_name).getRow(106).getCell(2).setCellValue("NO");	
//		
//		FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
//		wb.write(out);
//		
//		double monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);
//		
//		double monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(88, 1, sheet_name);
//		
//		LO.print("Monthly Finance Rental from excel (after making With Balloon toggle OFF) is "+monthlyFinanceRentalFromExcel);
//	    System.out.println("Monthly Finance Rental from excel (after making With Balloon toggle OFF) is "+monthlyFinanceRentalFromExcel);
//	    
//		LO.print("Monthly Mainte. Rental from excel (after making With Balloon toggle OFF) is "+monthlyMainteRentalFromExcel);
//	    System.out.println("Monthly Mainte. Rental from excel (after making With Balloon toggle OFF) is "+monthlyMainteRentalFromExcel);
//	   
//		
//		double diff1 =Difference.of_two_Double_Values(monthly_finance_rental_actual_converted, monthlyFinanceRentalFromExcel);
//		
//		double diff2 =Difference.of_two_Double_Values(monthly_maintenance_rental_actual_converted, monthlyMainteRentalFromExcel);
//
//		
//		boolean flag = false ;
//		if(diff1<0.2 && diff2<0.2)
//				{
//			    flag = true;
//			     LO.print("Monthly finance and maint. rental (after making With Balloon toggle OFF) is found OK" );
//			     System.out.println("Monthly finance and maint. rental (after making With Balloon toggle OFF) is found OK" );
//				}
//		else  {
//		     LO.print("Monthly finance and maint. rental (after making With Balloon toggle OFF) is found wrong" );
//		     System.err.println("Monthly finance and maint. rental (after making With Balloon toggle OFF) is found wrong" );
//		      }
//		
//		
//		FileInputStream in1 = new FileInputStream(prop.getProperty("formula_excel_path"));
//		XSSFWorkbook wb1 = new XSSFWorkbook(in1);
//		
//		wb.getSheet(sheet_name).getRow(106).getCell(2).setCellValue("YES");	
//		
//		FileOutputStream out1 = new FileOutputStream(prop.getProperty("formula_excel_path"));
//		wb.write(out1);
//		
//		Click.on(driver, with_balloon_toggle, 30);
//			
//     	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);		
//		
//		
//		
//		return flag;	
//		
//	}
//	
//	
//public boolean check_monthly_finance_payment_with_balloon_payment_on_off_without_maintenance(String sheet_name) throws InterruptedException, IOException {
//		
//		
//		LO.print("");
//	    System.out.println("");
//	    
//	    LO.print("***********Checking Monthly Payment values with Balloon Payment ON / OFF***********");
//	    System.out.println("***********Checking Monthly Payment values with Balloon Payment ON / OFF***********");
//	   
////		ExplicitWait.visibleElement(driver, with_balloon_toggle, 20);
//	    
////	    JavascriptExecutor jse = (JavascriptExecutor)driver;
////		
////		jse.executeScript("arguments[0].click();", with_balloon_toggle);
//		
//		Click.on(driver, with_balloon_toggle, 20);
//		
//		 LO.print("Clicked on  - With Balloon Toggle");
//		 System.out.println("Clicked on - With Balloon Toggle");		
//	   
//		
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
//		
//		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
//
//		double monthly_finance_rental_actual_converted = Double.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));
//
//		LO.print("Monthly Finance Rental from screen (after making With Balloon toggle OFF) is "+monthly_finance_rental_actual_converted);
//	    System.out.println("Monthly Finance Rental from screen (after making With Balloon toggle OFF) is "+monthly_finance_rental_actual_converted);
//	    
//	  
//			
//		FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
//		XSSFWorkbook wb = new XSSFWorkbook(in);
//		
//		wb.getSheet(sheet_name).getRow(106).getCell(2).setCellValue("NO");	
//		
//		FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
//		wb.write(out);
//		
//		double monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);
//		
//		
//		LO.print("Monthly Finance Rental from excel (after making With Balloon toggle OFF) is "+monthlyFinanceRentalFromExcel);
//	    System.out.println("Monthly Finance Rental from excel (after making With Balloon toggle OFF) is "+monthlyFinanceRentalFromExcel);
//	    
//		
//		
//		double diff1 =Difference.of_two_Double_Values(monthly_finance_rental_actual_converted, monthlyFinanceRentalFromExcel);
//		
//
//		
//		boolean flag = false ;
//		if(diff1<0.2)
//				{
//			    flag = true;
//			     LO.print("Monthly finance  rental (after making With Balloon toggle OFF) is found OK" );
//			     System.out.println("Monthly finance  rental (after making With Balloon toggle OFF) is found OK" );
//				}
//		else  {
//		     LO.print("Monthly finance  rental (after making With Balloon toggle OFF) is found wrong" );
//		     System.err.println("Monthly finance rental (after making With Balloon toggle OFF) is found wrong" );
//		      }
//		
//		FileInputStream in1 = new FileInputStream(prop.getProperty("formula_excel_path"));
//		XSSFWorkbook wb1 = new XSSFWorkbook(in1);
//		
//		wb.getSheet(sheet_name).getRow(106).getCell(2).setCellValue("YES");	
//		
//		FileOutputStream out1 = new FileOutputStream(prop.getProperty("formula_excel_path"));
//		wb.write(out1);
//		
//		
//		Click.on(driver, with_balloon_toggle, 20);		
//		
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
//		
//		return flag;
//		
//	}

	public boolean customer_Quote_HPNR_FL_OTR_calculation() throws InterruptedException {

		Click.on(driver, customer_quote, 50);
		ExplicitWait.clickableElement(driver, save_button, 0);
		Click.on(driver, save_button, 60);

		String page_title_after_save = driver.getTitle();
		System.out.println(page_title_after_save);
		return page_title_after_save.contains("Customer Quote");
	}

	public boolean verify_cutomer_quote_matrix_value() {

		Click.on(driver, customer_quote, 30);
		ExplicitWait.visibleElement(driver, customer_quote_matrix_default_cell, 30);
		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_reantal, 30);
		String customer_quote_matrix_value = customer_quote_matrix_default_cell.getText();
		String monthly_finance_rental = customer_quote_monthly_finance_reantal.getText();
		boolean status = false;
		if (customer_quote_matrix_value.equals(monthly_finance_rental)) {
			status = true;
		}
		return status;
	}

	public boolean customer_Quote_HPNR_FL_for_one_payment_option_without_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, ClassNotFoundException, FormulaParseException, IllegalStateException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		obj_read_excel_calculation_page.set_global_variables_to_excel_for_finance_lease(sheet_name);
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_one_payment_options_without_maintenance(driver,
						customer_quote_payment_profile_dropdown, part_exchange_payment, actual_part_exchange_value,
						actual_part_exchange_value_from_excel, given_part_exchange_value,
						given_part_exchange_value_from_excel, less_finance_settlement,
						less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
						document_fee_from_excel, upsell, customer_quote_monthly_finance_rental, maintenance_required,
						maintenance_margin, initial_payment, part_exchange_status, target_rental, sheet_name);

	}

	public boolean customer_Quote_HPNR_FL_for_one_payment_option_for_funder_quote_addition_with_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, ClassNotFoundException, FormulaParseException, IllegalStateException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Click.on(driver, holding_cost, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);



		ExplicitWait.visibleElement(driver, total_cap_maintenance_value, 30);

		double totalCapMaintenanceValue = Double
				.parseDouble(RemoveComma.of(total_cap_maintenance_value.getText().trim().substring(2)));

		Click.on(driver, customer_quote, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Actions act = new Actions(driver);

		if (totalCapMaintenanceValue == 0) 
		
		{
		
			obj_read_excel_calculation_page.set_global_variables_to_excel_for_finance_lease_for_funder_quote_addition(sheet_name);
			return obj_read_excel_calculation_page
					.verify_customer_quote_calculations_for_one_payment_options_for_funder_quote_addition_without_maintenance(driver,
							customer_quote_payment_profile_dropdown, part_exchange_payment, actual_part_exchange_value,
							actual_part_exchange_value_from_excel, given_part_exchange_value,
							given_part_exchange_value_from_excel, less_finance_settlement,
							less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
							document_fee_from_excel, upsell, customer_quote_monthly_finance_rental, maintenance_required,
							maintenance_margin, initial_payment, part_exchange_status, target_rental, sheet_name);
			
		}else
		{
		

		Click.on(driver, customer_quote_maintenance_toggle_button, 30);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		
		
		obj_read_excel_calculation_page
				.set_global_variables_to_excel_for_finance_lease_for_funder_quote_addition(sheet_name);
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_one_payment_options_for_funder_quote_addition_with_maintenance(
						driver, customer_quote_payment_profile_dropdown, part_exchange_payment,
						actual_part_exchange_value, actual_part_exchange_value_from_excel, given_part_exchange_value,
						given_part_exchange_value_from_excel, less_finance_settlement,
						less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
						document_fee_from_excel, upsell, customer_quote_monthly_finance_rental,
						customer_quote_monthly_maintenance_rental, maintenance_required, maintenance_margin,
						initial_payment, part_exchange_status, target_rental, sheet_name);
		}}

	public boolean customer_Quote_HPNR_FL_for_one_payment_option_for_funder_quote_addition_without_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, ClassNotFoundException, FormulaParseException, IllegalStateException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		obj_read_excel_calculation_page
				.set_global_variables_to_excel_for_finance_lease_for_funder_quote_addition(sheet_name);
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_one_payment_options_for_funder_quote_addition_without_maintenance(
						driver, customer_quote_payment_profile_dropdown, part_exchange_payment,
						actual_part_exchange_value, actual_part_exchange_value_from_excel, given_part_exchange_value,
						given_part_exchange_value_from_excel, less_finance_settlement,
						less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
						document_fee_from_excel, upsell, customer_quote_monthly_finance_rental, maintenance_required,
						maintenance_margin, initial_payment, part_exchange_status, target_rental, sheet_name);
	}

	public boolean customer_Quote_HPNR_FL_for_all_payment_option_without_maintenance_calculation(String initial_payment,
			String sheet_name) throws IOException, InterruptedException {

		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_all_payment_options_without_maintenance(driver,
						customer_quote_payment_profile_dropdown, customer_quote_monthly_finance_rental,
						initial_payment_input_field, initial_payment, sheet_name);
	}

	public boolean customer_Quote_HPNR_FL_for_one_payment_option_with_maintenance_calculation(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws IOException,
			InterruptedException, ClassNotFoundException, FormulaParseException, IllegalStateException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 120);
		Click.on(driver, customer_quote_maintenance_toggle_button, 40);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 120);
		Click.on(driver, holding_cost, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, holding_cost_summary, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, holding_cost_summary_terms, 30);

		double duration = Double.parseDouble(holding_cost_summary_terms.getText().substring(0, 2));

		ExplicitWait.visibleElement(driver, holding_cost_summary_mileage, 30);

		double annual_mileage = Double.parseDouble(RemoveComma.of(holding_cost_summary_mileage.getText()));

		ExplicitWait.visibleElement(driver, holding_cost_percentage_cap_residual_value_used, 20);
		ExplicitWait.visibleElement(driver, holding_cost_percentage_maintenance_cost_used, 20);
		ExplicitWait.visibleElement(driver, residual_value_used, 20);
		ExplicitWait.visibleElement(driver, maintenance_cost_used, 20);
		

		double percentage_cap_residual_value = Double.parseDouble(holding_cost_percentage_cap_residual_value_used.getAttribute("value"));
		
		
		Thread.sleep(1000);
		

		double percentage_cap_maintenance_cost =  Double.parseDouble(holding_cost_percentage_maintenance_cost_used.getAttribute("value"));

		Thread.sleep(1000);		
	
		double used_residual_value =  Double.parseDouble(residual_value_used.getAttribute("value"));

		
		Thread.sleep(1000);	
		
	
		double total_cap_maintenance_value_converted =  Double.parseDouble(maintenance_cost_used.getAttribute("value"));

		
		Thread.sleep(1000);

		Click.on(driver, customer_quote, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 160);	
		
		obj_read_excel_calculation_page.write_holding_cost_cap_values_to_excel_with_maintenance(duration,
				annual_mileage, used_residual_value, total_cap_maintenance_value_converted,
				percentage_cap_residual_value, percentage_cap_maintenance_cost, sheet_name);
		obj_read_excel_calculation_page.set_global_variables_to_excel_for_finance_lease(sheet_name);
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_one_payment_options_with_maintenance(driver,
						customer_quote_payment_profile_dropdown, part_exchange_payment, actual_part_exchange_value,
						actual_part_exchange_value_from_excel, given_part_exchange_value,
						given_part_exchange_value_from_excel, less_finance_settlement,
						less_finance_settlement_from_excel, order_Deposit, order_Deposit_from_excel, document_fee,
						document_fee_from_excel, upsell, customer_quote_monthly_finance_rental,
						customer_quote_monthly_maintenance_rental, maintenance_required, maintenance_margin,
						initial_payment, part_exchange_status, target_rental, sheet_name);
	}

	public boolean customer_Quote_HPNR_FL_for_all_payment_option_for_funder_quote_addition_with_maintenance_calculation(
			String initial_payment, String sheet_name) throws IOException, InterruptedException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_all_payment_options_for_funder_quote_addition_with_maintenance(
						driver, customer_quote_payment_profile_dropdown, customer_quote_monthly_finance_rental,
						customer_quote_monthly_maintenance_rental, initial_payment_input_field, initial_payment,
						sheet_name);
	}

	public boolean customer_Quote_HPNR_FL_for_all_payment_option_with_maintenance_calculation(String initial_payment,
			String sheet_name) throws IOException, InterruptedException {

		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_all_payment_options_with_maintenance(driver,
						customer_quote_payment_profile_dropdown, customer_quote_monthly_finance_rental,
						customer_quote_monthly_maintenance_rental, initial_payment_input_field, initial_payment,
						sheet_name);
	}

	public boolean customer_quote_part_balance_due_value_verification(String actual_part_exchange_value_from_excel,
			String given_part_exchange_value_from_excel, String less_finance_settlement_from_excel,
			String order_Deposit_from_excel, String document_fee_from_excel, String upsell, String part_exchange_status,
			String target_rental, String sheet_name) throws InterruptedException, IOException {

		LO.print("Started verifying Balance Due value");
		System.out.println("Started verifying Balance Due value");

		ExplicitWait.visibleElement(driver, part_exchange_allowance, 30);

		ExplicitWait.visibleElement(driver, balance_due_value, 30);

		Thread.sleep(5000);

		double partExchangeAllowanceFromScreen = Double
				.parseDouble(RemoveComma.of(part_exchange_allowance.getText().trim().substring(2)));

		Thread.sleep(5000);

		double balanceDueFromScreen = Double
				.parseDouble(RemoveComma.of(balance_due_value.getText().trim().substring(2)));

		double orderDepositeFromExcel = Double.parseDouble(order_Deposit_from_excel);

		double documentFeeFromExcel = ((Double.parseDouble(document_fee_from_excel)) * 1.2);

		double balance_due_expected = ((orderDepositeFromExcel + documentFeeFromExcel)
				- partExchangeAllowanceFromScreen);

		System.out.println("partExchangeAllowanceFromScreen " + partExchangeAllowanceFromScreen);
		System.out.println("balanceDueFromScreen " + balanceDueFromScreen);
		System.out.println("orderDepositeFromExcel " + orderDepositeFromExcel);
		System.out.println("documentFeeFromExcel " + documentFeeFromExcel);
		System.out.println("partExchangeAllowanceFromScreen " + partExchangeAllowanceFromScreen);
		System.out.println("balance due expected " + balance_due_expected);

		double diff = Difference.of_two_Double_Values(balanceDueFromScreen, balance_due_expected);

		System.out.println("Difference between expected and actual =" + diff);

		boolean balance_value_when_part_exchange_toggle_off = false;
		if (diff < 0.3) {
			balance_value_when_part_exchange_toggle_off = true;
			LO.print("Balance due value (when part exchange toggle is OFF) is verified and found ok");
			System.out.println("Balance due value (when part exchange toggle is off) is verified and found ok");
		} else {

			LO.print("Balance due value (when part exchange toggle is OFF) found wrong");
			System.out.println("Balance due value (when part exchange toggle is off) found wrong");
		}

		Click.on(driver, part_exchange_toggle, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		double partExchangeAllowanceFromScreen1 = Double
				.parseDouble(RemoveComma.of(part_exchange_allowance.getText().trim().substring(2)));

		Thread.sleep(5000);
		double balanceDueFromScreen1 = Double
				.parseDouble(RemoveComma.of(balance_due_value.getText().trim().substring(2)));

		double balance_due_expected1 = orderDepositeFromExcel + documentFeeFromExcel;

		System.out.println("partExchangeAllowanceFromScreen " + partExchangeAllowanceFromScreen1);
		System.out.println("balanceDueFromScreen1 " + balanceDueFromScreen1);
		System.out.println("balance due expected1 " + balance_due_expected1);

		double diff1 = Difference.of_two_Double_Values(balanceDueFromScreen, balance_due_expected);

		System.out.println("Difference between expected and actual =" + diff1);

		boolean balance_value_when_part_exchange_toggle_off1 = false;
		if (diff1 < 0.3) {
			balance_value_when_part_exchange_toggle_off1 = true;
			LO.print("Balance due value (when part exchange toggle is ON) is verified and found ok");
			System.out.println("Balance due value (when part exchange toggle is ON) is verified and found ok");

		} else {
			LO.print("Balance due value (when part exchange toggle is ON) found wrong");
			System.out.println("Balance due value (when part exchange toggle is ON) found wrong");
		}
		boolean status = false;
		if (balance_value_when_part_exchange_toggle_off && balance_value_when_part_exchange_toggle_off1) {
			status = true;
		}

		return status;

	}

	public boolean customer_Quote_HPNR_FL_for_all_payment_option_for_funder_quote_addition_without_maintenance_calculation(
			String initial_payment, String sheet_name) throws IOException, InterruptedException {
		obj_read_excel_calculation_page = new ReadExcelCalculation();
		return obj_read_excel_calculation_page
				.verify_customer_quote_calculations_for_all_payment_options_for_funder_quote_addition_without_maintenance(
						driver, customer_quote_payment_profile_dropdown, customer_quote_monthly_finance_rental,
						initial_payment_input_field, initial_payment, sheet_name);
	}

	public boolean customer_quote_monthly_finance_rental_value_verification_with_part_exchange_without_maintenance(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String part_exchange_status, String target_rental, String sheet_name)
			throws InterruptedException, IOException {
		
		LO.print("Entering the deposit values in the part Exchange Section");
		System.out.println("Entering the deposit values in the part Exchange Section");

		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		
		Click.on(driver, part_exchange_and_additional_payment_button, 20);
		Thread.sleep(4000);
		
//		ExplicitWait.clickableElement(driver, part_exchange_payment, 50);
//		Thread.sleep(4000);
//		Click.on(driver, part_exchange_payment, 70);
//		LO.print("Clicked on Part Exchange panel");
//		System.out.println("Clicked on Part Exchange panel");
//		Actions act = new Actions(driver);
//
//		Click.on(driver, given_part_exchange_value, 20);
//
//		given_part_exchange_value.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, given_part_exchange_value, given_part_exchange_value_from_excel, 30);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//		jse.executeScript("arguments[0].click();", check_box_outstanding_finance, 20);
//
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//	
//
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, funder_name, "Funder X", 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, agreement_number, "123", 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		ExplicitWait.visibleElement(driver, less_finance_settlement, 20);
//		less_finance_settlement.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, less_finance_settlement, less_finance_settlement_from_excel, 20);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, order_Deposit, 20);
		order_Deposit.clear();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.sendKeys(driver, order_Deposit, order_Deposit_from_excel, 30);
		act.sendKeys(Keys.TAB).perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

//		ExplicitWait.visibleElement(driver, document_fee, 30);
//		document_fee.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		ExplicitWait.visibleElement(driver, document_fee, 30);
//		document_fee.clear();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		Click.sendKeys(driver, document_fee, document_fee_from_excel, 30);
//		act.sendKeys(Keys.TAB).perform();
//		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);
		wb.getSheet(sheet_name).getRow(115).getCell(1).setCellValue("NO");
		wb.getSheet(sheet_name).getRow(117).getCell(3).setCellValue(0);
		wb.getSheet(sheet_name).getRow(117).getCell(4)
				.setCellValue(0);
		wb.getSheet(sheet_name).getRow(118).getCell(4)
				.setCellValue(0);
		wb.getSheet(sheet_name).getRow(129).getCell(1).setCellValue(Double.parseDouble(target_rental));

		FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
		wb.write(out);

		double monthly_finance_rental_expected_with_part_exchange = GetExcelFormulaValue.get_formula_value(96, 1,
				sheet_name);

		LO.print(
				"Expected Monthly Finance Rental From Excel is =" + monthly_finance_rental_expected_with_part_exchange);
		System.out.println(
				"Expected Monthly Finance Rental From Excel is =" + monthly_finance_rental_expected_with_part_exchange);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

		double monthlyFinanceRentalFromScreen = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().trim().substring(2)));

		LO.print("Actuacl Monthly Finance Rental From screen is =" + monthlyFinanceRentalFromScreen);
		System.out.println("Actuacl Monthly Finance Rental From screen is =" + monthlyFinanceRentalFromScreen);

		double diff = Difference.of_two_Double_Values(monthly_finance_rental_expected_with_part_exchange,
				monthlyFinanceRentalFromScreen);

		boolean monthlyFinanceRentalExpected = false;

		if (diff < 0.3) {
			monthlyFinanceRentalExpected = true;
		}

		return monthlyFinanceRentalExpected;
	}

	public boolean customer_quote_monthly_finance_rental_value_verification_with_part_exchange_with_maintenance(
			String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_Deposit_from_excel, String document_fee_from_excel,
			String upsell, String part_exchange_status, String target_rental, String sheet_name)
			throws InterruptedException, IOException {

		ExplicitWait.clickableElement(driver, holding_cost, 30);

		Click.on(driver, holding_cost, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		Click.on(driver, holding_cost_summary, 30);

		ExplicitWait.visibleElement(driver, total_cap_maintenance_value, 30);

		double totalCapMaintenanceValue = Double
				.parseDouble(RemoveComma.of(total_cap_maintenance_value.getText().trim().substring(2)));

		Click.on(driver, customer_quote, 30);

		LO.print("***********Entered in Customer Quote page ***********");
		System.out.println("***********Entered in Customer Quote page ***********");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		if (totalCapMaintenanceValue == 0) {
			
			Thread.sleep(4000);
			
			LO.print("Entering the deposit values in the part Exchange Section");
			System.out.println("Entering the deposit values in the part Exchange Section");
			
			Actions act = new Actions(driver);
			
			Click.on(driver, part_exchange_and_additional_payment_button, 20);
			Thread.sleep(4000);
			
			
//			ExplicitWait.clickableElement(driver, part_exchange_payment, 50);
//			Thread.sleep(4000);
//			Click.on(driver, part_exchange_payment, 70);
//			LO.print("Clicked on Part Exchange panel");
//			System.out.println("Clicked on Part Exchange panel");
//			Actions act = new Actions(driver);
//
//			Click.on(driver, given_part_exchange_value, 20);
//
//			given_part_exchange_value.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, given_part_exchange_value, given_part_exchange_value_from_excel, 30);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//			jse.executeScript("arguments[0].click();", check_box_outstanding_finance, 20);
//
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		
//
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, funder_name, "Funder X", 20);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, agreement_number, "123", 20);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			ExplicitWait.visibleElement(driver, less_finance_settlement, 20);
//			less_finance_settlement.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, less_finance_settlement, less_finance_settlement_from_excel, 20);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			ExplicitWait.visibleElement(driver, order_Deposit, 20);
			order_Deposit.clear();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			Click.sendKeys(driver, order_Deposit, order_Deposit_from_excel, 30);
			act.sendKeys(Keys.TAB).perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

//			ExplicitWait.visibleElement(driver, document_fee, 30);
//			document_fee.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			ExplicitWait.visibleElement(driver, document_fee, 30);
//			document_fee.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, document_fee, document_fee_from_excel, 30);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
			XSSFWorkbook wb = new XSSFWorkbook(in);
			wb.getSheet(sheet_name).getRow(115).getCell(1).setCellValue("NO");
			wb.getSheet(sheet_name).getRow(117).getCell(3).setCellValue(0);
			wb.getSheet(sheet_name).getRow(117).getCell(4)
					.setCellValue(0);
			wb.getSheet(sheet_name).getRow(118).getCell(4)
					.setCellValue(0);
			wb.getSheet(sheet_name).getRow(129).getCell(1).setCellValue(Double.parseDouble(target_rental));

			FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
			wb.write(out);

			double monthly_finance_rental_expected_with_part_exchange = GetExcelFormulaValue.get_formula_value(96, 1,
					sheet_name);

			LO.print("Expected Monthly Finance Rental From Excel is ="
					+ monthly_finance_rental_expected_with_part_exchange);
			System.out.println("Expected Monthly Finance Rental From Excel is ="
					+ monthly_finance_rental_expected_with_part_exchange);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

			double monthlyFinanceRentalFromScreen = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().trim().substring(2)));

			LO.print("Actuacl Monthly Finance Rental From screen is =" + monthlyFinanceRentalFromScreen);
			System.out.println("Actuacl Monthly Finance Rental From screen is =" + monthlyFinanceRentalFromScreen);

			double diff = Difference.of_two_Double_Values(monthly_finance_rental_expected_with_part_exchange,
					monthlyFinanceRentalFromScreen);

			boolean monthlyFinanceRentalExpected = false;

			if (diff < 0.3) {
				monthlyFinanceRentalExpected = true;
			}

			return monthlyFinanceRentalExpected;

		}

		else {
			
			LO.print("Entering the deposit values in the part Exchange Section");
			System.out.println("Entering the deposit values in the part Exchange Section");
			
			Actions act = new Actions(driver);
			
			Click.on(driver, part_exchange_and_additional_payment_button, 20);
			Thread.sleep(4000);
			
//			ExplicitWait.clickableElement(driver, part_exchange_payment, 50);
//			Thread.sleep(4000);
//			Click.on(driver, part_exchange_payment, 70);
//			LO.print("Clicked on Part Exchange panel");
//			System.out.println("Clicked on Part Exchange panel");
//			Actions act = new Actions(driver);
//
//			Click.on(driver, given_part_exchange_value, 20);
//
//			given_part_exchange_value.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, given_part_exchange_value, given_part_exchange_value_from_excel, 30);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//			jse.executeScript("arguments[0].click();", check_box_outstanding_finance, 20);
//
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//		
//
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, funder_name, "Funder X", 20);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, agreement_number, "123", 20);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			ExplicitWait.visibleElement(driver, less_finance_settlement, 20);
//			less_finance_settlement.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, less_finance_settlement, less_finance_settlement_from_excel, 20);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			ExplicitWait.visibleElement(driver, order_Deposit, 20);
			order_Deposit.clear();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			Click.sendKeys(driver, order_Deposit, order_Deposit_from_excel, 30);
			act.sendKeys(Keys.TAB).perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

//			ExplicitWait.visibleElement(driver, document_fee, 30);
//			document_fee.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			ExplicitWait.visibleElement(driver, document_fee, 30);
//			document_fee.clear();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
//
//			Click.sendKeys(driver, document_fee, document_fee_from_excel, 30);
//			act.sendKeys(Keys.TAB).perform();
//			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			FileInputStream in = new FileInputStream(prop.getProperty("formula_excel_path"));
			XSSFWorkbook wb = new XSSFWorkbook(in);
			wb.getSheet(sheet_name).getRow(115).getCell(1).setCellValue("NO");
			wb.getSheet(sheet_name).getRow(117).getCell(3).setCellValue(0);
			wb.getSheet(sheet_name).getRow(117).getCell(4)
					.setCellValue(0);
			wb.getSheet(sheet_name).getRow(118).getCell(4)
					.setCellValue(0);
			wb.getSheet(sheet_name).getRow(129).getCell(1).setCellValue(Double.parseDouble(target_rental));

			FileOutputStream out = new FileOutputStream(prop.getProperty("formula_excel_path"));
			wb.write(out);

			double monthly_finance_rental_expected_with_part_exchange = GetExcelFormulaValue.get_formula_value(95, 1,
					sheet_name);

			LO.print("Expected Monthly Finance Rental From Excel is ="
					+ monthly_finance_rental_expected_with_part_exchange);
			System.out.println("Expected Monthly Finance Rental From Excel is ="
					+ monthly_finance_rental_expected_with_part_exchange);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

			double monthlyFinanceRentalFromScreen = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().trim().substring(2)));

			LO.print("Actuacl Monthly Finance Rental From screen is =" + monthlyFinanceRentalFromScreen);
			System.out.println("Actuacl Monthly Finance Rental From screen is =" + monthlyFinanceRentalFromScreen);

			double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_expected_with_part_exchange,
					monthlyFinanceRentalFromScreen);

			double monthly_mainte_rental_expected_with_part_exchange = GetExcelFormulaValue.get_formula_value(94, 1,
					sheet_name);

			LO.print("Expected Monthly Maint. Rental From Excel is ="
					+ monthly_mainte_rental_expected_with_part_exchange);
			System.out.println("Expected Monthly Maint. Rental From Excel is ="
					+ monthly_mainte_rental_expected_with_part_exchange);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_maintenance_rental, 30);

			double monthlyMaintenanceRentalFromScreen = Double.parseDouble(
					RemoveComma.of(customer_quote_monthly_maintenance_rental.getText().trim().substring(2)));

			LO.print("Actuacl Monthly Maint. Rental From screen is =" + monthlyMaintenanceRentalFromScreen);
			System.out.println("Actuacl Monthly Maint. Rental From screen is =" + monthlyMaintenanceRentalFromScreen);

			double diff2 = Difference.of_two_Double_Values(monthly_mainte_rental_expected_with_part_exchange,
					monthlyMaintenanceRentalFromScreen);

			boolean status = false;

			if (diff1 < 0.2 && diff2 < 0.2) {
				status = true;
			}

			return status;
		}

	}

	public boolean check_monthly_payments_on_adding_upsell_values_with_maintenance(String security_deposit,
			String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage, String sheet_name)
			throws IOException, InterruptedException {

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		Click.on(driver, holding_cost, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, holding_cost_summary, 30);

		ExplicitWait.visibleElement(driver, total_cap_maintenance_value, 30);

		double totalCapMaintenanceValue = Double
				.parseDouble(RemoveComma.of(total_cap_maintenance_value.getText().trim().substring(2)));

		System.out.println(totalCapMaintenanceValue);

		Click.on(driver, customer_quote, 30);

		LO.print("Started verifying monthly payments with upsell values");
		System.out.println("Started verifying monthly payments with upsell values");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Actions act = new Actions(driver);

		if (totalCapMaintenanceValue == 0) {

			ExplicitWait.visibleElement(driver, security_deposit_input_field, 30);

			ExplicitWait.visibleElement(driver, matrix_upsell_input_field, 30);

			ExplicitWait.visibleElement(driver, referrer_upsell_input_field, 30);

			security_deposit_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeys(driver, security_deposit_input_field, security_deposit, 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			matrix_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeys(driver, matrix_upsell_input_field, matrix_upsell, 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			referrer_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeys(driver, referrer_upsell_input_field, referrer_upsell, 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

			double monthly_finance_rental_actual_converted = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));

			LO.print("Monthly Finance Rental from screen (after submitting upsell values) is "
					+ monthly_finance_rental_actual_converted);
			System.out.println("Monthly Finance Rental from screen (after submitting upsell values) is "
					+ monthly_finance_rental_actual_converted);

			LO.print("Writing upsell values to excel");
			System.out.println("Writing upsell values to excel");

			obj_read_excel_calculation_page = new ReadExcelCalculation();

			obj_read_excel_calculation_page.put_upsell_values_to_excel(matrix_upsell, referrer_upsell, sheet_name);

			double monthlyFinanceRentalFromExcel = 0;

			if (sheet_name.contains("Formula1") || sheet_name.contains("BCH (Formula 3)")) {

				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

			} else {
				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(95, 1, sheet_name);

			}

			LO.print("Monthly Finance Rental from Excel (after submitting upsell values) is "
					+ monthlyFinanceRentalFromExcel);
			System.out.println("Monthly Finance Rental from Excel (after submitting upsell values) is "
					+ monthlyFinanceRentalFromExcel);

			double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
					monthlyFinanceRentalFromExcel);

			boolean flag = false;
			if (diff1 < 0.2) {
				flag = true;
				LO.print("Monthly finance (after submitting upsell values) is found OK");
				System.out.println("Monthly finance (after submitting upsell values) is found OK");
			} else {
				LO.print("Monthly finance (after submitting upsell values) is found wrong");
				System.out.println("Monthly  (after submitting upsell values) is found wrong");
			}

			return flag;

		} else {
			ExplicitWait.visibleElement(driver, security_deposit_input_field, 30);

			ExplicitWait.visibleElement(driver, matrix_upsell_input_field, 30);

			ExplicitWait.visibleElement(driver, referrer_upsell_input_field, 30);

			security_deposit_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeys(driver, security_deposit_input_field, security_deposit, 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			matrix_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeys(driver, matrix_upsell_input_field, matrix_upsell, 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			referrer_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeys(driver, referrer_upsell_input_field, referrer_upsell, 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
			ExplicitWait.visibleElement(driver, customer_quote_monthly_maintenance_rental, 30);

			double monthly_finance_rental_actual_converted = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));
			double monthly_maintenance_rental_actual_converted = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_maintenance_rental.getText().substring(2)));

			LO.print("Monthly Finance Rental from screen (after submitting upsell values) is "
					+ monthly_finance_rental_actual_converted);
			System.out.println("Monthly Finance Rental from screen (after submitting upsell values) is "
					+ monthly_finance_rental_actual_converted);

			LO.print("Monthly Mainte. Rental from screen ((after submitting upsell values) is "
					+ monthly_maintenance_rental_actual_converted);
			System.out.println("Monthly Mainte. Rental from screen ((after submitting upsell values) is "
					+ monthly_maintenance_rental_actual_converted);

			LO.print("Writing upsell values to excel");
			System.out.println("Writing upsell values to excel");

			obj_read_excel_calculation_page = new ReadExcelCalculation();

			obj_read_excel_calculation_page.put_upsell_values_to_excel(matrix_upsell, referrer_upsell, sheet_name);

			double monthlyFinanceRentalFromExcel = 0;
			double monthlyMainteRentalFromExcel = 0;

			if (sheet_name.contains("Formula1") || sheet_name.contains("BCH (Formula 3)")) {
				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

				monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(88, 1, sheet_name);
			} else {
				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(95, 1, sheet_name);

				monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(94, 1, sheet_name);

			}

			LO.print("Monthly Finance Rental from Excel (after submitting upsell values) is "
					+ monthlyFinanceRentalFromExcel);
			System.out.println("Monthly Finance Rental from Excel (after submitting upsell values) is "
					+ monthlyFinanceRentalFromExcel);

			LO.print("Monthly Mainte. Rental from Excel ((after submitting upsell values) is "
					+ monthlyMainteRentalFromExcel);
			System.out.println("Monthly Mainte. Rental from Excel ((after submitting upsell values) is "
					+ monthlyMainteRentalFromExcel);

			double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
					monthlyFinanceRentalFromExcel);

			double diff2 = Difference.of_two_Double_Values(monthly_maintenance_rental_actual_converted,
					monthlyMainteRentalFromExcel);

			boolean flag = false;
			if (diff1 < 0.2 && diff2 < 0.2) {
				flag = true;
				LO.print("Monthly finance and maint. rental (after submitting upsell values) is found OK");
				System.out.println("Monthly finance and maint. rental (after submitting upsell values) is found OK");
			} else {
				LO.print("Monthly finance and maint. rental (after submitting upsell values) is found wrong");
				System.out.println("Monthly finance and maint. rental (after submitting upsell values) is found wrong");
			}

			return flag;
		}

	}

	public boolean check_monthly_payments_on_adding_upsell_values_without_maintenance(String security_deposit,
			String matrix_upsell, String referrer_upsell, String add_terms, String add_mileage, String sheet_name)
			throws IOException, InterruptedException {

		Actions act = new Actions(driver);

		ExplicitWait.visibleElement(driver, security_deposit_input_field, 30);

		ExplicitWait.visibleElement(driver, matrix_upsell_input_field, 30);

		ExplicitWait.visibleElement(driver, referrer_upsell_input_field, 30);

		security_deposit_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeys(driver, security_deposit_input_field, security_deposit, 30);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		matrix_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeys(driver, matrix_upsell_input_field, matrix_upsell, 30);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		referrer_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeys(driver, referrer_upsell_input_field, referrer_upsell, 30);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

		double monthly_finance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));

		LO.print("Monthly Finance Rental from screen (after submitting upsell values) is "
				+ monthly_finance_rental_actual_converted);
		System.out.println("Monthly Finance Rental from screen (after submitting upsell values) is "
				+ monthly_finance_rental_actual_converted);

		LO.print("Writing upsell values to excel");
		System.out.println("Writing upsell values to excel");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		obj_read_excel_calculation_page.put_upsell_values_to_excel(matrix_upsell, referrer_upsell, sheet_name);

		double monthlyFinanceRentalFromExcel = 0;

		if (sheet_name.contains("Formula1") || sheet_name.contains("BCH (Formula 3)")) {

			monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

		} else {
			monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(95, 1, sheet_name);

		}

		LO.print("Monthly Finance Rental from Excel (after submitting upsell values) is "
				+ monthlyFinanceRentalFromExcel);
		System.out.println("Monthly Finance Rental from Excel (after submitting upsell values) is "
				+ monthlyFinanceRentalFromExcel);

		double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
				monthlyFinanceRentalFromExcel);

		boolean flag = false;
		if (diff1 < 0.2) {
			flag = true;
			LO.print("Monthly finance (after submitting upsell values) is found OK");
			System.out.println("Monthly finance (after submitting upsell values) is found OK");
		} else {
			LO.print("Monthly finance (after submitting upsell values) is found wrong");
			System.out.println("Monthly  (after submitting upsell values) is found wrong");
		}

		return flag;

	}

	public boolean check_monthly_payments_on_updating_customer_quote_summary_upsell_value_with_maintenance(
			String matrix_upsell, String sheet_name) throws IOException, InterruptedException {

				
        ExplicitWait.clickableElement(driver, holding_cost, 30);
		
		Click.on(driver, holding_cost, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, holding_cost_summary, 30);

		ExplicitWait.visibleElement(driver, total_cap_maintenance_value, 30);

		double totalCapMaintenanceValue = Double
				.parseDouble(RemoveComma.of(total_cap_maintenance_value.getText().trim().substring(2)));

		Click.on(driver, customer_quote, 30);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Actions act = new Actions(driver);

		if (totalCapMaintenanceValue == 0) 
		{
			Click.on(driver, customer_quote_summary, 30);

			Thread.sleep(1000);

			ExplicitWait.visibleElement(driver, summary_upsell_input_field, 30);

			double upsell = Double.parseDouble(matrix_upsell);

			summary_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeysdouble(driver, summary_upsell_input_field, (upsell + upsell), 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

			double monthly_finance_rental_actual_converted = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));

			LO.print("Monthly Finance Rental from screen (after updating customer quote summary upsell value) is "
					+ monthly_finance_rental_actual_converted);
			System.out.println("Monthly Finance Rental from screen (after updating customer quote summary upsell value) is "
					+ monthly_finance_rental_actual_converted);

			LO.print("Writing upsell values to excel");
			System.out.println("Writing upsell values to excel");

			obj_read_excel_calculation_page = new ReadExcelCalculation();

			obj_read_excel_calculation_page.put_customer_quote_summary_upsell_value_to_excel(upsell, sheet_name);

			double monthlyFinanceRentalFromExcel = 0;

			if (sheet_name.contains("Formula1") || sheet_name.contains("BCH (Formula 3)")) {

				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

			} else {
				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(95, 1, sheet_name);

			}

			LO.print("Monthly Finance Rental from Excel (after updating customer quote summary upsell value) is "
					+ monthlyFinanceRentalFromExcel);
			System.out.println("Monthly Finance Rental from Excel (after updating customer quote summary upsell value) is "
					+ monthlyFinanceRentalFromExcel);

			double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
					monthlyFinanceRentalFromExcel);

			boolean flag = false;
			if (diff1 < 0.2) {
				flag = true;
				LO.print("Monthly finance rental (after updating customer quote summary upsell value) is found OK");
				System.out
						.println("Monthly finance rental (after updating customer quote summary upsell value) is found OK");
			} else {
				LO.print("Monthly finance and rental (after updating customer quote summary upsell value) is found wrong");
				System.out.println(
						"Monthly finance and rental (after updating customer quote summary upsell value) is found wrong");
			}

			return flag;
			
		}
		else
		{
			Click.on(driver, customer_quote_summary, 30);

			Thread.sleep(1000);

			ExplicitWait.visibleElement(driver, summary_upsell_input_field, 30);

			double upsell = Double.parseDouble(matrix_upsell);

			summary_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Click.sendKeysdouble(driver, summary_upsell_input_field, (upsell + upsell), 30);
			act.sendKeys(Keys.TAB).build().perform();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

			ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
			ExplicitWait.visibleElement(driver, customer_quote_monthly_maintenance_rental, 30);

			double monthly_finance_rental_actual_converted = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));
			double monthly_maintenance_rental_actual_converted = Double
					.parseDouble(RemoveComma.of(customer_quote_monthly_maintenance_rental.getText().substring(2)));

			LO.print("Monthly Finance Rental from screen (after updating customer quote summary upsell value) is "
					+ monthly_finance_rental_actual_converted);
			System.out.println("Monthly Finance Rental from screen (after updating customer quote summary upsell value) is "
					+ monthly_finance_rental_actual_converted);

			LO.print("Monthly Mainte. Rental from screen (after updating customer quote summary upsell value) is "
					+ monthly_maintenance_rental_actual_converted);
			System.out.println("Monthly Mainte. Rental from screen (after updating customer quote summary upsell value) is "
					+ monthly_maintenance_rental_actual_converted);

			LO.print("Writing upsell values to excel");
			System.out.println("Writing upsell values to excel");

			obj_read_excel_calculation_page = new ReadExcelCalculation();

			obj_read_excel_calculation_page.put_customer_quote_summary_upsell_value_to_excel(upsell, sheet_name);

			double monthlyFinanceRentalFromExcel = 0;
			double monthlyMainteRentalFromExcel = 0;

			if (sheet_name.contains("Formula1") || sheet_name.contains("BCH (Formula 3)")) {
				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

				monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(88, 1, sheet_name);
			} else {
				monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(95, 1, sheet_name);

				monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(94, 1, sheet_name);

			}

			LO.print("Monthly Finance Rental from Excel (after updating customer quote summary upsell value) is "
					+ monthlyFinanceRentalFromExcel);
			System.out.println("Monthly Finance Rental from Excel (after updating customer quote summary upsell value) is "
					+ monthlyFinanceRentalFromExcel);

			LO.print("Monthly Mainte. Rental from Excel (after updating customer quote summary upsell value) is "
					+ monthlyMainteRentalFromExcel);
			System.out.println("Monthly Mainte. Rental from Excel (after updating customer quote summary upsell value) is "
					+ monthlyMainteRentalFromExcel);

			double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
					monthlyFinanceRentalFromExcel);

			double diff2 = Difference.of_two_Double_Values(monthly_maintenance_rental_actual_converted,
					monthlyMainteRentalFromExcel);

			boolean flag = false;
			if (diff1 < 0.2 && diff2 < 0.2) {
				flag = true;
				LO.print(
						"Monthly finance and maint. rental (after updating customer quote summary upsell value) is found OK");
				System.out.println(
						"Monthly finance and maint. rental (after updating customer quote summary upsell value) is found OK");
			} else {
				LO.print(
						"Monthly finance and maint. rental (after updating customer quote summary upsell value) is found wrong");
				System.out.println(
						"Monthly finance and maint. rental (after updating customer quote summary upsell value) is found wrong");
			}

			return flag;
		}
		

	}

	public boolean check_monthly_payments_on_updating_customer_quote_summary_upsell_value_without_maintenance(
			String matrix_upsell, String sheet_name) throws IOException, InterruptedException {

		Actions act = new Actions(driver);

		Click.on(driver, customer_quote_summary, 30);

		Thread.sleep(1000);

		ExplicitWait.visibleElement(driver, summary_upsell_input_field, 30);

		double upsell = Double.parseDouble(matrix_upsell);

		summary_upsell_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Click.sendKeysdouble(driver, summary_upsell_input_field, (upsell + upsell), 30);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

		double monthly_finance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));

		LO.print("Monthly Finance Rental from screen (after updating customer quote summary upsell value) is "
				+ monthly_finance_rental_actual_converted);
		System.out.println("Monthly Finance Rental from screen (after updating customer quote summary upsell value) is "
				+ monthly_finance_rental_actual_converted);

		LO.print("Writing upsell values to excel");
		System.out.println("Writing upsell values to excel");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		obj_read_excel_calculation_page.put_customer_quote_summary_upsell_value_to_excel(upsell, sheet_name);

		double monthlyFinanceRentalFromExcel = 0;

		if (sheet_name.contains("Formula1") || sheet_name.contains("BCH (Formula 3)")) {

			monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

		} else {
			monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(95, 1, sheet_name);

		}

		LO.print("Monthly Finance Rental from Excel (after updating customer quote summary upsell value) is "
				+ monthlyFinanceRentalFromExcel);
		System.out.println("Monthly Finance Rental from Excel (after updating customer quote summary upsell value) is "
				+ monthlyFinanceRentalFromExcel);

		double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
				monthlyFinanceRentalFromExcel);

		boolean flag = false;
		if (diff1 < 0.2) {
			flag = true;
			LO.print("Monthly finance rental (after updating customer quote summary upsell value) is found OK");
			System.out
					.println("Monthly finance rental (after updating customer quote summary upsell value) is found OK");
		} else {
			LO.print("Monthly finance and rental (after updating customer quote summary upsell value) is found wrong");
			System.out.println(
					"Monthly finance and rental (after updating customer quote summary upsell value) is found wrong");
		}

		return flag;

	}

	public boolean check_monthly_payments_on_updating_customer_quote_summary_final_balloon_payment_with_maintenance(
			String sheet_name) throws IOException, InterruptedException, UnsupportedFlavorException {

		Actions act = new Actions(driver);

		ExplicitWait.visibleElement(driver, summary_final_balloon_input_field, 30);

		double default_final_balloon_converted =  Double.parseDouble(summary_final_balloon_input_field.getAttribute("value"));

		summary_final_balloon_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		Click.sendKeysdouble(driver, summary_final_balloon_input_field,
				(default_final_balloon_converted + default_final_balloon_converted), 30);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);
		ExplicitWait.visibleElement(driver, customer_quote_monthly_maintenance_rental, 30);

		double monthly_finance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));
		double monthly_maintenance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_maintenance_rental.getText().substring(2)));

		LO.print(
				"Monthly Finance Rental from screen (after updating customer quote summary final balloon payment value) is "
						+ monthly_finance_rental_actual_converted);
		System.out.println(
				"Monthly Finance Rental from screen (after updating customer quote summary final balloon payment value) is "
						+ monthly_finance_rental_actual_converted);

		LO.print(
				"Monthly Mainte. Rental from screen (after updating customer quote summary final balloon payment value) is "
						+ monthly_maintenance_rental_actual_converted);
		System.out.println(
				"Monthly Mainte. Rental from screen (after updating customer quote summary final balloon payment value) is "
						+ monthly_maintenance_rental_actual_converted);

		LO.print("Writing final balloon payment values to excel");
		System.out.println("Writing final balloon payment values to excel");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		obj_read_excel_calculation_page
				.put_customer_quote_summary_final_balloon_payment_to_excel(default_final_balloon_converted, sheet_name);

		double monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

		double monthlyMainteRentalFromExcel = GetExcelFormulaValue.get_formula_value(88, 1, sheet_name);

		LO.print(
				"Monthly Finance Rental from Excel (after updating customer quote summary final balloon payment value) is "
						+ monthlyFinanceRentalFromExcel);
		System.out.println(
				"Monthly Finance Rental from Excel (after updating customer quote summary final balloon payment value) is "
						+ monthlyFinanceRentalFromExcel);

		LO.print(
				"Monthly Mainte. Rental from Excel (after updating customer quote summary final balloon payment value) is "
						+ monthlyMainteRentalFromExcel);
		System.out.println(
				"Monthly Mainte. Rental from Excel (after updating customer quote summary final balloon payment value) is "
						+ monthlyMainteRentalFromExcel);

		double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
				monthlyFinanceRentalFromExcel);

		double diff2 = Difference.of_two_Double_Values(monthly_maintenance_rental_actual_converted,
				monthlyMainteRentalFromExcel);

		boolean flag = false;
		if (diff1 < 0.2 && diff2 < 0.2) {
			flag = true;
			LO.print(
					"Monthly finance and maint. rental (after updating customer quote summary final balloon payment value) is found OK");
			System.out.println(
					"Monthly finance and maint. rental (after updating customer quote summary final balloon payment value) is found OK");
		} else {
			LO.print(
					"Monthly finance and maint. rental (after updating customer quote summary final balloon payment value) is found wrong");
			System.out.println(
					"Monthly finance and maint. rental (after updating customer quote summary final balloon payment value) is found wrong");
		}

		obj_read_excel_calculation_page.reset_final_balloon_payment_formula_to_excel(sheet_name);

		return flag;

	}

	public boolean check_monthly_payments_on_updating_customer_quote_summary_final_balloon_payment_without_maintenance(
			String sheet_name) throws IOException, InterruptedException, UnsupportedFlavorException {

		Actions act = new Actions(driver);

		ExplicitWait.visibleElement(driver, summary_final_balloon_input_field, 30);

		double default_final_balloon_converted =  Double.parseDouble(summary_final_balloon_input_field.getAttribute("value"));

		summary_final_balloon_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		
		Thread.sleep(2000);

		Click.sendKeysdouble(driver, summary_final_balloon_input_field,
				(default_final_balloon_converted + default_final_balloon_converted), 30);
		act.sendKeys(Keys.TAB).build().perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, customer_quote_monthly_finance_rental, 30);

		double monthly_finance_rental_actual_converted = Double
				.parseDouble(RemoveComma.of(customer_quote_monthly_finance_rental.getText().substring(2)));

		LO.print(
				"Monthly Finance Rental from screen (after updating customer quote summary final balloon payment value) is "
						+ monthly_finance_rental_actual_converted);
		System.out.println(
				"Monthly Finance Rental from screen (after updating customer quote summary final balloon payment value) is "
						+ monthly_finance_rental_actual_converted);

		LO.print("Writing final balloon payment value to excel");
		System.out.println("Writing final balloon payment value to excel");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		obj_read_excel_calculation_page
				.put_customer_quote_summary_final_balloon_payment_to_excel(default_final_balloon_converted, sheet_name);

		double monthlyFinanceRentalFromExcel = GetExcelFormulaValue.get_formula_value(89, 1, sheet_name);

		LO.print(
				"Monthly Finance Rental from Excel (after updating customer quote summary final balloon payment value) is "
						+ monthlyFinanceRentalFromExcel);
		System.out.println(
				"Monthly Finance Rental from Excel (after updating customer quote summary final balloon payment value) is "
						+ monthlyFinanceRentalFromExcel);

		double diff1 = Difference.of_two_Double_Values(monthly_finance_rental_actual_converted,
				monthlyFinanceRentalFromExcel);

		boolean flag = false;
		if (diff1 < 0.2) {
			flag = true;
			LO.print(
					"Monthly finance  rental (after updating customer quote summary final balloon payment value) is found OK");
			System.out.println(
					"Monthly finance  rental (after updating customer quote summary final balloon payment value) is found OK");
		} else {
			LO.print(
					"Monthly finance  rental (after updating customer quote summary final balloon payment value) is found wrong");
			System.out.println(
					"Monthly finance  rental (after updating customer quote summary final balloon payment value) is found wrong");
		}

		obj_read_excel_calculation_page.reset_final_balloon_payment_formula_to_excel(sheet_name);

		return flag;

	}

}
