package src.services;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import src.rs.gov.parlament.propisi.Zakon;
import src.sessionbeans.TestDao;
import src.sessionbeans.TestDaoLocal;
 
@Path("test")
public class TestService {

    //@EJB
	private TestDaoLocal testDao;
	
	@javax.ws.rs.core.Context
	private ServletContext servletContext;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String findByAll() throws NamingException, IOException {
    	testDao = new TestDao();
    	
    	String s1 = "";
		
    	//InputStream i = Thread.currentThread().getContextClassLoader().getResourceAsStream("books.xml");
    	//InputStream i =  servletContext.getClass().getClassLoader().getResourceAsStream("books.xml");
    	
    	//File tmpdir = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
        /*File tmpdir = new File("C:\\Users\\Danilo\\Documents");
    	
    	if(null == tmpdir)
    	  throw new IllegalStateException("Container does not provide a temp dir"); // Or handle otherwise

    	File targetFile = new File(tmpdir, "books.xml");
    	BufferedWriter out = null;
        */
    	/*try {
    	  out = new BufferedWriter(new FileWriter(targetFile));
          out.write("<foo>fjhdfjdfd</foo>");
    	  // write to output stream
    	} finally {
    	  if(null != out) try { out.close(); }
    	  catch (IOException ioe) { og this }
    	} */
    	s1 =  testDao.test();
		return "fg";
    }	
   
}