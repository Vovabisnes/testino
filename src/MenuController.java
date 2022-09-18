import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MenuController extends MouseAdapter {
    private final Menu menu;

    public MenuController ( ) throws IOException {
        menu = new Menu(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (SwingUtilities.isLeftMouseButton(e))
        {
            if (x>=125 && x<=375)
            {
                if (y>=90 && y<=115)
                {

                    try {
                        Main.menuController = new View(new Controller(new Model())).run(Main.getFrame());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    /*try {
                        View view = new View(new Controller(new Model()));
                        view.run(Main.getFrame());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }*/
                }
                else if (y>=180 && y<=205)
                {
                    try {
                        Main.menuController = new Creators(new CreatorController()).run(Main.getFrame());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                else if (y>=285 && y<=310)
                {
                    System.exit(1);
                }
            }
        }
        menu.repaint();
    }

    public Menu getMenu()
    {
        return menu;
    }
}
