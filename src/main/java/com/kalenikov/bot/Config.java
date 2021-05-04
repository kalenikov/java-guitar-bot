package com.kalenikov.bot;

public class Config {
    public static String TOKEN = "1709111694:AAHp2uGVEtUEJuMc77TrtcMO9FyXf7cTbdo";
    public static String USER = "antipyzh_bot";
    public static Long ADMIN_ID1 = 399848983L;
    public static Long ADMIN_ID2 = 1144283236L;
    public static String ADMIN_NAME = "sergey919";
    public static boolean isTest = true;

    public static String getChatId() {
        String TEST_TOXIC_CHAT_ID = "-1001423027798";
        String REAL_TOXIC_CHAT_ID = "-1001242057624";
        return Config.isTest ? TEST_TOXIC_CHAT_ID : REAL_TOXIC_CHAT_ID;
    }

    public static boolean isAdmin(Long id){
        return id.equals(ADMIN_ID1) || id.equals(ADMIN_ID2);
    }
}
