package GAV.ressources;

public class ligne {
      private int idLigne ;
      private int heureDepart ;
      private int heureArrive ;
      private int kilometrage;
      private int dureeAttente;
      private int dureeRepos ;
      private int dureeImmobilisation ;
	public ligne(int idLigne, int heureDepart, int heureArrive, int kilometrage, int dureeAttente, int dureeRepos,
			int dureeImmobilisation) {
		super();
		this.idLigne = idLigne;
		this.heureDepart = heureDepart;
		this.heureArrive = heureArrive;
		this.kilometrage = kilometrage;
		this.dureeAttente = dureeAttente;
		this.dureeRepos = dureeRepos;
		this.dureeImmobilisation = dureeImmobilisation;
	}
	public int getIdLigne() {
		return idLigne;
	}
	public void setIdLigne(int idLigne) {
		this.idLigne = idLigne;
	}
	public int getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
	public int getHeureArrive() {
		return heureArrive;
	}
	public void setHeureArrive(int heureArrive) {
		this.heureArrive = heureArrive;
	}
	public int getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}
	public int getDureeAttente() {
		return dureeAttente;
	}
	public void setDureeAttente(int dureeAttente) {
		this.dureeAttente = dureeAttente;
	}
	public int getDureeRepos() {
		return dureeRepos;
	}
	public void setDureeRepos(int dureeRepos) {
		this.dureeRepos = dureeRepos;
	}
	public int getDureeImmobilisation() {
		return dureeImmobilisation;
	}
	public void setDureeImmobilisation(int dureeImmobilisation) {
		this.dureeImmobilisation = dureeImmobilisation;
	}
	@Override
	public String toString() {
		return "ligne [idLigne=" + idLigne + ", heureDepart=" + heureDepart + ", heureArrive=" + heureArrive
				+ ", kilometrage=" + kilometrage + ", dureeAttente=" + dureeAttente + ", dureeRepos=" + dureeRepos
				+ ", dureeImmobilisation=" + dureeImmobilisation + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ligne other = (ligne) obj;
		if (dureeAttente != other.dureeAttente)
			return false;
		if (dureeImmobilisation != other.dureeImmobilisation)
			return false;
		if (dureeRepos != other.dureeRepos)
			return false;
		if (heureArrive != other.heureArrive)
			return false;
		if (heureDepart != other.heureDepart)
			return false;
		if (idLigne != other.idLigne)
			return false;
		if (kilometrage != other.kilometrage)
			return false;
		return true;
	}
      
      
}
