package com.dmd.mall.security.sms;

import com.dmd.mall.model.domain.MemberDetails;
import com.dmd.mall.security.usesdetailsservice.MyUserDetailsService;
import com.dmd.mall.service.UmsMemberService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
    private MyUserDetailsService userDetailsService;
    private UmsMemberService umsMemberService;

    public UmsMemberService getUmsMemberService() {
        return umsMemberService;
    }

    public void setUmsMemberService(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    public MyUserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken smsToken=(SmsCodeAuthenticationToken)authentication;
        String type=smsToken.getType();
        userDetailsService.setType("smsCode");
        MemberDetails userDetails= (MemberDetails) userDetailsService.loadUserByUsername((String) smsToken.getPrincipal());
        SmsCodeAuthenticationToken smsCodeToken=new SmsCodeAuthenticationToken(userDetails,userDetails.getAuthorities());
        smsCodeToken.setDetails(smsToken.getDetails());
        return smsCodeToken;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
