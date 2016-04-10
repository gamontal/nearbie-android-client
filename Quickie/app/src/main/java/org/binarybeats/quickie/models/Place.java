package org.binarybeats.quickie.models;

/**
 * Created by Leamsy on 4/6/2016.
 */
public class Place {

    private String placeImage;
    private String placeName;

    public Place() {
    }

    public Place(String placeImage, String placeName) {
        this.placeImage = placeImage;
        this.placeName = placeName;
    }

    public String getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(String placeImage) {
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
