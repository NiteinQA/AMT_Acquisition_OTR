package com.amt.QuoteSummaryPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ConfigConstants;
import com.amt.testUtil.Difference;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.JavaScriptExecutor;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.RemoveComma;

public class QuoteSummaryBrokerBCHPage extends TestBase {

	ReadExcelCalculation obj_read_excel_calculation_page;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	@FindBy(xpath = "//p[normalize-space()='Quote summary']")
	private WebElement quote_summary;

	@FindBy(xpath = "//*[normalize-space()='Quote reference no.:']//ancestor::div[1]//span[2]")
	private WebElement quote_summary_ref_no;

	@FindBy(xpath = "//*[normalize-space()='Cost OTR price']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_cost_otr_price;

	@FindBy(xpath = "//*[normalize-space()='Cost price ex. VAT & RFL']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_cost_price_ex_vat_and_rfl;

	@FindBy(xpath = "//*[normalize-space()='VAT']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_otr_vat;

	@FindBy(xpath = "//*[normalize-space()='RFL & FRF']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_otr_rfl_and_frf;

	@FindBy(xpath = "//*[normalize-space()='Total monthly holding cost']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_total_monthly_holding_cost;

	@FindBy(xpath = "//*[normalize-space()='Monthly finance rental']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_monthly_finance_rental;

	@FindBy(xpath = "//*[normalize-space()='Monthly maint. rental']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_monthly_maintenance_rental;

	@FindBy(xpath = "//*[normalize-space()='Total monthly rental']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_monthly_total_rental;

	@FindBy(xpath = "//*[@id='headingHoldingCost']//*[normalize-space()='Contract type']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_acq_contract_type;

	@FindBy(xpath = "//*[normalize-space()='Contract type']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_contract_type;

    // vehicle details
	
	@FindBy(xpath = "//*[@class='heading ng-star-inserted']")
	private WebElement quote_summary_vehicle_heading;
	
	
	//customer quote summary button
	
	@FindBy(xpath = "//button[@data-target='#collapseBchSummary']//div[@class='acc-head']")
	private WebElement quote_summary_customer_quote_summary_button;
	
		// terms
	@FindBy(xpath = "//*[normalize-space()='Term']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_terms;

	// Miles per annum
	@FindBy(xpath = "//*[normalize-space()='Miles per annum']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_miles_per_annum;
	
	//Funder name
	@FindBy(xpath = "//*[normalize-space()='Funder']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_funder_name;
	
	//quote ref no.
	@FindBy(xpath = "//*[normalize-space()='Quote reference']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_quote_ref_number;
	
	//quote exp date
	@FindBy(xpath = "//*[normalize-space()='Quote expiry date']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_quote_exp_date;	
	
	
	//payment profile
	@FindBy(xpath = "//*[normalize-space()='Payment profile']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_payment_profile;
	
	//Initial finance rental
	@FindBy(xpath = "//*[normalize-space()='Initial finance rental']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_initial_finance_rental;
	
	//Total initial rental
	@FindBy(xpath = "//*[normalize-space()='Total initial rental']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_total_initial_rental;
	
	//Pence per excess mile - finance
	@FindBy(xpath = "//*[normalize-space()='Pence per excess mile - finance']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_pence_per_excess_mile_finance;
	
	//Pence per excess mile - maint.
	@FindBy(xpath = "//*[normalize-space()='Pence per excess mile - maint.']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_pence_per_excess_mile_maint;
	
	//Pence per excess mile - total
	@FindBy(xpath = "//*[normalize-space()='Pence per excess mile - total']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_pence_per_excess_mile_total;
	
	//commission
	@FindBy(xpath = "//*[normalize-space()='Commission']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_commission;
	
	@FindBy(xpath = "//div[@class='row acquisition-menu']//div[3]//button[1]")
	private WebElement quote_summary_save_button;
	
	Properties prop;

	public QuoteSummaryBrokerBCHPage() {
		
			try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(
					ConfigConstants.EXCEL_VALUES_PROPERTY_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PageFactory.initElements(driver, this);
	}

	public boolean quote_summary_broker_BCH_without_maintenance(String sheet_name)
			throws InterruptedException, IOException {

		LO.print("*************Calculations for Quote Summary page has been started************");
		System.out.println("*************Calculations for Quote Summary page has been started************");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		Click.on(driver, quote_summary, 90);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

        JavaScriptExecutor.click(driver, quote_summary_save_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 50);

		ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 60);
		ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 60);

		LO.print("Reading values from sceen -Quote Summary Page");
		System.out.println("Reading values from sceen -Quote Summary Page");

		String quote_ref_no = quote_summary_ref_no.getText();
		String temp_quote_summary_cost_otr_price = quote_summary_cost_otr_price.getText().trim().substring(2);
		String customer_contract_type = quote_summary_customer_contract_type.getText();

		LO.print("Getting values from screen");
		System.out.println("Getting values from screen");

		LO.print("Quote_summary_cost_otr_price =" + temp_quote_summary_cost_otr_price);
		System.out.println("Quote_summary_cost_otr_price =" + temp_quote_summary_cost_otr_price);

		LO.print("Customer contract_type =" + customer_contract_type);
		System.out.println("Customer contract_type =" + customer_contract_type);

		LO.print("Customer Quote generated successfully and Quote_ref_no =" + quote_ref_no);
		System.out.println("Customer Quote generated successfully and Quote_ref_no =" + quote_ref_no);

		String quote_summary_cost_otr_price_from_screen = RemoveComma.of(temp_quote_summary_cost_otr_price);

		double quote_summary_cost_otr_price_from_screen_converted = Double
				.parseDouble(quote_summary_cost_otr_price_from_screen);

		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);

		wb.getSheet("BrokerBCHQuoteNo").getRow(0).getCell(0).setCellValue(quote_ref_no);

		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		wb.write(out);

		return obj_read_excel_calculation_page
				.verify_quote_summary_values_for_broker_bch_pch_fl_from_excel_without_maintenance(
						quote_summary_cost_otr_price_from_screen_converted, sheet_name);

	}

	public boolean quote_summary_broker_BCH_with_maintenance(String sheet_name)
			throws InterruptedException, IOException {

		LO.print("*************Calculations for Quote Summary page has been started************");
		System.out.println("*************Calculations for Quote Summary page has been started************");

		obj_read_excel_calculation_page = new ReadExcelCalculation();
		Thread.sleep(5000);Click.on(driver, quote_summary, 60);

		Thread.sleep(12000);

        JavaScriptExecutor.click(driver, quote_summary_save_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 50);
		
		ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 120);

		LO.print("Reading values from sceen -Quote Summary Page");
		System.out.println("Reading values from sceen -Quote Summary Page");

		String quote_ref_no = quote_summary_ref_no.getText();
		String temp_quote_summary_cost_otr_price = quote_summary_cost_otr_price.getText().trim().substring(2);
		String customer_contract_type = quote_summary_customer_contract_type.getText();

		LO.print("Getting values from screen");
		System.out.println("Getting values from screen");

		LO.print("Quote_summary_cost_otr_price =" + temp_quote_summary_cost_otr_price);
		System.out.println("Quote_summary_cost_otr_price =" + temp_quote_summary_cost_otr_price);

		LO.print("Customer contract_type =" + customer_contract_type);
		System.out.println("Customer contract_type =" + customer_contract_type);

		LO.print("Customer Quote generated successfully and Quote_ref_no =" + quote_ref_no);
		System.out.println("Customer Quote generated successfully and Quote_ref_no =" + quote_ref_no);

		String quote_summary_cost_otr_price_from_screen = RemoveComma.of(temp_quote_summary_cost_otr_price);

		double quote_summary_cost_otr_price_from_screen_converted = Double
				.parseDouble(quote_summary_cost_otr_price_from_screen);

		return obj_read_excel_calculation_page
				.verify_quote_summary_values_for_broker_bch_pch_fl_from_excel_with_maintenance(
						quote_summary_cost_otr_price_from_screen_converted, sheet_name);

	}

	public boolean quote_summary_OTR_calculation_for_used_car(String sheet_name)
			throws InterruptedException, IOException {

		LO.print("*************OTR Calulation on quote summary page has been started************");
		System.out.println("*************OTR Calulation on quote summary page has been started************");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		Thread.sleep(2000);

		Thread.sleep(5000);Click.on(driver, quote_summary, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);

		ExplicitWait.visibleElement(driver, quote_summary_cost_price_ex_vat_and_rfl, 120);

		ExplicitWait.visibleElement(driver, quote_summary_otr_vat, 120);

		LO.print("Reading values from OTR calculation -Quote Summary Page");
		System.out.println("Reading values from OTR calculation -Quote Summary Page");

		double OTR_calculation_cost_otr_price_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_cost_otr_price.getText().trim().substring(2)));

		double OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_cost_price_ex_vat_and_rfl.getText().trim().substring(2)));

		double OTR_calculation_otr_vat_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_otr_vat.getText().trim().substring(2)));

		LO.print("OTR_calculation_cost_otr_price_from_screen =" + OTR_calculation_cost_otr_price_from_screen_converted);
		System.out.println(
				"OTR_calculation_cost_otr_price_from_screen =" + OTR_calculation_cost_otr_price_from_screen_converted);

		LO.print("OTR_calculation_cost_price_ex_vat_and_rfl_from_screen ="
				+ OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted);
		System.out.println("OTR_calculation_cost_price_ex_vat_and_rfl_from_screen ="
				+ OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted);

		LO.print("OTR_calculation_otr_vat_from_screen =" + OTR_calculation_otr_vat_from_screen_converted);
		System.out.println("OTR_calculation_otr_vat_from_screen =" + OTR_calculation_otr_vat_from_screen_converted);

		double OTR_calculation_cost_otr_price_from_excel = GetExcelFormulaValue.get_formula_value(3, 1, sheet_name);
		double OTR_calculation_cost_price_ex_vat_and_rfl_from_excel = GetExcelFormulaValue.get_formula_value(1, 1,
				sheet_name);
		double OTR_calculation_otr_vat_from_excel = GetExcelFormulaValue.get_formula_value(1, 3, sheet_name);
		double OTR_calculation_otr_rfl_and_frf_excel = GetExcelFormulaValue.get_formula_value(1, 5, sheet_name);

		LO.print("OTR_calculation_cost_otr_price_from_excel =" + OTR_calculation_cost_otr_price_from_excel);
		System.out.println("OTR_calculation_cost_otr_price_from_excel =" + OTR_calculation_cost_otr_price_from_excel);

		LO.print("OTR_calculation_cost_price_ex_vat_and_rfl_from_excel ="
				+ OTR_calculation_cost_price_ex_vat_and_rfl_from_excel);
		System.out.println("OTR_calculation_cost_price_ex_vat_and_rfl_from_excel ="
				+ OTR_calculation_cost_price_ex_vat_and_rfl_from_excel);

		LO.print("OTR_calculation_otr_vat_from_excel =" + OTR_calculation_otr_vat_from_excel);
		System.out.println("OTR_calculation_otr_vat_from_excel =" + OTR_calculation_otr_vat_from_excel);

		LO.print("OTR_calculation_otr_rfl_and_frf_from_excel =" + OTR_calculation_otr_rfl_and_frf_excel);
		System.out.println("OTR_calculation_otr_rfl_and_frf_from_excel =" + OTR_calculation_otr_rfl_and_frf_excel);

		double diff_otr = Difference.of_two_Double_Values(OTR_calculation_cost_otr_price_from_excel,
				OTR_calculation_cost_otr_price_from_screen_converted);
		double diff_cost_price = Difference.of_two_Double_Values(OTR_calculation_cost_price_ex_vat_and_rfl_from_excel,
				OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted);
		double diff_otr_vat = Difference.of_two_Double_Values(OTR_calculation_otr_vat_from_excel,
				OTR_calculation_otr_vat_from_screen_converted);

		int count = 0;
		boolean status = false;
		if (diff_otr < 0.2) {
			LO.print("OTR price compared");
			System.out.println("OTR price compared");
			count++;
		} else {
			LO.print("Found difference between OTR actual price and OTR expected price on Quote Summary Page");
			System.err
					.println("Found difference between OTR actual price and OTR expected price on Quote Summary Page");
		}

		if (diff_cost_price < 0.2) {
			LO.print("Cost price ex vat and rfl compared");
			System.out.println("Cost price ex vat and rfl compared");
			count++;
		} else {
			LO.print(
					"Found difference between (Cost price ex vat and rfl) actual and (Cost price ex vat and rfl) expected on Quote Summary Page");
			System.err.println(
					"Found difference between (Cost price ex vat and rfl) actual and (Cost price ex vat and rfl) expected on Quote Summary Page");
		}

		if (diff_otr_vat < 0.2) {
			LO.print("VAT compared");
			System.out.println("VAT compared");
			count++;
		} else {
			LO.print("Found difference between VAT actual and VAT expected on Quote Summary Page");
			System.err.println("Found difference between VAT actual and VAT expected on Quote Summary Page");
		}

		if (count == 3) {
			status = true;
		}

		return status;

	}

}
