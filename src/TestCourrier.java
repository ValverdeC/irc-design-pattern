interface Contenu
{
    void encode(String texte);
    String toString();
}
class ContenuTexte implements Contenu
{
    protected String texte;
    public void encode(String texte)
    {
        this.texte = texte;
    }
    public String toString()
    {
        return (texte);
    }
}
class ContenuHtml implements Contenu
{
    protected String codeHtml;
    public void encode(String texte)
    {
        codeHtml = "<HTML>" + texte + "</HTML>";
    }
    public String toString()
    {
        return (codeHtml);
    }
}

class Courrier<T extends Contenu> {


    private Class<T> type;
    protected Contenu contenu;
    protected String destinataire;

    public Courrier(Class<T> type) {
        this.type = type;
    }

    protected Contenu nouveauContenu() throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }

    public void prepare(String destinataire, String texte) throws InstantiationException, IllegalAccessException {
        this.destinataire = destinataire;
        contenu = nouveauContenu();
        contenu.encode(texte);
    }
    public String toString()
    {
        String st = "destinataire : " + destinataire + "\n";
        st += "contenu : " + contenu.toString();
        return st;
    }
}


public class TestCourrier
{

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Courrier<ContenuHtml> courrierHtml = new Courrier<>(ContenuHtml.class);
        courrierHtml.prepare("adresse1@domaine", "texte1");
        System.out.println(courrierHtml);
        Courrier<ContenuTexte> courrierTexte = new Courrier<>(ContenuTexte.class);
        courrierTexte.prepare("adresse2@domaine", "texte2");
        System.out.println(courrierTexte);
    }

}