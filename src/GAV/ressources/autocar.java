package GAV.ressources;

public class autocar {
   private String numImmobilisation ; 
   private int dureeImmobilisation ;
   
public autocar(String numImmobilisation, int dureeImmobilisation) {
	super();
	this.numImmobilisation = numImmobilisation;
	this.dureeImmobilisation = dureeImmobilisation;
}

public String getNumImmobilisation() {
	return numImmobilisation;
}

public void setNumImmobilisation(String numImmobilisation) {
	this.numImmobilisation = numImmobilisation;
}

public int getDureeImmobilisation() {
	return dureeImmobilisation;
}

public void setDureeImmobilisation(int dureeImmobilisation) {
	this.dureeImmobilisation = dureeImmobilisation;
}

@Override
public String toString() {
	return "autocar [numImmobilisation=" + numImmobilisation + ", dureeImmobilisation=" + dureeImmobilisation + "]";
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	autocar other = (autocar) obj;
	if (dureeImmobilisation != other.dureeImmobilisation)
		return false;
	if (numImmobilisation == null) {
		if (other.numImmobilisation != null)
			return false;
	} else if (!numImmobilisation.equals(other.numImmobilisation))
		return false;
	return true;
} 
   

   
}
