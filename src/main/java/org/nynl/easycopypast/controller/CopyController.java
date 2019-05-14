package org.nynl.easycopypast.controller;

import org.nynl.easycopypast.model.Copy;
import org.nynl.easycopypast.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/copy")
public class CopyController {

    @Autowired
    CopyService copyService;

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void copy(Principal principal, @RequestHeader("CONTENT") String content, @RequestHeader("MACHINE_IP") String machine_ip ){
        String username = principal.getName();
        copyService.copy(username, content, machine_ip);
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Copy> getAllCopies(){
        return copyService.getcopies();
    }

}