package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Session;
import view.Login;
import view.menuUtama;

public class AuthController {
    
    public AuthController(Login login, ModelLogin ML){
        login.getbtnLogin().addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                String username = login.get_username().getText();
                String password = login.get_password().getText();
                
                if(ML.isLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Berhasil Login cuy");
                    ML.setUserSession(username);
                    int user_id = Integer.parseInt(Session.get_id_user());
                    new menuUtama().show();
                    login.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Gagal Login cuy : Pastikan Username dan Password terisi dan benar");
                }
            }
        });
        
        login.getbtnRegister().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = login.get_username().getText();
                String password = login.get_password().getText();

                if(ML.isRegister(username, password)){
                    System.out.println("yey");
                    JOptionPane.showMessageDialog(null, "Berhasil register");

                }
                else {
                    JOptionPane.showMessageDialog(null, "Register gagal");
                }
            }
        });

    }
        
}

