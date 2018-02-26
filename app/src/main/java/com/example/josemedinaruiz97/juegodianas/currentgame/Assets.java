package com.example.josemedinaruiz97.juegodianas.currentgame;

import com.example.josemedinaruiz97.juegodianas.media.Graphics;
import com.example.josemedinaruiz97.juegodianas.media.Image;

public class Assets {

    public static Image background, ball, ball2,ball3,ball1,ball4,diana,transparente;

    public static void load(Graphics g) {
        Assets.background = g.newImage("beach.png");
        Assets.ball = g.newImage("91.png");
        Assets.ball1 = g.newImage("92.png");
        Assets.ball2 = g.newImage("93.png");
        Assets.ball3 = g.newImage("94.png");
        Assets.ball4= g.newImage("95.png");
        Assets.diana=g.newImage("Diana 0.png");
        Assets.transparente=g.newImage("transparente.png");
    }
}