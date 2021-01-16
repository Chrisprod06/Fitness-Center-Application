
package healthcenterapplication;

import javax.swing.JFrame;

public class HealthCenterApplication {

    public static void main(String[] args) {

        ApplicationFrame frame = new ApplicationFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.add(frame.getPanelCont());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
