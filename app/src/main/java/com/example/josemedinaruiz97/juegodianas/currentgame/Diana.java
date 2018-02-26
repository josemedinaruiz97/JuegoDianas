package com.example.josemedinaruiz97.juegodianas.currentgame;

import com.example.josemedinaruiz97.juegodianas.generic.GameObject;
import com.example.josemedinaruiz97.juegodianas.media.Image;

/**
 * Created by josemedinaruiz97 on 25/2/18.
 */

public class Diana extends GameObject{
    public Diana() {
        super(Assets.diana);
        this.setSpeedX(5);
        this.setY(this.getHeight()-10);
    }

    @Override
    public void update() {
        this.setX(this.getX() + this.getSpeedX());
    }
}
