package com.mg.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	@Override
	public Object run() throws ZuulException {

		logger.info("*************##############******** printing logs : ");
		System.out.println("from runing.........................");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("retuting from the.....filter should.....");
		return true;
	}

	@Override
	public int filterOrder() {
		System.out.println("retuting from the.....filter order.....");
		return 1;
	}

	@Override
	public String filterType() {
		System.out.println("retuting from the.....filter type.....");
		return "pre"; // 3 types re vailable - pre - to execute before processing the request, post- after processing the req and error
	}
}