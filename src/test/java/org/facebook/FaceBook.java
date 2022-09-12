package org.facebook;

//TestNg FrameWork
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {
	@AfterSuite
	private void s1() {
		System.out.println("S1");

	}

	@AfterTest

	private void s2() {
		System.out.println("S2");

	}

	@AfterClass
	private void s3() {
		System.out.println("S3");

	}

	@AfterMethod
	private void s4() {
		System.out.println("S4");

	}

	@Test
	private void s5() {
		System.out.println("S5");
	}

	@BeforeMethod
	private void s6() {
		System.out.println("S6");
	}

	@BeforeClass
	private void s7() {
		System.out.println("S7");

	}

	@BeforeTest
	private void s8() {
		System.out.println("S8");

	}

	@BeforeSuite
	private void s9() throws IOException {
		System.out.println("S9");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = (WebDriver) new FirefoxBinary();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\TestNgClass\\Excel Data\\TestNg.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String stringCellValue = cell.getStringCellValue();
		WebElement eMail = driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
		eMail.sendKeys(stringCellValue);

		Row row2 = sheet.getRow(2);
		Cell cell2 = row2.getCell(1);
		String stringCellValue2 = cell2.getStringCellValue();
		WebElement passWord = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
		passWord.sendKeys(stringCellValue2);

		WebElement login = driver.findElement(By.name("login"));
		login.click();

	}

}