package com.jlouceiro;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
public class LabseqResource {
    @Inject
    LabseqService labseqService;

    @GET
    // @RunOnVirtualThread
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response labseq(@PathParam("n") int n) {
        return Response.ok().entity(labseqService.getLabseqResult(n)).build();

    }
}
