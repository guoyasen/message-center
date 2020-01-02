package com.iquantex.tspweb.common;

import org.apache.commons.math3.util.Precision;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author shenzhengjie
 * @date 2019/1/18 16:41
 */
public class MathUtil {
    /**
     * “BP”后缀
     */
    private static final String BP_SUFFIX = "BP";

    /**
     * 增加BP后缀(* 100 +  “BP”)
     */
    public static String addSuffixBP100(String num) {
        try {
            return Precision.round(Double.valueOf(num) * 100, 2) + BP_SUFFIX;
        } catch (NumberFormatException e) {
            return "calcError";
        }
    }

    /**
     * 增加BP后缀(* 10000 +  “BP”)
     */
    public static String addSuffixBP(String num) {
        try {
            return Precision.round(Double.valueOf(num) * 10000, 2) + BP_SUFFIX;
        } catch (NumberFormatException e) {
            return "calcError";
        }
    }

    /**
     * 增加"%"后缀(* 100 + “%”)
     */
    public static String addSuffixPercent(String num) {
        if (num == null) {
            return "";
        }
        try {
            return Precision.round(Double.valueOf(num) * 100, 4) + "%";
        } catch (NumberFormatException e) {
            return "calcError";
        }
    }


    /**
     * 增加"%"后缀(* 100 + “%”),指定保留小数位数
     */
    public static String addSuffixPercent(String num, int scale) {
        if (num == null) {
            return "";
        }
        String pattern = "###0.";
        for (int i = 0; i < scale; i++) {
            pattern += "0";
        }
        try {
            DecimalFormat df = new DecimalFormat(pattern);
            return df.format(Double.parseDouble(num) * 100) + "%";
            //return Precision.round(Double.valueOf(num) * 100, scale) + "%";
        } catch (NumberFormatException e) {
            return "calcError";
        }
    }


    /**
     * 去掉科学计数法
     */
    public static String removeScientificNotation(String num) {
        Double d = new Double(num);
        java.text.NumberFormat NF = java.text.NumberFormat.getInstance();
        NF.setGroupingUsed(false);//去掉科学计数法显示
        return NF.format(d);
    }

    /**
     * 格式化数字为千分位显示；
     *
     * @param text 要格式化的数字；
     * @return
     */
    public static String fmtMicrometer(String text) {
        DecimalFormat df = null;
        if (text.indexOf(".") > 0) {
            if (text.length() - text.indexOf(".") - 1 == 0) {
                df = new DecimalFormat("###,##0.");
            } else if (text.length() - text.indexOf(".") - 1 == 1) {
                df = new DecimalFormat("###,##0.0");
            } else if (text.length() - text.indexOf(".") - 1 == 2) {
                df = new DecimalFormat("###,##0.00");
            } else if (text.length() - text.indexOf(".") - 1 == 3) {
                df = new DecimalFormat("###,##0.000");
            } else {
                df = new DecimalFormat("###,##0.0000");
            }
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }


    /**
     * 格式化数字为千分位显示，指定保留小数；
     *
     * @param text 要格式化的数字；
     * @return
     */
    public static String fmtMicrometer(String text, String digit) {
        DecimalFormat df = null;
        if (text.indexOf(".") > 0) {
            df = new DecimalFormat("###,##0." + digit);
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }


    /**
     * 格式化数字为千分位显示，不要小数；
     *
     * @param text 要格式化的数字；
     * @return
     */
    public static String fmtMicrometerNoDecimal(String text) {
        DecimalFormat df = null;
        df = new DecimalFormat("###,##0");
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }

    /**
     * 数字转换
     *
     * @param number 要转换的数字
     * @param unit   转换的单位如：百万、亿
     * @param digit  要保留的小数
     * @return
     */
    public static String fmtNumber(String number, Integer unit, Integer digit) {
        try {
            if (number == null)
                return "0";
            return String.valueOf(Precision.round(Double.valueOf(number) / unit, digit));
        } catch (NumberFormatException e) {
            return "0";
        }
    }

    /**
    *保留n位小数
    * */

    public void numberApproximation(int n, Double d) {
        BigDecimal bg = new BigDecimal(d);
        double f1 = bg.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }

}
