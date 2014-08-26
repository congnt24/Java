	/* BEST FIRST SEARCH
	 * OPEN = [initial state]
		CLOSED = []
		while OPEN is not empty
		do
		 1. Remove the best node from OPEN, call it n, add it to CLOSED.
		 2. If n is the goal state, backtrace path to n (through recorded parents) and return path.
		 3. Create n's successors.
		 4. For each successor do:
		       a. If it is not in CLOSED and it is not in OPEN: evaluate it, add it to OPEN, and record its parent.
		       b. Otherwise, if this new path is better than previous one, change its recorded parent.
		          i.  If it is not in OPEN add it to OPEN.
		          ii. Otherwise, adjust its priority in OPEN using this new evaluation.
		done
	 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class BestFirstSearch extends SubClass{
	public PriorityQueue<Vertex> open=new PriorityQueue<Vertex>(10, new Comparator<Vertex>() {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			// TODO Auto-generated method stub
			return o1.hueristic==o2.hueristic?0:o1.hueristic>o2.hueristic?1:-1;
		}
	});
	public PriorityQueue<Vertex> close = new PriorityQueue<Vertex>(10, new Comparator<Vertex>() {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			// TODO Auto-generated method stub
			return o1.hueristic==o2.hueristic?0:o1.hueristic>o2.hueristic?1:-1;
		}
	});
	
	public void bestFirstSearch(int[] start, int[] goal, int post) {
		ArrayList<Integer> list1=new ArrayList<Integer>();
		open.add(new Vertex(post,list1,start,hueristic1(start, goal)));
		while (!open.isEmpty()) {
			Vertex vertex=open.remove();
			if (Arrays.equals(goal, vertex.board)) {
				printfBoard(vertex.board);
				System.out.println(vertex.path);
				System.out.println(vertex.path.size());
				return ;
			}
			int p=vertex.position;
			//Create n's successors
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(p, vertex, goal));
			
			for (Vertex ver : list) {
				Vertex v1=find(ver, open), v2=find(ver, close);
				
				if(v1==null & v2==null){//evaluate it, add it to OPEN, and record its parent.
					open.add(ver);
				}else
				if(v2!=null & v1==null){
					if (v2.path.size()>ver.path.size()) {
						close.remove(v2);
						open.add(ver);
					}
				}else
				if(v2==null & v1!=null){
					if (v1.path.size()>ver.path.size()) {
						open.remove(v1);
						open.add(ver);
					}
				}
			}
			printfBoard(vertex.board);
			close.add(vertex);
		}
		return ;
	}

}
