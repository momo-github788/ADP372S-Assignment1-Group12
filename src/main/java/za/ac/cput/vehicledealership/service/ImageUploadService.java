package za.ac.cput.vehicledealership.service;

import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.vehicledealership.domain.ImageUpload;

public interface ImageUploadService {
    ImageUpload uploadImage(byte[] data, int id);
    ImageUpload getImageById(int id);
    boolean deleteImageById(int id);
}
