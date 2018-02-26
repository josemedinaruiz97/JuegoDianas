package com.example.josemedinaruiz97.juegodianas.currentgame;

import com.example.josemedinaruiz97.juegodianas.generic.GameBackground;

public class Fondo extends GameBackground {

    public Fondo() {
        super(Assets.background);
        this.setMovement(Movement.MOVING);
    }
}
