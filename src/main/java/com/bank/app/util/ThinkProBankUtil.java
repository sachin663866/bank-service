package com.bank.app.util;

import java.util.Random;

public class ThinkProBankUtil {
    private static final Random random = new Random();
    private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890";

    public static String getToken(int length) {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            token.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return token.toString();
    }

    public static String getUniqueId(String prefix, int length) {

        String prefixVal = "";
        double d;
        for (int i = 1; i <= length; i++) {
            d = Math.random() * 10;
            prefix = prefix + ((int) d);
            if (i % 4 == 0 && i != length) {
                prefixVal = prefix;
            }
        }

        return prefixVal;

    }

    public static int getUniqueIdInt(String prefix, int length) {

        String prefixVal = "";
        double d;
        for (int i = 1; i <= length; i++) {
            d = Math.random() * 10;
            prefix = prefix + ((int) d);
            if (i % 4 == 0 && i != length) {
                prefixVal = prefix;
            }
        }

        return Integer.parseInt(prefixVal);

    }
	
	  /*public static void main(String arg[]) {
	  
	  System.out.println(ThinkProBankUtil.getUniqueId("CST", 5));
	  System.out.println(ThinkProBankUtil.getUniqueId("ADD", 5));
	  System.out.println(ThinkProBankUtil.getUniqueId("BNK", 5));
	  System.out.println(ThinkProBankUtil.getUniqueId("BNK", 7));
	  System.out.println(ThinkProBankUtil.getUniqueId("", 10));
	  System.out.println(ThinkProBankUtil.getUniqueId("BRN", 5));
	  System.out.println(ThinkProBankUtil.getUniqueIdInt("", 8));
	  
	  
	  }*/

}
