package medic;

//import java.sql.SQLException;
import net.codejava.sql.Java2SQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Scrollbar;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;

public class medicWindow extends JFrame {

	private JPanel Pane;
	


	Java2SQL joc=new Java2SQL();
	int variant;
	
	String url="jdbc:sqlserver://CATUTA-THE-GREA\\SQLEXPRESS;databadeName=data";
	String user="sa";
	String password="catuta-314AC";
	
	String boalaPacient="[MedicFamilie].[dbo].[BoalaPacient]";
	String medic="[MedicFamilie].[dbo].[Medic]";
	String adresa="[MedicFamilie].[dbo].[Adresa]";
	String pacienti="[MedicFamilie].[dbo].[Pacienti]";
	String boala="[MedicFamilie].[dbo].[Boala]";
	String servicii_Asigurari="[MedicFamilie].[dbo].[Servicii_asigurari]";
	
	String command;
	
	String nume,prenume,telefon,mail,cnp,sex,dataNastere,cid,localitate,strada,nr,bloc,scara,etaj,apartament,selLoc,selStr, selBoli,selPac,selServ,selCnp;
	int codAll,NrPacientiAdr,IdMedic=0;
	String numeMedic, prenumeMedic, passwdDB,passwdMedic;
	String datasAll;
	
