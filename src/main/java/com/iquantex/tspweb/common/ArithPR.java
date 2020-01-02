package com.iquantex.tspweb.common;

import java.math.BigDecimal;

public class ArithPR {
    /**
     * �ṩ��ȷ�ӷ������add����
     * @param value1 ������
     * @param value2 ����
     * @return ���������ĺ�
     */
    public static double add(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.add(b2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ���������sub����
     * @param value1 ������
     * @param value2 ����
     * @return ���������Ĳ�
     */
    public static double sub(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ�˷������mul����
     * @param value1 ������
     * @param value2 ����
     * @return ���������Ļ�
     */
    public static double mul(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * �ṩ��ȷ�ĳ������㷽��div
     * @param value1 ������
     * @param value2 ����
     * @param scale ��ȷ��Χ
     * @return ������������
     * @throws IllegalAccessException
     */
    public static double div(double value1,double value2,int scale) throws IllegalAccessException{
        //�����ȷ��ΧС��0���׳��쳣��Ϣ
        if(scale<0){         
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();    
    }
}