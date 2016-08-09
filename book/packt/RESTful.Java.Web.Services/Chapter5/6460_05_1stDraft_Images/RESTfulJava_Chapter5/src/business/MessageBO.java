package business;

import java.util.ArrayList;
import java.util.List;

import model.MessageVO;
import model.UserVO;
import model.XMLUtil;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import exception.InvalidXMLException;
import exception.ItemNotFoundException;
import exception.UserNotFoundException;

public class MessageBO {
	private MessageBO() {
	}

	public static String create(String xml) throws InvalidXMLException, UserNotFoundException {
		ObjectContainer db = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);
			MessageVO messageVO = XMLUtil.getMessageVOFromXML(xml);

			if (messageVO != null) {
				// Add message only if user is registered
				if (UserBO.query(db, messageVO.getUserVO().getUsername(), messageVO.getUserVO().getPassword()) != null) {
					db.store(messageVO);

					return messageVO.toXML();
				} else {
					throw new UserNotFoundException();
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

	private static List<MessageVO> getAllForUser(final String username) {
		ObjectContainer db = null;
		List<MessageVO> list = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);

			// Check that user exists
			final UserVO userVO = UserBO.query(db, username);
			if (userVO == null) {
				return new ArrayList<MessageVO>();
			}

			list = db.query(new Predicate<MessageVO>() {
				public boolean match(MessageVO messageVO) {
					return (messageVO.getUserVO().getUsername().equals(username));
				}
			});
			
			ArrayList<MessageVO> newList = new ArrayList<MessageVO>();
			for (MessageVO vo : list) {
				newList.add(vo);
			}

			return (list == null) ? new ArrayList<MessageVO>() : newList;
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public static String getAllXMLForUser(String username) {
		return getAllXMLStructure(getAllForUser(username));
	}

	public static String getAllJSONForUser(String username) {
		return getAllJSONStructure(getAllForUser(username));
	}

	private static List<MessageVO> searchMessages(final String search_item) {
		ObjectContainer db = null;
		List<MessageVO> list = null;
		try {
			db = Db4o.openFile(Constants.DB_NAME);

			list = db.query(new Predicate<MessageVO>() {
				public boolean match(MessageVO messageVO) {
					return messageVO.getContent().contains(search_item);
				}
			});

			ArrayList<MessageVO> newList = new ArrayList<MessageVO>();
			for (MessageVO vo : list) {
				newList.add(vo);
			}
			
			return (list == null) ? new ArrayList<MessageVO>() : newList;
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	private static String getAllXMLStructure(List<MessageVO> result) {
		StringBuilder users = new StringBuilder();
		users.append("<messages>");
		users.append("<count>").append(result.size()).append("</count>");

		for (MessageVO vo : result) {
			users.append(vo.toXML());
		}

		users.append("</messages>");

		return users.toString();
	}

	// Declared final because of inner class access
	public static String searchAllXML(String search_item) {
		return getAllXMLStructure(searchMessages(search_item));
	}

	private static String getAllJSONStructure(List<MessageVO> result) {
		StringBuilder messages = new StringBuilder();
		int size = result.size();
		messages.append("{\"messages-result\":{\"count\":\"").append(size).append("\", \"messages\":[");

		for (int i = 0; i < size; i++) {
			messages.append(result.get(i).toJSON());

			if (i + 1 < size) {
				messages.append(",");
			}
		}

		messages.append("]}}");

		return messages.toString();
	}

	public static String searchAllJSON(String search_item) {
		return getAllJSONStructure(searchMessages(search_item));
	}

	public static String getAllXML() {
		ObjectContainer db = null;
		try {
			db = Db4o.openFile(Constants.DB_NAME);
			// Refer to Chapter 4 for the specific structure
			StringBuilder users = new StringBuilder();
			users.append("<messages>");

			ObjectSet<MessageVO> result = db.queryByExample(MessageVO.class);
			users.append("<count>").append(result.size()).append("</count>");

			while (result.hasNext()) {
				users.append(result.next().toXML());
			}

			users.append("</messages>");

			return users.toString();
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public static String getAllJSON() {
		ObjectContainer db = null;
		try {
			db = Db4o.openFile(Constants.DB_NAME);
			// Refer to Chapter 4 for the specific structure
			StringBuilder messages = new StringBuilder();

			ObjectSet<MessageVO> result = db.queryByExample(MessageVO.class);
			messages.append("{\"messages-result\":{\"count\":\"").append(result.size()).append("\", \"messages\":[");

			while (result.hasNext()) {
				messages.append(result.next().toJSON());

				if (result.hasNext()) {
					messages.append(",");
				}
			}

			messages.append("]}}");

			return messages.toString();
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	private static MessageVO queryMessage(ObjectContainer db, String messageID) {
		ObjectSet<MessageVO> result = db.queryByExample(new MessageVO(messageID));

		if (result.hasNext()) {
			return result.next();
		} else {
			return null;
		}
	}

	private static MessageVO queryMessage(String messageID) {
		ObjectContainer db = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);
			ObjectSet<MessageVO> result = db.queryByExample(new MessageVO(messageID));

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

	public static String getXML(String messageID) {
		MessageVO messageVO = queryMessage(messageID);

		return (messageVO != null) ? messageVO.toXML() : null;
	}

	public static String getJSON(String messageID) {
		MessageVO messageVO = queryMessage(messageID);

		return (messageVO != null) ? messageVO.toJSON() : null;
	}

	public static void delete(String messageID) throws ItemNotFoundException {
		ObjectContainer db = null;

		try {
			db = Db4o.openFile(Constants.DB_NAME);
			// Check that message for messageID exists
			MessageVO messageVO = queryMessage(db, messageID);
			if (messageVO != null) {
				db.delete(messageVO);
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
