import javax.swing.SwingUtilities;
import complexnumber.CartesianComplexNumberFactory;
import complexnumber.ComplexNumberFactory;
import complexnumber.PolarComplexNumberFactory;
import model.EditableComplexNumber;
import view.ComplexNumberFrame;

/**
 * Classe principale de l'application qui initialise l'implémentation des nombres complexes en fonction de la propriété système.
 */
public class App {

    /**
     * Le factory utilisé pour créer des nombres complexes, soit en représentation cartésienne soit en représentation polaire.
     */
    private static ComplexNumberFactory factory;

    /**
     * Point d'entrée principal de l'application, qui est responsable de la configuration de l'interface graphique Swing.
     * Il vérifie la propriété système pour décider d'utiliser les nombres complexes cartésiens ou polaires.
     *
     * @param args Arguments de la ligne de commande. Cette application n'accepte pas d'arguments spécifiques,
     *             mais utilise la propriété système "complexImplementation" pour décider de l'implémentation des nombres complexes.
     * @throws Exception Si un problème survient lors de la configuration de l'interface graphique ou de l'instanciation des nombres complexes.
     */
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Récupère le type d'implémentation à partir de la propriété système
                String implementation = System.getProperty("complexImplementation");

                // Si l'implémentation n'est pas fournie ou est "cartesian" ou "polar"
                if (implementation == null || "cartesian".equals(implementation) || "polar".equals(implementation)) {

                    // Défaut sur le nombre complexe cartésien
                    String title = "Cartesian Complex Number";
                    factory = new CartesianComplexNumberFactory();

                    // Si la propriété système spécifie "polar", on passe à l'implémentation polaire
                    if ("polar".equals(implementation)) {
                        title = "Polar Complex Number";
                        factory = new PolarComplexNumberFactory();
                    }

                    // Crée et affiche la fenêtre avec le factory de nombres complexes sélectionné
                    ComplexNumberFrame frame = new ComplexNumberFrame(
                        title, 
                        new EditableComplexNumber(factory.createComplexNumber())
                    );

                    // Affiche la fenêtre
                    if (frame != null) {
                        frame.pack();
                        frame.setVisible(true);
                    }

                } else {
                    // Affiche un message si l'implémentation n'est pas valide
                    System.out.println("Use: java [-DcomplexImplementation={implementation}] App\n" +
                                       "{implementation} can be cartesian or polar");
                }
            }
        });
    }
}
