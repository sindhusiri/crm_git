package com.crm.testscripts;

import java.io.IOException;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.services.Crmservice;
import com.crm.testdata.AccountsData;
import com.crm.testdata.CrmAccountData;
import com.crm.testdata.CrmTestData;
import com.crm.validators.CrmValidator;

public class AdmiTest2 {
	Crmservice cservice = new Crmservice();
	CrmValidator cvalidator = new CrmValidator();
	CrmAccountData cadata = null;
	List<AccountsData> crmaccountsdata = null;

	@BeforeClass
	public void init() throws InterruptedException {
		cadata = CrmTestData.accountTestData();
		crmaccountsdata = cadata.getCaccountdata();
		cservice.openCrmApplication();
		cservice.loginCrmApplication(crmaccountsdata.get(0).getUsername(), crmaccountsdata.get(0).getPassword());

	}
	//@Test(description = "Add fields to the accounts", priority = 0)
	public void testUsingSikuli() throws InterruptedException, FindFailed {
		
		cservice.navigateToAccountsDashboard().accountsAddField();
	
}
	@Test(description = "Creating contact using csv file", priority = 0)

	public void createContactusingcsvfile() throws FindFailed, InterruptedException, IOException{
		
		cservice.uploadContactcsvfile();
		//cservice.getCreatedContactDetails();
		
		cvalidator.validateDataFromCSV(cservice);
		
	}
	
	//@Test(description = "Creating leads using csv file", priority = 1)

    public void createLeadsusingcsvfile() throws FindFailed, InterruptedException, IOException{
		
		cservice.uploadLeadsCSVFile();
		//cservice.getCreatedLeadDetails();
		cvalidator.validateLeadFromCSV(cservice);
		
		
	}
	//@Test(description = "Creating Tasks using csv file", priority = 2)

	public void createTasksusingcsvfile() throws FindFailed, InterruptedException, IOException{
		cservice.uploadTaskCSVFile();
		//cservice.getCreatedLeadDetails();
		//cvalidator.validateDataFromCSV(cservice);
	}

}