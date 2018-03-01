package com.mybatis.config;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {
    @Pointcut("execution(* com.mybatis.mapper..*.*(..))")
    public void dataSourcePointcut() {
    }

    @Around("dataSourcePointcut()")
    public Object doAround(ProceedingJoinPoint pjp) {
	MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
	Method method = methodSignature.getMethod();
	DataSourceTypeAnno typeAnno = method.getAnnotation(DataSourceTypeAnno.class);
	DataSourceEnum sourceEnum = typeAnno.value();

	if (sourceEnum == DataSourceEnum.primary) {
	    DataSourceContextHolder.setDataSourceType(DataSourceEnum.primary);
	} else if (sourceEnum == DataSourceEnum.secondary) {
	    DataSourceContextHolder.setDataSourceType(DataSourceEnum.secondary);
	}

	Object result = null;
	try {
	    result = pjp.proceed();
	} catch (Throwable throwable) {
	    throwable.printStackTrace();
	} finally {
	    DataSourceContextHolder.resetDataSourceType();
	}

	return result;
    }
}
