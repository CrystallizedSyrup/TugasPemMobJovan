package id.ac.umn.uas32025;

import java.io.Serializable;

public class SumberLagu implements Serializable {
    private String uri, judul;

    public SumberLagu (String judul, String uri) {
        this.judul = judul;
        this.uri = uri;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getUri(){
        return this.uri;
    }
}
