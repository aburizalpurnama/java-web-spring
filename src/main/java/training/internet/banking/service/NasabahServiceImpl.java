package training.internet.banking.service;

import training.internet.banking.entity.Nasabah;
import training.internet.banking.helper.Config;
import training.internet.banking.helper.DatabaseHelper;
import training.internet.banking.repository.NasabahRepository;
import training.internet.banking.repository.NasabahRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NasabahServiceImpl implements NasabahService{

    NasabahRepository nasabahRepository = new NasabahRepositoryImpl(DatabaseHelper.connect());
    @Override
    public void addNasabah(String name, String email) {
        Nasabah nasabah = new Nasabah();
        nasabahRepository.insert(nasabah);
    }
}
