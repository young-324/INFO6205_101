package SnowWhitePrince.FinalProject;

public class Next {

	public void gameOfLife(int[][] board) {
        // <2 die
        //==2||==3 live
        //>3 die
        //die->live 3 live neighbor
        board=nextGenration(board);        
    }
    
    public int[][] nextGenration(int[][] board){
        
        
       
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count=0;
                if(i-1>=0&& j-1>=0 && (board[i-1][j-1]==1||board[i-1][j-1]==-1))count++;
                if(i-1>=0 && (board[i-1][j]==1||board[i-1][j]==-1))count++;
                if(i-1>=0 && j+1<board[0].length &&(board[i-1][j+1]==1||board[i-1][j+1]==-1))count++;
                if(j-1>=0 &&(board[i][j-1]==1 ||board[i][j-1]==-1)) count++;
                if(j+1<board[0].length&& (board[i][j+1]==1||board[i][j+1]==-1)) count++;
                if(i+1<board.length&&j-1>=0&&(board[i+1][j-1]==1||board[i+1][j-1]==-1))count++;
                if(i+1<board.length&&(board[i+1][j]==1||board[i+1][j]==-1))count++;
                if(i+1<board.length&& j+1<board[0].length&&(board[i+1][j+1]==1||board[i+1][j+1]==-1))count++;
                
                if(count<2 ) {
                	if(board[i][j]==1) {
                		board[i][j]=-1;
                	}
                }
                else if((count==2|| count==3)&& board[i][j]==1) {
                	board[i][j]=1;
                }
                else if(count>3) {
                	if(board[i][j]==1) {
                		board[i][j]=-1;
                	}
                }
                else if(count==3 && board[i][j]==0) {
                	board[i][j]=2;
                }

            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            	if(board[i][j]==-1)board[i][j]=0;
            	if(board[i][j]==2)board[i][j]=1;
            }
         }
        System.out.println(board);
        return board;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
