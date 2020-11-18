package cerepro.web.servlets.maven.noteTemplates;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.NoteTemplate;
import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.repository.NoteTemplateRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/noteTemplatesUpdate")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		NoteTemplateRepository ntr = new NoteTemplateRepository ();
		NoteTemplate nt = new NoteTemplate ();
		nt.setId(Long.parseLong(request.getParameter("id")));
		nt.setTitle(request.getParameter("title"));
		nt.setContent(request.getParameter("content"));
		ServletContext sc = request.getServletContext();

		try {
			boolean control = ntr.update(nt);
			System.out.println(ntr.update(nt));
			
			if(control) {
//			
				System.out.println(control+" update true ");
				sc.setAttribute("update", "true");
				

			}
			else {
				
				System.out.println(control+" update false");
				sc.setAttribute("update", "false");
				
				
			}
			
			RequestDispatcher rd =request.getRequestDispatcher("/noteTemplates/list.jsp");
			rd.forward(request, response);
			}
		catch(Exception  e) {
			System.out.println("error update");
			response.getWriter().append(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
