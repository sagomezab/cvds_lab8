package edu.eci.cvds.servlet.backingBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGuess {
    private RepositoryGuess repo;

    @Autowired
    public void ConfigurationService(RepositoryGuess configurationRepository){
        this.repo = configurationRepository;
    }
    public ConfigurationBean addConfiguration(ConfigurationBean configutationB){
        return repo.save(configutationB);
    }
    public ConfigurationBean getConfiguration (String propiedadId){
        return repo.findById(propiedadId);
    }
    public List<ConfigurationBean> getAllConfiguration(){
        return repo.findAll();
    }
    public ConfigurationBean updateConfiguration(ConfigurationBean configutationB){
        if(repo.existsById(configutationB.getId())){
            return repo.save(configutationB);
        }
        return null;
    }

    public void deleteConfiguration(Long configurationId){
        repo.deleteById(configurationId);
    }

}
