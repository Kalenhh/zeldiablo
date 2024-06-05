import java.io.*;

public class ScoreJeu {
    private String nomFichier;

    FileWriter fw;

    public ScoreJeu(String nomFichier) throws IOException {
        this.nomFichier = nomFichier;
        this.fw = new FileWriter(nomFichier);
    }

    public void ajouterScore(String pseudo, int score) throws IOException {
        this.fw.write(pseudo + ";" + score + ";\r");
    }

    public void fermerFichier() throws IOException {
        this.fw.close();
    }

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
