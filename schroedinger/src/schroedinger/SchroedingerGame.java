package schroedinger;

import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import schroedinger.script.pnj.Newton;
import schroedinger.util.DialogIndexes;

import IHM.IHMDialog;
public class SchroedingerGame extends BasicGame
{

	TiledMap map;
	Music music;
	
	private IHMDialog ihm;
	private int width = 800;
	private int height = 600;

	public SchroedingerGame()
	{
		super("Schroedinger");
	}

	public SchroedingerGame(int width,int height)
	{
		super("Schroedinger");
		this.width = width;
		this.height = height;
		try {
			music = new Music("./music/Ville.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		music.loop();
		try {
			map = new TiledMap("img/map.tmx","img");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException
	{

		//
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		if (!World.ffad.actionStopped) {
			World.ffad.incClock(delta);
		}
		World.ffad.actionStopped = false;
		if (World.ffad.currentDialog != null && ihm == null) {
			World.ffad.actionStopped = true;
			List<DialogIndexes> d = World.ffad.currentDialog.answer(World.ffad.lastAnswer);
			if (d != null) {
				ihm = new IHMDialog(this,
						d,
						Newton.getID());  
				ihm.init(gc);
			}
		}
		
		if (ihm != null && ihm.isAnswered()) {
			World.ffad.lastAnswer = ihm.getAnswerIndex();
			ihm = null;
		}
		if (ihm != null) {
			ihm.update(gc, delta);
		}
		if (World.ffad.currentDialog != null && World.ffad.currentDialog.isOver()) {
			World.ffad.currentDialog = null;
		}
		World.ffad.newton.update();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if (ihm != null) {
			ihm.render(gc, g);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static void main(String[] args) throws SlickException
	{
		SchroedingerGame hw = new SchroedingerGame(800,500);
		AppGameContainer app = new AppGameContainer(hw);

		app.setDisplayMode(hw.getWidth(),hw.getHeight(), false);
		app.start();
	}

	public void keyPressed(int key, char c) {
		switch(key) {
		case Input.KEY_ESCAPE:
			System.exit(0);
			break;
		}
		if (ihm != null) {
			ihm.keyPressed(key, c);
		}
	}

}

