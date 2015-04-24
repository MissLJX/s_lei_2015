package com.sl.servlet.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IPFilter implements Filter {
	
	private static final String INIT_PARAM = "init_param";

	@Override
	public void destroy() {
		System.out.println("IPFilter is destroying");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ip = request.getRemoteAddr();
		System.out.println("IP:"+ip+";CurrentTime:"+new Date().toString());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String initParam = config.getInitParameter(INIT_PARAM);
		String filterName = config.getFilterName();
		System.out.println("filter name is "+filterName+",and init-param is "+initParam);
	}

}
