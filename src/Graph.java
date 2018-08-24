import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Graph {

	private HashMap<String, Node> vertices;
	private HashMap<Integer, Edge> edges;

	public Graph() {
		this.vertices = new HashMap<String, Node>();
		this.edges = new HashMap<Integer, Edge>();
	}

	public Graph(ArrayList<Node> vertices) {
		this.vertices = new HashMap<String, Node>();
		this.edges = new HashMap<Integer, Edge>();

		for (Node v : vertices) {
			this.vertices.put(v.getName(), v);
		}

	}

	public boolean addEdge(Node one, Node two) {
		return addEdge(one, two, 1);
	}

	public boolean addEdge(Node one, Node two, int weight) {
		if(one == null || two == null) {
			JOptionPane.showMessageDialog(new JFrame(),"One of these Vertices do not Exist", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (one.equals(two)) {
			JOptionPane.showMessageDialog(new JFrame(),"The two vertices are the same", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Edge e = new Edge(one, two, weight);
		if (edges.containsKey(e.hashCode())) {
			JOptionPane.showMessageDialog(new JFrame(),"This Edge already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else if (one.containsNeighbor(e) || two.containsNeighbor(e)) {
			JOptionPane.showMessageDialog(new JFrame(),"This Edge already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Edge temp = new Edge(two, one, weight);
		if (edges.containsKey(temp.hashCode())) {
			JOptionPane.showMessageDialog(new JFrame(),"This Edge already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else if (one.containsNeighbor(temp) || two.containsNeighbor(temp)) {
			JOptionPane.showMessageDialog(new JFrame(),"This Edge already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		edges.put(e.hashCode(), e);
		one.addEdge(e);
		two.addEdge(e);
		System.out.println("Added Edge Between: " + one.getName() + ", and " + two.getName());
		return true;
	}

	public boolean containsEdge(Edge e) {
		if (e.getOne() == null || e.getTwo() == null) {
			return false;
		}

		return this.edges.containsKey(e.hashCode());
	}

	public Edge removeEdge(Edge e) {
		Edge temp = new Edge(e.getOne(), e.getTwo());
		Edge temp2 = new Edge(e.getTwo(), e.getOne());
		if(e.getOne() == null || e.getTwo() == null) {
			JOptionPane.showMessageDialog(new JFrame(),"No such Edge exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		temp = this.edges.remove(temp.hashCode());
		temp2 = this.edges.remove(temp2.hashCode());
		if (temp == null && temp2 == null) {
			JOptionPane.showMessageDialog(new JFrame(),"No such Edge exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if (temp == null) {
			temp2.getOne().removeEdge(temp2);
			temp2.getTwo().removeEdge(temp2);
			System.out.println("Removed Edge Between: " + temp2.getOne().getName() + ", and " + temp2.getTwo().getName());
			return temp2;
		}
		temp.getOne().removeEdge(temp);
		temp.getTwo().removeEdge(temp);
		System.out.println("Removed Edge Between: " + temp.getOne().getName() + ", and " + temp.getTwo().getName());
		return temp;
	}

	public boolean containsNode(Node Node) {
		return this.vertices.get(Node.getName()) != null;
	}

	public Node getNode(String label) {
		return vertices.get(label);
	}

	public boolean addNode(Node Node, boolean overwriteExisting) {
		Node current = this.vertices.get(Node.getName());
		if(current != null) {
			JOptionPane.showMessageDialog(new JFrame(),"A Node with that Name already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		vertices.put(Node.getName(), Node);
		System.out.println("Added Node: " + Node.getName() + ", Weight: " + Node.getWeight());
		return true;
	}

	public Node removeNode(String label) {
		Node v = vertices.remove(label);
		if (v == null) {
			JOptionPane.showMessageDialog(new JFrame(),"No Node with that Name exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		System.out.println("Removed Node: " + v.getName() + ", Weight: " + v.getWeight());
		if (v.degree() == 0) {
			return v;
		}
		while (v.degree() > 0) {
			this.removeEdge(v.getEdgeList((0)));
		}
		return v;
	}

	public Set<String> NodeKeys() {
		return this.vertices.keySet();
	}

	public ArrayList<Node> getNodes() {
		ArrayList<Node> tempList = new ArrayList<Node>();
		for (Node v : vertices.values()) {
			tempList.add(v);
		}
		return tempList;
	}
	
	public ArrayList<Edge> getEdges() {
		ArrayList<Edge> tempList = new ArrayList<Edge>();
		for (Edge e : edges.values()) {
			tempList.add(e);
		}
		return tempList;
	}

}
