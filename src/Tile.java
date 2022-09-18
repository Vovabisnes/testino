import javax.swing.*;
import java.awt.*;

public class Tile {
    private final int x;
    private final int y;
    int value;
    Image image;

    public Tile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public void drawTile(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        int xoffset = offsetCoors(x);
        int yoffset = offsetCoors(y);

        g.drawImage(getImage(value),xoffset,yoffset,null);

        g2.setColor(getColor(value));
        int size = View.Tile/2;
        Font font = new Font("Constantia",Font.BOLD,size);
        g2.setFont(font);

        String s = String.valueOf(value);
        FontMetrics fn = g.getFontMetrics(font);
        int w = fn.stringWidth(s);
        int h = - (int) fn.getLineMetrics(s,g2).getBaselineOffsets()[2];

        if (value==20)
        {
            image = new ImageIcon("res/flag.png").getImage();
            g.drawImage(image, xoffset,yoffset,null);
        }
        if (value==11)
        {
            image = new ImageIcon("res/bomb.jpg").getImage();
            g.drawImage(image, xoffset,yoffset,null);
        }

        if(value!=0 && value!=9 && value!=20)
        {
        g2.drawString(s, xoffset + (View.Tile-w)/2, yoffset + View.Tile - (View.Tile-h)/2 -2);}
    }

    public Image getImage(int value)
    {
        if (value==0)
        {
            image = new ImageIcon("res/tile.jpg").getImage();
        }
        else {
            image = new ImageIcon("res/newtile.jpg").getImage();
        }
        return image;
    }

    public int offsetCoors (int x)
    {
        return x*(View.Tile) + View.Tile ;
    }

    Color getColor(int value)
    {
        Color color;
        if (value == 1)
        {
            color = new Color(0x092E65);
        }
        else if (value == 2)
        {
            color = new Color(0x109006);
        }
        else if (value == 3)
        {
            color = new Color(0xE31111);
        }
        else {
            color = new Color(0x111010);
        }
        return color;
    }

}