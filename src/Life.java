import javafx.geometry.Rectangle2D;

public class Life extends AnimatedThing {
    public Life() {
        super(25, 20, "vies",50,50);
    }

    //méthode pour retirer une vie : on fait défiler l'image
    public void death() {
        if (getIndex() == 3) {
            setIndex(0);
        } else {
            setIndex(getIndex() + 1);
        }
        this.getImageView().setViewport(new Rectangle2D( 0, getIndex() *33, 100, 30));

    }
}

