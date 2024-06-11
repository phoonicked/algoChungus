package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class sortVisualizer extends JPanel {
    private int[] array;
    private int currentStep = 0;
    private List<int[]> steps;
    private List<int[]> compareIndices;
    private List<boolean[]> sortedStates;
    private int compareCurrentIndex = -1;
    private int compareNextIndex = -1;
    private boolean[] sortedElements;

    public sortVisualizer(int[] array, int width, int height) {
        this.array = array;
        setPreferredSize(new Dimension(width, height));
        sortedElements = new boolean[array.length];
    }

    public void setSteps(List<int[]> steps, List<int[]> compareIndices, List<boolean[]> sortedStates) {
        this.compareIndices = compareIndices;
        this.steps = steps;
        this.sortedStates = sortedStates;
        currentStep = 0;
        compareCurrentIndex = -1;
        compareNextIndex = -1;
        sortedElements = new boolean[array.length];
        if(steps != null && !steps.isEmpty()){
            array = steps.get(currentStep);
            sortedElements = sortedStates.get(currentStep);
        }
        repaint();
    }

    public void nextStep(){
        if(steps != null && currentStep < steps.size() - 1){
            currentStep++;
            array = steps.get(currentStep);
            int[] indices = compareIndices.get(currentStep);
            compareCurrentIndex = indices[0];
            compareNextIndex = indices[1];
            sortedElements = sortedStates.get(currentStep);
            repaint();
            System.out.println("Next Step: " + currentStep); // Debug
        }
    }

    public void previousStep(){
        if(steps != null && currentStep > 0){
            currentStep--;
            array = steps.get(currentStep);
            int[] indices = compareIndices.get(currentStep);
            compareCurrentIndex = indices[0];
            compareNextIndex = indices[1];
            sortedElements = sortedStates.get(currentStep);
            repaint();
            System.out.println("Previous Step: " + currentStep); // Debug
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRectangles(g);
    }

    private void drawRectangles(Graphics g) {
        int rectWidth = getWidth() / array.length;
        int maxValue = getMaxValue(array);
        for (int i = 0; i < array.length; i++) {
            int rectX = i * rectWidth;
            int rectHeight = (int)((double) array[i] / maxValue * getHeight());
            int rectY = getHeight() - rectHeight;
            if(sortedElements[i]){
                g.setColor(Color.GREEN);
            } else if(i == compareCurrentIndex || i == compareNextIndex) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.CYAN);
            }
            g.fillRect(rectX, rectY, rectWidth, rectHeight);
            g.setColor(Color.BLACK);
            g.drawRect(rectX, rectY, rectWidth, rectHeight);
        }
    }

    private int getMaxValue(int[] array){
        int maxValue = Integer.MIN_VALUE;
        for(int value: array){
            if(value > maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }
}
