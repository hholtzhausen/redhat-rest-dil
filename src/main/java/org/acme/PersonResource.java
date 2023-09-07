package org.acme;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.examples.person.*;

@Path("/person")
@Consumes({"application/json","application/xml"})
@Produces({"application/json","application/xml"})
public interface PersonResource
{
  @POST
  public Status createPerson(Person person);
}
