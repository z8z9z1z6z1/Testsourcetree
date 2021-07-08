package publishCheckPage.Model;

import java.sql.SQLException;
import java.text.ParseException;
import javax.sql.DataSource;
import org.hibernate.Session;

public class PublishDao {
	DataSource ds = null;
	
	private Session session;

	public PublishDao(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}
	
	public PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException {
		
		PublishBean result = session.get(PublishBean.class, bean.getPublishNo());
		if(result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
}

