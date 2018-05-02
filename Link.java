package finalProject;

public class Link {
	
		
		public company co;
		public Link next;
		
		/**
		 * constructor
		 */
		public  Link (company coName) {
			
			this.co=coName;
		}
		/**
		 * @return can
		 */
		public company getCompany() {
			return co;
		}
		
		/**
		 * show the list in the console
		 */
		public void displayLink() // display method
		{
			System.out.print( co.toString() );
		}

	}

