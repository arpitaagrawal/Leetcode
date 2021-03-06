import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfBoomerang {

	/**
	 * 
	 * 
	 * @param points
	 * @return
	 * 
	 * 
	 * 		tuple has 3 points : p1, p2, p3 distance between p1 and p2 == p2
	 *         and p3 when you find ditsance between p1 and p2, u have to find
	 *         one more p3 such that p2 and p3 have same distance we will have
	 *         to calculate distance of each point to each point at min It is as
	 *         if we are sorting number without lookin at the numbers we will
	 *         have to look at the distance before we can sya that these 3 do
	 *         not have same distances
	 * 
	 *         Lets say i do a n2 loop and calculate distance of each point with
	 *         each point except for itslef, and points already covered before.
	 * 
	 *         once i have distances lets say val =2 has 10 pairs attached to it
	 *         i have to find transitive pairs agains each key how?
	 * 
	 *         Eg: 10 : (P1, P2) (P3, P4) (P5, P6) (P7, P8) (P2, P3) (P1, P2) i
	 *         already know 1 pair, from the list i have to find as many combos
	 *         of P1 with some other point and P2 with some other point
	 * 
	 *         Possible Algorithm: Calculate the distance of each point with
	 *         each point in order n square and keep them in a map with key as
	 *         distance and value as list of pairs for each pair: check if we
	 *         have more pairs which have SP as EP of P1
	 * 
	 *         what if i create a map for each point: i.e distance of point x
	 *         from all other points: value will be list of points what if i
	 *         create interesting keys: i.e distance_SP: list will be (SP, y)
	 *         for curent distance. and then for each y i can look for
	 *         distance_y key and see points exists keep doing this?
	 * 
	 *         question taken from leetcode:
	 *         https://leetcode.com/problems/number-of-boomerangs/?tab=Description
	 * 
	 */
	public static int numberOfBoomerangs(int[][] points) {

		int numberOfBoomerangs = 0;
		Map<String, List<Integer>> distanceMap = createDistanceMap(points);
		for (String key : distanceMap.keySet()) {
			List<Integer> listOfIndices = distanceMap.get(key);
			int listSize = listOfIndices.size();
			if(listSize >1)	numberOfBoomerangs += listSize * (listSize -1);
		}
		return numberOfBoomerangs;
	}

	public static Map<String, List<Integer>> createDistanceMap(int[][] points) {
		Map<String, List<Integer>> distanceMap = new HashMap<String, List<Integer>>();
		int numOfRows = points.length;

		for (int i = 0; i < numOfRows - 1; i++) {
			for (int j = i + 1; j < numOfRows; j++) {
				int distance = 0;
				distance += Math.pow(points[i][0] - points[j][0], 2);
				distance += Math.pow(points[i][1] - points[j][1], 2);
				String key1 = i + "_" + distance;
				String key2 = j + "_" + distance;
				List<Integer> indiceList1 = (distanceMap.get(key1) == null) ? new ArrayList<Integer>() : distanceMap.get(key1);
				List<Integer> indiceList2 = (distanceMap.get(key2) == null) ? new ArrayList<Integer>() : distanceMap.get(key2);
				indiceList1.add(j);
				indiceList2.add(1);
				distanceMap.put(key1, indiceList1);;
				distanceMap.put(key2, indiceList2);
			}
		}
		return distanceMap;
	}

	public static void main(String[] args) {
		int[][] points = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 } };
		System.out.println(numberOfBoomerangs(points));
	}
}
