package com.weyon.security.aspect;

import com.weyon.framework.model.BaseEntity;
import com.weyon.security.model.MyUser;
import com.weyon.security.service.JwtTokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxu
 * @description 添加数据时添加创建人信息
 * @date 2019-06-10
 **/
@Component
@Aspect
@Slf4j
public class AutoSetAspect {

    @Autowired
    private JwtTokenService jwtTokenService;

    /**
     * 表示匹配带有自定义注解的方法
     */
    @Pointcut("execution(* com.weyon.common.model.IService.save*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void  before(JoinPoint joinPoint) {
        Object[] objArr = joinPoint.getArgs();
        MyUser myUser = jwtTokenService.getAuthentication();
        if (myUser != null) {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setCreatorId(myUser.getId());
            baseEntity.setCreator(myUser.getUsername());
            baseEntity.setOrgId(myUser.getOrganizationId());
            baseEntity.setOrgName(myUser.getOrgName());
            BeanUtils.copyProperties(baseEntity, objArr[0]);
        }
    }
}
