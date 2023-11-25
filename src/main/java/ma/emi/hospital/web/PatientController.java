package ma.emi.hospital.web;

import lombok.AllArgsConstructor;
import ma.emi.hospital.entities.Patient;
import ma.emi.hospital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw){
        Page<Patient> pagePatient = patientRepository.findByNameContains(kw,PageRequest.of(page,size));
//        Page<Patient> pagePatient = patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listePatients",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";  // retourne la vue
    }

    @GetMapping("/delete")
    public String delete(Long id,int page, String kw){
        patientRepository.deleteById(id);
        return "redirect:/index";  //?page="+page
    }
}
