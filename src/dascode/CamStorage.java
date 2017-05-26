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

    public Camera getCamByName(String name) {
        for (Object cam : cams.toArray()) {
            if (cam.equals(name)) {
                return (Camera) cam;
            }
        }

        return null;
    }
    public void addCamera(Camera cam) {
        cams.add(cam);
    }

    public void removeCamera(Camera cam) {
        cams.remove(cam);
        Camera.Remove(cam);

    }

    public void removeAllCams() {
        cams.clear();
    }

    public List<Camera> getCams() {
        return cams;
    }
}
