package com.example.josemedinaruiz97.juegodianas.currentgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.josemedinaruiz97.juegodianas.generic.GameObject;
import com.example.josemedinaruiz97.juegodianas.media.Image;

/**
 * Created by josemedinaruiz97 on 26/2/18.
 */

public class Puntuacion extends GameObject {
    private int pa=1;
    public Puntuacion() {
        super(Assets.transparente);

    }

    @Override
    public void update() {
        Bitmap m=Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c =new Canvas(m);
        Paint p=new Paint();
        p.setColor(Color.TRANSPARENT);
        p.setStyle(Paint.Style.FILL);
        c.drawRect(0, 0, 100, 100,p);
        p.setColor(Color.WHITE);
        p.setTextSize(20);
        c.drawText("Puntuacíon: "+pa,20,30,p);
        Image i =new Image(m);
        setImage(i);

    }

    public void setPa(int p) {
        this.pa = p;
    }
}
