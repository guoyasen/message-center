package com.iquantex.tspweb.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/*")
public class ParamFilter implements Filter{

    private static final Logger LOG= LoggerFactory.getLogger(ParamFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;

        RequestWrapper requestWrapper=new RequestWrapper(req);
        ResponseWrapper responseWrapper=new ResponseWrapper(res);

        String url=req.getRequestURI();
        String bodyParams=requestWrapper.getRequestParams();
        String method=req.getMethod();
        if(!"".equals(bodyParams)){
            LOG.info("当前请求为<{}>,请求URL为<{}>,body参数为<{}>",method,url,bodyParams);
        }else{
            LOG.info("当前请求为<{}>,请求URL为<{}>",method,url);
        }


        chain.doFilter(requestWrapper, responseWrapper);



        byte[] bytes=responseWrapper.getContent();
        if(bytes.length>0) {
            String resParams=new String(bytes,"utf-8");
            LOG.info("返回参数为<{}>",resParams);
        }else{
            LOG.info("该请求无返回值");
        }
        ServletOutputStream out = res.getOutputStream();
        out.write(bytes);
        out.flush();
    }

    @Override
    public void destroy() {

    }

  }
