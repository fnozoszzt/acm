package leetcode;

import java.util.ArrayList;

public class _65 {

    public String[] split(String s, char c) {
        int start = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                arrayList.add(s.substring(start, i));
                start = i + 1;
            }

        }
        arrayList.add(s.substring(start));
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public boolean isDigit(String s){
        //System.out.println(s);
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (! (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public boolean isFloat(String s) {
        if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            s = s.substring(1);
        }
//        String[] s2 = s.split("\\.");
        String[] s2 = split(s, '.');
        if (s2.length == 1) {
            return isInteger(s2[0]);
        } else if (s2.length == 2) {
            if (s2[0].length() == 0) {
                return isDigit(s2[1]);
            }
            if (s2[1].length() == 0) {
                return isInteger(s2[0]);
            }
            return isInteger(s2[0]) && isDigit(s2[1]);
        } else {
            return false;
        }
    }

    public boolean isInteger(String s) {
        if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return false;
        }
//        if (s.charAt(0) == '0') {
//            if (s.length() == 1) {
//                return true;
//            }
//            return false;
//        }
        return isDigit(s);
    }

    public boolean isNumber(String s) {
        String[] s1 = split(s.trim(), 'e');
//        System.out.println(s);
//        System.out.println(s1.length);
//        System.out.println(s1[0]);
//        System.out.println(s1[1]);
        if (s1.length == 1) {
            return isFloat(s1[0]);
        } else if(s1.length == 2) {
            return isFloat(s1[0]) && isInteger(s1[1]);
        } else {
            return false;
        }
    }


    public static void main(String[] aaaa) {

//        System.out.println(new _65().isNumber("1"));
//        System.out.println(new _65().isNumber(" 0.1 "));
//        System.out.println(new _65().isNumber("abc"));
//        System.out.println(new _65().isNumber("1 a"));
//        System.out.println(new _65().isNumber("2e10"));
//        System.out.println(new _65().isNumber(" -90e3   "));
//        System.out.println(new _65().isNumber(" 1e"));
//        System.out.println(new _65().isNumber(".1"));
        System.out.println(new _65().isNumber("01"));
        System.out.println(new _65().isNumber("3."));
        System.out.println(new _65().isNumber("005047e+6"));
//        System.out.println(new _65().isNumber("e3"));
    }
}
