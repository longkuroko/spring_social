package social.Network.projectsocial.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table
@Data
@NoArgsConstructor
public class Post extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String content;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

//    private Timestamp createdAt;
//    private Timestamp updateAt;

}
