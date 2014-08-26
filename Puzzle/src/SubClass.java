import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class SubClass {
	
	public ArrayList<Vertex> setListMove(int p, Vertex vertex, int[] goal){
		ArrayList<Vertex> list=new ArrayList<>();
		if(0<=(p-3)){
			int tmp[]=swap(vertex.board, p, p-3);
			list.add(new Vertex(p-3, vertex.path, tmp, hueristic1(tmp, goal)));
		}
		if(p!=0 & p!=3 &p!=6){	// Sang trai
			int tmp[]=swap(vertex.board, p, p-1);
			list.add(new Vertex(p-1, vertex.path, tmp, hueristic1(tmp, goal)));
		}
		if(p!=2 & p!=5 &p!=8){
			int tmp[]=swap(vertex.board, p, p+1);
			list.add(new Vertex(p+1, vertex.path, tmp, hueristic1(tmp, goal)));
		}
		if((p+3)<9){
			int tmp[]=swap(vertex.board, p, p+3);
			list.add(new Vertex(p+3, vertex.path, tmp, hueristic1(tmp, goal)));
		}
		return list;
	}
	public void printfBoard(int[] board) {
		for (int i = 0; i < 3; i++) {
			System.out.println(board[i*3]+" "+board[i*3+1]+" "+board[i*3+2]);
		}
		System.out.println("");
	}

	public Vertex find(Vertex vt1, PriorityQueue<Vertex> open2) {
		for (Vertex vert : open2) {
			if(Arrays.equals(vt1.board, vert.board)){
				return vert;
			}
		}
		return null;
	}
	public Vertex find(Vertex vt1, Stack<Vertex> open2) {
		for (Vertex vert : open2) {
			if(Arrays.equals(vt1.board, vert.board)){
				return vert;
			}
		}
		return null;
	}
	public Vertex find(Vertex vt1, Queue<Vertex> open2) {
		for (Vertex vert : open2) {
			if(Arrays.equals(vt1.board, vert.board)){
				return vert;
			}
		}
		return null;
	}
	public int[] swap(int[] start2, int x, int y) {
		int[] start1=new int[9];
		start1=Arrays.copyOf(start2, 9);
		int t=start1[x];
		start1[x]=start1[y];
		start1[y]=t;
		return start1;
	}
	
	public int hueristic1(int[] matrix, int[] goal){
		int k=0;
		for (int i = 0; i < 9; i++) {
			if(goal[i]==0)continue;
			else if(goal[i]!=matrix[i]){
				k++;
			}
		}
		return k;
	}
}
