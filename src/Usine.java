// PENSEZ A INDIQUER PAR DES COMMENTAIRES LES MODIFICATIONS APPORTEES A CE SQUELETTE AU FUR
// ET A MESURE DE L'EVOLUTION DU CODE DEMANDEE DANS LE TP.

/**
 * Les objets instances de la classe Usine represente une usine avec deux ateliers.
 * Une instance d'Usine possede un stock de pieces a transformer ainsi qu'un stock
 * de pieces finies initialement vide. Chacun des deux ateliers transforme la moitie
 * des unites du stock a transformer.
 * La methode fonctionner() fait travailler successivement les deux ateliers et affiche
 * l'etat des stocks a la fin des travaux.
 */
class Usine {
	/**
	 * Stock de pieces a transformer
	 */
    Stock stockDepart = new Stock("de depart", 10);
    /**
     * Stock de pieces transformees
     */
    Stock stockFin = new Stock("d'arrivee", 0);

    Stock stockIntermediaire = new Stock("intermédiaire", 0);
    /**
     * Ateliers de transformation
     */
    Atelier atelier1 = new Atelier(stockDepart, stockIntermediaire, 10);
    Atelier atelier2 = new Atelier(stockIntermediaire, stockFin, 10);

    /**
     * Effectuer le travail de l'usine
     * Utilise successivement chaque atelier pour transformer une piece et affiche
     * l'evolution de l'etat des stocks.
     */
    public synchronized void fonctionner() {
    		atelier1.start();
    		atelier2.start();
    		try {
				atelier1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				atelier2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		stockDepart.afficher();
    		stockFin.afficher();
    }

    /**
     * Point d'entree pour l'ensemble du TP.
     * @param args Non utilise
     */
    public static void main(String[] args) {

    	Usine u1 = new Usine();
    	u1.fonctionner();
    	
    	 

    }
}
