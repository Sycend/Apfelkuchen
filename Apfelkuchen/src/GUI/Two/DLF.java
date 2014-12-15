package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Florian Then
 * @version 1.0.2
 * Start of window2 with 1194, 550 size
 */
public class DLF extends JFrame{
	private static final long serialVersionUID = 1L;
	private double[][] vMatrix;
	private String[] rowNames;
	private String[] colNames;
	private String[] minV;
	private String[] maxV;
	private String[] MDimensionslosKontrolle;
	private String[] KDimensionslosKontrolle;
	private String[] SDimensionslosKontrolle;
	private String[] KelDimensionslosKontrolle;
	private String[] MolDimensionslosKontrolle;
	private String[] AmpDimensionslosKontrolle;
	private String[] CandDimensionslosKontrolle;
	private int lengthVMatrix;
	private int widthVMatrix;
	private ArrayList<JTextField> textFieldColNames = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMinV = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMaxV = new ArrayList<JTextField>();
	private ArrayList<ArrayList<JTextField>> vMatrixTextfields= new ArrayList<ArrayList<JTextField>>();
	private ArrayList<ArrayList<JTextField>> lineareAbhängigkeitenTextfields= new ArrayList<ArrayList<JTextField>>();
	private ArrayList<JLabel> labelM = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelK = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelS = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelKel = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelMol = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelAmp = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelCand = new ArrayList<JLabel>();
	private ArrayList<JCheckBox> checkBoxenVMatrix = new ArrayList<JCheckBox>();
	private JButton buttonReset;
	private JButton buttonRMin;
	private JButton buttonRMax;
	private JButton buttonNext;
	private JToggleButton toggle= new JToggleButton();
	
	public DLF(double[][] v_Matrix,String[] row_Names,String[] col_Names, String[][] minMax, String[][] siDimensionslosKontrolle) {

		vMatrix=v_Matrix;
		rowNames=row_Names;
		colNames=col_Names;
		
		String minVTemp[]=new String[minMax[0].length];
		String maxVTemp[]=new String[minMax[0].length];
		for(int i=0;i<vMatrix[0].length;i++)
		{
			minVTemp[i]=minMax[0][i];
			maxVTemp[i]=minMax[1][i];
		}
		minV=minVTemp;
		maxV=maxVTemp;
		
		String MDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		String KDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		String SDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		String KelDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		String MolDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		String AmpDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		String CandDimensionslosKontrolleTemp[]=new String[siDimensionslosKontrolle[0].length];
		for(int j=0;j<vMatrix[0].length;j++)
		{
			MDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[0][j];
			KDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[1][j];
			SDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[2][j];
			KelDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[3][j];
			MolDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[4][j];
			AmpDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[5][j];
			CandDimensionslosKontrolleTemp[j]=siDimensionslosKontrolle[6][j];
		}
		MDimensionslosKontrolle=MDimensionslosKontrolleTemp;
		KDimensionslosKontrolle=KDimensionslosKontrolleTemp;
		SDimensionslosKontrolle=SDimensionslosKontrolleTemp;
		KelDimensionslosKontrolle=KelDimensionslosKontrolleTemp;
		MolDimensionslosKontrolle=MolDimensionslosKontrolleTemp;
		AmpDimensionslosKontrolle=AmpDimensionslosKontrolleTemp;
		CandDimensionslosKontrolle=CandDimensionslosKontrolleTemp;
		
		//Testausgabe um Matrix-Ausmaße zu überprüfen
		System.out.println(vMatrix.length);
		System.out.println(vMatrix[0].length);
		lengthVMatrix=vMatrix.length;
		widthVMatrix=vMatrix[0].length;
		
		setSize(1194, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Apfelkuchen Window2");
		init();
		setVisible(true);
	}
	public void init() {	
		setLayout(new BorderLayout());
		
		JPanel menuePanel=new JPanel();
		buttonReset=new JButton("Reset");
		menuePanel.add(buttonReset);
		
		//add Controler
		toggle.setText("Natursicht");
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if(toggle.getText()=="Natursicht")
				{
					toggle.setText("log-Sicht");
				}else
				{
					toggle.setText("Natursicht");
				}
	      }
	    };
	    toggle.addActionListener(actionListener);
		menuePanel.add(toggle);
		
		buttonNext=new JButton("Weiter");
		menuePanel.add(buttonNext);
		getContentPane().add(menuePanel, BorderLayout.NORTH);
		
		JPanel contentPanel=new JPanel();
		
		contentPanel.setLayout(new GridBagLayout());
		((GridBagLayout)contentPanel.getLayout()).columnWidths=new int[]{40,40,40,40,40,
																		40,40,40,40,40,
																		40,40,40,40,40,
																		40,40,40,40,40,
																		40,40,40,40,40,
																		40,40,40,40,40};
		((GridBagLayout)contentPanel.getLayout()).rowHeights=new int[]{25,25,25,25,25,};
		
