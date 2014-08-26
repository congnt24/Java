import java.util.ArrayList;


public class Vertex {
	int position;
	ArrayList<Integer> path;
	int[] board;
	int hueristic;
	int Fn;
	public Vertex(int position, ArrayList<Integer> path, int[] board,
			int hueristic) {
		super();
		this.position = position;
//		this.path = path; //Ko dc
		this.path=new ArrayList<Integer>(path);
		this.board = board;
		this.hueristic = hueristic;
		this.path.add(position);
		Fn=hueristic+path.size();
	}
	
}
