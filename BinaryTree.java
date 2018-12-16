import java.util.List;
import java.util.Scanner;

public class BinaryTree {

	Node root;

	public void updateTree(int key) {

	}

	public void addNode(int key, String rawEvent) {

		Node newNode = new Node(key, rawEvent);
		newNode.ID = rawEvent;

		if (root == null) {

			root = newNode;
		} else {
			Node currentNode = root;

			Node parent;

			while (true) {

				parent = currentNode;

				if (key < currentNode.key) {
					// Build Left Node

					currentNode = currentNode.left;
					// String ParentID = currentNode.ParentID;

					if (currentNode == null) {
						parent.left = newNode;
						return;
					}

				} else {

					currentNode = currentNode.right;

					if (currentNode == null) {

						parent.right = newNode;
						return;
					}

				}

			}
		}
	}

	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	int height(Node root) {
		if (root == null)
			return 0;
		else {

			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	void printGivenLevel(Node root, int level) {
		if (root == null)
		{
			return;
		}
		if (level == 1)
  		{
            		System.out.print("Raw event: " + " " + root.rawEvent + "\n");
            		System.out.print("ID: "+ root.ID + "\n");
            		System.out.print("Parent ID: " + root.ParentID + "\n");
        	}
            
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public void askForRawEvent() {

		int[] perfectTree = new int[] { 100, 050, 200, 025, 075, 150, 250, 010, 030, 60, 80, 125, 175, 225, 275, 4, 15,
				27, 35, 55, 65, 77, 85, 120, 130, 170, 180, 220, 230, 270, 280 };
		String eventName;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 6; i++) {

			System.out.println("Enter a raw event");
			eventName = sc.nextLine();

			if (eventName.equals("exit")) {

				return;

			} else {

				addNode(perfectTree[i], eventName);

			}
		}
	}
}

class Node {
	int key;
	String ID;
	String ParentID;
	String rawEvent;
	String lHash;
	String rHash;
	String rHist;
	String lHist;

	Node left;
	Node right;

	Node(int key, String rawEvent) {

		this.rawEvent = rawEvent;
		this.key = key;
		this.ID = makeID(rawEvent, key);

	}

	private String hash(String rawEvent, int key) { // Take's two strings a rawEvent and a key, key is useful in
														// reverse lookup for parent
		String hash = rawEvent.toLowerCase().replace('g', 'b').replace('y', 'p').replace('n', 's');
		try {
			hash = hash.substring(0, 3);
		} catch (Exception a) {
		}
		; // Makes it 4 or less than 4 in fail case
		while (hash.length() < 4) { // Makes it exactly 4 by adding w's
			hash = hash.concat("w");
		}
		hash = hash.concat(String.valueOf(key));
		return hash;
	}

	private int getParentKey(int key) {
		int[] perfectTree = new int[] { 100, 050, 200, 025, 075, 150, 250, 010, 030, 60, 80, 125, 175, 225, 275, 4, 15,
				27, 35, 55, 65, 77, 85, 120, 130, 170, 180, 220, 230, 270, 280 };
		if (key == 5000) {
			key = (int) Math.random();
		} else {
			for (int i : perfectTree) {
				if (perfectTree[i] == key) {
					key = perfectTree[i - 1];
					break;
				}
			}
		}
		return key;
	}

	private String makeID(String rawEvent, int key) {
		key = getParentKey(key); //key now has the parent's key which we can use to get the parents id
		String myID = hash(rawEvent,key);		
		return myID;
	}
}
