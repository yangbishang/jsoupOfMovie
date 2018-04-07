package com.jsoup.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter {
    private FilterConfig filterConfig;
    private String encoding;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = this.filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getCharacterEncoding() == null){
            servletRequest.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        this.filterConfig = null;
    }
}
