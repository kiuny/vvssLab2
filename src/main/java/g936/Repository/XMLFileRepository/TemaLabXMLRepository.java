package g936.Repository.XMLFileRepository;

import g936.Domain.TemaLab;
import g936.Validator.TemaLabValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class TemaLabXMLRepository extends AbstractXMLRepository<Integer, TemaLab> {
    //private String fileName;

    public TemaLabXMLRepository(TemaLabValidator v, String fileName) {
        super(v, fileName);
    }

    @Override
    protected Element createElementFromEntity(Document document, TemaLab t) {
        Element root = document.getDocumentElement();
        Element e = document.createElement("tema");
        e.appendChild(createElement("id", document, t.getId().toString()));
        e.appendChild(createElement("descriere", document, t.getDescriere()));
        e.appendChild(createElement("saptamanaLimita", document, Integer.toString(t.getTermenLimita())));
        e.appendChild(createElement("saptamanaPredarii", document, Integer.toString(t.getSaptammanaPredarii())));
        return e;
    }


    @Override
    protected TemaLab createEntityFromElement(Element temaLabElement) {
        String nr = temaLabElement.getAttribute("nr");
        String descr = temaLabElement
                .getElementsByTagName("descriere")
                .item(0)
                .getTextContent();
        String sptLim = temaLabElement
                .getElementsByTagName("saptamanaLimita")
                .item(0)
                .getTextContent();
        String sptPrd = temaLabElement
                .getElementsByTagName("saptamanaPredarii")
                .item(0)
                .getTextContent();

        return new TemaLab(Integer.parseInt(nr), descr, Integer.parseInt(sptLim), Integer.parseInt(sptPrd));
    }

    @Override
    public TemaLab extractEntity(String[] params) {
        return new TemaLab(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
    }
}