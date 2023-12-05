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

import stand.Carro;
import stand.CarroService;

@Path("/carro")
public class carroRESTService {
	private CarroService carroService;
	
	public carroRESTService(EntityManager em) {
		this.carroService = new CarroService(em);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Olá, eu sou o controlador de carros";
	}
	
	@GET
	@Path("/getcarros")
	public Response getcarros() {
		List<Carro> carros = carroService.findAllCarros();
		
		return Response.status(Response.Status.OK)
				.entity(carros)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getcarros/{carro}")
	public Response getcarro(@PathParam("carro")String carro) {
		Carro carroResponse = carroService.findCarro(carro);
		
		return Response.status(Response.Status.OK)
				.entity(carroResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addcarro")
	public Response addcarro(String carro) {
		Carro carroResponse = carroService.updateCarro(0, carro, carro, 0, carro, 0, 0, carro, 0, null, false);
		
		return Response.status(Response.Status.CREATED)
				.entity(carroResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updatecarro")
	public Response updatecarro(String carro) {
		Carro carroResponse = carroService.updateCarro(0, carro, carro, 0, carro, 0, 0, carro, 0, null, false);
		
		return Response.status(Response.Status.OK)
				.entity(carroResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deletecarro/{carro}")
	public Response deletecarro(@PathParam("carro")int id) {
		CarroService carroRemoved = carroService.removeCarro(id);
		
		return Response.status(Response.Status.OK)
				.entity(carroRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}