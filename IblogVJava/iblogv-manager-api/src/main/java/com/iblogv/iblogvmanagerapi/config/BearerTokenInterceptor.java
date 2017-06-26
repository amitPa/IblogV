package com.iblogv.iblogvmanagerapi.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.serviceimpl.TokenServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BearerTokenInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	TokenServiceImpl tokenService;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object handler) throws IblogvException {

		log.debug("BearerTokenInterceptor preHandle");

		/*
		 * This is to allow option call.For options call is coming back as
		 * prefighthandler
		 */
		if (!(handler instanceof HandlerMethod)) {
			log.debug("Incoming request type is :" + httpServletRequest.getMethod());
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;

		BearerTokenRequired bearerTokenRequired = handlerMethod.getMethod().getAnnotation(BearerTokenRequired.class);

		/*
		 * If method is not annotated return true
		 */
		if (bearerTokenRequired == null) {
			return true;
		}

		/*
		 * Annotation found .Now check if token exists in handler
		 */
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		ResponseCode responseCode = null;
		if (!StringUtils.isEmpty(authorizationHeader)
				&& (authorizationHeader.toLowerCase().startsWith("Bearer".toLowerCase()))) {
			String accessToken = authorizationHeader.substring("Bearer".length()).trim();

			try {
				responseCode = tokenService.validateAccessToken(accessToken);
			} catch (Exception e) {
				throw new IblogvException("IM-404", "Access Token does not exists in Request header");
			}

			if (responseCode == null)
				return false;

			if ((responseCode != null) && ("200".equalsIgnoreCase(responseCode.getResponseCode())))
				return true;
		
			httpServletResponse.setStatus(404);
			throw new IblogvException("IM-404", "Please enter a valid token");
		}

		httpServletResponse.setStatus(401);
		throw new IblogvException("IM-401", "Please enter a valid token");
	}
}
