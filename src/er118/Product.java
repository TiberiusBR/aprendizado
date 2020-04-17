package er118;

public class Product {
	
	public String name;
	public Double prince;
	
	public Product() {
		
	}

	public Product(String name, Double prince) {
		this.name = name;
		this.prince = prince;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrince() {
		return prince;
	}

	public void setPrince(Double prince) {
		this.prince = prince;
	}
	

}
