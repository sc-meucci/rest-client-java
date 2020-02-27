package rest;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

public class RestClient {

    private String remoteUrl;
    private Client client;

    public RestClient(String remoteUrl) {
        this.remoteUrl = remoteUrl;
        this.client = ClientBuilder.newClient();
        this.remoteUrl = remoteUrl;
    }

    public String getEmployee(int id) {
        return client
                .target(remoteUrl)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public String getEmployees() {
        return client
                .target(remoteUrl)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public Response deleteEmployee(int id) {
        return client
                .target(remoteUrl)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }

    public Response addEmployee(Employee employee) {
        return client
                .target(remoteUrl)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(employee, MediaType.APPLICATION_JSON));
    }

    
    public Response updateEmployee(Employee employee) {
        return client
                .target(remoteUrl)
                .path(String.valueOf(employee.getEmployeeId()))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(employee, MediaType.APPLICATION_JSON));
    }


}
