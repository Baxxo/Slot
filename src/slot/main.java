package slot;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;

import java.awt.Image;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class main extends TimerTask implements Runnable {

	public ArrayList<String> img = new ArrayList<>();
	public Label lblNewLabel;
	public Label lblNewLabel_1;
	public Label lblNewLabel_2;
	private int cont;

	int n;

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TimerTask timerTask = new TimerTaskExample();
		Timer timer = new Timer(true);
		// timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
		try {
			main window = new main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1000, 500);
		shell.setText("SWT Application");

		img.add("/slot/bar.png");
		img.add("/slot/campana.png");
		img.add("/slot/cilieg.png");
		img.add("/slot/corons.png");
		img.add("/slot/fero.png");
		img.add("/slot/foia.png");
		img.add("/slot/inguria.png");
		img.add("/slot/prugna.png");
		img.add("/slot/ua.png");

		Button btnGira = new Button(shell, SWT.NONE);
		btnGira.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {

				Thread thread = new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for (int i = 0; i < 10; i++) {
							// TODO Auto-generated method stub
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									n = (int) (Math.random() * 9);
									lblNewLabel.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
									n = (int) (Math.random() * 9);
									lblNewLabel_1.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
									n = (int) (Math.random() * 9);
									lblNewLabel_2.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
								}
							});
							try {
								Thread.sleep(80);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								Thread.currentThread().interrupt();
							}
							System.out.println(i);
						}

					}
				};

				thread.start();	

				System.out.println(thread.getName());
				
				//PROBLEMA!!!!!!!!!!!!!!!!
				
				
				if (cont != 10) {
					System.out.println("cont: " + cont);
					n = (int) (Math.random() * 9);
					lblNewLabel.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
					n = (int) (Math.random() * 9);
					lblNewLabel_1.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
					n = (int) (Math.random() * 9);
					lblNewLabel_2.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
					cont++;
				} else {
					n = (int) (Math.random() * 9);
					lblNewLabel.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
					lblNewLabel_1.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
					lblNewLabel_2.setImage(SWTResourceManager.getImage(main.class, img.get(n)));
					cont = 0;
				}	

			}
		});
		btnGira.setBounds(899, 10, 75, 25);
		btnGira.setText("GIRA!");

		lblNewLabel = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel.setBounds(10, 10, 256, 358);

		lblNewLabel_1 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_1.setBounds(272, 10, 234, 358);

		lblNewLabel_2 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_2.setBounds(512, 10, 234, 358);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}