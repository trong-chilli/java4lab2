package Servlet;

import jakarta.persistence.criteria.Path;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDaolmpt;
import DAO.interfaceDAO;
import entitys.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({
		"user/index",
		"user/edit/*",
		"user/create",
		"user/update",
		"user/delete",
		"user/reset"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User form = new User();
		//code xu ly
	
		interfaceDAO Dao = new UserDaolmpt();
		
		try {
			BeanUtils.populate(form, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		String path = req.getServletPath();
		if(path.contains("edit")) {
			String id = req.getPathInfo().substring(1);
		}else if (path.contains("create")){
			Dao.create(form);
		}else if (path.contains("update")) {
			Dao.update(form);
		}else if (path.contains("delete")) {
			Dao.deleteById(path);
		}else {
			form = new User();
		}
		req.setAttribute("item", form);
		List<User> list = Dao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

}
