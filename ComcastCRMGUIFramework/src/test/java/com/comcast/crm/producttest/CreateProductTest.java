package com.comcast.crm.producttest;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelFileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewVendorPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.crm.objectrepositoryutility.SelectVendorPage;
import com.comcast.crm.objectrepositoryutility.VendorInfoPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

@Listeners(com.comcast.crm.generic.listeners.ListenersImpl.class)
public class CreateProductTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createProductTest() throws Exception {

		// Get data from Excel file
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String prodName = eUtil.getDataFromExcelFile("Products", 1, 1) + jUtil.getRandomNumber();

		// Object of POM Utilities
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		ProductInfoPage pip = new ProductInfoPage(driver);

		// 2. Click on Products.
		hp.getProductLink().click();

		// 3.Click on Create Product Lookup image.
		pp.getCreateProductBtn().click();

		// 4. Enter all the mandatory fields and click on Save button.
		cnpp.getProductNameEdt().sendKeys(prodName);
		cnpp.getSaveBtn().click();

		// 5. Verify that the product is created and the product name is displayed.
		String prodInfo = pip.getHeaderInfo().getText();
		boolean prodStatus = prodInfo.contains(prodName);
		Assert.assertEquals(prodStatus, true);
		UtilityClassObject.getTest().log(Status.INFO, "Product Created");
		
		String actProdName = pip.getProductNameInfo().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actProdName.trim(), prodName);

		// 6. Update the product Id in the Test Script Data.
		String prodId = pip.getProductIdInfo().getText();
		prodId = prodId.trim();

		// Write back to Excel File
		eUtil.setDataToExcel("Products", 1, 4, prodId);

	}

	@Test(groups = "regressionTest")
	public void createProductWithSalesDateTest() throws Exception {

		// Get the Date
		String currentDate = jUtil.getSystemDateYYYYMMDD();

		// End Date
		String endDate = jUtil.getRequiredDateYYYYMMDD(20);

		// Get data from Excel file
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String prodName = eUtil.getDataFromExcelFile("Products", 4, 1) + jUtil.getRandomNumber();

		// Object of POM Utilities
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		ProductInfoPage pip = new ProductInfoPage(driver);

		// 2. Click on Products.
		hp.getProductLink().click();

		// 3.Click on Create Product Lookup image.
		pp.getCreateProductBtn().click();

		// 4. Enter data and click on Save button.
		cnpp.getProductNameEdt().sendKeys(prodName);
		cnpp.getSalesStartDateEdt().sendKeys(currentDate);
		cnpp.getSalesEndDateEdt().sendKeys(endDate);
		cnpp.getSaveBtn().click();

		// 5. Verify that the product is created and the product name along with sales
		// start date and end date is displayed.
		String prodInfo = pip.getHeaderInfo().getText();
		boolean prodStatus = prodInfo.contains(prodName);
		Assert.assertEquals(prodStatus, true);
		UtilityClassObject.getTest().log(Status.INFO, "Product Created");
		
		
		String actProdName = pip.getProductNameInfo().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actProdName.trim(), prodName);

		String actStartDate = pip.getSalesStartDateInfo().getText();
		sa.assertEquals(actStartDate.trim(), currentDate);
		
		String actEndDate = pip.getSalesEndDateInfo().getText();
		sa.assertEquals(actEndDate.trim(), endDate);
		
		// 6. Update the product Id in the Test Script Data.
		String prodId = pip.getProductIdInfo().getText();
		prodId = prodId.trim();

		// Write back to Excel File
		eUtil.setDataToExcel("Products", 4, 4, prodId);
	}

	@Test(groups = "regressionTest")
	public void createProductWithVendor() throws Exception {

		// Get data from Excel file
		String prodName = eUtil.getDataFromExcelFile("Products", 7, 1) + jUtil.getRandomNumber();
		String vendorName = eUtil.getDataFromExcelFile("Products", 7, 2);

		// Object of POM Utilities
		HomePage hp = new HomePage(driver);
		VendorsPage vp = new VendorsPage(driver);
		CreatingNewVendorPage cnvp = new CreatingNewVendorPage(driver);
		VendorInfoPage vip = new VendorInfoPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		SelectVendorPage svp = new SelectVendorPage(driver);
		ProductInfoPage pip = new ProductInfoPage(driver);

		// Create Vendor
		String parentId = driver.getWindowHandle();
		hp.navigateToVendors(driver);
		vp.getCreateVendorBtn().click();
		cnvp.getVendorNameEdt().sendKeys(vendorName);
		cnvp.getSaveBtn().click();

		String vendorInfo = vip.getHeaderInfo().getText();
		boolean vendorStatus = vendorInfo.contains(vendorName);
		Assert.assertEquals(vendorStatus, true);
		UtilityClassObject.getTest().log(Status.INFO, "Vendor Created");

		// 2. Click on Products.
		hp.getProductLink().click();

		// 3.Click on Create Product Lookup image.
		pp.getCreateProductBtn().click();

		// 4. Enter product name, vendor name and click on save button.
		cnpp.getProductNameEdt().sendKeys(prodName);
		cnpp.getSelectVendorBtn().click();

		// Switch to vendors window
		Set<String> windowHandles = driver.getWindowHandles();
		for (String id : windowHandles) {
			driver.switchTo().window(id);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains("module=Vendors")) {
				break;
			}
		}

		svp.getSearchEdt().sendKeys(vendorName);
		svp.getSearchBtn().click();
		driver.findElement(By.linkText(vendorName)).click();

		// Switch to Parent window
		driver.switchTo().window(parentId);

		cnpp.getSaveBtn().click();

		// 5. Verify that the product is created and the product name along vendor name
		// is displayed.
		String prodInfo = pip.getHeaderInfo().getText();
		boolean prodStatus = prodInfo.contains(prodName);
		Assert.assertEquals(prodStatus, true);
		UtilityClassObject.getTest().log(Status.INFO, "Product Created");

		String actProdName = pip.getProductNameInfo().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actProdName.trim(), prodName);
		sa.assertAll();
		
		String actVendorName = pip.getVendorNameInfo().getText();
		sa.assertEquals(actVendorName.trim(), vendorName);
		sa.assertAll();

		// 6. Update the product Id in the Test Script Data.
		String prodId = pip.getProductIdInfo().getText();
		prodId = prodId.trim();

		// Write back to Excel File
		eUtil.setDataToExcel("Products", 7, 4, prodId);
	}
}
