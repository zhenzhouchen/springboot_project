package com.cskaoyan.sb.springboot_project.realm;

import com.cskaoyan.sb.springboot_project.mapper.UserMapper;
import com.cskaoyan.sb.springboot_project.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WxRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        String password = userMapper.queryPasswordByName(username);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "wxRealm");
        return authenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principalCollection.getPrimaryPrincipal();
        //authorizationInfo.addStringPermission("hello");
        List<String> permissions = userMapper.queryPermissionsByName(username);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;*/
        return null;
    }

    public void clearCache(){
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }


}
