import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThing {
    public Foe() {
            super(500,245,"monstre",50,50);
        }

        private boolean Invincible=false;
    private int invincibleIndex=0;

    public boolean isBlink() {return blink;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    private boolean blink;

    //getters et setters
    public boolean isInvincible() { return Invincible;}
    public int getInvincibleIndex() { return invincibleIndex;}
    public void setInvincible(boolean invincible) { Invincible = invincible;}
    public void setInvincibleIndex(int invincibleIndex) { this.invincibleIndex = invincibleIndex;}


    //méthode course
    public void update() {
        if (getIndex() == 3) {
            setIndex(0);
        }
        if (isBlink()==true){setBlink(false);}
        else{setBlink(true);}

        if (this.getX() < -50) {
            this.setX(850);
            this.setY(245);
            this.getImageView().setX(850);
            this.getImageView().setY(245);
            setIndex(getIndex() + 1);
        } else {
            this.setX(getX() - 23);
            this.getImageView().setX(getX() - 23);
        }

        if (isInvincible() == true) {
            setInvincibleIndex(getInvincibleIndex() + 1);
        }
        if (getInvincibleIndex() >= 10) {
            setInvincibleIndex(0);
            setInvincible(false);}

            this.getImageView().setViewport(new Rectangle2D(getIndex() * 94 + 22, 0, 110, 120));

        if(isInvincible()==true){
            if (isBlink()==true){
                this.getImageView().setViewport(new Rectangle2D(0, 0, 1, 1));
            }
        }

    }
}
