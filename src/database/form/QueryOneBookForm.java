/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package database.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-31-2013
 * 
 * XDoclet definition:
 * @struts.form name="queryOneBookForm"
 */
public class QueryOneBookForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** booksku property */
	private String booksku;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the booksku.
	 * @return String
	 */
	public String getBooksku() {
		return booksku;
	}

	/** 
	 * Set the booksku.
	 * @param booksku The booksku to set
	 */
	public void setBooksku(String booksku) {
		this.booksku = booksku;
	}
}