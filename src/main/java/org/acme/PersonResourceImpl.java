package org.acme;

import org.apache.camel.CamelContext;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;

import javax.inject.Inject;

import org.examples.person.*;

import io.bitbuild.lib.camel.support.jaxrs.JaxrsSupport;

public class PersonResourceImpl extends JaxrsSupport implements PersonResource
{
  @Inject
  CamelContext context;

  @Inject
  HttpHeaders httpHeaders;

  @Override
  public Status createPerson(Person person)
  {
    Response response = callCamelRoute("seda:personAPI?waitForTaskToComplete=Always",
                                       person,
                                       Person.class,
                                       Status.class,
                                       Status.class,200,400,
                                       httpHeaders,
                                       null,context);

    return (Status)response.getEntity();
  }
}
