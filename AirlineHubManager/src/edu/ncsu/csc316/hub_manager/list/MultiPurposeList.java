/**
 * 
 */
package edu.ncsu.csc316.hub_manager.list;

/**
 * List used for holding Airports, used by AirportReader
 * 
 * @author someshherath
 * 
 * @param <E>
 *            the generic parameter
 */
public class MultiPurposeList<E> {

	private static final int INITIAL_SIZE = 10;
	private E[] list;
	private int size;

	/**
	 * Constructs MultiPurposeList with 0 size
	 */
	@SuppressWarnings("unchecked")
	public MultiPurposeList() {
		size = 0;
		list = (E[]) (new Object[INITIAL_SIZE]);
	}

	/**
	 * Adds an element to the MultiPurposeList
	 * 
	 * @param i
	 *            index to add to
	 * @param e
	 *            element to add
	 */
	public void add(int i, E e) {
		if (e == null) {
			throw new NullPointerException();
		}

		if (i < 0 || i > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (list.length == size()) {
			growArray();
		}

		for (int c = (size() - 1); c >= i; c--) {
			list[c + 1] = list[c];
		}
		list[i] = e;
		size++;

	}

	/**
	 * Adds an element to the end of the MultiPurposeList
	 * 
	 * @param e
	 *            element to add
	 * @return true if added
	 */
	public boolean add(E e) {
		add(size(), e);
		return true;

	}

	/**
	 * Grows the array
	 */
	private void growArray() {
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) (new Object[size() * 2]);
		for (int i = 0; i < size(); i++) {
			temp[i] = list[i];
		}

		list = temp;
	}

	/**
	 * Removes elements from the list
	 * 
	 * @return the removed element
	 * @param i
	 *            the index to remove
	 */
	public E remove(int i) {
		E r;

		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}

		r = list[i];
		for (int c = i; c < size; c++) {
			list[c] = list[c + 1];
		}
		list[size - 1] = null;
		size--;
		return r;
	}

	/**
	 * Sets an index with the element given
	 * 
	 * @return the past element
	 * @param i
	 *            the index to set
	 * @param e
	 *            element to set
	 */
	public E set(int i, E e) {
		E r;

		if (e == null) {
			throw new NullPointerException();
		}

		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}

		r = list[i];

		list[i] = e;
		return r;

	}

	/**
	 * Gets a element form the list
	 * 
	 * @return the element at the index given
	 * @param i
	 *            the index to get from
	 */
	public E get(int i) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}

		return list[i];
	}

	/**
	 * Returns the size
	 * 
	 * @return the size
	 */
	public int size() {
		return size;
	}

}