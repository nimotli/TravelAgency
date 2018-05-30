package GAV.ressources;

import java.sql.Date;

public class location {
   private String intitule ;
   private String benificiare ;
   private Date dateDebut ;
   private Date dateFin ;
public location(String intitule, String benificiare, Date dateDebut, Date dateFin) {
	super();
	this.intitule = intitule;
	this.benificiare = benificiare;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
public String getBenificiare() {
	return benificiare;
}
public void setBenificiare(String benificiare) {
	this.benificiare = benificiare;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
@Override
public String toString() {
	return "location [intitule=" + intitule + ", benificiare=" + benificiare + ", dateDebut=" + dateDebut + ", dateFin="
			+ dateFin + "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	location other = (location) obj;
	if (benificiare == null) {
		if (other.benificiare != null)
			return false;
	} else if (!benificiare.equals(other.benificiare))
		return false;
	if (dateDebut == null) {
		if (other.dateDebut != null)
			return false;
	} else if (!dateDebut.equals(other.dateDebut))
		return false;
	if (dateFin == null) {
		if (other.dateFin != null)
			return false;
	} else if (!dateFin.equals(other.dateFin))
		return false;
	if (intitule == null) {
		if (other.intitule != null)
			return false;
	} else if (!intitule.equals(other.intitule))
		return false;
	return true;
} 
   
   
} 
