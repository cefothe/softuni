package app.serviceImp;

import app.domain.dto.json.LensDTO;
import app.domain.entities.lens.Lens;
import app.io.interfaces.ConsoleIO;
import app.parser.interfaces.ModelParser;
import app.repositories.LensRepository;
import app.service.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cefothe on 11.12.16.
 */
@Service
public class LendServiceImp implements LensService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private LensRepository lensRepository;

    @Autowired
    private ConsoleIO consoleIO;

    @Override
    public void create(LensDTO lensDTO) {


        Lens lens = this.modelParser.convert(lensDTO, Lens.class);
        lensRepository.saveAndFlush(lens);
        consoleIO.write("Successfully imported "+ lens.toString());
    }
}
