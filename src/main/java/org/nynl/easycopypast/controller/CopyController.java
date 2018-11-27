package org.nynl.easycopypast.controller;

import org.nynl.easycopypast.model.Copy;
import org.nynl.easycopypast.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "copy")
public class CopyController {

    @Autowired
    CopyService copyService;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Copy> getAllCopies(){
        return copyService.getcopies();
    }

}