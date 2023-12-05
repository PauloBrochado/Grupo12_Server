package RestServer;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import stand.Administrador;
import stand.AdministradorService;

@Path("/administrador")
public class AdministradorRESTService {
	private AdministradorService administradorService;
	
	public AdministradorRESTService(EntityManager em) {
		this.administradorService = new AdministradorService(em);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Olá, eu sou o controlador de Administradores";
	}
	
	@GET
	@Path("/getAdministradores")
	public Response getAdministrador() {
		List<Administrador> administradores = administradorService.findAllAdministrador();
		
		return Response.status(Response.Status.OK)
				.entity(administradores)
				.type(MediaType.APPLICATION_JSON)
				.build();	
	}
	
	@GET
	@Path("/getAdministradores/{Administrador}")
	public Response getAdministrador(@PathParam("administrador") int id) {
		Administrador administradorResponse = administradorService.findAdministrador(id);
		
		return Response.status(Response.Status.OK)
				.entity(administradorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addAdministrador")
	public Response addAdministrador(int id,String pass,String nome,String funcao) {
		Administrador administradorResponse = administradorService.updateAdministrador(0,null,null,null);
		
		return Response.status(Response.Status.CREATED)
				.entity(administradorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateAdministrador")
	public Response updateAdministrador(Administrador ad) {
		Administrador administradorResponse = administradorService.updateAdministrador(ad);
		
		return Response.status(Response.Status.OK)
				.entity(administradorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteAdministrador/{administrador}")
	public Response deleteAdministrador(@PathParam("administrador") int id) {
		boolean administradorRemoved = administradorService.removeAdministrador(id);
		
		return Response.status(Response.Status.OK)
				.entity(administradorRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}

