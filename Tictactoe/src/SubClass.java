import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;


public class SubClass {

	JButton[] button=new JButton[9];
	public ArrayList<Vertex> setListMove(Vertex start, int maxPlayer){
		ArrayList<Vertex> list=new ArrayList<Vertex>();
		for (int i = 0; i < start.board.length; i++) {
			if (start.board[i]==0) {
				Vertex temp = new Vertex(new int[9], 0);
				temp.position=i;
				temp.board=Arrays.copyOf(start.board, start.board.length);
				temp.board[i]=maxPlayer;
				list.add(temp);
			}
		}
		return list;
	}
	public int checkWin(Vertex vertex){
		int win=0;
		for (int i = 0; i < 3; i++) {
			if (vertex.board[i*3]==vertex.board[i*3+1] & vertex.board[i*3]==vertex.board[i*3+2]) {
				if (vertex.board[i*3]==1) {
					win=1;
				}
				if (vertex.board[i*3]==2) {
					win=2;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (vertex.board[i]==vertex.board[i+3] & vertex.board[i]==vertex.board[i+6]) {
				if (vertex.board[i]==1) {
					win=1;
				}
				if (vertex.board[i]==2) {
					win=2;
				}
			}
		}
		if (vertex.board[0]==vertex.board[4] & vertex.board[0]==vertex.board[8]) {
			if (vertex.board[0]==1) {
				win=1;
			}
			if (vertex.board[0]==2) {
				win=2;
			}
		}
		if (vertex.board[2]==vertex.board[4] & vertex.board[2]==vertex.board[6]) {
			if (vertex.board[2]==1) {
				win=1;
			}
			if (vertex.board[2]==2) {
				win=2;
			}
		}
		if (win!=0) {
			for (int i = 0; i < 9; i++) {
				if (vertex.board[i]==0) {
					button[i].setEnabled(false);
				}
			}
		}
		return win;
	}
	public void printf(int[] board){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i*3+j]+" ");
			}
			System.out.println();
		}
	}
	public void printf(Vertex board){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board.board[i*3+j]+" ");
			}
			System.out.println();
		}
	}
}
