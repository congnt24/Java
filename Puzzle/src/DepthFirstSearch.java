import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class DepthFirstSearch extends SubClass{

	public DepthFirstSearch(int[] start, int[] goal, int post) {
		Stack<Vertex> open=new Stack<Vertex>();
		open.push(new Vertex(post, new ArrayList<Integer>(), start, hueristic1(start, goal)));
		while (!open.isEmpty()) {
			Vertex vertex=open.pop();
			if (Arrays.equals(vertex.board, goal)) {
				printfBoard(vertex.board);
				System.out.println(vertex.path);
				System.out.println(vertex.path.size());
				return;
			}
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(vertex.position, vertex, goal));
			for (Vertex ver : list) {
				if (find(ver, open)==null) {
					open.push(ver);
				}
			}
			printfBoard(vertex.board);
		}
		return ;
	}
	
}
