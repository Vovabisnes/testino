import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class View  extends JPanel implements Scene{
    private final Controller controller;
    private int flag;
    private int [][] field0;
    private int [][] fieldFull;
    public static int Tile = Main.HeightOfGame/10;
    Tile tile;

    public View (Controller controller) throws IOException {
        this.controller = controller;
    }

    public void setFields(int [][] field0, int [][] fieldFull )
    {
        this.field0 = field0;
        this.fieldFull = fieldFull;
    }

    public void setFlag(int flag )
    {
        this.flag = flag;
    }

    @Override
    public void paint (Graphics g)
    {
        Image image = new ImageIcon("res/fon.jpg").getImage();
        g.drawImage(image,0,0,null);
        for(int x=0; x<Model.HEIGHT; x++)
        {
            for (int y=0; y<Model.WIDTH; y++)
            {
                tile = new Tile(x,y,field0[x][y]);
                tile.drawTile(g);
            }
        }
        g.drawString("Flags left: " + flag, View.Tile,View.Tile/2+5);
        repaint();
    }

    public void showMessage (boolean x)
    {
        if (x)
            JOptionPane.showMessageDialog(this, "YOU WIN!");
        else JOptionPane.showMessageDialog(this, "YOU LOST!");
    }

    @Override
    public int run(JFrame frame) throws IOException {
        Model model = new Model();
        Controller controller = new Controller(model);
        frame.add(controller.getView());
        frame.getContentPane().addMouseListener(controller);
        Scanner scn = new Scanner(System.in);

        System.out.println("View");

        scn.next();
        return 1;
    }
}
