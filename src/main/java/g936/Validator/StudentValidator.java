package g936.Validator;

import g936.Domain.Student;
import g936.Exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors = "";
        if (s.getId().equals("")) {
            //throw new ValidatorException("Id invalid\n");
            errors += "Id invalid\n";
        }
        if (s.getNume().equals("") || s.getNume() == null) {
            //throw new ValidatorException("Nume invalid\n");
            errors += "Nume invalid\n";
        }
        if (s.getGrupa() < 0) {
            //throw new ValidatorException("Grupa invalida\n");
            errors += "Grupa invalid\n";
        }
        if (s.getEmail().equals("") || s.getEmail() == null || !s.getEmail().matches("\\w+\\S*@\\S+.\\S")) {
            //throw new ValidatorException("Email invalid\n");
            errors += "Email invalid\n";
        }
        if (s.getIndrumator() == null || s.getIndrumator().isEmpty()) {
            errors += "Profesor invalid\n";
        }
        if (errors.length() != 0) {
            throw new ValidatorException(errors);
        }
    }
}