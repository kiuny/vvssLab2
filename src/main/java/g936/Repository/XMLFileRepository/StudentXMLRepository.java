package g936.Repository.XMLFileRepository;

import g936.Domain.Student;
import g936.Validator.StudentValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class StudentXMLRepository extends AbstractXMLRepository<String, Student> {
    //private String fileName;

    public StudentXMLRepository(StudentValidator v, String fileName) {
        super(v, fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document, Student s) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("student");
        e.appendChild(createElement("id", document, s.getId()));
        e.appendChild(createElement("nume", document, s.getNume()));
        e.appendChild(createElement("grupa", document, Integer.toString(s.getGrupa())));
        e.appendChild(createElement("email", document, s.getEmail()));
        e.appendChild(createElement("profesor", document, s.getIndrumator()));
        return e;
    }


    @Override
    protected Student createEntityFromElement(Element studentElement) {
        String id = studentElement
                .getAttribute("id");
        String nume = studentElement
                .getElementsByTagName("nume")
                .item(0)
                .getTextContent();
        String grupa = studentElement
                .getElementsByTagName("grupa")
                .item(0)
                .getTextContent();
        int gr = Integer.parseInt(grupa);
        String email = studentElement
                .getElementsByTagName("email")
                .item(0)
                .getTextContent();
        String prof = studentElement
                .getElementsByTagName("prof")
                .item(0)
                .getTextContent();
        return new Student(id, nume, gr, email, prof);
    }

    @Override
    public Student extractEntity(String[] params) {
        int grupa = 0;
        try {
            grupa = Integer.parseInt(params[2]);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return new Student(params[0], params[1], grupa, params[3], params[4]);
    }
}

