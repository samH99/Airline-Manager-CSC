/**
 * 
 */
package edu.ncsu.csc316.hub_manager.disjoint_set;

import edu.ncsu.csc316.hub_manager.flight.Airport;

/**
 * Stores the vertices of the MST
 * 
 * Used pseudo-code from DisjointSets_Up-Trees slides by Dr. King
 * 
 * @author someshherath
 */
public class UpTree {

	/**
	 * Finds the root of the airport given
	 * 
	 * @param a
	 *            the airport to find the root of
	 * @return the root
	 */
	private static Airport find(Airport a) {
		Airport temp = a;
		while (temp.parent != null) {
			temp = temp.parent;
		}
		return temp;
	}

	/**
	 * makes root of one set point to root of the other
	 * 
	 * @param a
	 *            the first airport
	 * @param b
	 *            the second airport
	 * @return the root airport
	 */
	public static Airport union(Airport a, Airport b) {
		Airport aRoot = find(a);
		Airport bRoot = find(b);

		if (aRoot != bRoot) {
			a.connections++;
			b.connections++;

			if (aRoot.count >= bRoot.count) {
				aRoot.count += (bRoot.count + 1);
				bRoot.parent = aRoot;

				return aRoot;
			} else {
				bRoot.count += (aRoot.count + 1);
				aRoot.parent = bRoot;

				return bRoot;
			}
		}

		return null;

	}

}
