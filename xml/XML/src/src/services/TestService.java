package src.services;

import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import src.sessionbeans.TestDao;
import src.sessionbeans.TestDaoLocal;
 
@Path("test")
public class TestService {

    //@EJB
	private TestDaoLocal testDao;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String findByAll() throws NamingException {
    	testDao = new TestDao();
    	
    	String s1 = "";
		s1 = testDao.test();
		
		return s1;
    }
}