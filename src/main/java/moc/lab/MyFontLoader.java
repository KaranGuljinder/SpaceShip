package moc.lab;

import ej.style.font.FontProfile;
import ej.style.font.loader.AbstractFontLoader;

/**
 *
 */
public class MyFontLoader extends AbstractFontLoader {

	@Override
	protected int getFontHeight(FontProfile fontProfile) {
		switch (fontProfile.getSize()) {
		case LARGE:
			return 50;
		case MEDIUM:
		case SMALL:
		default:
			return 30;
		}
	}
}
