package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTree tree;
	private String selectedItem;
	private String selectedItemParent;
	private JButton buttonOk;
	private String[] dimensions = Run.getDimensions();
	private boolean checkNode = false;
	
	public TreeWindow(JTextField textFieldDimensionPointer, JTextField textFieldUnitPointer) {
		
		// create the root node
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle(XMLDate.dateLabels("title"));
		this.setAlwaysOnTop(true);
		this.setSize(400, 400);
		this.setVisible(true);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		
		for (int i = 0; i < dimensions.length; i++) {
			// create the child nodes of root
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(dimensions[i]);
			
			root.add(node);
			// create the child nodes of SI Unitname (Time->min, sec)
			
			for (int j = 0; j < Run.unitsArray.size(); j++) {
				if (dimensions[i].equals(Run.unitsArray.get(j).getDimension()))
					node.add(new DefaultMutableTreeNode((Run.unitsArray.get(j).getUnit())));
				
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
						Window.setSelectionItem(selectedItemParent, selectedItem, textFieldDimensionPointer, textFieldUnitPointer);
						dispose();
						
						if (Run.unitsArray.size() > 0) {
							for (int i = 0; i < Window.textFieldDimension.size(); i++) {
								for (int n = 0; n < Run.unitsArray.size(); n++) {
									if (Window.textFieldDimension.get(i).getText().equals(Run.unitsArray.get(n).getDimension())) {
										if (Window.textFieldUnit.get(i).getText().equals(Run.unitsArray.get(n).getUnit())) {
											Window.textFieldM.get(i).setText("" + Run.unitsArray.get(n).getM());
											Window.textFieldK.get(i).setText("" + Run.unitsArray.get(n).getK());
											Window.textFieldS.get(i).setText("" + Run.unitsArray.get(n).getS());
											Window.textFieldKel.get(i).setText("" + Run.unitsArray.get(n).getKel());
											Window.textFieldMol.get(i).setText("" + Run.unitsArray.get(n).getMol());
											Window.textFieldAmp.get(i).setText("" + Run.unitsArray.get(n).getAmp());
											Window.textFieldCand.get(i).setText("" + Run.unitsArray.get(n).getCand());
										}
									}
								}
							}
						} else {
							System.out.println("Run.unitsArray is empty");
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
	}
}