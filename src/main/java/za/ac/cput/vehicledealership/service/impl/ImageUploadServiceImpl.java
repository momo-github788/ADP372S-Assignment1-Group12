package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.ImageUpload;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.repository.BranchRepository;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.ImageUploadRepository;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.service.ImageUploadService;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    private ImageUploadRepository imageUploadRepository;
    private EmployeeRepository employeeRepository;
    private PostRepository postRepository;
    private PostServiceImpl postService;
    private BranchServiceImpl branchService;

    @Autowired
    public ImageUploadServiceImpl(EmployeeRepository employeeRepository, ImageUploadRepository imageUploadRepository, PostRepository postRepository, PostServiceImpl postService, BranchServiceImpl branchService) {
        this.employeeRepository = employeeRepository;
        this.imageUploadRepository = imageUploadRepository;
        this.postRepository = postRepository;
        this.postService = postService;
        this.branchService = branchService;
    }

    @Override
    public ImageUpload uploadImage(byte[] data, int id) {

        System.out.println("in upload post img");
        ImageUpload imageUpload = new ImageUpload();

        if(data != null) {
            System.out.println("data is not null");
            Post post = postService.read(id);

            if(post!=null) {
                imageUpload.setData(data);
                imageUpload.setPost(post);
                post.setImageUpload(imageUpload);

                //postRepository.save(post);
                return imageUploadRepository.save(imageUpload);
            }
        }

        return imageUpload;

    }

    @Override
    public ImageUpload getImageById(int id) {
        return imageUploadRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteImageById(int id) {
        if(this.imageUploadRepository.existsById(id)) {
            this.imageUploadRepository.deleteById(id);
            System.out.println("deleted image");
            return true;
        }
        System.out.println("could not delete image");

        return false;
    }
}
