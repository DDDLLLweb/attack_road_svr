package com.el.algorism;

/**
 * @author Danfeng
 * @since 2018/8/21
 */
public class StuEnum {
    private void calcByEnum(int iNUm, int iOff, float fPercent) {
        float fMinDiff = 1.0f,fTmp;
        int iReadNum = 300;
        for(int i=iNUm-iOff+1; i<iNUm+iOff;i++) {
            fTmp = Math.abs(Math.round(i*fPercent)/(float)i - fPercent);
            if(fTmp<fMinDiff) {
                fMinDiff=fTmp;
                iReadNum = i;
            }
        }
        int iJiuYe = Math.round(iReadNum*fPercent);
        System.out.println("通过枚举，计算出学生总人数是："+iReadNum);
        System.out.println("已就业学生人数："+iJiuYe);
    }

    public static void main(String[] args) {
        StuEnum stuEnum = new StuEnum();
        stuEnum.calcByEnum(300,20,0.8323f);
    }
}
