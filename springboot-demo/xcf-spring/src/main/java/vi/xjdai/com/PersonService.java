package vi.xjdai.com;


import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PersonService {

    public List<Person> findAll(@WebParam(name = "arg0") String name);

}
