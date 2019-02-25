package com.el.designPatterns.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Danfeng
 * @since 2019/1/6
 */
public class Vacation {
    private ArrayList<VacationDay> vacationDays;
    private Date mDate;
    private int mDays = 0;
    private VacationDay vacationDay;

    public Vacation(String std) {
        vacationDays = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mDate = sdf.parse(std);
            vacationDay = new VacationDay(mDate);
            vacationDays.add(vacationDay);
            mDays++;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setMdate(String std) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse(std);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.mDate = parse;
    }

    public Date getMdate() {
        return mDate;
    }

    public void addDay() {
        vacationDay = new VacationDay(nextDate(mDays));
        vacationDays.add(vacationDay);
        mDays++;
    }

    public boolean setVacationDay(int i) {
        if (i > 0 && i < vacationDays.size()) {
            vacationDay = vacationDays.get(i);
            return true;
        }
        vacationDay = null;
        return false;
    }

    private Date nextDate(int next) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(mDate);
        cal.add(Calendar.DATE, next);
        return cal.getTime();
    }

}
