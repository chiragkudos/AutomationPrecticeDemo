package com.CongaDemo.tests;

import org.testng.annotations.Test;

import com.CongaDemo.init.Constants;
import com.CongaDemo.init.Init;

import junit.framework.Assert;

public class PrecticeTest extends Init {

	@Test
	public void test_01() {
		
		log((steps++) + " : Sign in using the credentials.");
		precticePage.signIn(userName,password);
		
		log((steps++) + " : Select the category as T-Shirts.");
		precticePage.clickTshirt();
		
		log((steps++) + " : Click on the product: Faded Short Sleeve T-shirts.");
		precticePage.clickProduct();
		
		log((steps++) + " : Click on Add to Cart.");
		precticePage.clickAddToCart();
		
		Assert.assertEquals(precticePage.getMessage(), Constants.SUCCESS_MESSAGE);
		
		log((steps++) + " : Click on proceed to checkout.");
		precticePage.clickCheckOut();
		
		Assert.assertEquals(precticePage.getName(), Constants.PRODUCT_NAME);
		Assert.assertEquals(precticePage.getColor(), Constants.PRODUCT_COLOR);
		Assert.assertEquals(precticePage.getProductSize(), Constants.PRODUCT_SIZE);
		Assert.assertEquals(precticePage.getTotal(), precticePage.getCalculatedTotal());
	}
}
