package com.nhnent.nguest.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhnent.nguest.dao.GuestbookDao;
import com.nhnent.nguest.vo.GuestbookVO;

@Aspect
@Component
public class RequiredAuthorityAspect {
	@Autowired(required = true)
	private HttpServletRequest request;
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	@Pointcut("@annotation(com.nhnent.nguest.aspect.RequiredAuthority)")
	private void authorityRequired() {
	}
	
	@Around(value = "authorityRequired()")
	public Object throwExceptionIfCurrentUserIsNotAdmin(ProceedingJoinPoint joinPoint, GuestbookVO guestbookVo) throws Throwable {
		int result = guestbookDao.selectOne(guestbookVo);
		
		if (result == 0) {
			throw new Exception();
		}
		
		return joinPoint.proceed();
	}
}