		contentPanel.add(new JLabel("V-Matrix"), new GridBagConstraints(0, 0, 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		
		//Spalten-Namen
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldColNamesTemp = new JTextField();
			textFieldColNamesTemp.setMaximumSize(new Dimension(50, 25));
			textFieldColNamesTemp.setPreferredSize(new Dimension(50, 25));
			textFieldColNamesTemp.setText(colNames[i]);
			textFieldColNamesTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(textFieldColNamesTemp, new GridBagConstraints(1+3*i, 0, 3,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 10, 5), 0, 0));
			
			textFieldColNames.add(textFieldColNamesTemp);
		}
		
		//MinWerte
		contentPanel.add(new JLabel("MinV"), new GridBagConstraints(0, 1, 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
		
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldMinVTemp = new JTextField();
			textFieldMinVTemp.setMaximumSize(new Dimension(50, 25));
			textFieldMinVTemp.setPreferredSize(new Dimension(50, 25));
			textFieldMinVTemp.setText(minV[i]);
			contentPanel.add(textFieldMinVTemp, new GridBagConstraints(1+3*i, 1, 3,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			textFieldMinV.add(textFieldMinVTemp);
			if(i==vMatrix[0].length-1)
			{
				buttonRMin=new JButton("R");
				contentPanel.add(buttonRMin, new GridBagConstraints(1+3*i+3, 1, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			}
		}		
		
		//MaxWerte
		contentPanel.add(new JLabel("MaxV"), new GridBagConstraints(0, 2, 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldMaxVTemp = new JTextField();
			textFieldMaxVTemp.setMaximumSize(new Dimension(50, 25));
			textFieldMaxVTemp.setPreferredSize(new Dimension(50, 25));
			textFieldMaxVTemp.setText(maxV[i]);

			contentPanel.add(textFieldMaxVTemp, new GridBagConstraints(1+3*i, 2, 3,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			textFieldMaxV.add(textFieldMaxVTemp);
			if(i==vMatrix[0].length-1)
			{
				buttonRMax=new JButton("R");
				contentPanel.add(buttonRMax, new GridBagConstraints(1+3*i+3, 2, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			}
		}
		
		//VMatrix
		for(int i=0;i<vMatrix.length;i++)
		{		
			
			String tempName=rowNames[i];
			if(i==0)
			{
				contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			}else
			{
				if(i==vMatrix.length-1)
				{
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				}else
				{
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
				}
			}
			JCheckBox checkBoxVMatrixTemp=new JCheckBox();
			if(i==0)
			{
				contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1,3+i, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			}else
			{
				if(i==vMatrix.length-1)
				{
					contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1,3+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				}else
				{
					contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1,3+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
					checkBoxenVMatrix.add(checkBoxVMatrixTemp);
				}
			}
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for(int j=0;j<vMatrix[0].length;j++)
			{	
				JTextField vMatrixTextfieldsTemp = new JTextField();
				vMatrixTextfieldsTemp.setMaximumSize(new Dimension(50, 25));
				vMatrixTextfieldsTemp.setPreferredSize(new Dimension(50, 25));
				vMatrixTextfieldsTemp.setText(String.valueOf(vMatrix[i][j]));
				vMatrixTextfieldsTemp.setHorizontalAlignment(SwingConstants.CENTER);

				if(i==0)
				{
					contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(2+3*j,3+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
				}else
				{
					if(i==vMatrix.length-1)
					{
						contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(2+3*j,3+i, 1,
								1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
					}else
					{
						
						contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(2+3*j,3+i, 1,
								1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
					}					
				}
								
				row.add(vMatrixTextfieldsTemp);
			}
			vMatrixTextfields.add(row);
		}
		
		//Lineare Abhängigkeits Matrix
		for(int i=0;i<vMatrix[0].length;i++)
		{		
			String tempName=colNames[i];
			if(i==0)
			{
				contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+lengthVMatrix+i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			}else
			{
				if(i==vMatrix.length-1)
				{
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+lengthVMatrix+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				}else
				{
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+lengthVMatrix+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
				}
			}
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for(int j=0;j<vMatrix[0].length;j++)
			{	
				JTextField lineareAbhängigkeitenTextfieldsTemp = new JTextField();
				lineareAbhängigkeitenTextfieldsTemp.setMaximumSize(new Dimension(50, 25));
				lineareAbhängigkeitenTextfieldsTemp.setPreferredSize(new Dimension(50, 25));
				lineareAbhängigkeitenTextfieldsTemp.setText(String.valueOf(1));
				lineareAbhängigkeitenTextfieldsTemp.setHorizontalAlignment(SwingConstants.CENTER);

				if(i==0)
				{
					contentPanel.add(lineareAbhängigkeitenTextfieldsTemp, new GridBagConstraints(2+3*j,3+lengthVMatrix+i, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
				}else
				{
					if(i==vMatrix.length-1)
					{
						contentPanel.add(lineareAbhängigkeitenTextfieldsTemp, new GridBagConstraints(2+3*j,3+lengthVMatrix+i, 1,
								1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
					}else
					{
						
						contentPanel.add(lineareAbhängigkeitenTextfieldsTemp, new GridBagConstraints(2+3*j,3+lengthVMatrix+i, 1,
								1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
					}					
				}				
				
				row.add(lineareAbhängigkeitenTextfieldsTemp);
			}
			lineareAbhängigkeitenTextfields.add(row);
		}
		
		
		
		//MWerte
		contentPanel.add(new JLabel("M"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JLabel labelMTemp = new JLabel();
			labelMTemp.setMaximumSize(new Dimension(50, 25));
			labelMTemp.setPreferredSize(new Dimension(50, 25));
			labelMTemp.setText(MDimensionslosKontrolle[i]);
			labelMTemp.setHorizontalAlignment(SwingConstants.CENTER);

			contentPanel.add(labelMTemp, new GridBagConstraints(2+3*i,3+lengthVMatrix+widthVMatrix, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
					
			labelM.add(labelMTemp);
		}
		
		//KWerte
		contentPanel.add(new JLabel("K"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix+1 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JLabel labelKTemp = new JLabel();
			labelKTemp.setMaximumSize(new Dimension(50, 25));
			labelKTemp.setPreferredSize(new Dimension(50, 25));
			labelKTemp.setText(KDimensionslosKontrolle[i]);
			labelKTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelKTemp, new GridBagConstraints(2+3*i, 3+lengthVMatrix+widthVMatrix+1, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelK.add(labelKTemp);
		}
		
		//SWerte
		contentPanel.add(new JLabel("S"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix+2 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JLabel labelSTemp = new JLabel();
			labelSTemp.setMaximumSize(new Dimension(50, 25));
			labelSTemp.setPreferredSize(new Dimension(50, 25));
			labelSTemp.setText(SDimensionslosKontrolle[i]);
			labelSTemp.setHorizontalAlignment(SwingConstants.CENTER);

			contentPanel.add(labelSTemp, new GridBagConstraints(2+3*i, 3+lengthVMatrix+widthVMatrix+2, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelS.add(labelSTemp);
		}
	
		//KelWerte
		contentPanel.add(new JLabel("Kel"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix+3 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JLabel labelKelTemp = new JLabel();
			labelKelTemp.setMaximumSize(new Dimension(50, 25));
			labelKelTemp.setPreferredSize(new Dimension(50, 25));
			labelKelTemp.setText(KelDimensionslosKontrolle[i]);
			labelKelTemp.setHorizontalAlignment(SwingConstants.CENTER);

			contentPanel.add(labelKelTemp, new GridBagConstraints(2+3*i, 3+lengthVMatrix+widthVMatrix+3, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelKel.add(labelKelTemp);
		}
		
		//MolWerte
		contentPanel.add(new JLabel("Mol"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix+4 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JLabel labelMolTemp = new JLabel();
			labelMolTemp.setMaximumSize(new Dimension(50, 25));
			labelMolTemp.setPreferredSize(new Dimension(50, 25));
			labelMolTemp.setText(MolDimensionslosKontrolle[i]);
			labelMolTemp.setHorizontalAlignment(SwingConstants.CENTER);

			contentPanel.add(labelMolTemp, new GridBagConstraints(2+3*i, 3+lengthVMatrix+widthVMatrix+4, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelMol.add(labelMolTemp);
		}
		
		//AmpWerte
		contentPanel.add(new JLabel("Amp"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix+5 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{			
			JLabel labelAmpTemp = new JLabel();
			labelAmpTemp.setMaximumSize(new Dimension(50, 25));
			labelAmpTemp.setPreferredSize(new Dimension(50, 25));
			labelAmpTemp.setText(AmpDimensionslosKontrolle[i]);
			labelAmpTemp.setHorizontalAlignment(SwingConstants.CENTER);

			contentPanel.add(labelAmpTemp, new GridBagConstraints(2+3*i, 3+lengthVMatrix+widthVMatrix+5, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelAmp.add(labelAmpTemp);
		}
		
		//CandWerte
		contentPanel.add(new JLabel("Cand"), new GridBagConstraints(0,3+lengthVMatrix+widthVMatrix+6 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{			
			JLabel labelCandTemp = new JLabel();
			labelCandTemp.setMaximumSize(new Dimension(50, 25));
			labelCandTemp.setPreferredSize(new Dimension(50, 25));
			labelCandTemp.setText(CandDimensionslosKontrolle[i]);
			labelCandTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelCandTemp, new GridBagConstraints(2+3*i, 3+lengthVMatrix+widthVMatrix+6, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			labelCand.add(labelCandTemp);
		}

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollpane = new JScrollPane(contentPanel);

		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}
	
}