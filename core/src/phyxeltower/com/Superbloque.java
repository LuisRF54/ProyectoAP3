package phyxeltower.com;

import java.util.ArrayList;

public class Superbloque implements Bloque {
    private ArrayList<Simple> b;

    public Superbloque(ArrayList<Simple> s){
        b = s;
    }

    @Override
    public void pintar() {
        for (Bloque l: b)
            l.pintar();
    }

    @Override
    public void eliminar() {
        for (Bloque l: b)
            l.eliminar();
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        float mayor = 0;
        for (Simple s: b)
            if (s.getY() >= mayor)
                mayor = s.getY();
        return mayor;
    }

    @Override
    public void AddX() {
        for (Bloque l: b)
            l.AddX();
    }

    @Override
    public void AddY() {
        for (Bloque l: b)
            l.AddY();
    }

    @Override
    public boolean choca(ArrayList<Bloque> b) {
        for (Bloque m: b)
            if(m.choca(b))
                return true;
        return false;
    }
}
