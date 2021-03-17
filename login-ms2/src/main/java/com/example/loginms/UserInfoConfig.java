package com.example.loginms;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

//@Component
public class UserInfoConfig implements UserInfoRestTemplateFactory{

	@Override
	public OAuth2RestTemplate getUserInfoRestTemplate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Component
	public class ResServerConfig implements ResourceServerTokenServices{

		@Override
		public OAuth2Authentication loadAuthentication(String accessToken)
				throws AuthenticationException, InvalidTokenException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OAuth2AccessToken readAccessToken(String accessToken) {
			// TODO Auto-generated method stub
			return null;
		}

		

	}

}


