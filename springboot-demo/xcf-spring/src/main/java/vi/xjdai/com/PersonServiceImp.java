package vi.xjdai.com;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "vi.xjdai.com.PersonService", serviceName = "person")
public class PersonServiceImp implements PersonService {

    @Override
    public List<Person> findAll(String name) {
        ArrayList<Person> persons = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setName(name + "3");
        p1.setAge(18);
        Person p2 = new Person();
        p2.setName(name + "4");
        p2.setAge(20);

        persons.add(p1);
        persons.add(p2);

        return persons;
    }

}
