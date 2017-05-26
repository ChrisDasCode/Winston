package dascode.gui;

import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.ds.ipcam.IpCamMode;
import dascode.CamStorage;
import dascode.Camera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by Chris on 5/3/2017.
 */
public class Main extends JFrame implements ActionListener, MouseListener {
    private static CamStorage cs;
    JMenuBar menuBar;
    JMenu newmen;
    JMenuItem menuadd;
    JLabel edit, trash;
    String camToRemove;
    ImageIcon tIco, eIco;
    private Dimension WIN_SIZE = new Dimension(250, 250);
    private String WIN_TITLE = "Winston";
    private WebcamPanel.Painter painter = null;
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

        // Add menu items
        menuadd = new JMenuItem("Add camera!");
        //set action listener
        menuadd.addActionListener(this);
        // Add to jFrame
        newmen.add(menuadd);

        menuBar.add(newmen);
        //Build jFrame
        setJMenuBar(menuBar);
        setTitle(WIN_TITLE);
        setSize(WIN_SIZE);
        setLayout(new GridLayout(0, 3, 1, 1));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void buildPanels() {
        //Build all webcams here
        cs = new CamStorage();
        Camera testCam = new Camera("yard", "http://192.168.1.108/IMAGE.JPG", IpCamMode.PULL,
                "test", "test");//TODO: remove test
        Camera testCam1 = new Camera("house", "http://192.168.1.108/IMAGE.JPG", IpCamMode.PULL,
                "test", "test");//TODO: remove test
        Camera testCam2 = new Camera("door", "http://192.168.1.108/IMAGE.JPG", IpCamMode.PULL,
                "test", "test");//TODO: remove test
        Camera testCam3 = new Camera("cat", "http://192.168.1.108/IMAGE.JPG", IpCamMode.PULL,
                "test", "test");//TODO: remove test
        cs.addCamera(testCam);
        cs.addCamera(testCam1);
        cs.addCamera(testCam2);
        cs.addCamera(testCam3);
        //Testing

        if (cs.getCams().isEmpty()) {
            return;
        }

        for (Camera c : cs.getCams()) {

            WebcamPanel panel = new WebcamPanel(Camera.getCamByName(c.getCameraName()));

            panel.setSize(new Dimension(400, 240));
            panel.setFPSLimited(true);
            panel.setFPSLimit(0.2); // 0.2 FPS = 1 frame per 5 seconds
            panel.setBorder(BorderFactory.createEmptyBorder());
            panel.setFPSDisplayed(true);
            JLabel name = new JLabel(c.getCameraName());
            edit = new JLabel();
            trash = new JLabel();
            eIco = new ImageIcon("edit.png", "edit-" + c.getCameraName());
            tIco = new ImageIcon("trash.png", "remove-" + c.getCameraName());
            edit.setName("edit-" + c.getCameraName());
            edit.setIcon(eIco);
            trash.setName("trash-" + c.getCameraName());
            trash.setIcon(tIco);
            edit.addMouseListener(this);
            trash.addMouseListener(this);
            name.setForeground(Color.RED);
            panel.add(name);
            panel.add(edit);
            JLabel spacer = new JLabel(" ");
            panel.add(spacer);
            panel.add(trash);
            add(panel);
        }
        setSize(WIN_SIZE);
        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        // Testing code
        Camera testCam;
        if (e.getSource() == menuadd) {

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel l = (JLabel) e.getSource();
        if (l.getName().contains("trash")) {

            String cameraName = l.getName().split("-")[1];
            System.out.println(cameraName);
            cs.removeCamera(cs.getCamByName(cameraName));
            System.out.println("trash");
        } else if (l.getName().contains("edit")) {
            String cameraName = l.getName().split("-")[1];
            System.out.println(cameraName);
            System.out.println("edit");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
