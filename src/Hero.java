import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {
    public Hero() {                         //ne pas oublier les parenthèses pr préciser quil n'y a pas d'arg
        super(20,245,"heros",50,50);
    }

    public boolean isInvincible() {
        return Invincible;
    }

    public void setInvincible(boolean invincible) {
        Invincible = invincible;
    }

    public int getInvincibleIndex() {
        return invincibleIndex;
    }

    public void setInvincibleIndex(int invincibleIndex) {
        this.invincibleIndex = invincibleIndex;
    }

    private boolean Invincible=false;
    private int invincibleIndex=0;
    //méthode course
    public void update(){
        if (getIndex() == 5) {
            setIndex(0);
        } else {
            setIndex(getIndex() + 1);
        }
        if (isInvincible()==true){
            setInvincibleIndex(getInvincibleIndex()+1);
        }
        if (getInvincibleIndex()>=30){
            setInvincibleIndex(0);
            setInvincible(false);
            System.out.println("njtdthgb");
        }


        if ((isFallOk()==false)&(isJumpOk()==false)&(isHitOk()==false)){
            this.getImageView().setViewport(new Rectangle2D(getIndex()*85+3,0,75,100));}

        if (isJumpOk()==true){
            this.getImageView().setViewport(new Rectangle2D(3,162,75,100));}

        if (isFallOk()==true){
            this.getImageView().setViewport(new Rectangle2D(88,162,75,100));}

        if(isHitOk()==true){
            this.getImageView().setViewport(new Rectangle2D(getIndex()*85+3,330,75,100));}
        }
}
