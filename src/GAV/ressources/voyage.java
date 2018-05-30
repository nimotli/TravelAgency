package GAV.ressources;
import java.util.Date;
public class voyage {
     private Date dateAffecter ;
     private Date dateVoyage ;
     
	public voyage(Date dateAffecter, Date dateVoyage) {
		super();
		this.dateAffecter = dateAffecter;
		this.dateVoyage = dateVoyage;
	}

	public Date getDateAffecter() {
		return dateAffecter;
	}

	public void setDateAffecter(Date dateAffecter) {
		this.dateAffecter = dateAffecter;
	}

	public Date getDateVoyage() {
		return dateVoyage;
	}

	public void setDateVoyage(Date dateVoyage) {
		this.dateVoyage = dateVoyage;
	}

	@Override
	public String toString() {
		return "voyage [dateAffecter=" + dateAffecter + ", dateVoyage=" + dateVoyage + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		voyage other = (voyage) obj;
		if (dateAffecter == null) {
			if (other.dateAffecter != null)
				return false;
		} else if (!dateAffecter.equals(other.dateAffecter))
			return false;
		if (dateVoyage == null) {
			if (other.dateVoyage != null)
				return false;
		} else if (!dateVoyage.equals(other.dateVoyage))
			return false;
		return true;
	}
     
	
     
}
