package training.internet.banking.repository;

import training.internet.banking.entity.Nasabah;

import java.util.List;

public interface NasabahRepository {
    public void insert(Nasabah nasabah);
    public List<Nasabah> getAll();
    public boolean remove(String id);

}
