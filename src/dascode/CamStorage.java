package dascode;

import com.github.sarxos.webcam.ds.ipcam.IpCamAuth;
import com.github.sarxos.webcam.ds.ipcam.IpCamDeviceRegistry;

import java.net.MalformedURLException;
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
        try {
            IpCamDeviceRegistry.register(cam.getCameraName(), cam.getCameraUrl(), cam.getCamMode());
        } catch (MalformedURLException e) {
            e.printStackTrace(); //TODO: handel error
        }
    }

    public void addCamera(Camera cam, IpCamAuth auth) {
        cams.add(cam);

        try {
            IpCamDeviceRegistry.register(cam.getCameraName(), cam.getCameraUrl(), cam.getCamMode(), auth);
        } catch (MalformedURLException e) {
            e.printStackTrace(); //TODO: handel error
        }
    }

    public void removeCamera(Camera cam) {
        cams.remove(cam);
        IpCamDeviceRegistry.unregister(cam.getCameraName());
    }

    public void removeAllCams() {
        cams.clear();
        IpCamDeviceRegistry.unregisterAll();
    }

    public List<Camera> getCams() {
        return cams;
    }
}
