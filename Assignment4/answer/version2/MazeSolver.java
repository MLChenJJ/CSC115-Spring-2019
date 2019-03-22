/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

public class MazeSolver {
    public static String findPath(Maze maze) {
        int m = maze.getNumRows();
		int n = maze.getNumCols();
		
		//define a matrix to record access history
		boolean[][]visited = new boolean[m][n];
		//initialize this matrix
		for (int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				visited[i][j]=false;
			}
		}
		 int[][] direction_matrix = new int[m][n];
		 for(int i = 0;i<m;i++){
			 for(int j = 0;j<n;j++){
			 direction_matrix[i][j]=0;}
		 }
		 Stack<MazeLocation>s = new StackRefBased<MazeLocation>();
		 
		 MazeLocation entry = maze.getEntry();
		 MazeLocation exit=maze.getExit();
		 
		 s.push(entry);
		 
		 String result="";

		 String[] directions = {"up","down","left","right",};
		 
		 MazeLocation temp;
		 try{
			int x=0;
			int y=0;
			
			while(!s.isEmpty()){
				temp=s.peek();
				x=temp.getRow();
				y=temp.getCol();
				direction_matrix[x][y]+=1;//start from 0
			
			if(temp.toString().equals(exit.toString())){//the top node is the exit
				break;	
			}
			
			//decide which node to check
			String check_node = "None";
			if(direction_matrix[x][y]>=1 && direction_matrix[x][y]<=4){
				check_node = directions[direction_matrix[x][y]-1];
			}
			
			
			if(check_node.equals("up")){
				// checking up node
				if(x-1>=0 && !maze.isWall(x-1,y)&& !visited[x-1][y]){
					MazeLocation node = new MazeLocation(x-1,y,maze.isWall(x-1,y));
					visited[x-1][y]=true;
					s.push(node);
				}
			}
			else if(check_node.equals("down")){
			// checking down node
			if(x+1<m && !maze.isWall(x+1,y)&& !visited[x+1][y]){
				MazeLocation node = new MazeLocation(x+1,y,maze.isWall(x+1,y));
				visited[x+1][y]=true;
				s.push(node);}
			}
				
			else if(check_node.equals("left")){
			// checking left node
			if(y-1>0 && !maze.isWall(x,y-1)&& !visited[x][y-1]){
				MazeLocation node = new MazeLocation(x,y-1,maze.isWall(x,y-1));
				visited[x][y-1]=true;
				s.push(node);}
			}
			
			else if(check_node.equals("right")){
			// checking right node
			if(y+1<n && !maze.isWall(x,y+1)&& !visited[x][y+1]){
				MazeLocation node = new MazeLocation(x,y+1,maze.isWall(x,y+1));
				visited[x][y+1]=true;
				s.push(node);
				}
			}
			else{
				//release this node
				visited[x][y]=false;
				s.pop();
			}
			}
		 
			Stack<MazeLocation>reverse;
			reverse=new StackRefBased<MazeLocation>();
			while(!s.isEmpty()){
				reverse.push(s.pop());
			}
			
			if(!reverse.isEmpty()){
				while(reverse.size()>1){
					result+=reverse.pop()+" ";
				}
				result+=reverse.pop();
				return result;
			}
			else{
				return "";
			}

		 }catch(StackEmptyException e){
		 	System.out.println(e.toString());
			
		}
        return "";
    }
}

