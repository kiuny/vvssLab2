package g936.UI;

import g936.Exceptions.ServiceException;
import g936.Exceptions.ValidatorException;
import g936.Service.XMLFileService.AbstractXMLService;
import g936.Service.XMLFileService.NotaXMLService;
import g936.Service.XMLFileService.StudentXMLService;
import g936.Service.XMLFileService.TemaLabXMLService;

import java.io.IOException;
import java.util.Scanner;

public class ui {
    StudentXMLService studentService;
    TemaLabXMLService temaLabService;
    NotaXMLService notaService;

    public ui(StudentXMLService srv1, TemaLabXMLService srv2, NotaXMLService srv3) {
        this.studentService = srv1;
        this.temaLabService = srv2;
        this.notaService = srv3;

    }

    /*
    public void printAllEntities(AbstractService srv){
        srv.getAll().forEach(x-> System.out.println(x));
    }
    */

    public void printAllEntities(AbstractXMLService srv) {
        srv.findAll().forEach(x -> System.out.println(x));
    }


    public void addStudent() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id, nume, grupa, email, prof;
        System.out.println("Id student:");
        id = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Nume student:");
        nume = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Grupa:");
        grupa = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Email:");
        email = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Profesor indrumator:");
        prof = scanner.nextLine();
        //scanner.nextLine();
        String[] params = {id, nume, grupa, email, prof};
        try {
            studentService.add(params);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public void addHomework() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id, descr, saptLim, saptPred;
        System.out.println("Nr tema:");
        id = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Descriere tema:");
        descr = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Saptamana limita:");
        saptLim = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Saptamana predarii:");
        saptPred = scanner.nextLine();
        //scanner.nextLine();
        String[] params = {id, descr, saptLim, saptPred};
        try {
            temaLabService.add(params);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addNota() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id, ids, idt, val, data;
        System.out.println("Id nota:");
        id = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Id student:");
        ids = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Id tema:");
        idt = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Valoare:");
        val = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Data:");
        data = scanner.nextLine();
        //scanner.nextLine();
        String val1 = notaService.depunctare(temaLabService, idt, val);
        String[] params = {id, ids, idt, val1, data};
        try {
            notaService.add(params);
            notaService.printAllNotes(temaLabService);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delStudent() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id;
        System.out.println("Id student:");
        id = scanner.nextLine();
        try {
            studentService.remove(id);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void delHomework() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        Integer id;
        System.out.println("Id student:");
        id = scanner.nextInt();
        try {
            temaLabService.remove(id);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void updStudent() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id, numenou, grupanou, emailnou, profnou;
        System.out.println("Id student:");
        id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nume student nou:");
        numenou = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Grupa noua:");
        grupanou = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Email nou:");
        emailnou = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Profesor indrumator nou:");
        profnou = scanner.nextLine();
        scanner.nextLine();
        String[] params = {id, numenou, grupanou, emailnou, profnou};
        studentService.update(params);
    }


    public void prelungireDeadLine() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id, descr, saptLim, saptPred;
        int saptCurenta;
        System.out.println("Nr tema:");
        id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Descriere tema:");
        descr = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saptamana limita:");
        saptLim = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saptamana predarii:");
        saptPred = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saptamana curenta:");
        saptCurenta = scanner.nextInt();
        scanner.nextLine();
        //String[] params={id,descr,saptLim,saptPred};
        try {
            temaLabService.prelungireTemaLab(id, descr, saptLim, saptPred, saptCurenta);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void run() throws ValidatorException, IOException {
        Scanner scanner = new Scanner(System.in);

        // try {
        while (true) {
            System.out.println("=======================================================");
            System.out.println("1a--Adaugare student         1b--Adaugare tema");
            System.out.println("2a--Stergere student         2b--Stergere tema");
            System.out.println("3a--Actualizare student      3b--Prelungire termen tema");
            System.out.println("4a--Afisare studenti         4b--Afisare studenti");
            System.out.println("5--Adaugare nota");
            System.out.println("6--Afisare note");
            System.out.println("7--Stop");
            System.out.println("=======================================================");
            System.out.println("Alegeti optiunea:");
            String opt = scanner.nextLine();
            if (opt.equals("1a")) {
                this.addStudent();
            } else if (opt.equals("2a")) {
                this.delStudent();
            } else if (opt.equals("3a")) {
                this.updStudent();
            } else if (opt.equals("4a")) {
                this.printAllEntities(studentService);
            } else if (opt.equals("1b")) {
                this.addHomework();
            } else if (opt.equals("2b")) {
                this.delHomework();
            } else if (opt.equals("3b")) {
                this.prelungireDeadLine();
            } else if (opt.equals("4b")) {
                this.printAllEntities(temaLabService);
            } else if (opt.equals("5")) {
                this.addNota();
            } else if (opt.equals("6")) {
                //this.printAllNotes();
            } else if (opt.equals("7")) {
                break;
            } else {
                System.out.println("Optiune invalida!");
            }
        }
        //} catch (ServiceException ex) {
        //  System.out.println(ex.getMessage());
        //} catch (RepositoryException ex) {
        //System.out.println(ex.getMessage());
        //} catch (ValidatorException e) {
        //  System.out.println(e.getMessage());
        //}

    }
}
