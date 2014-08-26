import java.util.ArrayList;
import java.util.Arrays;


public class DepthLimitedSearch extends SubClass{
	boolean save=false;
	public boolean depthLimitedSearch(Vertex start, int[] goal, int post, int depth) {
//		Vertex vertex=new Vertex(post, new ArrayList<Integer>(), start, hueristic1(start, goal));
		if (depth>=0) {
			if (Arrays.equals(start.board, goal)) {
				printfBoard(start.board);
				System.out.println(start.path);
				System.out.println(start.path.size());
				save=true;
				return true;
			}
			ArrayList<Vertex> list=new ArrayList<Vertex>(setListMove(post, start, goal));
			for (Vertex ver : list) {
				depthLimitedSearch(ver, goal, ver.position, depth-1);
			}
		}

		return save;
	}
	
}
