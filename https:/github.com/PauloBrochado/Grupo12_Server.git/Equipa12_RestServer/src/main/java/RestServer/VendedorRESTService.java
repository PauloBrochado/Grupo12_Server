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

import stand.Vendedor;
import stand.VendedorService;

@Path("/vendedor")
public class VendedorRESTService {
	private VendedorService vendedorService;
	
	public VendedorRESTService(EntityManager em) {
		this.vendedorService = new VendedorService();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Olá, eu sou o controlador de Vendedores";
	}
	
	@GET
	@Path("/getVendedor")
	public Response getVendedor() {
		List<Vendedor> Vendedores = VendedorService.findAllVendedor();
		
		return Response.status(Response.Status.OK)
				.entity(Vendedores)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getVendedor/{id}")
	public Response getUtilizador(@PathParam("id")int id) {
		Vendedor vendedorResponse = VendedorService.findVendedor(id);
		
		return Response.status(Response.Status.OK)
				.entity(vendedorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addVendedor")
	public Response addVendedor(int id, String pass, String nome) {
		Vendedor vendedorResponse = vendedorService.updateVendedor(id,pass,nome);
		
		return Response.status(Response.Status.CREATED)
				.entity(vendedorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateVendedor")
	public Response updateVendedor(int id, String pass, String nome) {
		Vendedor vendedorResponse = vendedorService.updateVendedor(id, pass,nome);
		
		return Response.status(Response.Status.OK)
				.entity(vendedorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteVendedor/{id}")
	public Response deleteVendedor(@PathParam("id") int id) {
		Vendedor vendedorRemoved = vendedorService.removeVendedor(id);
		
		return Response.status(Response.Status.OK)
				.entity(vendedorRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}