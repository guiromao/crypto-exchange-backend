package co.cryptoexchange.services;

import co.cryptoexchange.model.DistributedSystem;

import java.util.Optional;

public interface DistributedSystemService {

    Optional<DistributedSystem> getSystem();

    DistributedSystem save(DistributedSystem ds);

}
