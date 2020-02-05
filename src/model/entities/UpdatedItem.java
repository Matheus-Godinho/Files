package model.entities;

public class UpdatedItem extends Item {
	
	public UpdatedItem() {
		super();
	}
	public UpdatedItem(String name, Double price, Integer quantity) {
		super(name, price, quantity);
	}
	
	public Double totalValue() {
		return getPrice() * getQuantity();
	}
	
	@Override
	public String toString() {
		return getName() 
				+ "," 
				+ String.format("%.2f", totalValue());
	}

}
