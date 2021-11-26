import javafx.geometry.Rectangle2D;

public class GameOver extends staticThing {
    public GameOver() {
        super (30,245,"gameover");
    }
    //méthode pour afficher le game over au bon moment
    public void showgameover(){
        this.getimageView().setViewport(new Rectangle2D( 0, 0, 100, 100));
    }
}
