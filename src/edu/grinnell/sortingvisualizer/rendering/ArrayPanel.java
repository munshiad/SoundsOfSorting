package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (notes == null) {
            return;
        }
        int maxNote = notes.getNotes().length - 1;
        int rectWidth = this.getWidth() / (maxNote + 1);
//        System.out.println(maxNote);
        for (int i = 0; i <= maxNote; i++) {
//            System.out.println()
            Integer note = notes.getNotes()[i];
//            System.out.println(Arrays.toString(notes.getNotes()));
            if (notes.isHighlighted(i)) {
                g.setColor(Color.RED);
            } else {
                Color color = new Color(0f, 1f - (float) note / maxNote, 0f + (float) note / maxNote);
                g.setColor(color);
            }
            g.fillRect(i * rectWidth, (maxNote - note) * this.getHeight() / maxNote, rectWidth, note * this.getHeight() / maxNote);
        }
    }
}