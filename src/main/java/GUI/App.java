package GUI;

import Data.*;
import com.jcraft.jsch.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class App {
    private JFrame window;
    JButton button;
    private JButton button1;
    private JPanel panel1;

    public App(){
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(400, 100);
        window.setTitle("Server Mod Downloader");
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout( new GridBagLayout() );

        button = new JButton("Actualizar mods");
        button.setFocusable(false);
        window.add(button, new GridBagConstraints());
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Download download = new Download();
                try {
                    download.DownloadController();
                } catch (JSchException ex) {
                    ex.printStackTrace();
                } catch (SftpException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        window.add(button);
    }
    public  void show(){
        window.setVisible(true);
    }
}
