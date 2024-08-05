package pti.sb_treasurehunter_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_treasurehunter_mvc.db.Database;
import pti.sb_treasurehunter_mvc.dto.UserDTO;
import pti.sb_treasurehunter_mvc.model.User;


@Service
public class AppService {

	private Database db;
	
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}



	public UserDTO login(String userName, String userPassword) {
		
		UserDTO userDTO = null;
		
		User user = db.getUserByNameAndPassword(userName,userPassword);
		
		if(user != null)
		{
			userDTO = new UserDTO(	user.getId(),
									user.getName(),
									user.getRecordSteps(),
									false,
									null
									);
		}
		
		return userDTO;
	}



	public UserDTO saveById(int id, boolean win, int clicked) {
		
		UserDTO userDTO = null;
		
		User user = db.getUserById(id);

		if(user != null)
		{
			if(win == true)
			{
				Integer recordSteps = user.getRecordSteps();
				if (recordSteps == null)
				{
					recordSteps = clicked;
					user.setRecordSteps(clicked);
					db.saveUser(user);
				}
				else if(clicked < recordSteps)
				{
					user.setRecordSteps(clicked);
					db.saveUser(user);
				}
			}

			userDTO = new UserDTO(	id,
									user.getName(),
									user.getRecordSteps(),
									win,
									clicked
									);
		}
		
		return userDTO;
	}

}
