package RestServer;

import java.util.List;


import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import stand.Carro;
import stand.CarroService;



	@Path("/carro")
	public class Rest{
        CarroService cs = new CarroService(null);

		 
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String sayPlainTextHello(Request a) {
			return "REST Server : Hello World! I'm the Books Controller";
		}
	
		
		@POST
		@Path("/addCarro")
		public Response addCarro(Carro carro) {		
			Carro bookResponse = cs.updateCarro(carro.getId(),carro.getMarca(),carro.getModelo(),carro.getAno(),carro.getTipo(),carro.getCavalos(),carro.getAutonomia(),carro.getDescricao(),carro.getPrecoVenda(), null, false);
			
			return Response.status(Response.Status.CREATED)
					.entity(bookResponse)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		@GET
		@Path("/getCar")
		public Response getCar() {	

					List<Carro> c = cs.findAllCarros();
			return Response.status(Response.Status.OK)
					.entity(c)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		
		@GET
		@Path("/getCarro")
		public Response getCarro() {	

					List<Carro> c = cs.findAllCarros();
			return Response.status(Response.Status.OK)
					.entity(c)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		
		
		
		@GET
		@Path("/getCarroId/{id}")
		public Response getCarroId (@PathParam("id") int id) {	

					Carro c = cs.findCarro(id);
			return Response.status(Response.Status.OK)
					.entity(c)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		
		
		@GET
		@Path("/getCarroId_ad/{cod}")
		public Response getCarroId_ad (@PathParam("id") int id) {	
					Carro c = cs.findCarro(id);
			return Response.status(Response.Status.OK)
					.entity(c)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}


		@PUT
		@Path("/updateCarro")
		public Response updateBook(Carro carro) {
			Carro updateCarro = cs.updateCarro(carro.getId(),carro.getMarca(),carro.getModelo(),carro.getAno(),carro.getTipo(),carro.getCavalos(),carro.getAutonomia(),carro.getDescricao(),carro.getPrecoVenda(), null, false);
			
			return Response.status(Response.Status.OK)
					.entity(updateCarro)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
	
		
		@DELETE
		@Path("/deleteCarro/{id}")
		public Response deleteCarro(@PathParam("id") int id) {
			CarroService responsedelete = cs.removeCarro(id);
			
			return Response.status(Response.Status.OK)
					.entity(responsedelete)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
}
