import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThing {
    public Foe() {
            super(500,245,"monstre",50,50);
        }
    //méthode course
    public void update() {
        if (getIndex() == 3) {
            setIndex(0);
        }
        if (this.getX()<-50){
            this.setX(850);
            this.setY(245);
            this.getImageView().setX(850);
            this.getImageView().setY(245);
            setIndex(getIndex() + 1);
        }
        else {
            this.setX(getX()-20);
            this.getImageView().setX(getX()-20);
        }

        this.getImageView().setViewport(new Rectangle2D(getIndex() *94 +22 , 0, 110, 120));
    }

}
