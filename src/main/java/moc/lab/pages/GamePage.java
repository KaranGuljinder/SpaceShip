/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package moc.lab.pages;

import ej.widget.basic.Button;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;
import moc.lab.MyWidget;

/**
 *
 */
public class GamePage extends Page {

	public static boolean isButtonPressed = false;

	public static void show(Page PP) {
		MyActivity.transition.show(PP, false);
	}

	public static void goMenu() {
		MyActivity.transition.show(new MainPage(), false);

	}

	Split split = new Split(false, 0.85f);
	Button buttonReturn = new Button("Retour");

	public GamePage() {

		this.buttonReturn.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				isButtonPressed = true;
				MyWidget.spaceMouv = 0;
				GamePage.goMenu();
			}
		});

		MyWidget widget = new MyWidget();
		this.split.setFirst(widget);
		this.split.setLast(this.buttonReturn);
		setWidget(this.split);
	}
}
