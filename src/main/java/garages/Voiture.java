package garages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.PrintStream;
import java.util.*;


/**
 * Représente une voiture qui peut être stationnée dans des garages.
 */
@RequiredArgsConstructor
@ToString
public class Voiture {

	@Getter
	@NonNull
	private final String immatriculation;
	@ToString.Exclude // On ne veut pas afficher les stationnements dans toString
	private final List<Stationnement> myStationnements = new LinkedList<>();

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws IllegalStateException Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws IllegalStateException {
		// Et si la voiture est déjà dans un garage ?
		if (myStationnements.isEmpty()) {
			Stationnement s = new Stationnement(this, g);
			myStationnements.add(s);
		}else{
			throw new IllegalStateException();
		}


	}

	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws IllegalStateException si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws IllegalStateException {
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
		//throws NoSuchElementException

		if (!myStationnements.getLast().estEnCours()) {
			throw new IllegalStateException();
		}else{
			Stationnement actuel = myStationnements.getLast();
			actuel.terminer();
		}

		//throw new UnsupportedOperationException("Pas encore implémenté");
	}

	/**
	 * Calcule l'ensemble des garages visités par cette voiture
	 * 
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		Set<Garage> garages = new HashSet<>();
		for (Stationnement s : myStationnements) {
			garages.add(s.getGarageVisite());
		}
		return garages;
	}

	/**
	 * Détermine si la voiture est actuellement dans un garage
	 * 
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// Vrai si il y a des stationnements et le dernier stationnement est en cours
		if (myStationnements.isEmpty()) {
			return false;
		}else {
			return myStationnements.getLast().estEnCours();
		}
    }

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 * 
	 * <pre>
	 * Garage(name=Universite Champollion Albi):
	 * 		Stationnement{ entree=13/11/2024, sortie=13/11/2024 }
	 * Garage(name=ISIS Castres):
	 * 		Stationnement{ entree=13/11/2024, sortie=13/11/2024 }
	 * 		Stationnement{ entree=13/11/2024, en cours }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out pour imprimer dans la
	 *            console)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// Utiliser les méthodes toString() de Garage et Stationnement
		String retourCastres = "ISIS Castres";
		String retourAlbi = "Universite Champollion Albi";



		 for (Stationnement s : myStationnements) {
			 Garage garage = s.getGarageVisite();

			 if (garage.getName() == "Castres"){
				 retourCastres +=  s.toString();
			 }else{
				 retourAlbi += s.toString();
			 }
		 }

		 String retour = retourAlbi + retourCastres;
		 out.println(retour);
	}

}
