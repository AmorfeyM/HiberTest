package org.example.Entity;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int playtime;

    @ManyToMany(mappedBy = "games")
    @ToString.Exclude
    @Builder.Default
    private List<Player> players = new ArrayList<>();

    public void setPlayer(Player player) {
        players.add(player);
    }

}


