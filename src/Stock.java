// PENSEZ A INDIQUER PAR DES COMMENTAIRES LES MODIFICATIONS APPORTEES A CE SQUELETTE AU FUR
// ET A MESURE DE L'EVOLUTION DU CODE DEMANDEE DANS LE TP.

/**
 * Les objets instances de la classe Stock representent un ensemble de pieces,
 * empilees les unes sur les autres. Du fait de la disposition en piles, il n'est
 * pas possible que deux operateurs saisissent deux pieces au meme moment.
 *
 */
class Stock {
	/**
	 * Nombre de pieces dans la pile
	 */
    private int nbPieces;
    /**
     * Le nom du stock
     */
    private String nom;

    /**
     * Creer un nouvel objet instance de stock
     * @param nom Le nom du nouveau stock
     * @param nbPieces Le nombre de pieces initial
     */
    public Stock(String nom, int nbPieces) {
        this.nbPieces = nbPieces;
        this.nom = nom;
    }

    /**
     * Poser une piece sur le haut de la pile de pieces
     */
    public synchronized void stocker() {
        nbPieces++;
        System.out.println(Thread.currentThread().getName()+" stocke. il reste "+nbPieces+" pieces");
        notify();
    }

    /**
     * Saisir une piece sur le haut de la pile de pieces
     */
    public synchronized void destocker() {
        if (nbPieces == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " Attends " + nom);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nbPieces--;
        System.out.println(Thread.currentThread().getName()+" déstocke. il reste  "+nbPieces+" pieces");
    }

    /**
     * Affiche l'etat de l'objet stock
     */
    public void afficher() {
        System.out.println("Le stock " + nom + " contient " + nbPieces + " piece(s).");
    }

}
