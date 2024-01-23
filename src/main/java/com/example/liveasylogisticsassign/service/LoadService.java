package com.example.liveasylogisticsassign.service;

import com.example.liveasylogisticsassign.entity.Load;
import com.example.liveasylogisticsassign.exception.CustomException;
import com.example.liveasylogisticsassign.repo.LoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LoadService {

    private LoadRepository loadRepository;

    public Load saveLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(Long id) {
        return loadRepository.findById(id).orElseThrow(() -> new CustomException("Load does not exist"));
    }

    public Load updateLoad(Long id, Load load) {
        Load existingLoad = getLoadById(id);
        if (existingLoad != null) {
            existingLoad.setLoadingPoint(load.getLoadingPoint());
            existingLoad.setUnloadingPoint(load.getUnloadingPoint());
            existingLoad.setProductType(load.getProductType());
            existingLoad.setTruckType(load.getTruckType());
            existingLoad.setNoOfTrucks(load.getNoOfTrucks());
            existingLoad.setWeight(load.getWeight());
            existingLoad.setComment(load.getComment());
            existingLoad.setDate(load.getDate());
            return loadRepository.save(existingLoad);
        }
        return null;
    }

    public void deleteLoad(Long id) {
        Load existingLoad = getLoadById(id);
        if (existingLoad != null)
            loadRepository.deleteById(id);
    }
}
