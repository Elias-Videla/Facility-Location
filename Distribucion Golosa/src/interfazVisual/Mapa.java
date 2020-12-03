package interfazVisual;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Mapa {

	private JFrame frame;
	private JLabel tuerca;
	private ButtonGroup botonGroupClientes;
	private ButtonGroup botonGroupCentros;
	//private ImageIcon[] chinchesClientes;
	private JLabel chinchesClientes1, chinchesClientes2, chinchesClientes3, chinchesClientes4;
	private JLabel chinchesCentros1, chinchesCentros2, chinchesCentros3;

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
	public Mapa() 
	{
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
//		chinchesClientes = new ImageIcon[4];
//		chinchesClientes[0] = new ImageIcon(Mapa.class.getResource("/imagenes/clientes-1.png"));
//		chinchesClientes[1] = new ImageIcon(Mapa.class.getResource("/imagenes/clientes-2.png"));
//		chinchesClientes[2] = new ImageIcon(Mapa.class.getResource("/imagenes/clientes-3.png"));
		//chinchesClientes[3] = new ImageIcon(Mapa.class.getResource("/imagenes/clientes-4.png"));
		ManejoArchivos archivos = new ManejoArchivos();
		archivos.descargarArchivoCentros();
		archivos.descargarArchivoClientes();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 980, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setOpaque(false);
		panelOpciones.setBackground(new Color(46, 139, 87));
		panelOpciones.setBounds(732, 30, 238, 234);
		panelOpciones.setVisible(false);
		
		
		tuerca = new JLabel("");
		tuerca.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				panelOpciones.setVisible(true);
				tuerca.setVisible(false);
			}
		});
		tuerca.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Tuerca.png")));
		tuerca.setBounds(932, 30, 38, 38);
		frame.getContentPane().add(tuerca);
		tuerca.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tuerca.setBackground(new Color(0, 0, 255));
		tuerca.addMouseMotionListener( new MouseMotionAdapter() {
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				tuerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		} );
		frame.getContentPane().add(panelOpciones);
		panelOpciones.setLayout(null);
		
		
		botonGroupClientes = new ButtonGroup();
		botonGroupCentros  = new ButtonGroup();
		
		JLabel minimizar = new JLabel("salir");
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				panelOpciones.setVisible(false);
				tuerca.setVisible(true);
			}
		});
		minimizar.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Tuerca.png")));
		minimizar.setBounds(200, 0, 38, 38);
		minimizar.addMouseMotionListener( new MouseMotionAdapter() {
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				minimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		} );
		panelOpciones.add(minimizar);
		
		
		JRadioButton botonClientes1 = new JRadioButton("1");
		botonClientes1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesClientes1.setVisible(true);
				chinchesClientes2.setVisible(false);
				chinchesClientes3.setVisible(false);
				chinchesClientes4.setVisible(false);
			}
		});
		botonClientes1.setOpaque(false);
		botonClientes1.setBounds(21, 51, 41, 23);
		panelOpciones.add(botonClientes1);
		botonGroupClientes.add(botonClientes1);
		
		
		JRadioButton botonClientes2 = new JRadioButton("2");
		botonClientes2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesClientes1.setVisible(false);
				chinchesClientes2.setVisible(true);
				chinchesClientes3.setVisible(false);
				chinchesClientes4.setVisible(false);
			}
		});
		botonClientes2.setOpaque(false);
		botonClientes2.setBounds(64, 51, 41, 23);
		panelOpciones.add(botonClientes2);
		botonGroupClientes.add(botonClientes2);
		
		
		JRadioButton botonClientes3 = new JRadioButton("3");
		botonClientes3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesClientes1.setVisible(false);
				chinchesClientes2.setVisible(false);
				chinchesClientes3.setVisible(true);
				chinchesClientes4.setVisible(false);
			}
		});
		botonClientes3.setOpaque(false);
		botonClientes3.setBounds(111, 51, 41, 23);
		panelOpciones.add(botonClientes3);
		botonGroupClientes.add(botonClientes3);
		
		JRadioButton botonClientes4 = new JRadioButton("4");
		botonClientes4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesClientes1.setVisible(false);
				chinchesClientes2.setVisible(false);
				chinchesClientes3.setVisible(false);
				chinchesClientes4.setVisible(true);
			}
		});
		botonClientes4.setOpaque(false);
		botonClientes4.setBounds(155, 51, 41, 23);
		panelOpciones.add(botonClientes4);
		botonGroupClientes.add(botonClientes4);
		
		
		
		JRadioButton botonCentros1 = new JRadioButton("1");
		botonCentros1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesCentros1.setVisible(true);
				chinchesCentros2.setVisible(false);
				chinchesCentros3.setVisible(false);
			}
		});
		botonCentros1.setOpaque(false);
		botonCentros1.setBounds(21, 125, 41, 23);
		panelOpciones.add(botonCentros1);
		botonGroupCentros.add(botonCentros1);
		
		JRadioButton botonCentros2 = new JRadioButton("2");
		botonCentros2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesCentros1.setVisible(false);
				chinchesCentros2.setVisible(true);
				chinchesCentros3.setVisible(false);
			}
		});
		botonCentros2.setOpaque(false);
		botonCentros2.setBounds(64, 125, 41, 23);
		panelOpciones.add(botonCentros2);
		botonGroupCentros.add(botonCentros2);
		
		JRadioButton botonCentros3 = new JRadioButton("3");
		botonCentros3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				chinchesCentros1.setVisible(false);
				chinchesCentros2.setVisible(false);
				chinchesCentros3.setVisible(true);
			}
		});
		botonCentros3.setOpaque(false);
		botonCentros3.setBounds(111, 125, 41, 23);
		panelOpciones.add(botonCentros3);
		botonGroupCentros.add(botonCentros3);
		
		
		JLabel lblConjuntoDeClientes = new JLabel("Conjuntos de clientes");
		lblConjuntoDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConjuntoDeClientes.setBounds(21, 21, 156, 23);
		panelOpciones.add(lblConjuntoDeClientes);
		
		JLabel lblConjuntosDeCentros = new JLabel("Conjuntos de centros");
		lblConjuntosDeCentros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConjuntosDeCentros.setBounds(21, 95, 156, 23);
		panelOpciones.add(lblConjuntosDeCentros);
		
		JLabel lblCentrosAbiertos = new JLabel("Centros abiertos");
		lblCentrosAbiertos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCentrosAbiertos.setBounds(80, 177, 116, 19);
		panelOpciones.add(lblCentrosAbiertos);
		
		@SuppressWarnings("rawtypes")
		JComboBox cantidadAbiertos = new JComboBox();
		cantidadAbiertos.setBounds(21, 175, 41, 23);
		panelOpciones.add(cantidadAbiertos);
		crearComboBox(cantidadAbiertos);
		
		
		
		JLabel fondoTransparente = new JLabel("");
		fondoTransparente.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Contenedor.png")));
		fondoTransparente.setBounds(0, 0, 238, 234);
		panelOpciones.add(fondoTransparente);
		
		JLabel botonSalir = new JLabel("");
		botonSalir.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit( 0 );
			}
		});
		botonSalir.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/boton-salir.png")));
		botonSalir.setBounds(23, 30, 28, 29);
		botonSalir.addMouseMotionListener( new MouseMotionAdapter() {
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				botonSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		} );
		frame.getContentPane().add(botonSalir);
		
		
		//verificar que los radiobuttons esten seleccionados
		//verificar que la cantidad sea igual o menor a la cantidad de centros del conjunto
		//usar showmessagedialog para mostrar el resultado
		
		
		JButton botonCalcular = new JButton("");
		botonCalcular.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/CALCULAR.png")));
		botonCalcular.setFocusPainted( false );
		botonCalcular.setBorderPainted( false );
		botonCalcular.setBackground( new Color( 255, 255, 0 ) );
		botonCalcular.setBounds(420, 515, 135, 28);
		botonCalcular.addMouseMotionListener( new MouseMotionAdapter() {
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				botonCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		} );
		frame.getContentPane().add(botonCalcular);
		
		
		
		
		
		chinchesClientes1 = new JLabel("");
		chinchesClientes1.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/clientes-1.png")));
		chinchesClientes1.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesClientes1);
		chinchesClientes1.setVisible(false);
		
		chinchesClientes2 = new JLabel("");
		chinchesClientes2.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/clientes-2.png")));
		chinchesClientes2.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesClientes2);
		chinchesClientes2.setVisible(false);
		
		chinchesClientes3 = new JLabel("");
		chinchesClientes3.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/clientes-3.png")));
		chinchesClientes3.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesClientes3);
		chinchesClientes3.setVisible(false);
		
		chinchesClientes4 = new JLabel("");
		chinchesClientes4.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/clientes-4.png")));
		chinchesClientes4.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesClientes4);
		chinchesClientes4.setVisible(false);
		
		chinchesCentros1 = new JLabel("");
		chinchesCentros1.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/centros-1.png")));
		chinchesCentros1.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesCentros1);
		chinchesCentros1.setVisible(false);
		
		
		chinchesCentros2 = new JLabel("");
		chinchesCentros2.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/centros-2.png")));
		chinchesCentros2.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesCentros2);
		chinchesCentros2.setVisible(false);
		
		
		chinchesCentros3 = new JLabel("");
		chinchesCentros3.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/centros-3.png")));
		chinchesCentros3.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(chinchesCentros3);
		chinchesCentros3.setVisible(false);
		
		
		JLabel mapa = new JLabel("");
		mapa.setIcon(new ImageIcon(Mapa.class.getResource("/imagenes/Mapa.jpg")));
		mapa.setBounds(0, 0, 980, 554);
		frame.getContentPane().add(mapa);
		
	}
	
	//Metodos privados-------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	private void crearComboBox( @SuppressWarnings("rawtypes") JComboBox cBox ) 
	{
		cBox.addItem( "1" );
		cBox.addItem( "2" );
		cBox.addItem( "3" );
		cBox.addItem( "4" );
		cBox.addItem( "5" );
		cBox.addItem( "6" );
	}
	
	
}
