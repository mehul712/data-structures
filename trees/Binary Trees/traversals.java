import java.util.*;
class Traversals{
	
	static void insert(Node root, int x){
		
		Queue <Node> queue = new LinkedList<Node>();
		Node temp;
		queue.add(root);

		while(!queue.isEmpty()){
			temp = queue.poll();
			if (temp.left != null)
				queue.add(temp.left);
			else{
				temp.left = new Node(x);
				break;
			}
			if (temp.right != null)
				queue.add(temp.right);
			else{
				temp.right = new Node(x);
				break;
			}
		}
	}
	static void preOrder(Node root){
		if (root != null){
			System.out.print(root.val+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
		return;
	}

	static void postOrder(Node root){
		if (root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val+" ");
		}
		return;
	}

	static void inOrder(Node root){
		if (root != null){
			inOrder(root.left);
			System.out.print(root.val+" ");
			inOrder(root.right);
		}
		return;
	}

	static void levelOrder(Node root){
		Queue <Node> queue = new LinkedList<Node>();
		Node temp;
		queue.add(root);
		queue.add(null);
		int height = height(root);
		for(int i=0; i<height;i++) System.out.print(" ");
		height--;
		while(!queue.isEmpty()){
			temp = queue.poll();
			if (temp==null){
				if(!queue.isEmpty()){
					queue.add(null);
					System.out.println();
					for(int i=0; i<height;i++) System.out.print(" ");
					height--;
				}
			}
			else{
				
				System.out.print(temp.val+"  ");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
	}

	static int height(Node root){

		if (root==null)
			return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	public static void main(String []a){
		Node root=null;
		root = new Node(15);
		insert(root, 16);
		insert(root, 25);
		insert(root, 37);
		insert(root, 23);
		insert(root, 49);
		insert(root, 57);
		levelOrder(root);
		System.out.println("\n-----------------------------------");

		preOrder(root);

		System.out.println("\n-----------------------------------");

		postOrder(root);

		System.out.println("\n-----------------------------------");

		inOrder(root);
	}
}