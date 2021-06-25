package dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cards", schema = "public", catalog = "random_cards")
public class CardsEntity {
    private Boolean favor;
    private Integer countSeen;
    private Timestamp timeLastSeen;
    private String name;
    private String content;
    private Boolean hide;
    private Integer id;

    @Basic
    @Column(name = "favor")
    public Boolean getFavor() {
        return favor;
    }

    public void setFavor(Boolean favor) {
        this.favor = favor;
    }

    @Basic
    @Column(name = "count_seen")
    public Integer getCountSeen() {
        return countSeen;
    }

    public void setCountSeen(Integer countSeen) {
        this.countSeen = countSeen;
    }

    @Basic
    @Column(name = "time_last_seen")
    public Timestamp getTimeLastSeen() {
        return timeLastSeen;
    }

    public void setTimeLastSeen(Timestamp timeLastSeen) {
        this.timeLastSeen = timeLastSeen;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "hide")
    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardsEntity that = (CardsEntity) o;

        if (favor != null ? !favor.equals(that.favor) : that.favor != null) return false;
        if (countSeen != null ? !countSeen.equals(that.countSeen) : that.countSeen != null) return false;
        if (timeLastSeen != null ? !timeLastSeen.equals(that.timeLastSeen) : that.timeLastSeen != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (hide != null ? !hide.equals(that.hide) : that.hide != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = favor != null ? favor.hashCode() : 0;
        result = 31 * result + (countSeen != null ? countSeen.hashCode() : 0);
        result = 31 * result + (timeLastSeen != null ? timeLastSeen.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (hide != null ? hide.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
