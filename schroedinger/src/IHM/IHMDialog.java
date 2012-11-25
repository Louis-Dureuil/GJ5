package IHM;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class IHMDialog extends BasicGame {
   
    private static int portraitSize = 128;
	String question;
	List<String> answers;
	/**
     * Entry point to our test
     *
     * @param argv The arguments passed to the test
     */
    public static void main(String[] argv) {
        /*try {
            AppGameContainer container = new AppGameContainer(new IHMDialog());
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }*/
    }
   
    private List<String> lines;
    private Font font;
    private int width = 800 - portraitSize;
    private Color box = new Color(1f,1f,1f,0.45f);
   
    public IHMDialog(HelloWorld helloWorld) {
        super("IHMDialog");
        width = helloWorld.getWidth() - portraitSize;
	}

	//initialize the game and dialog box
    @Override
    public void init(GameContainer c) throws SlickException {
        font = c.getDefaultFont();
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing "
                + "elit. Mauris commodo erat lectus. \n\nNullam id magna erat, "
                + "lacinia vulputate nulla. Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit.";

        //create a list of lines based on the above text
        lines = wrap(text, font, width);
    }
    
    public void init(GameContainer c,String text) throws SlickException {
        font = c.getDefaultFont();
        //create a list of lines based on the above text
        lines = wrap(text, font, width);
    }
   
    //render the dialog box
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        int x = portraitSize;
        int y = 600 - portraitSize;
       
        g.setColor(box);
        g.fillRect(x, y, width, 600 - y);
       
        g.setColor(Color.white);
        int lineHeight = font.getLineHeight();
       
        //only render the rows we have typed out so far (renderRow = current row)
        for (int i=0; i<lines.size(); i++) {
        	g.drawString(lines.get(i), x, y);
            y += lineHeight;
        }
       
        g.drawString("SPACE to restart, ENTER to show all", 10, 40);
    }
   
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	
    }
    
    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_ESCAPE) {
            System.exit(0);
        }
    }
    
    //Wraps the given string into a list of split lines based on the width
    private List<String> wrap(String text, Font font, int width) {
        //A less accurate but more efficient wrap would be to specify the max
        //number of columns (e.g. using the width of the 'M' character or something).
        //The below method will look nicer in the end, though.
       
        List<String> list = new ArrayList<String>();
        String str = text;
        String line = "";
       
        //we will go through adding characters, once we hit the max width
        //we will either split the line at the last space OR split the line
        //at the given char if no last space exists
       
        //while we still have text to check
        int i = 0;
        int lastSpace = -1;
        while (i<str.length()) {
            char c = str.charAt(i);
            if (Character.isWhitespace(c))
                lastSpace = i;
           
            //time to wrap
            if (c=='\n' || font.getWidth(line + c) > width) {
                //if we've hit a space recently, use that
                int split = lastSpace!=-1 ? lastSpace : i;
                int splitTrimmed = split;
               
                //if we are splitting by space, trim it off for the start of the
                //next line
                if (lastSpace!=-1 && split<str.length()-1) {
                   splitTrimmed++;
                }
               
                line = str.substring(0, split);
                str = str.substring(splitTrimmed);
               
                //add the line and reset our values
                list.add(line);
                line = "";
                i = 0;
                lastSpace = -1;
            }
            //not time to wrap, just keep moving along
            else {
                line += c;
                i++;
            }
        }
        if (str.length()!=0)
            list.add(str);
        return list;
    }
}
