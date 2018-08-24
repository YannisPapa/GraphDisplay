import java.util.ArrayList;

public class Node {

	private String gName;
	private int gWeight;
	private ArrayList<Edge> edgeList;
	private int xCoord;
	private int yCoord;
	private int nodeNum;

	public Node(String name) {
		this.gName = name;
		this.edgeList = new ArrayList<Edge>();
	}

	public Node(String name, int weight) {
		this.gName = name;
		this.gWeight = weight;
		this.edgeList = new ArrayList<Edge>();
	}

	public void addEdge(Edge nEdge) {
		if (this.edgeList.contains(nEdge)) {
			return;
		}
		this.edgeList.add(nEdge);
	}

	public void removeEdge(Edge nEdge) {
		this.edgeList.remove(nEdge);
	}

	public String getName() {
		return this.gName;
	}

	public int getWeight() {
		return this.gWeight;
	}

	public int degree() {
		return this.edgeList.size();
	}

	public int getX() {
		return this.xCoord;
	}

	public int getY() {
		return this.yCoord;
	}
	
	public void setX(int coord) {
		this.xCoord = coord;
	}
	
	public void setY(int coord) {
		this.yCoord = coord;
	}

	public boolean isNeighbour(Edge nEdge) {
		return this.edgeList.contains(nEdge);
	}

	public int hashCode() {
		return this.gName.hashCode();
	}

	public ArrayList<Edge> getEdgeList() {
		return new ArrayList<Edge>(this.edgeList);
	}

	public boolean containsNeighbor(Edge other) {
		return this.edgeList.contains(other);
	}

	public Edge getEdgeList(int index) {
		return this.edgeList.get(index);
	}
	
	public int getNodeNum() {
		return this.nodeNum;
	}
	
	public void setNodeNum(int num) {
		this.nodeNum = num;
	}
	
	public String toString() {
		String names = "";
		if(this.edgeList.size() == 0) {
			names = "\nNot Connected";
		} else {
			for(int i = 0; i < this.edgeList.size(); i++) {
				names = names + edgeList.get(i).toString();
			}
		}
		String info = "Name: " + this.gName + "\n" + "Weight: " + this.gWeight + "\n" + "Connected to: " + names;
		return info;
	}

}
