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
    private PostServiceImpl postService;
    private BranchServiceImpl branchService;

    @Autowired
    public ImageUploadServiceImpl(EmployeeRepository employeeRepository, ImageUploadRepository imageUploadRepository, PostServiceImpl postService, BranchServiceImpl branchService) {
        this.employeeRepository = employeeRepository;
        this.imageUploadRepository = imageUploadRepository;
        this.postService = postService;
        this.branchService = branchService;
    }

    @Override
    public ImageUpload uploadImage(byte[] data, int id, Object type) {

        System.out.println("in upload post img");
        ImageUpload imageUpload = new ImageUpload();

        if(data != null) {
            System.out.println("data is not null");
            if(type instanceof Post) {
                System.out.println("upload is for a post");
                Post post = postService.read(id);


                if(post!=null) {
                    imageUpload.setData(data);
                    imageUpload.setPost(post);
                    post.setImageUpload(imageUpload);

                    return imageUploadRepository.save(imageUpload);
                }

            } else if(type instanceof Branch) {
                System.out.println("upload is for a branch");
                Branch branch = branchService.read(id);

                if(branch!=null) {
                    imageUpload.setData(data);
                    imageUpload.setBranch(branch);

                    System.out.println("image data");
                    System.out.println(imageUpload);
                    return imageUploadRepository.save(imageUpload);
                }
            }
        }

        return imageUpload;

    }

    @Override
    public ImageUpload getImageById(int id) {
        return imageUploadRepository.findById(id).orElse(null);
    }
}
