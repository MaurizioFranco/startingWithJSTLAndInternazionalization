package cerepro.web.servlets.maven.noteTemplates;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.NoteTemplate;
import centauri.academy.proxima.cerepro.repository.NoteTemplateRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/noteTemplateDeleteById")
public class DeleteIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteIdServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		NoteTemplateRepository ntr = new NoteTemplateRepository ();
		
		ServletContext sc = request.getServletContext();
		

		try {
			
			long id = Long.parseLong(request.getParameter("id"));
			boolean control=ntr.delete(id);

			if(control) {
				sc.setAttribute("deleteById", "true");
			}
			else {

				sc.setAttribute("deleteById", "false");
			}
		}
		catch(Exception  e){
			response.getWriter().append("Error");
			response.getWriter().append(e.getMessage());
		}

		RequestDispatcher rd =request.getRequestDispatcher("/noteTemplates/list.jsp");
		 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
