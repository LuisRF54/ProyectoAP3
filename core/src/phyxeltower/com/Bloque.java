package phyxeltower.com;

import java.util.ArrayList;

public interface Bloque {
    void pintar();
    void eliminar();
    float getX();
    float getY();
    void AddX();
    void AddY();
    boolean choca(ArrayList<Bloque> b);
}
