public class BinaryTree{
	BinaryTreeNode root;
	int count;

	public BinaryTree(){
		this.root = null;
		this.count = 0;
	}


	//function returns the height of this tree
	public int height(BinaryTreeNode node)
	{
		if(node==null)
		{
			return 0;
		}
		int lefheight=height(node.left);
		int righeight=height(node.right);
		if(lefheight>righeight)
		{
			return 1+lefheight;
		}
		else{
			return 1+righeight;
		}
		
	}


	/*
	full binary tree 的定义：
				A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes
				Conversely, there is no node in a full binary tree, which has one child node
	*/
	
	 /* this function checks if a binary tree is full or not */
   public boolean isFullTree(BinaryTreeNode node) 
    { 
        // if empty tree 
        if(node == null) 
        return true; 
           
        // if leaf node 
        if(node.left == null && node.right == null ) 
            return true; 
           
        // if both left and right subtrees are not null 
        // the are full 
        if((node.left!=null) && (node.right!=null)) 
            return (isFullTree(node.left) && isFullTree(node.right)); 
           
        // if none work 
        return false; 
    } 



	public  int findMax(BinaryTreeNode node) 
		    { 
		        if (node == null) 
		            return Integer.MIN_VALUE; 
		  
		        int max_value = node.data; 
		        int l_max_value = findMax(node.left); // the biggest value of left sub-tree
		        int r_max_value= findMax(node.right); // the biggest value of right sub-tree
		  
		        if (l_max_value > max_value) 
		            max_value = l_max_value; 
		        if (r_max_value > max_value) 
		            max_value = r_max_value; 
		        return max_value; 
		    } 

	/* Function to return the sum  of all the nodes in binary tree*/
		public int sumTree(BinaryTreeNode node)  
		{  
		    if (node == null)  
		        return 0;  
		    return (node.data + sumTree(node.left) +  sumTree(node.right));  
		}  


	public void PreOrder(BinaryTreeNode  node){
		if(node == null){
			return;
		}
		System.out.print(node.data+" ");
		PreOrder(node.left);
		PreOrder(node.right);
	}

	public void PostOrder(BinaryTreeNode  node){
		if(node == null){
			return;
		}
		
		PreOrder(node.left);
		PreOrder(node.right);
		System.out.print(node.data+" ");
	}


	public void InOrder(BinaryTreeNode  node){
		if(node == null){
			return;
		}
		
		PreOrder(node.left);
		System.out.print(node.data+" ");
		PreOrder(node.right);
	}


//level order traversal of a binary tree

public void printLevelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 


    } 

    /* Print nodes at the given level */
    void printGivenLevel (BinaryTreeNode node ,int level) 
    { 
        if (node == null) 
            return; 
        if (level == 1) 
            System.out.print(node.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(node.left, level-1); 
            printGivenLevel(node.right, level-1); 
        } 
    } 






	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		BinaryTreeNode node = new BinaryTreeNode(3);
		tree.root = node;
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(4);

		tree.root.left.left = new BinaryTreeNode(7);
		tree.root.left.right = new BinaryTreeNode(0);

		tree.root.right.left = new BinaryTreeNode(12);
		tree.root.right.right = new BinaryTreeNode(1);



		//test return the height of this tree
		int tree_height = tree.height(tree.root);
		System.out.println("the height of this binary tree:  "+tree_height);

		boolean full_tree = tree.isFullTree(tree.root);
		System.out.println("Test the binary tree is full tree or not:  "+full_tree);


		int max_data  = tree.findMax(tree.root);
		System.out.println("The biggest value in the binary tree:  "+max_data);


		int sum_nodes  = tree.sumTree(tree.root);
		System.out.println("The sum of binary tree:  "+sum_nodes);

		System.out.print("preorder traversal of binary tree:  ");
		tree.PreOrder(tree.root);
		System.out.println(); 

		System.out.print("postorder traversal of binary tree:  ");
		tree.PostOrder(tree.root);
		System.out.println(); 


		System.out.print("inorder traversal of binary tree:  ");
		tree.InOrder(tree.root);
		System.out.println(); 


		System.out.print("level order traversal of binary tree:  ");
		tree.printLevelOrder();
		System.out.println(); 

		
	}



}