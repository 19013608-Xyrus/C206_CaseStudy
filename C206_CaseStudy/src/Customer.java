/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19018500, 23 Aug 2020 2:21:40 pm
 */

/**
 * @author 19018500
 *
 */
public class Customer {

	/**
	 * @param args
	 */
		private String name;
		
		public Customer(String name) {
			super();
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public String setName() {
			return name;
		}
		
		public String toString() {
			String output = String.format("%s", name);
			return output;
		}

	}
