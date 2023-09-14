package com.trid.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer{

	int count=0;
	int retryMaxCount=4;
	public boolean retry(ITestResult result) {
		while(count<retryMaxCount) {
			count++;
			return true;
		}
		return false;
	}
	

}
