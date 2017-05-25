package dascode;/*
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.ds.ipcam.IpCamDriver;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.ds.ipcam.IpCamAuth;
import com.github.sarxos.webcam.ds.ipcam.IpCamDeviceRegistry;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;
import javax.swing.*;*/

import dascode.gui.Main;

/**
 * Created by Chris on 5/3/2017.
 */


public class Loader {

    static {
        // Webcam.setDriver(new IpCamDriver());
    }

    public static void main(String[] args) {
       /* String name = "Yardcam";
        String url = "http://192.168.1.100/IMAGE.JPG";

        IpCamMode mode = IpCamMode.PULL; // Setting the driver to grab image
        IpCamAuth auth = new IpCamAuth("test","test");

        IpCamDeviceRegistry.register(name,url,mode,auth);
        WebcamPanel panel = new WebcamPanel(Webcam.getWebcams().get(0));
        JFrame f = new JFrame(name);
        f.add(panel);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        new Main();
    }
}