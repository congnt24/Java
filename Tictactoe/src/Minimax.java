import java.util.ArrayList;
import java.util.Arrays;



public class Minimax extends SubClass {

	public Vertex minimax(Vertex start, int depth, int maxPlayer){
		if (depth==0) {
			Vertex ver=new Vertex(start.board, 0);
				ver.value=hueristic1(start.board, 1)-hueristic1(start.board, 2);
			return ver;
		}
		if (maxPlayer==1) {
			Vertex vertex=new Vertex(start.board,-99);
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(start, maxPlayer));
			for (Vertex is : list) {
				int val=minimax(is, depth-1, 2).value;
				if (vertex.value<val) {
					vertex.value=val;
					vertex.board=Arrays.copyOf(is.board, is.board.length);
					vertex.position=is.position;
				}
			}
			return vertex;
		}else{
			Vertex vertex=new Vertex(start.board,99);
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(start, maxPlayer));
			for (Vertex is : list) {
				int val=minimax(is, depth-1, 1).value;
				if (vertex.value>val) {
					vertex.value=val;
					vertex.board=Arrays.copyOf(is.board, is.board.length);
					vertex.position=is.position;
				}
			}
			return vertex;
		}
	}
	
/*	01 function alphabeta(node, depth, α, β, maximizingPlayer)
	02      if depth = 0 or node is a terminal node
	03          return the heuristic value of node
	04      if maximizingPlayer
	05          for each child of node
	06              α := max(α, alphabeta(child, depth - 1, α, β, FALSE))
	07              if β ≤ α
	08                  break (* β cut-off *)
	09          return α
	10      else
	11          for each child of node
	12              β := min(β, alphabeta(child, depth - 1, α, β, TRUE))
	13              if β ≤ α
	14                  break (* α cut-off *)
	15          return β

	(* Initial call *)
	alphabeta(origin, depth, -∞, +∞, TRUE)*/

	
	public Vertex alphabeta(Vertex start, int depth,int a,int b,int maxPlayer){
		if (depth==0) {
			Vertex ver=new Vertex(start.board, 0);
				ver.value=hueristic1(start.board, 1)-hueristic1(start.board, 2);
			return ver;
		}
		if (maxPlayer==1) {
			Vertex vertex=new Vertex(start.board,-99);
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(start, maxPlayer));
			for (Vertex is : list) {
				int val=alphabeta(is, depth-1, a, b, 2).value;
				if (a<val) {
					a=val;
					vertex.value=val;
					vertex.board=Arrays.copyOf(is.board, 9);
					vertex.position=is.position;
				}
				if (a>=b) {
					break;
				}
			}
			return vertex;
		}else{
			Vertex vertex=new Vertex(start.board,99);
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(start, maxPlayer));
			for (Vertex is : list) {
				int val=alphabeta(is, depth-1, a, b, 1).value;
				if (b>val) {
					b=val;
					vertex.value=val;
					vertex.board=Arrays.copyOf(is.board, 9);
					vertex.position=is.position;
				}
				if (a>=b) {
					break;
				}
			}
			return vertex;
		}
	}
	
	
	public int hueristic1(int[] board, int maxPlayer){		
		int player= maxPlayer==1?2:(maxPlayer==2)?1:0;
		int value=0;
		int count1=0, count2=0;
		for (int i = 0; i < 3; i++) {
			count1=0; count2=0;
			for (int j = 0; j < 3; j++) {
				if (board[i*3+j]==maxPlayer) {
					count1++;
				}else if(board[i*3+j]==player){
					count2++;
				}
			}
			if(count2==0){
				switch (count1) {
				case 1:
					value+=1;
					break;
				case 2:
					value+=9;
					break;
				case 3:
					value+=30;
					break;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			count1=0; count2=0;
			for (int j = 0; j < 3; j++) {
				if (board[i+3*j]==maxPlayer) {
					count1++;
				}else if(board[i+3*j]==player){
					count2++;
				}
			}
			if(count2==0){
				switch (count1) {
				case 1:
					value+=1;
					break;
				case 2:
					value+=9;
					break;
				case 3:
					value+=30;
					break;
				}
			}
		}

		{

			count1=0; count2=0;
			for (int i = 0; i < 3; i++) {
				if (board[i*3+i]==maxPlayer) {
					count1++;
				}else if(board[i*3+i]==player){
					count2++;
				}
			}
			if(count2==0){
				switch (count1) {
				case 1:
					value+=1;
					break;
				case 2:
					value+=9;
					break;
				case 3:
					value+=30;
					break;
				}
			}
		}
		{

			count1=0; count2=0;
			for (int i = 0; i < 3; i++) {
				if (board[i*2+2]==maxPlayer) {
					count1++;
				}else if(board[i*2+2]==player){
					count2++;
				}
			}
			if(count2==0){
				switch (count1) {
				case 1:
					value+=1;
					break;
				case 2:
					value+=9;
					break;
				case 3:
					value+=30;
					break;
				}
			}
		}
		return value;
	}
}
