/**
 * Created by aman on 7/9/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtonChange{
    JFrame frame;
    JButton labelButton;
    JButton colorButton;
    JLabel label;

    public static void main(String args[]){
        TwoButtonChange gui = new TwoButtonChange();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        colorButton = new JButton("Change Colour");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("Ouch");
        }
    }

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }
}

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        int red = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);

        Color randomColor = new Color(red, blue, green);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);
    }
}
