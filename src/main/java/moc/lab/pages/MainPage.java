package moc.lab.pages;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.widget.basic.Button;
import ej.widget.container.List;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

/**
 *
 */
public class MainPage extends Page {

	public static void show(Page PP) {
		MyActivity.transition.show(PP, false);
	}

	public static void gamePage() {
		MyActivity.transition.show(new GamePage(), false);

	}

	public static void highscorePage() {
		MyActivity.transition.show(new HighScorePage(), false);

	}

	public static void levelPage() {
		MyActivity.transition.show(new LevelPage(), false);

	}

	Button bt1 = new Button("Play !");
	Button bt2 = new Button("Highscore !");
	Button bt3 = new Button("Level !");
	Button bt4 = new Button("Quit !");

	List list = new List(false);

	/**
	 *
	 */
	public MainPage() {

		this.bt1.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				MainPage.gamePage();
			}
		});

		this.bt2.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				MainPage.highscorePage();

			}
		});

		this.bt3.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				MainPage.levelPage();

			}
		});

		this.bt4.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ExitHandler exitHandler = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				if (exitHandler != null) {
					exitHandler.exit();
				}
			}
		});

		this.list.add(this.bt1);
		this.list.add(this.bt2);
		this.list.add(this.bt3);
		this.list.add(this.bt4);
		setWidget(this.list);
	}
}
