package ru.rzd;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        Structure body = exchange.getIn().getBody(Structure.class);

        byte[] result = Base64.getDecoder().decode(body.getZip());

        List<Detail> listFile = unzip(result);

        exchange.getIn().setBody(listFile);
    }

    private List<Detail> unzip(byte[] byteZip) {
        List<Detail> files = new ArrayList<>();
        InputStream inputStream = new ByteArrayInputStream(byteZip);
        try {
            ZipInputStream zin = new ZipInputStream(inputStream);
            ZipEntry entry = null;
            while((entry = zin.getNextEntry()) != null) {
                File file = new File(entry.getName());
                FileOutputStream os = new FileOutputStream(file);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    os.write(c);
                }
                os.close();
                Detail detail = convertFileToDetail(file);

                files.add(detail);
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return files;
    }

    private Detail convertFileToDetail(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Detail.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (Detail) jaxbUnmarshaller.unmarshal(file);
    }
}
