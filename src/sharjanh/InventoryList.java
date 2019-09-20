/**
 *
 */
package sharjanh;

//importing the Arrays class
import java.util.ArrayList;

/**
 * @author janhvi
 */

// The InventoryList class models a list of the inventory items entered by the
// user
public class InventoryList {

	// declaring and instantiating invList which is an Array or ArrayList of
	// Inventory objects
	private ArrayList<Inventory> invList = new ArrayList<Inventory>();

	// default constructor of the class
	public InventoryList() {

	}

	// this method accepts an Inventory object to add to the invList
	public void add(Inventory inventory) {
		// adding the object to invList
		invList.add(inventory);
	}

	// this accepts an integer index and returns the Inventory object at that
	// index
	public Inventory get(int index) {
		// the method returns object only if the index is a valid index. If the
		// index is invalid, the method simply returns a null object
		try {
			return invList.get(index); // returns object at valid index
		} catch (Exception ex) {
			return null; // returning null object
		}
	}

	// this method returns the size of the invList
	public int length() {
		// returns the number of elements that contain Inventory objects
		return invList.size();
	}

} // end of InventoryList class
