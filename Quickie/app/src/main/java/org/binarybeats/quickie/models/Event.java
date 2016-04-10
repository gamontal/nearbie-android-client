package org.binarybeats.quickie.models;

/**
 * Created by Leamsy on 4/6/2016.
 */
public class Event {

    private String eventImage;
    private String eventName;
    private String eventUserCount;

    public Event() {
    }

    public Event(String eventImage, String eventName, String eventUserCount) {
        this.eventImage = eventImage;
        this.eventName = eventName;
        this.eventUserCount = eventUserCount;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventUserCount() {
        return eventUserCount;
    }

    public void setEventUserCount(String eventUserCount) {
        this.eventUserCount = eventUserCount;
    }
}
