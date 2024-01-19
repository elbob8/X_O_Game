
package x_o;

/**
 *
 * @author Elbob
 */

import Tools.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;
import static javax.swing.WindowConstants.*;


public class About_Game extends JFrame{
    JPanel home;
    JLabel title;
    JButton button_back,button_out;
    
    public About_Game(){
        
        setTitle("X_O");
        try {
            setIconImage(ImageIO.read(this.getClass().getResource("/Tools/images/smiling.png")));
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(rootPane, ex);
         }
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setSize(1000, 500);
            setLayout(null);
            setLocationRelativeTo(null);
            setVisible(true);
            
            home = new JPanel();
            home.setSize(getWidth(), getHeight());
            home.setLayout(null);
            home.setBackground(Color.decode("#000000"));
            add(home);
            
            title = new JLabel("About");
            title.setForeground(Color.GREEN);
            title.setFont(new Font("Ink Free",Font.BOLD,50));
            title.setBounds(400, 10, 200, 50);
            title.setHorizontalAlignment(JLabel.CENTER);
            home.add(title);
            

            JPanel draw = new JPanel(){
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.CYAN);
                g2.setFont(new Font("Tahoma", Font.BOLD, 20));
                g2.drawString("Developed by @SaidSabrey", 30, 30);
                g2.drawString("' The Hands of the 8 write and do the impossible '", 60, 60);
                g2.drawString("' Enjoy this game and we hope to provide the best in the future '", 90, 90);
                g2.drawString("' CopyRight@2024 Octopus8.com '", 120, 120);
            } 
            };
            
            draw.setBounds(10, 100, getWidth(), 300);
            home.add(draw);
            
            button_back = new MyButton("back");
            button_back.setBounds(80, 380, 200, 50);
            button_back.setToolTipText("Back to Home");
            button_back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Start_Game();
            }
            });
            home.add(button_back,BorderLayout.CENTER);
            
            button_out = new MyButton("Exit");
            button_out.setBounds(690, 380, 200, 50);
            button_out.setToolTipText("Exit in Game");
            button_out.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            });
            home.add(button_out,BorderLayout.CENTER);
    }
}