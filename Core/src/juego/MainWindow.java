package juego;

import heroes.Arcano;
import heroes.Guerrero;
import heroes.Humano;
import heroes.Mago;
import heroes.Sacerdote;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JSeparator;

import objetos.Bomba;
import objetos.Pocion;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import enemigos.EArquero;
import enemigos.EGuerrero;
import enemigos.Esqueleto;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

public class MainWindow extends JFrame {

	private JLayeredPane VentanaMain;
	private JButton btnCrearPersonaje;
	private JButton btnJugar;
	private JButton btnSeleccionarPersonaje;
	private JTextField textField;
	private JTextField txtHero;
	private JLabel lblClase;
	private JTextField txtClass;
	private JPanel Ataque;
	private JTextField n_enemigo;
	private JTextField n_ataque;
	private JTextField textFieldHnombre;
	private JTextField n_salud;
	private JTextField textFieldHsalud;
	private JTextField textFieldHataque;
	private JTextField txtCreaNom;
	private JTextField txtCreaEdad;
	private JCheckBox chckbxHielo;
	private JPanel creacion;
	private JCheckBox chckbxFuego;
	private JCheckBox chckbxMago;
	private JCheckBox chckbxArco;
	private JCheckBox chckbxArcano;
	private JCheckBox chckbxEspada;
	private JCheckBox chckbxSacerdote;
	private JCheckBox chckbxBastn;
	private JCheckBox chckbxCura;
	private JCheckBox chckbxVarita;
	private JCheckBox chckbxGuerrero;
	private JCheckBox chckbxMaldicin;
	static ArrayList<Humano> personajes=new ArrayList<Humano>();
	private JPanel seleccion;
	private JLabel lblElegirPersonaje;
	private JComboBox comboBox;
	private JButton btnokselec;
	private JButton btnAtrs_1;
	private JPanel panel;
	private int n=-1;
	private int muertes;
	private JSeparator separator;
	private Humano jugador=null;
	private Esqueleto es = null;
	private JLabel imgAtaqueHeroe;
	private JButton btnAtacar;
	private JButton btnObjeto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		personajes.add(new Guerrero("Thauss",25,true,false));
		personajes.add(new Guerrero("Legolas",33,false,true));
		personajes.add(new Arcano("Bastian",25,true,false,true,false));
		personajes.add(new Sacerdote("Bastian",25,true,false,true,false));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Hero in the Dark");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 415);
		VentanaMain = new JLayeredPane();
		VentanaMain.setForeground(Color.GRAY);
		VentanaMain.setBackground(Color.DARK_GRAY);
		VentanaMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentanaMain);
		VentanaMain.setLayout(null);
		
		 panel = new JPanel();
		VentanaMain.setLayer(panel, 4);
		panel.setBounds(0, 0, 533, 377);
		VentanaMain.add(panel);
		panel.setOpaque(true);
		panel.setLayout(null);
		


		
		JLabel lblHeroInThe = new JLabel("Hero in the Dark 2.0 Alpha Version");
		lblHeroInThe.setBounds(55, 9, 207, 14);
		panel.add(lblHeroInThe);
		
		
		btnCrearPersonaje = new JButton("Crear Personaje");
		btnCrearPersonaje.setBounds(333, 42, 150, 23);
		panel.add(btnCrearPersonaje);
		
		btnSeleccionarPersonaje = new JButton("Seleccionar Personaje");
		btnSeleccionarPersonaje.setBounds(333, 76, 150, 23);
		panel.add(btnSeleccionarPersonaje);
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jugador instanceof Mago){
					imgAtaqueHeroe.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/magecreat.gif")));
				}
				
				VentanaMain.setLayer(Ataque, 5);
				VentanaMain.setLayer(panel, 2);
				VentanaMain.setLayer(seleccion, 2);
				VentanaMain.setLayer(creacion, 2);
				
				juego();
				
				
			}
		});
		btnJugar.setBounds(333, 323, 150, 43);
		panel.add(btnJugar);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(10, 28, 300, 343);
		panel.add(imagen);
		imagen.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/Skeleton.gif")));
		
		JLabel lblHroeSeleccionado = new JLabel("H\u00E9roe seleccionado");
		lblHroeSeleccionado.setBounds(113, 401, 93, 14);
		panel.add(lblHroeSeleccionado);
		
		txtHero = new JTextField();
		txtHero.setBounds(211, 398, 86, 20);
		panel.add(txtHero);
		txtHero.setText("Thauss");
		txtHero.setColumns(10);
		
		lblClase = new JLabel("Clase");
		lblClase.setBounds(302, 401, 26, 14);
		panel.add(lblClase);
		
		txtClass = new JTextField();
		txtClass.setBounds(333, 398, 86, 20);
		panel.add(txtClass);
		txtClass.setText("Guerrero");
		txtClass.setColumns(10);
		
		btnSeleccionarPersonaje.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				VentanaMain.setLayer(panel, 2);
				VentanaMain.setLayer(seleccion, 5);
				VentanaMain.setLayer(creacion, 2);
				VentanaMain.setLayer(Ataque, 2);
				comboBox.removeAllItems();
				for (int i = 0; i < personajes.size(); i++) {
					
							
							comboBox.addItem(personajes.get(i).getNombre()+" Clase: "+personajes.get(i).getClass());
							
					
					
				}
				
				
			}
		});
		btnCrearPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMain.setLayer(creacion, 5);
				VentanaMain.setLayer(panel, 2);
				VentanaMain.setLayer(seleccion, 2);
				VentanaMain.setLayer(Ataque, 2);
				creacion.setVisible(true);
				
			}
		});
		
		Ataque = new JPanel();
		Ataque.setForeground(Color.GRAY);
		Ataque.setBounds(0, 0, 533, 377);
		VentanaMain.add(Ataque);
		VentanaMain.setLayer(Ataque, 3);
		Ataque.setOpaque(true);
		Ataque.setLayout(null);
		
		
		JLabel lblEnemigo = new JLabel("Enemigo");
		lblEnemigo.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		lblEnemigo.setBounds(10, 12, 55, 17);
		Ataque.add(lblEnemigo);
		
		n_enemigo = new JTextField();
		n_enemigo.setEnabled(false);
		n_enemigo.setBounds(70, 11, 150, 20);
		Ataque.add(n_enemigo);
		n_enemigo.setColumns(10);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		lblAtaque.setBounds(10, 71, 43, 17);
		Ataque.add(lblAtaque);
		
		n_ataque = new JTextField();
		n_ataque.setEnabled(false);
		n_ataque.setBounds(70, 71, 86, 20);
		Ataque.add(n_ataque);
		n_ataque.setColumns(10);
		
		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		lblSalud.setBounds(10, 42, 39, 17);
		Ataque.add(lblSalud);
		
		textFieldHnombre = new JTextField();
		textFieldHnombre.setEnabled(false);
		textFieldHnombre.setBounds(66, 211, 86, 20);
		Ataque.add(textFieldHnombre);
		textFieldHnombre.setColumns(10);
		
		JLabel lblHeroe = new JLabel("Heroe");
		lblHeroe.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblHeroe.setBounds(10, 207, 46, 30);
		Ataque.add(lblHeroe);
		
		n_salud = new JTextField();
		n_salud.setEnabled(false);
		n_salud.setBounds(70, 42, 86, 20);
		Ataque.add(n_salud);
		n_salud.setColumns(10);
		
		JLabel lblSalud_1 = new JLabel("Salud");
		lblSalud_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 14));
		lblSalud_1.setBounds(10, 249, 41, 23);
		Ataque.add(lblSalud_1);
		
		textFieldHsalud = new JTextField();
		textFieldHsalud.setEnabled(false);
		textFieldHsalud.setBounds(66, 249, 86, 20);
		Ataque.add(textFieldHsalud);
		textFieldHsalud.setColumns(10);
		
		JLabel lblAtaque_1 = new JLabel("Ataque");
		lblAtaque_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 14));
		lblAtaque_1.setBounds(10, 283, 50, 23);
		Ataque.add(lblAtaque_1);
		
		textFieldHataque = new JTextField();
		textFieldHataque.setEnabled(false);
		textFieldHataque.setColumns(10);
		textFieldHataque.setBounds(66, 283, 86, 20);
		Ataque.add(textFieldHataque);
		
		btnAtacar = new JButton("Atacar!");
		btnAtacar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean muerte=false;
				int jpop;
				JOptionPane jp=new JOptionPane(); 
				es.setVida(es.getVida()-jugador.getAtaque());
				if(es.getVida()<=0){
					muertes++;
					jpop=jp.showConfirmDialog(Ataque, "Enemigo Abatido!!\n Deseas continuar?");
						if(jpop==0){
							muerte=true;
							es=crearEnemigo();
							generarBotin(jugador);
						}
						if (jpop!=0) {
							muerte=true;
							jp.showMessageDialog(Ataque, "Has abatido a "+muertes+" Esqueletos del abismo");
							resetear();
							jugador.setVida(jugador.getMaxvida());;
							
						}
						
							
						
				}
				if (!muerte) {
					jugador.setVida(jugador.getVida() - es.getAtaque());
					if(jugador.getVida()<=0){
						JOptionPane.showMessageDialog(Ataque, "HAS MUERTO \n pero has regresado a: "
								+ ""+muertes+" enemigos a sus pestilentes tumbas");
						resetear();
						jugador.setVida(jugador.getMaxvida());;
						volver();
					}
					else{
						JOptionPane
						.showMessageDialog(
								Ataque,
								"Has realizado un ataque de "
										+ jugador.getAtaque()
										+ "puntos de da�o\n y has recibido un golpe de "
										+ es.getAtaque() + " de da�o");
						datos(jugador, es);
					}
					
				}
				datos(jugador, es);
			}
		});
		btnAtacar.setBounds(10, 329, 86, 23);
		Ataque.add(btnAtacar);
		
		btnObjeto = new JButton("Objeto");
		btnObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				
				s= JOptionPane.showInputDialog(Ataque, "Escribe el objeto que quieras usar: \n"
						+jugador.getInventario()[0].getNombre()+
						" cantidad: "+jugador.getInventario()[0].getCantidad()+
						"\n"+jugador.getInventario()[1].getNombre()+
						" cantidad: "+jugador.getInventario()[1].getCantidad());
				
				if((s.equalsIgnoreCase("pocion")||s.equalsIgnoreCase("pocion de vida"))&&(jugador.getInventario()[0].getCantidad()>0)){
					jugador.setVida(jugador.getVida()+10);
					if(jugador.getVida()>jugador.getMaxvida()){
						jugador.setVida(jugador.getMaxvida());
						jugador.getInventario()[0].setCantidad(jugador.getInventario()[0].getCantidad()-1);
								JOptionPane.showMessageDialog(rootPane, "Te has curado 10 puntos de salud");}
					datos(jugador, es);
				}
				else if((s.equalsIgnoreCase("bomba")||s.equalsIgnoreCase("bomba de fuego"))&&(jugador.getInventario()[1].getCantidad()>0)){
					es.setVida(es.getVida()-10);
				JOptionPane.showMessageDialog(rootPane, "Has causado 10 puntos de da�o");
					jugador.getInventario()[1].setCantidad(jugador.getInventario()[1].getCantidad()-1);
					datos(jugador,es);
					if(es.getVida()<=0){
						int jpop;
						JOptionPane jp=new JOptionPane(); 
						muertes++;
						jpop=jp.showConfirmDialog(Ataque, "Enemigo Abatido!!\n Deseas continuar?");
							if(jpop==0){
								es=crearEnemigo();
								generarBotin(jugador);
								datos(jugador, es);
							}
							if (jpop!=0) {
								jp.showMessageDialog(Ataque, "Has abatido a "+muertes+" Esqueletos del abismo");
								resetear();
								jugador.setVida(jugador.getMaxvida());;
								
							}
							
								
							
					}
					
				}
				else{
					JOptionPane.showMessageDialog(rootPane, "No te quedan bombas, o lo has escrito mal (tramposo/in�til)");
				}
			}
		});
		btnObjeto.setBounds(105, 329, 86, 23);
		Ataque.add(btnObjeto);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalir.setBounds(465, 332, 58, 20);
		Ataque.add(btnSalir);
		
		imgAtaqueHeroe = new JLabel("");
		imgAtaqueHeroe.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/warrior.png")));
		imgAtaqueHeroe.setBounds(305, 207, 150, 150);
		Ataque.add(imgAtaqueHeroe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/enemy.jpg")));
		lblNewLabel_1.setBounds(305, 12, 200, 150);
		Ataque.add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setBounds(0, 184, 533, 2);
		Ataque.add(separator);
		
		creacion = new JPanel();
		VentanaMain.setLayer(creacion, 3);
		creacion.setBounds(0, 0, 533, 377);
		VentanaMain.add(creacion);
		creacion.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Viner Hand ITC", Font.PLAIN, 22));
		lblNombre.setBounds(10, 61, 80, 28);
		creacion.add(lblNombre);
		
		JLabel lblCreacinDePersonaje = new JLabel("CREACI\u00D3N DE PERSONAJE");
		lblCreacinDePersonaje.setFont(new Font("Old English Text MT", Font.ITALIC, 24));
		lblCreacinDePersonaje.setBounds(70, 11, 395, 28);
		creacion.add(lblCreacinDePersonaje);
		
		txtCreaNom = new JTextField();
		txtCreaNom.setBounds(114, 65, 156, 20);
		creacion.add(txtCreaNom);
		txtCreaNom.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Viner Hand ITC", Font.PLAIN, 22));
		lblEdad.setBounds(10, 117, 80, 28);
		creacion.add(lblEdad);
		
		JLabel lblClase_1 = new JLabel("Clase");
		lblClase_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 22));
		lblClase_1.setBounds(10, 175, 80, 28);
		creacion.add(lblClase_1);
		
		chckbxGuerrero = new JCheckBox("Guerrero");
		chckbxGuerrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxGuerrero.isSelected()){
					chckbxEspada.setVisible(true);
					chckbxArco.setVisible(true);	
				}
			}
		});
		chckbxGuerrero.setBounds(114, 178, 80, 23);
		creacion.add(chckbxGuerrero);
		
		chckbxMago = new JCheckBox("Mago");
		chckbxMago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxBastn.setVisible(true);
				chckbxVarita.setVisible(true);
			}
		});
		chckbxMago.setBounds(114, 215, 80, 23);
		creacion.add(chckbxMago);
		
		chckbxArcano = new JCheckBox("Arcano");
		chckbxArcano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxFuego.setVisible(true);
				chckbxHielo.setVisible(true);
			}
		});
		chckbxArcano.setBounds(261, 215, 80, 23);
		creacion.add(chckbxArcano);
		chckbxArcano.setVisible(false);
		
		chckbxSacerdote = new JCheckBox("Sacerdote");
		chckbxSacerdote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxMaldicin.setVisible(true);
				chckbxCura.setVisible(true);
			}
		});
		chckbxSacerdote.setBounds(261, 251, 87, 23);
		creacion.add(chckbxSacerdote);
		chckbxSacerdote.setVisible(false);
		
		chckbxFuego = new JCheckBox("Fuego");
		chckbxFuego.setBounds(346, 215, 64, 23);
		creacion.add(chckbxFuego);
		chckbxFuego.setVisible(false);
		
		chckbxHielo = new JCheckBox("Hielo");
		chckbxHielo.setBounds(412, 215, 56, 23);
		creacion.add(chckbxHielo);
		chckbxHielo.setVisible(false);
		
		chckbxBastn = new JCheckBox("Bast\u00F3n");
		chckbxBastn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxArcano.setVisible(true);
				chckbxSacerdote.setVisible(true);
			}
		});
		chckbxBastn.setBounds(192, 215, 70, 23);
		creacion.add(chckbxBastn);
		chckbxBastn.setVisible(false);
		
		chckbxVarita = new JCheckBox("Varita");
		chckbxVarita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxArcano.setVisible(true);
				chckbxSacerdote.setVisible(true);
			}
		});
		chckbxVarita.setBounds(192, 251, 64, 23);
		creacion.add(chckbxVarita);
		chckbxVarita.setVisible(false);
		
		chckbxCura = new JCheckBox("Cura");
		chckbxCura.setBounds(346, 251, 64, 23);
		creacion.add(chckbxCura);
		chckbxCura.setVisible(false);
		
		chckbxMaldicin = new JCheckBox("Maldici\u00F3n");
		chckbxMaldicin.setBounds(412, 251, 80, 23);
		chckbxMaldicin.setVisible(false);
		creacion.add(chckbxMaldicin);
		
		chckbxEspada = new JCheckBox("Espada");
		chckbxEspada.setBounds(190, 178, 70, 23);
		creacion.add(chckbxEspada);
		chckbxEspada.setVisible(false);
		
		chckbxArco = new JCheckBox("Arco");
		chckbxArco.setBounds(259, 178, 70, 23);
		creacion.add(chckbxArco);
		chckbxArco.setVisible(false);
		
		txtCreaEdad = new JTextField();
		txtCreaEdad.setBounds(114, 121, 45, 20);
		creacion.add(txtCreaEdad);
		txtCreaEdad.setColumns(10);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxGuerrero.isSelected()){
					if (chckbxEspada.isSelected()) {
						personajes.add(new Guerrero(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), true, false));
					}
					if(chckbxArco.isSelected()){
						personajes.add(new Guerrero(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), false, true));
					}
				}
				else{
					if(chckbxMago.isSelected()){
						if (chckbxBastn.isSelected()) {
							if (chckbxArcano.isSelected()) {
								if (chckbxFuego.isSelected()) {
									personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), true, false, true, false));
								}
								if (chckbxHielo.isSelected()) {
									personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), true, false, false, true));
								}
							}
							if (chckbxSacerdote.isSelected()) {
								if (chckbxCura.isSelected()) {
									personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), true, false, true, false));
								}
								if (chckbxMaldicin.isSelected()) {
									personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), true, false, false, true));
								}
							}
						}
						else{
							if (chckbxVarita.isSelected()) {
								if (chckbxArcano.isSelected()) {
									if (chckbxFuego.isSelected()) {
										personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), false, true, true, false));
									}
									if (chckbxHielo.isSelected()) {
										personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), false, true, false, true));
									}
								}
								if (chckbxSacerdote.isSelected()) {
									if (chckbxCura.isSelected()) {
										personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), false, true, true, false));
									}
									if (chckbxMaldicin.isSelected()) {
										personajes.add(new Arcano(txtCreaNom.getText(), Integer.valueOf(txtCreaEdad.getText()), false, true, false, true));
									}
								}
							}
						}
					}
				}
				txtCreaEdad.setText("");
				txtCreaNom.setText("");
				chckbxArcano.setSelected(false);
				chckbxArco.setSelected(false);
				chckbxBastn.setSelected(false);
				chckbxCura.setSelected(false);
				chckbxEspada.setSelected(false);
				chckbxFuego.setSelected(false);
				chckbxGuerrero.setSelected(false);
				chckbxMago.setSelected(false);
				chckbxHielo.setSelected(false);
				chckbxMaldicin.setSelected(false);
				chckbxSacerdote.setSelected(false);
				chckbxVarita.setSelected(false);
			}
		});
		btnConf.setBounds(115, 311, 155, 36);
		creacion.add(btnConf);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMain.setLayer(panel, 5);
				volver();
			}

		});
		btnAtrs.setBounds(310, 311, 155, 36);
		creacion.add(btnAtrs);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/herocreation.png")));
		label.setBounds(348, 61, 175, 142);
		creacion.add(label);
		
		seleccion = new JPanel();
		VentanaMain.setLayer(seleccion, 1);
		seleccion.setBounds(0, 0, 533, 377);
		VentanaMain.add(seleccion);
		seleccion.setLayout(null);

		
		
		
		lblElegirPersonaje = new JLabel("ELEGIR PERSONAJE");
		lblElegirPersonaje.setFont(new Font("Old English Text MT", Font.ITALIC, 24));
		lblElegirPersonaje.setBounds(24, 37, 328, 54);
		seleccion.add(lblElegirPersonaje);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		comboBox.setBounds(24, 115, 479, 20);
		seleccion.add(comboBox);
		
		btnokselec = new JButton("Ok");
		btnokselec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elegido;
				elegido=comboBox.getSelectedItem().toString();
				StringTokenizer st=new StringTokenizer(elegido);
				elegido=st.nextToken();
				
				for (int i = 0; i < personajes.size(); i++) {
					if(personajes.get(i).getNombre().equals(elegido))
						jugador=personajes.get(i);
				}
				JOptionPane.showMessageDialog(seleccion, (elegido));
			}
		});
		btnokselec.setBounds(87, 309, 102, 43);
		seleccion.add(btnokselec);
		
		btnAtrs_1 = new JButton("Atr\u00E1s");
		btnAtrs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnAtrs_1.setBounds(339, 309, 102, 43);
		seleccion.add(btnAtrs_1);
		VentanaMain.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblHeroInThe, btnCrearPersonaje, btnSeleccionarPersonaje, btnJugar, imagen, lblHroeSeleccionado, txtHero, lblClase, txtClass, Ataque, lblEnemigo, lblAtaque, lblSalud, lblHeroe, lblSalud_1, lblAtaque_1, btnAtacar, btnObjeto, btnSalir, imgAtaqueHeroe, lblNewLabel_1}));
		
	}
	protected void generarBotin(Humano j) {
		Random r = new Random();
		int cantidad;
		int op;
		JOptionPane jp=new JOptionPane();
		op = r.nextInt(100);
		if(op>=0 && op <30){
			Pocion p=new Pocion();
			cantidad=j.getInventario()[0].getCantidad();
			j.getInventario()[0].setCantidad(cantidad+1);
			jp.showMessageDialog(Ataque, "Te ha tocado una Pocion!!");
		}
			
		else{
			if(op>=30 && op <51){
				Bomba bom=new Bomba();
				cantidad=j.getInventario()[1].getCantidad();
				j.getInventario()[1].setCantidad(cantidad+1);
				jp.showMessageDialog(Ataque, "Te ha tocado una Bomba de Fuego!!");
			}
				
			else
				jp.showMessageDialog(Ataque, "No te ha tocado nada!!");
		}
		
	}

	protected void resetear() {
		n_ataque.setText("");
		n_enemigo.setText("");
		n_salud.setText("");
		textFieldHataque.setText("");
		textFieldHnombre.setText("");
		textFieldHsalud.setText("");
		volver();
		
	}

	protected void juego() {
		boolean ok = false;
		int op;
		es = crearEnemigo();
			datos(jugador, es);
			
			
			
			
		
		
	}

	private void datos(Humano jugador, Esqueleto es) {
		textFieldHnombre.setText(jugador.getNombre());
		textFieldHsalud.setText(Integer.toString(jugador.getVida()));
		textFieldHataque.setText(Integer.toString(jugador.getAtaque()));
		if (es instanceof EGuerrero) {
			n_enemigo.setText("Esqueleto Guerrero");

		} else {
			if (es instanceof EArquero)
				n_enemigo.setText("Esqueleto Arquero");
			else {
				if (es instanceof Esqueleto)
					n_enemigo.setText("Esqueleto");
			}
		}
		n_salud.setText(Integer.toString(es.getVida()));
		n_ataque.setText(Integer.toString(es.getAtaque()));
		
		
	}

	protected Esqueleto crearEnemigo() {
		Esqueleto e = null;
		int n;
		Random r = new Random();
		n = r.nextInt(3);

		switch (n) {
		case 0:
			e = new Esqueleto();
			break;
		case 1:
			e = new EArquero();
			break;
		case 2:
			e = new EGuerrero();
			break;

		default:
			break;
		}
		return e;
	}

	protected void volver() {
		VentanaMain.setLayer(panel, 5);
		VentanaMain.setLayer(seleccion, 2);
		VentanaMain.setLayer(creacion, 2);
		VentanaMain.setLayer(Ataque, 2);
	}

	public JButton getBtnCrearPersonaje() {
		return btnCrearPersonaje;
	}
	public JButton getBtnJugar() {
		return btnJugar;
	}
	public JButton getBtnListarPersonajes() {
		return getBtnListarPersonajes();
	}
	public JButton getBtnSeleccionarPersonaje() {
		return btnSeleccionarPersonaje;
	}
	public JTextField getTxtClass() {
		return txtClass;
	}
	public JTextField getTxtHero() {
		return txtHero;
	}
	public JCheckBox getChckbxHielo() {
		return chckbxHielo;
	}
	public JPanel getCreacion() {
		return creacion;
	}
	public JCheckBox getChckbxFuego() {
		return chckbxFuego;
	}
	public JCheckBox getChckbxMago() {
		return chckbxMago;
	}
	public JCheckBox getChckbxArco() {
		return chckbxArco;
	}
	public JCheckBox getChckbxArcano() {
		return chckbxArcano;
	}
	public JCheckBox getChckbxEspada() {
		return chckbxEspada;
	}
	public JCheckBox getChckbxSacerdote() {
		return chckbxSacerdote;
	}
	public JCheckBox getChckbxBastn() {
		return chckbxBastn;
	}
	public JCheckBox getChckbxCura() {
		return chckbxCura;
	}
	public JCheckBox getChckbxVarita() {
		return chckbxVarita;
	}
	public JCheckBox getChckbxGuerrero() {
		return chckbxGuerrero;
	}
	public JCheckBox getChckbxMaldicin() {
		return chckbxMaldicin;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JPanel getPanel_1() {
		return seleccion;
	}
	public JPanel getPanel() {
		return panel;
	}
	public JLabel getImgAtaqueHeroe() {
		return imgAtaqueHeroe;
	}
	public JButton getBtnNewButton() {
		return btnAtacar;
	}
	public JButton getBtnObjeto() {
		return btnObjeto;
	}
}
