package com.cskaoyan.sb.springboot_project.realm;

import com.cskaoyan.sb.springboot_project.mapper.AdminMapper;
import com.cskaoyan.sb.springboot_project.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    AdminService adminService;
    @Autowired
    AdminMapper adminMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = adminMapper.queryPasswordByName(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "customRealm");
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principalCollection.getPrimaryPrincipal();
        int[] rolesIds = adminService.queryRoleIds(username);
        List<String> permissions = adminService.queryPermissionsByRoleIds(rolesIds);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }
//
//    public void clearCache(){
//        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
//        super.clearCache(principals);
//    }


}
