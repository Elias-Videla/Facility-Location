package interfazVisual;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Mapa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa window = new Mapa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mapa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 980, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setOpaque(false);
		panelOpciones.setBackground(new Color(46, 139, 87));
		panelOpciones.setBounds(732, 30, 238, 234);
		panelOpciones.setVisible(false);
		frame.getContentPane().add(panelOpciones);
		panelOpciones.setLayout(null);
		
		JLabel lblHola = new JLabel("");
		lblHola.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Contenedor.png")));
		lblHola.setBounds(0, 0, 238, 234);
		panelOpciones.add(lblHola);
		panelOpciones.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseExited( MouseEvent arg0 ) 
			{
				panelOpciones.setVisible(false);
			}
		} );
		
		JLabel lblO = new JLabel("O");
		lblO.setBounds(947, 30, 23, 39);
		frame.getContentPane().add(lblO);
		lblO.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblO.setBackground(new Color(0, 0, 255));
		lblO.addMouseMotionListener( new MouseMotionAdapter() {
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				panelOpciones.setVisible(true);

			}
		} );
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Mapa.jpg")));
		label.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(label);
		frame.setUndecorated(true);
	}
}
