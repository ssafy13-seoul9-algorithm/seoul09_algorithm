import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class w6_5397_이종환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i < tc; i++) {
			Node curNode = new Node("",null,null);
			String[] input = br.readLine().split("");
			for (int j = 0; j < input.length;j++) {
				if (input[j].equals("<")) {
					curNode = curNode.moveLeft();
				} else if (input[j].equals(">")) {
					curNode = curNode.moveRight();
				} else if (input[j].equals("-")) {
					curNode = curNode.remove();
				} else {
					curNode = curNode.add(input[j]);
				}
			}
			
			
			while (curNode.previousNode != null) {
				curNode = curNode.moveLeft();
				
			}
			
			while (curNode.nextNode != null) {
				bw.append(curNode.value);
				curNode = curNode.moveRight();
			}
			
			bw.append("\n");
			
		}
		

		bw.flush();
		
		
		
	}
}
class Node{
	// a|bcd
	// -> |기준 노드의 value는 b; pre는 a , next는 c;
	String value;
	Node nextNode;
	Node previousNode;
	
	public Node(String value, Node nextNode, Node previousNode) {
		this.value = value;
		this.nextNode = nextNode;
		this.previousNode = previousNode;
	}
	
	public Node add (String value){
		Node node = new Node(value, this,null);
		if (previousNode != null) {
			node = new Node(value, this, previousNode);
			previousNode.nextNode = node;
		} else {
			node = new Node (value, this, null);
		}
		previousNode = node;
		return this;	
	}
	
	public Node remove () {
		if (previousNode == null) {
			return this;
		}

		previousNode.nextNode = null;
		Node newpreviousNode = previousNode.previousNode;
		previousNode.previousNode = null;
		previousNode = newpreviousNode;
		
		if (previousNode != null) {
			previousNode.nextNode = this;
		}
		return this;
	}
	
	public Node moveLeft() {
		if (previousNode == null) {
			return this;
		}
		return previousNode;
	}
	
	public Node moveRight() {
		if (nextNode == null) {
			return this;
		}
		return nextNode;
	}
}