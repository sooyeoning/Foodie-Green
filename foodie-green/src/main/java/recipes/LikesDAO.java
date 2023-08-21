package recipes;

public interface LikesDAO {

    void addLike(LikesDTO likes);
    void removeLike(LikesDTO likes);
    int checkLike(LikesDTO likes);
}
