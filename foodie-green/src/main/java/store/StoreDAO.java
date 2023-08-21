package store;

import java.util.List;

public interface StoreDAO {
	List<StoreDTO> getStorelist();
	StoreDTO getDetail(int id);
}
