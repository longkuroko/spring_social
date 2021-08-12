package social.Network.projectsocial.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String content;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;



}
