
package main;

import controller.AuthController;
import controller.ModelLogin;
import view.Login;

public class main {
    public static void main(String[] args) {
        new AuthController(new Login(), new ModelLogin());
    }
}