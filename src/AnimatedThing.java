import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {
    protected double x;
    protected double y;
    protected double height;
    protected double width;
    private int index=0;
    private int jumpIndex;
    private int fallIndex;
    private int killIndex;
    private boolean jumpOk;
    private boolean fallOk;
    private boolean hitOk;
    private ImageView imageView;
    private Integer attitude;

    //getter de imageview
    public ImageView getImageView() {
        return imageView;
    }

    //getters et setters
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

    public void setFallOk(boolean fallOk) {
        this.fallOk = fallOk;
    }
    public boolean isFallOk() {
        return fallOk;
    }

    public int getJumpIndex() {
        return jumpIndex;
    }
    public void setJumpIndex(int jumpIndex) {
        this.jumpIndex = jumpIndex;
    }

    public boolean isJumpOk() {
        return jumpOk;
    }
    public void setJumpOk(boolean jumpOk) {
        this.jumpOk = jumpOk;
    }

    public int getFallIndex() {
        return fallIndex;
    }
    public void setFallIndex(int fallIndex) {
        this.fallIndex = fallIndex;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isHitOk() { return hitOk;}
    public void setHitOk(boolean hitOk) { this.hitOk = hitOk;}

    public int getKillIndex() { return killIndex;}
    public void setKillIndex(int killIndex) {this.killIndex = killIndex;}

    //constructeur
    public AnimatedThing(double x, double y, String fileName,double width, double height){
        this.index = 0;
        Image thingSpriteSheet = new Image("/Images/"+fileName+".png");
        this.imageView = new ImageView(thingSpriteSheet);
        this.imageView.setX(x);
        this.imageView.setY(y);
        this.imageView.setViewport(new Rectangle2D(0,0,100,30));
        this.x=x;
        this.y=y;
    }

    //méthode chute
    public void fall(){  //le perso va descendre d'un pixel dès qu'on appelle cette fonction
        this.imageView.setY(getY()-0.2*getFallIndex());
        this.setY(getY()-0.2*getFallIndex());
        setFallIndex(getFallIndex()-1);
        if (getY()>=245){
            setFallOk(false);
            this.setY(245);
            setFallIndex(0);
        }
        System.out.println(this.getY());
        System.out.println(this.isFallOk());
        System.out.println(this.isJumpOk());
    }

    //méthode saut
    public void jump(){
        this.imageView.setY(getY()-8+0.2*getJumpIndex());
        this.setY(getY()-8+0.2*getJumpIndex());
        setJumpIndex(getJumpIndex()+1);
        if (getJumpIndex()>=40){
            setJumpIndex(0);
            setJumpOk(false);
        }
    }

    //killing the monster
    public void kill(){
        this.imageView.setY(getY()-8+10*getKillIndex());
        this.setY(getY()-8+10*getKillIndex());
        setKillIndex(getKillIndex()+1);
    }

    //méthode frappe
    public void hit(){
        if (getY()>245){
            setHitOk(false);}
        if (getY()<=245){
            setHitOk(true);}
    }

    //méthode détection collision
    public Rectangle2D getHitBox(){
        return new Rectangle2D(x+1,y+1,width+10, height+10 );
    }
}
