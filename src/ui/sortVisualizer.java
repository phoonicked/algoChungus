package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class sortVisualizer extends JPanel {
    private int[] array;
    private int currentStep = 0;
    private List<int[]> steps;
    private boolean remainingChanges = false;

    public sortVisualizer(int[] array, int width, int height) {
        this.array = array;
        setPreferredSize(new Dimension(width, height));
    }

    public void setSteps(List<int[]> steps){
        this.steps = steps;
        currentStep = 0;
        remainingChanges = true;
        if(steps != null && !steps.isEmpty()){
            array = steps.get(currentStep);
        }
        repaint();
    }

    public void nextStep(){
        if(steps != null && currentStep < steps.size() - 1){
            currentStep++;
            array = steps.get(currentStep);
            if (currentStep == steps.size() - 1) {
                remainingChanges = false;
            }
            repaint();
        }
    }

    public void previousStep(){
        if(steps != null && currentStep > 0){
            currentStep--;
            array = steps.get(currentStep);
            repaint();
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
            if(!remainingChanges){
                g.setColor(Color.GREEN);
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
