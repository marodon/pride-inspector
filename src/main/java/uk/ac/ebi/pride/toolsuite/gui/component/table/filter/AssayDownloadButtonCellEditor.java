package uk.ac.ebi.pride.toolsuite.gui.component.table.filter;

import uk.ac.ebi.pride.toolsuite.gui.PrideInspector;
import uk.ac.ebi.pride.toolsuite.gui.component.dialog.AssayFileDownloadDialog;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rui Wang
 * @version $Id$
 *
 */
public class AssayDownloadButtonCellEditor extends ButtonCellEditor {
    private Object value;

    public AssayDownloadButtonCellEditor(String text, Icon icon) {
        super(text, icon);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.value = value;
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JFrame mainComponent = PrideInspector.getInstance().getMainComponent();
            AssayFileDownloadDialog dialog = new AssayFileDownloadDialog(mainComponent, (String) value);
            dialog.setLocationRelativeTo(mainComponent);
            dialog.setVisible(true);
        }

        return super.getCellEditorValue();
    }
}
