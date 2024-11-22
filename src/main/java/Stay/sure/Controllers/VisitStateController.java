package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.VisitStateDTO;
import Stay.sure.Servicies.VisitStateService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/visitState")
public class VisitStateController {

    @Autowired
    VisitStateService visitStateService;

    public VisitStateController(VisitStateService visitStateService) {
        this.visitStateService = visitStateService;
    }

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(VisitStateDTO visitState) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitStateDTO savedVisitState =  visitStateService.save(visitState);
        if(savedVisitState != null) {
            result.put("visitState", savedVisitState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(VisitStateDTO visitState) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitStateDTO updatedVisitState =  visitStateService.update(visitState);
        if(updatedVisitState != null) {
            result.put("visitState", updatedVisitState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(@PathVariable("id") Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitStateDTO foundVisitState =  visitStateService.findById(id);
        if(foundVisitState != null) {
            result.put("visitState", foundVisitState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<HashMap<String, Object>> getByName(@RequestParam String param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        VisitStateDTO foundVisitState =  visitStateService.findByName(param);
        if(foundVisitState != null) {
            result.put("visitState", foundVisitState);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
