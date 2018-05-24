package moc.lab.pages;

import ej.widget.basic.Button;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;

/**
 *
 */
public class MainPage extends Page {
	Button bt1 = new Button("Coucou");
	Button bt2 = new Button("Exit");
	Split split = new Split(false, 0.75f);

	/**
	 *
	 */
	public MainPage() {

		this.bt1.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("Cliqué !");
			}
		});

		this.bt2.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("Exit !");
			}
		});

		this.split.setFirst(this.bt1);
		this.split.setLast(this.bt2);
		setWidget(this.split);
	}
}
