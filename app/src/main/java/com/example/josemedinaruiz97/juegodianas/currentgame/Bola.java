package com.example.josemedinaruiz97.juegodianas.currentgame;


import com.example.josemedinaruiz97.juegodianas.generic.GameObject;
import com.example.josemedinaruiz97.juegodianas.media.Animation;

public class Bola extends GameObject {
    private Animation animation;
    private long tiempo=0;
    private boolean actualizaciones=false;
    public Bola(int x, int y) {
        super(Assets.ball);
        this.setX(x);
        this.setY(y);
        this.setSpeedX(5);
        animation = new Animation();
        animation.addFrame(Assets.ball, 100);
        animation.addFrame(Assets.ball1, 100);
        animation.addFrame(Assets.ball2, 100);
        animation.addFrame(Assets.ball3, 100);
        animation.addFrame(Assets.ball4, 100);
        tiempo=System.currentTimeMillis();
    }

    public void update() {
        if(actualizaciones==false) {
            animation.update(System.currentTimeMillis() - tiempo);
            tiempo = System.currentTimeMillis();
            this.setImage(animation.getImage());
            if(animation.getImage()==Assets.ball4){
                actualizaciones=true;
            }
        }
    }
    public boolean getActualizaciones(){
        return actualizaciones;
    }

}