import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class w6_1406_이종환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split("");
		
		Node end = new Node ("",null,null);
		Node cur = end;
		
		for (int i = 0; i < input.length; i++) {
			cur.add(input[i]);
		}
		
		int orderCnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < orderCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			if (order.equals("L")) {
				cur = cur.moveLeft();
			} else if (order.equals("D")) {
				cur = cur.moveRight();
			} else if (order.equals("B")) {
				cur.remove();
			} else {
				String target = st.nextToken();
				cur.add(target);
			}
		}
		
		
		while (cur.previousNode != null) {
			cur = cur.moveLeft();
		}
		
		while (cur.nextNode != null) {
			bw.append(cur.value);
			cur = cur.moveRight();
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
		Node node;
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
		previousNode = previousNode.previousNode;
		
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