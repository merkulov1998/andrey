package ru.rzd;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ZipFileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        Structure body = exchange.getIn().getBody(Structure.class);

        exchange.getOut().setBody(body.getZip());
    }
}
