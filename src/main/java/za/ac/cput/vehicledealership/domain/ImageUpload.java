package za.ac.cput.vehicledealership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class ImageUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] data;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    @JsonIgnore
    private Branch branch;


}
