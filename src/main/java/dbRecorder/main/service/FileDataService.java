package dbRecorder.main.service;

import dbRecorder.main.model.FileData;
import dbRecorder.main.repository.FileDataRepository;
import dbRecorder.main.utils.Commons;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FileDataService extends Commons {

    @Autowired
    FileDataRepository fileDataRepository;

    @Transactional
     public List<FileData> getAllFileData(){
        return fileDataRepository.findAll();
    }
    @Transactional
    public FileData getFileDataById(Long id){
        return fileDataRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("File with this ID " + id + "not found"));
    }
    @Transactional
    public FileData addFileData(FileData fileData){
        return fileDataRepository.saveAndFlush(fileData);
    }

    @Transactional
    public void deleteFileData(Long id){
        fileDataRepository.deleteById(id);
    }

    @Transactional
    public FileData findFileDataByName(String originalFileName){
        return fileDataRepository.findFileDataByNamedParams(originalFileName);
    }

    @Transactional
    public FileData findFileDataByAddedDay(Date addedDay){
        return fileDataRepository.findFileDataByAddedDay(addedDay);
    }
    @Transactional
    public FileData findFileDataByContentType(String contentType){
        return fileDataRepository.findFileDataByContentType(contentType);
    }

}
