package GAV.ressources;

public class chauffeur {
    private String matricule ;
    private String nomChauffeur ;
    private String enConge ;
    
	public chauffeur(String matricule, String nomChauffeur, String enConge) {
		super();
		this.matricule = matricule;
		this.nomChauffeur = nomChauffeur;
		this.enConge = enConge;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNomChauffeur() {
		return nomChauffeur;
	}

	public void setNomChauffeur(String nomChauffeur) {
		this.nomChauffeur = nomChauffeur;
	}

	public String getEnConge() {
		return enConge;
	}

	public void setEnConge(String enConge) {
		this.enConge = enConge;
	}

	@Override
	public String toString() {
		return "chauffeur [matricule=" + matricule + ", nomChauffeur=" + nomChauffeur + ", enConge=" + enConge + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		chauffeur other = (chauffeur) obj;
		if (enConge == null) {
			if (other.enConge != null)
				return false;
		} else if (!enConge.equals(other.enConge))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (nomChauffeur == null) {
			if (other.nomChauffeur != null)
				return false;
		} else if (!nomChauffeur.equals(other.nomChauffeur))
			return false;
		return true;
	}
    
    
}
