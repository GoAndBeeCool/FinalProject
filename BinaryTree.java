import java.util.Scanner;

public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String rawEvent) {
		
		Node newNode = new Node(key, rawEvent);
		newNode.ID = rawEvent;
		
		if(root == null) {
			
			root = newNode;
			
		}
		else {
			Node currentNode = root;
			
			Node parent;
			
			while (true) {
				
				parent  = currentNode;
				
				if(key < currentNode.key) {
					
					
					currentNode = currentNode.left;
					//String ParentID = currentNode.ParentID;
					
					if(currentNode == null) {
						parent.left = newNode;
						return;
					}
					
				} 
				else {
					
					currentNode = currentNode.right;
					
					if(currentNode == null) {
						
						parent.right = newNode;
						return;
					}
					
				}

			}			
		}
	}
	
	
    void printLevelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
  

    int height(Node root) { 
        if (root == null) 
           return 0; 
        else{ 

            int lheight = height(root.left); 
            int rheight = height(root.right); 
              

            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    }
    void printGivenLevel (Node root ,int level) { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print("Raw event: " + " " + root.rawEvent + " " + "ID: " + " " + root.ID + " " + "Parent ID: " + " " + root.ParentID + " "); 
        else if (level > 1) { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
	

	
	
	
	
	public void askForRawEvent() {
		
		int[] perfectTree = new int[] {100,50,200,25,75,150,250,10,30,60,80,125,175,225,275,4,15,27,35,55,65,77,85,120,130,170,180,220,230,270,280};
		String eventName;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0;i < 6;i++) {

			
			System.out.println("Enter a raw event");
			eventName = sc.nextLine();
			
			if(eventName.equals("exit")) {
				
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
		
	}
	
}
