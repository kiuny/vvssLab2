package g936.Service.TxtFileService;

import g936.Domain.Student;
import g936.Repository.MemoryRepository.AbstractCrudRepo;
import g936.Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String, Student> {
    //StudentFileRepo stdRepo;
    public StudentService(AbstractCrudRepo<String, Student> stdRepo) {
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


