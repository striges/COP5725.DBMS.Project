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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import po.User;

import dao.IUserDao;
import database.form.UserLoginForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-06-2013
 * 
 * XDoclet definition:
 * @struts.action path="/userLogin" name="userLoginForm" input="/userLogin.jsp" scope="request" validate="true"
 */
public class UserLoginAction extends Action {
	
	private IUserDao udao;
	
	/*
	 * Generated Methods
	 */

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
		UserLoginForm userLoginForm = (UserLoginForm) form;// TODO Auto-generated method stub
		String username=userLoginForm.getUsername();
		String password=userLoginForm.getPassword();
		//System.out.println(username);
		User user=udao.getUserByUsername(username);
		ActionMessages errors=new ActionMessages();
		if(user==null||!user.getPassword().equals(password)){
			ActionMessage error=new ActionMessage("errors.login");
			errors.add("login",error);
			this.saveErrors(request,errors);
			return mapping.getInputForward();
		}
		System.out.println(user.getCreateTime());
		//if(books!=null){
			//System.out.println("sasdsa");
		//}
		request.getSession().setAttribute("user",user);
		return new ActionForward("/index.do");
	}
}