package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date createdAt = new Date();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @Size(min = 1, message = "You must choose at least 1 ingredient")
  @ManyToMany()
  private List<Ingredient> ingredients = new ArrayList<>();

  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(ingredient);
  }

  //todo make sure if you nned to create createdAt() method an annotate it with @PrePersist

}
