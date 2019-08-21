package com.cskaoyan.sb.springboot_project.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

public class CustomAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        this.assertRealmsConfigured();
        Collection<Realm> realms = this.getRealms();
        MallToken token = (MallToken) authenticationToken;
        String type = token.getType();
        ArrayList<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().toLowerCase().contains(type)){
                typeRealms.add(realm);
            }
        }



        return realms.size() == 1 ? this.doSingleRealmAuthentication((Realm)typeRealms.iterator().next(), token) : this.doMultiRealmAuthentication(typeRealms, token);
    }
}
