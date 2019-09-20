/**
 *
 */
package sharjanh;

/**
 * @author janhvi
 */

// the Inventory class models an item that can be found in a store's inventory.
public class Inventory {

	// data members
	String _id; // Inventory Id of type String
	String _name;// Name of type String

	// QOH is quantity of item currently in stock
	int _qoh; // Quantity On Hand of type integer

	// ROP is the amount that the QOH should remain above before this item needs
	// to be re-ordered
	int _rop; // Re--Order Point of type integer

	double _sellPrice;// Selling Price of type double

	// default constructor initializes the data members to their default values
	public Inventory() {
		_id = "ABC-1234"; // default value for ID
		_name = "New Item"; // default value for Name
		_qoh = 0; // default value for QOH
		_rop = 25; // default value for ROP
		_sellPrice = 0.0; // default value for Selling Price
	}

	// multiple parameter constructors set the values of the appropriate data
	// members to the parameter values.

	// parameterized constructor
	public Inventory(String id, String name, double sellPrice) {
		setId(id); // sets value of ID from parameter
		setName(name); // sets value of Name from parameter
		setSellPrice(sellPrice); // sets value of Selling Price from parameter
	}

	// parameterized constructor
	public Inventory(String id, String name, int qoh, int rop, double sellPrice) {
		setId(id); // sets value of ID from parameter
		setName(name); // sets value of Name from parameter
		setQoh(qoh); // sets value of QOH from parameter
		setRop(rop); // sets value of ROP from parameter
		setSellPrice(sellPrice); // sets value of Selling Price from parameter
	}

	// Accessor methods

	// getter for Inventory ID
	public String getId() {
		return _id; // returns ID
	}

	// getter for Inventory Name
	public String getName() {
		return _name; // returns Name
	}

	// getter for QOH
	public int getQoh() {
		return _qoh; // returns QOH
	}

	// getter for ROP
	public int getRop() {
		return _rop; // returns ROP
	}

	// getter for Selling Price
	public double getSellPrice() {
		return _sellPrice; // returns Selling Price
	}

	// All mutator methods should only assign the parameter value if it is
	// valid,
	// otherwise an IllegalArgumentException is thrown with a specific, yet
	// concise and informative error message.

	// setter for Inventory ID
	public void setId(String id) {
		// checking if the id matches the specially-formed String
		if (id.matches("[a-zA-Z]{3}-[\\d]{4}")) {
			// setting value of ID
			_id = id;
		} else
			// error message shown if ID doesn't match the pattern of the String
			throw new IllegalArgumentException("Error: Inventory ID must be in the form ABC-1234");
	}

	// setter for Inventory Name
	public void setName(String name) {
		// checking if the name is not a null object or a null-String
		if (name != null && !name.isEmpty()) {
			// setting the value of Name
			_name = name;
		} else
			// error message shown if Name is either a null object or String
			throw new IllegalArgumentException("Error: You must enter an Item Name.");

	}

	// setter for Quantity-On-Hand
	public void setQoh(int qoh) {
		// checking if QOH is 0 or more, and not negative.
		if (qoh >= 0) {
			// setting the value of QOH
			_qoh = qoh;
		} else {
			// error message shown if QOH is less than 0 or negative
			throw new IllegalArgumentException("Error: QOH must be 0 or more.");

		}
	}

	// setter for Re-Order Point
	public void setRop(int rop) {
		// checking if ROP is greater than 0
		if (rop > 0) {
			// setting the value of ROP
			_rop = rop;
		} else
			// error message shown if ROP is equal to 0 or negative
			throw new IllegalArgumentException("Error: ROP must be greater than 0.");
	}

	// setter for Selling Price
	public void setSellPrice(double sellPrice) {
		// checking if Sell Price is greater than 0
		if (sellPrice > 0) {
			// setting the value of Sell Price
			_sellPrice = sellPrice;
		} else
			// error message shown if Sell Price is equal to 0 or negative
			throw new IllegalArgumentException("Error: Selling Price must be greater than 0.");
	}

	// toString method returns the Inventory object as a String
	public String toString() {
		// value stored in the sellPrice member formatted with a $ and 2 decimal
		// places
		String str = String.format("$%.2f", _sellPrice);

		// returns a string
		return _id + " (" + _name + "), QOH: " + _qoh + " Price: " + str;
	}

} // end of Inventory class
