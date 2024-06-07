package com.amt.pages.ContractTypesAndOTRPages;

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
import com.amt.testUtil.JavaScriptExecutor;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.ReadExcelCalculationForPurchaseAgreement;
import com.amt.testUtil.RemoveComma;

public class ContractTypesAndOTR_HPNR_BCH_Page extends TestBase {
	ContractTypesAndOTR_HPNR_BCH_Page obj_contract_types_page;
	ReadExcelCalculation obj_read_excel_calculation_hire;
	
	ReadExcelCalculationForPurchaseAgreement obj_read_excel_calculation_purchase;
		 
	Actions act;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	@FindBy(xpath = "//*[@id ='acqOTRHeader']")
	private WebElement acq_contractTypes;

	@FindBy(xpath = "(//p[contains(text(),' Hire Purchase Non-Regulated')])[1]")
	private WebElement acq_acq_contractTypes_HPNR;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[1]/div[1]/div[2]")
	private WebElement acq_contractTypes_calculation_table_basic_price;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[1]/div[1]/div[3]")
	private WebElement acq_contractTypes_calculation_table_discount;

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-aquisition-otr[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/app-acquisition-common-otr-calculations[1]/form[1]/div[1]/div[1]/div[4]")
	private WebElement acq_contractTypes_calculation_table_additional_discount;

	@FindBy(xpath = "(//p[contains(text(),'Business Contract Hire')])[2]")
	private WebElement acq_contractTypes_customer_contract_BCH;

	@FindBy(xpath = "//*[normalize-space()='Subtotal after discounts']//ancestor::div[1]//div[2]")
	private WebElement acq_contractTypes_subtotal_after_discounts;

	@FindBy(xpath = "//*[normalize-space()='RFL:']//ancestor::div[1]//p")
	private WebElement acq_contractTypes_road_tax_first_year;

	@FindBy(xpath = "//*[@id='roadTaxFirstYear']")
	private WebElement acq_contractTypes_road_tax_first_year_input;

	@FindBy(xpath = "//app-acquisition-common-otr-calculations//*[normalize-space()='Manufacturer delivery charges']//ancestor::div[1]//div[2]")
	private WebElement acq_contractTypes_manufacturer_delivery_charges;

	@FindBy(xpath = "//app-acquisition-common-otr-calculations//*[normalize-space()='First registration fee']//ancestor::div[1]//div[2]")
	private WebElement acq_contractTypes_first_registration_fee;

	@FindBy(xpath = "//app-acquisition-common-otr-calculations//*[normalize-space()='Rebate']//ancestor::div[1]//div[2]")
	private WebElement acq_contractTypes_rebate;

	@FindBy(xpath = "//*[normalize-space()='OTR for invoice:']//ancestor::div[1]//p")
	private WebElement acq_contractTypes_OTR_price;
	
	@FindBy(xpath = "//*[@id='OTRPrice']")
	private WebElement otr_price;

	@FindBy(xpath = "//*[@id='ListingPriceNew']")
	private WebElement acq_contractTypes_table_calculation_basic_vehicle_price;

	@FindBy(xpath = "//*[@id='collapseTwo']/app-acquisition-common-otr-calculations/form/div[1]/div/div[2]/div[3]")
	private WebElement acq_contractTypes_table_calculation_basic_paint_price;

	@FindBy(xpath = "//*[@id='collapseTwo']/app-acquisition-common-otr-calculations/form/div[1]/div/div[2]/div[4]")
	private WebElement acq_contractTypes_table_calculation_basic_options_price;

	@FindBy(xpath = "//*[normalize-space()='Cost price ex. VAT & RFL']//ancestor::div[1]//div//strong")
	private WebElement contract_types_cost_price_ex_vat_and_rfl;

	@FindBy(xpath = "//*[normalize-space()='VAT']//ancestor::div[1]//div//strong")
	private WebElement contract_types_vat;

	@FindBy(xpath = "//*[normalize-space()='RFL & FRF']//ancestor::div[1]//div//strong")
	private WebElement contract_types_rfl_and_frf;

	@FindBy(xpath = "//*[normalize-space()='Cost OTR price']//ancestor::div[1]//div//strong")
	private WebElement contract_types_otr;

	@FindBy(xpath = "//input[@id='ListingPriceUsed']")
	private WebElement vehicle_cost_price_input;

	@FindBy(xpath = "//input[@id='roadTaxFirstYear']")
	private WebElement road_tax_for_first_year_input;

	@FindBy(xpath = "//input[@id='roadTaxFirstYear']")
	private WebElement rfl_input;

	@FindBy(xpath = "//*[@id='preparationCost']")
	private WebElement options_cost_input;

	// other_support_type dropdown

	@FindBy(xpath = "//*[@name='OtherSupportType']")
	private WebElement other_support_type;

	// remarks_text

	@FindBy(xpath = "//*[@name='RemarksText']")
	private WebElement remarks_text;

	// other_support_value

	@FindBy(xpath = "//*[@name='OtherSupportValue']")
	private WebElement other_support_value;

	// add_other_support_button

	@FindBy(xpath = "//*[normalize-space()='Other support']//ancestor::div[1]//div[2]//div/div[4]/a")
	private WebElement add_other_support_button;

	// on_road_price_for_calculation

	@FindBy(xpath = "(//*[normalize-space()='On the road price for calculation']//ancestor::div[1]/div)[2]")
	private WebElement on_road_price_for_calculation;

	// delete_other_support button

	@FindBy(xpath = "//*[@src='/assets/images/delete.svg']")
	private WebElement delete_other_support;

	@FindBy(xpath = "//div[@class='row acquisition-menu']//div[3]//button[1]")
	private WebElement quote_summary_save_button;

	// **********Discount elements

	@FindBy(xpath = "//*[@id='addManfacturerDiscountBtn']")
	private WebElement add_manufacturer_discount_button;

	@FindBy(xpath = "//*[@id='addDealerDiscountBtn']")
	private WebElement add_dealer_discount_button;

	@FindBy(xpath = "//*[@id='DiscountOnVehiclePercentageCustomDiscount']")
	private WebElement manufacturer_discount_on_vehicle_percentage_input;

	@FindBy(xpath = "(//*[@id='DiscountOnVehiclePercentageCustomDiscount'])[2]")
	private WebElement dealer_discount_on_vehicle_percentage_input;

	@FindBy(xpath = "//*[@id='DiscountOnVehicleValueCustomDiscount']")
	private WebElement manufaturer_additional_discount_vehicle_input;

	@FindBy(xpath = "//*[@id='DiscountOnVehicleValueCustomDiscountForManufacturer']")
	private WebElement dealer_additional_discount_vehicle_input;

	@FindBy(xpath = "//*[@id='applyDiscountToOptionAndPaint']")
	private WebElement apply_same_discount_to_paint_and_option_checkbox;

	@FindBy(xpath = "//*[@id='DiscountOnOptionPercentageCustomDiscountMan']")
	private WebElement manufacturer_discount_on_options_percentage_input;

	@FindBy(xpath = "//*[@id='DiscountOnOptionPercentageCustomDiscount']")
	private WebElement dealer_discount_on_options_percentage_input;

	@FindBy(xpath = "//*[@id='DiscountOnPaintPercentageCustomDiscountMan']")
	private WebElement manufacturer_discount_on_paints_percentage_input;

	@FindBy(xpath = "//*[@id='DiscountOnPaintPercentageCustomDiscount']")
	private WebElement dealer_discount_on_paints_percentage_input;

	@FindBy(xpath = "//*[@id='DiscountOnOptionValueCustomDiscount']")
	private WebElement manufacturer_additional_discount_options_input;

	@FindBy(xpath = "//*[@id='DiscountOnPaintValueCustomDiscount']")
	private WebElement manufacturer_additional_discount_paint_input;

	@FindBy(xpath = "//*[@id='DiscountOnOptionValueCustomDiscountForManufacturer']")
	private WebElement dealer_additional_discount_options_input;

	@FindBy(xpath = "//*[@id='DiscountOnPaintValueCustomDiscountForManufacturer']")
	private WebElement dealer_additional_discount_paint_input;

	@FindBy(xpath = "//*[@id='RebateCustom']")
	private WebElement manufacturer_rebate_input;

	@FindBy(xpath = "//*[@id='MarketingBonusCustom']")
	private WebElement manufacturer_marketing_bonus_input;

	@FindBy(xpath = "//*[@id='MakeRoadWorthyCustomDiscount']")
	private WebElement manufacturer_manufacturing_delivery_charges_input;

	@FindBy(xpath = "//*[@id='RebateCustomForManufacturer']")
	private WebElement dealer_rebate_input;

	@FindBy(xpath = "//*[@id='MarketingBonusCustomForManufacturer']")
	private WebElement dealer_marketing_bonus_input;

	@FindBy(xpath = "//*[@id='MakeRoadWorthyCustomDiscountForManufacturer']")
	private WebElement dealer_manufacturing_delivery_charges_input;

	@FindBy(xpath = "//*[normalize-space()='Remarks']//div//textarea")
	private WebElement manufacturer_remarks_input;

	@FindBy(xpath = "(//*[normalize-space()='Remarks']//div//textarea)[2]")
	private WebElement dealer_remarks_input;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement add_discount;	
	
	@FindBy(xpath = "//*[@id='ListingPriceNew']")
	private WebElement vehicle_basic_price;

	public ContractTypesAndOTR_HPNR_BCH_Page() {
		PageFactory.initElements(driver, this);
	}

	public boolean contractTypes_and_OTR_selection_HPNR_BCH_Ownbook_calculation(String sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException {
		Click.on(driver, acq_contractTypes, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		Click.on(driver, acq_acq_contractTypes_HPNR, 50);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		LO.print(" Acquisition Contract type option = HPNR has been selected");
		System.out.println("Acquisition Contract type option = HPNR has been selected");

		Click.on(driver, acq_contractTypes_customer_contract_BCH, 30);

		LO.print(" Customer Contract type option = Business Contract Hire(BCH) has been selected");
		System.out.println(" Customer Contract type option = Business Contract Hire(BCH) has been selected");
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, acq_contractTypes_table_calculation_basic_vehicle_price, 30);
		String vehicle_price_copied = acq_contractTypes_table_calculation_basic_vehicle_price.getAttribute("value");

		obj_read_excel_calculation_hire = new ReadExcelCalculation();

		double subtotal_after_discount_excel = obj_read_excel_calculation_hire
				.verify_table_calculations_contract_types_page(driver, vehicle_price_copied,
						acq_contractTypes_table_calculation_basic_paint_price,
						acq_contractTypes_table_calculation_basic_options_price,
						acq_contractTypes_calculation_table_discount,
						acq_contractTypes_calculation_table_additional_discount, sheet_name);

		String subtotal_after_discount_actual = acq_contractTypes_subtotal_after_discounts.getText();

		LO.print("Subtotal after discount actual value from screen =" + subtotal_after_discount_actual);
		System.out.println("Subtotal after discount actual value from screen =" + subtotal_after_discount_actual);

		String str = subtotal_after_discount_actual.substring(2);

		String subtotal_after_discount_actual_converted = RemoveComma.of(str);

		double subtotal_after_discount_actual_from_screen = Double
				.parseDouble(subtotal_after_discount_actual_converted);
		boolean flag = false;
		double diff = Difference.of_two_Double_Values(subtotal_after_discount_excel,
				subtotal_after_discount_actual_from_screen);
		if (diff < 0.2) {
			flag = true;
		}

		return flag;
	}

	public void edit_road_tax_for_first_year_on_otr_page(String road_tax_for_first_year,
			String calculation_excel_sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		Click.on(driver, acq_contractTypes, 50);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		LO.print("");
		System.out.println("");

		LO.print("Sending Road tax for first year " + road_tax_for_first_year + " from test data to sceen");
		System.out.println("Sending Road tax for first year " + road_tax_for_first_year + " from test data to sceen");

		ExplicitWait.visibleElement(driver, road_tax_for_first_year_input, 20);

		road_tax_for_first_year_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		Thread.sleep(1000);

		Click.sendKeys(driver, road_tax_for_first_year_input, road_tax_for_first_year, 30);

		act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();

		Thread.sleep(2000);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		// write same to calculation sheet

		obj_read_excel_calculation_hire = new ReadExcelCalculation();

		obj_read_excel_calculation_hire.write_road_tax_for_first_year_to_calculation_excel(road_tax_for_first_year,
				calculation_excel_sheet_name);

		ExplicitWait.visibleElement(driver, quote_summary_save_button, 30);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", quote_summary_save_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 120);

	}

	public boolean contractTypes_selection_and_OTR_calculation(String sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException {

		Click.on(driver, acq_contractTypes, 50);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);
		Click.on(driver, acq_acq_contractTypes_HPNR, 50);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		LO.print(" Acquisition Contract type option = HPNR has been selected");
		System.out.println("Acquisition Contract type option = HPNR has been selected");

		Click.on(driver, acq_contractTypes_customer_contract_BCH, 30);

		LO.print(" Customer Contract type option = Business Contract Hire(BCH) has been selected");
		System.out.println(" Customer Contract type option = Business Contract Hire(BCH) has been selected");
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, contract_types_cost_price_ex_vat_and_rfl, 20);
		ExplicitWait.visibleElement(driver, contract_types_vat, 20);
		// ExplicitWait.visibleElement(driver, contract_types_rfl_and_frf, 20);
		ExplicitWait.visibleElement(driver, contract_types_otr, 20);

		double cost_price_ex_vat_and_rfl_from_screen = Double
				.parseDouble(RemoveComma.of(contract_types_cost_price_ex_vat_and_rfl.getText().substring(2)));
		double vat = Double.parseDouble(RemoveComma.of(contract_types_vat.getText().substring(2)));
		// double rfl_and_frf =
		// Double.parseDouble(RemoveComma.of(contract_types_rfl_and_frf.getText().substring(2)));
		double otr = Double.parseDouble(RemoveComma.of(contract_types_otr.getText().substring(2)));

		LO.print("Cost Price ex VAT and RFL from screen is " + cost_price_ex_vat_and_rfl_from_screen);
		System.out.println("Cost Price ex VAT and RFL from screen is " + cost_price_ex_vat_and_rfl_from_screen);

		LO.print("VAT from screen is " + vat);
		System.out.println("VAT from screen is " + vat);

//		LO.print("RFL AND FRF from screen is " + rfl_and_frf);
//		System.out.println("RFL AND FRF from screen is " + rfl_and_frf);

		// double cost_price_ex_vat_and_rfl_expected = (otr - (rfl_and_frf + vat));

		obj_read_excel_calculation_hire = new ReadExcelCalculation();

		obj_read_excel_calculation_hire
				.write_vehicle_cost_Price_to_excel_for_used_car(cost_price_ex_vat_and_rfl_from_screen, 0, sheet_name);

		double cost_price_ex_vat_and_rfl_expected = GetExcelFormulaValue.get_formula_value(1, 1, sheet_name);

		LO.print("Cost Price ex VAT and RFL calculated is " + cost_price_ex_vat_and_rfl_expected);
		System.out.println("Cost Price ex VAT and RFL calculated is " + cost_price_ex_vat_and_rfl_expected);

		boolean status = false;
		if (Difference.of_two_Double_Values(cost_price_ex_vat_and_rfl_from_screen,
				cost_price_ex_vat_and_rfl_expected) < 0.2) {
			status = true;
			LO.print("Cost Price ex VAT and RFL verified and found OK");
			System.out.println("Cost Price ex VAT and RFL verified and found OK");
		} else {
			LO.print("Cost Price ex VAT and RFL found Wrong");
			System.err.println("Cost Price ex VAT and RFL found Wrong");
		}

		return status;

	}

	public boolean edit_vehicle_cost_price_and_check_OTR_price(String vehicelCostPrice,
			String options_and_preparation_cost, String sheet_name)
			throws InterruptedException, IOException, UnsupportedFlavorException {

		LO.print("");
		System.out.println("");

		LO.print("Entering vehicle cost price and options cost from test data to screen ");
		System.out.println("Entering vehicle cost price and options cost from test data to screen ");

		ExplicitWait.visibleElement(driver, vehicle_cost_price_input, 20);

		vehicle_cost_price_input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		Click.sendKeys(driver, vehicle_cost_price_input, vehicelCostPrice, 30);

		act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();

		Thread.sleep(2000);

		ExplicitWait.visibleElement(driver, contract_types_cost_price_ex_vat_and_rfl, 20);
		ExplicitWait.visibleElement(driver, contract_types_vat, 20);
		// ExplicitWait.visibleElement(driver, contract_types_rfl_and_frf, 20);
		ExplicitWait.visibleElement(driver, contract_types_otr, 20);

		double cost_price_ex_vat_and_rfl_from_screen = Double
				.parseDouble(RemoveComma.of(contract_types_cost_price_ex_vat_and_rfl.getText().substring(2)));
		double vat = Double.parseDouble(RemoveComma.of(contract_types_vat.getText().substring(2)));
		// double rfl_and_frf =
		// Double.parseDouble(RemoveComma.of(contract_types_rfl_and_frf.getText().substring(2)));
		double otr = Double.parseDouble(RemoveComma.of(contract_types_otr.getText().substring(2)));

		LO.print("Reading values from screen after editing Vehicle cost price and options cost");
		System.out.println("Reading values from screen after editing Vehicle cost price and options cost");

		LO.print("Cost Price ex VAT and RFL from screen is " + cost_price_ex_vat_and_rfl_from_screen);
		System.out.println("Cost Price ex VAT and RFL from screen is " + cost_price_ex_vat_and_rfl_from_screen);

		LO.print("VAT from screen is " + vat);
		System.out.println("VAT from screen is " + vat);

		// LO.print("RFL AND FRF from screen is " + rfl_and_frf);
		// System.out.println("RFL AND FRF from screen is " + rfl_and_frf);

		obj_read_excel_calculation_hire = new ReadExcelCalculation();

		obj_read_excel_calculation_hire
				.write_vehicle_cost_Price_to_excel_for_used_car(Double.parseDouble(vehicelCostPrice), 0, sheet_name);

		double cost_price_ex_vat_and_rfl_expected = GetExcelFormulaValue.get_formula_value(1, 1, sheet_name);

		LO.print("Cost Price ex VAT and RFL expected from excel is " + cost_price_ex_vat_and_rfl_expected);
		System.out.println("Cost Price ex VAT and RFL expected from excel is " + cost_price_ex_vat_and_rfl_expected);

		boolean status = false;
		if (Difference.of_two_Double_Values(cost_price_ex_vat_and_rfl_from_screen,
				cost_price_ex_vat_and_rfl_expected) < 0.2) {
			status = true;
			LO.print("Cost Price ex VAT and RFL verified and found OK");
			System.out.println("Cost Price ex VAT and RFL verified and found OK");
		} else {
			LO.print("Cost Price ex VAT and RFL found Wrong");
			System.err.println("Cost Price ex VAT and RFL found Wrong");
		}

		return status;

	}

	public boolean contractTypes_and_OTR_selection_outright_bch_vehicle_price_edited(String vehicleBasicPrice,
			String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		Click.on(driver, acq_contractTypes, 40);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		Click.on(driver, acq_acq_contractTypes_HPNR, 50);

		Thread.sleep(5000);

		act = new Actions(driver);
		act.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER).build().perform();

		// Click.on(driver, acq_contractTypes_customer_contract_BCH , 50);

		LO.print("Contract type option has been selected");

		ExplicitWait.visibleElement(driver, acq_contractTypes_table_calculation_basic_vehicle_price, 30);
		acq_contractTypes_table_calculation_basic_vehicle_price.click();

		acq_contractTypes_table_calculation_basic_vehicle_price.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		acq_contractTypes_table_calculation_basic_vehicle_price.sendKeys(vehicleBasicPrice);

		act.sendKeys(Keys.TAB).build().perform();

		obj_read_excel_calculation_hire = new ReadExcelCalculation();

		double subtotal_after_discount_excel = obj_read_excel_calculation_hire
				.verify_table_calculations_contract_types_page_edited(driver, vehicleBasicPrice,
						acq_contractTypes_table_calculation_basic_paint_price,
						acq_contractTypes_table_calculation_basic_options_price,
						acq_contractTypes_calculation_table_discount,
						acq_contractTypes_calculation_table_additional_discount, sheet_name);

		String subtotal_after_discount_actual = acq_contractTypes_subtotal_after_discounts.getText();

		LO.print("Subtotal after discount actual value from screen =" + subtotal_after_discount_actual);
		System.out.println("Subtotal after discount actual value from screen =" + subtotal_after_discount_actual);

		String str = subtotal_after_discount_actual.substring(2);

		String subtotal_after_discount_actual_converted = RemoveComma.of(str);

		double subtotal_after_discount_actual_from_screen = Double
				.parseDouble(subtotal_after_discount_actual_converted);
		boolean flag = false;
		double diff = Difference.of_two_Double_Values(subtotal_after_discount_excel,
				subtotal_after_discount_actual_from_screen);
		if (diff < 0.2) {
			flag = true;
		}

		return flag;

	}

