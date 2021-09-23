package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlineBanking {

//	@Test(priority=0)
//	public void Login(){
//
//	}
//	@Test(priority=1)
//	public void AccountEnquiry(){
//
//	}
//	@Test(priority=2)
//	public void Reporting(){
//
//	}
//	@Test(priority=3)
//	public void Logout(){
//
//	}



	//**********************************

	@BeforeMethod
	public void Login(){

	}
	@Test(priority=1)
	public void AccountEnquiry(){

	}
	@Test(priority=2)
	public void Reporting(){

	}
	@AfterMethod
	public void Logout(){

	}

	//**********************************

//	@BeforeMethod
//	public void Login(){
//
//	}
//	@Test(priority=1)
//	public void AccountEnquiry(){
//
//	}
//
//	@AfterMethod
//	public void Logout(){
//
//	}

	//**********************************

//	@BeforeClass
//	public void Login(){
//
//	}
//	@Test(priority=1)
//	public void AccountEnquiry(){
//
//	}
//
//	@Test(priority=2)
//	public void Reporting(){
//
//	}
//
//	@AfterClass
//	public void Logout(){
//
//	}
}
