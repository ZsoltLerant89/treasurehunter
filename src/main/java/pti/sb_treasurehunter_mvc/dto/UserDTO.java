package pti.sb_treasurehunter_mvc.dto;

public class UserDTO {

	private int id;
	private String name;
	private Integer recordSteps;
	private boolean win;
	private Integer currentSteps;
	
	
	public UserDTO(	int id,
					String name, 
					Integer recordSteps,
					boolean win,
					Integer currentSteps
					)
	{
		super();
		this.id = id;
		this.name = name;
		this.recordSteps = recordSteps;
		this.win = win;
		this.currentSteps = currentSteps;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRecordSteps() {
		return recordSteps;
	}

	public void setRecordSteps(Integer recordSteps) {
		this.recordSteps = recordSteps;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Integer getCurrentSteps() {
		return currentSteps;
	}

	public void setCurrentSteps(Integer currentSteps) {
		this.currentSteps = currentSteps;
	}
	
	

}
