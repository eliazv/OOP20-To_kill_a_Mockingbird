package application;

import java.io.IOException;
import javax.swing.JFrame;
import controllers.MainMenuController;
import controllers.MainMenuControllerImpl;


public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(final String[] args) throws IOException {

        new GUI();
        final MainMenuController controller = new MainMenuControllerImpl();
        controller.setup();

    }
}
