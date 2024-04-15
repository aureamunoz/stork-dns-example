package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * A frontend API using our REST Client (which uses Stork to locate and select the service instance on each call).
 */
@Path("/api")
public class FrontendApi {

    @RestClient MyService service;

    @RestClient MvnService mvnService;
    @RestClient GithubService githubService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String invoke() {
        return service.get();
    }

    @GET
    @Path("/mvn")
//    @Produces(MediaType.TEXT_PLAIN)
    public String mvn() {
        return mvnService.get();
    }

    @GET
    @Path("/github")
//    @Produces(MediaType.TEXT_PLAIN)
    public String github() {
        return githubService.get();
    }

}
