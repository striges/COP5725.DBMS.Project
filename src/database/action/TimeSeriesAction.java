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

import dao.IEmployeeDAO;

/** 
 * MyEclipse Struts
 * Creation date: 04-07-2013
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class TimeSeriesAction extends Action {
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
		// TODO Auto-generated method stub
		ArrayList time=edao.timeseries();
		if(time!=null){
			request.setAttribute("time", time);
		}else{
			request.setAttribute("stats", 1);
		}
		return new ActionForward("/timeSeries.jsp");
	}
}