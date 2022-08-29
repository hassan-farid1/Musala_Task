package test_Package;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import data_Providers.Excel_Reader;
import pages.CareersPage;
import pages.CompanyPage;
import pages.ContactUsPage;
import pages.FacebookPage;
import pages.HomePage;
import setup.TestBase;


 

public class TestClass extends TestBase {

	HomePage homepage_obj;
	CareersPage careerspage_obj;
	CompanyPage companypage_obj;
	ContactUsPage contactus_obj;
	FacebookPage facebook_obj;
	
	@DataProvider(name="Data")
	public Object[][] userRegisterData() throws IOException
	{
		Excel_Reader ER = new Excel_Reader();
		return ER.getExcelData();
	}


	@Test (dataProvider = "Data" , description = "Invalid Email address format validation msg") 
	public void TestCase1(String name, String mail, String mobile , String subject, String Msg , String errorMsg) {
		homepage_obj = new HomePage();
		contactus_obj = new ContactUsPage();

		homepage_obj.click_ContactUS();
		contactus_obj.contact_US(name, mail, mobile, subject, Msg);
		assertEquals(contactus_obj.assert_invalidemail_message(), errorMsg);
	}

	@Test
	public void TestCase2() {
		companypage_obj = new CompanyPage();
		// company.companyTest();

		facebook_obj = new FacebookPage();

		companypage_obj.click_Company();
		getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		assertEquals(getDriverInstance().getCurrentUrl(), pro.getProperty("company_url"));
		System.out.println(getDriverInstance().getCurrentUrl());

		assertEquals(companypage_obj.assert_LeaderShip_text(), "Leadership");

		companypage_obj.click_Facebook();

		getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		assertEquals(facebook_obj.assert_FBPage_url(), pro.getProperty("fb_url"));

		System.out.println(facebook_obj.assert_FBPage_url());

	}

	@Test
	public void TestCase3() {
		careerspage_obj = new CareersPage();

		careerspage_obj.click_careers();

		careerspage_obj.click_openPositions();
		getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		assertEquals(getDriverInstance().getCurrentUrl(), pro.getProperty("joinUs_url"));
		System.out.println(getDriverInstance().getCurrentUrl());

		careerspage_obj.select_Location("Anywhere");
		careerspage_obj.select_Job();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(careerspage_obj.assert_GeneralDesc_Displayed());
		softAssert.assertTrue(careerspage_obj.assert_Requirements_Displayed());
		softAssert.assertTrue(careerspage_obj.assert_Responsibilities_Displayed());
		softAssert.assertTrue(careerspage_obj.assert_WhatWeOffer_Displayed());

		softAssert.assertTrue(careerspage_obj.assert_applyBtn_isDisplayed());

		careerspage_obj.click_Apply();
		careerspage_obj.fill_Fields();
		careerspage_obj.click_Send();

		assertEquals(careerspage_obj.assert_invalid_message(), "The e-mail address entered is invalid.");

	}

	@Test
	public void TestCase4() throws InterruptedException {

		careerspage_obj = new CareersPage();
		careerspage_obj.click_careers();
		careerspage_obj.click_openPositions();

		careerspage_obj.select_Location("Sofia");
		careerspage_obj.get_AvailableJobsDetails();

		System.out.println("-----------------------------------------------");

		careerspage_obj.select_Location("Skopje");
		careerspage_obj.get_AvailableJobsDetails();
	}

}
