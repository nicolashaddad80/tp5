package fr.cnam.tp5;

public interface Set {
    /**
     * Retrieve the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    int cardinal();

    /**
     * Determine if the set is empty.
     *
     * @return true if the set is empty
     */
    boolean isEmpty();

    /**
     * Determine if the set contains the element passed as argument.
     *
     * @param e the concerned element
     * @return true if the element is in the set
     */
    boolean contains(int e);

    /**
     * Add an element in the set.
     * If the element is present, do not do anything.
     *
     * @param e the element to add
     */
    void add(int e);

    /**
     * Remove an element from the set.
     * If the element is not present, do not do anything.
     *
     * @param e the element to remove
     */
    void remove(int e);

    /**
     * Get the minimum of the set.
     * If the set is empty, returns 0.
     *
     * @return the smallest element of the set
     */
    int min();
}
