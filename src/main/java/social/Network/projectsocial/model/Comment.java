package social.Network.projectsocial.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "comments")
public class Comment extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String content;

    @ManyToOne
    @NotEmpty
    @JoinColumn(name = "post", nullable = false)
    private Post post;

}
