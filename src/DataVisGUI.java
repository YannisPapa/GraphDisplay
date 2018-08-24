import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DataVisGUI extends javax.swing.JFrame {

	int lastPressed;
	Graph myGraph = new Graph();
	int maxNodes = 12;
	int currentNode = 0;
	int currentX = 0;
	int currentY = 0;
	double theta = (2*Math.PI)/maxNodes;

	public DataVisGUI() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jButton6 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jTextArea3 = new javax.swing.JTextArea();


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Data Visualisation");

		jPanel1.setBackground(new java.awt.Color(102, 0, 153));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		jButton6.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jButton6.setText("Apply");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				apply(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("jLabel1");

		jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("jLabel2");

		jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 12));

		jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel3Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jTextField2).addComponent(jTextField1).addComponent(jTextArea3)
										.addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel2)
								.addComponent(jTextArea3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton6).addContainerGap()));

		jButton6.setVisible(false);
		jLabel1.setVisible(false);
		jLabel2.setVisible(false);
		jTextField1.setVisible(false);
		jTextField2.setVisible(false);
		jTextArea3.setVisible(false);

		jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jButton1.setText("Add Node");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lastPressed = 0;
				addNode(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jButton2.setText("Add Edge");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lastPressed = 2;
				addEdge(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jButton3.setText("Remove Edge");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lastPressed = 3;
				removeEdge(evt);
			}
		});

		jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jButton4.setText("Remove Node");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lastPressed = 1;
				removeNode(evt);
			}
		});

		jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12));
		jButton5.setText("View Node");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lastPressed = 4;
				viewNode(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jButton1)
										.addGap(18, 18, 18).addComponent(jButton4).addGap(18, 18, 18)
										.addComponent(jButton2).addGap(18, 18, 18).addComponent(jButton3)
										.addGap(18, 18, 18).addComponent(jButton5).addGap(18, 18, 18)
										.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));

		jPanel2.setBackground(jPanel2.getBackground());
		
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 653, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 496, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel2,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		pack();
	}

	private void addNode(java.awt.event.ActionEvent evt) {
		jLabel1.setVisible(true);
		jLabel2.setVisible(true);
		jLabel1.setText("Node Name");
		jLabel2.setText("Node Weight");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField1.setVisible(true);
		jTextField2.setVisible(true);
		jTextArea3.setVisible(false);
		jButton6.setVisible(true);
	}

	private void removeNode(java.awt.event.ActionEvent evt) {
		jLabel1.setVisible(true);
		jLabel2.setVisible(false);
		jLabel1.setText("Node Name");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField1.setVisible(true);
		jTextField2.setVisible(false);
		jTextArea3.setVisible(false);
		jButton6.setVisible(true);
	}

	private void addEdge(java.awt.event.ActionEvent evt) {
		jLabel1.setVisible(true);
		jLabel2.setVisible(true);
		jLabel1.setText("From Node");
		jLabel2.setText("To Node");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField1.setVisible(true);
		jTextField2.setVisible(true);
		jTextArea3.setVisible(false);
		jButton6.setVisible(true);
	}

	private void removeEdge(java.awt.event.ActionEvent evt) {
		jLabel1.setVisible(true);
		jLabel2.setVisible(true);
		jLabel1.setText("From Node");
		jLabel2.setText("To Node");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField1.setVisible(true);
		jTextField2.setVisible(true);
		jTextArea3.setVisible(false);
		jButton6.setVisible(true);
	}

	private void viewNode(java.awt.event.ActionEvent evt) {
		jLabel1.setVisible(true);
		jLabel2.setVisible(false);
		jLabel1.setText("Node Name");
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField1.setVisible(true);
		jTextField2.setVisible(false);
		jTextArea3.setVisible(true);
		jTextArea3.setEditable(false);
		jButton6.setVisible(true);
	}

	private void apply(java.awt.event.ActionEvent evt) { // ***********************************************************************************************
		String name1 = "";
		String name2 = "";
		Node node1;
		Node node2;
		int weight = -1;
		String weight2 = "";
		switch (lastPressed) {
		case 0:
			// input validation
			name1 = jTextField1.getText();
			weight2 = jTextField2.getText();
			if(name1.equals("") || weight2.equals("")) {
				JOptionPane.showMessageDialog(new JFrame(), "One of the fields are empty", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			try {
				weight = Integer.parseInt(weight2);
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(new JFrame(), "Weight needs to be a number", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if(weight > 12 || weight < 1) {
				JOptionPane.showMessageDialog(new JFrame(), "Weight needs to be between 1 and 12", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if(currentNode == maxNodes) {
				JOptionPane.showMessageDialog(new JFrame(), "Max Nodes is currently set to: " + maxNodes, "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			Node tempNode = new Node(name1, weight);
			if (this.myGraph.addNode(tempNode, true)) {
				updateCoord(tempNode);
				drawGraph();
			}
			break;
		case 1:
			name1 = jTextField1.getText();
			if(name1.equals("")) {
				JOptionPane.showMessageDialog(new JFrame(), "One of the fields are empty", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (this.myGraph.removeNode(name1) != null) {
				this.currentNode--;
				drawGraph();
			}
			break;
		case 2:
			name1 = jTextField1.getText();
			name2 = jTextField2.getText();
			if(name1.equals("") || name2.equals("")) {
				JOptionPane.showMessageDialog(new JFrame(), "One of the fields are empty", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			node1 = myGraph.getNode(name1);
			node2 = myGraph.getNode(name2);
			this.myGraph.addEdge(node1, node2);
			drawGraph();
			break;
		case 3:
			name1 = jTextField1.getText();
			name2 = jTextField2.getText();
			if(name1.equals("") || name2.equals("")) {
				JOptionPane.showMessageDialog(new JFrame(),"One of the fields are empty", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			node1 = myGraph.getNode(name1);
			node2 = myGraph.getNode(name2);
			Edge tempEdge = new Edge(node1, node2);
			this.myGraph.removeEdge(tempEdge);
			drawGraph();
			break;
		case 4:
			name1 = jTextField1.getText();
			if(name1.equals("")) {
				JOptionPane.showMessageDialog(new JFrame(),"You need to enter a node name", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if(this.myGraph.getNode(name1) == null) {
				JOptionPane.showMessageDialog(new JFrame(),"This node does not exist", "Warning", JOptionPane.ERROR_MESSAGE);
				break;
			}
			node1 = this.myGraph.getNode(name1);
			jTextArea3.setText(node1.toString());
			break;
		}
	}

	public void updateCoord(Node node) {
		this.currentNode++;
		ArrayList<Node> temp = this.myGraph.getNodes();
		boolean found = false;
		if(temp.get(0) == null) {
			currentX = (int) (318 + (215 * Math.cos(theta*currentNode)));
			currentY = (int) (225 + (215 * Math.sin(theta*currentNode)));
			node.setX(this.currentX);
			node.setY(this.currentY);
			node.setNodeNum(currentNode);
		}
		int j;
		for(j = 1; j <= maxNodes; j++) {
			for (int i = 0; i < temp.size(); i++) {
				if(temp.get(i).getNodeNum() == j) {
					found = true;
					break;
				}
			}
			if(found == false) {
				currentX = (int) (318 + (215 * Math.cos(theta*j)));
				currentY = (int) (225 + (215 * Math.sin(theta*j)));
				break;
			}
			found = false;
		}
		node.setX(this.currentX);
		node.setY(this.currentY);
		node.setNodeNum(j);
	}

	public void drawGraph() {
		Graphics2D gfx = (Graphics2D) jPanel2.getGraphics();
		gfx.clearRect(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
		ArrayList<Edge> temp2 = this.myGraph.getEdges();
		for (int i = 0; i < temp2.size(); i++) {
			gfx.setColor(Color.black);
			gfx.setStroke(new BasicStroke(5));
			gfx.drawLine( 13+temp2.get(i).getOne().getX(), 13+temp2.get(i).getOne().getY(), 13+temp2.get(i).getTwo().getX(), 13+temp2.get(i).getTwo().getY());
		}
		ArrayList<Node> temp = this.myGraph.getNodes();
		for (int i = 0; i < temp.size(); i++) {
			Color nodeColor = getColor(temp.get(i).getWeight());
			gfx.setColor(nodeColor);
			gfx.fillOval(temp.get(i).getX(), temp.get(i).getY(), 25, 25);
			gfx.setColor(Color.black);
			gfx.setFont(new Font("default", Font.BOLD, 20));
			gfx.drawString( temp.get(i).getName(), temp.get(i).getX()+7, temp.get(i).getY()+17);
			gfx.setColor(Color.white);
			gfx.setFont(new Font("default", Font.BOLD, 16));
			gfx.drawString( temp.get(i).getName(), temp.get(i).getX()+8, temp.get(i).getY()+16);
		}
		
		gfx.setColor(Color.black);
		gfx.setFont(new Font("default", Font.BOLD, 16));
		gfx.drawString( "1", 0, 470);
		gfx.drawString( "12", 630, 470);
		
		Graphics2D g2d = (Graphics2D) gfx;
		Point2D start = new Point2D.Float(0, 475);
		Point2D end = new Point2D.Float(653, 496);
		float[] dist = { 0.0f, 0.33f, 0.66f, 1.0f };
		Color[] colors = { Color.MAGENTA ,Color.BLUE, Color.GREEN, Color.RED };
		LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
		g2d.setPaint(p);
		g2d.fillRect(0, 475, 653, 496);
	}

	public Color getColor(int weight) {
		Color tempColor = new Color(255,255,255);
		switch(weight) {
			case 1: tempColor = new Color(255,0,255); break;
			case 2: tempColor = new Color(204,153,255); break;
			case 3: tempColor = new Color(127,0,255); break;
			case 4: tempColor = new Color(0,0,255); break;
			case 5: tempColor = new Color(0,128,255); break;
			case 6: tempColor = new Color(0,204,204); break;
			case 7: tempColor = new Color(0,153,153); break;
			case 8: tempColor = new Color(0,255,0); break;
			case 9: tempColor = new Color(76,153,0); break;
			case 10: tempColor = new Color(153,153,0); break;
			case 11: tempColor = new Color(255,128,0); break;
			case 12: tempColor = new Color(255,0,0); break;
		}
		return tempColor;
	}
	
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DataVisGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DataVisGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DataVisGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DataVisGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DataVisGUI().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextArea jTextArea3;
}
