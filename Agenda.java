import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.text.*;

import java.text.SimpleDateFormat;
public class Agenda extends Janela implements ActionListener{
	
	String vPag, vValor, vData , vAsw;
	String data_atual;
	JLabel lblid, lblNome, lblEndereco, lblBairro,lbltel,lblnp,lblraca,lblobs,lblStatus,txtStatus,pag,pacote, renovacao;
	JTextField txtid,txtNome,txtEndereco,txtBairro,txttel,txtnp,txtraca,txtobs,sim_dias;
	JButton btIncluir,btConsulta,btAlterar,btExcluir;
	JRadioButton din,deb,cred,v1,v2,v3,sim,nao;
	ButtonGroup but,cash,valido;
	
	public Connection Con = Conectar.getConnection();
	
	public String status=Conectar.status;
	public int codigo,idade;
	public String nome, email;
	
		
	public Agenda(){
		super("Agenda", new Dimension (380,250));
		lblid = new JLabel("Código");
		lblNome = new JLabel("Nome");
		lblEndereco = new JLabel("EndereÃ§o");
		lblBairro = new JLabel("Bairro");
		lbltel = new JLabel("Telefone");
		lblnp = new JLabel("Nome do Pet");
		lblraca = new JLabel("Raça");
		lblobs = new JLabel("Observação");
		lblStatus = new JLabel("Status");
		pag = new JLabel("Pagamento");
		pacote = new JLabel("Pacote");
		renovacao = new JLabel("Renovação?");
		
		txtid = new JTextField("");
		txtNome = new JTextField("");
		txtEndereco = new JTextField("");
		txtBairro = new JTextField("");
		txttel = new JTextField("");
		txtnp = new JTextField("");
		txtraca = new JTextField("");
		txtobs = new JTextField("");
		txtStatus = new JLabel(status);
		sim_dias = new JTextField("");
		
		btIncluir = new JButton("Incluir");
		btConsulta = new JButton("Consulta");
		btAlterar = new JButton("Alterar");
		btExcluir = new JButton("Excluir");
		
		din = new JRadioButton("Dinheiro");
		din.setSize(100,20);
		din.setLocation(100,255);
		din.setOpaque(false);
		getContentPane().add(din);
		
		deb = new JRadioButton("Debito");
		deb.setSize(100,20);
		deb.setLocation(200,255);
		deb.setOpaque(false);
		getContentPane().add(deb);
		
		cred = new JRadioButton("Credito");
		cred.setSize(100,20);
		cred.setLocation(300,255);
		cred.setOpaque(false);
		getContentPane().add(cred);
		
		but = new ButtonGroup();
		but.add(din);
		but.add(deb);
		but.add(cred);
		
		v1 = new JRadioButton("R$ 85,00");
		v1.setSize(100,20);
		v1.setLocation(100,295);
		v1.setOpaque(false);
		getContentPane().add(v1);
		
		v2 = new JRadioButton("R$ 90,00");
		v2.setSize(100,20);
		v2.setLocation(200,295);
		v2.setOpaque(false);
		getContentPane().add(v2);
		
		v3 = new JRadioButton("R$ 110,00");
		v3.setSize(100,20);
		v3.setLocation(300,295);
		v3.setOpaque(false);
		getContentPane().add(v3);
		
		cash = new ButtonGroup();
		cash.add(v1);
		cash.add(v2);
		cash.add(v3);
		
		sim = new JRadioButton("Sim");
		sim.setSize(100,20);
		sim.setLocation(100,335);
		sim.setOpaque(false);
		getContentPane().add(sim);
		
		nao = new JRadioButton("Não");
		nao.setSize(100,20);
		nao.setLocation(300,335);
		nao.setOpaque(false);
		getContentPane().add(nao);
		
		valido = new ButtonGroup();
		valido.add(sim);
		valido.add(nao);
		
		
		lblid.setBounds(20,50,80,20);
		txtid.setBounds(130,50,260,20);
		lblNome.setBounds(20,70,80,20);
		txtNome.setBounds(130,70,260,20);
		lblEndereco.setBounds(20,90,80,20);
		txtEndereco.setBounds(130,90,260,20);
		lblBairro.setBounds(20,110,80,20);
		txtBairro.setBounds(130,110,260,20);
		lbltel.setBounds(20,130,90,20);
		txttel.setBounds(130,130,260,20);
		lblnp.setBounds(20,150,120,20);
		txtnp.setBounds(130,150,260,20);
		lblraca.setBounds(20,170,120,20);
		txtraca.setBounds(130,170,260,20);
		lblobs.setBounds(20,190,100,20);
		txtobs.setBounds(130,190,260,20);
		lblStatus.setBounds(20,210,80,20);
		txtStatus.setBounds(90,210,260,20);
		pag.setBounds(20,240,110,20);
		pacote.setBounds(20,280,120,20);
		renovacao.setBounds(20,320,120,20);
		sim_dias.setBounds(145,335,100,20);
		
		btIncluir.setBounds(20,360,80,20);
		btConsulta.setBounds(100,360,90,20);
		btAlterar.setBounds(190,360,80,20);
		btExcluir.setBounds(270,360,80,20);
		
		
		
		btConsulta.addActionListener(this);
		btIncluir.addActionListener(this);
		btAlterar.addActionListener(this);
		btExcluir.addActionListener(this);
		
		getContentPane().add(lblid);
		getContentPane().add(txtid);
		getContentPane().add(lblNome);
		getContentPane().add(txtNome);
		getContentPane().add(lblEndereco);
		getContentPane().add(txtEndereco);
		getContentPane().add(lblBairro);
		getContentPane().add(txtBairro);
		getContentPane().add(lbltel);
		getContentPane().add(txttel);
		getContentPane().add(lblnp);
		getContentPane().add(txtnp);
		getContentPane().add(lblraca);
		getContentPane().add(txtraca);
		getContentPane().add(lblobs);
		getContentPane().add(txtobs);
		getContentPane().add(lblStatus);
		getContentPane().add(txtStatus);
		getContentPane().add(pag);
		getContentPane().add(pacote);
		getContentPane().add(renovacao);
		getContentPane().add(sim_dias);
		getContentPane().add(btIncluir);
		getContentPane().add(btConsulta);
		getContentPane().add(btExcluir);
		getContentPane().add(btAlterar);
		
				
	}
	public static void main(String[] args) {
		new Agenda().setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btIncluir){
			inserir();
		} else if (e.getSource() == btConsulta) {
			consulta();
		} else if (e.getSource() == btAlterar){
			alterar();
		} else if(e.getSource() == btExcluir) {
			excluir();
		}

	}
	
	public void inserir(){
        int vid = Integer.parseInt(txtid.getText());
        String vnome = txtNome.getText();
        String vendereco = txtEndereco.getText();
        String vbairro = txtBairro.getText();
        String vTel = txttel.getText();
        String vpet = txtnp.getText();
        String vRaca = txtraca.getText();
        String vobs = txtobs.getText();
        String vPag = "";
        String vValor = "";
        String vAsw = "";
        String vData = sim_dias.getText();
        
        if (din.isSelected()==true)
           vPag = "Dinheiro";
        if (cred.isSelected()==true)
           vPag = "Credito";
        if (deb.isSelected()==true)
           vPag = "Débito";
       
        if (v1.isSelected()==true)
            vValor = "R$ 85,00";
        if (v2.isSelected()==true)
            vValor = "R$ 90,00";
        if (v3.isSelected()==true)
            vValor = "R$ 110,00";
        
        if (sim.isSelected() == true)
        	vAsw = "Sim";
        if (nao.isSelected() == true)
        	vAsw = "Não";
       
      
        String sql;
        sql = "insert into fofuxos_pet (id_cadastro,nome,endereco,bairro,telefone,nome_pet,raca,observacao,pagamento,pacote,renovacao,rn_sim)"
                + "values (" + vid + ", '" + vnome + "','" + vendereco + "', '" + vbairro + "','" + vTel + "','" + vpet + "','" + vRaca + "','" + vobs + "','" + vPag + "','" + vValor + "','" + vAsw + "', '" + vData + "')";
       
     
        try {
            Statement stm = Con.createStatement();
            stm.executeUpdate(sql);
            txtStatus.setText("Dados Gravados");
           
        } catch (Exception e) {
           
            txtStatus.setText("Erro ao gravar");
           
            System.out.println(e.getMessage());
        }
    }
	
	public void consulta(){
		int vid = Integer.parseInt(txtid.getText());
		
		String sql;
		sql = "select * from fofuxos_pet where id_cadastro = " + vid;
		
		try {
			Statement stm = Con.createStatement();
			ResultSet dados;
			dados = stm.executeQuery(sql);
			
			if (dados.next())
			{
				txtNome.setText(dados.getString(2));
				txtEndereco.setText(dados.getString(3));
				txtBairro.setText(dados.getString(4));
				txttel.setText(dados.getString(5));
				txtnp.setText(dados.getString(6));
				txtraca.setText(dados.getString(7));
				txtobs.setText(dados.getString(8));
				vPag = (dados.getString(9));
				vValor = (dados.getString(10));
				vAsw = (dados.getString(11));
				vData = (dados.getString(12));
				
				if (vPag.equals("Dinheiro")) {
					din.setSelected(true);
				} else if (vPag.equals("Débito")) {
					deb.setSelected(true);
				} else if (vPag.equals("Credito")){
					cred.setSelected(true);
				}
				
				if (vValor.equals("R$ 85,00")){
					v1.setSelected(true);
				} else if (vValor.equals("R$ 90,00")){
					v2.setSelected(true);
				} else if (vValor.equals("R$ 110,00")){
					v3.setSelected(true);
				}
				
				if (vAsw.equals("Sim")) {
					sim.setSelected(true);
				} else if (vAsw.equals("Não")) {
					nao.setSelected(true);
				}
				
				txtStatus.setText("Consulta realizada com Sucesso");	
			}else{
				txtStatus.setText("Não tem o nome cadastrado");
			}
			
		} catch (Exception e) {
			
			txtStatus.setText("Erro na consulta");
			
			System.out.println(e.getMessage());
		}
		
	}
		
		
		
		public void alterar(){
			int vid = Integer.parseInt(txtid.getText());
			String vnome = txtNome.getText();
	        String vendereco = txtEndereco.getText();
	        String vbairro = txtBairro.getText();
	        String vpet = txtnp.getText();
	        String vobs = txtobs.getText();
	        String vTel = txttel.getText();
	        String vRaca = txtraca.getText();
	        String vPag = "";
	        String vValor = "";
	        String vAsw = "";
	        String vData = sim_dias.getText();
	        
	        if (din.isSelected()==true)
	            vPag = "Dinheiro";
	         if (cred.isSelected()==true)
	            vPag = "Credito";
	         if (deb.isSelected()==true)
	            vPag = "Débito";
	        
	         if (v1.isSelected()==true)
	             vValor = "R$ 85,00";
	         if (v2.isSelected()==true)
	             vValor = "R$ 90,00";
	         if (v3.isSelected()==true)
	             vValor = "R$ 110,00";
	         
	         if (sim.isSelected() == true)
	        	 vAsw = "Sim";
	         if (nao.isSelected() == true)
	        	 vAsw = "Não";
			
			String sql;
			sql = "update fofuxos_pet set nome ='" + vnome + "', endereco = '" + vendereco + "', bairro ='" + vbairro + "', nome_pet = '" + vpet + "', observacao = '" + vobs + "', pagamento = '" + vPag + "', pacote = '" + vValor + "', renovacao = '" + vAsw + "', rn_sim = '" + vData + "' where id_cadastro = " + vid;
			
				
				try {
					Statement stm = Con.createStatement();
					stm.executeUpdate(sql);
					
					txtStatus.setText("Atualização feita com sucesso");
					
					
				} catch (Exception e) {
					
					txtStatus.setText("Erro na atualização");
					
					System.out.println(e.getMessage());
			}
			
			
			
		}
		
		public void excluir(){
			
			int vid = Integer.parseInt(txtid.getText());
			
			String sql;
			sql = "delete from fofuxos_pet where id_cadastro = " + vid;
			
			try {
				Statement stm = Con.createStatement();
				stm.executeUpdate(sql);
				
				txtStatus.setText("Exclusão feita com sucesso");
			} catch (Exception e) {
				
				txtStatus.setText("ID não existe");
				
				System.out.println(e.getMessage());
			}
			
					
					
		}
		
		
	}
