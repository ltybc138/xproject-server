package com.ltybc.xproject.server.utils;

public class Utils {
    public static String generateTag(String s) {
        // TODO transform it to functional style
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            ans.append(words[i]).append("-");
        }
        ans.append(words[words.length - 1]);
        return ans.toString();
    }
}
