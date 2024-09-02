package com.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class VersioningPersonController {

    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Safa Yılmaz");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2("Safa" , "Yılmaz");
    }

    @GetMapping(path = "/person" , params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Safa Yılmaz");
    }

    @GetMapping(path = "/person" , params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2("Safa" , "Yılmaz");
    }
}
