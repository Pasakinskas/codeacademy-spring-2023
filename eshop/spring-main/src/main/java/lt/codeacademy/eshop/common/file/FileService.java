package lt.codeacademy.eshop.common.file;

import lt.codeacademy.eshop.jpa.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {

  private FileRepository repository;
  private final Path fileLocation = Paths.get("./files").toAbsolutePath().normalize();

  @Autowired
  public FileService(FileRepository repository) {
    this.repository = repository;
  }

  public void save(MultipartFile file) {
    try {
      var filename = generateFilename(file);
      var newFile = new File(filename);
      file.transferTo(newFile);

      saveFileDetailsToDatabase(file, filename);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public List<String> getTextFileContents(MultipartFile file) {
    try {
      var reader = new InputStreamReader(file.getInputStream());
      var bufferedReader = new BufferedReader(reader);
      return bufferedReader.lines().toList();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public ByteArrayResource download(String filename) {
    Path path = Paths.get(fileLocation + "/" + filename);
    try {
      return new ByteArrayResource(Files.readAllBytes(path));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public List<lt.codeacademy.eshop.jpa.entities.File> getAllFiles() {
    return repository.findAll();
  }

  private String generateFilename(MultipartFile file) {
    return fileLocation + "/" + file.getOriginalFilename();
  }

  private void saveFileDetailsToDatabase(MultipartFile file, String newFileName) {
    var fileEntry = new lt.codeacademy.eshop.jpa.entities.File(
      0L,
      file.getOriginalFilename(),
      getExtension(newFileName),
      file.getSize(),
      LocalDateTime.now()
    );
    repository.save(fileEntry);
  }

  private String getExtension(String filename) {
    return filename.substring(filename.lastIndexOf("."));
  }
}
