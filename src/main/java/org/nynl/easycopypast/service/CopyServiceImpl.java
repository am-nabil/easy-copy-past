package org.nynl.easycopypast.service;

import org.nynl.easycopypast.model.Copy;
import org.nynl.easycopypast.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Override
    public void copy(String username, String content, String machine_ip) {
        if(!StringUtils.isEmpty(content)){
            copyRepository.updateOrInsertCopy(username, content, machine_ip);
        }
    }

    @Override
    public String paste(String username) {
      return copyRepository.paste(username).getContent();
    }

}