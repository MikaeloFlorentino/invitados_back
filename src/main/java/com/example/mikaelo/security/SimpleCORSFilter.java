package com.example.mikaelo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.mikaelo.util.Constantes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class SimpleCORSFilter implements Filter {

private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

	public SimpleCORSFilter() {
	    log.info(Constantes.CADENA_SIMPLE_CORS);
	}
	
	 @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader(Constantes.CADENA_HEADER_ALLOW_ORIGIN, Constantes.CADENA_HEADER_ALLOW_ORIGIN_VALUE);
        response.setHeader(Constantes.CADENA_HEADER_ALLOW_METODS, Constantes.CADENA_HEADER_ALLOW_METODS_VALUE);
        response.setHeader(Constantes.CADENA_HEADER_ALLOW_HEADERS,Constantes.CADENA_HEADER_ALLOW_HEADERS_VALUE);
        response.setHeader(Constantes.CADENA_HEADER_CONTENT_TYPE, Constantes.CADENA_HEADER_CONTENT_TYPE_VALUE);
        response.setHeader(Constantes.CADENA_HEADER_CACHE_CONTROL, Constantes.CADENA_HEADER_CACHE_CONTROL_VALUE);
        
    	
    	
        
        if (Constantes.CADENA_OPTIONS.equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }
	
	
	@Override
	public void init(FilterConfig filterConfig) {
	}
	
	@Override
	public void destroy() {
	}

}