import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ryan An
 * Date: 2020/7/13 3:48 下午
 */
public class Action implements EventHandler<MouseEvent> {

    private TicTacToe t;
    private TPane pane;
    private Robot bot;
    private boolean robotFirst;
    private boolean robotSecond;

    public Action(TicTacToe t, TPane pane, Robot bot)
    {
        this.t = t;
        this.pane = pane;
        this.bot = bot;
        this.robotFirst = false;
        this.robotSecond = false;
    }

    public Action(TicTacToe t, TPane pane, Robot bot, boolean robotFirst, boolean robotSecond)
    {
        this.t = t;
        this.pane = pane;
        this.bot = bot;
        this.robotFirst = robotFirst;
        this.robotSecond = robotSecond;
        if(robotFirst)
        {
            t.move(bot.getNextMove());
            pane.drawChess();
            pane.drawChess();
            pane.drawChess();
            pane.drawCurrentPlayer();
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        int i = (int)((x-100)/100);
        int j = (int)((y-100)/100);

        if(!isCurrentPlayerRobot())
        {
            try{
                t.move(j * 3 + i + 1);
                pane.drawChess();
                pane.drawChess();
                pane.drawChess();
                pane.drawCurrentPlayer();
                winAlert(t.checkWin());

                if(isCurrentPlayerRobot())
                {
                    t.move(bot.getNextMove());
                    pane.drawChess();
                    pane.drawChess();
                    pane.drawChess();
                    pane.drawCurrentPlayer();
                    winAlert(t.checkWin());
                }
            } catch (Exception ignored)
            {

            }
        }
        else
        {
            t.move(bot.getNextMove());
            pane.drawChess();
            pane.drawChess();
            pane.drawChess();
            pane.drawCurrentPlayer();
            winAlert(t.checkWin());
        }
    }

    private void winAlert(int win)
    {
        if(win == 0)
        {
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(win == 1)
        {
            alert.setTitle("WIN!!!");
            alert.setHeaderText("The Game Ended.");
            alert.setContentText("CIRCLE Have Won This Round.");
        }
        else if(win == 2)
        {
            alert.setTitle("WIN!!!");
            alert.setHeaderText("The Game Ended.");
            alert.setContentText("CROSS Have Won This Round.");
        }
        else
        {
            alert.setTitle("DUAL!!!");
            alert.setHeaderText("The Game Ended.");
            alert.setContentText("The Game Ended With a Dual.");
        }
        alert.showAndWait();
    }

    private boolean isCurrentPlayerRobot()
    {
        if(this.t.getCurrentPlayer())
        {
            return this.robotFirst;
        }
        else
        {
            return this.robotSecond;
        }
    }
}
