package com.jlouceiro;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
@Tag(name = "Labseq Resource", description = "Returns the nth number of the Labseq Sequence.")
@APIResponses({
        @APIResponse(responseCode = "200", description = "Value of the calculated Labseq Sequence at the specified index."),
        @APIResponse(responseCode = "400", description = "Invalid index. The number passed must always be positive."),
        @APIResponse(responseCode = "500", description = "Unknown server-side error.")
})
public class LabseqResource {
    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response labseq(@PathParam("n") int n) {
        return Response.ok().entity(labseqService.getLabseqResult(n)).build();
    }
}
