package shopping;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Fenetre extends JFrame{
	JTabbedPane onglet;
	JPanel user = null;
	JPanel dashboard = null;
	JPanel afficher = null;
	JPanel newList = null;
	JPanel newItem = null;
	JPanel edit = null;
	JPanel delete = null;
	JPanel corbeille = null;
	
	
	
	
	public Fenetre() {
		setPreferredSize(new Dimension(600,300));
		setTitle("Shopping List Manager");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		initFenetreComponent();
		
		
		
		
		this.setVisible(true);
	}
	
	private void initFenetreComponent(){
		
		 
		onglet = new JTabbedPane();
		
		 user = new JPanel();
		 dashboard = new JPanel();
		 afficher = new JPanel();
		 newList = new JPanel();
		 newItem = new JPanel();
		 edit = new JPanel();
		 delete = new JPanel();
		 corbeille = new JPanel();
		 setUserPanel();
		 setDashPanel();
		 setAfficherPanel();
		 
	}
	private void setUserPanel() {
		//ajouter le panel pr user
	}
	private void setDashPanel() {
		//ajouter les elements que contiendra dashboard
	}
	private void setAfficherPanel() {
		
		//cette ligne de code doit etre effacee
		String [] name= {"novembre", "decembre","janvier"};
		
		//recuperate list names in the DB and store them in a string table
		
		//on demande quelle liste a afficher
//		JOptionPane jop = new JOptionPane();

		String nomListe= (String) JOptionPane.showInputDialog(afficher, 
				"Choisir la liste:","Affichage liste",
				JOptionPane.QUESTION_MESSAGE,
				null,
				name,
				name[0]
				);
		//on va prendre ds la DB la liste correspondant au nomListe
		
		//il faut creer une classe separee pour les requetes sur la DB
		
		
		//on va creer un JTable avec les donnees recuperees ds la liste
		//le tableau des donnees doit etre de type Object
		
		//ces lignes de codes doivent etre modifiees:
		
		//les donnees du tableau
		
		Object [][] data = {
				{"pomme",50,5,250},
				{"savon",40,10,400},
				{"culottes",200,6,1200}
		};
		//les colonnes
		String titres[] = { "Produit", "prixunit","quantite","somme"};
		
		//il faut trouver un moyen pr ajouter la somme ds le tableau
		JTable tableau = new JTable(data, titres);
		afficher.add(tableau);
		
		//le boutton toPDF
		ToPDF pdf = new ToPDF(tableau);
		afficher.add(pdf);
		
		//ajouter le boutton send to an email
		
		
		
		
		
	}
	private void setNewList() {
		JScrollPane scroll =new JScrollPane();
		
		//recuperer le nom de la nouvelle liste
		String nomListe = JOptionPane.showInputDialog(newList, "Nom de la liste", "Nouvelle liste",
				JOptionPane.QUESTION_MESSAGE);
		
		//set up the input screen of the list
		
		GridLayout layout = new GridLayout(3,2);
		layout.setVgap(5);
		layout.setHgap(3);
		JPanel panel = new JPanel();
		panel.setLayout(layout);
		
		JTextField produit= new JTextField();
		JTextField prix= new JTextField();
		JTextField quantite= new JTextField();
		
		JButton ajouter= new JButton("Ajouter");
		ajouter.setSize(20,20);
		
		
		
		
		panel.add(new JLabel("Produit"));
		panel.add(produit);
		
		panel.add(new JLabel("prix-unit"));
		panel.add(prix);
		
		panel.add(new JLabel("Quantite"));
		panel.add(quantite);
		panel.add(ajouter);
		
		panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		
		
	}
}
