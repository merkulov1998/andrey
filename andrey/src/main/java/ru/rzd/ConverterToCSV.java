package ru.rzd;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConverterToCSV implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Detail detail = (Detail)exchange.getIn().getBody();
        String uuid = (String) exchange.getIn().getHeader("uuid");
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("uuid", uuid);
        body.put("idDetail", detail.getIdDetail());
        body.put("nameDetail", detail.getNameDetail());
        body.put("idFactory", detail.getIdFactory());

        exchange.getIn().setBody(body);
    }
}
