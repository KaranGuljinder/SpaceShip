package moc.lab;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Desktop;
import ej.mwt.MWT;
import ej.mwt.Panel;
import ej.style.Stylesheet;
import ej.style.border.SimpleRectangularBorder;
import ej.style.outline.SimpleOutline;
import ej.style.selector.TypeSelector;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import ej.widget.basic.Button;
import ej.widget.container.transition.SlideScreenshotTransitionContainer;
import ej.widget.container.transition.TransitionContainer;
import moc.lab.pages.MainPage;

/**
 *
 */
public class MyActivity implements Activity {

	public static TransitionContainer transition;

	private void InitializeStyle() {
		Stylesheet sts = StyleHelper.getStylesheet();
		EditableStyle st1 = new EditableStyle();

		st1.setMargin(new SimpleOutline(5));
		st1.setPadding(new SimpleOutline(5));
		st1.setBorder(new SimpleRectangularBorder(3));
		st1.setBorderColor(Colors.MAGENTA);
		st1.setBackgroundColor(Colors.NAVY);
		st1.setAlignment(GraphicsContext.VCENTER | GraphicsContext.HCENTER);
		st1.setForegroundColor(Colors.YELLOW);

		sts.addRule(new TypeSelector(Button.class), st1);
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		MicroUI.start();
		InitializeStyle();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		transition = new SlideScreenshotTransitionContainer(MWT.LEFT, false, false);
		transition.show(new MainPage(), false);
		panel.setWidget(transition);
		panel.showFullScreen(desktop);
		desktop.show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}
}
