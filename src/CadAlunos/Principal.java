package CadAlunos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Connection;

public class Principal extends JFrame {
	
	//Atributos
	private JDesktopPane jDesktopPane;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar jMenuBar;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem2;
	private GroupLayout jDesktopPaneLayout;
	private JMenuItem jMenuItem3;
	
	//Construtor
	public Principal() {
		//Instanciando atributos
		jDesktopPane = new JDesktopPane();		
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenuBar = new JMenuBar();        
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        
        //tratamentos de tela:
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastros escolar");
        
        //Painel Desktop
        jDesktopPaneLayout = new GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
        		jDesktopPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 400, Short.MAX_VALUE));
        jDesktopPaneLayout.setVerticalGroup(
        		jDesktopPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 279, Short.MAX_VALUE));
        getContentPane().add(jDesktopPane, BorderLayout.CENTER);
        
        //Menus:
        jMenu1.setText("Arquivo");
        jMenuItem1.setText("Cadastro de alunos");
        jMenuItem1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//abrir janela
				CadAlunos cadAlunos = new CadAlunos();
				jDesktopPane.add(cadAlunos);
				cadAlunos.show();
			}
		});
        jMenu1.add(jMenuItem1);
        
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//
				dispose();
			}
		});
        jMenu1.add(jMenuItem2);
        jMenuBar.add(jMenu1);
        
        jMenu2.setText("Editar");        
        jMenuItem3.setText("Copiar");
        jMenu2.add(jMenuItem3);        
        jMenuBar.add(jMenu2);
        setJMenuBar(jMenuBar);
        
        pack();
        
	}
	
	public static void main(String[] args) {
		/*Connection connection = null;
		String url = "jdbc:mysql://127.0.0.1:3306/cadalunos";
		String user = "root";
		String pwd = "7284";*/
		
		//Rotina para chamar o layout Nimbus
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		//Rotina para dar o 'run' na aplicação
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new Principal().setVisible(true);
			}
		});

	}

}