	public boolean verify_after_discount_calculations_contract_types_page_edited(String roadTaxForFirstYear,
			String sheet_name) throws IOException {

		Click.sendKeys(driver, acq_contractTypes_road_tax_first_year_input, roadTaxForFirstYear, 30);
		act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();

		obj_read_excel_calculation_hire = new ReadExcelCalculation();
		return obj_read_excel_calculation_hire.verify_after_discount_calculations_contract_types_page_edited(driver,

				acq_contractTypes_manufacturer_delivery_charges, roadTaxForFirstYear,
				acq_contractTypes_first_registration_fee, acq_contractTypes_rebate, acq_contractTypes_OTR_price,
				sheet_name);
	}

	public boolean verify_after_discount_calculations_contract_types_page(String sheet_name) throws IOException {

		obj_read_excel_calculation_hire = new ReadExcelCalculation();
		return obj_read_excel_calculation_hire.verify_after_discount_calculations_contract_types_page(driver,
				acq_contractTypes_calculation_table_basic_price, acq_contractTypes_calculation_table_discount,
				acq_contractTypes_calculation_table_additional_discount,
				acq_contractTypes_manufacturer_delivery_charges, acq_contractTypes_road_tax_first_year,
				acq_contractTypes_first_registration_fee, acq_contractTypes_rebate, acq_contractTypes_OTR_price,
				sheet_name);
	}

