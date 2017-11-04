package com.rbexample.demo.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbexample.demo.bean.User;
import static com.rbexample.demo.route.CollectDataRoute.DIRECT_USER_ROUTE;

import java.util.List;;

@RestController
public class UserController {

	@Autowired
	CamelContext camelContext;

	@Autowired
	@Produce(uri = DIRECT_USER_ROUTE)
	private ProducerTemplate userProducerTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/user", produces = "application/json")
	public ResponseEntity<List<User>> getUserDetails() {
		List<User> users = null;
		try {

			Exchange xchg = new DefaultExchange(camelContext);
			Message msg = new DefaultMessage(camelContext);
			xchg.setIn(msg);

			userProducerTemplate.start();

			Exchange op = userProducerTemplate.send(xchg);
			users = op.getIn().getBody(List.class);
			userProducerTemplate.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
