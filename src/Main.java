import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by Ryan An
 * Date: 2020/7/13 4:22 下午
 */
public class Main extends Application {

    @FXML
    Button RobotFirst;

    @FXML
    Button RobotSecond;

    private boolean robotFirst = false;
    private boolean robotSecond = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void startGame(Stage stage) throws Exception {

        TicTacToe t = new TicTacToe();
        TPane pane = new TPane(t);
        Robot bot = new Robot(t);

        if(robotFirst || robotSecond)
        {
            pane.setOnMouseClicked(new Action(t, pane, bot, robotFirst, robotSecond));
        }
        else
        {
            pane.setOnMouseClicked(new Action(t, pane, bot));
        }

        stage.setTitle("Tic Tac Toe");
        stage.setScene(new Scene(pane,500,500));
        stage.show();
    }

    public void startButtonClicked(MouseEvent mouseEvent) throws Exception {
        startGame(new Stage());
    }

    public void RobotFirstButtonClicked(MouseEvent mouseEvent) {

        if(robotFirst)
        {
            robotFirst = false;
            RobotFirst.setText("Robot First: NO");
        }
        else
        {
            robotFirst = true;
            RobotFirst.setText("Robot First: YES");
        }

    }

    public void RobotSecondButtonClicked(MouseEvent mouseEvent) {

        if(robotSecond)
        {
            robotSecond = false;
            RobotSecond.setText("Robot Second: NO");
        }
        else
        {
            robotSecond = true;
            RobotSecond.setText("Robot Second: YES");
        }

    }
}
