package inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Popup;

public class AddProductPopupController implements ActionListener{
	
	private static final String submitString = "Submit";
	private static final String cancelString = "Cancel";

	private AddProductPopup popup;
	private ProductModel model;
	
	private String number;
	private String description;

	public AddProductPopupController(ProductModel model,
			AddProductPopup addProductPopup) {
		this.popup = addProductPopup;
		this.model = model;
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if(command.equals(cancelString)){
			popup.dispose();
			return;
		} else if(command.equals(submitString)){
			//partId = itemP.getPartId();
			number = popup.getNumber();
			description = popup.getDescription();
			submit();					
		}
		
	}
	
	private void submit(){
		
		boolean error = false;
		
		Product newProduct = new Product();
		
		if(number.startsWith("A") && !number.isEmpty()) {
			newProduct.setNumber(number);
		} else {
			popup.formatError(1);
			error = true;
		}
		if(!description.isEmpty()) {
			newProduct.setDescription(description);
		} else {
			popup.formatError(2);
			error = true;
		}
		
		if(!error) {
			model.addProduct(newProduct);
			popup.closeWindow();
		}
	}

}
