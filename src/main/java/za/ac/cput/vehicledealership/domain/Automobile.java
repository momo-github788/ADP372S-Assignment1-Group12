package za.ac.cput.vehicledealership.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Automobile {
    private String name;
    private String make;
    private String plates;

}
