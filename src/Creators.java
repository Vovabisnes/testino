import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Creators extends JPanel implements Scene{
    private final CreatorController creatorController;

    public Creators (CreatorController creatorController) throws IOException {
        this.creatorController = creatorController;
    }

    @Override
    public int run(JFrame frame) throws IOException {
        CreatorController creatorController = new CreatorController();
        frame.add(creatorController.getCreators());
        frame.getContentPane().addMouseListener(creatorController);

        Scanner scn = new Scanner(System.in);

        System.out.println("Creators");

        scn.next();
        return Main.menuController;
    }


    @Override
    public void paint (Graphics g)
    {
        Image image = new ImageIcon("res/creators.jpg").getImage();
        g.drawImage(image,0,0,null);

        repaint();
    }

}
