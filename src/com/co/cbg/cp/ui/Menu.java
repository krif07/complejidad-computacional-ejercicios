package com.co.cbg.cp.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.co.cbg.cp.ejercicios2.Ordenamiento;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField txtTamVector;
	private JTextField txtTBurbuja;
	private JTextField txtTSeleccion;
	private JTextField txtTHeap;
	private JTextField txtTMerge;
	private JTextField txtCBurbuja;
	private JTextField txtCSeleccion;
	private JTextField txtCHeap;
	private JTextField txtCMerge;
	private JTextField txtIBurbuja;
	private JTextField txtISeleccion;
	private JTextField txtIHeap;
	private JTextField txtIMerge;
	private JTextField txtBuscar;
	private JTextField txtTSecuencial;
	private JTextField txtTBinaria;
	private JTextField txtCSecuencial;
	private JTextField txtCBinaria;
	private JTextField txtISecuencial;
	private JTextField txtIBinaria;
	
	private static Ordenamiento ordenamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					
					ordenamiento = new Ordenamiento();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGenerarVectores = new JButton("Generar vectores");
		btnGenerarVectores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ordenamiento.crearVectoresPrueba();
				
			}
		});
		btnGenerarVectores.setBounds(10, 11, 117, 23);
		contentPane.add(btnGenerarVectores);
		
		JButton btnBurbuja = new JButton("Burbuja");
		btnBurbuja.setBounds(10, 62, 117, 23);
		contentPane.add(btnBurbuja);
		
		JButton btnSeleccin = new JButton("Selecci\u00F3n");
		btnSeleccin.setBounds(10, 84, 117, 23);
		contentPane.add(btnSeleccin);
		
		JButton btnHeapSort = new JButton("Heap Sort");
		btnHeapSort.setBounds(10, 109, 117, 23);
		contentPane.add(btnHeapSort);
		
		JButton btnMerge = new JButton("Merge Sort");
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMerge.setBounds(10, 131, 117, 23);
		contentPane.add(btnMerge);
		
		JButton btnBuscarSecuencial = new JButton("B\u00FAsqueda Secuencial");
		btnBuscarSecuencial.setBounds(10, 211, 117, 23);
		contentPane.add(btnBuscarSecuencial);
		
		JButton btnBuscarBinaria = new JButton("B\u00FAsqueda Binaria");
		btnBuscarBinaria.setBounds(10, 234, 117, 23);
		contentPane.add(btnBuscarBinaria);
		
		JPanel panel = new JPanel();
		panel.setBounds(137, 11, 417, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTamaoVector = new JLabel("Tama\u00F1o vector");
		lblTamaoVector.setBounds(62, 8, 72, 14);
		panel.add(lblTamaoVector);
		
		txtTamVector = new JTextField();
		txtTamVector.setBounds(139, 5, 86, 20);
		txtTamVector.setText("10");
		panel.add(txtTamVector);
		txtTamVector.setColumns(10);
		
		JLabel lblTiempoMilisegundos = new JLabel("Tiempo milisegundos");
		lblTiempoMilisegundos.setBounds(140, 33, 104, 14);
		panel.add(lblTiempoMilisegundos);
		
		JLabel lblNoComparaciones = new JLabel("Comparaciones");
		lblNoComparaciones.setBounds(254, 33, 78, 14);
		panel.add(lblNoComparaciones);
		
		JLabel lblNoIntercambios = new JLabel(" Intercambios");
		lblNoIntercambios.setBounds(342, 33, 65, 14);
		panel.add(lblNoIntercambios);
		
		JLabel lblMtodo = new JLabel("M\u00E9todo");
		lblMtodo.setBounds(29, 33, 46, 14);
		panel.add(lblMtodo);
		
		JLabel lblBurbuja = new JLabel("Burbuja");
		lblBurbuja.setBounds(29, 78, 46, 14);
		panel.add(lblBurbuja);
		
		JLabel lblSeleccin = new JLabel("Selecci\u00F3n");
		lblSeleccin.setBounds(29, 101, 46, 20);
		panel.add(lblSeleccin);
		
		JLabel lblHeap = new JLabel("Heap");
		lblHeap.setBounds(29, 138, 46, 14);
		panel.add(lblHeap);
		
		JLabel lblMerge = new JLabel("Merge");
		lblMerge.setBounds(29, 170, 46, 14);
		panel.add(lblMerge);
		
		txtTBurbuja = new JTextField();
		txtTBurbuja.setEditable(false);
		txtTBurbuja.setBounds(139, 72, 97, 20);
		panel.add(txtTBurbuja);
		txtTBurbuja.setColumns(10);
		
		txtTSeleccion = new JTextField();
		txtTSeleccion.setEditable(false);
		txtTSeleccion.setBounds(139, 101, 97, 20);
		panel.add(txtTSeleccion);
		txtTSeleccion.setColumns(10);
		
		txtTHeap = new JTextField();
		txtTHeap.setEditable(false);
		txtTHeap.setBounds(139, 132, 97, 20);
		panel.add(txtTHeap);
		txtTHeap.setColumns(10);
		
		txtTMerge = new JTextField();
		txtTMerge.setEditable(false);
		txtTMerge.setBounds(139, 164, 97, 20);
		panel.add(txtTMerge);
		txtTMerge.setColumns(10);
		
		txtCBurbuja = new JTextField();
		txtCBurbuja.setEditable(false);
		txtCBurbuja.setBounds(254, 72, 78, 20);
		panel.add(txtCBurbuja);
		txtCBurbuja.setColumns(10);
		
		txtCSeleccion = new JTextField();
		txtCSeleccion.setEditable(false);
		txtCSeleccion.setBounds(254, 101, 78, 20);
		panel.add(txtCSeleccion);
		txtCSeleccion.setColumns(10);
		
		txtCHeap = new JTextField();
		txtCHeap.setEditable(false);
		txtCHeap.setBounds(254, 132, 78, 20);
		panel.add(txtCHeap);
		txtCHeap.setColumns(10);
		
		txtCMerge = new JTextField();
		txtCMerge.setEditable(false);
		txtCMerge.setBounds(254, 164, 78, 20);
		panel.add(txtCMerge);
		txtCMerge.setColumns(10);
		
		txtIBurbuja = new JTextField();
		txtIBurbuja.setEditable(false);
		txtIBurbuja.setBounds(342, 72, 65, 20);
		panel.add(txtIBurbuja);
		txtIBurbuja.setColumns(10);
		
		txtISeleccion = new JTextField();
		txtISeleccion.setEditable(false);
		txtISeleccion.setBounds(342, 101, 65, 20);
		panel.add(txtISeleccion);
		txtISeleccion.setColumns(10);
		
		txtIHeap = new JTextField();
		txtIHeap.setEditable(false);
		txtIHeap.setBounds(342, 132, 65, 20);
		panel.add(txtIHeap);
		txtIHeap.setColumns(10);
		
		txtIMerge = new JTextField();
		txtIMerge.setEditable(false);
		txtIMerge.setBounds(342, 164, 65, 20);
		panel.add(txtIMerge);
		txtIMerge.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(137, 211, 417, 85);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSecuencial = new JLabel("Secuencial");
		lblSecuencial.setBounds(30, 30, 67, 14);
		panel_1.add(lblSecuencial);
		
		JLabel lblBinaria = new JLabel("Binaria");
		lblBinaria.setBounds(30, 60, 46, 14);
		panel_1.add(lblBinaria);
		
		txtTSecuencial = new JTextField();
		txtTSecuencial.setEditable(false);
		txtTSecuencial.setBounds(141, 24, 86, 20);
		panel_1.add(txtTSecuencial);
		txtTSecuencial.setColumns(10);
		
		txtTBinaria = new JTextField();
		txtTBinaria.setEditable(false);
		txtTBinaria.setBounds(141, 54, 86, 20);
		panel_1.add(txtTBinaria);
		txtTBinaria.setColumns(10);
		
		txtCSecuencial = new JTextField();
		txtCSecuencial.setEditable(false);
		txtCSecuencial.setBounds(253, 24, 79, 20);
		panel_1.add(txtCSecuencial);
		txtCSecuencial.setColumns(10);
		
		txtCBinaria = new JTextField();
		txtCBinaria.setEditable(false);
		txtCBinaria.setBounds(253, 54, 79, 20);
		panel_1.add(txtCBinaria);
		txtCBinaria.setColumns(10);
		
		txtISecuencial = new JTextField();
		txtISecuencial.setEditable(false);
		txtISecuencial.setBounds(342, 24, 65, 20);
		panel_1.add(txtISecuencial);
		txtISecuencial.setColumns(10);
		
		txtIBinaria = new JTextField();
		txtIBinaria.setEditable(false);
		txtIBinaria.setBounds(341, 54, 66, 20);
		panel_1.add(txtIBinaria);
		txtIBinaria.setColumns(10);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 279, 117, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNmeroABuscar = new JLabel("N\u00FAmero a buscar");
		lblNmeroABuscar.setBounds(10, 265, 104, 14);
		contentPane.add(lblNmeroABuscar);
	}
}
