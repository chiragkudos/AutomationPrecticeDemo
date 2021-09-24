package com.CongaDemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CongaDemo.init.AbstractPage;
import com.utility.Common;

public class PrecticePage extends AbstractPage{

	public PrecticePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css="a.login")
	WebElement btnSignin;
	
	@FindBy (css="#email")
	WebElement inputUserName;
	
	@FindBy (css="#passwd")
	WebElement inputPassword;
	
	@FindBy (css="#SubmitLogin")
	WebElement btnLogin;

	public PrecticePage signIn(String userName, String password) {
		// TODO Auto-generated method stub
		Common.waitForElement(btnSignin, driver, MAX_WAIT);
		btnSignin.click();
		
		Common.waitForElement(inputUserName, driver, MAX_WAIT);
		inputUserName.sendKeys(userName);
		inputPassword.sendKeys(password);
		
		btnLogin.click();
		
		return new PrecticePage(driver);
	}
	
	@FindBy(css="a.logout")
	WebElement btnLogout;
	
	@FindBy(css="#block_top_menu>ul>li:nth-child(3)")
	WebElement btnT_Shirt;
	
	public PrecticePage clickTshirt()
	{
		Common.waitForElement(btnLogout, driver, MAX_WAIT);
		btnT_Shirt.click();
		return new  PrecticePage(driver);
	}
	
	@FindBy(css="div.product-container a.product-name")
	WebElement productName;

	public PrecticePage clickProduct() {
		// TODO Auto-generated method stub
		Common.waitForElement(productName, driver, MAX_WAIT);
		log("Prodct Name"+productName.getText());
		
		productName.click();
		return new PrecticePage(driver);
	}
	
	@FindBy(css="button.exclusive")
	WebElement btnAddToCart;

	public PrecticePage clickAddToCart() {
		// TODO Auto-generated method stub
		Common.waitForElement(btnAddToCart, driver, MAX_WAIT);
		btnAddToCart.click();
		return new PrecticePage(driver);
	}
	
	@FindBy(css="div.layer_cart_product>h2")
	WebElement success_message;

	public String getMessage() {
		// TODO Auto-generated method stub
		Common.waitForElement(success_message, driver, MAX_WAIT);
		log(success_message.getText());
		return success_message.getText();
	}
	
	@FindBy (css="a.button-medium")
	WebElement btnCheckOut;

	public PrecticePage clickCheckOut() {
		// TODO Auto-generated method stub
		btnCheckOut.click();
		return new PrecticePage(driver);
	}
	
	@FindBy(css="#cart_summary p.product-name")
	WebElement txtPrdName;

	public String getName() {
		// TODO Auto-generated method stub
		Common.waitForElement(txtPrdName, driver, MAX_WAIT);
		return txtPrdName.getText();
	}
	
	@FindBy(css="#cart_summary td.cart_description>small:nth-child(3)")
	WebElement productDesc;

	public String getColor() {
		// TODO Auto-generated method stub
		String str=productDesc.getText().split(",")[0].split(":")[1].trim();
		return str;
	}

	public String getProductSize() {
		// TODO Auto-generated method stub
		String str=productDesc.getText().split(",")[1].split(":")[1].trim();
		return str;
	}
	
	@FindBy(css="span[id*='total_product_price']")
	WebElement totalText;
	
	public String getTotal() {
		// TODO Auto-generated method stub
		return totalText.getText().substring(1);
	}
	
	@FindBy(css="input.cart_quantity_input.form-control.grey")
	WebElement txtQty;
	
	@FindBy(css="span[id*='product_price'] span.price")
	WebElement txtPrice;

	public String getCalculatedTotal() {
		// TODO Auto-generated method stub
		double qty= Double.valueOf(txtQty.getAttribute("value"));
		double price=Double.valueOf(txtPrice.getText().substring(1));
		log("Total Actual Amount :"+(qty*price));
		return String.valueOf(((qty*price)));
	}
}
