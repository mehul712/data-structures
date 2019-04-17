//import Users.mehsethi.data-structures.trees.basic.Node;
import java.util.*;
class Operations{

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

	static int max_val(Node root){
		if (root==null)
			return Integer.MIN_VALUE;
		int lmax = max_val(root.left);
		int rmax = max_val(root.right);
		int max = Integer.MIN_VALUE;
		if (lmax > rmax )
			max = lmax;
		else max = rmax;
		if (max > root.val)
			return max;
		return root.val;

	}

	static Node lca(Node root, int alpha, int beta){

		if (root.val == null)
			return root;
		if (root.val == alpha || root.val == beta){
			return root;
		}

		Node l_lca = lca(root.left);
		Node r_lca = lca(root.right);
		if(l_lca!=null && r_lca!=null)
			return root;

		if(l_lca==null || r_lca == null)
			return null;

		return (l_lca)? (l_lca):(r_lca);
	}

	static Node width(Node root){
		return new Node(-1);
	}

	static Node diameter(Node root){
		return new Node(-1);
	}

	public static void main(String []a){

		Node root = new Node(15);
		insert(root, 12);
		insert(root, 45);
		insert(root, 32);
		insert(root, 67);

		levelOrder(root);
		System.out.println("\n" + max_val(root));
	}
}
