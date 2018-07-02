/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package moc.lab.pages;

import ej.widget.basic.Button;
import ej.widget.container.List;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

/**
 *
 */
public class LevelPage extends Page {

	public static void show(Page PP) {
		MyActivity.transition.show(PP, false);
	}

	public static void homePage() {
		MyActivity.transition.show(new MainPage(), false);

	}

	public static int level = 1;
	List list = new List(false);
	Button buttonEasy = new Button("Easy");
	Button buttonMedium = new Button("Medium");
	Button buttonHard = new Button("Hard");
	Button buttonReturn = new Button("Retour");

	public LevelPage() {

		this.buttonEasy.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				level = 1;
			}
		});

		this.buttonMedium.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				level = 2;
			}
		});

		this.buttonHard.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				level = 3;
			}
		});

		this.buttonReturn.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				LevelPage.homePage();
			}
		});
		this.list.add(this.buttonEasy);
		this.list.add(this.buttonMedium);
		this.list.add(this.buttonHard);
		this.list.add(this.buttonReturn);
		setWidget(this.list);
	}
}
