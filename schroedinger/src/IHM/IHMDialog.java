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

import schroedinger.SchroedingerGame;
import schroedinger.util.DialogIndexes;

public class IHMDialog extends BasicGame {

	private static int portraitSize = 128;
	

	private List<DialogIndexes> dialog;

	private List<String> question;
	private List<String> answers;
	private List<String> lines;

	final static int LINES_SHOWN = 6; 
	
	private boolean answered = false;

	private int answerIndex = 0;

	private int limitIndex = 0;

	private int renderLine = 0;
	private boolean goNextDialogPage = false;

	private Font font;
	private int width = 800 - portraitSize;
	private Color box = new Color(1f,1f,1f,0.45f);
	private int height = 600;

	public boolean isAnswered() { return answered; }

	public int getAnswerIndex() { return answerIndex; } 

	public IHMDialog() {
		super("IHMDialog");
	}

	public IHMDialog(SchroedingerGame schroedingerGame,List<DialogIndexes> dialog) {
		super("IHMDialog");
		width = schroedingerGame.getWidth() - portraitSize;
		height = schroedingerGame.getHeight();
		this.dialog = dialog;
	}

	//initialize the game and dialog box
	public void init(GameContainer c) throws SlickException {
		font = c.getDefaultFont();
		//create a list of lines based on the above text
		question = wrap(dialog.get(0).message, font, width);
		if (dialog.size() == 1) {
			answers = null;
		} else {
			for (DialogIndexes diag : dialog) {
				answers.add(diag.message);
			}
			answers.remove(0);
		}
		lines = question;
	}

	//render the dialog box
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		if (lines == null) {
			return;
		}
		
		int x = portraitSize;
		int y = height - portraitSize;

		g.setColor(box);
		g.fillRect(x, y, width, height - y);

		g.setColor(Color.white);
		int lineHeight = font.getLineHeight();

		//only render the rows we have typed out so far (renderRow = current row)
		int i;
		//for (i=renderLine; i<lines.size() && y < height-lineHeight; i++) {
		for (i=renderLine; i<lines.size() && i - renderLine < LINES_SHOWN; i++) {	
			g.drawString(lines.get(i), x, y);
			y += lineHeight;
		}
		
		g.drawString("SPACE to restart, ENTER to show all", 10, 40);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (answered) {
			//
			System.out.println(answerIndex);
		}
		if (goNextDialogPage) {

			goNextDialogPage= false;
			renderLine++;
			if (renderLine + LINES_SHOWN >=  lines.size()) {
				if (lines.equals(answers))
					// Destroy !

					renderLine=0;
				lines=answers;

			}
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

	private void setAnswerIndex(int index) {
		if (index < limitIndex + 1 && index > 0) {
			answered = true;
			answerIndex = index;
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		switch(key) {
		case Input.KEY_ENTER:
			goNextDialogPage=true;
			break;
		case Input.KEY_1:
		case Input.KEY_NUMPAD1:
			setAnswerIndex(1);
			break;
		case Input.KEY_2:
		case Input.KEY_NUMPAD2:
			setAnswerIndex(2);
			break;
		case Input.KEY_3:
		case Input.KEY_NUMPAD3:
			setAnswerIndex(3);
			break;
		case Input.KEY_4:
		case Input.KEY_NUMPAD4:
			setAnswerIndex(4);
			break;
		case Input.KEY_5:
		case Input.KEY_NUMPAD5:
			setAnswerIndex(5);
			break;
		case Input.KEY_6:
		case Input.KEY_NUMPAD6:
			setAnswerIndex(6);
			break;
		default:
		}
	}

}
