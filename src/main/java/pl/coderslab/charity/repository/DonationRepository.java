package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("SELECT SUM(d.quantity) FROM Donation d")
    long sumQuantity();
    @Query("SELECT d FROM Donation d LEFT JOIN FETCH d.categories WHERE d.id=?1")
    Donation findByIdWithCategories(long id);
    @Query("SELECT d FROM Donation d LEFT JOIN FETCH d.categories")
    List<Donation> findAllWithCategories();
}
