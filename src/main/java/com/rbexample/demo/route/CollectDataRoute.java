package com.rbexample.demo.route;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.rbexample.demo.bean.User;

@Component
public class CollectDataRoute extends RouteBuilder {

	public static final String DIRECT_USER_ROUTE = "direct:userRoute";
	public static final String DIRECT_USER_BY_COUNTRY_IN = "direct:userCountryIn";
	public static final String DIRECT_USER_BY_COUNTRY_UK = "direct:userCountryUk";
	public static final String DIRECT_USER_BY_AGE = "direct:userAge";
	public static final String DIRECT_USER_BY_TITLE = "direct:userTitle";

	@Override
	public void configure() throws Exception {
		
		onException(Exception.class)
		.logStackTrace(true)
		.end();
		
		//from("timer://userTime?delay=5000&repeatCunt=1").
		from(DIRECT_USER_ROUTE)
		.routeId(DIRECT_USER_ROUTE)
		.tracing("true")
		.multicast(new UserAggregationStrategy())
		.to(DIRECT_USER_BY_COUNTRY_IN)
		.to(DIRECT_USER_BY_AGE)
		.to(DIRECT_USER_BY_TITLE)
		.to(DIRECT_USER_BY_COUNTRY_UK)
		.end()
		.to("log:level=INFO&showBody=true");
		//.bean(CollectDataRoute.class, "userData");
		
		from(DIRECT_USER_BY_COUNTRY_IN)
		.setHeader("country", constant("IN"))
		.to("mybatis:getUserByCountry?statementType=SelectList&inputHeader=country")
		.end();
		
		from(DIRECT_USER_BY_AGE)
		.setHeader("age", constant(30))
		.to("mybatis:getUserByAge?statementType=SelectList&inputHeader=age")
		.end();
		
		from(DIRECT_USER_BY_TITLE)
		.setHeader("title", constant("E"))
		.to("mybatis:getUserByTitle?statementType=SelectList&inputHeader=title")
		.end();
		
		from(DIRECT_USER_BY_COUNTRY_UK)
		.setHeader("country", constant("UK"))
		.to("mybatis:getUserByCountry?statementType=SelectList&inputHeader=country")
		.end();

	}
	
	@SuppressWarnings("unchecked")
	@Handler
	public void userData(Exchange exchange){
		List<User> body = exchange.getIn().getBody(List.class);
		body.forEach(u -> System.out.println("\t User: "+ u));
	}

}
