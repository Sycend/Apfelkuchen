package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * JTree Window for selection of dimensions and units
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 1.0.5
 */
public class TreeWindow extends JFrame {
	//serialVersionUID is generated
	private static final long serialVersionUID = -6399135783516007764L;
	private JTree tree;
	private String selectedItem;
	private String selectedItemParent;
	private JButton buttonOk;
	private String[] dimensions = Util.getInstance().getDimensions();
	private boolean checkNode = false;
	private Color bgColor = new Color(0xADFF2F);
	public TreeWindow(JTextField textFieldDimension, JTextField textFieldUnit) {
		//set background of fields
		textFieldDimension.setBackground(bgColor);
		textFieldUnit.setBackground(bgColor);
		// create the root node
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(Util.getInstance().getStringFromXML("title"));
		this.setAlwaysOnTop(true);
		this.setSize(400, 400);
		this.setLocation(400, 300);
		this.setVisible(true);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		
		for (int i = 0; i < dimensions.length; i++) {
			// create the child nodes of root
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(dimensions[i]);
			
			root.add(node);
			// create the child nodes of SI Unitname (Time->min, sec)
			
			for (int j = 0; j < Util.getInstance().unitsArray.size(); j++) {
				if (dimensions[i].equals(Util.getInstance().unitsArray.get(j).getDimension()))
					node.add(new DefaultMutableTreeNode((Util.getInstance().unitsArray.get(j).getUnit())));
				
				root.add(node);
			}
		}
		
		// create the tree by passing in the root node
		tree = new JTree(root);
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		tree.setCellRenderer(renderer);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
		add(new JScrollPane(tree));
		
		buttonOk = new JButton("OK");
		buttonOk.setMaximumSize(new Dimension(40, 20));
		buttonOk.setPreferredSize(new Dimension(40, 20));
		buttonOk.setFocusPainted(false);
		buttonOk.setSize(110, 20);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOk) {
					if (checkNode == true) {
						setVisible(false);
						WindowRelevantFactors.setSelectionItem(selectedItemParent, selectedItem, textFieldDimension, textFieldUnit);
						WindowRelevantFactors.treeOpend=false; // set flag for opend window
						textFieldDimension.setBackground(Color.WHITE); 
						textFieldUnit.setBackground(Color.WHITE);
						dispose();
						
						if (Util.getInstance().unitsArray.size() > 0) {
							for (int i = 0; i < WindowRelevantFactors.textFieldDimension.size(); i++) {
								for (int n = 0; n < Util.getInstance().unitsArray.size(); n++) {
									if (WindowRelevantFactors.textFieldDimension.get(i).getText().equals(Util.getInstance().unitsArray.get(n).getDimension())) {
										if (WindowRelevantFactors.textFieldUnit.get(i).getText().equals(Util.getInstance().unitsArray.get(n).getUnit())) {
											WindowRelevantFactors.textFieldM.get(i).setText("" + Util.getInstance().unitsArray.get(n).getM());
											WindowRelevantFactors.textFieldK.get(i).setText("" + Util.getInstance().unitsArray.get(n).getK());
											WindowRelevantFactors.textFieldS.get(i).setText("" + Util.getInstance().unitsArray.get(n).getS());
											WindowRelevantFactors.textFieldKel.get(i).setText("" + Util.getInstance().unitsArray.get(n).getKel());
											WindowRelevantFactors.textFieldMol.get(i).setText("" + Util.getInstance().unitsArray.get(n).getMol());
											WindowRelevantFactors.textFieldAmp.get(i).setText("" + Util.getInstance().unitsArray.get(n).getAmp());
											WindowRelevantFactors.textFieldCand.get(i).setText("" + Util.getInstance().unitsArray.get(n).getCand());
										}
									}
								}
							}
							
							WindowRelevantFactors.doSICalculationLow();
							WindowRelevantFactors.doSICalculationHigh();
							
						} else {
							System.out.println("Util.getInstance().unitsArray is empty");
						}
						
					}
				}
			}
		});
		add(buttonOk, BorderLayout.SOUTH);
		
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (!selectedNode.getParent().toString().equals("Root")) {
					selectedItem = selectedNode.getUserObject().toString();
					selectedItemParent = selectedNode.getParent().toString();
					checkNode = true;
				}
			}
		});
	
	
	this.addWindowListener(new WindowListener() {
		@Override
		public void windowOpened(WindowEvent e) {
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			textFieldDimension.setBackground(Color.WHITE); 
			textFieldUnit.setBackground(Color.WHITE);		
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
		}
	});
	
		
	
}
}