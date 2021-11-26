import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    String fileName; //filename ce sera le nom de l'image fixe qu'on ira chercher
    private ImageView imageView;


    //constructeur
    public staticThing(double x, double y, String fileName) {
        Image spriteSheet = new Image("/Images/" + fileName + ".png");
        imageView = new ImageView(spriteSheet);
        imageView.setX(x);
        imageView.setY(y);
        this.imageView.setViewport(new Rectangle2D(0,0,100,100));
    }

    //getter du ImageView
    public ImageView getimageView() {
        return imageView;
    }

    //getters et setters de x et y

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //méthode affichage
    public void showgameover(){
        this.getimageView().setViewport(new Rectangle2D( 0, 0, 0, 0));
    }
}