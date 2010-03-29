import java.util.ArrayList;

/**
 * Tool class
 * @author Lucia Blondel
 */

public class Tool {

	/**
	 * compute the cost of a given path
	 * @param path
	 * @param distanceMatrix
	 * @return
	 */
	public int computeCost(int[] path, int[][] distanceMatrix) {
		int cost = 0;
		for(int i = 1; i < path.length; i++) {
			cost += distanceMatrix[path[i-1]][path[i]];
		}
		cost += distanceMatrix[path[path.length - 1]] [path[0]];
		return cost;
	}

	/**
	 * @param path
	 * @param srcIndex
	 * @return destination city of an edge given the source index
	 */
	public int getDestination(int[] path, int srcIndex) {
		if(srcIndex + 1 == path.length) {
			return path[0];
		}
		return path[srcIndex + 1];
	}
	
	/**
	 * @param path
	 * @param srcIndex
	 * @return destination index of an edge given the source index
	 */
	public int getIndexOfDestination(int[] path, int srcIndex) {
		if(srcIndex + 1 == path.length) {
			return 0;
		}
		return srcIndex + 1;
	}
	
	
	/**
	 * Check if the city is in the path
	 * @param city
	 * @return true: if the city is already in the path, false otherwise
	 */
	public boolean isCityInPath(int[] path, int city) {
		for(int i = 0; i < path.length; i++) {
			if(path[i] == city) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param path1
	 * @param path2
	 * @return true if path1 == path2; false otherwise
	 */
	public boolean pathEquals(int[] path1, int[] path2) {
		
		for(int i = 0; i<path1.length; i++) {
			if(path1[i] != path2[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param path
	 * @param cities
	 * @return true if every city in cities is in the path (therefore in the path there is not a city
	 * twice)
	 */
	public boolean isFeasible(int[] path, ArrayList<String> cities) {
		int i = 0;
		int[] nameOfCities = new int[path.length];
		
		for(String c: cities) {
			String[] tokens = c.split(" ");
			nameOfCities[i] = Integer.parseInt(tokens[0]) - 1;
			i++;
		}
		
		for(Integer name: nameOfCities) {
			if(isCityInPath(path, name) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public double[] findMaxXAndY(DistanceMatrix distanceMatrix) {
		double[] X = distanceMatrix.getPosX();
		double[] Y = distanceMatrix.getPosY();
		
		double maxX = 0.0;
		double maxY = 0.0;
		
		for(int i = 0; i < X.length; i++) {
			if(X[i] > maxX) {
				maxX = X[i];
			}
			if(Y[i] > maxY) {
				maxY = Y[i];
			}
		}
		
		double[] res = new double[2];
		res[0] = maxX;
		res[1] = maxY;
		
		return res;
		
	}
}