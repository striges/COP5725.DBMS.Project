/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package database.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import po.Book;

import dao.IEmployeeDAO;
import database.form.UpdateBookForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-31-2013
 * 
 * XDoclet definition:
 * @struts.action path="/updateBook" name="updateBookForm" input="/updateBook.jsp" scope="request" validate="true"
 */
public class UpdateBookAction extends Action {
	/*
	 * Generated Methods
	 */
    private IEmployeeDAO edao;
    
	public IEmployeeDAO getEdao() {
		return edao;
	}

	public void setEdao(IEmployeeDAO edao) {
		this.edao = edao;
	}

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UpdateBookForm updateBookForm = (UpdateBookForm) form;// TODO Auto-generated method stub
		Book book=(Book) request.getSession().getAttribute("requiredBook");
		int bs=book.getBooksku();
		int sq=Integer.parseInt(updateBookForm.getStockquantity());
		double up=Double.parseDouble(updateBookForm.getUnitprice());
	    boolean flag=edao.updateBook(bs, sq, up);
	    if(flag=true){
	    	Book book2=edao.getBookByBooksku(bs);
	    	request.getSession().setAttribute("requiredBook", book2);
	    	request.setAttribute("update", 1);
	    }else{
	    	request.setAttribute("update", 0);
	    }
		return mapping.getInputForward();
	}
}