package com.ltybc.xproject.server.utils;

public class Utils {
    public static String generateTag(String s) {
        // TODO transform it to functional style
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        String ans = "";
        for (int i = 0; i < words.length - 1; i++) {
            ans += words[i] + "-";
        }
        ans += words[words.length - 1];
        return ans;
    }
}
