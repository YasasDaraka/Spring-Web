package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class D_Validate_Path_Variables_Controller {
    //01) RegEx Validation path
    @GetMapping(path = "/myName/{name:[A-Z]{1}[a-z]{4}}")
    public String getMapping1(@PathVariable String name) {
        return "Get Mapping Invoked 1 " + name;
    }

    @GetMapping(path = "/myNumbers/{numbers:[0-9]{5}}")
    public String getMapping2(@PathVariable String numbers) {
        return "Get Mapping Invoked 2 " + numbers;
    }

    //02) Single Character Validations
    @GetMapping(path = "/i?d")
    public String getMapping3() {
        return "Get Mapping Invoked 3";
    }

    @GetMapping(path = "/id??/nam??e")
    public String getMapping4() {
        return "Get Mapping Invoked 4";
    }

    @GetMapping(path = "/id/???")
    public String getMapping5() {
        return "Get Mapping Invoked 5";
    }

    //03) Single Wild Card Validator (wildcard mapping)
    //one or more characters inside a segment
    @GetMapping(path = "/my/name/*/end")
    public String getMapping6() {
        return "Get Mapping Invoked 6";
    }

    //04) Multiple Wild Card Validator (Dual wildcard mapping)
    //zero or more segments with unlimited characters
    @GetMapping(path = "/my/address/**/end")
    public String getMapping7() {
        return "Get Mapping Invoked 7";
    }
}
