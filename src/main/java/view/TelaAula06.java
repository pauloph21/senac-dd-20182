package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaAula06 {

	private JFrame jfPrincipal;
	private JTextField txtSomenteNumeros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAula06 window = new TelaAula06();
					window.jfPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAula06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfPrincipal = new JFrame();
		jfPrincipal.setTitle("Título em andamento...");
		jfPrincipal.setBounds(100, 100, 490, 300);
		jfPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBoasVindas = new JLabel("Bem-vindo!");
		lblBoasVindas.setBounds(0, 0, 490, 16);
		lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoasVindas.setForeground(Color.BLACK);
		
		JLabel lblCodigoBinario = new JLabel("Número representado em código binário");
		lblCodigoBinario.setBounds(6, 201, 265, 16);
		jfPrincipal.getContentPane().add(lblCodigoBinario);
		
		final JLabel lblCodigoBinarioDigitado = new JLabel("");
		lblCodigoBinario.setBounds(294, 201, 171, 16);
		jfPrincipal.getContentPane().add(lblCodigoBinarioDigitado);
		
		final JButton btnCliqueAqui = new JButton("Clique aqui para testar eventos de mouse");
		btnCliqueAqui.setBounds(0, 249, 490, 29);
		btnCliqueAqui.addMouseListener(new MouseListener() {
			
			public void mouseReleased(java.awt.event.MouseEvent e) {
				btnCliqueAqui.setForeground(Color.YELLOW);
			}
			
			public void mousePressed(java.awt.event.MouseEvent e) {
				btnCliqueAqui.setForeground(Color.YELLOW);
			}
			
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnCliqueAqui.setForeground(Color.CYAN);
			}
			
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnCliqueAqui.setForeground(Color.RED);
			}
			
			public void mouseClicked(java.awt.event.MouseEvent e) {
				btnCliqueAqui.setForeground(Color.BLACK);
			}
		});
		jfPrincipal.getContentPane().setLayout(null);
		
		jfPrincipal.getContentPane().add(btnCliqueAqui);
		jfPrincipal.getContentPane().add(lblBoasVindas);
		
		txtSomenteNumeros = new JTextField();
		txtSomenteNumeros.setBounds(152, 68, 332, 45);
		txtSomenteNumeros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent eventoTeclado) {
				
				int codigoAsciiTeclaDigitada = eventoTeclado.getKeyCode();
				
				if(codigoAsciiTeclaDigitada < KeyEvent.VK_0
						|| codigoAsciiTeclaDigitada > KeyEvent.VK_9){
					JOptionPane.showConfirmDialog(null, "Digite um número de 0 a 9");
				}
			}
		});
		jfPrincipal.getContentPane().add(txtSomenteNumeros);
		txtSomenteNumeros.setColumns(10);
		
		JLabel lblInformeSoNumeros = new JLabel("Informe só números");
		lblInformeSoNumeros.setBounds(6, 66, 151, 48);
		jfPrincipal.getContentPane().add(lblInformeSoNumeros);
		
		JButton btnMostrarCodigoAscii = new JButton("Ver código ASCII");
		
		btnMostrarCodigoAscii.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Pegar o que foi digitado no input soNumeros
				Integer numeroDigitado = Integer.parseInt(txtSomenteNumeros.getText());
								
				//Mostrar no label lblCodigoAsciiDigitado
				lblCodigoBinarioDigitado.setText(numeroDigitado.toBinaryString(50));
			}
		});
		btnMostrarCodigoAscii.setBounds(152, 137, 182, 29);
		jfPrincipal.getContentPane().add(btnMostrarCodigoAscii);
		
		
		
	}
}
