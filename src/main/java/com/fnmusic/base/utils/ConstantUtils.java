package com.fnmusic.base.utils;

public class ConstantUtils {

    public static final String APPNAME = "fnmusic";
    public static final String[] ACTIONS = new String[] {
            "CREATE_USER",
            "LOGGED_IN",
            "FORGOT_PASSWORD",
            "RESET_PASSWORD",
            "ACCOUNT_ACTIVATION"
    };

    public static final String MAILSENDER = "no-reply@fnmusic.com";
    public static final String[] MAIL_TEMPLATE_NAMES = new String[] {
            "ACCOUNT_ACTIVATION",
            "PASSWORD_RESET"
    };

    public static final String WEBURL = "https://localhost:5001";
    public static final String PHOTO_STORAGE_PATH = "D:/Photos/";
}
