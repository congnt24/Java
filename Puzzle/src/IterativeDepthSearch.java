
public class IterativeDepthSearch {

	public IterativeDepthSearch(Vertex start, int[] goal, int post) {
		for (int i = 1; i < 4; i++) {
			if(new DepthLimitedSearch().depthLimitedSearch(start, goal, start.position, i))break;
		}
	}
	
}
