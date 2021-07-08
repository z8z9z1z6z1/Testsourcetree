package publishCheckPage.Service;

import java.sql.SQLException;
import java.text.ParseException;
import org.hibernate.Session;
import publishCheckPage.Model.PublishBean;
import publishCheckPage.Model.PublishDao;

public class PublishService {
	
	private PublishDao pDao;
	private Session session;
	
	public PublishService(Session session) {
		this.session = session;
		pDao = new PublishDao(session);
	}
	
	public PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException {
		return pDao.insertPublish(bean);
	}
}

