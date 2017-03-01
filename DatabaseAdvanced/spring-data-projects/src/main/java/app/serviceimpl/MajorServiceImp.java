package app.serviceimpl;

import app.dao.ManajorDao;
import app.domain.Major;
import app.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cefothe on 09.12.16.
 */
@Service
public class MajorServiceImp implements MajorService {

    @Autowired
    private ManajorDao manajorDao;

    @Override
    public void create(Major major) {
        this.manajorDao.saveAndFlush(major);
    }
}
