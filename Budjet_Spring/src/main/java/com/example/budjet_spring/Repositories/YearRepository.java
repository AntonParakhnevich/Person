package com.example.budjet_spring.Repositories;

import com.example.budjet_spring.Entity.Budget;
import com.example.budjet_spring.Entity.Family;
import com.example.budjet_spring.Entity.Month;
import com.example.budjet_spring.Entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.time.YearMonth;
import java.util.List;

/**
 * Created by .
 */
public interface YearRepository extends JpaRepository<Year, Long> {

    @Query("select b.years from Budget b where b.id=?1")
    List<Year> getYearByIdBudget(Long idBudget) throws SQLException;

    @Query("select m from Month m where m.year.id=?1")
    List<Month> getAllMonth(Long idYear) throws SQLException;

    @Query(nativeQuery = true, value = "select exists(select * from months where months.year_id=?1 and name=?2)")
    Integer existMonth(Long idYear, String nameMonth);
}
