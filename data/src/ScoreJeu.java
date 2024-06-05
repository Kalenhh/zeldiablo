import java.io.*;

public class ScoreJeu {
    private String nomFichier;

    FileWriter fw;
    /**
     * 
     * @param nomFichier
     * @throws IOException
     * 
     * Constructeur du score du jeu, sauvegarder sur un fichier 
     */
    public ScoreJeu(String nomFichier) throws IOException {
        this.nomFichier = nomFichier;
        this.fw = new FileWriter(nomFichier);
    }
    /**
     * 
     * @param pseudo
     * @param score
     * @throws IOException
     * 
     * Methode qui permet de metre à jour le score contenue sur un fichier
     */
    public void ajouterScore(String pseudo, int score) throws IOException {
        this.fw.write(pseudo + ";" + score + ";\r");
    }
    /**
     * 
     * @throws IOException
     * 
     * Methode qui permet de fermer un de sauvegarde fichier 
     */
    public void fermerFichier() throws IOException {
        this.fw.close();
    }
    /**
     * 
     * @return
     * @throws IOException
     * 
     * Methode qui permet de renvoyer le meilleur score contenue sur un fichier 
     */
    public String getMeilleurScore() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(this.nomFichier));
        int meilleurScore = 0;
        String ligne;
        while(true){
            try{
                ligne = br.readLine();
                String[] ligneSepare = ligne.split(";");
                int scoreCourant = Integer.parseInt(ligneSepare[1]);
                if(scoreCourant > meilleurScore)
                    meilleurScore = scoreCourant;
            }catch (EOFException e){
                break;
            }catch (IOException e){
                break;
            }
        }
        String scoreMax = String.valueOf(meilleurScore);
        return scoreMax;
    }

    public int getScore(){
        return 0;
    }


}
