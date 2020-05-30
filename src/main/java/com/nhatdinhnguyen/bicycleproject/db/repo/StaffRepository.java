package com.nhatdinhnguyen.bicycleproject.db.repo;

import com.nhatdinhnguyen.bicycleproject.db.entity.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
//    List<Staff> findByManager_Id(@Param("id") int id);
    @Query("Select s from Staff s where s.manager.id=:id")
    List<Staff> searchQueryByManagerId(@Param("id")int id);
    List<Staff> findByPersonLastNameLike(@Param("likeName") String likeName);
}
