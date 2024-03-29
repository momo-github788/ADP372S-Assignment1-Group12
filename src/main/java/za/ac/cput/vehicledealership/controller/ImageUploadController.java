package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.service.impl.ImageUploadServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class ImageUploadController {

    private ImageUploadServiceImpl imageUploadService;

    @Autowired
    public ImageUploadController(ImageUploadServiceImpl imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean status = imageUploadService.deleteImageById(id);

        if(status) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Image does not exist..");
    }
}
