/** 
 * Stellt Funktionalität für die Kanten zur Verfügung;
 * prinzipiell ist eine einzelne Kante gerichtet. Für einen (mehr oder weniger) ungerichteten Graphen bedarf es Kanten "aus beiden Richtungen"
 * 
 * @param gewichtung
 *      die gewichtung einer Kante
 * @param zielKnoten
 *      der zielKnoten einer Kante
 * @param nachfolger
 *      nachfolger vom typ Kante, dient der rekursivität der Liste
 */
class KANTE{
    int gewichtung;
    KNOTEN zielKnoten;
    KANTE nachfolger;

    /**
     * Erstellt eine neue Kante mit einer Kante als Nahfolger
     * 
     * @param gewichtungNeu
     *      die gewichtung der zu erstellenden Kante
     * @param zielKnotenNeu
     *      das Ziel der zu erstellenden Kante
     * @param nachfolgerNeu
     *      der nachfolger der zu erstellenden Kante
     */
    KANTE(int gewichtungNeu, KNOTEN zielKnotenNeu, KANTE nachfolgerNeu){
        gewichtung = gewichtungNeu;
        zielKnoten = zielKnotenNeu;
        nachfolger = nachfolgerNeu;
    }

    /**
     * Erstellt eine neue Kante ohne eine Kante als Nahfolger
     * Ist hauptsächlich nützlich, falls sie die erste innerhalb einer List ist
     * 
     * @param gewichtungNeu
     *      die gewichtung der zu erstellenden Kante
     * @param zielKnotenNeu
     *      das Ziel der zu erstellenden Kante
     * 
     * der nachfolger wird auf null gesetzt
     */
    KANTE(int gewichtungNeu, KNOTEN zielKnotenNeu){
        gewichtung = gewichtungNeu;
        zielKnoten = zielKnotenNeu;
        nachfolger = null;
    }

    /**
     * Gibt von dieser und allen nachfolgenden Kanten die bezeichung des zielKnotens und die gewichtung nummeriert aus
     * 
     * Folgend Formattiert:
     * 
     *   1. nach 'Beispielbezeichnung1' mit der Gewichtung 'Beispielgewichtung1'
     *   2. nach 'Beispielbezeichnung2' mit der Gewichtung 'Beispielgewichtung2'
     *                       .
     *                       .
     *                      usw.
     * @param nummer
     *      die jetztige Nummer in der Liste
     */
    void Ausgeben(int nummer){
        int Stelle = nummer;
        System.out.println("  " + Stelle + ". " + "nach" + zielKnoten.bezeichnung + "mit Gewichtung: '" + gewichtung + "'" );
        Stelle++;
        nachfolger.Ausgeben(Stelle);
    }
    
    public int getGewichtung() {
        return gewichtung;
    }

    public KANTE getNachfolger() {
        return nachfolger;
    }

    public KNOTEN getZielknoten() {
        return zielKnoten;
    }
}