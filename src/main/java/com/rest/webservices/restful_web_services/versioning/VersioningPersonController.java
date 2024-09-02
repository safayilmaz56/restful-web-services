package com.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class VersioningPersonController {

    // URI ile versiyonlama
    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Safa Yılmaz");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2("Safa" , "Yılmaz");
    }

    // Request Parameter ile versiyonlama
    @GetMapping(path = "/person" , params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Safa Yılmaz");
    }

    @GetMapping(path = "/person" , params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2("Safa" , "Yılmaz");
    }

    // Request Header ile versiyonlama
    @GetMapping(path = "/person/header" , headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Safa Yılmaz");
    }

    @GetMapping(path = "/person/header" , headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2("Safa" , "Yılmaz");
    }

    // Media Type ile versiyonlama
    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("Safa Yılmaz");
    }

    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2("Safa" , "Yılmaz");
    }
}
