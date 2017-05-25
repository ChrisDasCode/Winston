package dascode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 5/3/2017.
 */
public class CamStorage {

    private List<Camera> cams = new ArrayList<>();

    public CamStorage() {

    }

    public CamStorage(List<Camera> cams) {
        this.cams = cams;
    }

    public void addCamera(Camera cam) {
        cams.add(cam);
    }

    public void removeCamera(Camera cam) {
        cams.remove(cam);

    }

    public void removeAllCams() {
        cams.clear();
    }

    public List<Camera> getCams() {
        return cams;
    }
}
