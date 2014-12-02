package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.awt.*;

/**
 * @author Florian Then
 * @version 1.0.0
 * Start of window2 with 1194, 550 size
 */
public class Window2 extends JFrame{
	
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
	private int rowsGridLayout;
	private int colsGridLayout;
	private ArrayList<JTextField> textFieldColNames = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMinV = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMaxV = new ArrayList<JTextField>();
	private ArrayList<ArrayList<JTextField>> vMatrixTextfields= new ArrayList<ArrayList<JTextField>>();
	private ArrayList<JTextField> textFieldM = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldK = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldS = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldKel = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMol = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldAmp = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldCand = new ArrayList<JTextField>();
	private JButton buttonReset;
	private JTextField textFieldFormel;

	public Window2(double[][] v_Matrix,String[] row_Names,String[] col_Names, String[][] minMax, String[][] siDimensionslosKontrolle) {

//		setSize(1194, 550);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
 
//		numExp = Run.getNumExp();
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
		
		System.out.println(vMatrix.length);
		System.out.println(vMatrix[0].length);
		lengthVMatrix=vMatrix.length;
		rowsGridLayout=vMatrix.length+2+7+1;
		colsGridLayout=vMatrix[0].length+1;
		
		
//		setSize(colsGridLayout*200, rowsGridLayout* 35);
		setSize(1194, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	public void init() {	
		setLayout(new BorderLayout());
		
		JPanel menuePanel=new JPanel();
		buttonReset=new JButton("Reset");
		menuePanel.add(buttonReset);
		
		menuePanel.add(new JLabel("Formel"));
		
		textFieldFormel=new JTextField();
		textFieldFormel.setMaximumSize(new Dimension(100, 25));
		textFieldFormel.setPreferredSize(new Dimension(100, 25));
		menuePanel.add(textFieldFormel);
		
		getContentPane().add(menuePanel, BorderLayout.NORTH);
		
		JPanel contentPanel=new JPanel();
		
		contentPanel.setLayout(new GridBagLayout());
		((GridBagLayout)contentPanel.getLayout()).columnWidths=new int[]{40,40,40,40,40,
																		 40,40,40,40,40,
																		 40,40,40,40,40,
																		 40,40,40,40,40,
																		 40,40,40,40,40,
																		 40,40,40,40,40};
		((GridBagLayout)contentPanel.getLayout()).rowHeights=new int[]{25,25,25,25,25,
																	   25,25,25,25,25,
																	   25,25,25,25,25,
																	   25,25,25,25,25,
																	   25,25,25,25,25,
																	   25,25,25,25,25};//50-60...++
//		((GridBagLayout)contentPanel.getLayout()).columnWidths=new int[]{40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40,
//																		40,40,40,40,40};
//		((GridBagLayout)contentPanel.getLayout()).rowHeights=new int[]{20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20,
//																		20,20,20,20,20};

		
		contentPanel.add(new JLabel("V-Matrix"), new GridBagConstraints(0, 0, 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		
		//Spalten-Namen
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldColNamesTemp = new JTextField();
			textFieldColNamesTemp.setMaximumSize(new Dimension(100, 25));
			textFieldColNamesTemp.setPreferredSize(new Dimension(100, 25));
			textFieldColNamesTemp.setText(colNames[i]);
			
			contentPanel.add(textFieldColNamesTemp, new GridBagConstraints(1+i, 0, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldColNames.add(textFieldColNamesTemp);
		}
		
		//MinWerte
		contentPanel.add(new JLabel("MinV"), new GridBagConstraints(0, 1, 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldMinVTemp = new JTextField();
			textFieldMinVTemp.setMaximumSize(new Dimension(100, 25));
			textFieldMinVTemp.setPreferredSize(new Dimension(100, 25));
			textFieldMinVTemp.setText(minV[i]);
			contentPanel.add(textFieldMinVTemp, new GridBagConstraints(1+i, 1, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			textFieldMinV.add(textFieldMinVTemp);
		}
		
		//MaxWerte
		contentPanel.add(new JLabel("MaxV"), new GridBagConstraints(0, 2, 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldMaxVTemp = new JTextField();
			textFieldMaxVTemp.setMaximumSize(new Dimension(100, 25));
			textFieldMaxVTemp.setPreferredSize(new Dimension(100, 25));
			textFieldMaxVTemp.setText(maxV[i]);

			contentPanel.add(textFieldMaxVTemp, new GridBagConstraints(1+i, 2, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldMaxV.add(textFieldMaxVTemp);
		}
		
		//VMatrix
		for(int i=0;i<vMatrix.length;i++)
		{
			String tempName=rowNames[i];
			contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3+i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for(int j=0;j<vMatrix[0].length;j++)
			{				
				JTextField vMatrixTextfieldsTemp = new JTextField();
				vMatrixTextfieldsTemp.setMaximumSize(new Dimension(100, 25));
				vMatrixTextfieldsTemp.setPreferredSize(new Dimension(100, 25));
				vMatrixTextfieldsTemp.setText(String.valueOf(vMatrix[i][j]));

				contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(1+j,3+i, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
				
				row.add(vMatrixTextfieldsTemp);
			}
			vMatrixTextfields.add(row);
		}
		
		//MWerte
		contentPanel.add(new JLabel("M"), new GridBagConstraints(0,3+lengthVMatrix , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldMTemp = new JTextField();
			textFieldMTemp.setMaximumSize(new Dimension(100, 25));
			textFieldMTemp.setPreferredSize(new Dimension(100, 25));
			textFieldMTemp.setText(MDimensionslosKontrolle[i]);

			contentPanel.add(textFieldMTemp, new GridBagConstraints(1+i,3+lengthVMatrix, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldM.add(textFieldMTemp);
		}
		
		//KWerte
		contentPanel.add(new JLabel("K"), new GridBagConstraints(0,3+lengthVMatrix+1 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldKTemp = new JTextField();
			textFieldKTemp.setMaximumSize(new Dimension(100, 25));
			textFieldKTemp.setPreferredSize(new Dimension(100, 25));
			textFieldKTemp.setText(KDimensionslosKontrolle[i]);

			contentPanel.add(textFieldKTemp, new GridBagConstraints(1+i, 3+lengthVMatrix+1, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldK.add(textFieldKTemp);
		}
		
		//SWerte
		contentPanel.add(new JLabel("S"), new GridBagConstraints(0,3+lengthVMatrix+2 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldSTemp = new JTextField();
			textFieldSTemp.setMaximumSize(new Dimension(100, 25));
			textFieldSTemp.setPreferredSize(new Dimension(100, 25));
			textFieldSTemp.setText(SDimensionslosKontrolle[i]);

			contentPanel.add(textFieldSTemp, new GridBagConstraints(1+i, 3+lengthVMatrix+2, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldS.add(textFieldSTemp);
		}
	
		//KelWerte
		contentPanel.add(new JLabel("Kel"), new GridBagConstraints(0,3+lengthVMatrix+3 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldKelTemp = new JTextField();
			textFieldKelTemp.setMaximumSize(new Dimension(100, 25));
			textFieldKelTemp.setPreferredSize(new Dimension(100, 25));
			textFieldKelTemp.setText(KelDimensionslosKontrolle[i]);

			contentPanel.add(textFieldKelTemp, new GridBagConstraints(1+i, 3+lengthVMatrix+3, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldKel.add(textFieldKelTemp);
		}
		
		//MolWerte
		contentPanel.add(new JLabel("Mol"), new GridBagConstraints(0,3+lengthVMatrix+4 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldMolTemp = new JTextField();
			textFieldMolTemp.setMaximumSize(new Dimension(100, 25));
			textFieldMolTemp.setPreferredSize(new Dimension(100, 25));
			textFieldMolTemp.setText(MolDimensionslosKontrolle[i]);

			contentPanel.add(textFieldMolTemp, new GridBagConstraints(1+i, 3+lengthVMatrix+4, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldMol.add(textFieldMolTemp);
		}
		
		//AmpWerte
		contentPanel.add(new JLabel("Amp"), new GridBagConstraints(0,3+lengthVMatrix+5 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldAmpTemp = new JTextField();
			textFieldAmpTemp.setMaximumSize(new Dimension(100, 25));
			textFieldAmpTemp.setPreferredSize(new Dimension(100, 25));
			textFieldAmpTemp.setText(AmpDimensionslosKontrolle[i]);

			contentPanel.add(textFieldAmpTemp, new GridBagConstraints(1+i, 3+lengthVMatrix+5, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldAmp.add(textFieldAmpTemp);
		}
		
		//CandWerte
		contentPanel.add(new JLabel("Cand"), new GridBagConstraints(0,3+lengthVMatrix+6 , 1,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		for(int i=0;i<vMatrix[0].length;i++)
		{
			JTextField textFieldCandTemp = new JTextField();
			textFieldCandTemp.setMaximumSize(new Dimension(100, 25));
			textFieldCandTemp.setPreferredSize(new Dimension(100, 25));
			textFieldCandTemp.setText(CandDimensionslosKontrolle[i]);
			
			contentPanel.add(textFieldCandTemp, new GridBagConstraints(1+i, 3+lengthVMatrix+6, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
			
			textFieldCand.add(textFieldCandTemp);
		}

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollpane = new JScrollPane(contentPanel);

		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}

}