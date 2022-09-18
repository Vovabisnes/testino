import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    final static int WidthOfGame = 500;
    final static int HeightOfGame = 500;
    public static int menuController = 1;

    public static void main(String[] args) throws IOException {
        Scene scene[] = {
                new Menu(new MenuController()),
                new View(new Controller(new Model())),
                new Creators(new CreatorController())
        };

        while (menuController != 0)
        {
            menuController = scene[menuController-1].run(getFrame());
        }
    }

    public static JFrame getFrame() throws IOException {
        JFrame frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - WidthOfGame /2, dimension.height/2 - HeightOfGame /2, WidthOfGame, HeightOfGame);
        frame.setResizable(false);
        return frame;
    }
}
