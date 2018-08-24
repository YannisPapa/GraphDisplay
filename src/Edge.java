public class Edge {

    private Node one, two;
    private int weight;
    
    public Edge(Node nOne, Node nTwo){
        this(nOne, nTwo, 1);
    }
    
    public Edge(Node one, Node two, int weight){
        this.one =  one;
        this.two = two;
        this.weight = weight;
    }
    
    public Node getOne(){
        return this.one;
    }
    
    public Node getTwo(){
        return this.two;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public void setWeight(int nWeight){
        this.weight = nWeight;
    }
    
    public int hashCode(){
        return (this.one.getName() + this.two.getName()).hashCode(); 
    } 
    
    public String toString(){
        return "\n{" + one.getName() + ", " + two.getName() + "}";
    }
}
