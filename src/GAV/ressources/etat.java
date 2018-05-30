package GAV.ressources;

import java.sql.Date;

public class etat {
   private int idEtat ;
   private Date dateNonDispo ;
   
public etat(int idEtat, Date dateNonDispo) {
	super();
	this.idEtat = idEtat;
	this.dateNonDispo = dateNonDispo;
}

public int getIdEtat() {
	return idEtat;
}

public void setIdEtat(int idEtat) {
	this.idEtat = idEtat;
}

public Date getDateNonDispo() {
	return dateNonDispo;
}

public void setDateNonDispo(Date dateNonDispo) {
	this.dateNonDispo = dateNonDispo;
}

@Override
public String toString() {
	return "etat [idEtat=" + idEtat + ", dateNonDispo=" + dateNonDispo + "]";
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	etat other = (etat) obj;
	if (dateNonDispo == null) {
		if (other.dateNonDispo != null)
			return false;
	} else if (!dateNonDispo.equals(other.dateNonDispo))
		return false;
	if (idEtat != other.idEtat)
		return false;
	return true;
} 
   

   
   
}
