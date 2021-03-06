package com.dmd.mall.service;

import com.dmd.base.result.CommonResult;
import com.dmd.mall.model.domain.UmsMember;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 用户注册
     */
    @Transactional
    CommonResult register(String username, String password, String telephone, String authCode, HttpServletRequest request);

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone,HttpServletRequest request);

    /**
     * 修改密码
     */
    @Transactional
    CommonResult updatePassword(String telephone, String oldPassword,String newPassword,String confirmPassword);
    /**
     * 修改密码
     */
    @Transactional
    CommonResult findPassword(String telephone, String password,String confirmPassword, String authCode,HttpServletRequest request);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id, Integer integration);
    /**
     * 在手机号或邮箱登陆时，没有账号的话注册账号用的
     * */
    @Transactional
    UmsMember register(String username);

    /**
     * 修改个人资料
     * */
    CommonResult updatePersonalData(UmsMember umsMember);
}
