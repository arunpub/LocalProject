/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.ResourcePath;

import java.io.File;

public class ResourcePath {
	public static final String USER_DIR=System.getProperty("user.dir")+File.separator;
	
	public static final String TEST_DATA_LOCATION=USER_DIR+"src\\main\\java\\com\\arun\\LocalProject\\TestData"+File.separator;
	
	public static final String TESTING_XLSX=TEST_DATA_LOCATION+"Testing.xlsx";
	
	public static final String USER_HOME_CONFIG_FILE=System.getProperty("user.dir")+File.separator+"ConfigFile"+File.separator;

	public static final String GENRAL_PROPERTIES=USER_HOME_CONFIG_FILE+"genral.properties";
	
	// Login Page confi properties path
	public static final String LOGIN_PAGE=USER_HOME_CONFIG_FILE+"LoginPage.properties";
	
	//Home Page config properties path
	public static final String HOME_PAGE=USER_HOME_CONFIG_FILE+"HomePage.properties";

	//Leads Page config properties path
	public static final String LEADS_PAGE=USER_HOME_CONFIG_FILE+"LeadsPage.properties";

	
	//Organization Page config properties path
	public static final String ORGANIZATION_PAGE=USER_HOME_CONFIG_FILE+"OrganizationPage.properties";
}
