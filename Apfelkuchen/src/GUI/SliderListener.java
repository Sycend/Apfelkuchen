package GUI;
/**
 * @author Yury Kalinin
 * Listener for the slider 
 * Changing the value of evaluation 
 *
 */
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
	private  int sliderValue;

	@Override
	public void stateChanged(ChangeEvent e) {

		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			sliderValue = (int) source.getValue();

		}

	}

	public  int getSliderValue() {
		return sliderValue;
	}
}