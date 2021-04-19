/**
 * Verwaltet die unterschiedlichen Knoten in Form einer Liste
 * Marius ist ein komischer Typ
 * @param anzahlKnoten
 *  	die jetztige anzahl der Knoten in der Liste. Startet bei 0
 * @param anfang 
 *      referenziert den Knoten, der zur zeit der "erste" ist bzw als letztes eingefügt wurde. 
 *      Wenn anzahlKnoten = 0 (noch kein Koten eingefügt wurde) gilt anfang == null
 * 
 */
class GRAPH_LISTE{
    int anzahlKnoten;
    KNOTEN anfang;   
    
    /**
     * erstellt eine neue Liste mit defualt werten von 0 und null
     */
    GRAPH_LISTE(){
        anzahlKnoten = 0;
        anfang = null;
    }
    
    /**
     * Fügt einen neuen Knoten am anfang der Liste ein
     *
     * @param bezeichnerNeu
     *      der Übergabeparameter für die bezeichnung des zu erstellenden Knoten
     */
    void KnotenEinfuengen(String bezeichnerNeu){
        if(Suchen(bezeichnerNeu) == null){
            KNOTEN knotenNeu;
            if(anfang != null){
                knotenNeu = new KNOTEN(bezeichnerNeu, anfang);
                anfang = knotenNeu;
            }
            else{
                knotenNeu = new KNOTEN(bezeichnerNeu);
                anfang = knotenNeu;
            }
        }   
    }

    /**
     * Fügt eine neue Kante an beliebiger stelle ein
     * 
     * @param zielKnotenBezeichner
     *      die bezeichnung des Knotens, von dem die Kante ausgehen sollte
     * @param zielKnotenBezeichner
     *      die bezeichnung des Knotens, zu dem die Kante gehen sollte
     * @param gewichtungNeu
     *      die gewichtung der zu erstellenden Kante
     * 
     * bei ungerichteten Graphen sind zielKnotenBezeichner und zielKnotenBezeichner kommutativ
     */
    void KanteEinfuegen(String zielKnotenBezeichner, String endKnotenBeteichner, int gewichtungNeu){
        Suchen(zielKnotenBezeichner).KanteEinfuegen(Suchen(endKnotenBeteichner), gewichtungNeu);
    }

    /**
     * Sucht einen Knoten, nach seiner bezeichnung
     * 
     * @param bezeichnerGesucht
     *      der Übergabeparameter für die Bezeichnung des gesuchten Knoten
     * @return
     *      der gesuchte Koten, falls gefunden. 
     *      Falls ein Knoten mit der bezeichnung bezeichnerGesucht nicht existiert wird null zurück gegeben
     */
    KNOTEN Suchen(String bezeichnerGesucht){
        return anfang.Suchen(bezeichnerGesucht);
    }
    
    /**
     * Gibt alle Knoten und alle Kanten, die diese Knoten besitzen aus (in der Konsole)
     */
    void Ausgeben(){
        anfang.Ausgeben();
    }

   public KNOTEN getAnfang() {
       return anfang;
   }

   public int getAnzahlKnoten() {
       return anzahlKnoten;
   }
}
