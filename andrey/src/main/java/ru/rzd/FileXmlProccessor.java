package ru.rzd;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.xml.bind.JAXBContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;

public class FileXmlProccessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        try {
            Object body = exchange.getIn().getBody();

            ByteArrayInputStream in = new ByteArrayInputStream((byte[]) body);
            ObjectInputStream is = new ObjectInputStream(in);

            JAXBContext context = JAXBContext.newInstance(Detail.class);
            Detail detail = (Detail) context.createUnmarshaller().unmarshal(is);

            exchange.getIn().setBody(detail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