	Color QueenBlue=new Color(52, 107, 152);
	Color PthaloGreen=new Color(17, 45, 36);
	Color TyrianPurple=new Color(82, 0, 41);
	Color Charcoal=new Color(35, 76, 94);
	private JTextField NumeField;
	private JTextField PrenumeField;
	private JTextField TelefonField;
	private JTextField MailField;
	private JTextField CNPField;
	private JTextField SexField;
	private JTextField DataNField;
	private JTextField CIDField;
	private JTextField LocalitateField;
	private JTextField StradaField;
	private JTextField nrField;
	private JTextField blocField;
	private JTextField ScaraField;
	private JTextField EtajField;
	private JTextField ApartamentField;
	private JTextField NumeMedicField;
	private JTextField PrenumeMedicField;
	private JPasswordField passwordMedicField;
	private JTextField NPacientField;
	private JTextField PnPacientField;
	private JTextField CNPPacField;
	private JTextArea txtArea2;
	private JTextField Boala1Txt;
	private JTextField Strada1Txt;
	private JTextField textField_2;
	private JTextField CNPtxt;
	private JTextField textField_4;
	private JTextField Localitate1txt;
	private JTextField CnpField;
	private JTextField BoalaField;
	private JTextField Nume2Field;
	private JTextField Prenume2Field;
	private JTextField MedicField;
	private JTextField AsigField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField ASN;
	private JTextField NewVal;
	private JTextField textField_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medicWindow frame = new medicWindow();
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
	public medicWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 780);
		Pane = new JPanel();
		Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(Pane);
		
		//declarare tot
		//panes
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel cardLayout = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel NouPacientPanel = new JPanel();
		JPanel LogInPanel = new JPanel();
		
		//buttons
		JButton SignOut = new JButton("SignOut");
		JButton NewPacient = new JButton("Nou Pacient");
		JButton AllPacienti = new JButton("Pacientii");
		JButton Register = new JButton("Register");
		JButton Login = new JButton("LogIn");
	
		
	

		JButton Querry = new JButton("Queries");
		
		JButton DelPacient = new JButton("Eliminare Pacient");
		JButton Medics = new JButton("Lista Medici");
		
		//text pane
		JTextPane NumeTxt = new JTextPane();
		JTextPane TelefonTxt = new JTextPane();
		JTextPane PrenumeTxt = new JTextPane();
		JTextPane MailTxt = new JTextPane();
		JTextPane CNPTxt = new JTextPane();
		JTextPane SexTXT = new JTextPane();
		JTextPane DataNTxt = new JTextPane();
		JTextPane CIDTxt = new JTextPane();
		JTextPane LocalitateTxt = new JTextPane();
		JTextPane StradaTxt = new JTextPane();
		JTextPane DatePersonaleTXT = new JTextPane();
		JTextPane ApartamentTxt = new JTextPane();
		JTextPane EtajTxt = new JTextPane();
		JTextPane ScataTxt = new JTextPane();
		JTextPane blocTxt = new JTextPane();
		JTextPane NrTxt = new JTextPane();
		JTextPane Adresa = new JTextPane();
		
		//text field
		NumeField = new JTextField();
		
		//separator
		JSeparator separator = new JSeparator();
		
		//declarare grupuri
		GroupLayout gl_panel4 = new GroupLayout(panel4);
		GroupLayout gl_Pane = new GroupLayout(Pane);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		
		
		
		
		NewPacient.setVisible(false);
		SignOut.setVisible(false);
		AllPacienti.setVisible(false);

		Querry.setVisible(false);
		DelPacient.setVisible(false);
		
		
		
		panel1.setForeground(Color.WHITE);
		panel1.setBorder(null);
		panel1.setBackground(QueenBlue);
		
		
		gl_Pane.setHorizontalGroup(
			gl_Pane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
		);
		gl_Pane.setVerticalGroup(
			gl_Pane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
		);
		
		
		panel2.setBackground(Charcoal);
		
		
		SignOut.setSelectedIcon(null);
	
		SignOut.setForeground(Color.WHITE);
		SignOut.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		SignOut.setBackground(new Color(35, 76, 94));
		
		
		NewPacient.setSelectedIcon(null);
		
		NewPacient.setForeground(Color.WHITE);
		NewPacient.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		NewPacient.setBackground(new Color(35, 76, 94));
		
		
		AllPacienti.setSelectedIcon(null);

		AllPacienti.setForeground(Color.WHITE);
		AllPacienti.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		AllPacienti.setBackground(new Color(35, 76, 94));
		
		
		cardLayout.setBackground(QueenBlue);
		
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cardLayout, GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(cardLayout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		cardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel ListaMediciPanel = new JPanel();
		ListaMediciPanel.setBackground(QueenBlue);
		cardLayout.add(ListaMediciPanel, "name_21195159869300");
		
		JToggleButton ShowSalariesBtn = new JToggleButton("afiseaza salariu?");
		ShowSalariesBtn.setForeground(Color.WHITE);
		
		ShowSalariesBtn.setBackground(TyrianPurple);
		
		ShowSalariesBtn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		
		JTextArea MedicsTxt = new JTextArea();
		MedicsTxt.setEditable(false);
		MedicsTxt.setWrapStyleWord(true);
		MedicsTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		MedicsTxt.setTabSize(4);
		MedicsTxt.setRows(10);
		MedicsTxt.setBackground(QueenBlue);
		MedicsTxt.setForeground(Color.WHITE);
		
		JButton ShowMedicsBtn = new JButton("Afiseaza");
		ShowMedicsBtn.setForeground(Color.WHITE);
		
		ShowMedicsBtn.setBackground(QueenBlue);
		
		ShowMedicsBtn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		
		JTextPane Y_NPane = new JTextPane();
		Y_NPane.setText("Nu");
		Y_NPane.setForeground(Color.WHITE);
		Y_NPane.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 23));
		Y_NPane.setEditable(false);
		Y_NPane.setBackground(new Color(52, 107, 152));
		GroupLayout gl_ListaMediciPanel = new GroupLayout(ListaMediciPanel);
		gl_ListaMediciPanel.setHorizontalGroup(
			gl_ListaMediciPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ListaMediciPanel.createSequentialGroup()
					.addGroup(gl_ListaMediciPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ListaMediciPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(MedicsTxt, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
						.addGroup(gl_ListaMediciPanel.createSequentialGroup()
							.addGap(93)
							.addComponent(ShowSalariesBtn)
							.addGap(18)
							.addComponent(Y_NPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(198)
							.addComponent(ShowMedicsBtn)))
					.addContainerGap())
		);
		gl_ListaMediciPanel.setVerticalGroup(
			gl_ListaMediciPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ListaMediciPanel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_ListaMediciPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ListaMediciPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(ShowSalariesBtn)
							.addComponent(ShowMedicsBtn))
						.addComponent(Y_NPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(MedicsTxt, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
					.addContainerGap())
		);
		ListaMediciPanel.setLayout(gl_ListaMediciPanel);
		cardLayout.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ListaMediciPanel, NouPacientPanel, Register, CNPTxt, CNPField, SexTXT, SexField, DataNTxt, DataNField, TelefonTxt, TelefonField, MailTxt, MailField, CIDTxt, CIDField, separator, LocalitateTxt, LocalitateField, Adresa, StradaTxt, StradaField, NrTxt, nrField, NumeTxt, NumeField, DatePersonaleTXT, PrenumeTxt, PrenumeField, blocTxt, blocField, ScataTxt, ScaraField, EtajTxt, EtajField, ApartamentTxt, ApartamentField}));
		
		
		cardLayout.add(NouPacientPanel, "name_21159244992700");
		NouPacientPanel.setBorder(null);
		
		
		Register.setSelectedIcon(null);
		Register.setForeground(Color.WHITE);
		Register.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		Register.setBackground(new Color(35, 76, 94));
		NouPacientPanel.setBackground(QueenBlue);
		
		
		NumeTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		NumeTxt.setText("Nume");
		NumeTxt.setEditable(false);
		NumeTxt.setBackground(QueenBlue);
		NumeTxt.setForeground(Color.white);
		
		
		PrenumeTxt.setText("Prenume");
		PrenumeTxt.setForeground(Color.WHITE);
		PrenumeTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		PrenumeTxt.setEditable(false);
		PrenumeTxt.setBackground(new Color(52, 107, 152));
		
		
		NumeField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		NumeField.setColumns(10);
		
		PrenumeField = new JTextField();
		PrenumeField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		PrenumeField.setColumns(10);
		
		
		TelefonTxt.setText("Telefon");
		TelefonTxt.setForeground(Color.WHITE);
		TelefonTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		TelefonTxt.setEditable(false);
		TelefonTxt.setBackground(new Color(52, 107, 152));
		
		TelefonField = new JTextField();
		TelefonField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		TelefonField.setColumns(10);
		
		
		MailTxt.setText("Mail");
		MailTxt.setForeground(Color.WHITE);
		MailTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		MailTxt.setEditable(false);
		MailTxt.setBackground(new Color(52, 107, 152));
		
		MailField = new JTextField();
		MailField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		MailField.setColumns(10);
		
		
		CNPTxt.setText("CNP");
		CNPTxt.setForeground(Color.WHITE);
		CNPTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		CNPTxt.setEditable(false);
		CNPTxt.setBackground(new Color(52, 107, 152));
		
		CNPField = new JTextField();
		CNPField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		CNPField.setColumns(10);
		
		
		SexTXT.setText("Sex");
		SexTXT.setForeground(Color.WHITE);
		SexTXT.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		SexTXT.setEditable(false);
		SexTXT.setBackground(new Color(52, 107, 152));
		
		SexField = new JTextField();
		SexField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		SexField.setColumns(10);
		
		
		DataNTxt.setText("Data Nastere");
		DataNTxt.setForeground(Color.WHITE);
		DataNTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		DataNTxt.setEditable(false);
		DataNTxt.setBackground(new Color(52, 107, 152));
		
		DataNField = new JTextField();
		DataNField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		DataNField.setColumns(10);
		
		
		CIDTxt.setText("CID");
		CIDTxt.setForeground(Color.WHITE);
		CIDTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		CIDTxt.setEditable(false);
		CIDTxt.setBackground(new Color(52, 107, 152));
		
		CIDField = new JTextField();
		CIDField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		CIDField.setColumns(10);
		
		
		LocalitateTxt.setText("Localitate");
		LocalitateTxt.setForeground(Color.WHITE);
		LocalitateTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		LocalitateTxt.setEditable(false);
		LocalitateTxt.setBackground(new Color(52, 107, 152));
		
		
		
		LocalitateField = new JTextField();
		LocalitateField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		LocalitateField.setColumns(10);
		
		
		StradaTxt.setText("Strada");
		StradaTxt.setForeground(Color.WHITE);
		StradaTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		StradaTxt.setEditable(false);
		StradaTxt.setBackground(new Color(52, 107, 152));
		
		
		DatePersonaleTXT.setText("Date Personale");
		DatePersonaleTXT.setForeground(Color.WHITE);
		DatePersonaleTXT.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 23));
		DatePersonaleTXT.setEditable(false);
		DatePersonaleTXT.setBackground(new Color(52, 107, 152));
		
		Adresa.setText("Adresa");
		Adresa.setForeground(Color.WHITE);
		Adresa.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 23));
		Adresa.setEditable(false);
		Adresa.setBackground(new Color(52, 107, 152));
		
		StradaField = new JTextField();
		StradaField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		StradaField.setColumns(10);
		
		NrTxt.setText("Numarul");
		NrTxt.setForeground(Color.WHITE);
		NrTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		NrTxt.setEditable(false);
		NrTxt.setBackground(new Color(52, 107, 152));
		
		nrField = new JTextField();
		nrField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		nrField.setColumns(10);
		
		blocTxt.setText("Bloc");
		blocTxt.setForeground(Color.WHITE);
		blocTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		blocTxt.setEditable(false);
		blocTxt.setBackground(new Color(52, 107, 152));
		
		blocField = new JTextField();
		blocField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		blocField.setColumns(10);
		
		ScataTxt.setText("Scara");
		ScataTxt.setForeground(Color.WHITE);
		ScataTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		ScataTxt.setEditable(false);
		ScataTxt.setBackground(new Color(52, 107, 152));
		
		ScaraField = new JTextField();
		ScaraField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		ScaraField.setColumns(10);
		
		EtajTxt.setText("Etaj");
		EtajTxt.setForeground(Color.WHITE);
		EtajTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		EtajTxt.setEditable(false);
		EtajTxt.setBackground(new Color(52, 107, 152));
		
		EtajField = new JTextField();
		EtajField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		EtajField.setColumns(10);
		
		
		ApartamentTxt.setText("Apartament");
		ApartamentTxt.setForeground(Color.WHITE);
		ApartamentTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		ApartamentTxt.setEditable(false);
		ApartamentTxt.setBackground(new Color(52, 107, 152));
		
		ApartamentField = new JTextField();
		ApartamentField.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		ApartamentField.setColumns(10);
		
		JTextPane MesajField = new JTextPane();
		MesajField.setForeground(Color.WHITE);
		MesajField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		MesajField.setEditable(false);
		MesajField.setBackground(new Color(52, 107, 152));
		GroupLayout gl_NouPacientPanel = new GroupLayout(NouPacientPanel);
		gl_NouPacientPanel.setHorizontalGroup(
			gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(Register, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
				.addGroup(gl_NouPacientPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_NouPacientPanel.createSequentialGroup()
								.addComponent(TelefonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(TelefonField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(MailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(MailField))
							.addGroup(gl_NouPacientPanel.createSequentialGroup()
								.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(CIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(CNPTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_NouPacientPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(CNPField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(SexTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(SexField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(DataNTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(DataNField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_NouPacientPanel.createSequentialGroup()
										.addGap(27)
										.addComponent(CIDField, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
						.addGroup(gl_NouPacientPanel.createSequentialGroup()
							.addComponent(LocalitateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LocalitateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(Adresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_NouPacientPanel.createSequentialGroup()
									.addComponent(StradaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(StradaField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(NrTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nrField, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addGap(127)))
					.addContainerGap())
				.addGroup(gl_NouPacientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(NumeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(NumeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(DatePersonaleTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_NouPacientPanel.createSequentialGroup()
							.addComponent(PrenumeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(PrenumeField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(209, Short.MAX_VALUE))
				.addGroup(gl_NouPacientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(blocTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(blocField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ScataTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ScaraField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(EtajTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(EtajField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ApartamentTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ApartamentField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(gl_NouPacientPanel.createSequentialGroup()
					.addGap(47)
					.addComponent(MesajField, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_NouPacientPanel.setVerticalGroup(
			gl_NouPacientPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_NouPacientPanel.createSequentialGroup()
					.addGap(26)
					.addComponent(DatePersonaleTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(NumeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PrenumeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(NumeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(PrenumeField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(TelefonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TelefonField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(MailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MailField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(CNPTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CNPField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(SexTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(SexField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(DataNTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(DataNField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(CIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CIDField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Adresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(LocalitateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LocalitateField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(StradaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(StradaField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(NrTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nrField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NouPacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(blocTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blocField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(ScataTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ScaraField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(EtajTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(EtajField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(ApartamentTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ApartamentField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(MesajField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(Register, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		NouPacientPanel.setLayout(gl_NouPacientPanel);
		
		
		
		LogInPanel.setBackground(QueenBlue);
		cardLayout.add(LogInPanel, "name_23480311010400");
		
		JTextPane NumeMedicTxt = new JTextPane();
		NumeMedicTxt.setText("Nume");
		NumeMedicTxt.setForeground(Color.WHITE);
		NumeMedicTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		NumeMedicTxt.setEditable(false);
		NumeMedicTxt.setBackground(new Color(52, 107, 152));
		
		JTextPane PrenumeMedicTxt = new JTextPane();
		PrenumeMedicTxt.setText("Prenume");
		PrenumeMedicTxt.setForeground(Color.WHITE);
		PrenumeMedicTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		PrenumeMedicTxt.setEditable(false);
		PrenumeMedicTxt.setBackground(new Color(52, 107, 152));
		
		JTextPane PasswdMedicTxt = new JTextPane();
		PasswdMedicTxt.setText("Parola");
		PasswdMedicTxt.setForeground(Color.WHITE);
		PasswdMedicTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		PasswdMedicTxt.setEditable(false);
		PasswdMedicTxt.setBackground(new Color(52, 107, 152));
		
		NumeMedicField = new JTextField();
		NumeMedicField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		NumeMedicField.setColumns(10);
		
		PrenumeMedicField = new JTextField();
		PrenumeMedicField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		PrenumeMedicField.setColumns(10);
		
		JTextPane LogInTxt = new JTextPane();
		LogInTxt.setText("LogIN");
		LogInTxt.setForeground(Color.WHITE);
		LogInTxt.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 32));
		LogInTxt.setEditable(false);
		LogInTxt.setBackground(new Color(52, 107, 152));
		
		JButton LogInMedic = new JButton("LogIN");
		
		LogInMedic.setForeground(Color.WHITE);
		LogInMedic.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		LogInMedic.setBackground(new Color(35, 76, 94));
		
		JTextPane ConectedTxt = new JTextPane();
		ConectedTxt.setForeground(Color.WHITE);
		ConectedTxt.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 37));
		ConectedTxt.setEditable(false);
		ConectedTxt.setBackground(new Color(52, 107, 152));
		
		passwordMedicField = new JPasswordField();
		passwordMedicField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		passwordMedicField.setEchoChar('*');
		GroupLayout gl_LogInPanel = new GroupLayout(LogInPanel);
		gl_LogInPanel.setHorizontalGroup(
			gl_LogInPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LogInPanel.createSequentialGroup()
					.addGroup(gl_LogInPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_LogInPanel.createSequentialGroup()
							.addGap(316)
							.addComponent(LogInTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LogInPanel.createSequentialGroup()
							.addGap(166)
							.addComponent(ConectedTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LogInPanel.createSequentialGroup()
							.addGap(157)
							.addGroup(gl_LogInPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(NumeMedicTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_LogInPanel.createSequentialGroup()
									.addGroup(gl_LogInPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(PrenumeMedicTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(PasswdMedicTxt, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_LogInPanel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_LogInPanel.createSequentialGroup()
											.addGap(27)
											.addComponent(LogInMedic, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_LogInPanel.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(passwordMedicField, Alignment.LEADING)
											.addComponent(PrenumeMedicField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
											.addComponent(NumeMedicField, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))))))
					.addGap(209))
		);
		gl_LogInPanel.setVerticalGroup(
			gl_LogInPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LogInPanel.createSequentialGroup()
					.addGap(93)
					.addComponent(LogInTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addGroup(gl_LogInPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(NumeMedicTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NumeMedicField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_LogInPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(PrenumeMedicField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PrenumeMedicTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_LogInPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LogInPanel.createSequentialGroup()
							.addComponent(PasswdMedicTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(ConectedTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(passwordMedicField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(LogInMedic, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		LogInPanel.setLayout(gl_LogInPanel);
		
		JPanel EliminarePacientPanel = new JPanel();
		EliminarePacientPanel.setBackground(QueenBlue);
		cardLayout.add(EliminarePacientPanel, "name_20669878595100");
		
		JTextPane NPacientTxt = new JTextPane();
		NPacientTxt.setText("Nume Pacient");
		NPacientTxt.setForeground(Color.WHITE);
		NPacientTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		NPacientTxt.setEditable(false);
		NPacientTxt.setBackground(new Color(52, 107, 152));
		
		JTextPane PnPacientTxt = new JTextPane();
		PnPacientTxt.setText("Prenume Pacient");
		PnPacientTxt.setForeground(Color.WHITE);
		PnPacientTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		PnPacientTxt.setEditable(false);
		PnPacientTxt.setBackground(new Color(52, 107, 152));
		
		NPacientField = new JTextField();
		NPacientField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		NPacientField.setColumns(10);
		
		PnPacientField = new JTextField();
		PnPacientField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		PnPacientField.setColumns(10);
		
		JTextPane CNPPacTxt = new JTextPane();
		CNPPacTxt.setText("CNP Pacient");
		CNPPacTxt.setForeground(Color.WHITE);
		CNPPacTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		CNPPacTxt.setEditable(false);
		CNPPacTxt.setBackground(new Color(52, 107, 152));
		
		CNPPacField = new JTextField();
		CNPPacField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		CNPPacField.setColumns(10);
		
		JButton ExecDelPacBtn = new JButton("Executa");
		
		ExecDelPacBtn.setForeground(Color.WHITE);
		ExecDelPacBtn.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		ExecDelPacBtn.setBackground(new Color(35, 76, 94));
		GroupLayout gl_EliminarePacientPanel = new GroupLayout(EliminarePacientPanel);
		gl_EliminarePacientPanel.setHorizontalGroup(
			gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EliminarePacientPanel.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_EliminarePacientPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ExecDelPacBtn, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_EliminarePacientPanel.createSequentialGroup()
							.addGroup(gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(PnPacientTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(NPacientTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CNPPacTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(NPacientField)
								.addComponent(CNPPacField)
								.addComponent(PnPacientField))))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		gl_EliminarePacientPanel.setVerticalGroup(
			gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EliminarePacientPanel.createSequentialGroup()
					.addGap(110)
					.addGroup(gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(NPacientTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NPacientField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(PnPacientTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PnPacientField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_EliminarePacientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(CNPPacField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(CNPPacTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
					.addComponent(ExecDelPacBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
		);
		EliminarePacientPanel.setLayout(gl_EliminarePacientPanel);
		
		JPanel PacientiPanel = new JPanel();
		
		PacientiPanel.setBackground(QueenBlue);
		cardLayout.add(PacientiPanel, "name_47927638726500");
		
		JButton AfiseazaPacientiBtn = new JButton("Afiseaza");
		
		AfiseazaPacientiBtn.setForeground(Color.WHITE);
		AfiseazaPacientiBtn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		AfiseazaPacientiBtn.setBackground(QueenBlue);
		
		JTextArea PacientiTxt = new JTextArea();
		PacientiTxt.setEditable(false);
		PacientiTxt.setWrapStyleWord(true);
		PacientiTxt.setTabSize(4);
		PacientiTxt.setRows(100);
		PacientiTxt.setForeground(Color.WHITE);
		PacientiTxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		PacientiTxt.setBackground(new Color(52, 107, 152));
		GroupLayout gl_PacientiPanel = new GroupLayout(PacientiPanel);
		gl_PacientiPanel.setHorizontalGroup(
			gl_PacientiPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PacientiPanel.createSequentialGroup()
					.addGroup(gl_PacientiPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PacientiPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(PacientiTxt, GroupLayout.PREFERRED_SIZE, 704, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_PacientiPanel.createSequentialGroup()
							.addGap(297)
							.addComponent(AfiseazaPacientiBtn)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_PacientiPanel.setVerticalGroup(
			gl_PacientiPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PacientiPanel.createSequentialGroup()
					.addGap(51)
					.addComponent(AfiseazaPacientiBtn)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(PacientiTxt, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE))
		);
		PacientiPanel.setLayout(gl_PacientiPanel);
		
		JPanel QuerriesPanel = new JPanel();
		QuerriesPanel.setBackground(QueenBlue);
		cardLayout.add(QuerriesPanel, "name_6586802292200");
		
		JButton AsigBtn = new JButton("Asigurari");
		AsigBtn.setForeground(Color.WHITE);
		
		AsigBtn.setBackground(TyrianPurple);
		
		AsigBtn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));

		
		JTextArea txtAreaAsig = new JTextArea();
		txtAreaAsig.setText("Interogari referitoare la asigurari");
		txtAreaAsig.setEditable(false);
		txtAreaAsig.setForeground(Color.WHITE);
		txtAreaAsig.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtAreaAsig.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrInterogariReferitoareLa = new JTextArea();
		txtrInterogariReferitoareLa.setText("Interogari referitoare la boli specifice");
		txtrInterogariReferitoareLa.setForeground(Color.WHITE);
		txtrInterogariReferitoareLa.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrInterogariReferitoareLa.setEditable(false);
		txtrInterogariReferitoareLa.setBackground(new Color(52, 107, 152));
		
		JButton BoliBtn1 = new JButton("Boli 1");
		BoliBtn1.setForeground(Color.WHITE);
		
		BoliBtn1.setBackground(TyrianPurple);
		
		BoliBtn1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		
		
		
		JTextArea txtrInterogariGeneraleReferitoare = new JTextArea();
		txtrInterogariGeneraleReferitoare.setText("Interogari generale referitoare la boli");
		txtrInterogariGeneraleReferitoare.setForeground(Color.WHITE);
		txtrInterogariGeneraleReferitoare.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrInterogariGeneraleReferitoare.setEditable(false);
		txtrInterogariGeneraleReferitoare.setBackground(new Color(52, 107, 152));
		
		JButton BoliBtn2 = new JButton("Boli 2");
		BoliBtn2.setForeground(Color.WHITE);
		
		BoliBtn2.setBackground(TyrianPurple);
		
		BoliBtn2.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		
		JTextArea txtrUpdateTabele = new JTextArea();
		txtrUpdateTabele.setText("Update tabele");
		txtrUpdateTabele.setForeground(Color.WHITE);
		txtrUpdateTabele.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrUpdateTabele.setEditable(false);
		txtrUpdateTabele.setBackground(new Color(52, 107, 152));
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnUpdate.setBackground(new Color(82, 0, 41));
		
		JTextArea txtrUpdateTabele_1 = new JTextArea();
		txtrUpdateTabele_1.setText("Update tabele 2");
		txtrUpdateTabele_1.setForeground(Color.WHITE);
		txtrUpdateTabele_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrUpdateTabele_1.setEditable(false);
		txtrUpdateTabele_1.setBackground(new Color(52, 107, 152));
		
		JButton btnUpdate_1 = new JButton("Update2");
		
		btnUpdate_1.setForeground(Color.WHITE);
		btnUpdate_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnUpdate_1.setBackground(new Color(82, 0, 41));
		
		
		GroupLayout gl_QuerriesPanel = new GroupLayout(QuerriesPanel);
		gl_QuerriesPanel.setHorizontalGroup(
			gl_QuerriesPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_QuerriesPanel.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrInterogariReferitoareLa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAreaAsig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrInterogariGeneraleReferitoare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrUpdateTabele, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrUpdateTabele_1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdate_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoliBtn2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(AsigBtn, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoliBtn1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addGap(120))
		);
		gl_QuerriesPanel.setVerticalGroup(
			gl_QuerriesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QuerriesPanel.createSequentialGroup()
					.addGap(188)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAreaAsig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AsigBtn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_QuerriesPanel.createSequentialGroup()
							.addGap(52)
							.addComponent(txtrInterogariReferitoareLa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_QuerriesPanel.createSequentialGroup()
							.addGap(50)
							.addComponent(BoliBtn1)))
					.addGap(53)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrInterogariGeneraleReferitoare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BoliBtn2))
					.addGap(53)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtrUpdateTabele, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_QuerriesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrUpdateTabele_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		QuerriesPanel.setLayout(gl_QuerriesPanel);
		
		JPanel AsigPanel = new JPanel();
		AsigPanel.setBackground(QueenBlue);
		cardLayout.add(AsigPanel, "name_8187936641000");
		
		JTextArea txtArea3 = new JTextArea();
		txtArea3.setLineWrap(true);
		txtArea3.setText("Selectati toate serviciile de asigurari (si preturile acestora, in ordine crescatoare dupa pret) care sunt facute la adresa:");
		txtArea3.setForeground(Color.WHITE);
		txtArea3.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtArea3.setEditable(false);
		txtArea3.setBackground(new Color(52, 107, 152));
		
		JButton btn13 = new JButton("executa");
		
		btn13.setForeground(Color.WHITE);
		btn13.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn13.setBackground(TyrianPurple);
		
		JButton btnNou1 = new JButton("Executa");
		
		btnNou1.setForeground(Color.WHITE);
		btnNou1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnNou1.setBackground(TyrianPurple);
		
		JTextArea txtArea4 = new JTextArea();
		txtArea4.setText("Selectati pacientii nascuti dupa 2000-01-01 care au asigurare la agentia de asigurare:");
		txtArea4.setLineWrap(true);
		txtArea4.setForeground(Color.WHITE);
		txtArea4.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtArea4.setEditable(false);
		txtArea4.setBackground(new Color(52, 107, 152));
		
		JButton btn14 = new JButton("executa");
		
		btn14.setForeground(Color.WHITE);
		btn14.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn14.setBackground(TyrianPurple);
		
		JTextArea txtrSelectatiPacientiiNascuti = new JTextArea();
		txtrSelectatiPacientiiNascuti.setText("Selectati suma platita de fiecare pacient in parte pentru tratamentul tuturor bolilor  ");
		txtrSelectatiPacientiiNascuti.setLineWrap(true);
		txtrSelectatiPacientiiNascuti.setForeground(Color.WHITE);
		txtrSelectatiPacientiiNascuti.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectatiPacientiiNascuti.setEditable(false);
		txtrSelectatiPacientiiNascuti.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrSelectatiTotiMedicii = new JTextArea();
		txtrSelectatiTotiMedicii.setText("Selectati toti medicii care trateaza pacientii de la o anumita adresa");
		txtrSelectatiTotiMedicii.setLineWrap(true);
		txtrSelectatiTotiMedicii.setForeground(Color.WHITE);
		txtrSelectatiTotiMedicii.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectatiTotiMedicii.setEditable(false);
		txtrSelectatiTotiMedicii.setBackground(new Color(52, 107, 152));
		
		JButton button_5 = new JButton("Executa");
		
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		button_5.setBackground(new Color(82, 0, 41));
		GroupLayout gl_AsigPanel = new GroupLayout(AsigPanel);
		gl_AsigPanel.setHorizontalGroup(
			gl_AsigPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(281)
					.addComponent(btn13, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(72)
					.addComponent(txtArea3, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(270)
					.addComponent(btn14, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(311, Short.MAX_VALUE))
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_AsigPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AsigPanel.createSequentialGroup()
							.addComponent(txtrSelectatiPacientiiNascuti, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_AsigPanel.createSequentialGroup()
							.addComponent(txtArea4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(88))))
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(279)
					.addComponent(btnNou1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(302, Short.MAX_VALUE))
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(59)
					.addComponent(txtrSelectatiTotiMedicii, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(275)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		gl_AsigPanel.setVerticalGroup(
			gl_AsigPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AsigPanel.createSequentialGroup()
					.addGap(46)
					.addComponent(txtArea3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn13, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(txtArea4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn14, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(txtrSelectatiPacientiiNascuti, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnNou1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtrSelectatiTotiMedicii, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		AsigPanel.setLayout(gl_AsigPanel);
		
		JPanel Boli1Panel = new JPanel();
		Boli1Panel.setBackground(QueenBlue);
		cardLayout.add(Boli1Panel, "name_8269236350900");
		
		txtArea2 = new JTextArea();
		txtArea2.setText("Selectati numele tuturor pacientilor care stau la o adresa detinuta de un pacient bolnav de boala:");
		txtArea2.setLineWrap(true);
		txtArea2.setForeground(Color.WHITE);
		txtArea2.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtArea2.setEditable(false);
		txtArea2.setBackground(new Color(52, 107, 152));
		
		JButton btn12 = new JButton("executa");

		btn12.setForeground(Color.WHITE);
		btn12.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn12.setBackground(TyrianPurple);
		
		JTextArea txtArea6 = new JTextArea();
		txtArea6.setText("Selectati toti medicii care trateaza pacientii de boala:");
		txtArea6.setLineWrap(true);
		txtArea6.setForeground(Color.WHITE);
		txtArea6.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtArea6.setEditable(false);
		txtArea6.setBackground(new Color(52, 107, 152));
		
		JButton btn16 = new JButton("executa");
		
		btn16.setForeground(Color.WHITE);
		btn16.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn16.setBackground(TyrianPurple);
		
		JButton btn26 = new JButton("executa");
	
		btn26.setForeground(Color.WHITE);
		btn26.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn26.setBackground(TyrianPurple);
		
		JTextArea txtrSelectatiTotiPacientii = new JTextArea();
		txtrSelectatiTotiPacientii.setText("Selectati toti pacientii care sufera de mai mult de 2 boli nascuti inainte de 2000-01-01");
		txtrSelectatiTotiPacientii.setLineWrap(true);
		txtrSelectatiTotiPacientii.setForeground(Color.WHITE);
		txtrSelectatiTotiPacientii.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectatiTotiPacientii.setEditable(false);
		txtrSelectatiTotiPacientii.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrSelectatiPacientiiNascuti_1 = new JTextArea();
		txtrSelectatiPacientiiNascuti_1.setText("Selectati pacientii tratati de un anumit medic care  nu stau la o anumita adresa");
		txtrSelectatiPacientiiNascuti_1.setLineWrap(true);
		txtrSelectatiPacientiiNascuti_1.setForeground(Color.WHITE);
		txtrSelectatiPacientiiNascuti_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectatiPacientiiNascuti_1.setEditable(false);
		txtrSelectatiPacientiiNascuti_1.setBackground(new Color(52, 107, 152));
		
		JButton button_2 = new JButton("executa");
		
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		button_2.setBackground(new Color(82, 0, 41));
		GroupLayout gl_Boli1Panel = new GroupLayout(Boli1Panel);
		gl_Boli1Panel.setHorizontalGroup(
			gl_Boli1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Boli1Panel.createSequentialGroup()
					.addGroup(gl_Boli1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Boli1Panel.createSequentialGroup()
							.addGap(291)
							.addComponent(btn12, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Boli1Panel.createSequentialGroup()
							.addGap(67)
							.addComponent(txtArea6, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Boli1Panel.createSequentialGroup()
							.addGap(287)
							.addComponent(btn16, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Boli1Panel.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_Boli1Panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtrSelectatiTotiPacientii, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtArea2, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(gl_Boli1Panel.createSequentialGroup()
					.addGap(294)
					.addComponent(btn26, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(287, Short.MAX_VALUE))
				.addGroup(gl_Boli1Panel.createSequentialGroup()
					.addGap(49)
					.addComponent(txtrSelectatiPacientiiNascuti_1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
				.addGroup(gl_Boli1Panel.createSequentialGroup()
					.addGap(307)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(274, Short.MAX_VALUE))
		);
		gl_Boli1Panel.setVerticalGroup(
			gl_Boli1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Boli1Panel.createSequentialGroup()
					.addGap(58)
					.addComponent(txtArea2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btn12, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(txtArea6, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn16, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(txtrSelectatiTotiPacientii, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn26, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(txtrSelectatiPacientiiNascuti_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		Boli1Panel.setLayout(gl_Boli1Panel);
		
		JPanel Boli2Panel = new JPanel();
		Boli2Panel.setBackground(QueenBlue);
		cardLayout.add(Boli2Panel, "name_8315574296900");
		
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setText("Selectati toti pacientii care sufera de mai putin de 2 boli");
		txtArea1.setLineWrap(true);
		txtArea1.setForeground(Color.WHITE);
		txtArea1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtArea1.setEditable(false);
		txtArea1.setBackground(new Color(52, 107, 152));
		
		JButton btn11 = new JButton("executa");
		
		btn11.setForeground(Color.WHITE);
		btn11.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn11.setBackground(TyrianPurple);
		
		JTextArea txtArea5 = new JTextArea();
		txtArea5.setText("Selectati suma platita de fiecare pacient in parte pentru tratamentul fiecarei boli");
		txtArea5.setLineWrap(true);
		txtArea5.setForeground(Color.WHITE);
		txtArea5.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtArea5.setEditable(false);
		txtArea5.setBackground(new Color(52, 107, 152));
		
		JButton btn15 = new JButton("executa");
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn15.setForeground(Color.WHITE);
		btn15.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btn15.setBackground(TyrianPurple);
		
		JButton button_3 = new JButton("executa");
		
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		button_3.setBackground(new Color(82, 0, 41));
		
		JTextArea txtrMediciiCareTrateaza = new JTextArea();
		txtrMediciiCareTrateaza.setText("Medicii care trateaza bolnavi de la adresele care nu au o anumita boala");
		txtrMediciiCareTrateaza.setLineWrap(true);
		txtrMediciiCareTrateaza.setForeground(Color.WHITE);
		txtrMediciiCareTrateaza.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrMediciiCareTrateaza.setEditable(false);
		txtrMediciiCareTrateaza.setBackground(new Color(52, 107, 152));
		GroupLayout gl_Boli2Panel = new GroupLayout(Boli2Panel);
		gl_Boli2Panel.setHorizontalGroup(
			gl_Boli2Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Boli2Panel.createSequentialGroup()
					.addGroup(gl_Boli2Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Boli2Panel.createSequentialGroup()
							.addGap(79)
							.addGroup(gl_Boli2Panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Boli2Panel.createSequentialGroup()
									.addGap(181)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtArea1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtArea5, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Boli2Panel.createSequentialGroup()
									.addGap(174)
									.addComponent(btn11, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Boli2Panel.createSequentialGroup()
									.addGap(181)
									.addComponent(btn15, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Boli2Panel.createSequentialGroup()
							.addGap(91)
							.addComponent(txtrMediciiCareTrateaza, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_Boli2Panel.setVerticalGroup(
			gl_Boli2Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Boli2Panel.createSequentialGroup()
					.addGap(68)
					.addComponent(txtArea1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn11, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(txtArea5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btn15, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrMediciiCareTrateaza, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(284, Short.MAX_VALUE))
		);
		Boli2Panel.setLayout(gl_Boli2Panel);
		
		JPanel Querry1 = new JPanel();
		Querry1.setBackground(QueenBlue);
		cardLayout.add(Querry1, "name_11408227228700");
		
		JTextArea titlu1 = new JTextArea();
		titlu1.setText("Pacientii care sufera de mai putin de 2 boli sunt:");
		titlu1.setLineWrap(true);
		titlu1.setForeground(Color.WHITE);
		titlu1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		titlu1.setEditable(false);
		titlu1.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(52, 107, 152));
		
		JButton q1btn = new JButton("executa");
		q1btn.setBackground(TyrianPurple);
		q1btn.setForeground(Color.WHITE);
		q1btn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		GroupLayout gl_Querry1 = new GroupLayout(Querry1);
		gl_Querry1.setHorizontalGroup(
			gl_Querry1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry1.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
						.addComponent(titlu1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
						.addComponent(q1btn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_Querry1.setVerticalGroup(
			gl_Querry1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry1.createSequentialGroup()
					.addContainerGap()
					.addComponent(q1btn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(titlu1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
					.addContainerGap())
		);
		Querry1.setLayout(gl_Querry1);
		
		JPanel Querry2 = new JPanel();
		Querry2.setBackground(QueenBlue);
		cardLayout.add(Querry2, "name_11431212890400");
		
		JTextArea txtrSelectieDupaBoala = new JTextArea();
		txtrSelectieDupaBoala.setText("Selectie dupa boala:");
		txtrSelectieDupaBoala.setLineWrap(true);
		txtrSelectieDupaBoala.setForeground(Color.WHITE);
		txtrSelectieDupaBoala.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectieDupaBoala.setEditable(false);
		txtrSelectieDupaBoala.setBackground(new Color(52, 107, 152));
		
		JPanel panel = new JPanel();
		panel.setBackground(QueenBlue);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(QueenBlue);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(QueenBlue);
		
		JButton q2btn = new JButton("executa");
		q2btn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		q2btn.setBackground(TyrianPurple);
		q2btn.setForeground(Color.WHITE);
		GroupLayout gl_Querry2 = new GroupLayout(Querry2);
		gl_Querry2.setHorizontalGroup(
			gl_Querry2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry2.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_Querry2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Querry2.createSequentialGroup()
							.addComponent(q2btn, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(159)
							.addComponent(txtrSelectieDupaBoala, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
						.addGroup(gl_Querry2.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Querry2.setVerticalGroup(
			gl_Querry2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry2.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrSelectieDupaBoala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(q2btn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Querry2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setForeground(Color.WHITE);
		textArea_2.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_2.setEditable(false);
		textArea_2.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JTextArea txtrListaBoli = new JTextArea();
		txtrListaBoli.setText("Lista Boli:");
		txtrListaBoli.setForeground(Color.WHITE);
		txtrListaBoli.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrListaBoli.setEditable(false);
		txtrListaBoli.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea.setEditable(false);
		textArea.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtrListaBoli, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrListaBoli, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JTextArea ttle2 = new JTextArea();
		ttle2.setText("Introduceti boala dupa care se ");
		ttle2.setForeground(Color.WHITE);
		ttle2.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		ttle2.setEditable(false);
		ttle2.setBackground(new Color(52, 107, 152));
		
		JTextArea ttle3 = new JTextArea();
		ttle3.setText("executa selectia");
		ttle3.setForeground(Color.WHITE);
		ttle3.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		ttle3.setEditable(false);
		ttle3.setBackground(new Color(52, 107, 152));
		
		Boala1Txt = new JTextField();
		Boala1Txt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		Boala1Txt.setColumns(10);
		
		JTextArea txtrBoala = new JTextArea();
		txtrBoala.setText("Boala:");
		txtrBoala.setForeground(Color.WHITE);
		txtrBoala.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrBoala.setEditable(false);
		txtrBoala.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ttle2, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(31)
								.addComponent(txtrBoala, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Boala1Txt))
							.addComponent(ttle3, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ttle2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ttle3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Boala1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrBoala, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		Querry2.setLayout(gl_Querry2);
		
		JPanel Querry3 = new JPanel();
		Querry3.setBackground(QueenBlue);
		cardLayout.add(Querry3, "name_11455505428300");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(52, 107, 152));
		
		Strada1Txt = new JTextField();
		Strada1Txt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		Strada1Txt.setColumns(10);
		
		JTextArea txtrStrada = new JTextArea();
		txtrStrada.setText("Localitate:");
		txtrStrada.setForeground(Color.WHITE);
		txtrStrada.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrStrada.setEditable(false);
		txtrStrada.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrIntroducetiLocalitateaSi = new JTextArea();
		txtrIntroducetiLocalitateaSi.setText("Introduceti localitatea si strada ");
		txtrIntroducetiLocalitateaSi.setForeground(Color.WHITE);
		txtrIntroducetiLocalitateaSi.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrIntroducetiLocalitateaSi.setEditable(false);
		txtrIntroducetiLocalitateaSi.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrSeExecutaSelectia = new JTextArea();
		txtrSeExecutaSelectia.setText("dupa care se executa selectia");
		txtrSeExecutaSelectia.setForeground(Color.WHITE);
		txtrSeExecutaSelectia.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSeExecutaSelectia.setEditable(false);
		txtrSeExecutaSelectia.setBackground(new Color(52, 107, 152));
		
		Localitate1txt = new JTextField();
		Localitate1txt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		Localitate1txt.setColumns(10);
		
		JTextArea txtrLocalitate = new JTextArea();
		txtrLocalitate.setText("Strada:");
		txtrLocalitate.setForeground(Color.WHITE);
		txtrLocalitate.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrLocalitate.setEditable(false);
		txtrLocalitate.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrIntroducetiLocalitateaSi, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtrSeExecutaSelectia, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_3.createSequentialGroup()
											.addComponent(txtrLocalitate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(41)
											.addComponent(Localitate1txt, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
										.addGroup(gl_panel_3.createSequentialGroup()
											.addComponent(txtrStrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Strada1Txt)))
									.addGap(12)))))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrIntroducetiLocalitateaSi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrSeExecutaSelectia, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrStrada, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(Strada1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrLocalitate, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(Localitate1txt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JTextArea txtrSelectieDupaAdresa = new JTextArea();
		txtrSelectieDupaAdresa.setText("Selectie dupa adresa");
		txtrSelectieDupaAdresa.setLineWrap(true);
		txtrSelectieDupaAdresa.setForeground(Color.WHITE);
		txtrSelectieDupaAdresa.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectieDupaAdresa.setEditable(false);
		txtrSelectieDupaAdresa.setBackground(new Color(52, 107, 152));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrListaAdrese = new JTextArea();
		txtrListaAdrese.setText("Lista Adrese:");
		txtrListaAdrese.setForeground(Color.WHITE);
		txtrListaAdrese.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrListaAdrese.setEditable(false);
		txtrListaAdrese.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setForeground(Color.WHITE);
		textArea_8.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_8.setEditable(false);
		textArea_8.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(textArea_8, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(txtrListaAdrese, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrListaAdrese, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_8, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setForeground(Color.WHITE);
		textArea_9.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_9.setEditable(false);
		textArea_9.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_9, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 266, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_9, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JButton q3btn = new JButton("executa");
		q3btn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		q3btn.setBackground(TyrianPurple);
		q3btn.setForeground(Color.WHITE);
		GroupLayout gl_Querry3 = new GroupLayout(Querry3);
		gl_Querry3.setHorizontalGroup(
			gl_Querry3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Querry3.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
							.addGap(25))
						.addGroup(gl_Querry3.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
							.addGap(20))
						.addGroup(gl_Querry3.createSequentialGroup()
							.addComponent(q3btn, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(156)
							.addComponent(txtrSelectieDupaAdresa, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(232))))
		);
		gl_Querry3.setVerticalGroup(
			gl_Querry3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry3.createSequentialGroup()
					.addGroup(gl_Querry3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Querry3.createSequentialGroup()
							.addGap(19)
							.addComponent(txtrSelectieDupaAdresa, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Querry3.createSequentialGroup()
							.addContainerGap()
							.addComponent(q3btn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Querry3.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
					.addGap(12))
		);
		Querry3.setLayout(gl_Querry3);
		
		JPanel Querry4 = new JPanel();
		Querry4.setBackground(QueenBlue);
		cardLayout.add(Querry4, "name_11465754995400");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrIntroducetiBoalaAsigurarea = new JTextArea();
		txtrIntroducetiBoalaAsigurarea.setText("Introduceti asigurarea care ");
		txtrIntroducetiBoalaAsigurarea.setForeground(Color.WHITE);
		txtrIntroducetiBoalaAsigurarea.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrIntroducetiBoalaAsigurarea.setEditable(false);
		txtrIntroducetiBoalaAsigurarea.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrAsigurare = new JTextArea();
		txtrAsigurare.setText("Asigurare:");
		txtrAsigurare.setForeground(Color.WHITE);
		txtrAsigurare.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrAsigurare.setEditable(false);
		txtrAsigurare.setBackground(new Color(52, 107, 152));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textField_2.setColumns(10);
		
		JTextArea txtrSeExecutaSelectia_1 = new JTextArea();
		txtrSeExecutaSelectia_1.setText("se executa selectia");
		txtrSeExecutaSelectia_1.setForeground(Color.WHITE);
		txtrSeExecutaSelectia_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSeExecutaSelectia_1.setEditable(false);
		txtrSeExecutaSelectia_1.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtrIntroducetiBoalaAsigurarea, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_6.createSequentialGroup()
							.addGap(17)
							.addComponent(txtrAsigurare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2))
						.addComponent(txtrSeExecutaSelectia_1, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrIntroducetiBoalaAsigurarea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrSeExecutaSelectia_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrAsigurare, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(197, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JTextArea txtrSelectieDupaAsigurare = new JTextArea();
		txtrSelectieDupaAsigurare.setText("Selectie dupa asigurare:");
		txtrSelectieDupaAsigurare.setLineWrap(true);
		txtrSelectieDupaAsigurare.setForeground(Color.WHITE);
		txtrSelectieDupaAsigurare.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectieDupaAsigurare.setEditable(false);
		txtrSelectieDupaAsigurare.setBackground(new Color(52, 107, 152));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setForeground(Color.WHITE);
		textArea_14.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_14.setEditable(false);
		textArea_14.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrListaAsigurari = new JTextArea();
		txtrListaAsigurari.setText("Lista Asigurari:");
		txtrListaAsigurari.setForeground(Color.WHITE);
		txtrListaAsigurari.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrListaAsigurari.setEditable(false);
		txtrListaAsigurari.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(textArea_14, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(txtrListaAsigurari, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 362, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrListaAsigurari, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_14, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_16 = new JTextArea();
		textArea_16.setForeground(Color.WHITE);
		textArea_16.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_16.setEditable(false);
		textArea_16.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_16, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 266, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_16, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_8.setLayout(gl_panel_8);
		
		JButton q4btn = new JButton("executa");
		q4btn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		q4btn.setBackground(TyrianPurple);
		q4btn.setForeground(Color.WHITE);
		GroupLayout gl_Querry4 = new GroupLayout(Querry4);
		gl_Querry4.setHorizontalGroup(
			gl_Querry4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Querry4.createSequentialGroup()
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_Querry4.createSequentialGroup()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 347, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_Querry4.createSequentialGroup()
							.addComponent(q4btn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(146)
							.addComponent(txtrSelectieDupaAsigurare, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_Querry4.setVerticalGroup(
			gl_Querry4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry4.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrSelectieDupaAsigurare, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(q4btn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Querry4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		Querry4.setLayout(gl_Querry4);
		
		JPanel Querry5 = new JPanel();
		Querry5.setBackground(QueenBlue);
		cardLayout.add(Querry5, "name_11477762781000");
		
		JTextArea txtrSelectieDupaCnp = new JTextArea();
		txtrSelectieDupaCnp.setText("Selectie dupa CNP:");
		txtrSelectieDupaCnp.setLineWrap(true);
		txtrSelectieDupaCnp.setForeground(Color.WHITE);
		txtrSelectieDupaCnp.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrSelectieDupaCnp.setEditable(false);
		txtrSelectieDupaCnp.setBackground(new Color(52, 107, 152));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrIntroducetiCnpulDupa = new JTextArea();
		txtrIntroducetiCnpulDupa.setText("Introduceti CNP-ul dupa care se ");
		txtrIntroducetiCnpulDupa.setForeground(Color.WHITE);
		txtrIntroducetiCnpulDupa.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrIntroducetiCnpulDupa.setEditable(false);
		txtrIntroducetiCnpulDupa.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrCnp = new JTextArea();
		txtrCnp.setText("CNP:");
		txtrCnp.setForeground(Color.WHITE);
		txtrCnp.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrCnp.setEditable(false);
		txtrCnp.setBackground(new Color(52, 107, 152));
		
		CNPtxt = new JTextField();
		CNPtxt.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		CNPtxt.setColumns(10);
		
		JTextArea textArea_20 = new JTextArea();
		textArea_20.setText("executa selectia");
		textArea_20.setForeground(Color.WHITE);
		textArea_20.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_20.setEditable(false);
		textArea_20.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 347, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrIntroducetiCnpulDupa, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_9.createSequentialGroup()
							.addGap(31)
							.addComponent(txtrCnp, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CNPtxt))
						.addComponent(textArea_20, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 362, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrIntroducetiCnpulDupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_20, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(CNPtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrCnp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(197, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_21 = new JTextArea();
		textArea_21.setForeground(Color.WHITE);
		textArea_21.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_21.setEditable(false);
		textArea_21.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrListaPersoane = new JTextArea();
		txtrListaPersoane.setText("Lista Persoane:");
		txtrListaPersoane.setForeground(Color.WHITE);
		txtrListaPersoane.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrListaPersoane.setEditable(false);
		txtrListaPersoane.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_10.createSequentialGroup()
							.addComponent(textArea_21, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_10.createSequentialGroup()
							.addComponent(txtrListaPersoane, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 362, Short.MAX_VALUE)
				.addGap(0, 362, Short.MAX_VALUE)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrListaPersoane, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_21, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_10.setLayout(gl_panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_23 = new JTextArea();
		textArea_23.setForeground(Color.WHITE);
		textArea_23.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_23.setEditable(false);
		textArea_23.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_23, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 277, Short.MAX_VALUE)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_23, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_11.setLayout(gl_panel_11);
		
		JButton q5btn = new JButton("executa");
		q5btn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		q5btn.setBackground(TyrianPurple);
		q5btn.setForeground(Color.WHITE);
		GroupLayout gl_Querry5 = new GroupLayout(Querry5);
		gl_Querry5.setHorizontalGroup(
			gl_Querry5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Querry5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Querry5.createSequentialGroup()
							.addComponent(q5btn)
							.addGap(193)
							.addComponent(txtrSelectieDupaCnp, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(228, Short.MAX_VALUE))
						.addGroup(gl_Querry5.createSequentialGroup()
							.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_Querry5.createSequentialGroup()
							.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
							.addGap(20))))
		);
		gl_Querry5.setVerticalGroup(
			gl_Querry5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry5.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrSelectieDupaCnp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(q5btn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Querry5.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
					.addContainerGap())
		);
		Querry5.setLayout(gl_Querry5);
		
		JPanel Querry6 = new JPanel();
		Querry6.setBackground(QueenBlue);
		cardLayout.add(Querry6, "name_11486128263900");
		
		JTextArea textArea_24 = new JTextArea();
		textArea_24.setText("Selectie dupa boala:");
		textArea_24.setLineWrap(true);
		textArea_24.setForeground(Color.WHITE);
		textArea_24.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_24.setEditable(false);
		textArea_24.setBackground(new Color(52, 107, 152));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_25 = new JTextArea();
		textArea_25.setText("Introduceti boala dupa care se ");
		textArea_25.setForeground(Color.WHITE);
		textArea_25.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_25.setEditable(false);
		textArea_25.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_26 = new JTextArea();
		textArea_26.setText("Boala:");
		textArea_26.setForeground(Color.WHITE);
		textArea_26.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_26.setEditable(false);
		textArea_26.setBackground(new Color(52, 107, 152));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textField_4.setColumns(10);
		
		JTextArea textArea_27 = new JTextArea();
		textArea_27.setText("executa selectia");
		textArea_27.setForeground(Color.WHITE);
		textArea_27.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_27.setEditable(false);
		textArea_27.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGap(0, 347, Short.MAX_VALUE)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_12.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea_25, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_12.createSequentialGroup()
							.addGap(31)
							.addComponent(textArea_26, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4))
						.addComponent(textArea_27, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_27, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_26, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		panel_12.setLayout(gl_panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_28 = new JTextArea();
		textArea_28.setForeground(Color.WHITE);
		textArea_28.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_28.setEditable(false);
		textArea_28.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_29 = new JTextArea();
		textArea_29.setText("Lista Boli:");
		textArea_29.setForeground(Color.WHITE);
		textArea_29.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_29.setEditable(false);
		textArea_29.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_13.createSequentialGroup()
							.addComponent(textArea_28, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_13.createSequentialGroup()
							.addComponent(textArea_29, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGap(0, 356, Short.MAX_VALUE)
				.addGap(0, 362, Short.MAX_VALUE)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_29, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_28, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_13.setLayout(gl_panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_30 = new JTextArea();
		textArea_30.setForeground(Color.WHITE);
		textArea_30.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_30.setEditable(false);
		textArea_30.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_30, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGap(0, 277, Short.MAX_VALUE)
				.addGap(0, 277, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_30, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_14.setLayout(gl_panel_14);
		
		JButton q6btn = new JButton("executa");
		q6btn.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		q6btn.setBackground(TyrianPurple);
		q6btn.setForeground(Color.WHITE);
		GroupLayout gl_Querry6 = new GroupLayout(Querry6);
		gl_Querry6.setHorizontalGroup(
			gl_Querry6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Querry6.createSequentialGroup()
							.addGroup(gl_Querry6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Querry6.createSequentialGroup()
									.addComponent(q6btn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(124)
									.addComponent(textArea_24, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Querry6.createSequentialGroup()
									.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(14))
						.addGroup(gl_Querry6.createSequentialGroup()
							.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
							.addGap(20))))
		);
		gl_Querry6.setVerticalGroup(
			gl_Querry6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Querry6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Querry6.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_24, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(q6btn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Querry6.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_12, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
						.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 358, Short.MAX_VALUE))
					.addGap(24)
					.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addContainerGap())
		);
		Querry6.setLayout(gl_Querry6);
		
		JPanel Update = new JPanel();
		Update.setBackground(QueenBlue);
		cardLayout.add(Update, "name_11962900221300");
		Update.setLayout(null);
		
		JPanel ce = new JPanel();
		ce.setBackground(QueenBlue);
		ce.setBounds(12, 5, 349, 709);
		Update.add(ce);
		
		JTextArea txtrCnp_1 = new JTextArea();
		txtrCnp_1.setText("CNP:");
		txtrCnp_1.setForeground(Color.WHITE);
		txtrCnp_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrCnp_1.setEditable(false);
		txtrCnp_1.setBackground(new Color(52, 107, 152));
		
		CnpField = new JTextField();
		CnpField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		CnpField.setColumns(10);
		
		JButton btnSchimbaAsigurare = new JButton("Schimba Asigurare");
		
		btnSchimbaAsigurare.setForeground(Color.WHITE);
		btnSchimbaAsigurare.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnSchimbaAsigurare.setBackground(new Color(82, 0, 41));
		
		JTextArea txtrAsigurare_1 = new JTextArea();
		txtrAsigurare_1.setText("Asigurare:");
		txtrAsigurare_1.setForeground(Color.WHITE);
		txtrAsigurare_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrAsigurare_1.setEditable(false);
		txtrAsigurare_1.setBackground(new Color(52, 107, 152));
		
		AsigField = new JTextField();
		AsigField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		AsigField.setColumns(10);
		GroupLayout gl_ce = new GroupLayout(ce);
		gl_ce.setHorizontalGroup(
			gl_ce.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ce.createSequentialGroup()
					.addGap(77)
					.addComponent(btnSchimbaAsigurare)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_ce.createSequentialGroup()
					.addGroup(gl_ce.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ce.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtrCnp_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(CnpField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
						.addGroup(gl_ce.createSequentialGroup()
							.addGap(33)
							.addComponent(txtrAsigurare_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AsigField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
					.addGap(24))
		);
		gl_ce.setVerticalGroup(
			gl_ce.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ce.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_ce.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ce.createSequentialGroup()
							.addGap(1)
							.addComponent(txtrCnp_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(CnpField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(263)
					.addGroup(gl_ce.createParallelGroup(Alignment.LEADING)
						.addComponent(AsigField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ce.createSequentialGroup()
							.addGap(1)
							.addComponent(txtrAsigurare_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnSchimbaAsigurare, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(256, Short.MAX_VALUE))
		);
		ce.setLayout(gl_ce);
		
		JPanel in = new JPanel();
		in.setBackground(QueenBlue);
		in.setBounds(366, 5, 350, 709);
		Update.add(in);
		
		JTextArea txtrBoala_1 = new JTextArea();
		txtrBoala_1.setText("Boala:");
		txtrBoala_1.setForeground(Color.WHITE);
		txtrBoala_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrBoala_1.setEditable(false);
		txtrBoala_1.setBackground(new Color(52, 107, 152));
		
		BoalaField = new JTextField();
		BoalaField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		BoalaField.setColumns(10);
		
		JButton btnSchimbaBoala = new JButton("Schimba Boala");
		
		btnSchimbaBoala.setForeground(Color.WHITE);
		btnSchimbaBoala.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnSchimbaBoala.setBackground(new Color(82, 0, 41));
		
		JTextArea txtrNume = new JTextArea();
		txtrNume.setText("Nume:");
		txtrNume.setForeground(Color.WHITE);
		txtrNume.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrNume.setEditable(false);
		txtrNume.setBackground(new Color(52, 107, 152));
		
		Nume2Field = new JTextField();
		Nume2Field.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		Nume2Field.setColumns(10);
		
		JButton btnSchimbaNume = new JButton("Schimba Nume");
		
		btnSchimbaNume.setForeground(Color.WHITE);
		btnSchimbaNume.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnSchimbaNume.setBackground(new Color(82, 0, 41));
		
		JTextArea txtrPrenume = new JTextArea();
		txtrPrenume.setText("Prenume:");
		txtrPrenume.setForeground(Color.WHITE);
		txtrPrenume.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrPrenume.setEditable(false);
		txtrPrenume.setBackground(new Color(52, 107, 152));
		
		Prenume2Field = new JTextField();
		Prenume2Field.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		Prenume2Field.setColumns(10);
		
		JButton btnSchimbaPreume = new JButton("Schimba Preume");
		
		btnSchimbaPreume.setForeground(Color.WHITE);
		btnSchimbaPreume.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnSchimbaPreume.setBackground(new Color(82, 0, 41));
		
		JTextArea txtrMedic = new JTextArea();
		txtrMedic.setText("Medic:");
		txtrMedic.setForeground(Color.WHITE);
		txtrMedic.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrMedic.setEditable(false);
		txtrMedic.setBackground(new Color(52, 107, 152));
		
		MedicField = new JTextField();
		MedicField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		MedicField.setColumns(10);
		
		JButton btnSchimbaMedic = new JButton("Schimba Medic");
		
		btnSchimbaMedic.setForeground(Color.WHITE);
		btnSchimbaMedic.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		btnSchimbaMedic.setBackground(new Color(82, 0, 41));
		GroupLayout gl_in = new GroupLayout(in);
		gl_in.setHorizontalGroup(
			gl_in.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_in.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_in.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_in.createSequentialGroup()
							.addComponent(txtrBoala_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(BoalaField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_in.createSequentialGroup()
							.addGap(57)
							.addComponent(btnSchimbaBoala)
							.addGap(58))
						.addGroup(gl_in.createSequentialGroup()
							.addComponent(txtrNume, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(Nume2Field, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
					.addGap(12))
				.addGroup(gl_in.createSequentialGroup()
					.addGap(108)
					.addComponent(btnSchimbaNume)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(gl_in.createSequentialGroup()
					.addGap(46)
					.addComponent(txtrPrenume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Prenume2Field, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_in.createSequentialGroup()
					.addGap(110)
					.addComponent(btnSchimbaPreume)
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_in.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_in.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_in.createSequentialGroup()
							.addComponent(txtrMedic, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(MedicField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
						.addGroup(gl_in.createSequentialGroup()
							.addGap(64)
							.addComponent(btnSchimbaMedic, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_in.setVerticalGroup(
			gl_in.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_in.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_in.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_in.createSequentialGroup()
							.addGap(1)
							.addComponent(txtrBoala_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(BoalaField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSchimbaBoala)
					.addGap(18)
					.addGroup(gl_in.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_in.createSequentialGroup()
							.addGap(1)
							.addComponent(txtrNume, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(Nume2Field, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSchimbaNume, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_in.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_in.createSequentialGroup()
							.addGap(19)
							.addComponent(txtrPrenume, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_in.createSequentialGroup()
							.addGap(18)
							.addComponent(Prenume2Field, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnSchimbaPreume, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_in.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_in.createSequentialGroup()
							.addGap(1)
							.addComponent(txtrMedic, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(MedicField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSchimbaMedic, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(282, Short.MAX_VALUE))
		);
		in.setLayout(gl_in);
		
		JPanel QuerryNou1 = new JPanel();
		QuerryNou1.setBackground(new Color(52, 107, 152));
		cardLayout.add(QuerryNou1, "name_4283297398599");
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrIntroducetiAdresaDupa = new JTextArea();
		txtrIntroducetiAdresaDupa.setText("Introduceti adresa dupa care se ");
		txtrIntroducetiAdresaDupa.setForeground(Color.WHITE);
		txtrIntroducetiAdresaDupa.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrIntroducetiAdresaDupa.setEditable(false);
		txtrIntroducetiAdresaDupa.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrStrada_1 = new JTextArea();
		txtrStrada_1.setText("Strada:");
		txtrStrada_1.setForeground(Color.WHITE);
		txtrStrada_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrStrada_1.setEditable(false);
		txtrStrada_1.setBackground(new Color(52, 107, 152));
		
		textField = new JTextField();
		textField.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textField.setColumns(10);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setText("executa selectia");
		textArea_5.setForeground(Color.WHITE);
		textArea_5.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_5.setEditable(false);
		textArea_5.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_15 = new GroupLayout(panel_15);
		gl_panel_15.setHorizontalGroup(
			gl_panel_15.createParallelGroup(Alignment.LEADING)
				.addGap(0, 347, Short.MAX_VALUE)
				.addGroup(gl_panel_15.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_15.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrIntroducetiAdresaDupa, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(gl_panel_15.createSequentialGroup()
							.addGap(31)
							.addComponent(txtrStrada_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField))
						.addComponent(textArea_5, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_15.setVerticalGroup(
			gl_panel_15.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_15.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrIntroducetiAdresaDupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_15.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrStrada_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		panel_15.setLayout(gl_panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setForeground(Color.WHITE);
		textArea_6.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_6.setEditable(false);
		textArea_6.setBackground(new Color(52, 107, 152));
		
		JTextArea txtrListaStrazi = new JTextArea();
		txtrListaStrazi.setText("Lista Strazi:");
		txtrListaStrazi.setForeground(Color.WHITE);
		txtrListaStrazi.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrListaStrazi.setEditable(false);
		txtrListaStrazi.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_16 = new GroupLayout(panel_16);
		gl_panel_16.setHorizontalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_16.createSequentialGroup()
							.addComponent(textArea_6, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_16.createSequentialGroup()
							.addComponent(txtrListaStrazi, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_16.setVerticalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrListaStrazi, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_6, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_16.setLayout(gl_panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setForeground(Color.WHITE);
		textArea_10.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_10.setEditable(false);
		textArea_10.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_10, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_17.setVerticalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_10, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_17.setLayout(gl_panel_17);
		
		JButton btnExec = new JButton("exec");
		
		GroupLayout gl_QuerryNou1 = new GroupLayout(QuerryNou1);
		gl_QuerryNou1.setHorizontalGroup(
			gl_QuerryNou1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QuerryNou1.createSequentialGroup()
					.addGroup(gl_QuerryNou1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_QuerryNou1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_QuerryNou1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_QuerryNou1.createSequentialGroup()
									.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addComponent(panel_16, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_17, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_QuerryNou1.createSequentialGroup()
							.addGap(24)
							.addComponent(btnExec)))
					.addContainerGap())
		);
		gl_QuerryNou1.setVerticalGroup(
			gl_QuerryNou1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QuerryNou1.createSequentialGroup()
					.addComponent(btnExec)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_QuerryNou1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_16, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_17, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		QuerryNou1.setLayout(gl_QuerryNou1);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(52, 107, 152));
		cardLayout.add(panel_18, "name_5036576283500");
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setForeground(Color.WHITE);
		textArea_13.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_13.setEditable(false);
		textArea_13.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_21 = new GroupLayout(panel_21);
		gl_panel_21.setHorizontalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_21.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_13, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_21.setVerticalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGroup(gl_panel_21.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_13, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_21.setLayout(gl_panel_21);
		
		JButton button = new JButton("exec");
		
		GroupLayout gl_panel_18 = new GroupLayout(panel_18);
		gl_panel_18.setHorizontalGroup(
			gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup()
					.addGroup(gl_panel_18.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_18.createSequentialGroup()
							.addGap(24)
							.addComponent(button))
						.addGroup(gl_panel_18.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_21, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel_18.setVerticalGroup(
			gl_panel_18.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_18.createSequentialGroup()
					.addComponent(button)
					.addGap(47)
					.addComponent(panel_21, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel_18.setLayout(gl_panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(52, 107, 152));
		cardLayout.add(panel_19, "name_5490272049900");
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("Introduceti adresa dupa care se ");
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_3.setEditable(false);
		textArea_3.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setText("Strada:");
		textArea_4.setForeground(Color.WHITE);
		textArea_4.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_4.setEditable(false);
		textArea_4.setBackground(new Color(52, 107, 152));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textField_1.setColumns(10);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setText("executa selectia");
		textArea_7.setForeground(Color.WHITE);
		textArea_7.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_7.setEditable(false);
		textArea_7.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_20 = new GroupLayout(panel_20);
		gl_panel_20.setHorizontalGroup(
			gl_panel_20.createParallelGroup(Alignment.LEADING)
				.addGap(0, 347, Short.MAX_VALUE)
				.addGroup(gl_panel_20.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_20.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_3, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(gl_panel_20.createSequentialGroup()
							.addGap(31)
							.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1))
						.addComponent(textArea_7, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_20.setVerticalGroup(
			gl_panel_20.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_20.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_20.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		panel_20.setLayout(gl_panel_20);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setForeground(Color.WHITE);
		textArea_11.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_11.setEditable(false);
		textArea_11.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setText("Lista Strazi:");
		textArea_12.setForeground(Color.WHITE);
		textArea_12.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_12.setEditable(false);
		textArea_12.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_22 = new GroupLayout(panel_22);
		gl_panel_22.setHorizontalGroup(
			gl_panel_22.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGroup(gl_panel_22.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_22.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_22.createSequentialGroup()
							.addComponent(textArea_11, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_22.createSequentialGroup()
							.addComponent(textArea_12, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_22.setVerticalGroup(
			gl_panel_22.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_22.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_12, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_11, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_22.setLayout(gl_panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_15 = new JTextArea();
		textArea_15.setForeground(Color.WHITE);
		textArea_15.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_15.setEditable(false);
		textArea_15.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_23 = new GroupLayout(panel_23);
		gl_panel_23.setHorizontalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_23.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_15, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_23.setVerticalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGroup(gl_panel_23.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_15, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_23.setLayout(gl_panel_23);
		
		JButton button_1 = new JButton("exec");
		
		GroupLayout gl_panel_19 = new GroupLayout(panel_19);
		gl_panel_19.setHorizontalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGap(0, 728, Short.MAX_VALUE)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_19.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_19.createSequentialGroup()
									.addComponent(panel_20, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addComponent(panel_22, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_23, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_19.createSequentialGroup()
							.addGap(24)
							.addComponent(button_1)))
					.addContainerGap())
		);
		gl_panel_19.setVerticalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGap(0, 727, Short.MAX_VALUE)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_22, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_20, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_23, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel_19.setLayout(gl_panel_19);
		
		JPanel panel_24 = new JPanel();
		panel_24.setLayout(null);
		panel_24.setBackground(new Color(52, 107, 152));
		cardLayout.add(panel_24, "name_29622541829300");
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(52, 107, 152));
		panel_25.setBounds(12, 5, 349, 709);
		panel_24.add(panel_25);
		
		JTextArea txtrAsigure = new JTextArea();
		txtrAsigure.setText("Asigurare:");
		txtrAsigure.setForeground(Color.WHITE);
		txtrAsigure.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrAsigure.setEditable(false);
		txtrAsigure.setBackground(new Color(52, 107, 152));
		
		ASN = new JTextField();
		ASN.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		ASN.setColumns(10);
		
		JTextArea asig_Num = new JTextArea();
		asig_Num.setBackground(QueenBlue);
		asig_Num.setForeground(Color.WHITE);
		GroupLayout gl_panel_25 = new GroupLayout(panel_25);
		gl_panel_25.setHorizontalGroup(
			gl_panel_25.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_25.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_25.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_25.createSequentialGroup()
							.addComponent(txtrAsigure, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ASN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(Alignment.TRAILING, gl_panel_25.createSequentialGroup()
							.addComponent(asig_Num, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_25.setVerticalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_25.createSequentialGroup()
					.addGroup(gl_panel_25.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_25.createSequentialGroup()
							.addGap(65)
							.addComponent(ASN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_25.createSequentialGroup()
							.addGap(66)
							.addComponent(txtrAsigure, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(41)
					.addComponent(asig_Num, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_25.setLayout(gl_panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(52, 107, 152));
		panel_26.setBounds(366, 5, 350, 709);
		panel_24.add(panel_26);
		
		NewVal = new JTextField();
		NewVal.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		NewVal.setColumns(10);
		
		JTextArea txtrPretNou = new JTextArea();
		txtrPretNou.setText("Pret nou:");
		txtrPretNou.setForeground(Color.WHITE);
		txtrPretNou.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		txtrPretNou.setEditable(false);
		txtrPretNou.setBackground(new Color(52, 107, 152));
		
		JButton Efect = new JButton("Schimba Pret");
		
		Efect.setForeground(Color.WHITE);
		Efect.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		Efect.setBackground(new Color(82, 0, 41));
		
		JButton AFASig = new JButton("Afiseaza Asigurari");
		
		AFASig.setForeground(Color.WHITE);
		AFASig.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		AFASig.setBackground(new Color(82, 0, 41));
		GroupLayout gl_panel_26 = new GroupLayout(panel_26);
		gl_panel_26.setHorizontalGroup(
			gl_panel_26.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_26.createSequentialGroup()
					.addGroup(gl_panel_26.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_26.createSequentialGroup()
							.addGap(43)
							.addComponent(txtrPretNou, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(NewVal, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_26.createSequentialGroup()
							.addGap(87)
							.addGroup(gl_panel_26.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(Efect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(AFASig, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_26.setVerticalGroup(
			gl_panel_26.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_26.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel_26.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrPretNou, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NewVal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(Efect)
					.addGap(101)
					.addComponent(AFASig, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(404, Short.MAX_VALUE))
		);
		panel_26.setLayout(gl_panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(new Color(52, 107, 152));
		cardLayout.add(panel_27, "name_32064655755800");
		
		JButton button_4 = new JButton("executa");
		
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		button_4.setBackground(new Color(82, 0, 41));
		
		JTextArea textArea_17 = new JTextArea();
		textArea_17.setText("Selectie dupa boala:");
		textArea_17.setLineWrap(true);
		textArea_17.setForeground(Color.WHITE);
		textArea_17.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_17.setEditable(false);
		textArea_17.setBackground(new Color(52, 107, 152));
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_18 = new JTextArea();
		textArea_18.setText("Introduceti boala dupa care se ");
		textArea_18.setForeground(Color.WHITE);
		textArea_18.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_18.setEditable(false);
		textArea_18.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_19 = new JTextArea();
		textArea_19.setText("Boala:");
		textArea_19.setForeground(Color.WHITE);
		textArea_19.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_19.setEditable(false);
		textArea_19.setBackground(new Color(52, 107, 152));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textField_3.setColumns(10);
		
		JTextArea textArea_22 = new JTextArea();
		textArea_22.setText("executa selectia");
		textArea_22.setForeground(Color.WHITE);
		textArea_22.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_22.setEditable(false);
		textArea_22.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_28 = new GroupLayout(panel_28);
		gl_panel_28.setHorizontalGroup(
			gl_panel_28.createParallelGroup(Alignment.LEADING)
				.addGap(0, 347, Short.MAX_VALUE)
				.addGroup(gl_panel_28.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_28.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_18, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addGroup(gl_panel_28.createSequentialGroup()
							.addGap(31)
							.addComponent(textArea_19, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3))
						.addComponent(textArea_22, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_28.setVerticalGroup(
			gl_panel_28.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_28.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_22, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_panel_28.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_19, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		panel_28.setLayout(gl_panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_31 = new JTextArea();
		textArea_31.setForeground(Color.WHITE);
		textArea_31.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_31.setEditable(false);
		textArea_31.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_32 = new JTextArea();
		textArea_32.setText("Lista Boli:");
		textArea_32.setForeground(Color.WHITE);
		textArea_32.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_32.setEditable(false);
		textArea_32.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_29 = new GroupLayout(panel_29);
		gl_panel_29.setHorizontalGroup(
			gl_panel_29.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGap(0, 337, Short.MAX_VALUE)
				.addGroup(gl_panel_29.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_29.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_29.createSequentialGroup()
							.addComponent(textArea_31, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_29.createSequentialGroup()
							.addComponent(textArea_32, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
							.addGap(12))))
		);
		gl_panel_29.setVerticalGroup(
			gl_panel_29.createParallelGroup(Alignment.LEADING)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGap(0, 358, Short.MAX_VALUE)
				.addGroup(gl_panel_29.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_32, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea_31, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_29.setLayout(gl_panel_29);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(52, 107, 152));
		
		JTextArea textArea_33 = new JTextArea();
		textArea_33.setForeground(Color.WHITE);
		textArea_33.setFont(new Font("Bodoni MT", Font.PLAIN, 23));
		textArea_33.setEditable(false);
		textArea_33.setBackground(new Color(52, 107, 152));
		GroupLayout gl_panel_30 = new GroupLayout(panel_30);
		gl_panel_30.setHorizontalGroup(
			gl_panel_30.createParallelGroup(Alignment.LEADING)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGap(0, 696, Short.MAX_VALUE)
				.addGroup(gl_panel_30.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_33, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_30.setVerticalGroup(
			gl_panel_30.createParallelGroup(Alignment.LEADING)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGap(0, 275, Short.MAX_VALUE)
				.addGroup(gl_panel_30.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea_33, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_30.setLayout(gl_panel_30);
		GroupLayout gl_panel_27 = new GroupLayout(panel_27);
		gl_panel_27.setHorizontalGroup(
			gl_panel_27.createParallelGroup(Alignment.LEADING)
				.addGap(0, 728, Short.MAX_VALUE)
				.addGroup(gl_panel_27.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_27.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_27.createSequentialGroup()
							.addGroup(gl_panel_27.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_27.createSequentialGroup()
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(124)
									.addComponent(textArea_17, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_27.createSequentialGroup()
									.addComponent(panel_28, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(panel_29, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(14))
						.addGroup(gl_panel_27.createSequentialGroup()
							.addComponent(panel_30, GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
							.addGap(20))))
		);
		gl_panel_27.setVerticalGroup(
			gl_panel_27.createParallelGroup(Alignment.LEADING)
				.addGap(0, 727, Short.MAX_VALUE)
				.addGroup(gl_panel_27.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_27.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_17, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_27.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_28, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
						.addComponent(panel_29, GroupLayout.PREFERRED_SIZE, 358, Short.MAX_VALUE))
					.addGap(24)
					.addComponent(panel_30, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_27.setLayout(gl_panel_27);
		
		
		JLabel lblNewLabel = new JLabel("");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Pane, panel1, panel2, SignOut, Login, DelPacient, Querry, AllPacienti, NewPacient, panel4, lblNewLabel, Medics, NouPacientPanel, Register, CNPTxt, CNPField, SexTXT, SexField, DataNTxt, DataNField, TelefonTxt, TelefonField, MailTxt, MailField, CIDTxt, CIDField, separator, LocalitateTxt, LocalitateField, Adresa, StradaTxt, StradaField, NrTxt, nrField, NumeTxt, NumeField, DatePersonaleTXT, PrenumeTxt, PrenumeField, blocTxt, blocField, ScataTxt, ScaraField, EtajTxt, EtajField, ApartamentTxt, ApartamentField}));
		
	
		
		Querry.setForeground(Color.WHITE);
		Querry.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		Querry.setBackground(new Color(35, 76, 94));
		
		
		DelPacient.setForeground(Color.WHITE);
		DelPacient.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		DelPacient.setBackground(new Color(35, 76, 94));
		
		
		Login.setForeground(Color.WHITE);
		Login.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		Login.setBackground(new Color(35, 76, 94));
		
		
		panel4.setBackground(Charcoal);
		
		
		
		Medics.setForeground(Color.WHITE);
		Medics.setFont(new Font("Bodoni MT", Font.BOLD, 23));
		Medics.setBackground(TyrianPurple);
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
						.addComponent(SignOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(Login, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(DelPacient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(Querry, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(AllPacienti, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(NewPacient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel4, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(Medics, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addComponent(panel4, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Medics, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(Login, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(DelPacient, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Querry, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AllPacienti, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NewPacient, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SignOut, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
		);
		
		
		lblNewLabel.setIcon(new ImageIcon(medicWindow.class.getResource("/res/caduceus4.png")));
		
		
		
		gl_panel4.setHorizontalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel4.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(50))
		);
		gl_panel4.setVerticalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel4.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(28))
		);
		panel4.setLayout(gl_panel4);
		panel2.setLayout(gl_panel2);
		panel1.setLayout(gl_panel1);
		Pane.setLayout(gl_Pane);
		
		//Apasare buton
		
		SignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(TyrianPurple);
				DelPacient.setBackground(Charcoal);
				Login.setBackground(Charcoal);
				AllPacienti.setBackground(Charcoal);
				NewPacient.setBackground(Charcoal);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(Charcoal);
				
				cardLayout.removeAll();
				cardLayout.add(ListaMediciPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
				
				NewPacient.setVisible(false);
				SignOut.setVisible(false);
				AllPacienti.setVisible(false);
				Querry.setVisible(false);
				DelPacient.setVisible(false);
				PrenumeMedicField.setText("");
				NumeMedicField.setText("");
				passwordMedicField.setText("");
				ConectedTxt.setText("");
				
			}
		});
		
		NewPacient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(Charcoal);
				DelPacient.setBackground(Charcoal);
				Login.setBackground(Charcoal);
				AllPacienti.setBackground(Charcoal);
				NewPacient.setBackground(TyrianPurple);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(Charcoal);
				
				
				cardLayout.removeAll();
				cardLayout.add(NouPacientPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		
		AllPacienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(Charcoal);
				DelPacient.setBackground(Charcoal);
				Login.setBackground(Charcoal);
				AllPacienti.setBackground(TyrianPurple);
				NewPacient.setBackground(Charcoal);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(Charcoal);
				
				cardLayout.removeAll();
				cardLayout.add(PacientiPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
				
			}
		});
		
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(Charcoal);
				DelPacient.setBackground(Charcoal);
				Login.setBackground(TyrianPurple);
				AllPacienti.setBackground(Charcoal);
				NewPacient.setBackground(Charcoal);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(Charcoal);
				
				cardLayout.removeAll();
				cardLayout.add(LogInPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		
		DelPacient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(Charcoal);
				DelPacient.setBackground(TyrianPurple);
				Login.setBackground(Charcoal);
				AllPacienti.setBackground(Charcoal);
				NewPacient.setBackground(Charcoal);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(Charcoal);
				
				cardLayout.removeAll();
				cardLayout.add(EliminarePacientPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		
		Medics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(TyrianPurple);
				DelPacient.setBackground(Charcoal);
				Login.setBackground(Charcoal);
				AllPacienti.setBackground(Charcoal);
				NewPacient.setBackground(Charcoal);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(Charcoal);
				
				cardLayout.removeAll();
				cardLayout.add(ListaMediciPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				strada=StradaField.getText();
				StradaField.setText("");
				
				nume=NumeField.getText();
				NumeField.setText("");
				
				prenume=PrenumeField.getText();
				PrenumeField.setText("");
				
				telefon=TelefonField.getText();
				TelefonField.setText("");
				
				mail=MailField.getText();
				MailField.setText("");
				
				cnp=CNPField.getText();
				CNPField.setText("");
				
				sex=SexField.getText();
				SexField.setText("");
				
				dataNastere=DataNField.getText();
				DataNField.setText("");
				
				cid=CIDField.getText();
				CIDField.setText("");
				
				localitate=LocalitateField.getText();
				LocalitateField.setText("");
				
				nr=nrField.getText();
				nrField.setText("");
				
				bloc=blocField.getText();
				blocField.setText("");
				
				scara=ScaraField.getText();
				ScaraField.setText("");
				
				etaj=EtajField.getText();
				EtajField.setText("");
				
				apartament=ApartamentField.getText();
				ApartamentField.setText("");
				
				
				command="Select codAddr from "+adresa+"where Localitate='"+localitate+"' And strada='"+strada+"'";
				
				codAll=joc.getCod(command,"codAddr", url, user, password);
				System.out.println(codAll);
				if (codAll==-1) {
					command="Insert into "+adresa+" (Localitate, Strada, nr, bloc, scara, etaj, apartament, mail, telefon) values ('"+localitate+"','"+strada+"',"+nr+",'"+bloc+"','"+scara+"',"+etaj+","+apartament+",'"+mail+"',"+telefon+");";
					joc.ExecuteWrite(command, url, user, password);
					codAll=joc.getTopCodAdr(url, user, password);
				}
				System.out.println(codAll);
				command="Insert into "+pacienti+" (CodMedic,codAddr,CNP,Nume,Prenume,Sex,DataN,CID) values ("+IdMedic+","+codAll+
																											","+cnp
																											+",'"+nume
																											+"','"+prenume
																											+"','"+sex
																											+"','"+dataNastere
																											+"',"+cid+");";
				joc.ExecuteWrite(command, url, user, password);
				
				
				MesajField.setText(" Persoana a fost trecuta in baza \n"+nume+" "+prenume+" \n"+telefon+" "+mail+" \n"+cnp+" "+sex+" "+dataNastere+" "+cid+" \n"+localitate+" "+strada+" "+nr+" "+bloc+" "+scara+" "+etaj+" "+apartament);
			}
		});
		
		LogInMedic.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				passwdMedic=passwordMedicField.getText();
	
				
				numeMedic=NumeMedicField.getText();

				
				prenumeMedic=PrenumeMedicField.getText();

				
				command="select Parola from "+medic+" where Nume ='"+numeMedic+"' and Prenume='"+prenumeMedic+"'";
				passwdDB=joc.getPasswd(command, "Parola", url, user, password);
//				System.out.println(passwdMedic);
				if (passwdDB.equals(passwdMedic)&&(!numeMedic.isEmpty()&&!prenumeMedic.isEmpty()&&!passwdMedic.isEmpty())) {
					NewPacient.setVisible(true);
					SignOut.setVisible(true);
					AllPacienti.setVisible(true);
					Querry.setVisible(true);
					DelPacient.setVisible(true);
					ConectedTxt.setText("Log in Succsessfull");
					command="select IdMedic from "+medic+" where Parola="+passwdDB;
					IdMedic=joc.getCod(command, "IdMedic", url, user, password);
					System.out.println(IdMedic+"=IdMedic");
				}
				else {
					NewPacient.setVisible(false);
					SignOut.setVisible(false);
					AllPacienti.setVisible(false);
					Querry.setVisible(false);
					DelPacient.setVisible(false);
					ConectedTxt.setText("Failed to Log in");
				}
				
			}
		});
		

		
		ShowMedicsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShowSalariesBtn.isSelected()) {
					
					command="select Nume,Prenume,Salariu from"+medic;
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					//Y_NPane.setText("Da");
					MedicsTxt.setText("Nume \t Prenume \t Salariu[lei]\n"+datasAll);
					
				}
				else {
					//System.out.println("false");
					command="select Nume,Prenume from"+medic;
					datasAll=joc.ReadNVals(command, 2, url, user, password);
					//Y_NPane.setText("Nu");
					MedicsTxt.setText("Nume \t Prenume\n"+datasAll);
				}
				System.out.println(datasAll);
				
			}
		});
		
		ShowSalariesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShowSalariesBtn.isSelected()) {
					Y_NPane.setText("Da");
				}
				else {
					Y_NPane.setText("Nu");
				}
			}
		});
		
		ExecDelPacBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nume=NPacientField.getText();
				NPacientField.setText("");
				
				prenume=PnPacientField.getText();
				PnPacientField.setText("");
				
				cnp=CNPPacField.getText();
				CNPPacField.setText("");
				
				command="select CodAddr from "+pacienti+" where Nume='"+nume+"' and Prenume='"+prenume+"' and CNP="+cnp;
				codAll=joc.getCod(command, "codAddr", url, user, password);
				System.out.println(codAll+"=codAddrElim");

				command="select CodAddr, count(*) as NrPac from "+pacienti+" group by CodAddr Having CodAddr="+codAll;
				NrPacientiAdr=joc.getCod(command, "NrPac", url, user, password);
				System.out.println(NrPacientiAdr+"=Nrpac");
				
				command="delete from "+pacienti+"where Nume='"+nume+"' and Prenume='"+prenume+"' and CNP="+cnp+" and CodMedic="+IdMedic;
				joc.ExecuteWrite(command, url, user, password);
				
				if (NrPacientiAdr<=1) {
					command="delete from "+adresa+"where CodAddr="+codAll;
					joc.ExecuteWrite(command, url, user, password);
				}
				
			}
		});
		
		AfiseazaPacientiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				command="select Nume,Prenume,CNP from"+pacienti+" where CodMedic="+IdMedic;
				datasAll=joc.ReadNVals(command, 3, url, user, password);
				
				PacientiTxt.setText("Nume \t Prenume\t CNP\n"+datasAll);
			}
		});
		
		Querry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medics.setBackground(Charcoal);
				DelPacient.setBackground(Charcoal);
				Login.setBackground(Charcoal);
				AllPacienti.setBackground(Charcoal);
				NewPacient.setBackground(Charcoal);
				SignOut.setBackground(Charcoal);
				Querry.setBackground(TyrianPurple);

				cardLayout.removeAll();
				cardLayout.add(QuerriesPanel);
				cardLayout.repaint();
				cardLayout.revalidate();
				
				textArea_30.setText("");
				textArea_23.setText("");
				textArea_16.setText("");
				textArea_9.setText("");
				textArea_2.setText("");
				textArea_1.setText("");
				textArea_28.setText("");
				textArea_21.setText("");
				textArea_14.setText("");
				textArea.setText("");
				textArea_8.setText("");

			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.removeAll();
				cardLayout.add(Update);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		
		AsigBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.removeAll();
				cardLayout.add(AsigPanel);
				cardLayout.repaint();
				cardLayout.revalidate();

			}
		});
		
		BoliBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Boli1Panel);
				cardLayout.repaint();
				cardLayout.revalidate();

			}
		});
		
		BoliBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Boli2Panel);
				cardLayout.repaint();
				cardLayout.revalidate();

			}
		});
		
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry3);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=1;
				
				command="select Localitate,Strada from"+adresa;
				datasAll=joc.ReadNVals(command, 2, url, user, password);
				textArea_8.setText("Localitate \t Strada\n"+datasAll);

			}
		});
		
		btnNou1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry5);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=2;
				
				command="select Localitate,Strada from"+adresa;
				datasAll=joc.ReadNVals(command, 2, url, user, password);
				textArea_8.setText("Localitate \t Strada\n"+datasAll);

			}
		});
		
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry1);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=1;
			
			}
		});
		
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry2);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=1;
				
				command="select Nume from" +boala;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea.setText("Nume Boala\n"+datasAll);

			}
		});
		
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry4);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=1;
				
				command="select NumeAsigurare from" +servicii_Asigurari;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_14.setText("Nume Asigurare\n"+datasAll);

			}
		});
		
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry5);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=1;
				
				command="select cnp from" +pacienti;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_21.setText("CNP Pacient\n"+datasAll);

			}
		});
		
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(Querry6);
				cardLayout.repaint();
				cardLayout.revalidate();
				variant=1;
				
				command="select Nume from" +boala;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_28.setText("Nume Boala\n"+datasAll);

			}
		});
		
		btn26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(panel_18);
				cardLayout.repaint();
				cardLayout.revalidate();
				
				
				
			}
		});
		
		q1btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (variant==1)
				{
					command="select  CNP,Nume,Prenume from "+boalaPacient+" BP inner join "+pacienti+" on CNP=CNPpacient group by Cnp, Nume, Prenume having count(*)<2";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_1.setText("CNP \t Nume \t Prenume\n"+datasAll);
				}
				else
				{
					command="Select  CNP,Nume,Prenume from "+pacienti+" where CNP in( select CNPPacient from "+boalaPacient+" group by CNPPacient having COUNT(*)<2)";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_1.setText("CNP \t Nume \t Prenume\n"+datasAll);
				}
			}
			
		});
		
		q2btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (variant==1)
				{
					
					selBoli=Boala1Txt.getText();
					command="select distinct P1.CNP,P1.Nume,P1.Prenume from "+ pacienti+" P1 inner join "+pacienti+" P2 on P1.CodAddr=P2.CodAddr inner Join "+boalaPacient+" BP on P2.CNP=CNPpacient inner join "+boala +" B on IDBoala=CodBoala where B.Nume='"+selBoli+"'";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_2.setText("CNP \t Nume \t Prenume\n"+datasAll);
				}
				else
				{
					selBoli=Boala1Txt.getText();
					command="select CNP,Nume,Prenume from "+pacienti+" where CodAddr in (select CodAddr from "+pacienti+" where cnp in (select CNPPacient from "+boalaPacient+" where CodBoala in (select IDBoala from "+boala+" where nume='"+selBoli+"')))";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_2.setText("CNP \t Nume \t Prenume\n"+datasAll);
				}
			}
			
		});
		
		q3btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (variant==1)
				{
					selLoc=Strada1Txt.getText();
					selStr=Localitate1txt.getText();
					command="select distinct NumeAsigurare,PretServiciu from "+ servicii_Asigurari+" inner join "+ pacienti+ " p on IdServiciu=CodServiciu inner join "+ adresa+" a on a.codAddr=p.CodAddr where Localitate='"+ selLoc+"' and Strada='"+ selStr+"' order by PretServiciu";
					datasAll=joc.ReadNVals(command, 2, url, user, password);
					textArea_9.setText("Nume Asigurare \t Pret serviciu\n"+datasAll);
				}
				else
				{
					selLoc=Strada1Txt.getText();
					selStr=Localitate1txt.getText();
					command="select NumeAsigurare, PretServiciu from "+ servicii_Asigurari+" where IDServiciu in (select distinct CodServiciu from "+ pacienti+" where CodAddr in (select codAddr from "+ adresa+" where Localitate='"+selLoc+"' and Strada='"+selStr+"')) order by PretServiciu";
					datasAll=joc.ReadNVals(command, 2, url, user, password);
					textArea_9.setText("Nume Asigurare \t Pret serviciu\n"+datasAll);
				}
			}
			
		});
		
		q4btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (variant==1)
				{
					selServ=textField_2.getText();
					
					command="select DataN,Nume,Prenume from "+servicii_Asigurari+" Inner join "+pacienti+" on IDServiciu=CodServiciu where NumeAsigurare='"+selServ+"' and DataN>'2000-01-01'";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_16.setText("Data Nastere \t Nume \t Prenume\n"+datasAll);
				}
				else
				{
					selServ=textField_2.getText();
					
					command="select DataN,Nume,Prenume from " +pacienti+" where CodServiciu in (select IDServiciu from "+ servicii_Asigurari+" where NumeAsigurare='"+selServ+"') and DataN>'2000-01-01'";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_16.setText("Data Nastere \t Nume \t Prenume\n"+datasAll);
				}
			}
			
		});
		
		q5btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (variant==1)
				{
					selPac=CNPtxt.getText();
					System.out.println(selPac);
					command="select P.nume,prenume,sum(PretTratament) Pret_Tratament from "+boala+" inner join "+boalaPacient+" on CodBoala=IDBoala inner join "+pacienti+" P on CNP=cnpPacient where cnp="+selPac+" group by p.nume,prenume";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_23.setText("Nume \t Prenume \t Pret\n"+datasAll);
					
				}
				else
				{
					selPac=CNPtxt.getText();
					System.out.println(selPac);
					command="select P.nume,Prenume, sum(PretTratament) from "+boala+","+pacienti+" P where IDBoala in (select CodBoala from "+boalaPacient+" where CNPpacient ="+selPac+") and Cnp="+selPac+" group by p.nume,prenume";
					datasAll=joc.ReadNVals(command, 3, url, user, password);
					textArea_23.setText("Nume \t Prenume \t Pret\n"+datasAll);
				}
			}
			
		});
		
		q6btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (variant==1)
				{
					selBoli=textField_4.getText();
					command="select distinct M.Nume,M.Prenume from "+ medic+" M inner join   "+pacienti+" P on  CodMedic=IdMedic inner Join  "+boalaPacient+" on CNPPacient=cnp inner join  "+boala +" B on IDBoala=CodBoala where B.nume='"+selBoli+"'";
					datasAll=joc.ReadNVals(command, 2, url, user, password);
					textArea_30.setText("Nume \t Prenume\n"+datasAll);
				}
				else
				{
					selBoli=textField_4.getText();
					command="select Nume,Prenume from "+medic+" where IdMedic in (select CodMedic from "+pacienti+" where cnp in (select CNPPacient from "+boalaPacient+" where CodBoala in (select IDBoala from "+boala+" where nume='"+selBoli+"')))";
					datasAll=joc.ReadNVals(command, 2, url, user, password);
					textArea_30.setText("Nume \t Prenume\n"+datasAll);
				}
			}
			
		});
		
		btnSchimbaNume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selPac=Nume2Field.getText();
				selCnp=CnpField.getText();
				command="update "+pacienti+" set Nume='"+selPac+"' where cnp="+selCnp;
				joc.ExecuteWrite(command, url, user, password);
			}
		});
		
		btnSchimbaPreume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selPac=Prenume2Field.getText();
				selCnp=CnpField.getText();
				command="update "+pacienti+" set Prenume='"+selPac+"' where cnp="+selCnp;
				joc.ExecuteWrite(command, url, user, password);
			}
		});
		
		btnSchimbaBoala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selBoli=BoalaField.getText();
				selCnp=CnpField.getText();
				String val;
				command="select Idboala from"+boala+" where nume="+selBoli;
				val= joc.ReadNVals(command, 1, url, user, password);
				command="insert into "+boalaPacient+" values " +selCnp+","+val;
				joc.ExecuteWrite(command, url, user, password);
			}
		});
		
		btnSchimbaMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
						
				selBoli=MedicField.getText();
				selCnp=CnpField.getText();
				command="update "+pacienti+" set CodMedic=(select idMedic from "+medic+" where nume='"+selBoli+"') where cnp="+selCnp;
				joc.ExecuteWrite(command, url, user, password);
			}
		});
		
		btnSchimbaAsigurare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selBoli=AsigField.getText();
				selCnp=CnpField.getText();
				command="update "+pacienti+" set CodServiciu=(select IDServiciu from "+servicii_Asigurari+" where nume='"+selBoli+"') where cnp="+selCnp;
				joc.ExecuteWrite(command, url, user, password);
			}
		});
		

		
		btnExec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selStr=textField.getText();
				command="select Nume,Prenume from "+medic+" where IdMedic in ( select CodMedic from "+pacienti+" where CodAddr in ( select codAddr from "+adresa+" where Strada ='"+selStr+"'))";
				datasAll=joc.ReadNVals(command, 3, url, user, password);
				textArea_10.setText("data \t Nume \t Prenume\n"+datasAll);
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				command="Select  CNP,Nume,Prenume,DataN from "+pacienti+" where CNP in( select CNPPacient from "+boalaPacient+" group by CNPPacient having COUNT(*)>2) and DataN<'2000-01-01'";
				datasAll=joc.ReadNVals(command, 4, url, user, password);
				textArea_13.setText("cnp \t Nume \t Prenume \t data\n"+datasAll);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(panel_19);
				cardLayout.repaint();
				cardLayout.revalidate();
				command="select Strada from"+adresa;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_11.setText(" Strada\n"+datasAll);
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selStr=textField_1.getText();
				command="select DataN,Nume,Prenume from "+ pacienti+" where CodAddr not in (select CodAddr from "+adresa+" where Strada= '"+selStr+"') and DataN>'2000-01-01'";
				datasAll=joc.ReadNVals(command, 3, url, user, password);
				textArea_15.setText("data \t Nume \t Prenume\n"+datasAll);
			}
		});
		
		AFASig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				command="Select numeasigurare,pretserviciu from "+servicii_Asigurari;
				
				asig_Num.setText(joc.ReadNVals(command, 2, url, user, password));
			}
		});
		
		Efect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nume=ASN.getText();
				prenume=NewVal.getText();
				command="update"+ servicii_Asigurari+" set PretServiciu="+prenume+" where NumeAsigurare='"+nume+" '";
				joc.ExecuteWrite(command, url, user, password);
			}
		});
		
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(panel_24);
				cardLayout.repaint();
				cardLayout.revalidate();
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(panel_27);
				cardLayout.repaint();
				cardLayout.revalidate();
				
				command="select Nume from" +boala;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_31.setText("Nume Boala\n"+datasAll);
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prenume=textField_3.getText();
				command="select nume from "+medic+" where idmedic in(select codMedic from "+pacienti+" where codAddr not in(select codaddr from "+pacienti+" where cnp in (select cnppacient from "+boalaPacient+" where CodBoala in(select idboala from "+boala+" where nume='"+prenume+"'))))";
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_33.setText(" Nume \n"+datasAll);
			}
		});
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.removeAll();
				cardLayout.add(QuerryNou1);
				cardLayout.repaint();
				cardLayout.revalidate();
				command="select Strada from"+adresa;
				datasAll=joc.ReadNVals(command, 1, url, user, password);
				textArea_6.setText(" Strada\n"+datasAll);
			}
		});
	}
}
