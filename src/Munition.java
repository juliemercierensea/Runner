import javafx.geometry.Rectangle2D;

public class Munition extends AnimatedThing {
    public Munition() {
        super(400, 20, "explosion",200,60);
    }

    //méthode pour retirer une munition : on fait défiler l'image
    public void shoot() {
        if (getIndex() == 3) {
            setIndex(0);
        } else {
            setIndex(getIndex() + 1);
        }
        this.getImageView().setViewport(new Rectangle2D( 0, getIndex() *60, 200, 60));

    }
}