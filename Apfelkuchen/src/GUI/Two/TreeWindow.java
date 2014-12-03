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
 * @version 1.0.2
 */
public class TreeWindow extends JFrame {
	private JTree tree;
	private String selectedItem;
	private String selectedItemParent;
	private JButton buttonOk;
	private String[] nameSiUnit;
	private boolean checkNode = false;
	
	public TreeWindow(JTextField textFieldDimensionPointer, JTextField textFieldUnitPointer) {
		nameSiUnit = (Run.getDimensions());
		
		// create the root node
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(XMLDate.dateLabels("title"));
		this.setAlwaysOnTop(true);
		this.setSize(400, 400);
		this.setVisible(true);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		
		for (int i = 0; i < nameSiUnit.length; i++) {
			// create the child nodes of root
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(nameSiUnit[i]);
			
			root.add(node);
			// create the child nodes of SI Unitname (Time->min, sec)
			
			for (int j = 0; j < Run.unitsArray.size(); j++) {
				if (nameSiUnit[i].equals(Run.unitsArray.get(j).getTypeName()))
					node.add(new DefaultMutableTreeNode((Run.unitsArray.get(j).getUnitName())));
				
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
						//Run.addNewDimensionTextObject(textFieldDimensionPointer);
						dispose();
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
	
	
	public TreeWindow(JTextField textFieldUnitPointer) {
		nameSiUnit = (Run.getDimensions());
		
		// create the root node
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(XMLDate.dateLabels("title"));
		this.setAlwaysOnTop(true);
		this.setSize(400, 400);
		this.setVisible(true);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		
		for (int i = 0; i < nameSiUnit.length; i++) {
			// create the child nodes of root
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(nameSiUnit[i]);
			
			root.add(node);
			// create the child nodes of SI Unitname (Time->min, sec)
			
			for (int j = 0; j < Run.unitsArray.size(); j++) {
				if (nameSiUnit[i].equals(Run.unitsArray.get(j).getTypeName()))
					node.add(new DefaultMutableTreeNode((Run.unitsArray.get(j).getUnitName())));
				
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
						Window.setSelectionItem(selectedItem, textFieldUnitPointer);
						System.out.println("selected Item: "+selectedItem);
						//Window.setSelectionItem(selectedItemParent, selectedItem, textFieldDimensionPointer, textFieldUnitPointer);
						//Run.addNewDimensionTextObject(selectedItemParent, textFieldDimensionPointer);
						dispose();
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
