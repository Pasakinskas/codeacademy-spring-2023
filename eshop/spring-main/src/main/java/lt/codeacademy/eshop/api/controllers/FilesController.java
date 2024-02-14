package lt.codeacademy.eshop.api.controllers;

import lt.codeacademy.eshop.common.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FilesController {

  private FileService fileService;

  @Autowired
  public FilesController(FileService fileService) {
    this.fileService = fileService;
  }

  @PostMapping("/files/upload")
  public ResponseEntity<Void> uploadAFile(@RequestBody MultipartFile file) {
    fileService.save(file);
    return ResponseEntity.ok().build();
  }

  @PostMapping("files/contents")
  public ResponseEntity<List<String>> getFileContents(@RequestBody MultipartFile file) {
    return ResponseEntity.ok().body(fileService.getTextFileContents(file));
  }
}
