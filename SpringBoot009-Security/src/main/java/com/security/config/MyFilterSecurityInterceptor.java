package com.security.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.security.service.CustomAccessDecisionManager;
import com.security.service.CustomInvocationSecurityMetadataSourceService;

@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{

  @Autowired
  private CustomInvocationSecurityMetadataSourceService mySecurityMetadataSource;

  @Autowired
  private CustomAccessDecisionManager myAccessDecisionManager;

  /**
   *  在WebSecurityConfig类中configureGlobal(AuthenticationManagerBuilder auth)已经创建
   */
  @Autowired
  private AuthenticationManager authenticationManager;
  /**
   *  被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
   *  被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
   */
  @PostConstruct
  public void init(){
      super.setAuthenticationManager(authenticationManager);
      super.setAccessDecisionManager(myAccessDecisionManager);
  }

  public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
      FilterInvocation filterInvocation = new FilterInvocation( request, response, chain );
      invoke(filterInvocation);
  }


  public Class<? extends Object> getSecureObjectClass(){
      return FilterInvocation.class;
  }


  public void invoke( FilterInvocation filterInvocation ) throws IOException, ServletException{
      System.out.println("MyFilterSecurityInterceptor --> invoke..........................");
      InterceptorStatusToken  token = super.beforeInvocation(filterInvocation);
      try{
          filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
      }finally{
          super.afterInvocation(token, null);
      }
  }


  @Override
  public SecurityMetadataSource obtainSecurityMetadataSource(){
      System.out.println("MyFilterSecurityInterceptor 中的 obtainSecurityMetadataSource（）方法");
      return this.mySecurityMetadataSource;
  }

  public void destroy(){
      System.out.println("filter===========================end");
  }
  public void init( FilterConfig filterconfig ) throws ServletException{
      System.out.println("filter===========================");
  }
}