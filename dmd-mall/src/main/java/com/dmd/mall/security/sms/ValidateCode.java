package com.dmd.mall.security.sms;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ValidateCode implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1588203828504660915L;

    private String code;

    //过期时间点
    private LocalDateTime expireTime;

    public ValidateCode(String code, long expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

}
