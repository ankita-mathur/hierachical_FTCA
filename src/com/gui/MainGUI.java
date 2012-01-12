package com.gui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.DefaultComboBoxModel;

public class MainGUI extends JFrame {
	private JTextField txtQuery;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setTitle("Web Snippet Clusterer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024,720 );
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("50dlu:grow"),
				ColumnSpec.decode("50dlu:grow"),
				ColumnSpec.decode("50dlu:grow"),
				ColumnSpec.decode("50dlu"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		txtQuery = new JTextField();
		panel.add(txtQuery, "1, 1, 3, 1, fill, default");
		txtQuery.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		panel.add(btnSearch, "4, 1");
		
		JLabel lblResultCount = new JLabel("Result Count");
		panel.add(lblResultCount, "1, 3, center, default");
		
		JComboBox cmbResultCpunt = new JComboBox();
		cmbResultCpunt.setModel(new DefaultComboBoxModel(new String[] {"20", "50", "100"}));
		panel.add(cmbResultCpunt, "2, 3, fill, default");
		
		JLabel lblAlgorithm = new JLabel("Algorithm");
		panel.add(lblAlgorithm, "3, 3, center, default");
		
		JComboBox cmbAlgo = new JComboBox();
		cmbAlgo.setModel(new DefaultComboBoxModel(new String[] {"HAC", "STC", "Lingo", "TCA", "FTCA", "HTCA", "HFTCA"}));
		panel.add(cmbAlgo, "4, 3, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "1, 5, default, fill");
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panel.add(tabbedPane, "2, 5, 3, 1, fill, fill");
		try{
		ImageIcon google=new ImageIcon("images/google.ico");
		JComponent googlePanel=new JPanel();
		
		JEditorPane googleEditor=new JEditorPane();
		googleEditor.setEditable(false);
		googlePanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,ColumnSpec.decode("50dlu:grow"),FormFactory.RELATED_GAP_COLSPEC},
			new RowSpec[] {
				
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				}) );
		googlePanel.add(googleEditor,"2,2,fill,fill");
		tabbedPane.addTab("Google",google,googlePanel,"Show results from google search engine");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(panel, e.getMessage(), "Web Snippet Clustering", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

}