	public void add_manufacturer_discount(String vehicle_percentage_discount, String additional_discount_vehicle,
			String options_percentage_discount, String additional_discount_options, String paint_percentage_discount,
			String additional_discount_paint, String rebate, String marketing_bonus,
			String manufacturer_delivery_charges) throws InterruptedException {

		Click.on(driver, acq_contractTypes, 20);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 100);

		LO.print("Adding Manufacturer Discount On OTR page");
		System.out.println("Adding Manufacturer Discount On OTR page");

		// open pop up on clicking add discount button
		Click.on(driver, add_manufacturer_discount_button, 20);

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", apply_same_discount_to_paint_and_option_checkbox);

		Thread.sleep(2000);

		// add vehicle discount
		Click.sendKeys(driver, manufacturer_discount_on_vehicle_percentage_input, vehicle_percentage_discount, 20);

		Click.sendKeys(driver, manufaturer_additional_discount_vehicle_input, additional_discount_vehicle, 20);

		// add options discount
		Click.sendKeys(driver, manufacturer_discount_on_options_percentage_input, options_percentage_discount, 20);

		Click.sendKeys(driver, manufacturer_additional_discount_options_input, additional_discount_options, 20);

		// add paint discount
		Click.sendKeys(driver, manufacturer_discount_on_paints_percentage_input, paint_percentage_discount, 20);

