/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package database.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import po.User;

import dao.IUserDao;

/** 
 * MyEclipse Struts
 * Creation date: 04-04-2013
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ChooseShippingAddressAction extends Action {
	/*
	 * Generated Methods
	 */
    private IUserDao udao;
    
    
	public IUserDao getUdao() {
		return udao;
	}


	public void setUdao(IUserDao udao) {
		this.udao = udao;
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
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("user");
		int id=user.getID();
		ArrayList addrs=udao.queryAddress(id);
		if(addrs!=null){
			request.setAttribute("choose",1);
			request.getSession().setAttribute("addresslist", addrs);
		}else{
			request.setAttribute("choose", 0);
		}
		
		return new ActionForward("/chooseShippingAddress.jsp");
	}
}