import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Controller extends MouseAdapter {
    private final Model model;
    private final View view;

    public Controller (Model model) throws IOException {
        this.model = model;
        view = new View(this);
        view.setFields(model.startHideField(),model.startFullField());
        view.setFlag(model.Flag);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(mouseX + " " + mouseY);
       if (model.WinGame())
        {
            view.showMessage(true);
            System.exit(1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/(Main.HeightOfGame/10);
        int y = e.getY()/(Main.HeightOfGame/10);
        if ((x<1 || x>8) || (y<1 || y>8) ) return;
        x--; y--;
        if (SwingUtilities.isLeftMouseButton(e))
        {
            if(model.LooseGame(x,y))
            {
                model.choose(x, y);
                view.showMessage(false);
                System.exit(1);
            }
            else {
            model.choose(x, y); }
        }
        else
        {
            model.chooseFlag(x,y);
            view.setFlag(model.Flag);
        }
        view.repaint();
    }

    public View getView()
    {
        return view;
    }
}
