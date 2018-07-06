package phyxeltower.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;


public class MainGame extends ApplicationAdapter{

	private ArrayList<Bloque> t;
	private ArrayList<Bloque> piso;
	private int i;
	private boolean gameover;
	private int l;

	@Override
	public void create() {
		t = new ArrayList<Bloque>();
		piso = new ArrayList<Bloque>();
		l = Gdx.graphics.getWidth();
		for (int i = 0; i < 5; i++) {
			piso.add(new Simple((l/32*10)+(i*32), Gdx.graphics.getHeight()-16, 8));
		}
		i = 7;
		gameover = false;
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.1f,0.4f,0.4f,1);
		if (!gameover) {
			if (Gdx.input.justTouched() && (Gdx.graphics.getHeight() - Gdx.input.getY() <= 120)){
				t.add(new Simple(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),i));
				if (i == 7)
					i = 0;
				else
					i++;
			}
			for (Bloque p : piso)
				p.pintar();
			for (Bloque l : t) {
				l.pintar();
				if ((l.getY() + 32 <= Gdx.graphics.getHeight()) && (!l.choca(t)) && (!l.choca(piso))) {
					l.AddY();
					if (l.getY() + 32 == Gdx.graphics.getHeight())
						gameover = true;
				}
			}
		}
		else{
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			Gdx.gl.glClearColor(0,0,0,1);
			if(Gdx.input.justTouched()) {
				for (Bloque l : t) {
					l.eliminar();
				}
				t = new ArrayList<Bloque>();
				gameover = false;
			}
		}
	}

	@Override
	public void dispose() {
		for (Bloque l : t) {
			l.eliminar();
		}
		for (Bloque j : piso)
			j.eliminar();
		t.clear();
		piso.clear();
	}
}
