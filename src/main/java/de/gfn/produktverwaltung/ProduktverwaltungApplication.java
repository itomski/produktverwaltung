package de.gfn.produktverwaltung;

import de.gfn.produktverwaltung.model.Product;
import de.gfn.produktverwaltung.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class ProduktverwaltungApplication implements CommandLineRunner {

	@Autowired // Wird von Spring automatisch erzeugt und zugewiesen
	private ProductRepository repo;

	public static void main(String[] args) {
		//System.out.println(UUID.randomUUID());
		SpringApplication.run(ProduktverwaltungApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Befehle werden nach dem Start der App auf der Console des Servers ausgeführt

		/*
		repo.deleteAll(); // Löscht Altdaten
		repo.save(new Product("Milch", "3,5% Fett", 1.29, 1000, LocalDate.of(2024, 4, 15)));
		repo.save(new Product("Brot", "Vollkorn", 2.29, 100, LocalDate.of(2024, 4, 20)));
		repo.save(new Product("Butter", "Sauerrahm", 3.59, 200, LocalDate.of(2024, 4, 10)));
		*/
	}
}
