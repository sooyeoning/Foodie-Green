package store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO storeDAO;
	
	@Override
	public List<StoreDTO> getStorelist() {
		return storeDAO.getStorelist();
	}

	@Override
	public StoreDTO getDetail(int id) {
		// TODO Auto-generated method stub
		return storeDAO.getDetail(id);
	}

}
