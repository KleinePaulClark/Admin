import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowDocs {
    /**
     * Opens the folder for the given applicationId in backend/uploads/[application_id].
     * @param parent The parent frame (for dialog positioning).
     * @param applicationId The application ID.
     */
    public static void openDocumentsFolder(JFrame parent, String applicationId) {
        // Get the absolute path to the backend/uploads/[application_id] folder
        File folder = new File("..", "backend/uploads/" + applicationId).getAbsoluteFile();
        if (Desktop.isDesktopSupported() && folder.exists()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(folder);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parent, "Unable to open folder:\n" + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(parent, "Document folder not found:\n" + folder.getAbsolutePath());
        }
    }
}