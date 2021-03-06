package g936;


import g936.Exceptions.ValidatorException;
import org.junit.Test;

public class BigBangIntegrationTest extends AbstractIntegrationTest {


    @Test
    public void testAddStudent() throws ValidatorException {
        testAddStudentImpl();
    }

    @Test
    public void testAddAssignment() throws ValidatorException {
        testAddAssignmentImpl();
    }

    @Test
    public void testAddGrade() throws ValidatorException {
        testAddGradeImpl();
    }

    @Test
    public void testAll() throws ValidatorException {
        testAddStudentImpl();
        testAddAssignmentImpl();
        testAddGradeImpl();
    }

}
