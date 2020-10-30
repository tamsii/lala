package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
@Repository
public class BalloonRepository {
    List<Balloon> balloons = new ArrayList<>(10);

    public List<Balloon> findAllBalloons(){
        return balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        return balloons.stream().filter(r->r.getName().contains(text)||r.getDescription().contains(text)).collect(Collectors.toList());
    }

}
