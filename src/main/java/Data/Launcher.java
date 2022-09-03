package Data;

import GUI.*;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App app = new App();
                app.show();
            }
        });
    }
}
