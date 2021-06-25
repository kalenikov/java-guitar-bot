package com.kalenikov.bot;

public class Config {
    public static String TOKEN = "1495328041:AAGbne7q2SHaSl4Tdl2bcPVlkfAm8CBXRFw";
    public static String BOT_NAME = "guitar360_bot";
    public static Long ADMIN_ID = 399848983L;

    public static boolean isAdmin(Long id){
        return id.equals(ADMIN_ID);
    }
}
