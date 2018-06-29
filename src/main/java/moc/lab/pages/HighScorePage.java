/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package moc.lab.pages;

import ej.widget.basic.Button;
import ej.widget.basic.Label;
import ej.widget.container.List;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

/**
 *
 */
public class HighScorePage extends Page {

	public static void show(Page PP) {
		MyActivity.transition.show(PP, false);
	}

	public static void goMenu() {
		MyActivity.transition.show(new MainPage(), false);

	}

	List list = new List(false);
	Label title = new Label("Highscore");
	Button buttonReturn = new Button("Retour");
	Label data1 = new Label("322");
	Label data2 = new Label("250");
	Label data3 = new Label("110");
	Label data4 = new Label("89");

	public HighScorePage() {

		this.buttonReturn.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {

				HighScorePage.goMenu();
			}
		});
		this.list.add(this.title);
		if (MyWidget.scoreDisplay != null) {
			Label score = new Label(MyWidget.scoreDisplay);
			this.list.add(score);
		}
		this.list.add(this.data1);
		this.list.add(this.data2);
		this.list.add(this.data3);
		this.list.add(this.data4);
		this.list.add(this.buttonReturn);
		setWidget(this.list);
	}

}
