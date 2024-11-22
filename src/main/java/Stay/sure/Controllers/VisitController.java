package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.VisitDTO;
import Stay.sure.Servicies.VisitService;

@RestController
@RequestMapping("/api/visit")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(VisitDTO visit) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitDTO savedVisit = visitService.save(visit);
        if (savedVisit != null) {
            result.put("visit", savedVisit);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(VisitDTO visit) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitDTO updatedVisit = visitService.update(visit);
        if (updatedVisit != null) {
            result.put("visit", updatedVisit);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitDTO foundVisit = visitService.findById(id);
        if (foundVisit != null) {
            result.put("visit", foundVisit);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
