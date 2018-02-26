package com.example.josemedinaruiz97.juegodianas;

import com.example.josemedinaruiz97.juegodianas.currentgame.Bola;
import com.example.josemedinaruiz97.juegodianas.currentgame.Diana;
import com.example.josemedinaruiz97.juegodianas.currentgame.Fondo;
import com.example.josemedinaruiz97.juegodianas.currentgame.Puntuacion;
import com.example.josemedinaruiz97.juegodianas.generic.GameObject;
import com.example.josemedinaruiz97.juegodianas.generic.GenericGameActivity;

import java.util.ArrayList;
import java.util.Random;

public class JuegoNuevo extends GenericGameActivity {
    private long time=0;
    private int puntuacion=0;
    private int velocidad=4;
    private boolean encontrado=false;
    private Puntuacion p;
    private Bola b1,b2;
    private boolean pulsado=false;
    ArrayList<Diana> dianas= new ArrayList<>();
    ArrayList<Bola> bolas=new ArrayList<>();

    private void añadirBolas(){
        if (getTouchHandler().isTouchDown() && !pulsado) {
            pulsado = true;
        }
        if (!getTouchHandler().isTouchDown() && pulsado) {
            Bola bola =new Bola(getTouchHandler().getTouchX(), getTouchHandler().getTouchY());
            addGameObject(bola);
            bolas.add(bola);
            pulsado = false;
        }
    }

    private void eliminarDianas(){
        for (int i = 0; i < dianas.size(); i++) {
            if (dianas.get(i).getX() > this.getGraphics().getWidth() - dianas.get(i).getImage().getBitmap().getWidth()) {
                dianas.remove(i);
                if (puntuacion != 0) {
                    puntuacion--;
                }
            }
        }
    }

    private void eliminarObjetos(ArrayList<GameObject> eliminar){
        if(eliminar.size()!=0){
            for(GameObject o:eliminar){
                if(o.getClass()==Diana.class){
                    dianas.remove(o);
                }else{
                    bolas.remove(o);
                }
            }
        }
    }

    private void generarDianas(){
        encontrado=false;
        Random r=new Random(System.currentTimeMillis());
        if(time==0){
            Diana diana1 = new Diana();
            addGameObject(diana1);
            dianas.add(diana1);
            time=System.currentTimeMillis();
        }else if((System.currentTimeMillis()-time)>1000){
            Diana diana1 = new Diana();
            diana1.setY(r.nextInt(this.getGraphics().getHeight()-100));
            diana1.setSpeedX(velocidad);
            r.setSeed(System.currentTimeMillis());
            addGameObject(diana1);
            dianas.add(diana1);
            time=System.currentTimeMillis();

        }
    }
    @Override
    public void start() {
        addGameObject(new Fondo());
        addGameObject(p=new Puntuacion());
    }

    private void puntuar(ArrayList<GameObject> eliminar){
        if(bolas.size()!=0){
            for (Bola b:bolas){
                if(b.getActualizaciones()){
                    for(Diana d:dianas){
                        if(b.instersects(d)){
                            deleteGameObject(d);
                            deleteGameObject(b);
                            eliminar.add(b);
                            eliminar.add(d);
                            puntuacion++;
                            encontrado=true;
                        }
                    }
                    if(!encontrado) {
                        deleteGameObject(b);
                        eliminar.add(b);
                        if(puntuacion!=0) {
                            puntuacion--;
                        }
                    }
                }
            }
        }
        p.setPa(puntuacion);
    }

    @Override
    public void update() {
        super.update();
        ArrayList<GameObject> eliminar = new ArrayList<>();

        generarDianas();
        eliminarDianas();
        añadirBolas();
        puntuar(eliminar);
        eliminarObjetos(eliminar);
    }
}
