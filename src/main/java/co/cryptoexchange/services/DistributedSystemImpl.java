package co.cryptoexchange.services;

import co.cryptoexchange.data.DistributedSystemRepository;
import co.cryptoexchange.model.DistributedSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistributedSystemImpl implements DistributedSystemService {

    @Autowired
    private DistributedSystemRepository dsRepository;

    public Optional<DistributedSystem> getSystem(){
        return dsRepository.findById(1l);
    }

    @Override
    public DistributedSystem save(DistributedSystem ds) {
        return dsRepository.saveAndFlush(ds);
    }

}
