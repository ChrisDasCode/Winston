package dascode.gui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;
import dascode.CamStorage;
import dascode.Camera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chris on 5/3/2017.
 */
public class Main extends JFrame implements ActionListener {
    private static CamStorage cs;
    JMenuBar menuBar;
    JMenu newmen, modmen;
    JMenuItem menuadd, menumod;
    private Dimension WIN_SIZE = new Dimension(250, 250);
    private String WIN_TITLE = "Winston";

    public Main() {
        buildMain();
        buildPanels();
    }

    private void buildMain() {
        //Menubar
        menuBar = new JMenuBar();
        // New menu
        newmen = new JMenu(" New");
        newmen.getAccessibleContext().setAccessibleDescription("Add a new camera to monitor using Winston.");
        //modify menu
        modmen = new JMenu(" Modify");
        modmen.getAccessibleContext().setAccessibleDescription("Modify a camera .");
        // Add menu items
        menuadd = new JMenuItem("Add camera!");
        menumod = new JMenuItem("Modify a camera");
        //set action listener
        menumod.addActionListener(this);
        menuadd.addActionListener(this);
        // Add to jFrame
        newmen.add(menuadd);
        modmen.add(menumod);
        menuBar.add(newmen);
        menuBar.add(modmen);
        //Build jFrame
        setJMenuBar(menuBar);
        setTitle(WIN_TITLE);
        setSize(WIN_SIZE);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void buildPanels() {
        //Build all webcams here
        cs = new CamStorage();


    }

    public void actionPerformed(ActionEvent e) {
        // Testing code
        Camera testCam;
        if (e.getSource() == menuadd) {
            testCam = new Camera("yard", "http://192.168.1.108/IMAGE.JPG", IpCamMode.PULL,
                    "test", "test");//TODO: remove test
            cs.addCamera(testCam);
            System.out.println("Added");
        }
        if (e.getSource() == menumod) {
            Webcam cam = Camera.getCamByName("yard");
            WebcamPanel panel = new WebcamPanel(cam);
            panel.setFPSDisplayed(true);
            panel.setDisplayDebugInfo(true);
            panel.setImageSizeDisplayed(true);
            panel.setMirrored(false);
            add(panel);
            setSize(WIN_SIZE);
            System.out.println("Test");
        }

    }


}
