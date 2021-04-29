package id.ac.umn.week11_32025;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId, id;
    private String title;

    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
