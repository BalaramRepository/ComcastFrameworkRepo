package com.comcast.crm.generic.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int i=0;
	int retryCount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(i<retryCount) {
			i++;
			return true;
		}
		return false;
	}

}
