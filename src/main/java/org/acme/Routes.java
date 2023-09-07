package org.acme;

//import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.rest.RestBindingMode;

import org.examples.person.Person;


//@ApplicationScoped
public class Routes extends RouteBuilder
{
  public void configure() throws Exception
  {
    restConfiguration().bindingMode(RestBindingMode.json);

    rest("/restdsl/person")
          .post()
          .type(Person.class)
          .to("direct:restDslPerson");

    from("direct:restDslPerson")
      .to("seda:mockQueue")
      .to("dataformat:jaxb:unmarshal?contextPath=org.examples.person")
    .end();
  }
}
