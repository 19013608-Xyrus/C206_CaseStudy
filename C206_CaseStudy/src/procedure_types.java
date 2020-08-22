import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

//!!ALL TOGGLED COMMENTS IS FOR SPRINT #2 , DUE 25 AUGUST 2020 2359

public class procedure_types {
	
	private String type;
	private String description;
	private Date DateTime;
	
	public procedure_types(String type , String description) {
		super();
		this.type=type;
		this.description = description;
	}


	public procedure_types(String type, String description, Date DateTime) {
		super();
		this.type = type;
		this.description = description;
		this.DateTime = DateTime;
	}


	public String getDateTime() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		return df.format(DateTime);
	}


	public void setDateTime(Date dateTime) {
		this.DateTime = DateTime;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