		Click.sendKeys(driver, manufacturer_additional_discount_paint_input, additional_discount_paint, 20);

		// add rebate
		Click.sendKeys(driver, manufacturer_rebate_input, rebate, 20);

		// add marketing bonus
		Click.sendKeys(driver, manufacturer_marketing_bonus_input, marketing_bonus, 20);

		// add manufacturing del charges bonus
		Click.sendKeys(driver, manufacturer_manufacturing_delivery_charges_input, manufacturer_delivery_charges, 20);

		// add remarks
		Click.sendKeys(driver, manufacturer_remarks_input, "Man Discount Test Remark", 20);

		Click.on(driver, add_discount, 20);

		LO.print("Manufacturer Discount Added On OTR page");
		System.out.println("Manufacturer Discount Added On OTR page");

	}

	public void add_dealer_discount(String vehicle_percentage_discount, String additional_discount_vehicle,
			String options_percentage_discount, String additional_discount_options, String paint_percentage_discount,
			String additional_discount_paint, String rebate, String marketing_bonus,
			String manufacturer_delivery_charges) throws InterruptedException {

		Click.on(driver, acq_contractTypes, 20);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 100);

		LO.print("Adding Dealer Discount On OTR page");
		System.out.println("Adding Dealer Discount On OTR page");

