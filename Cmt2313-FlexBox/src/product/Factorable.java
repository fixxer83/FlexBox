package product;

import java.util.ArrayList;

public interface Factorable {
	
	/**
	 * This method may be used to
	 * return all items available
	 * in one product list
	 * 
	 * @param path
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> getList(String path);
	
	/**
	 *adding a new product 
	 */
	public void addNew(ArrayList<Object> objList); 
	
	/**
	 * Verify if a product is present
	 * in a file. Method supports using a
	 * search term
	 * 
	 * @return ArrayList<Object>
	 */	
	public ArrayList<Object> searchForCardGrade(ArrayList<Object> objList, String searchTerm);
	
	/**
	 * Verify if a product is present
	 * in a file. Method supports using a
	 * search term
	 * 
	 * @return ArrayList<Object>
	 */	
	public BoxType searchForBoxType(ArrayList<Object> objList);
	
}
