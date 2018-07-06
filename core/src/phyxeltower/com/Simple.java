package phyxeltower.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Simple implements Bloque {
    private Texture t;
    private SpriteBatch sp;
    private float x;
    private float y;

    public Simple(float i,float j, int color){
        switch (color){
            case 0: t = new Texture("BloqueAmarillo.png");
                break;
            case 1: t = new Texture("BloqueAzul.png");
                break;
            case 2: t = new Texture("BloqueBlanco.png");
                break;
            case 3: t = new Texture("BloqueMorado.png");
                break;
            case 4: t = new Texture("BloqueNaranja.png");
                break;
            case 5: t = new Texture("BloqueRojo.png");
                break;
            case 6: t = new Texture("BloqueRosa.png");
                break;
            case 7: t = new Texture("BloqueVerde.png");
                break;
            case 8: t = new Texture("BloquePiso.png");
        }
        this.x = i - 16;
        this.y = j - 16;
        this.sp = new SpriteBatch();
    }

    @Override
    public float getX(){
        return this.x;
    }

    @Override
    public float getY(){
        return this.y;
    }

    @Override
    public void AddX(){
        x += 1;
    }

    @Override
    public void AddY(){
        y += 1;
    }

    @Override
    public void pintar(){
        sp.begin();
        sp.draw(t,x,y);
        sp.end();
    }

    @Override
    public void eliminar(){
        t.dispose();
    }

    @Override
    public boolean choca(ArrayList<Bloque> b){
        for (Bloque l: b)
            if((this.y+16) == (l.getY()-16) && (this.x+16 >= l.getX()-16) && (this.x-16 <= l.getX()+16))
                return true;
        return false;
    }
}
