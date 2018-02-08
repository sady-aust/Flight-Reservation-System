/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feeds;

/**
 *
 * @author User
 */
public class Feed {
    private int feedId;
    private int adminId;
    private String events ;
    private String date;

    public Feed(int feedId, int adminId, String events, String date) {
        this.feedId = feedId;
        this.adminId = adminId;
        this.events = events;
        this.date = date;
    }

    public Feed() {
    }

    public Feed(int adminId, String events, String date) {
        this.adminId = adminId;
        this.events = events;
        this.date = date;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
