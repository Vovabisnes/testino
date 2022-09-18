import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CreatorController extends MouseAdapter {
    private final Creators creators;

    public CreatorController ( ) throws IOException {
        this.creators= new Creators(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (x >= 450 && x <= 500) {
                if (y >= 450 && y <= 500) {
                    try {
                        Main.menuController = new Menu(new MenuController()).run(Main.getFrame());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

            }
            creators.repaint();
        }
    }

    public Creators getCreators()
    {
        return creators;
    }

}