package src.services;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import src.sessionbeans.LoginTry;
import src.sessionbeans.User;
import src.sessionbeans.UserDao;

@Path("/user")
public class UserService {
	
	@Context
	HttpServletRequest request;
	@Context
	ServletContext ctx;
	@Context
    private HttpServletResponse servletResponse;
	
	UserDao k = new UserDao("","");
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "OK";
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User login(LoginTry lt) {
		/*User kor = k.getKorisnik(lt.getEmail());
		if(kor!=null && kor.getLozinka().equals(lt.getPass())){
			System.out.println("Ulogovani kao"+kor.toString());
			return kor;
		}*/
		return null;
	}

}
