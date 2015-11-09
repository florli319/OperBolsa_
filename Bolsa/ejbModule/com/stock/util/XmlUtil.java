package com.stock.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.stock.dto.ActionDTO;

public class XmlUtil {
	
	/**
	 * Método que transforma un objeto a un xml
	 */
	public static void marshallObtjectToXml(String pathFile){

			  ActionDTO actionDTO = new ActionDTO();
			  actionDTO.setEmpresa(" AAA " );
			  actionDTO.setPrecioCompra(100.0);

			  try {

				File file = new File(pathFile);
				JAXBContext jaxbContext = JAXBContext.newInstance(ActionDTO.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				jaxbMarshaller.marshal(actionDTO, file);
				jaxbMarshaller.marshal(actionDTO, System.out);

			      } catch (JAXBException e) {
				e.printStackTrace();
			      }

	}
	
	/**
	 * Método que transforma un xml a un objeto
	 */
	public static Object unmarshallXmlToObject(Class clase, String pathFile){
		 try {

				File file = new File(pathFile);
				JAXBContext jaxbContext = JAXBContext.newInstance(clase);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Object obj = (Object) jaxbUnmarshaller.unmarshal(file);
				System.out.println(obj);

				return obj;
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
		 return null;
	}
	
	public void test(){
		ActionDTO actionDTO = (ActionDTO) unmarshallXmlToObject(ActionDTO.class, "D:\\especializacion\\Doc xml patrones\\file.xml");
		System.out.println("sirvio " + actionDTO.getEmpresa());
	}
	public static void main(String[] args) {
		new XmlUtil().test();
	}

}
