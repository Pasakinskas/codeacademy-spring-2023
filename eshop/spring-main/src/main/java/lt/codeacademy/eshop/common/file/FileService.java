package lt.codeacademy.eshop.common.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * read info from a file
 * get file by name
 */
@Service
public class FileService {

  private final Path fileLocation = Paths.get("./files").toAbsolutePath().normalize();

  public void save(MultipartFile file) {
    try {
      new File("hello-world");
      file.transferTo(new File(fileLocation + "/" + file.getOriginalFilename()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
