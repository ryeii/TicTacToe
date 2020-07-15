/**
 * Created by Ryan An
 * Date: 2020/7/12 2:46 下午
 */
public class TicTacToe {

    /**
     * 3*3 pane
     * label:
     * {
     *     {1,2,3}
     *     {4,5,6}
     *     {7,8,9}
     * }
     * 0 = empty
     * 1 = circle
     * 2 = cross
     */

    private int[][] pane;

    /**
     * true = circle playing
     * false = cross playing
     */

    private boolean currentPlayerCircle;

    private boolean circleRobot;
    private boolean crossRobot;

    public TicTacToe()
    {
        this.pane = new int[3][3];
        this.currentPlayerCircle = true;
    }

    public int[][] getPane()
    {
        return pane;
    }

    public boolean getCurrentPlayer()
    {
        return currentPlayerCircle;
    }

    public void changePlayer()
    {
        this.currentPlayerCircle = !this.currentPlayerCircle;
    }

    public void move(int label)
    {
        if(getOnLabel(label) == 0)
        {
            if(currentPlayerCircle)
            {
                pane[(label-1)/3][label-((label-1)/3)*3-1] = 1;
                changePlayer();
            }
            else
            {
                pane[(label-1)/3][label-((label-1)/3)*3-1] = 2;
                changePlayer();
            }
        }
    }

    /**
     * Check whether the game ended.
     * @return
     * 0: game ended not
     * 1: circle win
     * 2: cross win
     * 3: dual
     */

    public int checkWin()
    {
        if(getOnLabel(1) != 0)
        {
            if(getOnLabel(1)==getOnLabel(2)&&getOnLabel(1)==getOnLabel(3))
            {
                return getOnLabel(1);
            }
            if(getOnLabel(1)==getOnLabel(4)&&getOnLabel(1)==getOnLabel(7))
            {
                return getOnLabel(1);
            }
            if(getOnLabel(1)==getOnLabel(5)&&getOnLabel(1)==getOnLabel(9))
            {
                return getOnLabel(5);
            }
        }
        if(getOnLabel(5) != 0)
        {
            if(getOnLabel(4)==getOnLabel(5)&&getOnLabel(4)==getOnLabel(6))
            {
                return getOnLabel(4);
            }
            if(getOnLabel(2)==getOnLabel(5)&&getOnLabel(2)==getOnLabel(8))
            {
                return getOnLabel(2);
            }
            if(getOnLabel(3)==getOnLabel(5)&&getOnLabel(3)==getOnLabel(7))
            {
                return getOnLabel(5);
            }
        }
        if(getOnLabel(9) != 0)
        {
            if(getOnLabel(7)==getOnLabel(8)&&getOnLabel(7)==getOnLabel(9))
            {
                return getOnLabel(7);
            }
            if(getOnLabel(3)==getOnLabel(6)&&getOnLabel(3)==getOnLabel(9))
            {
                return getOnLabel(3);
            }
        }
        boolean dual = true;
        for (int i = 1; i < 10; i++)
        {
            if(getOnLabel(i) == 0)
            {
                dual = false;
                break;
            }
        }
        if(dual)
        {
            return 3;
        }
        return 0;
    }

    private int getOnLabel(int label)
    {
        int[][] pane = this.getPane();
        switch (label)
        {
            case 1: return pane[0][0];
            case 2: return pane[0][1];
            case 3: return pane[0][2];
            case 4: return pane[1][0];
            case 5: return pane[1][1];
            case 6: return pane[1][2];
            case 7: return pane[2][0];
            case 8: return pane[2][1];
            case 9: return pane[2][2];
        }
        return -1;
    }

}
