package br.ifam.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.ifam.connection.ConexaoJDBC;
import br.ifam.controller.ControleEixo;
import br.ifam.model.bean.Eixo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaEixo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private ConexaoJDBC conexaoJDBC;
	
	private JLabel lblLogoTela;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblTipoEixo;
	private JLabel lblTurma;
	private JLabel lblCurso;
	private JLabel lblObservacao;
	private JLabel lblRetangulo;
	
	private JButton novo;
	private JButton cadastrar;
	private JButton buscar;
	private JButton editar;
	private JButton cancelar;
	
	private JTextField txNome;
	private JTextField txCodigo;
	private JTextArea txObservacao;
	private JTextField txTurma;
	private JTextField txCurso;
	
	private String[] tiposEixos = {"","Desenvolvimento" , "Hardware"};
	private JComboBox listaDeEixos;
	
	private Object tipo[]={"Desenvolvimento","Hardware"};

	public String codigoBusca;
	
	public ImageIcon icone1;
	public ImageIcon icone2;
	public ImageIcon icone3;
	public ImageIcon icone4;
	public ImageIcon icone5;
	public ImageIcon icone6;
	private JPanel painel;
	private ImageIcon iconePanoDeFundo;
	
	private ControleEixo controleEixo = new ControleEixo(null);
	public TelaEixo() {
		super(".:: CADASTRO DE EIXOS ::.");
		Container container = getContentPane();
		ImageIcon icone = new ImageIcon("cadastro.png");
		setIconImage(icone.getImage());
		
		icone1=new ImageIcon("novo.png");
		icone2=new ImageIcon("cadastro.png");
		icone3=new ImageIcon("editar.png");
		icone4=new ImageIcon("pesquisa.JPG");
		icone5=new ImageIcon("cancelar.png");
		
		novo=new JButton("Novo",icone1);
		novo.setFont(new Font("Serif", Font.BOLD,14));
		novo.setBounds(85, 230, 91, 20);
		novo.setFocusPainted(false);
		novo.setForeground(Color.black);
		novo.setBackground(Color.white);
		novo.addActionListener(this);
		
		cadastrar=new JButton("Cadastrar",icone2);
		cadastrar.setFont(new Font("Serif", Font.BOLD,14));
		cadastrar.setBounds(185, 230, 118, 20);
		cadastrar.setFocusPainted(false);
		cadastrar.setForeground(Color.black);
		cadastrar.setBackground(Color.white);
		cadastrar.addActionListener(this);
		cadastrar.setEnabled(false);
		
		editar=new JButton("Editar",icone3);
		editar.setFont(new Font("Serif", Font.BOLD,14));
		editar.setBounds(310, 230, 95, 20);
		editar.setFocusPainted(false);
		editar.setForeground(Color.black);
		editar.setBackground(Color.white);
		editar.addActionListener(this);
		editar.setEnabled(false);
		
		buscar=new JButton("Buscar",icone4);
		buscar.setFont(new Font("Serif", Font.BOLD,14));
		buscar.setBounds(412, 230, 109, 20);
		buscar.setFocusPainted(false);
		buscar.setForeground(Color.black);
		buscar.setBackground(Color.white);
		buscar.addActionListener(this);
		
		cancelar=new JButton("Cancelar",icone5);
		cancelar.setFont(new Font("Serif", Font.BOLD,14));
		cancelar.setBounds(530, 230, 115, 20);cancelar.setFocusPainted(false);
		cancelar.setForeground(Color.black);
		cancelar.setBackground(Color.white);
		cancelar.addActionListener(this);
		cancelar.setEnabled(false);
		
		lblNome=new JLabel("Nome:");
		lblNome.setFont(new Font("Serif", Font.BOLD,14));
		lblNome.setBounds(10, 240, 75, 80);
		
		txNome=new JTextField();
		txNome.setBounds(57, 270, 370, 20);
		txNome.setEditable(false);
		
		lblCodigo= new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Serif", Font.BOLD,14));
		lblCodigo.setBounds(438, 240, 75, 80);
		
		txCodigo=new JTextField();
		txCodigo.setBounds(485, 270, 70, 20);
		txCodigo.setEditable(false);
		
		lblTipoEixo= new JLabel("Tipo:");
		lblTipoEixo.setFont(new Font("Serif", Font.BOLD,14));
		lblTipoEixo.setBounds(450, 270, 219, 80);
		
		listaDeEixos = new JComboBox(tiposEixos);
		listaDeEixos.setBounds(new Rectangle(485, 300, 150, 20));
		listaDeEixos.setBackground(Color.white);
		listaDeEixos.setEnabled(false);
		
		lblRetangulo=new JLabel();
		lblRetangulo.setBorder(new TitledBorder(""));
		lblRetangulo.setBounds (new Rectangle(5, 260, 750, 288));
		
		lblCurso= new JLabel("Curso:");
		lblCurso.setFont(new Font("Serif", Font.BOLD,14));
		lblCurso.setBounds(215, 270, 135, 80);txCurso=new JTextField();
		
		txCurso.setBounds(260, 300, 183, 20);
		txCurso.setEditable(false);
		
		lblTurma= new JLabel("Turma:");
		lblTurma.setFont(new Font("Serif", Font.BOLD,14));
		lblTurma.setBounds(10, 270, 95, 80);
		
		txTurma=new JTextField();
		txTurma.setBounds(66, 300, 145, 20);
		txTurma.setEditable(false);
		
		lblObservacao= new JLabel("Observação:");
		lblObservacao.setFont(new Font("Serif", Font.BOLD,14));
		lblObservacao.setBounds (new Rectangle(10, 320, 105, 40));
		
		txObservacao=new JTextArea();
		txObservacao.setEditable(false);
		txObservacao.setLineWrap(true);
		txObservacao.setWrapStyleWord(true);
		txObservacao.setEditable(false);
		
		JScrollPane barra = new JScrollPane();
		barra.setViewportView(txObservacao);
		barra.setBounds(new Rectangle(10,350,370,160));
		
		lblLogoTela=new JLabel();
		
		iconePanoDeFundo =new ImageIcon("departamentos.JPG");
		
		lblLogoTela.setIcon(iconePanoDeFundo);
		lblLogoTela.setBounds(0, -26, 830,255);
		
		painel = new JPanel();
		painel.setLayout(null);
		painel.add(novo);
		painel.add(cadastrar);
		painel.add(editar);
		painel.add(buscar);
		painel.add(cancelar);
		painel.add(lblNome);
		painel.add(lblCodigo);
		painel.add(lblTipoEixo);
		painel.add(lblTurma);
		painel.add(lblCurso);
		painel.add(lblObservacao);
		painel.add(lblRetangulo);
		painel.add(txNome);
		painel.add(txCodigo);
		painel.add(txTurma);
		painel.add(txCurso);
		painel.add(barra);
		painel.add(lblLogoTela);
		painel.add(listaDeEixos);
		painel.setBackground(Color.white);
		
		container.add(painel);
		setSize(765,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==novo){
			listaDeEixos.setEnabled(true);
			txNome.setEditable(true);
			cadastrar.setEnabled(true);
			txCodigo.setEditable(true);
			txObservacao.setEditable(true);
			txTurma.setEditable(true);
			txCurso.setEditable(true);
			listaDeEixos.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent acao) {
					if(listaDeEixos.getSelectedItem().toString()=="Desenvolvimento"){
						JOptionPane.showMessageDialog(null, listaDeEixos.getSelectedItem().toString());}
					else if(listaDeEixos.getSelectedItem().toString()=="Hardware"){
						JOptionPane.showMessageDialog(null, listaDeEixos.getSelectedItem().toString());
					}
				}
				
			});
		}
		
			if(e.getSource()==cadastrar){
				cadastrar.setEnabled(false);
				editar.setEnabled(true);
				cancelar.setEnabled(true);
				Eixo eixo = new Eixo();
				eixo.setCodigo(Long.parseLong(txCodigo.getText()));
				eixo.setNome(txNome.getText());
				eixo.setTipo(listaDeEixos.getSelectedItem().toString());
				eixo.setTurma(txTurma.getText());
				eixo.setObservacao(txObservacao.getText());
				eixo.setCurso(txCurso.getText());
				ControleEixo facade;
				try {
					facade = new ControleEixo(conexaoJDBC.getConnection());
					facade.cadastrar(eixo);
					JOptionPane.showMessageDialog(this,"Operação realizada com sucesso!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(this,"Ocorreu um problema de comunicação com Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this,"Ocorreu um problema de Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
				}
				
				
			}
			if(e.getSource()==buscar){
				listaDeEixos.setEnabled(true);
				txNome.setEditable(true);
				txCodigo.setEditable(true);
				txObservacao.setEditable(true);
				txTurma.setEditable(true);
				txCurso.setEditable(true);
					try{
						ControleEixo facade = new ControleEixo(conexaoJDBC.getConnection());
					Long opcao =Long.parseLong(JOptionPane.showInputDialog(null,"Escolha o usuario para busca:"));
					
					Eixo s =  facade.buscar(opcao);
					JOptionPane.showMessageDialog(this, s.getNome(), ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
			}
			catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(this,"Ocorreu um problema de comunicação com Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this,"Ocorreu um problema de Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
				}
			
			}
	
	if(e.getSource()==editar){
		ControleEixo facade;
		try {
			facade = new ControleEixo(conexaoJDBC.getConnection());
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		Eixo eixo = new Eixo();
		editar.setEnabled(false);
		cancelar.setEnabled(true);
		listaDeEixos.setEnabled(true);
		txNome.setEditable(true);
		txCodigo.setEditable(true);
		txObservacao.setEditable(true);
		txTurma.setEditable(true);
		txCurso.setEditable(true);
		eixo.setCodigo(Long.parseLong(txCodigo.getText()));
		eixo.setNome(txNome.getText());
		eixo.setTipo(listaDeEixos.getSelectedItem().toString());
		eixo.setTurma(txTurma.getText());
		eixo.setObservacao(txObservacao.getText());
		eixo.setCurso(txCurso.getText());
		try {
			facade = new ControleEixo(conexaoJDBC.getConnection());
			facade.editar(eixo);
			JOptionPane.showMessageDialog(this,"Alteração realizada com sucesso!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(this,"Ocorreu um problema de comunicação com Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this,"Ocorreu um problema de Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
		}		
	}
	if (e.getSource()==cancelar){
		try {
			Eixo eixo = new Eixo();
			ControleEixo facade = new ControleEixo(conexaoJDBC.getConnection());
			facade.excluir(eixo);
			JOptionPane.showMessageDialog(this,"Exclusão realizada com sucesso!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(this,"Ocorreu um problema de comunicação com Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this,"Ocorreu um problema de Banco!", ".::INFORMAÇÃO::.", JOptionPane.PLAIN_MESSAGE, null);
		}	
		
	}
	}	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new TelaEixo();
	}
	
}
