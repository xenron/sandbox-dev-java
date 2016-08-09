package business;

import model.UserVO;
import model.XMLUtil;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;
import exception.ItemNotFoundException;

public class UserBO {
	private UserBO() {
	}

	public static String create(String xml) throws InvalidXMLException, ItemAlreadyExistsException {
		ObjectContainer db = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);
			UserVO userVO = XMLUtil.getUserVOFromXML(xml);
			if (userVO != null) {
				// Check if user exists in our DB: if not, create; else, throw
				// exception
				if (query(db, userVO.getUsername()) == null) {
					db.store(userVO);

					return userVO.toXML();
				} else {
					throw new ItemAlreadyExistsException();
				}
			} else {
				throw new InvalidXMLException();
			}
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public static String getAllXML() {
		ObjectContainer db = null;
		try {
			db = Db4o.openFile(Constants.DB_NAME);
			// Refer to Chapter 4 for the specific structure
			StringBuilder users = new StringBuilder();
			users.append("<users>");

			ObjectSet<UserVO> result = db.queryByExample(UserVO.class);
			users.append("<count>").append(result.size()).append("</count>");

			while (result.hasNext()) {
				users.append(result.next().toXML());
			}

			users.append("</users>");

			return users.toString();
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public static String getAllJSON() {
		// Refer to Chapter 4 for the specific structure
		ObjectContainer db = null;
		try {
			db = Db4o.openFile(Constants.DB_NAME);
			StringBuilder users = new StringBuilder();

			ObjectSet<UserVO> result = db.queryByExample(UserVO.class);

			users.append("{\"users-result\":{\"count\":\"").append(result.size()).append("\", \"users\":[");

			while (result.hasNext()) {
				users.append(result.next().toJSON());

				if (result.hasNext()) {
					users.append(",");
				}
			}

			users.append("]}}");

			return users.toString();
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	protected static UserVO query(String username) {
		ObjectContainer db = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);
			ObjectSet<UserVO> result = db.queryByExample(new UserVO(username));

			if (result.hasNext()) {
				return result.next();
			} else {
				return null;
			}
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	protected static UserVO query(ObjectContainer db, String username) {
		return query(db, username, null);
	}

	protected static UserVO query(ObjectContainer db, String username, String password) {
		ObjectSet<UserVO> result = db.queryByExample(new UserVO(username, password));

		if (result.hasNext()) {
			return result.next();
		} else {
			return null;
		}
	}

	public static String getXML(String username) {
		UserVO userVO = query(username);

		return (userVO != null) ? userVO.toXML() : null;
	}

	public static String getJSON(String username) {
		UserVO userVO = query(username);

		return (userVO != null) ? userVO.toJSON() : null;
	}

	public static String update(String xml) throws InvalidXMLException, ItemNotFoundException {
		ObjectContainer db = null;
		try {
			db = Db4o.openFile(Constants.DB_NAME);
			UserVO userVO = XMLUtil.getUserVOFromXML(xml);
			if (userVO != null) {
				// Check that user exists in our DB: if so, update; else, throw
				// exception
				UserVO tmpUser = query(db, userVO.getUsername());
				if (tmpUser != null) {
					// We only let the user update the password
					tmpUser.setPassword(userVO.getPassword());
					db.store(tmpUser);

					return tmpUser.toXML();
				} else {
					throw new ItemNotFoundException();
				}
			} else {
				throw new InvalidXMLException();
			}
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public static void delete(String username) throws ItemNotFoundException {
		ObjectContainer db = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);
			// Check that user for username exists
			UserVO userVO = query(db, username);
			if (userVO != null) {
				db.delete(userVO);
			} else {
				throw new ItemNotFoundException();
			}
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}
}
