package hello.data;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class HashtagsHits {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String hashTag;
    private Long hits;

    public HashtagsHits() {
    }

    public HashtagsHits(String hashTag) {
        this.hashTag = hashTag;
        this.hits = 0L;
    }

    public String getHashTag() {
        return hashTag;
    }

    public Long getHits() {
        return hits;
    }

    @Override
    public String toString() {
        return "HashtagsHits{" +
                "id=" + id +
                ", hashTag='" + hashTag + '\'' +
                ", hits=" + hits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        HashtagsHits that = (HashtagsHits) o;

        return new EqualsBuilder()
                .append(hashTag, that.hashTag)
                .append(hits, that.hits)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(hashTag)
                .append(hits)
                .toHashCode();
    }
}
