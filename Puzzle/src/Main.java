import java.util.ArrayList;

/*
 * Puzzle
 * mang3 3*3 gồm 9 phần ô với 8 phần tử
 * Start: 1 mảng với 8 số bất kỳ đặt vào 8 vị trí trên mảng
 * Goal: 1 vị trí nào đó dã được xác đình trước.
 * Luật
 * Di chuyển từng quân cạnh ô trống vào ô trống đó
 * Mỗi ô có tối đa 4 khả năng.
 * Algorithms
 * 
 * Tìm kiếm theo chiều rộng (BFS)
 * Tìm kiếm theo chiều sâu (DFS)
 * Tìm kiếmvới chi phí cực tiểu (UCS) Tìm kiếm với chi phí cực tiểu (UCS)
 * Tìm kiếm giới hạn độsâu (DLS)
 * Tìm kiếm sâu dần (IDS)
 * 
 * Hàm đánh giá: F(n)=G(n)+H(n)
 * G(n) Tổn thất thực từ Start đến n
 * H(n)..Hueristic.. Tổn thất ước lượng từ n đến Goal
 * Hueristic 1:	Tổng số quân còn sai vị trí
 * Hueristic 2: Tổng đường đi để hoán đổi các quân đến các vị trí đúng.   
 */
public class Main extends SubClass{

	int[] start=new int[9];
	int[] goal = new int[9];
	public static void main(String[] args) {
		Main main=new Main();
		main.initialize();
	}

	private void initialize() {
		for (int i = 0; i < 8; i++) {// Khởi tạo giá trị đầu cuối
			start[i]=i+1;
			goal[i]=i+1;
		}
		goal[8]=6;
		goal[5]=5;
		goal[4]=0;
//		BestFirstSearch bestFS=new BestFirstSearch();
//		bestFS.bestFirstSearch(start,goal, 8);
//		new BreadthFirstSearch(start, goal, 8);
//		new DepthFirstSearch(start, goal, 8);
//		new UniformCostSearch(start, goal, 8);
//		System.out.println(new DepthLimitedSearch().depthLimitedSearch(new Vertex(8, new ArrayList<Integer>(), start, hueristic1(start, goal)), goal, 8, 3));
		new IterativeDepthSearch(new Vertex(8, new ArrayList<Integer>(), start, hueristic1(start, goal)), goal, 8);
	}
	
	
	

}
