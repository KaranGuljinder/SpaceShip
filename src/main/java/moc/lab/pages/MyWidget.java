package moc.lab.pages;

import java.io.IOException;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.microui.display.Display;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.style.Style;
import ej.style.container.Rectangle;
import ej.widget.StyledWidget;

/**
 * A personalised widget.
 */
public class MyWidget extends StyledWidget {

	public static int imageX;
	public static int imageY;
	public int meteoriteY;
	public int meteoriteX;
	private Image microejImage;
	private Image background;
	int hideMeteorite = 0;
	public static int spaceMouv = 0;
	public static Image spaceship;
	public static Image meteorite;
	public int aleatoireX = 0;
	public int aleatoireY = 0;
	public int aleatoireMouvX = 0;
	public int betweenMeteorite = 0;
	public int betweenMeteorite2 = 0;
	public int positionX[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public int positionY[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int bottomLimit = 0;
	int ABSOLUTE_INCREMENT = 2;
	int verticalIncrement = this.ABSOLUTE_INCREMENT;
	int horizontalIncrement = this.ABSOLUTE_INCREMENT;

	// private final int event = 50528512;
	private static final int ANIMATION_PERIOD = 10; // in ms - 60 frames per second
	static Display display = Display.getDefaultDisplay();

	public MyWidget() {
		try {
			this.background = Image.createImage("/images/space.png");
			this.spaceship = Image.createImage("/images/ship.png");
			this.meteorite = Image.createImage("/images/meteorite.png");
			int animatedImageHalfHeight = display.getHeight();
			System.out.println("Height : " + animatedImageHalfHeight);
			this.imageX = this.display.getWidth() / 2 - this.spaceship.getWidth() / 2;
			this.imageY = this.display.getHeight() / 2 - this.spaceship.getHeight() / 2;
			this.bottomLimit = animatedImageHalfHeight;
			this.meteoriteY = display.getWidth() / 2;
			this.meteoriteX = display.getHeight() / 2;
			this.meteoriteY = 1;
			this.aleatoireMouvX = this.display.getWidth() / 2 - this.spaceship.getWidth() / 2;

		} catch (IOException e) {
			e.printStackTrace();
		}

		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MyWidget.this.meteoriteY += MyWidget.this.verticalIncrement;
				MyWidget.this.aleatoireMouvX += MyWidget.this.horizontalIncrement;
				if (MyWidget.this.meteoriteY < MyWidget.this.bottomLimit) {
					MyWidget.this.verticalIncrement = MyWidget.this.ABSOLUTE_INCREMENT;
					MyWidget.this.horizontalIncrement = MyWidget.this.ABSOLUTE_INCREMENT;
				} else {
					MyWidget.this.meteoriteY = 1;
					MyWidget.this.aleatoireMouvX = 0 + (int) (Math.random() * ((400 - 0) + 1));
					MyWidget.this.betweenMeteorite = 0 + (int) (Math.random() * ((150 - 0) + 1));
					MyWidget.this.betweenMeteorite2 = 0 + (int) (Math.random() * ((150 - 0) + 1));
				}

				repaint();

			}
		}, ANIMATION_PERIOD, ANIMATION_PERIOD);
	}

	public void displayMeteorite(GraphicsContext g, int max) {
		for (int i = 0; i < max; i++) {
			if (spaceMouv == 0) {
				this.aleatoireX = 0 + (int) (Math.random() * ((400 - 0) + 1));
				this.aleatoireY = 0 + (int) (Math.random() * ((250 - 0) + 1));
				this.positionX[i] = this.aleatoireX;
				this.positionY[i] = this.aleatoireY;
			}
			g.drawImage(this.meteorite, this.positionX[i], this.positionY[i],
					GraphicsContext.TOP | GraphicsContext.LEFT);
		}
	}

	public void displayMeteoriteMouvement(GraphicsContext g, int max) {
		g.drawImage(this.meteorite, this.aleatoireMouvX, this.meteoriteY, GraphicsContext.TOP | GraphicsContext.LEFT);
		g.drawImage(this.meteorite, this.aleatoireMouvX + this.betweenMeteorite, this.meteoriteY,
				GraphicsContext.TOP | GraphicsContext.LEFT);
		g.drawImage(this.meteorite, this.aleatoireMouvX - this.betweenMeteorite2, this.meteoriteY,
				GraphicsContext.TOP | GraphicsContext.LEFT);

	}

	public void collision() {
		for (int i = 0; i < 10; i++) {
			if (this.positionX[i] == imageX && this.positionY[i] == imageY) {
				System.out.println("Collision");
			}
		}
	}

	@Override
	public void renderContent(GraphicsContext g, Style style, Rectangle bounds) {
		// TODO Auto-generated method stub
		g.drawImage(this.background, 0, 0, GraphicsContext.TOP | GraphicsContext.LEFT);
		g.drawImage(this.background, 200, 0, GraphicsContext.TOP | GraphicsContext.LEFT);
		g.drawImage(this.background, 0, 200, GraphicsContext.TOP | GraphicsContext.LEFT);
		g.drawImage(this.background, 200, 200, GraphicsContext.TOP | GraphicsContext.LEFT);
		g.drawImage(this.spaceship, imageX, imageY, GraphicsContext.TOP | GraphicsContext.LEFT);
		displayMeteoriteMouvement(g, 3);
		displayMeteorite(g, 10);
		spaceMouv = 1;

	}

	@Override
	public Rectangle validateContent(Style style, Rectangle bounds) {
		Rectangle rectange = new Rectangle(bounds);
		return rectange;
	}

	@Override
	public boolean handleEvent(int event) {
		// TODO Auto-generated method stub
		boolean eventProcessed = false;

		// Gets the type of event.
		final int type = Event.getType(event);

		if (Event.getType(event) == Event.POINTER) {
			Pointer pointer = (Pointer) Event.getGenerator(event);
			this.imageX = pointer.getX();
			this.imageY = pointer.getY();
			eventProcessed = true;
		}

		return eventProcessed;
	}

}
