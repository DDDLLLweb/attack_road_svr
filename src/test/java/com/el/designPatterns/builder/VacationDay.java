package com.el.designPatterns.builder;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Danfeng
 * @since 2019/1/6
 */
public class VacationDay {
    private Date mDate;
    private String mHotes;
    private ArrayList<String> mTickets = null;
    private ArrayList<String> mEvents = null;

    public VacationDay(Date date) {
        mDate = date;
        mTickets = new ArrayList<>();
        mEvents = new ArrayList<>();
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public void setmHotes(String hotes) {
        this.mHotes = hotes;
    }

    public void addTicket(String ticket) {
        mTickets.add(ticket);
    }

    public void addEvents(String event) {
        mEvents.add(event);
    }
}
