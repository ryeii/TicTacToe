import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by Ryan An
 * Date: 2020/7/13 2:47 下午
 */
public class TPane extends Pane {

    private Canvas canvas;
    private GraphicsContext gc;
    private TicTacToe t;

    public TPane(TicTacToe t)
    {
        this.t = t;
        drawPane();
        drawChess();
        drawCurrentPlayer();
        getChildren().add(canvas);
    }

    public void drawPane()
    {
        canvas = new Canvas(500,500);
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.strokeLine(200,100,200,400);
        gc.strokeLine(300,100,300,400);
        gc.strokeLine(100,200,400,200);
        gc.strokeLine(100,300,400,300);
    }

    public void drawChess()
    {
        int[][] chess = t.getPane();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(chess[i][j] != 0)
                {
                    if(chess[i][j] == 1)
                    {
                        gc.strokeOval(100+100*j+20,100+100*i+20,60,60);
                    }
                    if(chess[i][j] == 2)
                    {
                        gc.strokeLine(100+100*j+20,100+100*i+20,100+100*(j+1)-20,100+100*(i+1)-20);
                        gc.strokeLine(100+100*(j+1)-20,100+100*i+20,100+100*j+20,100+100*(i+1)-20);
                    }
                }
            }
        }
    }

    public void drawCurrentPlayer()
    {
        gc.clearRect(400,100,100,100);
        int i = 0;
        int j = 3;
        if(this.t.getCurrentPlayer())
        {
            gc.strokeOval(100+100*j+20,100+100*i+20,60,60);
        }
        else
        {
            gc.strokeLine(100+100*j+20,100+100*i+20,100+100*(j+1)-20,100+100*(i+1)-20);
            gc.strokeLine(100+100*(j+1)-20,100+100*i+20,100+100*j+20,100+100*(i+1)-20);
        }
    }

}
