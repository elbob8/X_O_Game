
package x_o;

/**
 *
 * @author Elbob
 */

import Tools.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.WindowConstants.*;


public class Start_Game extends JFrame{
    JPanel home;
    JLabel title;
    JButton button_multi,button_single,button_out,button_about;
    
    public Start_Game(){
        
        setTitle("X_O");
        try {
            setIconImage(ImageIO.read(this.getClass().getResource("/Tools/images/smiling.png")));
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(rootPane, "icon app not found");
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
            
            title = new JLabel("X _ O");
            title.setForeground(Color.GREEN);
            title.setFont(new Font("Ink Free",Font.BOLD,50));
            title.setBounds(400, 10, 200, 50);
            title.setHorizontalAlignment(JLabel.CENTER);
            home.add(title);
            
            button_multi = new MyButton("MultiPlayer");
            button_multi.setBounds(400, 100, 200, 50);
            button_multi.setToolTipText("One VS One");
            button_multi.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game_Pane gp = new Game_Pane();
                gp.Choose = true;
                dispose();
            }
            });
            home.add(button_multi,BorderLayout.CENTER);
            
            button_single = new MyButton("SinglePlayer");
            button_single.setBounds(400, 170, 200, 50);
            button_single.setToolTipText("One VS Computer");
            button_single.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game_Pane gp = new Game_Pane();
                gp.Choose = false;
                gp.is_Com = true;
                dispose();
            }
            });
            home.add(button_single,BorderLayout.CENTER);
            
            
            button_about = new MyButton("about");
            button_about.setBounds(400, 240, 200, 50);
            button_about.setToolTipText("Information From Game");
            button_about.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new About_Game();
            }
            });
            home.add(button_about,BorderLayout.CENTER);
            
            button_out = new MyButton("Exit");
            button_out.setBounds(400, 310, 200, 50);
            button_out.setToolTipText("Exit in Game");
            button_out.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            });
            home.add(button_out,BorderLayout.CENTER);
            
    }
    public static void main(String[] args) {
        new Start_Game();
    }
}
