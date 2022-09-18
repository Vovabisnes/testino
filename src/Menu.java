import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Scanner;

public class Menu extends JPanel implements Scene{
    private final MenuController menuController;

    public Menu (MenuController menuController) throws IOException {
        this.menuController = menuController;
    }

    @Override
    public int run(JFrame frame) throws IOException {
        MenuController menuController = new MenuController();
        frame.add(menuController.getMenu());
        frame.getContentPane().addMouseListener(menuController);


        Scanner scn = new Scanner(System.in);

        System.out.println("Menu");

        scn.next();
        return 2;
    }


    @Override
    public void paint (Graphics g)
    {
        Image image = new ImageIcon("res/menu.jpg").getImage();
        g.drawImage(image,0,0,null);

        repaint();
    }

}
