package edu.ncsu.csc316.hub_manager.priority_queue;

import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;

/**
 * Contains a heap of FlightLegs between the airports
 * 
 * Used pseudo-code from Priority Queue ADT and Heaps slides by Dr. King
 * 
 * @author someshherath
 *
 */
public class MinHeap {

	/**
	 * contains the heap as an array
	 */
	public MultiPurposeList<FlightLeg> heap;

	/**
	 * Constructs an empty MinHeap
	 */
	public MinHeap() {
		heap = new MultiPurposeList<FlightLeg>();
	}

	/**
	 * Inserts a legend to the heap
	 * 
	 * @param legend
	 *            the legend to insert
	 */
	public void insert(FlightLeg legend) {
		heap.add(legend);
		upHeap(heap.size() - 1);
	}

	/**
	 * moves the FlightLeg in the position given to the correct position in the
	 * heap by moving it up
	 * 
	 * @param i
	 *            the position of the element to move in the heap
	 */
	private void upHeap(int i) {
		if (i > 0) {
			if (heap.get((i - 1) / 2).getDistance() > heap.get(i).getDistance()) {
				FlightLeg temp = heap.get((i - 1) / 2);
				heap.set((i - 1) / 2, heap.get(i));
				heap.set(i, temp);
			}
			upHeap((i - 1) / 2);
		}
	}

	/**
	 * deletes the minimum value in the heap
	 * 
	 * @return the FlightLeg with the smallest distance
	 */
	public FlightLeg deleteMin() {
		FlightLeg r = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		downHeap(0);

		return r;

	}

	/**
	 * moves the FlightLeg in the position given to the correct position in the
	 * heap by moving it down
	 * 
	 * @param m
	 *            the position of the element to move in the heap
	 */
	private void downHeap(int m) {
		int i = 0;
		if ((2 * m + 2) < heap.size()) {
			if (heap.get(2 * m + 2).getDistance() <= heap.get(2 * m + 1).getDistance()) {
				i = 2 * m + 2;
			} else {
				i = 2 * m + 1;
			}
		} else if ((2 * m + 1) < heap.size()) {
			i = 2 * m + 1;
		}
		if (i > 0 && heap.get(m).getDistance() > heap.get(i).getDistance()) {
			FlightLeg temp = heap.get(i);
			heap.set(i, heap.get(m));
			heap.set(m, temp);

			downHeap(i);
		}

	}

}
