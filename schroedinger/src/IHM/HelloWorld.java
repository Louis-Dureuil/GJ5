package IHM;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


import org.newdawn.slick.*;

import IHM.IHMDialog;


public class HelloWorld extends BasicGame
{
	
	private IHMDialog ihm;
	private int width = 800;
	private int height = 600;

  public HelloWorld()
  {
     super("Hello World");
  }
  
  public HelloWorld(int width,int height)
  {
     super("Hello World");
     this.width = width;
     this.height = height;
  }

  @Override
  public void init(GameContainer gc) throws SlickException
  {
	  ihm = new IHMDialog(this);
	  ihm.init(gc);
  }

  @Override
  public void update(GameContainer gc, int delta) throws SlickException
  {

  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
     g.drawString("Hello World", 100, 100);
     ihm.render(gc, g);
     
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
	 HelloWorld hw = new HelloWorld(800,600);
     AppGameContainer app = new AppGameContainer(hw);

     app.setDisplayMode(hw.getWidth(),hw.getHeight(), false);
     app.start();
  }


}

