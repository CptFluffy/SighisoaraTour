package com.example.android.sighisoaratour;

public class Attraction {

    private int mImageResouceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAttractionTitle;

    private int mAttractionDetail;

    private int mAttractionDescription;

    private String mLatitude;

    private String mLongitude;

    //Constructor for the events list. Does not include map coordinates.
    public Attraction( int attractionTitle, int attractionDetail, int imageResourceId, int attractionDescription) {
        mImageResouceId = imageResourceId;
        mAttractionTitle = attractionTitle;
        mAttractionDetail = attractionDetail;
        mAttractionDescription = attractionDescription;
    }

    //A second constructor made for the attractions that have a physical location on the map.
    //This way an intent can be used to navigate to the desired location.
    public Attraction( int attractionTitle, int attractionDetail, int imageResourceId, int attractionDescription, String latitude, String longitude) {
        mImageResouceId = imageResourceId;
        mAttractionTitle = attractionTitle;
        mAttractionDetail = attractionDetail;
        mAttractionDescription = attractionDescription;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public int getImageResourceId(){
        return mImageResouceId;
    }

    public int getAttractionTitle(){
        return mAttractionTitle;
    }

    public int getAttractionDetail(){
        return mAttractionDetail;
    }

    public int getAttractionDescription() {
        return mAttractionDescription;
    }

    public boolean hasImage() {
        return mImageResouceId != NO_IMAGE_PROVIDED;
    }

    public  String getLatitude(){
        return mLatitude;
    }

    public String getLongitude(){
        return mLongitude;
    }
}
