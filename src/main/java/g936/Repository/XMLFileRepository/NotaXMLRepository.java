package g936.Repository.XMLFileRepository;

import g936.Domain.Nota;
import g936.Validator.NotaValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.time.LocalDateTime;


public class NotaXMLRepository extends AbstractXMLRepository<Integer, Nota> {
    //private String fileName;

    public NotaXMLRepository(NotaValidator v, String fileName) {
        super(v, fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document, Nota n) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("nota");
        e.appendChild(createElement("id", document, n.getId().toString()));
        e.appendChild(createElement("idStudent", document, n.getStudentId()));
        e.appendChild(createElement("idTemaLab", document, Integer.toString(n.getTemaLabId())));
        e.appendChild(createElement("valoare", document, Double.toString(n.getValoare())));
        e.appendChild(createElement("data", document, n.getLdt().toString()));
        return e;
    }


    @Override
    protected Nota createEntityFromElement(Element notaElement) {
        String id = notaElement.getAttribute("id");
        String idStudent = notaElement
                .getElementsByTagName("idStudent")
                .item(0)
                .getTextContent();
        String idTemaLab = notaElement
                .getElementsByTagName("idTemaLab")
                .item(0)
                .getTextContent();
        String val = notaElement
                .getElementsByTagName("valoare")
                .item(0)
                .getTextContent();
        String data = notaElement
                .getElementsByTagName("data")
                .item(0)
                .getTextContent();

        return new Nota(Integer.parseInt(id), idStudent, Integer.parseInt(idTemaLab), Double.parseDouble(val), LocalDateTime.parse(data));
    }


    @Override
    public Nota extractEntity(String[] params) {
        Nota n = new Nota(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Double.parseDouble(params[3]), LocalDateTime.parse(params[4]));
        return n;
    }
}