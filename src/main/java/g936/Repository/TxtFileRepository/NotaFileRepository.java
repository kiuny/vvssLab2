package g936.Repository.TxtFileRepository;

import g936.Domain.HasId;
import g936.Domain.Nota;
import g936.Validator.NotaValidator;

import java.io.IOException;
import java.time.LocalDateTime;

public class NotaFileRepository extends AbstractFileRepository {
    public NotaFileRepository(String filename, NotaValidator val) throws IOException {
        super(val, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        Integer idNota = Integer.parseInt(info[0]);
        String idStudent = info[1];
        Integer idTema = Integer.parseInt(info[2]);
        double valoare = Double.parseDouble(info[3]);
        //TemaLab t=findOne(idTema);
        LocalDateTime ldt = LocalDateTime.parse(info[4]);
        Nota n = new Nota(idNota, idStudent, idTema, valoare, ldt);
        return n;
    }


}