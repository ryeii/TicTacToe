/**
 * Created by Ryan An
 * Date: 2020/7/13 3:49 下午
 */
public class Robot {

    private TicTacToe t;

    private static int[] weights;

    public Robot(TicTacToe t)
    {
        this.t = t;
    }

    /**
     * Get next move
     * @return
     * int label, in range(1, 9)
     */
    public int getNextMove()
    {
        this.giveWeights();
        int index = 0;
        for (int i = 0; i < weights.length; i++)
        {
            if(getOnLabel(i+1) == 0)
            {
                index = i;
                break;
            }
        }
        for (int i = 0; i < weights.length; i++)
        {
            if(weights[i] > weights[index] && getOnLabel(i+1) == 0)
            {
                index = i;
            }
        }
        return index + 1;
    }

    private void giveWeights()
    {
        weights = new int[9];
        boolean circle = t.getCurrentPlayer();
        int component = 0;
        if(circle)
        {
            component = 2;
        }
        else
        {
            component = 1;
        }
        giveOnVector(1,2,3,component);
        giveOnVector(4,5,6,component);
        giveOnVector(7,8,9,component);
        giveOnVector(1,4,7,component);
        giveOnVector(2,5,8,component);
        giveOnVector(3,6,9,component);
        giveOnVector(1,5,9,component);
        giveOnVector(3,5,7,component);
    }

    private void giveOnVector(int firstLabel, int secondLabel, int thirdLabel, int component)
    {
        // give weights
        if(getOnLabel(firstLabel) != component && getOnLabel(secondLabel) != component && getOnLabel(thirdLabel) != component)
        {
            weights[firstLabel-1] += 1;
            weights[secondLabel-1] += 1;
            weights[thirdLabel-1] += 1;
        }

        // check lethal spot
        if(getOnLabel(firstLabel) == getOnLabel(secondLabel) && getOnLabel(firstLabel) != 0)
        {
            if(getOnLabel(firstLabel) == component)
            {
                weights[thirdLabel-1] += 5;
            }
            else
            {
                weights[thirdLabel-1] += 10;
            }
        }
        if(getOnLabel(firstLabel) == getOnLabel(thirdLabel) && getOnLabel(firstLabel) != 0)
        {
            if(getOnLabel(firstLabel) == component)
            {
                weights[secondLabel-1] += 5;
            }
            else
            {
                weights[secondLabel-1] += 10;
            }
        }
        if(getOnLabel(secondLabel) == getOnLabel(thirdLabel) && getOnLabel(secondLabel) != 0)
        {
            if(getOnLabel(secondLabel) == component)
            {
                weights[firstLabel-1] += 5;
            }
            else
            {
                weights[firstLabel-1] += 10;
            }
        }
    }

    private int getOnLabel(int label)
    {
        int[][] pane = this.t.getPane();
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
