package cerepro.web.servlets.maven.noteTemplates;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import centauri.academy.proxima.cerepro.entity.NoteTemplate;
import centauri.academy.proxima.cerepro.repository.NoteTemplateRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/noteTemplatesInsert")
public class InsertServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		NoteTemplateRepository ntr = new NoteTemplateRepository ();
		NoteTemplate nt = new NoteTemplate ();
		
		
		nt.setTitle(request.getParameter("title"));
		nt.setContent(request.getParameter("content"));
		ServletContext sc = request.getServletContext();
		try {
			Long id = ntr.create(nt);
			System.out.println(id);
			
			if(id>0) {
//			
				 System.out.println("id positivo");
				sc.setAttribute("insert", "true");
				

			}
			else {
				
				System.out.println("id negativo");
				sc.setAttribute("insert", "false");
				
				
			}
			System.out.println(request.getRequestURL());
			
			RequestDispatcher rd =request.getRequestDispatcher("/noteTemplates/list.jsp");
			rd.forward(request, response);
			}
		catch(Exception  e) {
			System.out.println("error");
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
