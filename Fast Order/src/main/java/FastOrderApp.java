import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FastOrderApp {

    public static Local esteLocal;
    JPanel [] hola = new JPanel[2];

    public FastOrderApp(){

        esteLocal = new Local();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fast Order");
        frame.setSize(900,600);
        frame.getContentPane().setBackground(Color.gray);
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());


        /*
        JPanel panel = new JPanel();
        panel.setBounds(0,0,300,600);
        frame.add(panel);
        */


        /*
        frame.add(new MainPanel());
         */

        frame.add(new MenuPanel());

        frame.setVisible(true);
    }



    public static void main(String[] args) {
        new FastOrderApp();
    }
}
