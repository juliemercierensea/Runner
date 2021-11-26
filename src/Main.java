import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bonhomme qui court");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene theScene = new GameScene(pane, 600, 400, true);
        //GameScene theScene = new GameScene(root);

        pane.getChildren().add(theScene.getBackgroundleft().getimageView());
        pane.getChildren().add(theScene.getBackgroundright().getimageView());
        pane.getChildren().add(theScene.getGameOver().getimageView());
        pane.getChildren().add(theScene.getHero().getImageView());
        pane.getChildren().add(theScene.getMonstre().getImageView());
        pane.getChildren().add(theScene.getLife().getImageView());

        /*Image spriteSheet = new Image("heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(20);
        sprite.setY(245);
        root.getChildren().add(sprite);*/

        primaryStage.setScene(theScene);

        primaryStage.show();
    }
    public static void main(String[] args) {
    launch(args);
    }
}