import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import training.internet.banking.entity.Nasabah;
import training.internet.banking.repository.NasabahRepository;
import training.internet.banking.repository.NasabahRepositoryImpl;

import java.sql.Connection;

public class RepositoryTest {
    NasabahRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new NasabahRepositoryImpl();
    }

    @Test
    void testConnection() {
        Assertions.assertEquals(true, repository.connect());
        Assertions.assertEquals(true, repository.disconnect());
    }

    @Test
    void testInsert() {
        Nasabah nasabah = Mockito.mock(Nasabah.class);
        Mockito.when(nasabah.getName()).thenReturn("Rizal");
        Mockito.when(nasabah.getEmail()).thenReturn("Purnama");

        repository.insert(nasabah);

        Mockito.verify(nasabah, Mockito.times(1)).getName();
        Mockito.verify(nasabah, Mockito.times(1)).getEmail();
    }


}
