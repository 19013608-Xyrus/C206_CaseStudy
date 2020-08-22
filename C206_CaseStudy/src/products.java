/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19038833, 19 Aug 2020 10:08:38 pm
 */

/**
 * @author 19038833
 *
 */
public class products {
	private String name;
	
	public products(String name) {
		super();
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public String setName() {
		this.name=name;
		return name;
	}
	
	public String toString() {
		String output = String.format("%s", name);
		return output;
	}

}
