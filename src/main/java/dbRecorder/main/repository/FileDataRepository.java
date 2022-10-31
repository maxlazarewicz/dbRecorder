package dbRecorder.main.repository;

import dbRecorder.main.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Date;
import java.util.List;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {

    @Query("SELECT fl FROM FileData fl WHERE fl.originalFileName = :originalFileName")
    FileData findFileDataByNamedParams(
            @Param("originalFileName") String fileName);

    @Query("SELECT fl FROM FileData fl WHERE fl.contentType = :contentType")
    FileData findFileDataByContentType(
        @Param("contentType") String contentType);

    @Query("SELECT fl FROM FileData fl WHERE fl.addedDay = :addedDay")
    FileData findFileDataByAddedDay(
            @Param("addedDay") Date addedDay);
}