//open pop up on clicking add discount button
		Click.on(driver, add_dealer_discount_button, 20);

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", apply_same_discount_to_paint_and_option_checkbox);

		Thread.sleep(2000);

//add vehicle discount 		
		Click.sendKeys(driver, dealer_discount_on_vehicle_percentage_input, vehicle_percentage_discount, 20);

		Click.sendKeys(driver, dealer_additional_discount_vehicle_input, additional_discount_vehicle, 20);

//add options discount 		
		Click.sendKeys(driver, dealer_discount_on_options_percentage_input, options_percentage_discount, 20);

		Click.sendKeys(driver, dealer_additional_discount_options_input, additional_discount_options, 20);

//add paint discount 		
		Click.sendKeys(driver, dealer_discount_on_paints_percentage_input, paint_percentage_discount, 20);

		Click.sendKeys(driver, dealer_additional_discount_paint_input, additional_discount_paint, 20);

//add rebate		
		Click.sendKeys(driver, dealer_rebate_input, rebate, 20);

//add marketing bonus		
		Click.sendKeys(driver, dealer_marketing_bonus_input, marketing_bonus, 20);

//add manufacturing del charges bonus		
		Click.sendKeys(driver, dealer_manufacturing_delivery_charges_input, manufacturer_delivery_charges, 20);

