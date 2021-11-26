import javafx.geometry.Rectangle2D;

public class GameOver extends staticThing {
    public GameOver() {
        super (20,245,"gameover");
    }
    //méthode pour afficher le game over au bon moment
    public void showgameover(){
        this.getimageView().setViewport(new Rectangle2D( 100, 0, 100, 100));
    }
}
