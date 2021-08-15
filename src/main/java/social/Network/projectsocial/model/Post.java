package social.Network.projectsocial.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
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

    //Comment Mapping: One to many: Post -> Comments
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();


}
