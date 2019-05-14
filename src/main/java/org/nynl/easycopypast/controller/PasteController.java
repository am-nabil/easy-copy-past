package org.nynl.easycopypast.controller;

import org.nynl.easycopypast.model.Copy;
import org.nynl.easycopypast.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/paste")
public class PasteController {

    @Autowired
    CopyService copyService;

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String paste(Principal principal){
        String username = principal.getName();
        return copyService.paste(username);
    }

}