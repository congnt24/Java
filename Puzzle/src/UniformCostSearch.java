import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class UniformCostSearch extends SubClass {

	public UniformCostSearch(int[] start, int[] goal, int post) {
		PriorityQueue<Vertex> open=new PriorityQueue<Vertex>(20, new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				int v1=o1.path.size(), v2=o2.path.size();
				return v1==v2?0:v1>v2?1:-1;
			}
		});
		Queue<Vertex> close=new LinkedList<Vertex>();
		open.add(new Vertex(post, new ArrayList<Integer>(), start, hueristic1(start, goal)));
		while (!open.isEmpty()) {
			 Vertex vertex=open.remove();
			 if (Arrays.equals(goal, vertex.board)) {
					printfBoard(vertex.board);
					System.out.println(vertex.path);
					System.out.println(vertex.path.size());
					return ;
				}
			 ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(vertex.position, vertex, goal));
			 for (Vertex ver : list) {
				Vertex v1=find(ver, open);
				Vertex v2 = find(ver, close);
				if (v1==null & v2==null) {
					open.add(ver);
				}else if(v1==null & v2!=null){// Ton tai trong close
					if (v2.path.size()>ver.path.size()) {
						open.add(v2);
						close.remove(ver);
					}
				}else if (v1!=null & v2==null) {// Ton tai trong Open
					if (v1.path.size()>ver.path.size()) {
						open.remove(v1);
						open.add(ver);
					}
				}
			}
			 close.add(vertex);
			printfBoard(vertex.board); 
		}
	}
	
}
