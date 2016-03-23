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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class main extends TimerTask implements Runnable {

	public ArrayList<String> img = new ArrayList<>();
	public Label lblNewLabel;
	public Label lblNewLabel_1;
	public Label lblNewLabel_2;
	public Label lblNewLabel_3;
	SoundClipTest st;
	int[] n = new int[4];

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtBet;
	private Label txtVincita;
	private Label label;
	private double credito = 100;
	private double vincita;
	private double bet;
	private String title;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
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
		//st.sound("/slot/inizio.wav");
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
		shell.setSize(1117, 500);
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
				

				if (credito == 0) {
					JOptionPane.showMessageDialog(null, "HAI PERSO!");
				} else {
					try {
						bet = Double.parseDouble(txtBet.getText());
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block						
						JOptionPane.showMessageDialog(null, "SCOMMETTI!!!!");
						bet = 10;
					}

					System.out.println("BET: " + txtBet.getText());

					Thread thread = new Thread() {
						public void run() {
							Display.getDefault().asyncExec(new Runnable(){
								public void run(){
									//st.sound("/slot/giro.wav");									
								}
							});
							// TODO Auto-generated method stub
							for (int i = 0; i < 40; i++) {
								// TODO Auto-generated method stub
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										n[0] = (int) (Math.random() * 9);
										lblNewLabel.setImage(SWTResourceManager.getImage(main.class, img.get(n[0])));
										n[1] = (int) (Math.random() * 9);
										lblNewLabel_1.setImage(SWTResourceManager.getImage(main.class, img.get(n[1])));
										n[2] = (int) (Math.random() * 9);
										lblNewLabel_2.setImage(SWTResourceManager.getImage(main.class, img.get(n[2])));
										n[3] = (int) (Math.random() * 9);
										lblNewLabel_3.setImage(SWTResourceManager.getImage(main.class, img.get(n[3])));
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

							n[0] = (int) (Math.random() * 9);
							n[1] = (int) (Math.random() * 9);
							n[2] = (int) (Math.random() * 9);
							n[3] = (int) (Math.random() * 9);
							

							Display.getDefault().asyncExec(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									lblNewLabel.setImage(SWTResourceManager.getImage(main.class, img.get(n[0])));
									lblNewLabel_1.setImage(SWTResourceManager.getImage(main.class, img.get(n[1])));
									lblNewLabel_2.setImage(SWTResourceManager.getImage(main.class, img.get(n[2])));
									lblNewLabel_3.setImage(SWTResourceManager.getImage(main.class, img.get(n[3])));
								}

							});

							vincita = vincit(n, bet);
							if (vincita == 0) {
								credito = credito - bet;
							} else {
								credito = credito + vincita;
							}
							Display.getDefault().asyncExec(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									System.out.println(credito);
									label.setText("" + credito);
								}
							});

						}
					};

					thread.start();
				}
			}
		});
		btnGira.setBounds(995, 10, 75, 25);
		btnGira.setText("GIRA!");

		lblNewLabel = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel.setBounds(10, 10, 234, 358);

		lblNewLabel_1 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_1.setBounds(250, 10, 234, 358);

		lblNewLabel_2 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_2.setBounds(490, 10, 234, 358);

		lblNewLabel_3 = formToolkit.createLabel(shell, "", SWT.NONE);
		lblNewLabel_3.setBounds(730, 10, 234, 358);

		Button btnBetMax = new Button(shell, SWT.NONE);
		btnBetMax.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bet=credito;
				txtBet.setText(Double.toString(credito));
			}
		});
		btnBetMax.setBounds(995, 70, 75, 25);
		formToolkit.adapt(btnBetMax, true, true);
		btnBetMax.setText("Bet Max");

		Button btnBetOne = new Button(shell, SWT.NONE);
		btnBetOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bet=1;
				txtBet.setText("1");
			}
		});
		btnBetOne.setBounds(995, 130, 75, 25);
		formToolkit.adapt(btnBetOne, true, true);
		btnBetOne.setText("Bet One");

		Button btnReset = new Button(shell, SWT.NONE);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				credito = 100;
				bet = 0;
				vincita = 0;
				txtVincita.setText(" ");
				txtBet.setText(" ");

			}
		});
		btnReset.setBounds(995, 191, 75, 25);
		formToolkit.adapt(btnReset, true, true);
		btnReset.setText("Reset");

		Label lblCredito = new Label(shell, SWT.NONE);
		lblCredito.setBounds(29, 408, 52, 15);
		formToolkit.adapt(lblCredito, true, true);
		lblCredito.setText("Credito: ");

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

		txtVincita = new Label(shell, SWT.BORDER);
		txtVincita.setBounds(374, 402, 76, 21);
		formToolkit.adapt(txtVincita, true, true);

		label = new Label(shell, SWT.NONE);
		label.setBounds(81, 408, 55, 15);
		formToolkit.adapt(label, true, true);

		label.setText("" + credito);

	}

	public double vincit(int[] n, double b) {
		double vin = 0;
		int coppie = 0;
		boolean find = false;
		int n_find=0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (n[i] == n[j]) {
					find = true;
					n_find = i;
					break;
				}
			}
		}
		
		if(find == true){
			for(int i=0;i<4;i++){
				if (n[n_find] == n[i]){
					coppie++;
				}
			}
		}
		
		coppie--;


		if (coppie == 0) {
			vin = 0;
		}
		if (coppie == 1) {
			vin = b * 0.2;
			System.out.println("coppia");
		}
		if (coppie == 2) {
			vin = b * 0.5;
			System.out.println("tris");
		}
		if (coppie == 3) {
			vin = b;
			//st.sound("/slot/vittoria.wav");
			System.out.println("figata");
		}
		System.out.println("vin: " + vin);
		return vin;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}