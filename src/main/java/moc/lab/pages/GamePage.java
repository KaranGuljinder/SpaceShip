/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package moc.lab.pages;

import ej.widget.container.Split;
import ej.widget.navigation.page.Page;

/**
 *
 */
public class GamePage extends Page {

	Split split = new Split(false, 0.999f);

	public GamePage() {

		MyWidget widget = new MyWidget();
		this.split.setFirst(widget);
		setWidget(this.split);
		// setWidget(widget);
	}

}
