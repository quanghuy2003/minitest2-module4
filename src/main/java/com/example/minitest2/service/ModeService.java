package com.example.minitest2.service;

import com.example.minitest2.model.Mode;
import com.example.minitest2.repository.ModeRepository;
import com.example.minitest2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeService implements IModeService{

    @Autowired
    private ModeRepository modeRepository;
    @Override
    public void save(Mode mode) {
        modeRepository.save(mode);
    }

    @Override
    public Iterable<Mode> findAll() {
        return modeRepository.findAll();
    }

    @Override
    public Optional<Mode> findById(Long id) {
        return modeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        modeRepository.deleteById(id);
    }
}
