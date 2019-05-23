package com.fnmusic.base.Utils;

import com.fnmusic.base.models.User;
import com.fnmusic.base.models.UserPrincipal;
import com.fnmusic.base.security.AccessTokenWithUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SystemUtils {

    public static User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        User currentUser = userPrincipal.getUser();

        return currentUser;
    }

    public static AccessTokenWithUserDetails getAccessTokenWithUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        AccessTokenWithUserDetails access = new AccessTokenWithUserDetails();
        User currentUser = userPrincipal.getUser();

        access.setAccessToken((String) auth.getDetails());
        access.setUser((User) auth.getPrincipal());
        access.setUsername(access.getUser().getEmail());

        return access;
    }

    public static String getAccessToken() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = (String) auth.getDetails();

        return accessToken;
    }
}
