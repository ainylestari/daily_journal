
package main;

import controller.LoginController;
import controller.ModelLogin;
import view.Login;

public class main {
    public static void main(String[] args) {
        new LoginController(new Login(), new ModelLogin());
    }
}