package dbRecorder.main.web;

import dbRecorder.main.model.FileData;
import dbRecorder.main.service.FileDataService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/filedata")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Controller
public class FileDataController {

    @Autowired
    FileDataService fileDataService;

    @Operation(summary = "Showing list of FileData")
    @GetMapping("/list")
    @PreAuthorize("permitAll")
    public ResponseEntity getFileData(){
        return new ResponseEntity(fileDataService.getAllFileData(), HttpStatus.OK);
    }

    @Operation(summary = "Gets a FileData after a given id")
    @GetMapping("/list/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity getFileDataById(@PathVariable Long id){
        return new ResponseEntity(fileDataService.getFileDataById(id), HttpStatus.OK);
    }

    @Operation(summary = "Adding new FileData object to db")
    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addFileData(@RequestBody FileData fileData){
        return new ResponseEntity(fileDataService.addFileData(fileData), HttpStatus.OK);
    }

    @Operation(summary = "Deleting FileData object from db, after given id")
    @DeleteMapping
    @PreAuthorize("permitAll")
    public ResponseEntity deleteFileData(@PathVariable Long id){
        fileDataService.deleteFileData(id);
        return new ResponseEntity("File Data with id: " + id + "delete successful", HttpStatus.OK);
    }

    @Operation(summary = "Gets a File by name")
    @GetMapping("/list/name/{originalFileName}")
    @PreAuthorize("permitAll")
    public ResponseEntity getFileDataByOriginalName(@PathVariable String originalFileName){
        return new ResponseEntity(fileDataService.findFileDataByName(originalFileName), HttpStatus.OK);
    }

    @Operation(summary = "Gets File by AddedDay (Date)")
    @GetMapping("/list/date/{addedDay}")
    @PreAuthorize("permitAll")
    public ResponseEntity getFileByAddedDay(@PathVariable Date addedDay){
        return new ResponseEntity(fileDataService.findFileDataByAddedDay(addedDay), HttpStatus.OK);
    }
    @Operation(summary = "Getting File by  content type")
    @GetMapping("/list/content/{contentType}")
    public ResponseEntity getFileByContentType(@PathVariable String contentType){
        return new ResponseEntity(fileDataService.findFileDataByContentType(contentType), HttpStatus.OK);

    }
}
