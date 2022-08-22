package pat123.pat123.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pat123.pat123.entities.Patients;
import pat123.pat123.repositories.Patientrepositorie;

import java.util.List;
@AllArgsConstructor
@Controller
public class PatientController {
    private Patientrepositorie patientrepositorie;
    @GetMapping(path = "/index")
    public  String patientss(Model model,
                             @RequestParam(name = "page",defaultValue ="0" )int page,
                             @RequestParam(name = "size",defaultValue = "6")int size
    ){
        Page<Patients> Pagepatients=patientrepositorie.findAll(PageRequest.of(page,size));
        model.addAttribute("listePatients",Pagepatients.getContent());
        model.addAttribute("pages", new int[Pagepatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        return  "patients";
    }
}