//add remarks	
		Click.sendKeys(driver, dealer_remarks_input, "Man Discount Test Remark", 20);

		Click.on(driver, add_discount, 20);

		LO.print("Dealer Discount Added On OTR page");
		System.out.println("Dealer Discount Added On OTR page");

	}

	public void edit_basic_price(String basic_price) throws InterruptedException {

		Click.on(driver, acq_contractTypes, 20);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 100);

		LO.print("Editing Basic Price");
		System.out.println("Editing Basic Price");

		ExplicitWait.visibleElement(driver,vehicle_basic_price, 20);

		vehicle_basic_price.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		
		Thread.sleep(1000);
		
		Click.sendKeys(driver, vehicle_basic_price, basic_price, 30);
		
		Actions act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();		
		
		LO.print("Basic Price changed On OTR page");
		System.out.println("Basic Price changed On OTR page");

	}

	
	public void increase_OTR_price(String on_road_price_for_invoice , String sheet_name) throws InterruptedException, IOException, ClassNotFoundException {


		LO.print("Increasing OTR price by 50 %");
		System.out.println("Increasing OTR price by 50 %");

		ExplicitWait.visibleElement(driver,otr_price, 20);
		
		double otr_for_invoice_from_screen =Double.parseDouble(otr_price.getAttribute("value"));
		
		double increased_otr = otr_for_invoice_from_screen*1.5;

		otr_price.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		
		Thread.sleep(1000);
		
		Click.sendKeysdouble(driver, otr_price, increased_otr, 30);
		
		Actions act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();		
		
		LO.print("Increased OTR Price is "+increased_otr);
		System.out.println("Increased OTR Price is "+increased_otr);
		
		LO.print("Set the same value of OTR into the excel sheet");
		System.out.println("Set the same value of OTR into the excel sheet");
		
		
//		obj_read_excel_calculation_hire = new ReadExcelCalculation();
//		
//		obj_read_excel_calculation_hire.write_otr_value_to_the_calculation_sheet_excel(increased_otr, sheet_name);
		
		
		ExplicitWait.visibleElement(driver, vehicle_basic_price, 30);
		String vehicle_price_copied = vehicle_basic_price.getAttribute("value");
		
        String className = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName();
		
		write_discount_table_values_to_excel(className, vehicle_price_copied, sheet_name);
		
		LO.print("writing OTR value into the excel sheet completed");
		System.out.println("writing OTR value into the excel sheet completed");

}

	public void write_discount_table_values_to_excel(String className, String vehicle_price_copied, String sheet_name)
			throws IOException {
		if(className.contains("hire"))
		{
			
			obj_read_excel_calculation_hire = new ReadExcelCalculation();	
			
		obj_read_excel_calculation_hire
				.verify_table_calculations_contract_types_page(driver, vehicle_price_copied,
						acq_contractTypes_table_calculation_basic_paint_price,
						acq_contractTypes_table_calculation_basic_options_price,
						acq_contractTypes_calculation_table_discount,
						acq_contractTypes_calculation_table_additional_discount, sheet_name);
		
		}else if(className.contains("purchase"))
		{
			
	
		   obj_read_excel_calculation_purchase =new ReadExcelCalculationForPurchaseAgreement();
		   
		obj_read_excel_calculation_purchase.verify_table_calculations_contract_types_page(driver, vehicle_price_copied, acq_contractTypes_table_calculation_basic_paint_price,acq_contractTypes_table_calculation_basic_options_price, acq_contractTypes_calculation_table_discount, acq_contractTypes_calculation_table_additional_discount, sheet_name);	
		
		}
	}

	
	
	public void decrease_OTR_price(String on_road_price_for_invoice , String sheet_name) throws InterruptedException, IOException, ClassNotFoundException {


		
		
		LO.print("Decreasing OTR price by 50 %");
		System.out.println("Decreasing OTR price by 50 %");

		ExplicitWait.visibleElement(driver,otr_price, 20);
		
		double otr_for_invoice_from_screen =Double.parseDouble(otr_price.getAttribute("value"));
		
		double decreased_otr = otr_for_invoice_from_screen/1.5;

		otr_price.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		
		Thread.sleep(1000);
		
		Click.sendKeysdouble(driver, otr_price, decreased_otr, 30);
		
		Actions act = new Actions(driver);

		act.sendKeys(Keys.TAB).build().perform();		
		
		LO.print("Decreased OTR Price is "+decreased_otr);
		System.out.println("Decreased OTR Price is "+decreased_otr);
		
		LO.print("Set the same value of OTR into the excel sheet");
		System.out.println("Set the same value of OTR into the excel sheet");
		
		
//		obj_read_excel_calculation_hire = new ReadExcelCalculation();
//		
//		obj_read_excel_calculation_hire.write_otr_value_to_the_calculation_sheet_excel(increased_otr, sheet_name);
		
		
		ExplicitWait.visibleElement(driver, vehicle_basic_price, 30);
		String vehicle_price_copied = vehicle_basic_price.getAttribute("value");
      
		String className = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName();

		
		write_discount_table_values_to_excel(className, vehicle_price_copied, sheet_name);		
		LO.print("writing OTR value into the excel sheet completed");
		System.out.println("writing OTR value into the excel sheet completed");

}

	public boolean verify_other_support_calculations(String otherSupportValue, String sheet_name)
			throws IOException, InterruptedException {

		LO.print("Verification of OTR price for calculation after adding other support value has been started");
		System.out
				.println("Verification of OTR price for calculation after adding other support value has been started");

		// Adding other support
		for (int i = 0; i <= 2; i++) {

			Dropdown.select(driver, other_support_type, i, 20);

			Click.sendKeys(driver, remarks_text, " Support " + i, 20);

			Click.sendKeys(driver, other_support_value, otherSupportValue, 20);

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			ExplicitWait.visibleElement(driver, add_other_support_button, 30);

			jse.executeScript("arguments[0].click();", add_other_support_button);

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);

		}

		Thread.sleep(3000);

		// Deleting other support

		Click.on(driver, delete_other_support, 20);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);
		Click.on(driver, delete_other_support, 20);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);

		// reading OTR_for_calculation value from screen

		ExplicitWait.visibleElement(driver, on_road_price_for_calculation, 30);

		double onRoadPriceForCalculationActual = Double
				.parseDouble(RemoveComma.of(on_road_price_for_calculation.getText().trim().substring(2)));

		double otherSupportConverted = Double.parseDouble(otherSupportValue);

		// writing other support values to Excel

		obj_read_excel_calculation_hire = new ReadExcelCalculation();

		double OTRValueExpected = obj_read_excel_calculation_hire
				.verify_OTR_for_calculation_after_adding_other_support_values_to_excel(otherSupportConverted,
						sheet_name);

		ExplicitWait.visibleElement(driver, acq_contractTypes_OTR_price, 30);
		double onRoadPriceorInvoice = Double
				.parseDouble(RemoveComma.of(acq_contractTypes_OTR_price.getText().trim().substring(2)));

		System.out.println("");

		boolean status = false;

		if (Difference.of_two_Double_Values(OTRValueExpected, onRoadPriceForCalculationActual) < 0.2) {
			status = true;

			LO.print("OTR price for calculation after adding other support found OK");
			System.out.println("OTR price for calculation after adding other support found OK");
		}

		else {
			LO.print("OTR price for calculation after adding other support found wrong");
			System.err.println("OTR price for calculation after adding other support found wrong");

		}

		System.out.println("");

		LO.print("Verification of OTR price for calculation after adding other support value has been ended");
		System.out.println("Verification of OTR price for calculation after adding other support value has been ended");

		return status;

	}

}
