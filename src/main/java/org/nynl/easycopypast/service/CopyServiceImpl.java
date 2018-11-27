package org.nynl.easycopypast.service;

import org.nynl.easycopypast.model.Copy;
import org.nynl.easycopypast.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pdfService")
@Transactional
public class CopyServiceImpl implements CopyService {

    @Autowired
    CopyRepository copyRepository;

    @Override
    public List<Copy> getcopies() {
        return copyRepository.getCopies();
    }


}