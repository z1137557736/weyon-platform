package com.weyon.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxu
 * @description 扩展security默认的user类
 * @date 2019-05-21
 **/
@Data
public class MyUser implements UserDetails {

    private String id;

    private String selfId;

    private String username;

    private String password;

    private String salt;

    private Integer loginType;

    private String uniqueToken;

    private String realName;

    private String nickName;

    private String gender;

    private Date birthday;

    private String mobile;

    private String telephone;

    private String email;

    private String qq;

    private String wechat;

    private String identityCard;

    private Byte userType;

    private String openId;

    private String headUrl;

    private String locked;

    private String organizationId;

    private String loginIp;

    private Date loginTime;

    private Byte recordStatus;

    private String creatorId;

    private String creator;

    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    private List<MyPermission> permissions;

    private String uuid;

    /** 过期时间戳 */
    private Long expireTime;

    private String orgName;

    private static final long serialVersionUID = 9017384715574435412L;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p.getPermission()))
                .map(p -> new SimpleGrantedAuthority(p.getPermission())).collect(Collectors.toSet());
    }

    /**
     * 账户是否未过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !getLocked().equals(Status.LOCKED);
    }

    /**
     * 密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public interface Status {
        String VALID = "0";
        String LOCKED = "1";
    }
}
