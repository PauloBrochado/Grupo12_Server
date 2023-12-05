package RestServer;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Path;

import com.google.gson.Gson;

import stand.Cliente;
import stand.Carro;
import stand.CarroService;
import stand.Vendedor;
import stand.VendedorService;

@Path("/carro/admin")
public class AdminTestHttpURLConnection {

    public static void main(String[] args) {
       
    }

    // a funcionar
    private static void addCarro() {
        HttpURLConnection conn = null;
        Gson gson = new Gson();

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/eletro/addCarro");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);
            con.setDoInput(true);

            String postData = gson.toJson(new Carro(0, "Marca1", "Modelo1", 2023, "Tipo1", 200, 500, "Descrição1", 25000.0, null, true), Carro.class);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();

            if (con.getResponseCode() < 200 || con.getResponseCode() > 299) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                getCarro();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    private static void getCarro() {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/eletro/getCarro");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            Gson gson = new Gson();
            List<Carro> carro = Arrays.asList(gson.fromJson(br, Carro[].class));
            System.out.println("Output JSON from Server .... \n");
            for (Carro ca : carro) {
                System.out.println(ca);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    
    private static void deleteCarro(int id) {
		HttpURLConnection conn = null;

		try {

			URL url = new URL("http://localhost:8080/RestServerLPOFC/eletro/deleteCarro/" + Integer.toString(id));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");

			if (con.getResponseCode() < 200 && con.getResponseCode() > 299) {
				throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
			} else {
				getCarro();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
    
    private static void addCliente() {
        HttpURLConnection conn = null;
        Gson gson = new Gson();

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/cliente/addCliente");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);
            con.setDoInput(true);

            String postData = gson.toJson(new Cliente(0, "abc123", "cliente1@upt.pt", "Paulo", 5), Carro.class);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();

            if (con.getResponseCode() < 200 || con.getResponseCode() > 299) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                getCliente1();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
 
    
    
    private static void getCliente1() {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/cliente/getCliente1");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            Gson gson = new Gson();
            List<Cliente> clientes = Arrays.asList(gson.fromJson(br, Cliente[].class));
            System.out.println("Output JSON from Server .... \n");
            for (Cliente cl : clientes) {
                System.out.println(cl);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private static void listCarros() {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/stockmanager/listCarros");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            Gson gson = new Gson();
            List<Carro> carro = Arrays.asList(gson.fromJson(br, Carro[].class));
            System.out.println("Imprimindo Stock .... \n");
                System.out.println(carro);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    
    
    private static void getCliente() {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/cliente/getCliente");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            Gson gson = new Gson();
            List<Cliente> clientes = Arrays.asList(gson.fromJson(br, Cliente[].class));
            System.out.println("Imprimindo Clientes .... \n");

            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    
    private static void getCarroId_ad(int id) {
		HttpURLConnection conn = null;

		try {

			URL url = new URL("http://localhost:8080/RestServerLPOFC/eletro/getCarroId_ad/" + Integer.toString(id));
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.connect();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			Gson gson = new Gson();
			Carro carro = gson.fromJson(br, Carro.class);
			System.out.println("Output JSON from Server .... \n");
			System.out.println(carro);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
    
    private static void updateCarro(int id, String marca, String modelo, int ano,String descricao,String tipo,int cavalos, int autonomia,int precoVenda) {
        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/stockmanager/updateStock/" + id );
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);
            con.setDoInput(true);

            if (con.getResponseCode() < 200 || con.getResponseCode() > 299) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                System.out.println("Carro updated successfully!");
                // Adicione aqui qualquer lógica adicional que você deseja executar após a atualização do estoque
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    private static void updateCarro() {
        HttpURLConnection conn = null;
        Gson gson = new Gson();

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/eletro/updateCarro");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);
            con.setDoInput(true);

            String postData = gson.toJson(new Carro(0, "Marca2", "Modelo1", 2020, "Tipo1", 200, 500, "Descrição1", 25000.0, null, true),
                   Carro.class);

            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();

            if (con.getResponseCode() < 200 || con.getResponseCode() > 299) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                getCarro();
                listCarros();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }   
   
    
    private static void removedCarro(int id) {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/stockmanager/removeCarro/"
                    + Integer.toString(id));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            if (con.getResponseCode() < 200 || con.getResponseCode() > 299) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                listCarros();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // a funcionar
    private static void addCarro(int id, String marca, String modelo, int ano,String descricao,String tipo,int cavalos, int autonomia,int precoVenda) {
        HttpURLConnection conn = null;
        Gson gson = new Gson();

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/stockmanager/addCarro");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);
            con.setDoInput(true);

            String postData = gson.toJson(new Carro(0, "Marca1", "Modelo1", 2023, "Tipo1", 200, 500, "Descrição1", 25000.0, null, true),
                    Carro.class);
            
            CarroService cs = new CarroService(null);
          
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postData);
            wr.flush();
            wr.close();

            if (con.getResponseCode() < 200 || con.getResponseCode() > 299) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            } else {
                getCarro();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // DA ELETRO PELO ID (FUNCIONAL)
    private static void getCarro_Id(int id) {
        HttpURLConnection conn = null;

        try {
            URL url = new URL("http://localhost:8080/RestServerLPOFC/eletro/getCarroId/" + Integer.toString(id));
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            Gson gson = new Gson();
            Carro carro = gson.fromJson(br, Carro.class);
            System.out.println("Output JSON from Server .... \n");
            System.out.println(carro);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    

}
