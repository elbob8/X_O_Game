
package x_o;

/**
 *
 * @author Elbob
 */

import Tools.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.WindowConstants.*;


public final class Game_Pane extends JFrame implements ActionListener{
    
    JPanel pnl_title,pnl_game;
    JLabel title;
    JButton button[] = new JButton[9];
    JButton button_back,button_newgame;
    boolean First_Player,Choose,is_Com,com_win = false;
    Random com = new Random();
    private int i_com;
    
    public Game_Pane(){
            setTitle("X_O");
        try {
            setIconImage(ImageIO.read(this.getClass().getResource("/Tools/images/smiling.png")));
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(rootPane, ex);
         }
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setSize(1000, 500);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);
            setVisible(true);
            
            pnl_title = new JPanel();
            pnl_title.setBounds(0, 0, getWidth(), 100);
            pnl_title.setBackground(Color.BLACK);
            pnl_title.setLayout(new BorderLayout());
            add(pnl_title,BorderLayout.NORTH);
            
            button_back = new MyButton("back");
            button_back.setBounds(50, 5, 200, 50);
            button_back.setToolTipText("Back to Home");
            button_back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Start_Game();
            }
            });
            pnl_title.add(button_back,BorderLayout.CENTER);
            
            button_newgame = new MyButton("New Game");
            button_newgame.setBounds(720, 5, 200, 50);
            button_newgame.setToolTipText("New Game To Play!");
            
            button_newgame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game_Pane gp = new Game_Pane();
                if(Choose){  
                gp.Choose = true;
                dispose();
                
                }else{
                gp.Choose = false;
                gp.is_Com = true;
                dispose();
                
                }
                
            }
            });
            pnl_title.add(button_newgame,BorderLayout.CENTER);
            
            title = new JLabel("X_O");
            title.setForeground(Color.red);
            title.setFont(new Font("Ink Free",Font.BOLD,50));
            title.setHorizontalAlignment(JLabel.CENTER);
            pnl_title.add(title);
            
            
            pnl_game = new JPanel();
            pnl_game.setSize(getWidth(), getHeight());
            pnl_game.setLayout(new GridLayout(3,3));
            pnl_game.setBackground(Color.WHITE);
            add(pnl_game);
            
            
            for(int x =0; x < 9; x++){
                button[x] = new JButton("");
                button[x].setFont(new Font("Ink Free",Font.BOLD,50));
                button[x].setForeground(Color.WHITE);
                button[x].setBackground(Color.BLACK);
                button[x].setFocusable(false);
                button[x].addActionListener(this);
                pnl_game.add(button[x]);
            }
            
            frist();
    }
    public void frist(){
        First_Player = true;
        if(First_Player == true){
            title.setText("Player : X");
        }else{
            if(is_Com){
                title.setText("Computer : O");
            }else{
                title.setText("Player : O");
            }
        }
    }
    
    public void Xwins(int i,int v,int z){
        button[i].setBackground(Color.GREEN);
        button[v].setBackground(Color.GREEN);
        button[z].setBackground(Color.GREEN);
        com_win = true;
        for(int x=0; x < 9;x++){
            button[x].setEnabled(false);
        }
        title.setText("Player : X : Win");
    }
    public void Owins(int i,int v,int z){
        button[i].setBackground(Color.GREEN);
        button[v].setBackground(Color.GREEN);
        button[z].setBackground(Color.GREEN);
        for(int x=0; x < 9;x++){
            button[x].setEnabled(false);
        }
        if(is_Com){
            title.setText("Computer : O : Win");
        }else{
            title.setText("Player : O : Win");
        }
        
    }
    public void check(){
        ////////////////////// check X ///////////////////////
        if(
            button[0].getText() == "X"&&
            button[1].getText() == "X"&&
            button[2].getText() == "X"
             ){
            Xwins(0, 1, 2);
        }
        if(
            button[3].getText() == "X"&&
            button[4].getText() == "X"&&
            button[5].getText() == "X" 
             ){
            Xwins(3, 4, 5);
        }
        if(
            button[6].getText() == "X"&&
            button[7].getText() == "X"&&
            button[8].getText() == "X" 
             ){
            Xwins(6, 7, 8);
        }
        if(
            button[0].getText() == "X"&&
            button[3].getText() == "X"&&
            button[6].getText() == "X" 
             ){
            Xwins(0, 3, 6);
        }
        if(
            button[1].getText() == "X"&&
            button[4].getText() == "X"&&
            button[7].getText() == "X" 
             ){
            Xwins(1, 4, 7);
        }
        if(
            button[2].getText() == "X"&&
            button[5].getText() == "X"&&
            button[8].getText() == "X" 
             ){
            Xwins(2, 5, 8);
        }
        if(
            button[0].getText() == "X"&&
            button[4].getText() == "X"&&
            button[8].getText() == "X" 
             ){
            Xwins(0, 4, 8);
        }
        if(
            button[2].getText() == "X"&&
            button[4].getText() == "X"&&
            button[6].getText() == "X" 
             ){
            Xwins(2, 4, 6);
        }
        ////////////////////// check O ///////////////////////
                if(
            button[0].getText() == "O"&&
            button[1].getText() == "O"&&
            button[2].getText() == "O"
             ){
            Owins(0, 1, 2);
        }
        if(
            button[3].getText() == "O"&&
            button[4].getText() == "O"&&
            button[5].getText() == "O" 
             ){
            Owins(3, 4, 5);
        }
        if(
            button[6].getText() == "O"&&
            button[7].getText() == "O"&&
            button[8].getText() == "O" 
             ){
            Owins(6, 7, 8);
        }
        if(
            button[0].getText() == "O"&&
            button[3].getText() == "O"&&
            button[6].getText() == "O" 
             ){
            Owins(0, 3, 6);
        }
        if(
            button[1].getText() == "O"&&
            button[4].getText() == "O"&&
            button[7].getText() == "O" 
             ){
            Owins(1, 4, 7);
        }
        if(
            button[2].getText() == "O"&&
            button[5].getText() == "O"&&
            button[8].getText() == "O" 
             ){
            Owins(2, 5, 8);
        }
        if(
            button[0].getText() == "O"&&
            button[4].getText() == "O"&&
            button[8].getText() == "O" 
             ){
            Owins(0, 4, 8);
        }
        if(
            button[2].getText() == "O"&&
            button[4].getText() == "O"&&
            button[6].getText() == "O" 
             ){
            Owins(2, 4, 6);
        }    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            for(int x =0; x < 9; x++){
                
                if(e.getSource() == button[x]){
                    
                    if(First_Player){
                        
                        if(button[x].getText()==""){
                            button[x].setText("X");
                            First_Player = false;
                            title.setText("Player : O");
                            check();
                        }
                    }else{
                    if(Choose == true){
                    if(button[x].getText()==""){
                    button[x].setText("O");
                    First_Player = true;
                    title.setText("Player : X");
                    check();
                    }
                }
            }  
        }
                
        if(Choose == false){
        if(com_win == true){
            
        }else{
            
          if(First_Player == false){
            for(int i = 0; i < 9; i++){
                
                i_com = com.nextInt(9);
            if(button[i_com].getText()==""){
                 button[i_com].setText("O");
                 First_Player = true;
                 title.setText("Player : X");
                 check();
                 break;
                                    
                            }
                        }
                    }               
                }
            }  
        }     
    }
}
