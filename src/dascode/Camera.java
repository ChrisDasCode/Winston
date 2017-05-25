package dascode; /**
 * Created by Chris on 5/3/2017.
 */

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.ds.ipcam.IpCamAuth;
import com.github.sarxos.webcam.ds.ipcam.IpCamDeviceRegistry;
import com.github.sarxos.webcam.ds.ipcam.IpCamDriver;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;

import java.net.MalformedURLException;
import java.util.List;

public class Camera {
    static {
        Webcam.setDriver(new IpCamDriver());
    }

    IpCamMode camMode;
    private String cameraName, cameraUrl, userName, userPass;

    public Camera(String cameraName, String cameraUrl, IpCamMode cameraMode) {
        this.cameraName = cameraName;
        this.cameraUrl = cameraUrl;
        camMode = cameraMode;
        try {
            IpCamDeviceRegistry.register(this.cameraName, this.cameraUrl, this.camMode);
        } catch (MalformedURLException e) {
            e.printStackTrace(); //TODO: handel error
        }
    }

    public Camera(String cameraName, String cameraUrl, IpCamMode cameraMode, String userName, String userPass) {
        this.cameraName = cameraName;
        this.cameraUrl = cameraUrl;
        this.userName = userName;
        this.userPass = userPass;
        this.camMode = cameraMode;
        IpCamAuth auth = new IpCamAuth(this.userName, this.userPass);
        try {
            IpCamDeviceRegistry.register(this.cameraName, this.cameraUrl, this.camMode, auth);
        } catch (MalformedURLException e) {
            e.printStackTrace(); //TODO: handel error
        }
    }

    public static Webcam getCamByName(String name) {
        return Webcam.getWebcamByName(name);
    }

    public static List<Webcam> getAllCams() {
        return Webcam.getWebcams();
    }

    public static void Remove(Camera toRemove) {
        IpCamDeviceRegistry.unregister(toRemove.cameraName);
    }

    public static void RemoveAll() {
        IpCamDeviceRegistry.unregisterAll();
    }

    public IpCamMode getCamMode() {
        return camMode;
    }

    public void setCamMode(IpCamMode camMode) {
        this.camMode = camMode;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraUrl() {
        return cameraUrl;
    }

    public void setCameraUrl(String cameraUrl) {
        this.cameraUrl = cameraUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

}
