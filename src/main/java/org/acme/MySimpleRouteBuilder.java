package org.acme;

import javax.enterprise.context.ApplicationScoped;

import io.bitbuild.lib.camel.AbstractBaseRouteBuilder;

@ApplicationScoped
public class MySimpleRouteBuilder extends AbstractBaseRouteBuilder
{
  @Override
  protected String getBaseRouteId()
  {
    return MySimpleRouteBuilder.class.getSimpleName();
  }

   @Override
  protected int getMaximumRedeliveries()
  {
    return 0;
  }

  @Override
  protected boolean getUseOriginalMessage()
  {
    return false;
  }


  @Override
  protected boolean useDynamicAuditLogCategory()
  {
    return true;
  }


  @Override
  public void configure() throws Exception
  {
    super.configure();

    from("direct:simple")
      .routeId(getRouteId("simple"))
      .log("BODY: ${body}")
    .end();

    from("direct:myEnricher")
      .routeId(getRouteId("myEnricher"))
      .log("I am an enricher")
    .end();
  }
}
