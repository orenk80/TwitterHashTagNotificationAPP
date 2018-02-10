package hello.data;

public class HashtagsHitsDto {
    private String hashTag;
    private Long hits;

    public HashtagsHitsDto(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashtagsHitsDto that = (HashtagsHitsDto) o;

        if (hashTag != null ? !hashTag.equals(that.hashTag) : that.hashTag != null) return false;
        return hits != null ? hits.equals(that.hits) : that.hits == null;
    }

    @Override
    public int hashCode() {
        int result = hashTag != null ? hashTag.hashCode() : 0;
        result = 31 * result + (hits != null ? hits.hashCode() : 0);
        return result;
    }

    public HashtagsHitsDto(String hashTag, Long hits) {
        this.hashTag = hashTag;
        this.hits = hits;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }
}
