package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.ImageUpload;
import za.ac.cput.vehicledealership.domain.Post;

public interface ImageUploadRepository extends JpaRepository<ImageUpload, Integer> {
    ImageUpload findImageUploadByBranch(Branch branch);

    ImageUpload findImageUploadByPost(Post post);
}
