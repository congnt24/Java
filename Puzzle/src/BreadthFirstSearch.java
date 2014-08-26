import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirstSearch extends SubClass {
	Queue<Vertex> open=new LinkedList<Vertex>();
	public BreadthFirstSearch(int[] start, int[] goal,int post) {
		ArrayList<Integer> list1=new ArrayList<Integer>();
		open.add(new Vertex(post, list1, start, hueristic1(start, goal)));
		while (!open.isEmpty()) {
			Vertex vertex=open.remove();
			if (Arrays.equals(vertex.board, goal)) {
				printfBoard(vertex.board);
				System.out.println(vertex.path);
				System.out.println(vertex.path.size());
				return ;
			}
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(vertex.position, vertex, goal));
			for (Vertex ver : list) {
				if (find(ver, open)==null) {
					open.add(ver);
				}
			}

			printfBoard(vertex.board);
		}
		return;
	}
}
