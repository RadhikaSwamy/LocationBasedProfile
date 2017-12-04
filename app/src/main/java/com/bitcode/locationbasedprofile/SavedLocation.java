package com.bitcode.locationbasedprofile;

import java.io.Serializable;

/**
 * Created by root on 2/12/17.
 */

public class SavedLocation implements Serializable {

    String LocationName, ProfileName;

    public SavedLocation(String locationName, String profileName) {
        LocationName = locationName;
        ProfileName = profileName;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String profileName) {
        ProfileName = profileName;
    }
}
