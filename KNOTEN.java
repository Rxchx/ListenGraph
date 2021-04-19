/**
 * - Verwaltet die Kanten, die ein Knoten hat in Form einer Liste
 * - Stellt Funktionalität für die Knoten zur Verfügung
 * 
 * @param bezeichnung
 *      die bezeichnung des Knotens. Mit ihr wird der Knoten identifiziert, sie müssen also eindeutig sein bzw. es lässt sich pro eindeutiger bezeichnung nur ein Knoten eunfügen
 * @param anfang
 *      Listenanfang  der Liste aller Kanten, die mit dem Spezifischen Knoten verbunden sind
 * @param nachfolger
 *      nachfolger vom typ Knoten, dient der rekursivität der Liste
 */
class KNOTEN{
    String bezeichnung;
    KANTE anfang;
    KNOTEN nachfolger;

    /**
     * Erstellt einen neuen Knoten mit einem Knoten als Nahfolger
     * 
     * @param bezeichnungNeu
     *      die bezeichung des zu erstellenden Knotens
     * @param nachfolgerNeu
     *      der Nahfolger des zu erstellenden Knotens
     */
    KNOTEN(String bezeichnungNeu, KNOTEN nachfolgerNeu){
        bezeichnung = bezeichnungNeu;
        nachfolger = nachfolgerNeu;
    }

    /**
     * Erstellt einen neuen Knoten ohne einen Knoten als Nahfolger
     * Ist hauptsächlich nützlich, falls er der erste innerhalb einer List ist
     * 
     * @param bezeichnungNeu
     *      die bezeichung des zu erstellenden Knotens
     * 
     * der nachfolger wird auf null gesetzt
     */
    KNOTEN(String bezeichnungNeu){
        bezeichnung = bezeichnungNeu;
        nachfolger = null;
    }

    /**
     * Sucht in diesem und allen nachfolgenden Knoten, nach Knoten mit einer bestimmten bezeichnung
     * 
     * @param bezeichnerGesucht
     *      die bezeichung des zu suchenden Knotens
     * @return  
     *      - der Gefundene Knoten, falls dieser existiert
     *      - null, falls kein Knoten gefunden wurde
     */
    KNOTEN Suchen(String bezeichnerGesucht){
        if(this.bezeichnung == bezeichnerGesucht){
            return this;
        }
        else{
            if(nachfolger != null){
                return nachfolger.Suchen(bezeichnerGesucht);
            }
            else{
                return null;
            }
        }
    }

    /**
     * Fügt eiene gerichtete neue Kante, die vom jetzigen Knoten ausgeht ein
     * Für einen (mehr oder weniger) ungerichteten Graphen müssen "von beiden Seiten" Kanten eingefüt werden
     * 
     * @param endKnoten
     *      der Knoten, auf den die Kante zeigt
     * @param gewichtung
     *      die gewichtung der zu erstellenden Kante
     */
    void KanteEinfuegen(KNOTEN endKnoten, int gewichtung){
        KANTE kanteNeu;
        if(anfang != null){
            kanteNeu = new KANTE(gewichtung, endKnoten, anfang);
            anfang = kanteNeu;
        }
        else{
            kanteNeu = new KANTE(gewichtung, endKnoten);
            anfang = kanteNeu;
        }
    }

    /**
     * Gibt von diesem und allen nachfolgenden Knoten die bezeichung und alle Kanten aus
     * 
     * Folgend Formattiert:
     * 
     * Der Knoten 'Beispielbezeichnung0' hat folgende Kanten:
     *   1. nach 'Beispielbezeichnung1' mit der Gewichtung 'Beispielgewichtung1'
     *   2. nach 'Beispielbezeichnung2' mit der Gewichtung 'Beispielgewichtung2'
     *                       .
     *                       .
     *                      usw.
     */
    void Ausgeben(){
        System.out.println("Der Knoten '" + bezeichnung + "' hat folgende Katen:");
        anfang.Ausgeben(1);
        nachfolger.Ausgeben();
    }

    public KANTE getAnfang() {
        return anfang;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public KNOTEN getNachfolger() {
        return nachfolger;
    }
}