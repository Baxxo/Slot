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
import org.eclipse.swt.widgets.Text;

public class main extends TimerTask implements Runnable {

	public ArrayList<String> img = new ArrayList<>();
	public Label lblNewLabel;
	public Label lblNewLabel_1;
	public Label lblNewLabel_2;
	private int cont;

	int n;

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtCredito;
	private Text txtBet;
	private Text txtVincita;

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
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				//
				///
				//
				///
				//
				//
				///
				//
				//
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
		
		Button btnBetMax = new Button(shell, SWT.NONE);
		btnBetMax.setBounds(899, 46, 75, 25);
		formToolkit.adapt(btnBetMax, true, true);
		btnBetMax.setText("Bet Max");
		
		Button btnBetOne = new Button(shell, SWT.NONE);
		btnBetOne.setBounds(899, 86, 75, 25);
		formToolkit.adapt(btnBetOne, true, true);
		btnBetOne.setText("Bet One");
		
		Button btnPayTable = new Button(shell, SWT.NONE);
		btnPayTable.setBounds(899, 125, 75, 25);
		formToolkit.adapt(btnPayTable, true, true);
		btnPayTable.setText("Pay Table");
		
		Button btnReset = new Button(shell, SWT.NONE);
		btnReset.setBounds(899, 166, 75, 25);
		formToolkit.adapt(btnReset, true, true);
		btnReset.setText("Reset");
		
		Label lblCredito = new Label(shell, SWT.NONE);
		lblCredito.setBounds(29, 408, 52, 15);
		formToolkit.adapt(lblCredito, true, true);
		lblCredito.setText("Credito: ");
		
		txtCredito = new Text(shell, SWT.BORDER);
		txtCredito.setBounds(79, 402, 76, 21);
		formToolkit.adapt(txtCredito, true, true);
		
		Label lblBet = new Label(shell, SWT.NONE);
		lblBet.setBounds(185, 408, 35, 15);
		formToolkit.adapt(lblBet, true, true);
		lblBet.setText("Bet: ");
		
		txtBet = new Text(shell, SWT.BORDER);
		txtBet.setBounds(215, 402, 76, 21);
		formToolkit.adapt(txtBet, true, true);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(320, 408, 52, 15);
		formToolkit.adapt(lblNewLabel_3, true, true);
		lblNewLabel_3.setText("Vincita: ");
		
		txtVincita = new Text(shell, SWT.BORDER);
		txtVincita.setBounds(374, 402, 76, 21);
		formToolkit.adapt(txtVincita, true, true);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}