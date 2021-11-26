import javafx.animation.AnimationTimer;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class GameScene extends Scene {
    private static staticThing backgroundleft;
    private static staticThing backgroundright;
    private static staticThing gameover;
    private Hero hero;
    private Foe monstre;
    private Life life;
    private Munition munition;
    protected int numberOfLives=3;

    Camera camera = new Camera(0, 0);

    //getters
    public static staticThing getBackgroundleft() {
        return backgroundleft;
    }
    public static staticThing getBackgroundright() {
        return backgroundright;
    }
    public Hero getHero() {
        return hero;
    }
    public Foe getMonstre() { return monstre; }
    public Life getLife() {return life;}
    public static staticThing getGameOver() { return gameover; }
    public Munition getMunition() {return munition;}

    //setters
    public static void setBackgroundleft(staticThing backgroundleft) {
        GameScene.backgroundleft = backgroundleft;
    }
    public static void setBackgroundright(staticThing backgroundright) {
        GameScene.backgroundright = backgroundright;
    }
    public void setMonstre(Foe monstre) { this.monstre = monstre;}
    public void setLife(Life life) {this.life = life;}
    public static void setGameover(staticThing gameover) {GameScene.gameover = gameover;}
    public void setMunition(Munition munition) {this.munition = munition;}

    //constructeur
    public GameScene(Parent parent, double width, double height, boolean depthBuffer) {

        super(parent, width, height, depthBuffer);

        this.setBackgroundleft(new staticThing(0, 0, "desert"));
        this.setBackgroundright(new staticThing(800, 0, "desert"));
        this.setGameover(new staticThing(900, 0, "gameover"));

        this.getBackgroundleft().getimageView().setViewport(new Rectangle2D(0, 0, this.getBackgroundleft().getimageView().getFitHeight(), this.getBackgroundleft().getimageView().getFitWidth()));
        this.getBackgroundright().getimageView().setViewport(new Rectangle2D(0, 0, this.getBackgroundright().getimageView().getFitHeight(), this.getBackgroundright().getimageView().getFitWidth()));

        this.hero = new Hero();
        this.monstre = new Foe();
        this.life = new Life();
        this.munition = new Munition();
        munition.setIndex(-1);
        munition.shoot();

        //Animation
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long time) {
                GameScene.update();
                if (hero.isJumpOk() == true) {
                    hero.jump();
                }
                if ((hero.isJumpOk() == false)&(hero.getY()<245)) {
                    hero.setFallOk(true);
                }
                if (hero.isFallOk() == true) {
                    hero.fall();
                }

                if (hero.isHitOk()==true){
                    hero.hit();
                    if (collision()==true){
                        hero.setHitOk(false); //à mettre autrement parce qu'on ne passe qu'une seule fois dans la boucle
                        monstre.update();     // dc le monstre ne se décale que d'une case
                        monstre.setInvincible(true);
                        munition.shoot();
                    }
                }
                /*if ((hero.isInvincible()==false)&(collision()==true)&(hero.isHitOk()==true)&(monstre.isInvincible()==false)){
                    munition.shoot();
                    System.out.println("Munition en moins");
                }*/
                if ((hero.isInvincible()==false)&(collision()==true)&(hero.isHitOk()==false)&(monstre.isInvincible()==false)){
                   life.death();
                   System.out.println(" Une vie en moins !");
                   hero.setInvincible(true);
                    if (numberOfLives==1){
                        gameover.getimageView().setX(0);
                        gameover.setX(0);
                        gameover.showgameover();
                        numberOfLives=3;
                        this.stop();}

                    else{
                        numberOfLives-=1;}
                    }

                if (time - lastUpdate >= 100_000_000) {
                    hero.update();
                    monstre.update();
                    lastUpdate = time;
                }

            }
        };
        timer.start();

        //détecter l'activation des touches
        this.setOnKeyPressed(event ->{
            if (event.getCode()== KeyCode.SPACE){
                System.out.println("Jump");
                if (hero.getY()==245) {
                    hero.setJumpOk(true);
                }
            }
            if (event.getCode()== KeyCode.ENTER){
                System.out.println("Hit");
                if (hero.getY()==245) {
                    hero.setHitOk(true);
                }
            }
        });
    }

    //méthode pour faire défiler le fond
    private static void update() {
        double x1 = backgroundleft.getX();
        double x2 = backgroundright.getX();
        if (x2 <= 0) {
            backgroundright.getimageView().setX(800);
            backgroundright.setX(800);
            backgroundleft.getimageView().setX(0);
            backgroundleft.setX(0);
        } else {
            backgroundleft.getimageView().setX(x1 - 2);
            backgroundleft.setX(x1 - 2);
            backgroundright.getimageView().setX(x2 - 2);
            backgroundright.setX(x2 - 2);
        }
    }

    //méthode collision
    private boolean collision(){
        if((hero.getX()+70 > monstre.getX())&(hero.getX()<monstre.getX()+55)&(hero.getY()+80>monstre.getY())){
            System.out.println("collision");
            return true;
        }
        //System.out.println("Keep running");
        return false;}
}
