import ua.kpi.its.lab.rest.entity.Magazine

/**

An interface representing a container for storing objects of type T.
 */
interface Container<T> {
    /**

    Adds an element of type T to the container.
    @param element The element to be added to the container.
     */
    fun add(element: T)

    /**

    Removes an element from the container at the specified index.
    @param index The index of the element to be removed.
     */
    fun remove(index: Int)

    /**

    Updates an element in the container at the specified index with a new element of type T.
    @param index The index of the element to be updated.
    @param element The new element to replace the existing element at the specified index.
     */
    fun update(index: Int, element: T)

    /**

    Retrieves the element at the specified index from the container.
    @param index The index of the element to be retrieved.
    @return The element at the specified index.
     */
    fun get(index: Int): T

    /**

    Retrieves all elements from the container.
    @return A list of all elements in the container.
     */
    fun getAll(): List<T>
}

/**

A class representing a container for storing Magazine objects.
 */
class MagazineContainer : Container<Magazine> {
    private val magazines: MutableList<Magazine> = mutableListOf()

    /**

    Adds a Magazine object to the container.
    @param element The Magazine object to be added to the container.
     */
    override fun add(element: Magazine) {
        magazines.add(element)
    }

    /**

    Removes a Magazine object from the container at the specified index.
    @param index The index of the Magazine object to be removed.
     */
    override fun remove(index: Int) {
        magazines.removeAt(index)
    }

    /**

    Updates a Magazine object in the container at the specified index with a new Magazine object.
    @param index The index of the Magazine object to be updated.
    @param element The new Magazine object to replace the existing Magazine object at the specified index.
     */
    override fun update(index: Int, element: Magazine) {
        magazines[index] = element
    }

    /**

    Retrieves a Magazine object from the container at the specified index.
    @param index The index of the Magazine object to be retrieved.
    @return The Magazine object at the specified index.
     */
    override fun get(index: Int): Magazine {
        return magazines[index]
    }

    /**

    Retrieves all Magazine objects from the container.
    @return A list of all Magazine objects in the container.
     */
    override fun getAll(): List<Magazine> {
        return magazines
    }
}