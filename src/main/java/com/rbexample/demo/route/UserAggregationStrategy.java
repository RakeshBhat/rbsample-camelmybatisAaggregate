package com.rbexample.demo.route;

import java.util.List;
import java.util.stream.Stream;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.rbexample.demo.bean.User;

public class UserAggregationStrategy implements AggregationStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public Exchange aggregate(Exchange xchgOld, Exchange xchgNew) {

		
		if(xchgOld == null){
			xchgOld = xchgNew;
		}else{
			List<User> nusers = xchgNew.getIn().getBody(List.class);
			List<User> ousers = xchgOld.getIn().getBody(List.class);
			
			Stream<User> combinedStream = Stream.concat(nusers.stream(), ousers.stream());			
			xchgOld.getIn().setBody(combinedStream, List.class);
		}
		
		return xchgOld;
	}

}
