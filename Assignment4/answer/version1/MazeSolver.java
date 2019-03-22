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


//reference website:https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-using-stack/

public class MazeSolver {




public static void setvisited(boolean b, boolean[][] array){
	 for (int i = 0; i < array.length; i++)  
        { 
            for (int j = 0; j < array[i].length; j++) 
            { 
                array[i][j] = b; 
            } 
        } 


   


}

public static void init_dir(int d, int[][] array){
	for (int i = 0; i < array.length; i++)  
        { 
            for (int j = 0; j < array[i].length; j++) 
            { 
                array[i][j] = d; 
            } 
        } 


     
}



    public static String findPath(Maze maze) {
    	


    	//m rows and n cols of the maze
    	int m = maze.getNumRows();
    	int n = maze.getNumCols();

    	//define a visited matrix
    	boolean[][] visited = new boolean[m][n];
    	setvisited(false, visited);

    	//define a direction matrix
    	int[][] dir_mtr = new int[m][n];
    	init_dir(-1,dir_mtr);



    	//define a stack
    	Stack<MazeLocation> s;
    	s = new StackRefBased<MazeLocation>();

    	MazeLocation entry = maze.getEntry();
    	MazeLocation exit = maze.getExit();
    	// System.out.println(entry.toString());
    	s.push(entry);

		MazeLocation temp;  
		String result = "";  	

		try{
			int x,y;


			while(!s.isEmpty()){

            		temp = s.peek();
            		x = temp.getRow();
            		y = temp.getCol();
            		dir_mtr[x][y]+=1;

            		if(temp.toString().equals(exit.toString())){
            			System.out.println("find the path");
            			break;

            		}

            		if(dir_mtr[x][y]==0){ 
            			//checking the up direction
            			if(x-1>=0 && !maze.isWall(x-1,y) && !visited[x-1][y]){
            				MazeLocation testnode = new MazeLocation(x-1,y,maze.isWall(x-1,y));
            				visited[x-1][y] = true;
            				s.push(testnode);

            			}

            		}else if(dir_mtr[x][y]==1){
            			//checking the left direction
            			if(y-1>=0 && !maze.isWall(x,y-1) && !visited[x][y-1]){
            				MazeLocation testnode = new MazeLocation(x,y-1,maze.isWall(x,y-1));
            				visited[x][y-1] = true;
            				s.push(testnode);

            			}

            		}else if(dir_mtr[x][y]==2){
            			//checking the down direction
            			if(x+1<m && !maze.isWall(x+1,y) && !visited[x+1][y]){
            				MazeLocation testnode = new MazeLocation(x+1,y,maze.isWall(x+1,y));
            				visited[x+1][y] = true;
            				s.push(testnode);

            			}
            			
            		}else if(dir_mtr[x][y]==3){
            			//checking the right direction
            			if(y+1<n && !maze.isWall(x,y+1) && !visited[x][y+1]){
            				MazeLocation testnode = new MazeLocation(x,y+1,maze.isWall(x,y+1));
            				visited[x][y+1] = true;
            				s.push(testnode);

            			}
            			
            		}else{
            			visited[x][y] = false;
            			s.pop();
            		}



    		
    	}

    	//reverse the stack
    	Stack<MazeLocation> reverse;
    	reverse = new StackRefBased<MazeLocation>();
    	while(!s.isEmpty()){
			   reverse.push(s.pop()); 	//push the node to the reverse stack
			   }


    	//if the stack is not empty, then we find the path
		if(!reverse.isEmpty()){
			result = reverse.toString();

		}

    	
    

		}
		catch (StackEmptyException see) {
            
        }


    	return result;


    }
}
