import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Model {
    final static int WIDTH = 8;
    final static int HEIGHT = 8;
    final static int MinesNum = 10;
    static int Flag = 10;
    int [][] field = new int[HEIGHT][WIDTH];
    int [][] hidefield = new int[HEIGHT][WIDTH];
    // 11=mine 9=0 20 flag

    public int[][] startFullField()
    {
        drawMines();
        NumOfMines();
        return field;
    }

    public int[][] startHideField()
    {
        return hidefield;
    }

    public void drawMines()
    {
            Random random = new Random();
            for (int i=0; i<MinesNum; i++) {
                while (true) {
                    int row = random.nextInt(HEIGHT);
                    int col = random.nextInt(WIDTH);
                    if (field[row][col] == 0) {
                        field[row][col] = 11;
                        break;
                    }
                }
            }
    }

    public void NumOfMines()
    {
        int[] col = {0,-1,1,0,-1,1,-1,1};
        int[] row = {-1,0,0,1,-1,1,1,-1};

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++)
            {
                if(field[i][j]==11)
                {
                    for(int k=0; k<8; k++)
                    {
                        if((j+col[k]<WIDTH && j+col[k]>=0) && (i+row[k]<HEIGHT && i+row[k]>=0) && field[i+row[k]][j+col[k]]!=11)
                        {
                            field[i+row[k]][j+col[k]]++;
                        }
                    }
                }
            }
        }
    }

    static class point{
        int x,y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void chooseFlag(int x, int y) {
        if (hidefield[x][y] == 20) {
            hidefield[x][y] = 0;
            ++Flag;
        }
        else {
        if (Flag>0 ){
        if (hidefield[x][y] == 0) {
            hidefield[x][y] = 20;
            --Flag;
        }
        } }
    }

    public void choose(int x, int y) {
        if (field[x][y]==11 && hidefield[x][y]==0)
        {
            hidefield[x][y]=11;
            return;
        }
        if(field[x][y]>0 && field[x][y]<9 && hidefield[x][y]==0)
        {
        hidefield[x][y]=field[x][y]; }
        else if (field[x][y]==0 && hidefield[x][y]==0){
            int[] col = {0, -1, 1, 0, -1, 1, -1, 1};
            int[] row = {-1, 0, 0, 1, -1, 1, 1, -1};
            Queue<point> q = new LinkedBlockingQueue<>();

            field[x][y] = 9;
            hidefield[x][y] = 9;
            q.add(new point(x, y));
            while (!q.isEmpty()) {
                point point = q.poll();
                int X = point.x;
                int Y = point.y;

                for (int k = 0; k < 4; k++) {
                    if (X + row[k] >= 0 && X + row[k] < HEIGHT &&
                            Y + col[k] >= 0 && Y + col[k] < WIDTH && field[X + row[k]][Y + col[k]] == 0) {
                        field[X + row[k]][Y + col[k]] = 9;
                        hidefield[X + row[k]][Y + col[k]] = 9;


                        for (int s = 0; s < 8; s++) {
                            int i = Y + col[k] + col[s];
                            int i1 = X + row[k] + row[s];
                            if ((i < WIDTH && i >= 0) &&
                                    (i1 < HEIGHT && i1 >= 0)
                                    && field[i1][i] != 11) {
                                hidefield[i1][i] = field[i1][i];
                            }
                        }

                        q.add(new point(X + row[k], Y + col[k]));
                    }
                }
            }
        }
    }

    public boolean LooseGame(int x, int y)
    {
        return field[x][y] == 11 && hidefield[x][y]!=20;
    }

    public boolean WinGame ()
    {
        if (Flag!=0) return false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (hidefield[i][j]==0)
                    return false;
                if(hidefield[i][j]==20 && field[i][j]!=11)
                    return false;
            }
        }
        return true;

    }

    }
