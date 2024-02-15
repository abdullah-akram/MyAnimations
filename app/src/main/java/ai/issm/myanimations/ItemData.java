package ai.issm.myanimations;

import android.net.Uri;

public class ItemData {
    private String imageUri;

    public ItemData(String url) {
        this.imageUri = url;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
