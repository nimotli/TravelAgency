package GAV.ressources;

public class agence {
  private int idAgence ;
  private String nomAgence ;
  
public agence(int idAgence, String nomAgence) {
	super();
	this.idAgence = idAgence;
	this.nomAgence = nomAgence;
}

public int getIdAgence() {
	return idAgence;
}

public void setIdAgence(int idAgence) {
	this.idAgence = idAgence;
}

public String getNomAgence() {
	return nomAgence;
}

public void setNomAgence(String nomAgence) {
	this.nomAgence = nomAgence;
}

@Override
public String toString() {
	return "agence [idAgence=" + idAgence + ", nomAgence=" + nomAgence + "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	agence other = (agence) obj;
	if (idAgence != other.idAgence)
		return false;
	if (nomAgence == null) {
		if (other.nomAgence != null)
			return false;
	} else if (!nomAgence.equals(other.nomAgence))
		return false;
	return true;
}
  
  
}
