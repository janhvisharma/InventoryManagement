package sharjanh;

import java.util.Optional;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// Assign2Controller has an object of the InventoryList class to store and
// manage the information of items in the inventory.
public class Assign2Controller {

	// object of the InventoryList class to store and manage the information of
	// items in the inventory.
	InventoryList invList = new InventoryList();

	// @FXML is a special tag that connects the variable to the layout

	// adding field variables for the Buttons that match the fx:id
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnOrders;
	@FXML
	private Button btnExit;

	// adding field variables for the Text Fields that match fx:id
	@FXML
	private TextField id;
	@FXML
	private TextField name;
	@FXML
	private TextField qoh;
	@FXML
	private TextField rop;
	@FXML
	private TextField price;

	// adding field variables for the Text Area that matches fx:id
	@FXML
	private TextArea txtArea;

	// adding field variables for the Labels that match fx:id
	@FXML
	private Label msg;
	@FXML
	private Label tracker;

	// This method creates an object of all the handlers and passes them to the
	// field variables using their setOnAction method.
	@FXML
	private void initialize() {
		// using lambda expressions

		// setOnAction method accepts an EventHandler object, so one is created
		// (e) is the parameter passed to the handle method
		// it implements one method, the handle method. Calls a method in the
		// outer class.

		btnAdd.setOnAction(e -> {
			onAddClicked(); // the handle method for Add button
		});

		btnSave.setOnAction(e -> {
			try {
				onSaveClicked(); // the handle method for Save button
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btnOrders.setOnAction(e -> {
			onOrdersClicked(); // the handle method for Orders button
		});

		btnExit.setOnAction(e -> {
			onExitClicked(); // the handle method for Exit button
		});
	}

	// data members
	// ID an Name of type String
	String _id, _name;

	// QOH and ROP of type integer
	int _qoh, _rop;

	// Sell Price of type double
	double _price;

	// this method is used to clear the input fields so that the user can easily
	// type inputs for a new Inventory object.
	public void onAddClicked() {
		// the clear method clears the fields in the GUI

		id.clear(); // clears id
		name.clear(); // clears name
		qoh.clear(); // clears quantity-on-hand
		rop.clear(); // clears re-order point
		price.clear(); // clears price
		msg.setText(""); // clears the output label
		txtArea.setText(""); // clears the text area
	}

	// this method is used to save the current input values as an Inventory
	// object to the InventoryList.
	public void onSaveClicked() throws Exception {

		// object of the Inventory class
		Inventory invent = new Inventory();

		// the try block defines using the mutator methods from Inventory to
		// assign value to be tested for errors while they are being executed.
		try {
			// use the mutator methods from Inventory to assign the user inputs
			// to each field.
			_id = id.getText(); // gets id
			invent.setId(_id); // sets id

			_name = name.getText(); // gets name
			invent.setName(_name); // sets name

			_qoh = Integer.parseInt(qoh.getText()); // gets quantity-on-hand as
													// integer
			invent.setQoh(_qoh); // sets quantity-on-hand

			_rop = Integer.parseInt(rop.getText()); // gets re-order point as
													// integer
			invent.setRop(_rop); // sets re-order point

			_price = Double.parseDouble(price.getText()); // gets selling price
			invent.setSellPrice(_price); // sets selling price

			// items added to the Inventory List if no exceptions occur
			invList.add(invent);

			// label message changes to show confirmation of items being added.
			msg.setText("Item Added to List!");

		} catch (Exception ex) {
			// an Alert dialog box is displayed with Inventory error messages
			// for the field that has the error. Only one error message is shown
			// at a time.
			Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
			alert.showAndWait();
		}
	}

	// This method will display a list of Inventory objects from the
	// InventoryList that need to be re-ordered (_qoh <= _rop).
	public void onOrdersClicked() {

		// searching in the list to display only those items that need
		// re-ordering
		for (int i = 0; i < invList.length(); i++) {
			if ((invList.get(i)._rop > invList.get(i)._qoh) || (invList.get(i)._rop == invList.get(i)._qoh)) {
				// the items that need to be re-ordered are displayed in the
				// TextArea below the input area.
				txtArea.appendText(invList.get(i)._name + " needs to be ordered \n");
			} else {
				continue;
			}
		}

		// If the InventoryList is empty, this message is displayed in the
		// bottom message label.
		if (invList.length() == 0) {
			msg.setText("No items to list. Add some.");
		}
		// If no items get added to the TextArea, this message is displayed in
		// the bottom message label.
		else if (txtArea.getText().trim().length() == 0) {
			msg.setText("No items to re-order.");
		} else {
			msg.setText("");
		}

	}

	// This button is used to exit the program, upon confirmation from the user.
	public void onExitClicked() {

		// Displays an Alert dialog that asks if the user is sure that they wish
		// to exit (Yes/No).
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Exit?");
		alert.setHeaderText("Are you sure you want to exit?");

		// customizing the buttons as yes/no
		ButtonType btnYes = new ButtonType("Yes");
		ButtonType btnNo = new ButtonType("No");

		alert.getButtonTypes().setAll(btnYes, btnNo);

		Optional<ButtonType> result = alert.showAndWait();

		// If the user says Yes, exit the program. If the user says no, does
		// nothing.
		if (result.get() == btnYes) {
			Platform.exit();
			System.exit(0);
		}
	}

} // end of Assign2Controller class
