package CadAlunos;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import model.Aluno;
//import CadAlunos.ConexaoBDMariaDB;
import model.Conexao;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class CadAlunos extends JInternalFrame {	
	//Atributos
	private JLabel lblMatricula;
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblIdade;
	
	private JTextField txtMatricula;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtEmail;	
	private JSpinner txtIdade;
	
	private JButton btnNovoRegistro;
	private JButton btnGravarRegistro;
	private JButton btnProximo;
	private JButton btnAnterior;

	Connection connection = null;
		String url = "jdbc:mysql://127.0.0.1:3306/cadalunos";
		String user = "root";
		String pwd = "12345";
		
	
	Aluno alunos = new Aluno();
	int qteAlunos = 0; //controle de inser��es.	
	//erro aqui: sequ�ncia:
	//Conexao conexao = new Conexao("127.0.0.1", "cadalunos", "root", "123456",3306);
	Conexao conexao = new Conexao("127.0.0.1", "root", "12345", "cadalunos",3306);
	//Construtor
	public CadAlunos() {
		setClosable(true);
		setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de alunos");
        
        //instanciar atributos:
        lblMatricula = new JLabel();
        lblCodigo    = new JLabel();
        lblNome      = new JLabel();
        lblEmail     = new JLabel();
        lblIdade     = new JLabel();
        
        txtMatricula = new JTextField();
        txtCodigo    = new JTextField();
        txtNome      = new JTextField();
        txtEmail     = new JTextField();
        txtIdade     = new JSpinner();
        
        btnNovoRegistro   = new JButton();
        btnGravarRegistro = new JButton();
        btnProximo        = new JButton();
        btnAnterior       = new JButton();
        
        lblMatricula.setText("Matr�cula:");
        lblCodigo.setText("C�digo:");
        lblNome.setText("Nome:");
        lblEmail.setText("E-mail:");
        lblIdade.setText("Idade:");
        
        btnNovoRegistro.setText("Adulto?");
        btnGravarRegistro.setText("Gravar registro");
        btnProximo.setText("Pr�ximo");
        btnAnterior.setText("Anterior");
        
        txtCodigo.setEnabled(false);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            //.addGap(0, 394, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
            	.addContainerGap()
            	.addGroup(
            		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addGap(0, 0, Short.MAX_VALUE)
            			.addComponent(btnNovoRegistro)
            			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            			.addComponent(btnGravarRegistro)
            			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            			.addComponent(btnProximo)
            		)
            		.addGroup(layout.createSequentialGroup()
            			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
            				.addGroup(layout.createSequentialGroup()
            					.addComponent(lblNome)
            					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            					.addComponent(txtNome,GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
            				)
            				.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            					.addComponent(lblMatricula)
            					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            					.addComponent(txtMatricula,GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
            				)
            				.addGroup(layout.createSequentialGroup()
            					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(lblEmail)
            						.addComponent(lblIdade)
            					)
            					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            						.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE,  48, GroupLayout.DEFAULT_SIZE)
            						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.DEFAULT_SIZE)
            					)
            				)
            			)
            			.addGap(0, 0, Short.MAX_VALUE)
            		)
            	)
            	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addComponent(lblCodigo)
            			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            			.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            		)
            		.addComponent(btnAnterior)
            	)
            	.addContainerGap()
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            //.addGap(0, 274, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMatricula)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCodigo))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdade)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovoRegistro)
                        .addComponent(btnGravarRegistro)
                        .addComponent(btnProximo)
                        .addComponent(btnAnterior))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        //a��es de bot�es:
        btnGravarRegistro.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//validar a tela				
				if(validarTela() == true) {
					try {
						Aluno alunos = new Aluno();
						alunos.setNome(txtNome.getText());
						alunos.setEmail(txtEmail.getText());
						alunos.setIdade((Integer)txtIdade.getValue());
						alunos.setMatricula(txtMatricula.getText());
						
						ConexaoBDMariaDB conexaoMariaDB = new ConexaoBDMariaDB(conexao);
						if(conexaoMariaDB.Conectar()) {
							if(conexaoMariaDB.Insert(alunos)){
								JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
								limparTela();
							}
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro no processo de grava��o: " + ex.getMessage(), "Erro ao gravar dados no banco de dados.", JOptionPane.WARNING_MESSAGE);
					}
					
					//verificar posi��o do vetor
					/*if(qteAlunos <= 3) {
						qteAlunos++; //incrementa em +1						
						//gravar
						Aluno aluno = new Aluno(txtNome.getText(), txtEmail.getText(), (Integer)txtIdade.getValue(), txtMatricula.getText());
						alunos = aluno; //BD
						JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
						//limpar a tela
						limparTela();
					}else {
						JOptionPane.showMessageDialog(null, "N�o existe mais espa�o para novos alunos!");
					}*/
				}
				
			}
		});
        
        btnProximo.addActionListener(new ActionListener() {			
			@Override
			

			public void actionPerformed(ActionEvent arg0) {
				try
            {
                Aluno alunos = new Aluno();
				ConexaoBDMariaDB conexaoMariaDB = new ConexaoBDMariaDB(conexao);
                
				conexaoMariaDB.Buscar(alunos);

                if(alunos.codigo != 0) {
					
					
				


                  
                }
                else
                {
                    limparTela();
                }
            }catch(Exception ex)
            {
              
            }
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*try {
					int proximo = 0;
					//verificar se a qte de alunos � >= 0	
					if(qteAlunos >= 0) {
						//limparTela();
						if(txtCodigo.getText().length() == 0) {
							txtCodigo.setText("0");
						}else {
							proximo = Integer.parseInt(txtCodigo.getText()) + 1;
							if(proximo <= qteAlunos) {
								txtCodigo.setText(String.valueOf(proximo));
							}
						}
						//pesquisar no vetor:
						if(Integer.parseInt(txtCodigo.getText()) <= qteAlunos) {
							int codigo = Integer.parseInt(txtCodigo.getText());
							Aluno aluno = alunos; //busco do BD
							txtMatricula.setText(aluno.getMatricula());
							txtNome.setText(aluno.getNome());
							txtEmail.setText(aluno.getEmail());
							txtIdade.setValue(aluno.getIdade());
						}
					}
				}catch (Exception ex) {
					txtCodigo.setText("");
					limparTela();
					JOptionPane.showMessageDialog(null, "Aten��o!\nOcorreu um erro ao buscar"
							                      + " dados de alunos(prx): " + ex.getMessage());
				}*/
			}
		});
        
        btnAnterior.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//tratamento de exce��o
				try {
					//Criar rotina de anterior
					int anterior = 0;
					if(qteAlunos >= 0) {
						if(txtCodigo.getText().length() == 0) {
							txtCodigo.setText("0");
						}else {
							anterior = Integer.parseInt(txtCodigo.getText()) - 1;
							if(anterior >= 0) {
								txtCodigo.setText(String.valueOf(anterior));
							}else {
								txtCodigo.setText("0");
							}
							if(Integer.parseInt(txtCodigo.getText()) <= qteAlunos) {
								Aluno aluno = alunos;
								txtMatricula.setText(aluno.getMatricula());
								txtNome.setText(aluno.getNome());
								txtEmail.setText(aluno.getEmail());
								txtIdade.setValue(aluno.getIdade());
							}							
														
						}
					}
				}catch (Exception ex) {
					txtCodigo.setText("");
					limparTela();
					JOptionPane.showMessageDialog(null, "Aten��o!\nOcorreu um erro ao buscar"
							                      + " dados de alunos(ant): " + ex.getMessage());
				}
			}
		});
        
        btnNovoRegistro.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtCodigo.getText().length() > 0) {
						Aluno aluno = alunos;
						if(aluno.alunoDeMaior())
							JOptionPane.showMessageDialog(null, "O aluno " + aluno.getNome() + " j� � adulto!");
						else
							JOptionPane.showMessageDialog(null, "O aluno " + aluno.getNome() + " n�o � adulto!");
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao verificar se "
							                          + "aluno � de maior: " + ex.getMessage());
				}				
			}
		});
        
        pack();
	}
	
	/**
	 * Esta rotina server para validar se os campos em tela est�o preenchidos
	 * @return True ou False
	 */
	private boolean validarTela() {
		boolean resposta = true;
		//validar a tela.
		if(txtMatricula.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Campo matr�cula em branco. Verifique!");
			resposta = false;
		}		
		if(txtNome.getText().length() == 0 && resposta == true) {
			JOptionPane.showMessageDialog(null, "Campo nome em branco. Verifique!");
			resposta = false;
		}		
		if(txtEmail.getText().length() == 0 && resposta == true) {
			JOptionPane.showMessageDialog(null, "Campo e-mail em branco. Verifique!");
			resposta = false;
		}		
		if((Integer)txtIdade.getValue() <= 0 && resposta == true) {
			JOptionPane.showMessageDialog(null, "Campo idade inv�lido. Verifique!");
			resposta = false;
		}
		return resposta;
	}
	
	/**
	 * Rotina para limpar a tela, zerando os campos digitados
	 */
	private void limparTela() {
		txtMatricula.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtIdade.setValue(0);
		txtMatricula.requestFocus();
	}

	/*private void exibirDadosArtigo(Aluno artigo){
        limparTela();
        if (artigo != null){
            txtCodigo.setText(String.valueOf(qteAlunos));
            txtMatricula.setText(artigo.getMatricula());
            txtNome.setText(artigo.getNome());
            txtEmail.setText(artigo.getEmail());
            txtIdade.setToolTipText(artigo.getIdade().toString());
        }
    }*/
	
}
