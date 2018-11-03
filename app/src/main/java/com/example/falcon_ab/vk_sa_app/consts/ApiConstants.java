package com.example.falcon_ab.vk_sa_app.consts;


import com.vk.sdk.VKScope;

public class ApiConstants {
    public static final String[] DEFAULT_LOGIN_SCOPE = {VKScope.AUDIO, VKScope.DIRECT, VKScope.VIDEO,
            VKScope.WALL, VKScope.MESSAGES, VKScope.PHOTOS, VKScope.PAGES, VKScope.GROUPS, VKScope.EMAIL,
            VKScope.STATS, VKScope.DOCS};
    public static final Double DEFAULT_VERSION = 5.67;
    public static final int DEFAULT_COUNT = 10;
    public  static final String DEFAULT_USER_FIELDS = "photo_100";
    public static final String DEFAULT_MEMBER_FIELDS = "name,photo_100";
    public static final int MY_GROUP_ID = -86529522;
    public static final String DEFAULT_GROUP_FIELDS = "status,description,site,links,contacts";
    public static final String VIDEOS = "videos";
    public static final String POSTS = "posts";
    public static final String EXTENDED = "extended";
}
