import java.util.*;

class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		public void printInOrder(int depth) {
			if (this.left  != null) this.left.printInOrder (depth + 1);	
			for (int i = 0; i < depth; i++) System.out.print("    ");
			System.out.println(this.val);
			if (this.right != null) this.right.printInOrder(depth + 1);	
		}
	}
    public List<List<Integer>> levelOrder(TreeNode root) {
		final List<List<Integer>> a = new ArrayList<List<Integer>>();
		if(root == null) return a;
		final int depth = findDepth(root);
		for (int i = 0; i <= depth; i++) a.add(null);
		traverse(root,a,0);
		return a;
	}
	public void traverse(TreeNode root, List<List<Integer>> a,int depth){
		if (root.left != null) {
			// System.out.println("LEFT-- depth:" + depth + " -- node: " + root.val);
			traverse(root.left,a, depth + 1);	
		}
		if (root.right != null) {
			// System.out.println("RIGHT-- depth:" + depth + "-- node: " + root.val);
			traverse(root.right,a, depth + 1);	
		}
		List<Integer> b = a.get(depth);															// if cell a contains null ->  b == null
		if (b == null) {
			b = new ArrayList<Integer>();
			// System.out.println("size of a: " + a.size());
			a.set(depth,b);																		// sets an ArrayList to our depth Array
		}
		// System.out.println("Adding-- depth:" + depth + "-- node: " + root.val);
		b.add(root.val);																		// adds values to our List<Integer> *yellow*
	}
	public int findDepth(TreeNode root){
		if (root.left != null && root.right != null) {
			return Math.max(findDepth(root.left) + 1, findDepth(root.right) + 1);
		}
		if (root.left  != null) return findDepth(root.left)  + 1;	
		if (root.right != null) return findDepth(root.right) + 1;
		return 0;
	}
	public void print(List<List<Integer>> a){
		for (List<Integer> b : a) {
			// System.out.println("print our b: " + b);
			if (b == null) break;
			System.out.print('[');
			for (Integer i : b) System.out.print(i + ", ");
			System.out.println(']');
		}
	}
	public TreeNode makeTree4(){
		TreeNode r  = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode r2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode r3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode r4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode r5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode r6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		TreeNode r7 = new TreeNode(7);
		TreeNode l8 = new TreeNode(8);
		TreeNode r8 = new TreeNode(8);

		r.left  = l2;
		r.right = r2;

		l2.left  = l3;
		l2.right = l4;
		l3.left  = l5;
		l3.right = l6;
		l4.left  = l7;
		l4.right = l8;

		r2.right = r3;
		r2.left  = r4;
		r3.left  = r6;
		r3.right = r5;
		r4.left  = r8;
		r4.right = r7;
	
		return r;
	}
	public void test4() {
		TreeNode root = makeTree4();
		root.printInOrder(0);
		System.out.println("Depth: " + findDepth(root));
		List<List<Integer>> a = levelOrder(root);
		print(a);

	}
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test4();
	}
}